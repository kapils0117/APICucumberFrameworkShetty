package resourcesTestData;

import java.util.ArrayList;
import java.util.List;

import pojo.LocationPojo17;
import pojo.PojoForClass17;

public class TestData {

	
public PojoForClass17 addPlacePayload(String name, String language, String address) {
		
	//we will call this method in Step definition file and call this payload and pass this payload object in body

		PojoForClass17 obj = new PojoForClass17();//here we've to create object of parent pojo class to call 8 setter methods here
		obj.setAccuracy(55);
		obj.setAddress(address);
		obj.setLanguage(language);
		obj.setName(name);
		obj.setPhone_number("1234567890");
		obj.setWebsite("www.rahulshettyacademy.com");
					
		List<String> types2=new ArrayList<String>();
		types2.add("shoe park");
		types2.add("shop");
		obj.setTypes(types2);
		
		LocationPojo17 obj2= new LocationPojo17();// here we've to create object of Location pojo class to call setter methods here
		obj2.setLat(-12);
		obj2.setLng(45);
		obj.setLocation(obj2);// here we're passing obj of LocationPojo17 class and the object "obj2" has values we provided 
	     return obj; // Here we have to use this payload data in other class so we're returning this to use further and changing from void to class name(PojoForClass17
	
	}

//To make this place id dynamic we will define one variable and then we can use it at run time instead of providing hard coded place id value
   public String deletePlacepayload(String placeIds) {
	 //  return "{\r\n\"place_id\":\"f0203225724e877dad28ed334661f814\"\r\n}";
	   return "{\r\n\"place_id\":\""+placeIds+"\"\r\n}";
   }

}
