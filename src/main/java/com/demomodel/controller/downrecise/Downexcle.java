package com.demomodel.controller.downrecise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//测试  不通过
@RestController
@RequestMapping("Downexcle")
public class Downexcle {
//下载excel模板表格
	@GetMapping(value = "/downtemplate")
	@ResponseBody
	public  void downTemplate(HttpServletResponse response) {
	    InputStream inputStream=null;
	    try {
//	        RestResult restResult=new RestResult();
//	        restResult.setSuccess(false);
	        response.reset();
	        response.setContentType("bin");
	        response.setHeader("Content-Disposition", "attachment;filename=" + new String("销售项目评审表项目2019XXXX.xlsx".getBytes(), "ISO-8859-1"));

	       ServletOutputStream outputStream = response.getOutputStream();

	        inputStream= new FileInputStream(new File(ResourceUtils.getURL("classpath:").getPath()+"static/model/xs_table.xlsx"));
	        byte [] buff=new byte[1024];
	        int length=0;
	        while((length=inputStream.read(buff))!=-1){
	            outputStream.write(buff, 0, length);
	        }
	        if(outputStream!=null){
	            outputStream.flush();
	            outputStream.close();
	        }
	    }catch (Exception e){
	        e.printStackTrace();
	    }finally {
	        if(inputStream!=null){

	            try {
	                inputStream.close();
	            } catch (IOException e) {
	              System.out.println("关闭资源出错"+e.getMessage());
	                e.printStackTrace();
	            }
	        }

	    }
	}
	//https://blog.csdn.net/drsbbbl/java/article/details/93598109
	@RequestMapping("downloadExcel")
	public void downloadExcel(HttpServletResponse response,HttpServletRequest request) {
        try {
            //获取文件的路径
            String excelPath = request.getSession().getServletContext().getRealPath("/Excel/"+"sxstuds.xls");
            String fileName = "sxstuds.xls".toString(); // 文件的默认保存名
            // 读到流中
            InputStream inStream = new FileInputStream(excelPath);//文件的存放路径
            // 设置输出的格式
            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode("sxstuds.xls", "UTF-8"));
            // 循环取出流中的数据
            byte[] b = new byte[200];
            int len;
 
            while ((len = inStream.read(b)) > 0){
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//https://blog.csdn.net/weixin_42394615/java/article/details/82794296
}
