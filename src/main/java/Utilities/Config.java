package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Config { 
	static Properties prop;
	public static String getProperties(String locName)
	{
		 prop=new Properties();//removed
		 try
		 {
			 String splitted=locName.split("\\.")[0].toString();
			 System.out.println("Splitted Value: "+splitted);
			 FileInputStream fis=new FileInputStream(MainConfig.getProperties(splitted));
	     prop.load(fis);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 String vdalue=prop.getProperty(locName);
			return value;	
			 //not
	}
	
}
