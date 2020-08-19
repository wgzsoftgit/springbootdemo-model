package com.demomodel.Method.getClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Test {
	static String abspath;
	   static public String getPath()
	   {

	       File file=new File(""); 
	       abspath=file.getAbsolutePath();  //可以找到src   同级目录config
	       return abspath;
	   }
        public static void main(String[] args) throws URISyntaxException, IOException {
 
        	// 方法1：通过this.getClass().getResoure("")获取, 有"/"开头表示以bin目录为根目录, 没"/"开头表示以当前文件夹为根目录   
       // 	System.err.println(this.getClass().getResource("/").getFile());
        	          
        	// 方法2：通过this.getClass().getClassLoader().getResource(""), 不允许以"/"开头, 默认以bin目录为根, 类似方法1中以"/"开头的情况  
        //	System.err.println(Test.getClass().getClassLoader().getResource("").getFile());  
        	          
        	// 方法3：通过ClassLoader.getSystemResource("")获取, 不允许以"/开头", 默认以bin目录为根, 同上  
        	System.err.println(ClassLoader.getSystemResource("").getFile());  
        	          
        	// 方法4：通过Thread.currentThread().getContextClassLoader().getResource("")获取, 同上【推荐】  
        	System.err.println(Thread.currentThread().getContextClassLoader().getResource("").getFile());  
        	          
        	// 方法5：通过new File("bin").getCanonicalPath()获取, 有"/"开头, 则以系统盘为根, 没"/"开头, 表示以bin目录为根   
        	System.err.println(new File("bin").getCanonicalPath());   
        	          
        	// 方法6：通过System.getProperty("user.dir") + File.separator + "bin"来获取(不推荐)  
        	//System.getProperty("user.dir") + File.separator + "bin"; 
        	
        	System.out.println(getPath()+File.separator);
        	
                System.out.println("java.home : "+System.getProperty("java.home"));
 
                System.out.println("java.class.version : "+System.getProperty("java.class.version"));
 
                System.out.println("java.class.path : "+System.getProperty("java.class.path"));
 
                System.out.println("java.library.path : "+System.getProperty("java.library.path"));
 
                System.out.println("java.io.tmpdir : "+System.getProperty("java.io.tmpdir"));
 
                System.out.println("java.compiler : "+System.getProperty("java.compiler"));
 
                System.out.println("java.ext.dirs : "+System.getProperty("java.ext.dirs"));
 
                System.out.println("user.name : "+System.getProperty("user.name"));
 
                System.out.println("user.home : "+System.getProperty("user.home"));
 
                System.out.println("当前工程路径user.dir : "+System.getProperty("user.dir")+File.separator);
 
            //    System.getProperty("user.dir"); 有坑  https://blog.csdn.net/jdycsdn/article/details/105648235
                //win  D:\workspace-eclipse\tspringbootdemo\  不一致 linux /usr/local/apache/bin
                System.out.println("===================");
 
                System.out.println("package: "+Test.class.getPackage().getName());
 
                System.out.println("package: "+Test.class.getPackage().toString());
 
                System.out.println("=========================");
 
                String packName = Test.class.getPackage().getName();
          System.err.println(packName);
                URL packurl = new URL(packName);
             System.out.println(packurl.getPath());
 
//                URI packuri = new URI(packName);
//                System.out.println(packuri.getPath());
//               System.out.println(packuri.toURL().getPath());
 
                System.out.println(packName.replaceAll("//.", "/"));
 
                System.out.println(System.getProperty("user.dir")+"/"+(Test.class.getPackage().getName()).replaceAll("//.", "/")+"/");
 
        }
 
} 
