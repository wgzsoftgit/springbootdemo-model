package com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
@Component
@Qualifier("tag1")
public class Servicefu2 implements IService {
}