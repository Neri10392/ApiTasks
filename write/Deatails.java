package org.write;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deatails {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		
		File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\Api\\src\\test\\resources\\write.JSON");
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Courses> courses = new ArrayList<Courses>();
		Courses c = new Courses("mani", "java", "thanjai");
		Courses c1 = new Courses("vj", "phyton", "periyakkotai");
		Courses c2 = new Courses("neri", "c#", "thanjai");
		
		courses.add(c);
		courses.add(c1);
		courses.add(c2);
		
      Employee e = new Employee("Neriyarasan", "neriyrasan@gmail.com", 9944847248l, courses );
		
		
		mapper.writeValue(file, e);
		

	}}