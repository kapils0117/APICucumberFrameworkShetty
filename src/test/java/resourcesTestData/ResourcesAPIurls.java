package resourcesTestData;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
//We're not going to use this class in framework as we will use ENUM class concepts
//Now these method we can call in when()
// respspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//responsespec2= response1.when().post("maps/api/place/add/json").then().spec(respspec).extract().response();

//ResourcesAPIurls obj=new ResourcesAPIurls();
//responsespec2= response1.when().post(obj.addPlaceAPI).then().spec(respspec).extract().response();
public class ResourcesAPIurls {
// This is the first method where we're creating variables of API resources and then use them by creating object of this class.
	String addPlaceAPI= "/maps/api/place/add/json";
	String getPlaceAPI= "/maps/api/place/get/json";
	String deletePlaceAPI= "/maps/api/place/delete/json";

	public String getAddPlaceAPI() {
		return addPlaceAPI;
	}
	
	public String getPlaceAPI() {
		return deletePlaceAPI;
	}
	
	public String deleteAddPlaceAPI() {
		return deletePlaceAPI;
	}
	

}
