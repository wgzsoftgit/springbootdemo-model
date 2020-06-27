package com.demomodel.filter.midengFile.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.demomodel.filter.midengFile.Idempotent;
import com.demomodel.filter.midengFile.springContextUtil.SpringContextUtil;
import com.demomodel.utils.httpHelp.HttpHelper;
import com.demomodel.utils.httpHelp.RequestReaderHttpServletRequestWrapper;
import com.demomodel.utils.redis.JedisPool.conf.RedisUtil;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class IdempotentFilter extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(IdempotentFilter.class);
	private static final String IDEMPOTENT = "idempotent.info";
	private static final String NAMESPACE = "idempotent";
	private static final String NAMESPACE_LOCK = "idempotent.lock";
//	@Autowired  //	@Qualifier("jedisCluster2")
//	JedisCluster  jedisCluster;  
	// 原因：因为Filter和Listener加载顺序优先于spring容器初始化实例，所以使用@Autowired肯定为null了~~
	// 解决：用ApplicationContext根据bean名称（注意名称为实现类而不是接口）去获取bean，随便写个工具类即可

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 if (!(handler instanceof HandlerMethod)) {
	            return true;
	        }
		 
		logger.info("com.demomodel.filter.midengFile.config.IdempotentFilterrequest请求地址path[{}] uri[{}]", request.getServletPath(), request.getRequestURI());
//--------------------------
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

