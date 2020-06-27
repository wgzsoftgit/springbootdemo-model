package com.demomodel.utils.netip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetGetidUtil {
	
public static void main(String[] args) throws Exception {
	System.err.println(getLocalIp());
	test2();
}
	public static String getLocalIp(){
		String ipAddress = "127.0.0.1";
		Enumeration<NetworkInterface> netInterfaces = null;  
		try {  
		    netInterfaces = NetworkInterface.getNetworkInterfaces();  
		    while (netInterfaces.hasMoreElements()) {  
		        NetworkInterface ni = netInterfaces.nextElement();  
		        if (ni.isLoopback() || ni.isVirtual() || !ni.isUp()) {
	        		 //用于排除回送接口,非虚拟网卡,未在使用中的网络接口.
	   	          continue;
	   	        } else {
		        Enumeration<InetAddress> ips = ni.getInetAddresses();  
		        while (ips.hasMoreElements()) { 
		        	
		        	
//		        	String hostAddress = ips.nextElement().getHostAddress();
//		        	if(hostAddress.indexOf(".")>-1){
//		        		if(!hostAddress.equals(ipAddress)){
//		        			ipAddress = hostAddress ;
//		        			return ipAddress;
//		        		}
//		        	  }
		        	InetAddress  ip = ips.nextElement();
		        	System.err.println(ip);
		            if (ip != null && ip instanceof Inet4Address) {
		              return ip.getHostAddress();
		            }
		        	
		        	
		   	        }
		        }  
		    }  
		} catch (Exception e) {  
		    e.printStackTrace();  
		} 
		return ipAddress;
	}
	
	public static void test2() 
			   throws Exception {
			      InetAddress addr = InetAddress.getLocalHost();
			      System.out.println("Local HostAddress: "+addr.getHostAddress());
			      String hostname = addr.getHostName();
			      System.out.println("Local host name: "+hostname);
			   }
}
