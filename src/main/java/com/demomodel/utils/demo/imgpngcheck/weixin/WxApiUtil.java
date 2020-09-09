package com.demomodel.utils.demo.imgpngcheck.weixin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WxApiUtil {
	static String APPID="";
	static String APPSecret="";
	//获取access_token
		public static Map<String, Object> getAccessToken() {
			Map<String, Object> map = null;
			StringBuffer url = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");
			url.append("&appid=");//appid设置
			url.append(APPID);
			url.append("&secret=");//secret设置
			url.append(APPSecret);
			try {
		        CloseableHttpClient client =HttpClientBuilder.create().build();//构建一个Client
		        HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
		        HttpResponse response = client.execute(get);//提交GET请求
		        HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
		        String content = EntityUtils.toString(result);   
		        JSONObject res = JSONObject.fromObject(content);//把信息封装为json
			    //把信息封装到map
			    map = parseJSON2Map(res);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return map;
		}
		//json转map
		public static Map<String, Object> parseJSON2Map(JSONObject json) {
		        Map<String, Object> map = new HashMap<String, Object>();
		        // 最外层解析
		        for (Object k : json.keySet()) {
		            Object v = json.get(k);
		            // 如果内层还是数组的话，继续解析
		            if (v instanceof JSONArray) {
		                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		                @SuppressWarnings("unchecked")
						Iterator<JSONObject> it = ((JSONArray) v).iterator();
		                while (it.hasNext()) {
		                    JSONObject json2 = it.next();
		                    list.add(parseJSON2Map(json2));
		                }
		                map.put(k.toString(), list);
		            } else {
		                map.put(k.toString(), v);
		            }
		        }
		        return map;
		}
	//校验文本内容是否有违法违规内容
	 public static Boolean checkText(String accessToken,String textConetnt) {

		        try {
		            CloseableHttpClient httpclient = HttpClients.createDefault();

		            CloseableHttpResponse response = null;
		            HttpPost request = new HttpPost("https://api.weixin.qq.com/wxa/msg_sec_check?access_token=" + accessToken);
		            request.addHeader("Content-Type", "application/json;charset=UTF-8");

		            Map<String, String> paramMap = new HashMap<String, String>();
		            paramMap.put("content", textConetnt);
		            request.setEntity(new StringEntity(com.alibaba.fastjson.JSONObject.toJSONString(paramMap), ContentType.create("application/json", "utf-8")));
		            

		            response = httpclient.execute(request);
		            HttpEntity httpEntity = response.getEntity();
		            String result = EntityUtils.toString(httpEntity, "UTF-8");// 转成string
		            com.alibaba.fastjson.JSONObject jso = com.alibaba.fastjson.JSONObject.parseObject(result);
		            System.out.println(jso);
		            Object errcode = jso.get("errcode");
		            int errCode = (int) errcode;
		            if (errCode == 0) {
		                return true;
		            } else if (errCode == 87014) {
		                System.out.println("内容违规-----------" + textConetnt);
		                return false;
		            }

		            return true;
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println("----------------调用腾讯内容过滤系统出错------------------");
		            return true;
		        }
		  }	 
	 
	 
	 
	 /**
	     * 图片过滤检测
	     * @param file 图片文件
	     * @return
	     */
	    @RequestMapping(value = "/imgcheck", method = {RequestMethod.POST})
	    @ResponseBody
	    public AccessTokenWX checkPic(@RequestParam(value = "file") MultipartFile file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	       
	        //自己写一个定时任务或其他方式 获取AccessToken
	        AccessTokenWX accessTokenWX = new AccessTokenWX();
	        try {
	                String  token = WxApiUtil.getAccessToken().get("access_token")+"";
	                String url = "https://api.weixin.qq.com/wxa/img_sec_check?access_token=" + token;
	                String result = WxApiUtil.uploadFile(url, file);
	                accessTokenWX = JSON.parseObject(result, AccessTokenWX.class);
	                System.out.println("图片检测结果 = " + result);
	                return accessTokenWX;
	        } catch (Exception e) {
	            accessTokenWX.setErrcode("500");
	            accessTokenWX.setErrmsg("system错误");
	            return accessTokenWX;
	        }
	    }

	/**
		     * 上传二进制文件      参考com.demomodel.utils.httpHelp.HttpURLConnection.get
		     * @param graphurl 接口地址
		     * @param file 图片文件
		     * @return
		     */
		 public static String uploadFile(String graphurl,MultipartFile file) {
		        String line = null;//接口返回的结果
		        try {
		            // 换行符
		            final String newLine = "\r\n";
		            final String boundaryPrefix = "--";
		            // 定义数据分隔线
		            String BOUNDARY = "========7d4a6d158c9";
		            // 服务器的域名
		            URL url = new URL(graphurl);
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		            // 设置为POST情
		            conn.setRequestMethod("POST");
		            // 发送POST请求必须设置如下两行
		            conn.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false; 
		            conn.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
		            conn.setUseCaches(false);//Post 请求不能使用缓存 
		            // 设置请求头参数
		            conn.setRequestProperty("connection", "Keep-Alive");
		            conn.setRequestProperty("Charsert", "UTF-8");
		            conn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + BOUNDARY);
		            conn.setRequestProperty("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
		            OutputStream out = new DataOutputStream(conn.getOutputStream());

		            // 上传文件
		            StringBuilder sb = new StringBuilder();
		            sb.append(boundaryPrefix);
		            sb.append(BOUNDARY);
		            sb.append(newLine);
		            // 文件参数,photo参数名可以随意修改
		            sb.append("Content-Disposition: form-data;name=\"image\";filename=\""
		                    + "https://api.weixin.qq.com" + "\"" + newLine);
		            sb.append("Content-Type:application/octet-stream");
		            // 参数头设置完以后需要两个换行，然后才是参数内容
		            sb.append(newLine);
		            sb.append(newLine);

		            // 将参数头的数据写入到输出流中
		            out.write(sb.toString().getBytes());

		            // 读取文件数据
		            out.write(file.getBytes());
		            // 最后添加换行
		            out.write(newLine.getBytes());

		            // 定义最后数据分隔线，即--加上BOUNDARY再加上--。   写入标记结束位
		            byte[] end_data = (newLine + boundaryPrefix + BOUNDARY
		                    + boundaryPrefix + newLine).getBytes();
		            // 写上结尾标识
		            out.write(end_data);
		            out.flush();
		            out.close();
		            // 定义BufferedReader输入流来读取URL的响应
		            BufferedReader reader = new BufferedReader(new InputStreamReader(
		                    conn.getInputStream()));  //getInputStream()<===注意，实际发送请求的代码段就在这里 
		            while ((line = reader.readLine()) != null) {
		                return line;
		            }
		        } catch (Exception e) {
		            System.out.println("发送POST请求出现异常！" + e);
		        }
		        return line;
		    }

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public class AccessTokenWX {
			private String access_token;
		    private Integer expires_in;
		    private String errcode;
		    private String errmsg;
			public String getAccess_token() {
				return access_token;
			}
			public void setAccess_token(String access_token) {
				this.access_token = access_token;
			}
			public Integer getExpires_in() {
				return expires_in;
			}
			public void setExpires_in(Integer expires_in) {
				this.expires_in = expires_in;
			}
			public String getErrcode() {
				return errcode;
			}
			public void setErrcode(String errcode) {
				this.errcode = errcode;
			}
			public String getErrmsg() {
				return errmsg;
			}
			public void setErrmsg(String errmsg) {
				this.errmsg = errmsg;
			} 
	}
}
//https://blog.csdn.net/weixin_43767049/article/details/103369284?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase