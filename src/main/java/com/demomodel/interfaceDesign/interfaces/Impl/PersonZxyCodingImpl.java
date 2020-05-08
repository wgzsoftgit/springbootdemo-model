package com.demomodel.interfaceDesign.interfaces.Impl;

import org.springframework.stereotype.Service;

import com.demomodel.interfaceDesign.interfaces.PersonZxyCoding;


@Service
public class PersonZxyCodingImpl implements PersonZxyCoding{
 
	@Override
	public String testPrint() {
		System.err.println("com.demomodel.interfaceDesign.interfaces.Impl.PersonZxyCodingImpl####$$$这里是son:PersonZxyCodingImpl");
		
		return null;
	}
 
}
//https://blog.csdn.net/zxysshgood/java/article/details/78399980