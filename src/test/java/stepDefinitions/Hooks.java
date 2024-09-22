package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
   @Before("@deletePlace")// means firstly it will execute this method prior @deletePlace tag provided in step def file
	public void beforescenario() throws IOException {
	//execute this code only when place_Id is null
	  //write a coe that will give you place id, so here we will call all methods of step def and provide arguments
// to call step def methods we need to create first object of stef def class
	   OptimizedTestDataAddPlace2 op= new OptimizedTestDataAddPlace2();
	   if(OptimizedTestDataAddPlace2.placeIdd==null) {// place_id is static variable so we're calling it thru classname.var name
	   op.add_place_payload_with("kapil", "Hinglish", "India");
	   op.user_calls_with_http_request("AddPlaceAPI", "POST");
	   op.verify_place_id_created_maps_to_using("kapil", "getPlaceAPI");
		
	}
}
}