package com.demomodel.mybatis.ThreadPoolUtilMybatis.text;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.bean.User;
import com.demomodel.mybatis.ThreadPoolUtilMybatis.util.ThreadEntity;
import com.demomodel.mybatis.ThreadPoolUtilMybatis.util.ThreadPoolUtil;
//项目名称：QueryDAO    
// 类名称：ThreadDemo    
// 类描述：一个多线程连接的sql查询demo
@RestController
public class ThreadDemo extends ThreadPoolUtil{
	ConcurrentLinkedQueue<User> cqli = new ConcurrentLinkedQueue<User>();//线程安全的list集合
	
	List<User> usLi = new ArrayList<User>();//装载list返回值集合
	
	/**
	 * setCondition(设置传入的参数)     
	 * TODO()     
	 * @param name
	 * @param clazz
	 * @param map
	 * void
	 */
		public void setCondition(String name,Class<?> clazz,Map<String,Object> map) {
			usLi = new ArrayList<User>();
			ThreadEntity tey = new ThreadEntity();
			tey.setMethodName(name);
			tey.setClazz(clazz);
			tey.setCondition(map);
			getLi().add(tey);    //&&getLi  关键点控制线程数量    调用父类返回list
		}
	
	//必须实现
	@Override
	public void meta(Object oc, Object[] objects) {
		
		try {
			User u = (User)getRefle().invoke(oc, objects);   //反射执行方法
			cqli.add(u);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
 
	@Override
	public void found() {
		usLi.addAll(cqli);
	}
	
	public List<User> getUsLi() {
		return usLi;
	}
	public void setUsLi(List<User> usLi) {
		this.usLi = usLi;
	}
	//需要执行的逻辑   ----查询数据库
	public User findUserByUserid(String tableName,Integer userId) {
		User user= new User();
		user.setI(1);
		user.setJ(userId);
		user.setId(22L);
		user.setName(tableName);
		return user;
	}
	@RequestMapping("/threadDemotext")
	public  String  main() throws ClassNotFoundException {
		ThreadDemo t = new ThreadDemo();
		//t.setWide(new WideCls<User>());
		System.err.println("测试多线程");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", "user_emp");
		map.put("userId",2);
      //&&   传入方法名     Class类     map参数
	t.setCondition("findUserByUserid", Class.forName("com.demomodel.mybatis.ThreadPoolUtilMybatis.text.ThreadDemo"), map);
		//t.setCondition("findUserByName",  Class.forName("com.demomodel.mybatis.ThreadPoolUtilMybatis.text.ThreadDemo"), map);
		t.getStart();   //调用父类方法开启线程
		List<User> li =  t.getUsLi();//&& 获得结果值
		for (User user : li) {
			System.out.println("com.demomodel.bean.User"+user);  
		}
		return "ok";
	}
	
	
	
}
//：https://blog.csdn.net/qq_36090711/java/article/details/79165577