package com.demomodel.utils.OpenOffice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.sun.star.io.IOException;


public class FileUploadController {

	/**
	 * 图片上传
	 * 
	 * @param myfiles  // myfiles 的名称要和页面中 <input type="file" name="myfiles" /> 中的name名称保持一致，否则获取不到你上传的文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/upload")
	public static Object uploadApk(MultipartFile myfiles, HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		//判断文件是否为空
	    if(myfiles.isEmpty()){
	    	resMap.put("msg", "文件为空，上传失败!");
	    	return resMap;
	    }
	     

		if (myfiles.getSize() > 1024 * 1024 * 5) {
			resMap.put("code", 500);
			resMap.put("msg", "文件过大，请上传5M以内的图片");
			System.out.println("文件上传失败");
			return resMap;
		}
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		Date dt = new Date();
		Long time = dt.getTime();
		if (myfiles != null) {
			String realPath = "d://uploadFiles/";// 获取保存的路径，本地磁盘中的一个文件夹
			if (myfiles.isEmpty()) {
// 未选择文件
				resMap.put("code", 400);
				resMap.put("msg", "未选择文件");
			} else {
// 文件原名称
				String originFileName = "";
// 上传文件重命名
				String originalFilename = time.toString().substring(time.toString().length() - 8,
						time.toString().length());
				originalFilename = originalFilename.concat(".");
				originalFilename = originalFilename.concat(myfiles.getOriginalFilename().toString()
						.substring(myfiles.getOriginalFilename().toString().indexOf(".") + 1));
				InputStream fis = null;
		        OutputStream outputStream = null;	
				try {
// 这里使用Apache的FileUtils方法来进行保存
				//	FileUtil.uploadFile(myfiles.getBytes(), path, originalFilename);
				//	FileUtils.copyInputStreamToFile(myfiles.getInputStream(), new File(realPath, originalFilename));
					 fis = myfiles.getInputStream();
			            outputStream = new FileOutputStream("G:\\uploadfile\\"+myfiles.getOriginalFilename());
			            IOUtils.copy(fis,outputStream);
			//https://blog.csdn.net/zknxx/article/details/72633444
					
					resMap.put("code", 200);
					resMap.put("msg", "上传成功");
					resMap.put("filename", originalFilename);
					resMap.put("path", basePath + "/static/image/" + originalFilename);

				} catch (Exception e) {
					resMap.put("code", 500);
					System.out.println("文件上传失败");
					resMap.put("msg", "文件上传失败");
					e.printStackTrace();
				}
			}

		}

		String param = JSON.toJSONString(resMap);
		System.out.println(param);
		return resMap;
	}
	/**
	 * 下载
	 * @param response
	 * @throws java.io.IOException
	 */
	@RequestMapping(value="/download",method = RequestMethod.GET)
    public void download( HttpServletResponse response) throws java.io.IOException{
        //要上传的文件名字
        String fileName="com.seven.xuanshang.apk";
        //通过文件的保存文件夹路径加上文件的名字来获得文件
        File file=new File("D://",fileName);
        //当文件存在
        if(file.exists()){
            //首先设置响应的内容格式是force-download，那么你一旦点击下载按钮就会自动下载文件了
            response.setContentType("application/force-download");
            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", file.getName()));
            //进行读写操作
            byte[]buffer=new byte[1024];
            FileInputStream fis=null;
            BufferedInputStream bis=null;
            try{
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
                OutputStream os=response.getOutputStream();
                //从源文件中读
                int i=bis.read(buffer);
                while(i!=-1){
                    //写到response的输出流中
                    os.write(buffer,0,i);
                    i=bis.read(buffer);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //善后工作，关闭各种流
                try {
                    if(bis!=null){
                        bis.close();
                    }
                    if(fis!=null){
                        fis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
 
        }
    }
//https://blog.csdn.net/qq_36159851/article/details/79968433
}
//：https://blog.csdn.net/qq_34350964/article/details/84028262