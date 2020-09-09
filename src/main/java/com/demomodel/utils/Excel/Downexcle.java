package com.demomodel.utils.Excel;

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
//测试    ok
@RestController
@RequestMapping("Downexcle")
public class Downexcle {

	@RequestMapping("downloadExcel")
	public void downloadExcel(HttpServletResponse response,HttpServletRequest request) {
        try {
            //获取文件的路径
            String excelPath = "d:/book.xls"  ; //request.getSession().getServletContext().getRealPath("/Excel/"+"sxstuds.xls");
           // File image = new File(excelPath);
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
