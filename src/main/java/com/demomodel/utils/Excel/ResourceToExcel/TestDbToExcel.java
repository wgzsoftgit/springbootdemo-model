package com.demomodel.utils.Excel.ResourceToExcel;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demomodel.utils.Excel.bean.Demotxt2;
import com.demomodel.utils.Excel.map.Demotxt2Mapper;

import jxl.Workbook;
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
               //以fileName为文件名来创建一个Workbook
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
