package com.demomodel.configure.AOP.AOPErrro;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springfox.documentation.annotations.ApiIgnore;

@RestControllerAdvice
@ApiIgnore
public class AllExceptionHandler {

	static Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
    public JsonResponse<?> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("", e);
        JsonResponse<?> r = new JsonResponse<>();
        r.setMessage(e.getMessage());
        System.err.println("com.demomodel.configure.AOP.AOPErrro.AllExceptionHandler"+e.getMessage());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
             r.setStatus(404);
        } else {
             r.setStatus(500);
        }
        r.setData(null);
        return r;
    }
}
