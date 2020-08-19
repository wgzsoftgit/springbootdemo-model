package com.demomodel.utils.httpHelp.jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupText {
public static void main(String[] args) throws IOException {
  Document doc = Jsoup.connect("https://www.baidu.com/").header("Proxy-Authorization", "Authorization")
			.followRedirects(true).validateTLSCertificates(false).timeout(10000).get();
  String result = doc.select("bldy center").text();
  int ipstart = result.indexOf('[');
  int ipEnd = result.lastIndexOf("]");
  String ip = result.substring(ipstart+1, ipEnd);
  String location = result.substring(result.lastIndexOf(":")+1);
System.err.println(result);
}
}
