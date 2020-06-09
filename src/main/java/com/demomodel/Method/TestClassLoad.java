package com.demomodel.Method;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class TestClassLoad {
	public static void main(String[] args) throws Exception {
		String[] arg=new String[] {"1"};
	//	getClassT(arg);
		TestClassLoad testClassLoad=new TestClassLoad();
		testClassLoad.BaseDaoImpl();
	}
	//ok
	public static void  getClassT(String[] args) throws Exception
    {
        args = new String[]{"com.demomodel.Method.A","java疯狂讲义w"};
        String progClass = args[0];
        String[] progArgs = new String[args.length-1];
       // Object src : 原数组
     //   int srcPos : 从元数据的起始位置开始
     //　Object dest : 目标数组
//int destPos : 目标数组的开始起始位置
// length  : 要copy的数组的长度
        System.arraycopy(args , 1 , progArgs, 0 , progArgs.length);//数组的复制 
        for (String string : progArgs) {
			System.err.println(string);
		}
        
        Class<?> clazz = Class.forName(progClass);
        Object o = clazz.newInstance();   //new  对象
        // 获取需要运行的类的主方法
        Method main = clazz.getMethod("foo" , String.class);
        Object[] argsArray = {progArgs};
        for (Object object : argsArray) {
        	System.err.println(object);
		}
        
        main.invoke(o, "张三"); //执行方法并传入参数
        
       
    }
	//待测试  这种方案需要使用到有参,因为只要子类对象一床架,父类空参构造就会被调用 ,
    public  void BaseDaoImpl(){
    	Class clazz;
        //子类的构造方法会默认调用父类空参  super(), 所以this代表子类对象
        Class childClazz = this.getClass(); //子类字节码对象
      System.err.println(childClazz);
        //得到父类的字节码BaseDaoImpl的字节码 ， 这份字节码上带有泛型数据
        /**
         * 虽然这个方法，返回值说的是Type ，
         * 但是其实返回的是ParameterizedType的实现类类型。
         * 所以我们使用ParameterizedTypeImpl接口来接收。
         */
        ParameterizedType genericSuperclass = (ParameterizedType) childClazz.getGenericSuperclass();
        //获取这样可以得到泛型了
        //因为泛型可能不止一个,所以返回的是数组,所以我们取第一个,
        clazz = (Class) genericSuperclass.getActualTypeArguments()[0];
        System.err.println(clazz);
    }
//https://blog.csdn.net/qq_40794266/java/article/details/78666395
}