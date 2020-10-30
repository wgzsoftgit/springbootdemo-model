package com.demomodel.P7.daima.switchs;

public class switchDemo1 {



private  String createPlayer1(PlayerTypes playerType) {
    switch (playerType) {
       case TENNIS:
           return "网球运动员费德勒";
       case FOOTBALL:           
    	   return "足球运动员C罗";
        case BASKETBALL:
            return "篮球运动员詹姆斯";
        case UNKNOWN:
            throw new IllegalArgumentException("未知");
        default:
            throw new IllegalArgumentException(
                    "运动员类型: " + playerType);

    }


}
}
