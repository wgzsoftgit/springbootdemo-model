package com.demomodel.interfaceDesign.interfaces.Impl;

import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.demomodel.interfaceDesign.getContent;
import com.demomodel.interfaceDesign.interfaces.PersonAnnotationService;
import com.demomodel.interfaceDesign.notes.personInfo;
/**
 * map中通过personInfo就是map中的key进行识别存的对象
 * @author wgz
 * @date 创建时间：2020年4月19日 上午11:25:02
 */
@Service
@personInfo(personInfo="PersonCoding2Serviceimpl+config.personInfoCoding")
public class PersonCoding2Serviceimpl implements PersonAnnotationService{

	@Override
	public String testPrint() {
		// TODO Auto-generated method stub
		System.err.println("###com.demomodel.interfaceDesign.interfaces.Impl.PersonCoding2Serviceimpl##@####");
		for(Entry<String, Object> entry : getContent.getPersonbeanmap.entrySet()){

		    String mapKey = entry.getKey();

		    Object mapValue = entry.getValue();

		    System.err.println("com.demomodel.interfaceDesign.interfaces.Impl.PersonCoding2Serviceimpl##$$$"+mapKey+"键值对:"+mapValue);

		}
		return null;
	}
		
}