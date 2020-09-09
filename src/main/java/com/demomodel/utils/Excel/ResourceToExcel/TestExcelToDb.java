package com.demomodel.utils.Excel.ResourceToExcel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.utils.Excel.bean.Demotxt2;
import com.demomodel.utils.Excel.map.Demotxt2Mapper;

import jxl.Sheet;
import jxl.Workbook;
//得到表格中所有的数据   存入到mysql
@RestController
@RequestMapping("TestExcelToDb")
public class TestExcelToDb {

	@Autowired
	Demotxt2Mapper testExcelToDbSerivce;
	@Autowired
	TestExcelToDb testExcelToDb;
	
	@RequestMapping("Tomysql2")
	@ResponseBody
    public  boolean Tomysql2(int id) {
		   List<Demotxt2> exist = testExcelToDbSerivce.selectALL();
		   boolean exist2 = testExcelToDb.isExist(id);
		   return exist2;
		   
	} 
	
	@RequestMapping("Tomysql")
    public  void Tomysql() {
        //得到表格中所有的数据                                         &&
        List<Demotxt2> listExcel=TestExcelToDb.getAllByExcel("d://book.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/

        for (Demotxt2 stuEntity : listExcel) {
            Integer id=stuEntity.getId();
            System.out.println(id);
            boolean exist = testExcelToDb.isExist(id);
			  if ( ! exist) {
				  //不存在就添加 
				  System.err.println("不存在就添加到数据库");
			  }else { 
				  //存在就更新
				  System.err.println("存在就更新数据"); 
				  }
			 
        }
	}
	
	
	 /**
     * 查询指定目录中电子表格中所有的数据
     * 读取excel的表格的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<Demotxt2> getAllByExcel(String file){
        List<Demotxt2> list=new ArrayList<Demotxt2>();
        Workbook rwb=null;
        try {
        	
        	//导入已存在的Excel文件，获得只读的工作薄对象   可以获取文件流 
//            FileInputStream fis=new FileInputStream(xlsPath);
//            Workbook wk=Workbook.getWorkbook(fis);
        	//1:创建workbook
             rwb=Workbook.getWorkbook(new File(file));
             // 2:获取第一个工作表sheet
            Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String num=rs.getCell(j++, i).getContents();
                    String address=rs.getCell(j++, i).getContents();
                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num+" address:"+address);
                    list.add(new Demotxt2(Integer.parseInt(id), name, sex, num,address));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	 //最后一步：关闭资源
        	rwb.close();
		}
        return list;
        
    }
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */
    public boolean isExist(int id){
    	int count=	testExcelToDbSerivce.selectById(id);
    	System.out.println(count);
    if(count>0) {
    	return true;
    }
    	return false;
   
    }
}
