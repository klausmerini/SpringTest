package com.merini.springmysqldemo;

import org.json.JSONException;
import org.json.JSONObject;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import org.json.simple.JSONObject;
//import org.testng.annotations.Test;

public class GetPostExamlples 
{
	
	private String baseURI="https://reqres.in/api";
	private String baseURI2= "https://gorest.co.in/public/v1/users";

//	@Test
	public void testGet ()
	{
		System.out.println();
		System.out.println("testGet ()");
		given().
			get(baseURI+"/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George"))
			.log().all();
	}
	
//	@Test
	public void testPost ()
	{
		System.out.println();
		System.out.println("testPost ()");
		Date date = new Date();
		String st = String.valueOf(date.getTime());
		JSONObject request = new JSONObject();
		
		try {
			request.put("name", "Kl Merini Castro");
			request.put("gender", "male");	
			request.put("email", "dominick.de.castro"+st+"@yahoo.com.BR");
			request.put("status", "active" );					} 
		catch (JSONException e) {
			e.printStackTrace();		}
	
		System.out.println(request.toString());
		
		given().
			header("Content-Type", "application/json").
			header("Authorization","Bearer d6ec6fe537e854970660ae39a38535fa64c783f22d763f66331e11ebe76089e0").
			body(request.toString()).
		when().
			post(baseURI2).
		then().
			statusCode(201).log().all();
	}
	

}
