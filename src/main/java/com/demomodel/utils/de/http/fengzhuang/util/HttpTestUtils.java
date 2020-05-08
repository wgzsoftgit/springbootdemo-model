package com.demomodel.utils.de.http.fengzhuang.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.demomodel.utils.de.http.fengzhuang.Login;
import com.google.gson.Gson;


public class HttpTestUtils {

/**
 * 
 * @param method 请求类型
 * @param ip  ip
 * @param port 端口
 * @param action   url路径
 * @param token 
 * @param content 内容
 * @return
 */
    public static String httpRequest(HttpEnum method,String ip, int port, String action, String token, String content) {
        String responJson = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        InputStream inputStream = null;
        try {
            httpClient = HttpClients.createDefault();
            String uri="http://" + ip + ":" + port + action;
            HttpRequestBase httpReq = getRequestEntity(method, token, uri, content);//&&同下
            httpResponse = httpClient.execute(httpReq);
            inputStream = httpResponse.getEntity().getContent();
            responJson = convertToString(inputStream);//&&同下   输出流转换成字符串
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responJson;
    }
/**
 * 判断请求类型       添加请求头和请求体
 * getRequestEntity
 * @param method  类型
 * @param token   获取的token
 * @param uri  url
 * @param content  请求内容
 * @return
 * @throws UnsupportedEncodingException
 */
    private static HttpRequestBase getRequestEntity(HttpEnum method, String token, String uri, String content) throws UnsupportedEncodingException {
        switch(method.getNum()){
            case 1:
                HttpGet httpGet = new HttpGet(uri+content);
                httpGet.addHeader("Content-type", "application/json");
                httpGet.addHeader("X-Subject-Token", token);
                return httpGet;
            case 2:
                HttpPost httpPost = new HttpPost(uri);
                httpPost.addHeader("Content-type", "application/json");  //请求头
                httpPost.addHeader("X-Subject-Token", token);
                httpPost.setEntity(new StringEntity(content,"UTF-8"));  //请求体
                return httpPost;
            case 3:
                HttpPut httpPut= new HttpPut(uri);
                httpPut.addHeader("Content-type", "application/json");
                httpPut.addHeader("X-Subject-Token", token);
                httpPut.setEntity(new StringEntity(content,"UTF-8"));
                return httpPut;
            case 4:
                HttpDelete httpDelete = new HttpDelete(uri+content);
                httpDelete.addHeader("Content-type", "application/json");
                httpDelete.addHeader("X-Subject-Token", token);
                return httpDelete;
            default:
                    System.out.println("请求方法不对");
        }
        return null;
    }
/**
 * 
 * @param is InputStream输出流转换成字符串
 * @return  String
 */
    private static String convertToString(InputStream is) {
        if (is == null) {
            return null;
        }
        BufferedReader bf = null;
        try {
            StringBuilder sb = new StringBuilder();
            String temp = "";
            bf = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            while ((temp = bf.readLine()) != null) {
                sb.append(temp);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeStream(bf);
            closeStream(is);
        }
    }

    private static void closeStream(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    /**
     * 获取token
     * @param ip
     * @param port
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public static String getToken(String ip,int port,String userName,String password) throws Exception {
        String response="";
        String token="";
        response = Login.login(ip, port, userName, password);
        Map<String, Object> rsp = new Gson().fromJson(response, Map.class);
        String message= (String)rsp.get("message");
        if (message!=null&&!"".equals(message)){
            System.out.println(message);
            throw new Exception("未获取到token");
        }
        token = (String)rsp.get("token");
        if(token==null||"".equals(token)){
            System.out.println("获取到的token为空");
            throw new Exception("获取到的token为空");
        }
        return  token;
    }

}
