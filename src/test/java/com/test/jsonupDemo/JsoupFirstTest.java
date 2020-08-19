package com.test.jsonupDemo;

import java.io.File;
import java.net.URL;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class JsoupFirstTest {

	@Test
	public void testUrl() throws Exception{
		//解析url  第一访问url 第二个参数访问的超时时间
		Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
		//使用标签选择器，获取title标签中的内容
		String text = doc.getElementsByTag("title").first().text();
		System.err.println(text);
	}
	
	@Test
	public void testFileString() throws Exception{
		String readFileToString = FileUtils.readFileToString(new File("C:\\Users\\zbj\\Desktop\\select_menu_checkbox.html"), "utf-8");
		
		//解析字符串
		Document doc = Jsoup.parse(readFileToString);
		//使用标签选择器，获取title标签中的内容
		String text = doc.getElementsByTag("title").first().text();
		System.err.println(text);
	}
	@Test
	public void testFile() throws Exception{
		
		//解析字符串
		Document doc = Jsoup.parse(new File("C:\\Users\\zbj\\Desktop\\select_menu_checkbox.html"), "utf-8");
		//使用标签选择器，获取title标签中的内容
		String text = doc.getElementsByTag("title").first().text();
		System.err.println(text);
	}
	
	@Test
	public void testDom() throws Exception{
		
		//解析字符串
		Document doc = Jsoup.parse(new File("C:\\Users\\zbj\\Desktop\\select_menu_checkbox.html"), "utf-8");
		//获取元素
		//1、根据id查询元素
	//	Element elementById = doc.getElementById("text1");
		//2、根据标签获取元素
	//	Element elementById = doc.getElementsByTag("span").first();
		//3、根据class获取元素
//		Element elementById = doc.getElementsByClass("class_a class_b").first();
//		Element elementById = doc.getElementsByClass("class_a").first();
//		Element elementById = doc.getElementsByClass("class_b").first();
		//4、根据属性获取元素
		Element elementById = doc.getElementsByAttribute("abc").first();
		Element elementById2 = doc.getElementsByAttributeValue("href", "www.baidu.com").first();
		System.err.println("根据id查询元素"+elementById.text());
	}
	@Test
	public void testData() throws Exception{
		
		//解析字符串
		Document doc = Jsoup.parse(new File("C:\\Users\\zbj\\Desktop\\select_menu_checkbox.html"), "utf-8");
		Element elementById = doc.getElementById("text1");
		String str="";
		//获取元素
		//1、从元素中获取id
		str=elementById.id();
		//2、从元素中获取classname
		str=elementById.className();
		Set<String> classNames = elementById.classNames();
		//3、从元素中获取属性的值attr     获取属性的值——————####
		str=elementById.attr("id");
	//	str=elementById.attr("class");
		//4、从元素中获取属性的值attrbuter   获取所有属性值
		Attributes attributes = elementById.attributes();
		System.err.println(attributes.toString());
		//5、从元素中获取元素内容
		str = elementById.text();
		System.err.println("元素"+str);
	}
	@Test
	public void testSelect() throws Exception{
		
		//解析字符串
		Document doc = Jsoup.parse(new File("C:\\Users\\zbj\\Desktop\\select_menu_checkbox.html"), "utf-8");
		//tagname  通过标签查找元素  span
		Elements select = doc.select("span");
		for (Element element : select) {
			System.err.println(element.text());
		}
		//#id  通过ID查找元素，   eg:#city
	//	Element first = doc.select("#ciuty").first();
		//。class  通过class名称查找元素 eg:.class_a
	//	Element first = doc.select(".class_a").first();
		//[attribute]  利用属性查找元素 eg:[abc]
	//	Element first = doc.select("[abc]").first();
		//[attr=value]  利用属性值来查找元素 eg:[class=s_name]
	//	Element first = doc.select("[class=s_name]").first();
	
		//组合使用
	//el#id 元素+id  eg：h3#city
    //el.class 元素——+class eg： li.calls_a
	//el[attr] 元素+属性名  eg： span[abc]
	//任意组合 eg: span[abc].s_name
	// ancestor child 查找某个元素下子元素  eg: .city_con  li 查找“city_con”下的所有li
	//parent > childer 查找某个父元素下的直接子元素 eg: .city_con>ul>li
	//parent>* 查找父元素下所有子元素
	}
}
