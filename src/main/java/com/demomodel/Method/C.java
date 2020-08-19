package com.demomodel.Method;

import java.lang.reflect.ParameterizedType;

public class C extends B<Integer>{

	public C(Class clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
	C testClassLoad=new C(C.class);
	C.BaseDaoImpl();
}
	
//待测试  这种方案需要使用到有参,因为只要子类对象一床架,父类空参构造就会被调用 ,
public static  void BaseDaoImpl(){
	Class clazz;
    //子类的构造方法会默认调用父类空参  super(), 所以this代表子类对象
    Class childClazz =   C.class ;//this.getClass(); //子类字节码对象
  System.err.println("获取本类"+childClazz);
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
    System.err.println(clazz);   //获取  泛型的参数  的 类型        
}
}
