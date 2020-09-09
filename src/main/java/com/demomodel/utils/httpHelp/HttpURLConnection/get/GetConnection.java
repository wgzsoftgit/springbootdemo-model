package com.demomodel.utils.httpHelp.HttpURLConnection.get;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.demomodel.utils.StringUtils.inputToString.InputStringTo;


public class GetConnection {

	public static void main(String[] args) {
		try {
            String url = "https://www.baidu.com/";
            URL url2 = new URL(url);
          //  此处的urlConnection对象实际上是根据URL的 
            // 请求协议(此处是http)生成的URLConnection类 
            // 的子类HttpURLConnection,故此处最好将其转化 
            // 为HttpURLConnection类型的对象,以便用到 
            // HttpURLConnection更多的API.如下: 
            //得到connection对象。
            HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //连接  至此的配置必须要在connect之前完成，
//            实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。 
//            无论是post还是get，http请求实际上直到HttpURLConnection的getInputStream()这个函数里面才正式发送出去。 
            connection.connect();
            //得到响应码
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
            	// 调用HttpURLConnection连接对象的getInputStream()函数, 
            	// 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            	//得到响应流     从这个流对象中只能读取一次数据，第二次读取时将会得到空数据。
                InputStream inputStream = connection.getInputStream(); // <===注意，实际发送请求的代码段就在这里 
                //将响应流转换成字符串
                String result = InputStringTo.InputToString7(inputStream);//将流转换为字符串。
                System.err.print("kwwl---result============="+result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
