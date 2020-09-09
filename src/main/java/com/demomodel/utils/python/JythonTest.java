package com.demomodel.utils.python;
import org.python.util.PythonInterpreter;

import com.google.common.collect.Lists;

import lombok.var;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.python.core.*;  
public class JythonTest {  
    public static void main(String[] args) { 
    	
    	var numbers = Arrays.asList(1, 2, 3);
    	for (var nr : numbers)
    	System.out.print(nr + " ");
    	for (var i = 0; i < numbers.size(); i++)
    	System.out.print(numbers.get(i) + " ");
    	
    	
    	
    	Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");
        interpreter.exec("print days[1];");
    	
        PythonInterpreter interp2 = new PythonInterpreter();  
        interp2.execfile("test.py"); //运行test.py脚本  
               //运行python命令  
        PythonInterpreter interp =  
            new PythonInterpreter();  
            System.out.println("Hello, brave new world");  
            interp.exec("import sys");  
            interp.exec("print sys");  
            interp.set("a", new PyInteger(42));  
            interp.exec("print a");  
            interp.exec("x = 2+2");  
            PyObject x = interp.get("x");  
            System.out.println("x: "+x);  
            System.out.println("Goodbye, cruel world");  
    
    }  
}  