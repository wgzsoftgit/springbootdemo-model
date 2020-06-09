package com.demomodel.utils.readpropersion;

import java.util.ResourceBundle;
//Can't find bundle for base name hbase.properties, locale zh_CN
//如果是读取的文件带有“properties”后缀名，它会从工程根目录下找,如果是到classes下则去掉后缀就可以了。
//错误的写法:
//ResourceBundle resourceBundle= ResourceBundle.getBundle("hbase.properties");
//正确的写法:
//ResourceBundle resourceBundle= ResourceBundle.getBundle("hbase");
//https://blog.csdn.net/LL9504/article/details/103029852
public class CreateHbaseTableDemo {
    public static void main(String[] args) {
//        ResourceBundle resourceBundle= ResourceBundle.getBundle("hbase.properties");
    	ResourceBundle resourceBundle= ResourceBundle.getBundle("hbase");
        String port = resourceBundle.getString("zookeeperPort");
        String threadMax = resourceBundle.getString("threadMax");
        String keyValueMaxSize = resourceBundle.getString("KeyValueMaxSize");
        System.out.println("读取hbase.properties的内容"+port);
        System.out.println("读取hbase.properties的内容"+threadMax);
        System.out.println("读取hbase.properties的内容"+keyValueMaxSize);
 
 
    }
}
