package api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;


public class ApiDemo {

	public static void main(String[] args) {
		
	
		
		// TODO Auto-generated method stub
		//given - all the inputs detail
		//when - submit the api -resource or path and http method 
		//then - validate the response
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json").body(payload.AddPlace()).when().post("maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		
//		String response = "83841f959ac9cb71842d53c8965b65c4";
		JsonPath js = new JsonPath(response);
		String placeId = js.get("place_id");
		String newAddress = "98544 washington dc";
		given().queryParam("key", "qaclick123").header("Content-type","application/json").body("{\n"
				+ "	\"place_id\": \""+placeId+"\",\n"
				+ "	\"address\": \""+newAddress+"\",\n"
				+ "	 \"key\": \"qaclick123\"\n"
				+ "}\n"
				+ "").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200);
		
		String seeplaces = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(seeplaces);
		String actualAdress = js1.get("address");
		System.out.println(actualAdress);
		
		Assert.assertEquals(actualAdress, newAddress);
		
		

//	}
	    RestAssured.baseURI = "http://localhost:8080";
		SessionFilter session = new SessionFilter();
		given().header("Content-type","application/json").body("{ \"username\": \"abel\", \"password\": \"sasa2014\" }")
		.filters(session).post("http://localhost:8080/rest/auth/1/session")
		.then().log().all().statusCode(200);
//		
		given().pathParam("key", "10005").header("Content-type","application/json").body("{\n"
				+ "	\"body\":\"The comment from restassured\"\n"
				+ "}")
		.filter(session).when().post("/rest/api/2/issue/{key}/comment")
		.then().log().all().statusCode(201);
	}
	
	

}
