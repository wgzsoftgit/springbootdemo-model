package com.demomodel.utils.OpenOffice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
 
public class Doc2HtmlUtil {
	
	
    /**
     *  转换文件成pdf
     * @param fromFileInputStream
     * @param toFilePath   ""
     * @param type  doc  docx xls  slsx  ppt  pptx txt pdf  
     * @return
     * @throws Exception
     */
    
    public static String file2pdf(InputStream fromFileInputStream, String toFilePath,String type) throws Exception{
        String timesuffix = "ddaaaaaa";//IDUtil.getID();
        String docFileName = null;
        String htmFileName = null;
        if("doc".equals(type)){
            docFileName = timesuffix.concat(".doc");
            htmFileName = timesuffix.concat(".pdf");
        }else if("docx".equals(type)){
            docFileName = timesuffix.concat(".docx");
            htmFileName = timesuffix.concat(".pdf");
        }else if("xls".equals(type)){
            docFileName = timesuffix.concat(".xls");
            htmFileName = timesuffix.concat(".pdf");
        }else if("xlsx".equals(type)){
            docFileName = timesuffix.concat(".xlsx");
            htmFileName = timesuffix.concat(".pdf");
        }else if("ppt".equals(type)){
            docFileName = timesuffix.concat(".ppt");
            htmFileName = timesuffix.concat(".pdf");
        }else if("pptx".equals(type)){
            docFileName = timesuffix.concat(".pptx");
            htmFileName = timesuffix.concat(".pdf");
        }else if("txt".equals(type)){
            docFileName = timesuffix.concat(".txt");
            htmFileName = timesuffix.concat(".pdf");
        }else{
        	return null;
        }
 
        File htmlOutputFile = new File(toFilePath + File.separatorChar + htmFileName);
        File docInputFile = new File(toFilePath + File.separatorChar + docFileName);
        if (htmlOutputFile.exists()){
        	htmlOutputFile.delete();
        }
 
		htmlOutputFile.createNewFile();
 
        docInputFile.createNewFile();
        
        /**
         * 由fromFileInputStream构建输入文件
         */
        int bytesRead = 0;
        byte[] buffer = new byte[1024];
    	OutputStream os = new FileOutputStream(docInputFile);
		while ((bytesRead = fromFileInputStream.read(buffer)) != -1) {
		    os.write(buffer, 0, bytesRead);
		}
		os.close();
        fromFileInputStream.close();
        
        OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1",8100);
		connection.connect();
        // convert
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
        converter.convert(docInputFile, htmlOutputFile);
        connection.disconnect();
        // 转换完之后删除word文件
        docInputFile.delete();
        return htmFileName;
    }
    /**
     * 文件转换成Html
     * @param fromFileInputStream
     * @param toFilePath
     * @param type  doc  docx xls  slsx  ppt  pptx txt pdf
     * @return
     * @throws Exception
     */
    public static String file2Html (InputStream fromFileInputStream, String toFilePath,String type) throws Exception{
		String timesuffix ="text";
        String docFileName = null;
        String htmFileName = null;
        if("doc".equals(type)){
            docFileName = timesuffix.concat(".doc");
            htmFileName = timesuffix.concat(".html");
        }else if("docx".equals(type)){
            docFileName = timesuffix.concat(".docx");
            htmFileName = timesuffix.concat(".html");
        }else if("xls".equals(type)){
            docFileName = timesuffix.concat(".xls");
            htmFileName = timesuffix.concat(".html");
        }else if("xlsx".equals(type)){
            docFileName = timesuffix.concat(".xlsx");
            htmFileName = timesuffix.concat(".html");
        }else if("ppt".equals(type)){
            docFileName = timesuffix.concat(".ppt");
            htmFileName = timesuffix.concat(".html");
        }else if("pptx".equals(type)){
            docFileName = timesuffix.concat(".pptx");
            htmFileName = timesuffix.concat(".html");
        }else if("txt".equals(type)){
            docFileName = timesuffix.concat(".txt");
            htmFileName = timesuffix.concat(".html");
        }else if("pdf".equals(type)){
        	docFileName = timesuffix.concat(".pdf");
			htmFileName = timesuffix.concat(".html");
        }else{
        	return null;
        }
		File htmlOutputFile = new File(toFilePath + File.separatorChar + htmFileName);
        File docInputFile = new File(toFilePath + File.separatorChar + docFileName);
        if (htmlOutputFile.exists()){
        	htmlOutputFile.delete();
        }
		htmlOutputFile.createNewFile();
        docInputFile.createNewFile();
        /**
         * 由fromFileInputStream构建输入文件
         */
        int bytesRead = 0;
        byte[] buffer = new byte[1024 * 8];
    	OutputStream os = new FileOutputStream(docInputFile);
		while ((bytesRead = fromFileInputStream.read(buffer)) != -1) {
		    os.write(buffer, 0, bytesRead);
		}
		os.close();
        fromFileInputStream.close();
        OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1",8100);
		connection.connect();
        // convert
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
        converter.convert(docInputFile, htmlOutputFile);
        connection.disconnect();
        // 转换完之后删除word文件
        docInputFile.delete();
        return htmFileName;
	}	
}
//————————————————
//版权声明：本文为CSDN博主「坐看云淡风轻」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_38294614/article/details/85621544