//--------------------------
		// 获得方法中参数的注解 根据获取到的参数注解和参数列表获得加锁的参数
		Annotation[][] annotations = method.getParameterAnnotations();
		// 根据获取到的参数注解和参数列表获得加锁的参数
		Object[] args = null;
	// Object lockedObject = getLockedObject(annotations, args);

		Idempotent ra = method.getAnnotation(Idempotent.class);// && 注解的类
		if (Objects.nonNull(ra)) {
			logger.debug("Start doIdempotent");
			int liveTime = getIdempotentLockExpiredTime(ra); // &&获取超时时间
			String key = generateKey(request, ra);
			logger.debug("Finish generateKey:[{}]", key);
//			jedisCluster.set("test", "my forst jedis");
//	        String str = jedisCluster.get("test");
//	        System.out.println(str);
////	        //关闭连接池
//	        jedisCluster.close();
			// JedisCluster jedisCluster = getJedisCluster();
			RedisUtil jedisCluster = getJedisCluster();
			if (jedisCluster.get(key, 0) == null) {
				jedisCluster.setex(key, liveTime, "true");
				System.err.println("存入redis的key" + key);
				request.setAttribute(IDEMPOTENT, key);
			} else {
				logger.debug("the key exist : {}, will be expired after {} mils if not be cleared", key, liveTime);
				System.err.println("redis已经存在");
				return false;
			}

			// 上分布式锁 避免相同的请求同时进入调用jedisCluster.get(key) 都为null的情况
//			new SimpleLock(NAMESPACE_LOCK + key,jedisCluster).wrap(new Runnable() {
//				@Override
//				public void run() {
//					//判断key是否存在，如存在抛出重复提交异常，如果不存在 则新增
//					if (jedisCluster.get(key,0) == null){
//						System.err.println("存入rediscom.demomodel.filter.midengFile.config.IdempotentFilter");
//						jedisCluster.setex(key,liveTime,"true");
//						request.setAttribute(IDEMPOTENT, key);
//					}else {
//						logger.debug("the key exist : {}, will be expired after {} mils if not be cleared", key, liveTime);
//						// throw new FastRuntimeException(20001,"请勿重复提交");
//						//return false;
//					}
//				}
//			});
		}
		return true;
	}

	private int getIdempotentLockExpiredTime(Idempotent ra) {
		return ra.expiredTime();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		try {
			// 业务处理完成 删除redis中的key
			afterIdempotent(request);
		} catch (Exception e) {
			// ignore it when exception
			e.printStackTrace();
			System.err.println("请求后异常com.demomodel.filter.midengFile.config.IdempotentFilter" + e);
			logger.error("Error after @Idempotent", e);
		}
	}

	/**
	 * 业务处理完成 删除redis中的key
	 * 
	 * @param request
	 * @throws IOException
	 */
	private void afterIdempotent(HttpServletRequest request) throws IOException {
		Object obj = request.getAttribute(IDEMPOTENT);
		if (obj != null) {
			logger.debug("Start afterIdempotent");
			String key = obj.toString();
			// JedisCluster jedisCluster = getJedisCluster();
			RedisUtil jedisCluster = getJedisCluster();
			if (StringUtils.isNotBlank(key) && jedisCluster.del(key) == 0) {
				logger.debug("afterIdempotent error Prepared to delete the key:[{}] ", key);
			}

			logger.debug("End afterIdempotent");
		}
	}

	/**
	 * 生成key generate key
	 *
	 * @param request
	 * @param ra
	 * @return
	 */
	public String generateKey(HttpServletRequest request, Idempotent ra) {
		String requestURI = request.getRequestURI(); /// IdempotentTest/IdempotentIndex
		String requestMethod = request.getMethod();// GET
		StringBuilder result = new StringBuilder(NAMESPACE);
		String token = request.getHeader("H-User-Token"); // null
		append(result, requestURI);
		append(result, requestMethod);
		append(result, token);
		appendBodyData(request, result, ra); // &&
		logger.debug("The raw data to be generated key: {}", result.toString());
		return DigestUtils.sha1Hex(result.toString());
	}

	private void appendBodyData(HttpServletRequest request, StringBuilder src, Idempotent ra) {
		if (Objects.nonNull(ra)) {
			boolean shouldHashBody = (boolean) ra.body(); // 获取 body中的 是否为true/false
			logger.debug("Found attr for body in @Idempotent, the value is {}", shouldHashBody);
			if (shouldHashBody) // 为true才继续执行
			{
				String data = null;
				try {
					//// && 防止流丢失 RequestReaderHttpServletRequestWrapper
					data = HttpHelper.getBodyString(new RequestReaderHttpServletRequestWrapper(request));
				} catch (IOException e) {
					logger.warn("Found attr for body in @Idempotent, but the body is blank");
					return;
				}
				if (StringUtils.isBlank(data)) {
					logger.warn("Found attr for body in @Idempotent, but the body is blank");
					return;
				}
				String[] bodyVals = ra.bodyVals(); // 获取bodyVals String[] 中的数据
				// bodyVals优先
				if (Objects.nonNull(bodyVals) && bodyVals.length != 0) {
					logger.debug("Found attr for bodyVals in @Idempotent, the value is {}", Arrays.asList(bodyVals));

					final String finalData = data;
					Arrays.asList(bodyVals).stream().sorted().forEach(e -> {
						String val = getEscapedVal(finalData, e); // &&
						append(src, val); // &&
					});
				} else {
					append(src, data);
				}
			}
		}
	}

	/**
	 * 
	 * @param json String
	 * @param path String
	 * @return String
	 */
	private String getEscapedVal(String json, String path) {
		String[] paths = path.split(":");
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		String nodeVal = json;
		for (String fieldName : paths) {
			if (isInteger(fieldName)) {
				try {
					jsonArray = JSONObject.parseArray(nodeVal);
					nodeVal = jsonArray.get(Integer.parseInt(fieldName)).toString();
				} catch (JSONException e) {// 如果无法转为jsonArray 则说明不是数组尝试转为jsonObject去取值
					logger.warn("getEscapedVal JSONObject.parseArray error nodeVal:[{}] fieldName:[{}]", nodeVal,
							nodeVal);
					jsonObject = JSONObject.parseObject(nodeVal);
					nodeVal = jsonObject.get(fieldName).toString();
				}
			} else {
				jsonObject = JSONObject.parseObject(nodeVal);
				nodeVal = jsonObject.get(fieldName).toString();
			}

		}
		return nodeVal;
	}

	/**
	 * 正则表达式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * StringBuilder 中添加 字符串
	 * 
	 * @param src StringBuilder
	 * @param str String
	 */
	private void append(StringBuilder src, String str) {
		if (!StringUtils.isBlank(str)) {
			src.append("#").append(str);
		}
	}

	/**
	 * 手动注入
	 * 
	 * @return
	 */
	public RedisUtil getJedisCluster() {
		return SpringContextUtil.getBean(RedisUtil.class);
	}

	private Object getLockedObject(Annotation[][] annotations, Object[] args) throws Exception {
//		if(null==args||args.length==0){
//			throw new Exception("方法参数为空，没有被锁定的对象");
//			}
//
//			if(null==annotations||annotations.length==0){
//			throw new Exception("没有被注解的参数");
//			}
			//不支持多个参数加锁，只支持第一个注解为lockedObject或者lockedComplexObject的参数
			int index=-1;//标记参数的位置指针
			for(int i=0;i<annotations.length;i++){
			    for(int j=0;j<annotations[i].length;j++){
			    	System.err.println(annotations[i][j]);
//				if(annotations[i][j] instanceof LockedComplexObject){//注解为LockedComplexObject
//				index=i;
//				try{
//				return args[i].getClass().getField(((LockedComplexObject)annotations[i][j]).field());
//				}catch(NoSuchFieldException|SecurityExceptione){
//				throw new Exception("注解对象中没有该属性");//+((LockedComplexObject)annotations[i][j]).field()
//				}
//				}
	
//				if(annotations[i][j] instanceof LockedObject){
//				index=i;
//				break;
//				}
			}
			//找到第一个后直接break，不支持多参数加锁
//			if(index!=-1){
//			break;
//			}
			}
//
//			if(index==-1){
//			     throw new  Exception("请指定被锁定参数");         //CacheLockException("请指定被锁定参数");
//			}

			return args[index];
			}

	// https://www.jianshu.com/p/d0174f311c3e

}

//https://blog.csdn.net/zhibo_lv/java/article/details/81905300