package com.demomodel.filter.views;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;

public class HandleResourceViewExists extends InternalResourceView {
 
    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
       System.err.println("com.demomodel.filter.views.HandleResourceViewExists"+file);
        return file.exists(); //判断页面是否存在
    }
    
    
    
}
//https://blog.csdn.net/qq_29611427/java/article/details/88867549