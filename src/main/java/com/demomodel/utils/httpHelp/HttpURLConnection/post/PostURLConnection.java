package com.demomodel.utils.httpHelp.HttpURLConnection.post;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.demomodel.utils.StringUtils.inputToString.InputStringTo;

public class PostURLConnection {
	public static void main(String[] args) throws IOException {
// URLConnection的对象问题: 		
		// 下面的index.jsp由<servlet-mapping>映射到 
		// 一个Servlet(com.quantanetwork.getClientDataServlet) 
		// 该Servlet的注意点下边会提到 

		URL url = new URL("https://www.baidu.com/"); 
		URLConnection rulConnection = url.openConnection();// 此处的urlConnection对象实际上是根据URL的 
		          // 请求协议(此处是http)生成的URLConnection类 
		          // 的子类HttpURLConnection,故此处最好将其转化 
		          // 为HttpURLConnection类型的对象,以便用到 
		          // HttpURLConnection更多的API.如下: 
		HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection; 
				
		
// HttpURLConnection对象参数问题 

		// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在 
		// http正文内，因此需要设为true, 默认情况下是false; 
		httpUrlConnection.setDoOutput(true);  //允许写出
		// 设置是否从httpUrlConnection读入，默认情况下是true; 
		httpUrlConnection.setDoInput(true); //允许读入
		// Post 请求不能使用缓存 
		httpUrlConnection.setUseCaches(false); //不使用缓存
		// 设定传送的内容类型是可序列化的java对象 
		// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException) 
		httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object"); 
		// 设定请求的方法为"POST"，默认是GET 
		httpUrlConnection.setRequestMethod("POST"); 
		// 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成， 
		        httpUrlConnection.connect(); 
		
		
		        
//HttpURLConnection连接问题： 


		     // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法， 
		     // 所以在开发中不调用上述的connect()也可以)。    正文的内容
		     OutputStream outStrm = httpUrlConnection.getOutputStream(); 	        
		        
//HttpURLConnection写数据与发送数据问题： 

		  // 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。 
		  ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm); 

		  // 向对象输出流写出数据，这些数据将存到内存缓冲区中 
		  objOutputStrm.writeObject(new String("我是测试数据")); 

		  // 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream） 
		  objOutputStrm.flush(); 

		  // 关闭流对象。此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中, 
		  // 在调用下边的getInputStream()函数时才把准备好的http请求正式发送到服务器 
		  objOutputStrm.close(); 

		  // 调用HttpURLConnection连接对象的getInputStream()函数, 
		  // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。  从这个流对象中只能读取一次数据，第二次读取时将会得到空数据。
		  InputStream inputStream = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里 
	      //将响应流转换成字符串
          String result = InputStringTo.InputToString7(inputStream);//将流转换为字符串。
          System.err.print("kwwl---result============="+result);
		  // 上边的httpConn.getInputStream()方法已调用,本次HTTP请求已结束,下边向对象输出流的输出已无意义， 
		  // 既使对象输出流没有调用close()方法，下边的操作也不会向对象输出流写入任何数据. 
		  // 因此，要重新发送数据时需要重新创建连接、重新设参数、重新创建流对象、重新写数据、 
		  // 重新发送数据(至于是否不用重新这些操作需要再研究) 
		  objOutputStrm.writeObject(new String("")); 
		  httpUrlConnection.getInputStream(); 
		     
		
	}
}
