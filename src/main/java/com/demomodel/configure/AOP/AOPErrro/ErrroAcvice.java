package com.demomodel.configure.AOP.AOPErrro;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ErrroAcvice {

    /**
     * 全局捕获异常的切面类
     * @param request 请求对象，可不传
     * @param response 响应对象，可不传
     * @param e 异常类(这个要和你当前捕获的异常类是同一个)
     */
   // @ExceptionHandler(Exception.class) //也可以只对一个类进行捕获
    public void errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e){
      	/*
      	 * You can do everything you want to do
         * 这里你拿到了request和response对象，你可以做任何你想做的事
         * 比如：
         *	1.用request从头信息中拿到Accept来判断是请求方可接收的类型从而进行第一个方法的判断
         *	2.如果你也想返回一个页面，使用response对象进行重定向到自己的错误页面就可以了
         *  3.你甚至还拿到了异常对象
      	 */
      
        String accept = request.getHeader("Accept");
				// 根据这个字符串来判断做出什么响应	
      System.err.println(accept);
        try {
            response.setStatus(500);
            response.getWriter().write("hello");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
      
    }
}