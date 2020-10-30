package com.demomodel.javaCV.Mytext.aviImg;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

/**
 * 取第五帧作为封面
 * 避免出现黑屏
 * @author wgz
 * @date 创建时间：2020年9月26日 下午4:52:34
 */
public class VideoProcessing2 {
	//视频文件路径：
	public static String videoPath = "D:/text/video";

	//存放截取视频某一帧的图片
	public static String videoFramesPath = "D:/text/video/img/";
	/**
	 * 将视频文件帧处理并以“jpg”格式进行存储。
	 * 依赖FrameToBufferedImage方法：将frame转换为bufferedImage对象
	 *
	 * @param videoFileName
	 */
	public static String grabberVideoFramer(String videoFileName){
		//最后获取到的视频的图片的路径
		String videPicture="";
		//Frame对象
		Frame frame = null;
		//标识
		int flag = 0;
		try {
			 /*
            获取视频文件
            */
			FFmpegFrameGrabber fFmpegFrameGrabber = new FFmpegFrameGrabber(videoPath + "/" + videoFileName);
			fFmpegFrameGrabber.start();
			
            //获取视频总帧数
			int ftp = fFmpegFrameGrabber.getLengthInFrames();
			System.out.println("时长 " + ftp / fFmpegFrameGrabber.getFrameRate() / 60);
			
			while (flag <= ftp) {
				frame = fFmpegFrameGrabber.grabImage();
				/*
				对视频的第五帧进行处理
				 */
				if (frame != null && flag==5) {
					//文件绝对路径+名字
					String fileName = videoFramesPath + UUID.randomUUID().toString()+"_" + String.valueOf(flag) + ".jpg";
					
					//文件储存对象
					File outPut = new File(fileName);
					 if (frame != null) {
							ImageIO.write(FrameToBufferedImage(frame), "jpg", outPut);
							
					 }
			
					//视频第五帧图的路径
					String savedUrl = "img_path" + outPut.getName();
					videPicture=savedUrl;
					break;
				}
				flag++;
			}
			fFmpegFrameGrabber.stop();
			fFmpegFrameGrabber.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
		return videPicture;
	}

	public static BufferedImage FrameToBufferedImage(Frame frame) {
		//创建BufferedImage对象
		Java2DFrameConverter converter = new Java2DFrameConverter();
		BufferedImage bufferedImage = converter.getBufferedImage(frame);
		return bufferedImage;
	}


	/**
	 * 测试：
	 * 1、在D盘中新建一个test文件夹，test中再分成video和img，在video下存入一个视频，并命名为test
	 * D:/test/video     D:/test/img
	 * @param args
	 */
	public static void main(String[] args) {
		String videoFileName = "chrome-download.mp4";
		grabberVideoFramer(videoFileName);
	}
}