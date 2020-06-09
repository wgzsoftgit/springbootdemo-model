/**
 * 
 */
package com.demomodel.controller.baseController;

import java.lang.reflect.Modifier;
import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Administrator
 *
 */
public class BaseController {

	protected final Gson gson ;
	
	protected final HttpHeaders headers;
	
	public BaseController () {
		gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
		headers = new HttpHeaders();
		MediaType mediaType = new MediaType("text","json",Charset.forName("UTF-8"));
		headers.setContentType(mediaType);
	}
}
