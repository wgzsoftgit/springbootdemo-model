package com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
@Component
@Qualifier("tag2")//@1
public class Servicefu3 implements IService {
}