package com.demomodel.interfaceDesign.interfaces.Impl;

import org.springframework.stereotype.Service;

import com.demomodel.interfaceDesign.interfaces.PersonAnnotationService;
import com.demomodel.interfaceDesign.notes.personInfo;


@Service
@personInfo(personInfo="PersonCodingServiceimpl+config.personInfoCoding")
public class PersonCodingServiceimpl implements PersonAnnotationService{

	@Override
	public String testPrint() {
		// TODO Auto-generated method stub
		System.err.println("com.demomodel.interfaceDesign.interfaces.Impl.PersonCodingServiceimpl###$$PersonCodingServiceimpl");
		
		return "ok-com.demomodel.interfaceDesign.interfaces.Impl.PersonCodingServiceimpl";
	}
	
}