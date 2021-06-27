package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utility {

	
	public static Map<Object,Object> SharedData=new TreeMap<Object, Object>();
	public static WebDriver driver;
//	public static ATUTestRecorder recorder;
	//it will remove
	public static void getFullScreentshot()
	{
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		LocalDateTime date=LocalDateTime.now();
		String str=date.format(format);
		File directory = new File(".\\Reports\\ExecutionImages");
	    if(!directory.exists())
	    {
	       if(directory.mkdirs())
	       {
	          System.out.println("Sub directories created");
	       }
	       else
	       {
	          System.out.println("Sub directories not created");
	       }
	    }
		try {
			ImageIO.write(screenshot.getImage(), "jpg", new File(directory.toString()+"\\FullImage "+str+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********FullScreenshot Captured**********");
	}
	public static void getScreenshot()
	{
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		LocalDateTime date=LocalDateTime.now();
		String str=date.format(format);
		File directory = new File(".\\Reports\\ExecutionImages");
	    if(!directory.exists())
	    {
	       if(directory.mkdirs())
	       {
	          System.out.println("Sub directories created");
	       }
	       else
	       {
	          System.out.println("Sub directories not created");
	       }
	    }
		File srcFile=((TakesScreenshot)Utility.driver).getScreenshotAs(OutputType.FILE);
		File DesFile=new File(directory.toString()+"\\Normalimage "+str+".png");
		try {
			Files.copy(srcFile, DesFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********NormalScreenshot Captured**********");
	}
//	public static void startVideo()
//	{
//		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//		  Date date = new Date();
//		  //Created object of ATUTestRecorder
//		  //Provide path to store videos and file name format.
//		  File directory = new File(".\\Reports\\ExecutionVideos");
//	      if(!directory.exists())
//	      {
//	         if(directory.mkdirs())
//	         {
//	            System.out.println("Sub directories created");
//	         }
//	         else
//	         {
//	            System.out.println("Sub directories not created");
//	         }
//	      }
//		  try {
//			recorder = new ATUTestRecorder(directory.toString(),"TestVideo-"+dateFormat.format(date),false);
//			  //To start video recording.
//			  recorder.start();  
//		} catch (ATUTestRecorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		  System.out.println("**********Recording Started************");
//	}
//	public static void stopVideo()
//	{
//		try {
//			recorder.stop();
//		} catch (ATUTestRecorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		 System.out.println("\n\n**********Recording Ended************");
//	}
}
