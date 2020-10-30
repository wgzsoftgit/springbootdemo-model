package com.demomodel.utils.httpHelp.jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupText {
public static void main(String[] args) throws IOException {
  Document doc = Jsoup.connect("https://www.baidu.com/")
		    .header("Proxy-Authorization", "Authorization")
		  //  .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
//		    .cookie("auth", "token")
			.followRedirects(true).validateTLSCertificates(false).timeout(10000).get();
  Elements result = doc.select("#su");
  String text = result.val();

System.err.println(text);
}
}
