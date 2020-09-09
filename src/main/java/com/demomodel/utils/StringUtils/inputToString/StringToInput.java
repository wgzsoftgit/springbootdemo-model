package com.demomodel.utils.StringUtils.inputToString;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.curator.shaded.com.google.common.io.CharSource;

public class StringToInput {

	public InputStream StringToinput1jdk(String str) {
		
		InputStream is = new ByteArrayInputStream(str.getBytes());
		return is;
	}
	public InputStream StringToinput1Apache(String str) throws IOException {
		
		InputStream targetStream = IOUtils.toInputStream(str, StandardCharsets.UTF_8.name());
		return targetStream;
	}

}
