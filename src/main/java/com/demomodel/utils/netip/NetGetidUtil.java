package com.demomodel.utils.netip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetGetidUtil {
	
public static void main(String[] args) {
	System.err.println(getLocalIp());
}
	public static String getLocalIp(){
		String ipAddress = "127.0.0.1";
		Enumeration<NetworkInterface> netInterfaces = null;  
		try {  
		    netInterfaces = NetworkInterface.getNetworkInterfaces();  
		    while (netInterfaces.hasMoreElements()) {  
		        NetworkInterface ni = netInterfaces.nextElement();   
		        Enumeration<InetAddress> ips = ni.getInetAddresses();  
		        while (ips.hasMoreElements()) { 
		        	String hostAddress = ips.nextElement().getHostAddress();
		        	if(hostAddress.indexOf(".")>-1){
		        		if(!hostAddress.equals(ipAddress)){
		        			ipAddress = hostAddress ;
		        			return ipAddress;
		        		}
		        	}
		        }  
		    }  
		} catch (Exception e) {  
		    e.printStackTrace();  
		} 
		return ipAddress;
	}
}
