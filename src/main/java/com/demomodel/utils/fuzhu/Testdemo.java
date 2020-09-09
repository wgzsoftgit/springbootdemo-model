package com.demomodel.utils.fuzhu;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.Random;
//RPG  游戏
//点击  计算屏幕尺寸差异
public class Testdemo {

	public static void main(String[] args) throws AWTException {
		Robot robot=new Robot(); //创建一个java机器人对象
		Random random=new Random();
		robot.delay(5000);// 延迟5s
		
		robot.mouseMove(1255, 745);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      getScreenSize();//计算屏幕尺寸差异
     
//		while(true) {
//			//按下鼠标
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			//按下弹起的时间不一定是0,3秒，而是一个随机数字   3秒钟
//			double v=0.3+random.nextDouble()*(0.6-0.3);
//			v=v*1000;
//			System.err.println(v);
//           robot.delay((int)v);
//           
//           //弹起鼠标
//           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//           
//         //按下弹起的时间不一定是0,3秒，而是一个随机数字   3秒钟
//			double v2=3+random.nextDouble()*(6-3);
//			v2=v2*1000;
//			System.err.println(v2);
//          robot.delay((int)v2);
//			
//		
//		}
		
	}
	
	
	public static void getScreenSize(){
		 // 计算屏幕尺寸差异
		   double different;
		   // 计算真实的屏幕比例
		   GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		   // 计算缩放比例为100%情况下的屏幕尺寸
		   Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
		   // 差异对比计算
		   double different1 = gd.getDisplayMode().getWidth() / di.getWidth();
		   double different2 = gd.getDisplayMode().getHeight() / di.getHeight();
		   if(different1 == different2) {
				different = different1;
				System.err.println("相等");
		   }
	}
}
