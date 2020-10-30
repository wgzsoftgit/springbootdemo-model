package com.demomodel.utils.Excel.ResourceToExcel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demomodel.utils.Excel.bean.Demotxt2;
import com.demomodel.utils.Excel.map.Demotxt2Mapper;

import jxl.Workbook;
import jxl.biff.ByteArray;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
//http://localhost:9093/TestDbToExcel/Toexcel
/**
 * mysql数据导入到Excel表
 * @author wgz
 * @date 创建时间：2020年5月25日 下午2:30:37
 */
@RestController
@RequestMapping("TestDbToExcel")
public class TestDbToExcel {

  @Autowired
  Demotxt2Mapper  demotxt2Mapper;
	
  //poi
  //客户端下载 文件      可保存或直接打开   推荐   <a>标签请求
//  原因：因为response原因，一般请求浏览器是会处理服务器输出的response，
//例如生成png、文件下载等,然而ajax请求只是个“字符型”的请求，即请求的内容是以文本类型存放的。
 //文件的下载是以二进制形式进行的，虽然可以读取到返回的response，但只是读取而已，是无法执行的，
  //说白点就是js无法调用到浏览器的下载处理机制和程序。
  @RequestMapping("DownToexcel")
  public void main2(HttpServletResponse response,HttpServletRequest request) {
		try {
			//创建HSSFWorkbook对象(excel的文档对象)
		      HSSFWorkbook wb = new HSSFWorkbook();
		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet=wb.createSheet("成绩表");
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1=sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell=row1.createCell(0);
		      //设置单元格内容
		cell.setCellValue("学员考试成绩一览表");
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		//在sheet里创建第二行
		HSSFRow row2=sheet.createRow(1);    
		      //创建单元格并设置单元格内容
		      row2.createCell(0).setCellValue("姓名");
		      row2.createCell(1).setCellValue("班级");    
		      row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");    
		      //在sheet里创建第三行
		      HSSFRow row3=sheet.createRow(2);
		      row3.createCell(0).setCellValue("李明");
		      row3.createCell(1).setCellValue("As178");
		      row3.createCell(2).setCellValue(87);    
		      row3.createCell(3).setCellValue(78);    
		  //.....省略部分代码
		 
		      String fileName = "xxx.xls";
		   // 请求客户端操作系统的信息  
			    final String userAgent = request.getHeader("USER-AGENT");  
			    if(userAgent.contains("Firefox")){
					//是火狐浏览器，使用BASE64编码
					//fileName = "=?utf-8?b?"+new BASE64Encoder().encode(fileName.getBytes("utf-8"))+"?=";
				}else{
					//给文件名进行URL编码
					//URLEncoder.encode()需要两个参数，第一个参数时要编码的字符串，第二个是编码所采用的字符集
					fileName = URLEncoder.encode(fileName, "utf-8");
				}
		//输出Excel文件
		    OutputStream output=response.getOutputStream();
		    response.reset();
		    response.setHeader("Content-disposition", "attachment;filename= "+ fileName);
		    response.setContentType("application/msexcel;charset=utf-8");      
		    wb.write(output);
		    output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  //jxl方式   一般不用这种下载
  //自动下载      自动创建文件下载  已经自动下载到D://book.xls  本地下载
	@RequestMapping("Toexcel")
    public  void main() {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "D://book.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook    若要直接输出到磁盘文件可采用下列代码 下载本地用的
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 2", 1);
               
               //查询数据库中所有的数据
               List<Demotxt2> list= demotxt2Mapper.selectALL();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelId= new Label(0, 0, "编号(id)");//表示第
               Label labelName= new Label(1, 0, "姓名(name)");
               Label labelSex= new Label(2, 0, "性别(sex)");
               Label labelNum= new Label(3, 0, "薪水(num)");
               Label address= new Label(4, 0, "地址(address)");
               
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(labelSex);
               ws.addCell(labelNum);
               ws.addCell(address);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
                   Label labelName_i= new Label(1, i+1, list.get(i).getDemo());
                   Label labelSex_i= new Label(2, i+1, list.get(i).getNsmre());
                   Label labelNum_i= new Label(3, i+1, list.get(i).getSate()+"");
                   Label address_i= new Label(4, i+1, list.get(i).getAddress()+"");
                   ws.addCell(labelId_i);
                   ws.addCell(labelName_i);
                   ws.addCell(labelSex_i);
                   ws.addCell(labelNum_i);
                   ws.addCell(address_i);
               }
             
             //4、 合并单元格
           //    wwb.mergeCells(3,1, 9, 1);// 参数说明，前两个参数为待合并的起始单元格位置，后两个参数用来指定结束单元格位置（列和行）
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
	
	
	
	
	
	
	
	//2.写文件到excel中

    /**
     * 写数据到本地磁盘
     * @param datas 课程数据
     * @param fileQualifyName   文件全路径(比如C:/USER/XXX.excel)
     */
    public void writeCourse2LocalExcel(List<Map<String,Object>> datas,String fileQualifyName){
        String[] title = { "序号", "课程编号", "课程平台","课程性质","中文名称","英文名称","学分/学时", "周学时分配","计分方式" };
        //2.1写入表头信息
        // 创建一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        // 设置列宽
        this.setColumnWidth(sheet, 9);
        // 创建第一行
        HSSFRow row = sheet.createRow(0);
        // 创建一个单元格
        HSSFCell cell = null;
        // 创建表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            // 设置样式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置字体居中
            // 设置字体
            HSSFFont font = workbook.createFont();
            font.setFontName("宋体");
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体加粗
            // font.setFontHeight((short)12);
            font.setFontHeightInPoints((short) 13);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(title[i]);
        }


        // 2.2写入数据
        // 从第二行开始追加数据
        for (int i = 1, length_1 = (datas.size() + 1); i < length_1; i++) {
            // 创建第i行
            HSSFRow nextRow = sheet.createRow(i);
            // 设置样式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置字体居中
            // 获取数据(一条数据)
            Map<String, Object> course = datas.get(i - 1);
            for (int j = 0; j < 9; j++) {
                HSSFCell cell2 = nextRow.createCell(j);
                cell2.setCellStyle(cellStyle);
                if (j == 0) {
                    cell2.setCellValue(i);//第一列是序号
                    continue;
                }
                if (j == 1) {
                    cell2.setCellValue(course.get("courseNum").toString());//课程编号
                    continue;
                }
                if (j == 2) {
                    cell2.setCellValue(course.get("coursePlatform").toString());//课程平台
                    continue;
                }
                if (j == 3) {
                    cell2.setCellValue(course.get("courseNature").toString());//课程性质
                    continue;
                }
                if (j == 4) {
                    cell2.setCellValue(course.get("courseNameCN").toString());//中文名称
                    continue;
                }
                if (j == 5) {
                    cell2.setCellValue(course.get("courseNameEN").toString());//英文名称
                    continue;
                }
                if (j == 6) {
                    cell2.setCellValue(course.get("credit").toString()+"/"+course.get("courseHour").toString());//学分/学时
                    continue;
                }
                if (j == 7) {
                    cell2.setCellValue(course.get("weeklyHour").toString());//周学时
                    continue;
                }
                if (j == 8) {
                    cell2.setCellValue(course.get("scoringWay").toString());//计分方式
                    continue;
                }
            }
        }


        // 创建一个文件
        File file = new File(fileQualifyName);
        // 获取文件的父文件夹并删除文件夹下面的文件
        File parentFile = file.getParentFile();
        // 获取父文件夹下面的所有文件
        File[] listFiles = parentFile.listFiles();
        if (parentFile != null && parentFile.isDirectory()) {
            for (File fi : listFiles) {
                // 删除文件
                fi.delete();
            }
        }
        // 如果存在就删除
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            // 打开文件流并写入文件
            FileOutputStream outputStream = org.apache.commons.io.FileUtils.openOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 设置列宽的函数
     * @param sheet 对哪个sheet进行设置，
     * @param colNum
     */
    private  void setColumnWidth(HSSFSheet sheet, int colNum) {
        for (int i = 0; i < colNum; i++) {
            int v = 0;
            v = Math.round(Float.parseFloat("15.0") * 37F);
            v = Math.round(Float.parseFloat("20.0") * 267.5F);
            sheet.setColumnWidth(i, v);
        }
    }
  //3.打开流提供下载
    @RequestMapping("/downCourses")
    public void down(HttpServletRequest request, HttpServletResponse response,@RequestParam Map condition){
        //1.查询数据
        List<Map<String, Object>> datas = this.getCourseBaseInfosByCondition(condition);
        //2.写入excel
        String dir = "path"+"courseExcelFile";
        String fileName = "DefaultValue.COURSE_DEFAULT_FILENAME";
        String fileQualifyName =  dir + fileName;//生成的excel名字
        this.writeCourse2LocalExcel(datas,fileQualifyName);//写入数据(生成文件)
        //3.打开流提供下载
        //获取输入流
        try {
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileQualifyName)));
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
            out.close();
        } catch (Exception e) {
            System.err.println("下载课程信息出错!"+e);
        }
    }
    //1.查询数据
    public List<Map<String, Object>> getCourseBaseInfosByCondition(@RequestParam Map<String, Object> condition) {
        List<Map<String, Object>> datas = null;
        try {
           // datas =  courseBaseInfoService.getCourseBaseInfosByCondition(condition);
        } catch (Exception e) {
            System.err.println("导出课程信息的时候查询数据库出错"+e);
        }
        return datas;
    }
    //https://www.cnblogs.com/qlqwjy/p/8971207.html
	
}
