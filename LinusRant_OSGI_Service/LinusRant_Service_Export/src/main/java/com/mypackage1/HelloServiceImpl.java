package com.mypackage1;

import java.util.Date;
public class HelloServiceImpl implements HelloService {

	@Override
	public String helloAll() {
		try {
			String json = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
			JsonFactory jfactory = new JsonFactory();
JsonParser jParser = jfactory.createParser(json);
String parsedName = null;
Integer parsedAge = null;
List<String> addresses = new LinkedList<>();
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
		}

       return new Date()+" ";
	}

}
