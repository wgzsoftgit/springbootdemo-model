package com.demomodel.utils.Excel.ResourceToExcel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
  //客户端下载 文件      可保存或直接打开   推荐
  @RequestMapping("DownToexcel")
  public void main2(HttpServletResponse response) {
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
  //自动下载      自动创建文件下载  已经自动下载到D://book.xls
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
	
}
