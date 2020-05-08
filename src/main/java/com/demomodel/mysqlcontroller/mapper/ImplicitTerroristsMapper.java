package com.demomodel.mysqlcontroller.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.demomodel.bean.master.ImplicitTerrorists;


//@respository  //任选其一
//@Mapper
public interface ImplicitTerroristsMapper {

	Integer totalCount(ImplicitTerrorists implicitTerrorists);
    /**
     * 查询涉恐的人员  
     * @param implicitTerrorists
     * @return
     */
	List<ImplicitTerrorists> selectByTypeCondition(ImplicitTerrorists implicitTerrorists);
    /**
     * 查询区域       
     * @return
     */
	List<String> selectByRegion();
	/**
	 * 更新布控状态   
	 * @param checkboxValue
	 */
	void updaControlStatesByarray(String[] checkboxValues);
	
	List<ImplicitTerrorists> getByTransNum(@Param("idCard") String idCard,@Param("transNum") String transNum ,@Param("departureDateStr") String departureDateStr);
}