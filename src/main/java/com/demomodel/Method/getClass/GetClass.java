package com.demomodel.Method.getClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map.Entry;

import com.demomodel.Method.A;

public class GetClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//方式一
		//调用Object类的getClass()方法来得到Class对象，这也是最常见的产生Class对象的方法。例如：
	   // A x = null;
	   // Class c1 = x.getClass();
	   // 2、使用Class类的中静态forName()方法获得与字符串对应的Class对象。例如： 
	    Class c2=Class.forName("com.demomodel.Method.A");
	   //获取Class类型对象的第三个方法非
	    Class cl1 = A.class;
	    Class cl2 = int.class;
	    Class cl3 = Double[].class;
	   // 注意：Class对象实际上描述的只是类型，而这类型未必是类或者接口。
	    //例如上面的int.class是一个Class类型的对象。由于历史原因，数组类型的getName方法会返回奇怪的名字。
	    
	  //方案一
	  		Class<?> clz = Class.forName("com.demomodel.Method.A");//全类名获取class
	  		Object o = clz.newInstance();  //new 一个对象
	  		Method method = clz.getMethod("foo", String.class);//获取方法 和传参类型
	  		if(!method.isAccessible()){ //判断是不是公共方法  //获取一个方法对象，然后根据isAccessible 返回值确定是否能够执行，如果返回值为false则需要调用setAccessiblea（true),最后再调 用invoke执行方法
	  			method.setAccessible(true);
	  	//参考com.demomodel.mybatis.ThreadPoolUtilMybatis.util.ThreadPoolUtil的使用
	  	}
	  		Parameter[] p =  method.getParameters();
			for (int j = 0; j < (p==null?0:p.length); j++) { //  将参数全部取出来
				System.err.println(p[j].getName());////1.8提供的新方法可以取出参数名  
			}
	  		for (int i = 0; i < 16; i++) {
	  			method.invoke(o, Integer.toString(i));
	  		}
	  	
	  	    
	  		
	  		
	  //方案二反射		
//	  		Method m = A.class.getMethod("foo", String.class);
//	  		Object o = A.class.newInstance();
//	  		m.invoke(o, "张三"); //调用A类的方法foo

	    
	}
}
