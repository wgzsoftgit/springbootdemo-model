package com.demomodel.utils.Excel.fileUpText;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.demomodel.utils.demo.imgpngcheck.CheckPnoto;

import io.swagger.annotations.ResponseHeader;

@Controller
@RequestMapping("FileUpController2")
public class FileUpController {

	  @RequestMapping("/webhtml")
	    public String jspindex2() {
	    	//https://github.com/simonsfan/springboot-quartz-demo
	        return "file/FileUpdate";
	    }
	  @RequestMapping("/webhtml3")
	    public String jspindex3() {
	    	//https://github.com/simonsfan/springboot-quartz-demo
	        return "file/PhotoUpdate";
	    }
	
	//设置上传文件的大小
	@Bean 
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //允许上传的文件最大值
        factory.setMaxFileSize("50MB"); //KB,MB  
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize("50MB");  
        return factory.createMultipartConfig();  
    }
	 
	   /**
	     * 用于接收前端上传文件
	     * @param request
	     * @param file
	     */
	    @RequestMapping(value = "/upload", method = RequestMethod.POST)
	    public void dome1(HttpServletRequest request, MultipartFile file) throws Exception{
	    	if (null == file) {
	          //  return response("上传失败，无法找到文件！");
	        }
	        // BMP、JPG、JPEG、PNG、GIF
	        String fileName = file.getOriginalFilename().toLowerCase();
	        if (!fileName.endsWith(".bmp") && !fileName.endsWith(".jpg")
	                && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")
	                && !fileName.endsWith(".gif")) {
	         //   return response("上传失败，请选择BMP、JPG、JPEG、PNG、GIF文件！");
	        }
	    	
	    	
	    	//file对象名记得和前端name属性值一致
	        System.out.println(file.getOriginalFilename());
	        File image = new File(file.getOriginalFilename());
	        System.err.println("com.demomodel.utils.Excel.fileUpText.FileUpController "+CheckPnoto.isImage(image));
	       
	        
	        InputStream inputStream = file.getInputStream();
            byte[] byt = new byte[inputStream.available()];
            inputStream.read(byt);
            CloseableHttpClient httpclient = HttpClients.createDefault();

            CloseableHttpResponse response = null;

            HttpPost request2 = new HttpPost("https://api.weixin.qq.com/wxa/img_sec_check?access_token=" );
            request2.addHeader("Content-Type", "application/octet-stream");
            request2.setEntity(new ByteArrayEntity(byt, ContentType.create("image/jpg")));
            response = httpclient.execute(request2);
            HttpEntity httpEntity = response.getEntity();
            String result = EntityUtils.toString(httpEntity, "UTF-8");// 转成string
            JSONObject jso = JSONObject.parseObject(result);
            System.out.println(jso + "-------------验证效果");

            Object errcode = jso.get("errcode");
            int errCode = (int) errcode;
            if (errCode == 0) {
              //  return true;
            } else if (errCode == 87014) {
                System.out.println("图片内容违规-----------");
              //  return false;
            }

          //  return true;
	    }
	    
	    
	    //单文件
	    @RequestMapping(value="/singleSave", method=RequestMethod.POST )
	    public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc ){
	    	System.out.println("File Description:"+desc);
	    	String fileName = null;
	    	if (!file.isEmpty()) {
	            try {
	                fileName = file.getOriginalFilename();
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream buffStream = 
	                        new BufferedOutputStream(new FileOutputStream(new File("F:/cp/" + fileName)));
	                buffStream.write(bytes);
	                buffStream.close();
	                return "You have successfully uploaded " + fileName;
	            } catch (Exception e) {
	                return "You failed to upload " + fileName + ": " + e.getMessage();
	            }
	        } else {
	            return "Unable to upload. File is empty.";
	        }
	    }

	    //多文件
	    @RequestMapping(value="/multipleSave", method=RequestMethod.POST )
	    public @ResponseHeader String multipleSave(@RequestParam("file") MultipartFile[] files){
	    	String fileName = null;
	    	String msg = "";
	    	if (files != null && files.length >0) {
	    		for(int i =0 ;i< files.length; i++){
		            try {
		                fileName = files[i].getOriginalFilename();
		                byte[] bytes = files[i].getBytes();
		                BufferedOutputStream buffStream = 
		                        new BufferedOutputStream(new FileOutputStream(new File("F:/cp/" + fileName)));
		                buffStream.write(bytes);
		                buffStream.close();
		                msg += "You have successfully uploaded " + fileName +"<br/>";
		            } catch (Exception e) {
		                return "You failed to upload " + fileName + ": " + e.getMessage() +"<br/>";
		            }
	    		}
	    		return msg;
	        } else {
	            return "Unable to upload. File is empty.";
	        }
	    }
	    
}
