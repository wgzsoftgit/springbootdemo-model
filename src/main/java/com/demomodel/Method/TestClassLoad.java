package com.demomodel.Method;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class TestClassLoad {
	public static void main(String[] args) throws Exception {
		String[] arg=new String[] {"1"};
		getClassT(arg);

	}
	//ok
	public static void  getClassT(String[] args) throws Exception
    {
        args = new String[]{"com.demomodel.Method.A","java疯狂讲义w"};
        String progClass = args[0]; //com.demomodel.Method.A
        String[] progArgs = new String[args.length-1];
       // Object src : 原数组    args
     //   int srcPos : 从元数据的起始位置开始    1
     //　Object dest : 目标数组    progArgs
//int destPos : 目标数组的开始起始位置    0
// length  : 要copy的数组的长度  progArgs.length
    System.arraycopy(args , 1 , progArgs, 0 , progArgs.length);//数组的复制 
       
        
        for (String string : progArgs) {
			System.err.println("拷贝后的数组"+string);
		}
        Object[] argsArray = {progArgs};
        for (Object object : argsArray) {
        	System.err.println(object);
		}
        
        
        //反射执行 --         -----方法-----
        //传入类的方法             具体路径 com.demomodel.Method.A
        Class<?> clazz = Class.forName(progClass);
        Object o = clazz.newInstance();   //new  对象
        // 获取需要运行的类的主方法
        Method main = clazz.getMethod("foo" , String.class);
        main.invoke(o, "张三"); //执行方法并传入参数
        
       
    }
	
//https://blog.csdn.net/qq_40794266/java/article/details/78666395
}