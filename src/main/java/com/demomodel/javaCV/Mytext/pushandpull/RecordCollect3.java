package com.demomodel.javaCV.Mytext.pushandpull;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;

//拉流端代码实现
public class RecordCollect3 {

	
	  public static void frameRecord(String inputFile, String outputFile, boolean AUDIO_ENABLED)  
	            throws Exception, org.bytedeco.javacv.FrameRecorder.Exception {  
	        // 是否录制音频  
	        int audioChannel = AUDIO_ENABLED ? 1 : 0;  
	        // 获取视频源  
	        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputFile);  
	        // 流媒体输出地址，分辨率（长，高），是否录制音频（0:不录制/1:录制）  
	        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputFile, 1280, 720, audioChannel);  
	        // 开始取视频源  
	        recordByFrame(grabber, recorder, AUDIO_ENABLED);  
	    }    
	  private static void recordByFrame(FFmpegFrameGrabber grabber, FFmpegFrameRecorder recorder, Boolean status)  
	            throws Exception, org.bytedeco.javacv.FrameRecorder.Exception {  
	        try {  //建议在线程中使用该方法  
	        	
	            grabber.start();  
	            recorder.start();  
	            Frame frame = null;  
	            while (status && (frame = grabber.grabFrame()) != null) {  
	                recorder.record(frame);  
	            }  
	            recorder.stop();  
	            grabber.stop();  
	        } finally {  
	            if (grabber != null) {  
	                grabber.stop();  
	            }  
	        }  
	    }  
	  
	  
	  public static void main(String[] args)  
	            throws Exception {  
	  
	         String inputFile = "D:\\chrome-download\\shznews1125-2.mp4";  ///Users/codingBoy/Desktop/picture/camera/output.mp4
	         // Decodes-encodes  
	         String outputFile = "D:\\chrome-download\\recorde.mp4";  ///Users/codingBoy/Desktop/picture/camera/recorde.mp4
	         frameRecord(inputFile, outputFile,true);  
	}  
}