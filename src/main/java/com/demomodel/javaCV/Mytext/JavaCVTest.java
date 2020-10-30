package com.demomodel.javaCV.Mytext;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.FrameGrabber.Exception;

import javax.swing.*;
import java.util.EnumSet;

/**
 * JAVA中通过JavaCV实现跨平台视频/图像处理-调用摄像头
 * 　JavaCV使用来自计算机视觉领域(OpenCV, FFmpeg, libdc1394, PGR FlyCapture, OpenKinect, 
 * librealsense, CL PS3 Eye Driver, videoInput, ARToolKitPlus, flandmark,
Leptonica, and Tesseract)领域的研究人员常用库的JavaCPP预设的封装。提供实用程序类，
使其功能更易于在Java平台上使用，包括Android。
 * @author wgz
 * @date 创建时间：2020年7月1日 上午11:06:47
 */
public class JavaCVTest {
	
    public static void main(String[] args) throws Exception, InterruptedException {

    	testCamera();
    	//testCamera1();
	}
    public static void testCamera() throws InterruptedException, FrameGrabber.Exception {
    	//0表示本机摄像头 当然这里也可以换成网络摄像头地址
    	OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);////窗口关闭时程序运行结束
        canvas.setAlwaysOnTop(true);
        while (true) {
            if (!canvas.isDisplayable()) {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(-1);//退出
            }
//是一个用于管理音频和视频帧数据的类。 在CanvasFrame、FrameGrabber、FrameRecorder及他们的子类里面都有用到。
            Frame frame = grabber.grab();//表示从帧收集器里面抓去最新的帧

            canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            Thread.sleep(50);//50毫秒刷新一次图像
        }
    }

     
    public static void testCamera1() throws FrameGrabber.Exception, InterruptedException {
        VideoInputFrameGrabber grabber = VideoInputFrameGrabber.createDefault(0);
        grabber.start();
        CanvasFrame canvasFrame = new CanvasFrame("摄像头");
        canvasFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvasFrame.setAlwaysOnTop(true);
        while (true) {
            if (!canvasFrame.isDisplayable()) {
                grabber.stop();
                System.exit(-1);
            }
            Frame frame = grabber.grab();
            canvasFrame.showImage(frame);
            Thread.sleep(30);
        }
    }
}