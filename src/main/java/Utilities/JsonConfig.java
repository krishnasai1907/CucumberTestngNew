package Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonConfig {

	public static String readJson(String key)
	{
		JSONParser jsonparser=new JSONParser();
		String value="";
		try {
			FileReader fis=new FileReader(new File(".\\src\\test\\resources\\JSONText.json"));
			JSONObject jsonObj=(JSONObject) jsonparser.parse(fis);
			 value=(String) jsonObj.get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	@SuppressWarnings("unchecked")
	public static void writJson(String key,String value)
	{
		
		try {
			JSONObject obj=new JSONObject();
			obj.put(key, value);
			FileWriter fiw=new FileWriter(".\\src\\test\\resources\\JSONText.json",true);
			 fiw.write(obj.toString());
			 fiw.close();
			 System.out.println("Key and Value saved in JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
