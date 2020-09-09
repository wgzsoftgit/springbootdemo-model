package com.demomodel.utils.demo.imgpngcheck;

import java.util.HashMap;
import java.util.Map;
//根据文件的前面几个字节，即常说的魔术数字进行判断，不同文件类型的开头几个字节
//不同文件的头魔术数字
//此时有人把一个可执行的PHP文件的扩展名修改为PNG,然后再在前面补上”89 50″两个字节，就又绕开了这种验证方式，这种也是不靠谱的！
public class ToHexFileType {
	static Map<String,String> FILE_TYPE_MAP=new HashMap<String, String>();
	
	private static void getAllFileType()     
	    {     
	        FILE_TYPE_MAP.put("jpg", "FFD8FF"); //JPEG      
	        FILE_TYPE_MAP.put("png", "89504E47"); //PNG      
	        FILE_TYPE_MAP.put("gif", "47494638"); //GIF     
	        FILE_TYPE_MAP.put("tif", "49492A00"); //TIFF    
	        FILE_TYPE_MAP.put("bmp", "424D"); //Windows Bitmap     
	        FILE_TYPE_MAP.put("dwg", "41433130"); //CAD   
	        FILE_TYPE_MAP.put("html", "68746D6C3E"); //HTML    
	        FILE_TYPE_MAP.put("rtf", "7B5C727466"); //Rich Text Format    
	        FILE_TYPE_MAP.put("xml", "3C3F786D6C");     
	        FILE_TYPE_MAP.put("zip", "504B0304");     
	        FILE_TYPE_MAP.put("rar", "52617221");     
	        FILE_TYPE_MAP.put("psd", "38425053"); //PhotoShop  
	        FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A"); //Email [thorough only]   
	        FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F"); //Outlook Express   
	        FILE_TYPE_MAP.put("pst", "2142444E"); //Outlook      
	        FILE_TYPE_MAP.put("office", "D0CF11E0"); //office类型，包括doc、xls和ppt     
	        FILE_TYPE_MAP.put("mdb", "000100005374616E64617264204A"); //MS Access     
	        FILE_TYPE_MAP.put("wpd", "FF575043"); //WordPerfect   
	        FILE_TYPE_MAP.put("eps", "252150532D41646F6265");     
	        FILE_TYPE_MAP.put("ps", "252150532D41646F6265");     
	        FILE_TYPE_MAP.put("pdf", "255044462D312E"); //Adobe Acrobat   
	        FILE_TYPE_MAP.put("qdf", "AC9EBD8F"); //Quicken  
	        FILE_TYPE_MAP.put("pwl", "E3828596"); //Windows Password 
	        FILE_TYPE_MAP.put("wav", "57415645"); //Wave   
	        FILE_TYPE_MAP.put("avi", "41564920");     
	        FILE_TYPE_MAP.put("ram", "2E7261FD"); //Real Audio     
	        FILE_TYPE_MAP.put("rm", "2E524D46"); //Real Media     
	        FILE_TYPE_MAP.put("mpg", "000001BA"); //     
	        FILE_TYPE_MAP.put("mov", "6D6F6F76"); //Quicktime     
	        FILE_TYPE_MAP.put("asf", "3026B2758E66CF11"); //Windows Media    
	        FILE_TYPE_MAP.put("mid", "4D546864"); //MIDI (mid)     
	    }
}

