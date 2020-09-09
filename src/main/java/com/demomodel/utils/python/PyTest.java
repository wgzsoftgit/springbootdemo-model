package com.demomodel.utils.python;
import org.python.util.PythonInterpreter;
import org.python.core.*;
 
public class PyTest {
    public static void main(String[] args) {
    	//运行test.py脚本
        PythonInterpreter interp1 = new PythonInterpreter();
        interp1.execfile("test.py");
        //运行python命令
//        PythonInterpreter interp = new PythonInterpreter();
//        System.out.println("Hello, brave new world");
//        interp.exec("import sys");
//        interp.exec("print sys");
//        interp.set("a", new PyInteger(42));
//        interp.exec("print a");
//        interp.exec("x = 2+2");
//        PyObject x = interp.get("x");
//        System.out.println("x: "+x);
//        System.out.println("Goodbye, cruel world");
    }
}