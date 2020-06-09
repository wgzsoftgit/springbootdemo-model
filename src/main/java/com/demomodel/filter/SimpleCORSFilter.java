package com.demomodel.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.fasterxml.classmate.Filter;

@Component   //不起作用
public class SimpleCORSFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");

        response.setHeader("Access-Control-Max-Age", "3600");

        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");

 

       // chain.doFilter(servletRequest, servletResponse);
       System.err.println("com.demomodel.filter.SimpleCORSFilter"+"*********************************过滤器被使用**************************");
                try {
                	chain.doFilter(servletRequest, servletResponse);
                 } catch (IllegalStateException e) {
                     servletRequest.getServletContext().removeAttribute("/rent");
                } catch (ServletException e) {
                    e.printStackTrace();
                }  
    }
	@Override
	public boolean include(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

}