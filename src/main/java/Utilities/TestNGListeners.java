package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class TestNGListeners implements ITestListener{


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stsub
		System.out.println("================All Files are loaded================"+context.getName());
//		Utility.startVideo();
		try {
			ScreenRecorderUtil.startRecord("TestVideo");
			 System.out.println("**********Recording Started************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================Execution Started================"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================Execution Sucess================"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("\n================Execution Failed================"+result.getName());
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
		File DesFile=new File(directory.toString()+"\\Failed "+str+".png");
		try {
			Files.copy(srcFile, DesFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********FailedScreenshot Captured**********");
//		Utility.stopVideo();
		try {
			ScreenRecorderUtil.stopRecord();
			 System.out.println("\n\n**********Recording Ended************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility.driver.close();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================Execution Test Skipped================"+result.getName());
		Utility.driver.close();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================On Test Failed Within Sucess================"+result.getName());
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		Utility.stopVideo();
		try {
			 System.out.println("\n\n**********Recording Ended************");
			ScreenRecorderUtil.stopRecord();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("================Execution Finished================"+context.getName());
	}

}
