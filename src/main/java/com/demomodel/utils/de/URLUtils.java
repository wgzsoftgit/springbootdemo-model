/**
 * 
 */
package com.demomodel.utils.de;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shawnkuo
 *
 */
public class URLUtils {

	public static String reformNextUrl(String nextUrl) {
		//end with
		String REGEX1 = "\\?tab=[0-9]+"; 
		
		//contains both
		String REGEX2 = "\\&tab=[0-9]+";
		
		// step 1
		Pattern p = Pattern.compile(REGEX2);
        Matcher m = p.matcher(nextUrl); 
        nextUrl = m.replaceAll("");
        
        // step 2
        p = Pattern.compile(REGEX1);
        m = p.matcher(nextUrl); 
        nextUrl = m.replaceAll("");
        
        // step 3
        
        
		return nextUrl;
	}
	
	public static void main(String [] args) {
		String url1 = "http://datume.com/?tab=1";
		String url2 = "http://datume.com/?tab=2&tab=1&tab=2";
		String url3 = "http://datume.com/vv?tab=1";
		String url4 = "http://datume.com/vv?tab=2&tab=2";
		String url5 = "http://datume.com/vv/dd?query=keyword&tab=1";
		String url6 = "http://datume.com/vv/dd?query=keyword&tab=1&tab=1";
		String url7 = "http://datume.com/vv/dd?query=keyword&tab=1&tab=2";
		String url8 = "http://datume.com/vv/dd?tab=1&tab=2&query=keyword";
		String url9 = "http://datume.com/vv/dd?tab=1&tab=2&query=keyword&id=2323&tab=2";
		
		
		System.out.println(URLUtils.reformNextUrl(url8));
	}
}
