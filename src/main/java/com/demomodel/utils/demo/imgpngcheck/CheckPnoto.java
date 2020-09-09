package com.demomodel.utils.demo.imgpngcheck;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class CheckPnoto {
/*
	  function validateImageSize(url,fileinput) {
	        var f = fileinput.files[0];
	        var reader = new FileReader();
	        reader.onload = function (e) {
	            var data = e.target.result;
	            //加载图片获取图片真实宽度和高度
	            var image = new Image();
	            image.onload = function () {
	                var width = image.width;
	                var height = image.height;
	                if (width < 640 || height < 360) {
	                    $(fileinput).val('');
	                    alert("尺寸须大于640*360像素！");
	                    return;
	                }
	                if (width > 5000 || height > 5000) {
	                    $(fileinput).val('');
	                    alert("尺寸须小于5000*5000像素！");
	                    return;
	                }
	                doUpload(url);          
	            };
	            image.src = data;
	        };
	        reader.readAsDataURL(f);
	    }
	  */
	/**读取本地文件   一般不用可以用js代替
     * 通过读取文件并获取其width及height的方式，来判断判断当前文件是否图片，这是一种非常简单的方式。
     * @param imageFile
     * @return
     */
    public static boolean isImage(File imageFile) {
        if (!imageFile.exists()) {
            return false;
        }
        Image img = null;
        try {
            img = ImageIO.read(imageFile);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            img = null;
        }
    }
  /**
   * 根据文件的前面几个字节，即常说的魔术数字进行判断，不同文件类型的开头几个字节
   *   //不同文件的头魔术数字
  //此时有人把一个可执行的PHP文件的扩展名修改为PNG,然后再在前面补上”89 50″两个字节，就又绕开了这种验证方式，这种也是不靠谱的！
 
   * @param src
   * @return
   */
   public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) throws IOException {
        String imagePath = "d:/aa.jpg";
        File image = new File(imagePath);
        InputStream is = new FileInputStream(image);
        byte[] bt = new byte[2];
        is.read(bt);
        System.out.println("com.demomodel.utils.Excel.fileUpText.utils.checkPnoto "+bytesToHexString(bt));
        
        
        System.err.println("com.demomodel.utils.Excel.fileUpText.utils.checkPnoto "+isImage(image));
    }
}
