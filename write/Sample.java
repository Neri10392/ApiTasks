package org.write;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
	
	
	File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\Api\\src\\test\\resources\\cc.JSON");
	
	ObjectMapper mappper = new ObjectMapper();
	
	Employ e = new Employ("balaji", "fgh", 985426526l);
	    mappper.writeValue(file, e);
	
}
}