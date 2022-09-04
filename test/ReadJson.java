package org.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fileread = new FileReader("C:\\Users\\Welcome\\eclipse-workspace\\Api\\src\\test\\resources\\File.JSON");
		JSONParser parser = new JSONParser();
		   Object object = parser.parse(fileread);
		   
		   JSONObject jsonObj = (JSONObject) object;
		   
		   Object data = jsonObj.get("data");
		   System.out.println(data);
		   
		   JSONObject datas =(JSONObject) data;
		   Object id = datas.get("id");
		   System.out.println(id);
		   
		   Object email = datas.get("email");
		   System.out.println(email);
		   
		   Object fName = datas.get("first_name");
		   System.out.println(fName);
		   
		   Object lName = datas.get("last_name");
		   System.out.println(lName);
		   
		   Object avatar = datas.get("avatar");
		   System.out.println(avatar);
		   
          Object support = jsonObj.get("support");
          System.out.println(support);
          
          JSONObject readSupport = (JSONObject) support;
          Object url = readSupport.get("url");
          System.out.println(url);
          
          Object text = readSupport.get("text");
          System.out.println(text);
	}

}
