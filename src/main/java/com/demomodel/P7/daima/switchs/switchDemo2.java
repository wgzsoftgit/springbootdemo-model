package com.demomodel.P7.daima.switchs;

import com.sun.star.lang.IllegalArgumentException;

public class switchDemo2 {

	public String creaswitch2(PlayerTypes playerType2) throws IllegalArgumentException {
		   String player = null;
	   	switch (playerType2) {
	           case TENNIS:
	           	player = "网球运动员费德勒";
	               break;
	           case FOOTBALL:
	           	 player = "足球运动员C罗";
	                break;
	           case BASKETBALL:
	           	 player = "篮球运动员詹姆斯";
	                break;
	           case UNKNOWN:
	               throw new IllegalArgumentException("未知");
	           
	              
	       }
	   	 return player;
	    }
	
}
