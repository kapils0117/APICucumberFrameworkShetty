package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LocationPojo17;
import pojo.PojoForClass17;
import resourcesTestData.EnumAPIResources;
import resourcesTestData.TestData;
import resourcesTestData.UtilsForCommonCode;


public class OptimizedTestDataAddPlace2 extends UtilsForCommonCode{

	RequestSpecification response1;
	ResponseSpecification respspec;
	Response responsespec2;
	
	static String placeIdd; // so that all methods can share this place id , if we need to use this place id in single method then no need to declare as static
	static String status1;
	static String scope1;
	
 
	 //Here we called Testdata class payload method and also we created TestData class object first here above Given annotation to call method by object
	TestData testdata=new TestData();

//	@Given("Add Place Payload")
//	public void add_place_payload() throws IOException {
		@Given("Add Place Payload with {string} {string} {string}")
		public void add_place_payload_with(String name,String language,String address) throws IOException {
			response1 = given().spec(requestSpecification())
					.body(testdata.addPlacePayload(name,language,address));

	}
		@When("User calls {string} with {string} http request")
		public void user_calls_with_http_request(String resource, String APIMethod) {
	   // Here we will write POST method code only means when() keyword code where we send the POST request 
		 //Here we're calling enum class constructor and it will set resource as 
		EnumAPIResources apires=EnumAPIResources.valueOf(resource);
		apires.getResource(); // This will has addPlaceAPI resource value 
		System.out.println(apires.getResource());
		 respspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 if(APIMethod.equalsIgnoreCase("POST")) {
			 //We will only hit POST request in this method and will not do validation so we will put then() inside @Then annotation
			 responsespec2= response1.when().post(apires.getResource());
		 }
		 else if(APIMethod.equalsIgnoreCase("GET")) {
			 responsespec2= response1.when().get(apires.getResource());// here we're using .get(apires.getResource()

		 }
			/*
			 * String resp = responsespec2.asString();
			 * System.out.println("Response is latest: " + resp);
			 */
		 
		//responsespec2= response1.when().post("maps/api/place/add/json").then().spec(respspec).extract().response();
//Declare above variable globally
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		//then().spec(respspec).extract().response();
	assertEquals(responsespec2.getStatusCode(),200); 
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String keyeExpectedvalue) {
		//Now below we can call Json path method directly which we made generic in UTIL class and we ll provide 2 arg Response , key value
		assertEquals(getJsonPath(responsespec2, keyvalue), keyeExpectedvalue);
		
		
		String status1= getJsonPath(responsespec2, "status"); 
			  String scope1=getJsonPath(responsespec2, "scope");
			  
			  System.out.println("latest status" +"" + status1);
			  System.out.println("latest status" +"" + scope1);
		
	}
	@Then("verify placeId created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String resource) throws IOException {
		//Here we will use GET request so firstly we require request url, resources and query params which we stored in generic class "UtilsForCommonCode" 
		//To hit the get api we also need place_id which we got from POST api and we will get the place_id
		//getting place id
           placeIdd=getJsonPath(responsespec2, "place_id");
		response1 = given().spec(requestSpecification()).queryParam("place_id",placeIdd);
//Below we're calling above method and passing GET method which will execute as per If else condition and call resource "getPlaceAPI" resource value
		user_calls_with_http_request(resource,"GET");
		String Actualname=getJsonPath(responsespec2, "name");
		assertEquals(Actualname, ExpectedName);
		
		
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		response1=given().spec(requestSpecification()).body(testdata.deletePlacepayload(placeIdd));
		
	}




		}
		



