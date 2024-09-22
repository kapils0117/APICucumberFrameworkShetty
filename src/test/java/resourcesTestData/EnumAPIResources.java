package resourcesTestData;

public enum EnumAPIResources {

	//Define mthods in enum which takes one arguments. Enum treats it as a method with one arg and that will return this string value, we dont need to provide paranthesis n body
	//In feature file we only need to set method like AddPlaceAPI, getPlaceAPI and API request like Post, GET, DELETE
	AddPlaceAPI("maps/api/place/add/json"),// value of AddPlaceAPI is maps/api/place/add/json = resource, 

	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
   private String resource;
	//Here need to declare one constructor with class name
	//The argument if AddPlacePi i.e "maps/api/place/add/json" will fall here below in constructor as "Resource"
   
   //Here we're assigning local variable value to the global/class variable resource and then returning it to use in Step definition class under When() keyword
	EnumAPIResources(String resource){
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}
	
	/*//String addPlaceAPI= "/maps/api/place/add/json";
public String getAddPlaceAPI() {
		return addPlaceAPI;
	}*/
	
	
}
