package com.demomodel.utils.StringUtils.inputToString;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;

public class InputStringTo {

	public String InputToString1(InputStream inputStream) throws IOException {		
		//方法一：           --------------------------------------------
		byte[] bytes = new byte[0];
		bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		String str = new String(bytes);
		return null;
		
	}
	public String InputToString2(InputStream inputStream)  {		
		
		//方法二：
		String result = new BufferedReader(new InputStreamReader(inputStream))
		.lines().collect(Collectors.joining(System.lineSeparator()));
		return result;
		
	}
	public String InputToString3(InputStream inputStream) throws IOException {		
		//方法三：
		String result = new BufferedReader(new InputStreamReader(inputStream))
		.lines().parallel().collect(Collectors.joining(System.lineSeparator()));
		return result;
		
	}
	public String InputToString4(InputStream inputStream) throws IOException {		
		//方法四：
		Scanner s = new Scanner(inputStream).useDelimiter("\\A");
		String str = s.hasNext() ? s.next() : "";
		return str;
		
	}
	public String InputToString5(InputStream inputStream) throws IOException {		
		//方法五：
		String resource = new Scanner(inputStream).useDelimiter("\\Z").next();
		return resource;
		
	}
	public String InputToString6(InputStream inputStream) throws IOException {		
		//方法六：
		StringBuilder sb = new StringBuilder();
		String line;

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		while ((line = br.readLine()) != null) {
		sb.append(line);
		}
		String str = sb.toString();
		return str;
	}
	public static String InputToString7(InputStream inputStream) throws IOException {		
		//方法七：----------------------------推荐-----------------------
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) != -1) {
		result.write(buffer, 0, length);
		}
		String str = result.toString(StandardCharsets.UTF_8.name());
		return str;
		
	}
	public String InputToString8(InputStream inputStream) throws IOException {		
		//方法八：
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result = bis.read();
		while(result != -1) {
		buf.write((byte) result);
		result = bis.read();
		}
		String str = buf.toString();
		return str;
		
	}
	public String InputToString9(InputStream inputStream) throws IOException {		
		//方法九：  ----------------------推荐-------------
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
		String str = writer.toString();
		return str;
		
	}
	public String InputToString10(InputStream inputStream) throws IOException {		
		String str = IOUtils.toString(inputStream, "utf-8");
		return str;
		
	}
	public String InputToString11(InputStream inputStream) throws IOException {		
		//方法十一：
		String str = CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		return str;
		
	}
	public String InputToString111(InputStream inputStream) throws IOException  {		
		//方法十二：
		String str = new String(ByteStreams.toByteArray(inputStream));
		return str;
		
	}

	
}
