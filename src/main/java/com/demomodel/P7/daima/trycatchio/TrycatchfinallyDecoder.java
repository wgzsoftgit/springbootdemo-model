package com.demomodel.P7.daima.trycatchio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TrycatchfinallyDecoder {
	public static void main(String[] args) {
		TrycatchfinallyDecoder trycatchfinallyDecoder=new TrycatchfinallyDecoder();
		trycatchfinallyDecoder.text6();
	}
	/** 不推荐
	 * try–catch-finally 至始至终存在一个严重的隐患：try 中的 br.readLine() 
	 * 有可能会抛出 IOException，finally 中的 br.close() 也有可能会抛出 IOException。
	 * 假如两处都不幸地抛出了 IOException，那程序的调试任务就变得复杂了起来
	 * @param args
	 */
    public static void text0(String[] args) {
        BufferedReader br = null;
        try {
            String path = TrycatchfinallyDecoder.class.getResource("/牛逼.txt").getFile();
            String decodePath = URLDecoder.decode(path,"utf-8");
            br = new BufferedReader(new FileReader(decodePath));

            String str = null;
            while ((str =br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //推荐
    public void text2() throws UnsupportedEncodingException {
    	   String path = TrycatchfinallyDecoder.class.getResource("/牛逼.txt").getFile();
           String decodePath = URLDecoder.decode(path,"utf-8");
    	try (BufferedReader br = new BufferedReader(new FileReader(decodePath));) {
    	    String str = null;
    	    while ((str =br.readLine()) != null) {
    	        System.out.println(str);
    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
    }
    //   try-with-resources   替代try–catch-finally
    public void text3() throws UnsupportedEncodingException {
    	  String path = TrycatchfinallyDecoder.class.getResource("/牛逼.txt").getFile();
          String decodePath = URLDecoder.decode(path,"utf-8");
    	try (BufferedReader br = new BufferedReader(new FileReader(decodePath));
    		     PrintWriter writer = new PrintWriter(new File("输出的.txt"))) {
    		    String str = null;
    		    while ((str =br.readLine()) != null) {
    		        writer.print(str);
    		    }
    		} catch (IOException e) {
    		    e.printStackTrace();
    		}
    }
    /**反编译可以看到
     * catch 块中主动调用了 resource.close()，并且有一段很关键的代码 var5.addSuppressed(var4)。
     * 它有什么用处呢？当一个异常被抛出的时候，可能有其他异常因为该异常而被抑制住，从而无法正常抛出。
     * 这时可以通过 addSuppressed() 方法把这些被抑制的方法记录下来。被抑制的异常会出现在抛出的异常的堆栈信息中，
     * 也可以通过 getSuppressed() 方法来获取这些异常。这样做的好处是不会丢失任何异常
     */
    //释放自定义的资源    推荐
    public  void text4() {
    	try (MyResource resource = new MyResource();) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class MyResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("关闭自定义资源");
        }
    }
    
    //推荐
    //close异常和out异常都可以抓取到     通过try-with-resources
    public void text5() {
    	  try (MyResourceOutThrow resource = new MyResourceOutThrow();) {
              resource.out();
          } catch (Exception e) {
              e.printStackTrace();
          }
    }
    //不推荐  异常不具体
    public void text6() {
    	try {
    		MyResourceOutThrow resource = new MyResourceOutThrow();
    		 resource.out();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    class MyResourceOutThrow implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw  new Exception("close()");
        }

        public void out() throws Exception{
            throw new Exception("out()");
        }
    }
}