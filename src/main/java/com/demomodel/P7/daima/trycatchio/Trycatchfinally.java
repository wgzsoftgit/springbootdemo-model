package com.demomodel.P7.daima.trycatchio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trycatchfinally {
	/*
	 * 有经验的读者会从上面这段代码中发现 2 个严重的问题：

1）文件名“牛逼.txt”包含了中文，需要通过 java.net.URLDecoder 类的 decode() 方法对其转义，否则这段代码在运行时铁定要抛出文件找不到的异常。

2）如果直接通过 new FileReader("牛逼.txt") 创建 FileReader 对象，“牛逼.txt”需要和项目的 src 在同一级目录下，否则同样会抛出文件找不到的异常。但大多数情况下，（配置）文件会放在 resources 目录下，便于编译后文件出现在 classes 目录下
	 */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/牛逼.txt"));
            String str = null;
            while ((str =br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}