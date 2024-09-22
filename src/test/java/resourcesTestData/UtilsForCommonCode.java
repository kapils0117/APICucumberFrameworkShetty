package resourcesTestData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UtilsForCommonCode {
	//In this class we will write generic/ common & Reusable code which can be used by different API'S like 
	public static RequestSpecification requ;// requ variable will be shared among all test cases so it will not be treated a sNULL when second test case will start running
	public RequestSpecification requestSpecification() throws IOException {
// Here w're using one login if(requ==null) then return it, bocz if we dont do this then it will only display last params data n values means it will replace first test case data 		
//Here if we dont apply this IF logic then it will create multiple LOG files , n replace previous files but we want to update only inside single file so all request will use that GET , Delete, etc..		
		//Creating object of Stream class, here one new file will be created automatically and will store all logs and print request and response
		//Need to refresh the project after run to see new log file
		//FileOutputStream fo=new FileOutputStream("loggin.txt");
		//PrintStream ps=new PrintStream(fo);
		//FileOutputStream is used to write the file and FileInputStream is used to read the file
		//We're calling static method "getGlobalValue" below & providing one arg "baseuri" so by this way we're preventing to provide any hardcoded key from property file
		if(requ==null) { //We're preventing it to run again for GET and DELETE api request
		PrintStream ps=new PrintStream(new FileOutputStream("loggin.txt"));
		requ=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
//here we're calling LOGGIN method and it will log everything request and response
				 .addFilter(RequestLoggingFilter.logRequestTo(ps))
				 .addFilter(ResponseLoggingFilter.logResponseTo(ps))
				 .setContentType(ContentType.JSON).build();
		 return requ;
		}
		return requ;
	}
	public static String getGlobalValue(String key) throws IOException {
		Properties prop=new Properties();
	//Properties method can read/scan any value from property file
		//FileInputStream is used to read the file
	FileInputStream fi=new FileInputStream("C:\\Users\\KSHARM23\\eclipse-workspace\\APILatestFramework\\src\\test\\java\\resourcesTestData\\global.properties");
	prop.load(fi);         //Used to load the file
	return prop.getProperty(key);
	}
	//Creating generic method for JSON path
	public String getJsonPath(Response responsespec23, String key) {
		String resp= responsespec23.asString();
		JsonPath js= new JsonPath(resp);
		//It will return as any param value of GET request
		//return js.get(key).toString();
		Object value = js.get(key);
	    
	    if (value == null) {
	        System.out.println("The key '" + key + "' does not exist in the response.");
	        return null; // Or handle accordingly, such as throwing an exception or returning an empty string
	    } else {
	        return value.toString();
	    }
	}
	}
	


