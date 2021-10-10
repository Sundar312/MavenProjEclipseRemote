package SundarMaven.MavenProjEclipse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TC001_c1_req {
	
	@Test
	void sample(){
		
		//Authenticate the request
		apiBaseClass apiBaseClass = new apiBaseClass();
		apiBaseClass.configFilObj();
		String token = apiBaseClass.authenticateAPI();
		
		//Declare base URI
		RestAssured.baseURI=apiBaseClass.getValue("baseURI2test");
		
		//Send the request
		RequestSpecification a =RestAssured.given();
		
		//Get the response and store it in a variable
		Response response = a.auth().oauth2(token).request(Method.GET,"/10");
		
		//Get the Responses received so far
		String resbody = response.getBody().asPrettyString();
		System.out.println("Response body is:\t" +resbody);
		
		JsonPath CompanyBankID = response.jsonPath();
		String CompBankID = CompanyBankID.get("companyBankId");
		System.out.println(CompBankID);
		
		Headers headers = response.headers();
		System.out.println("*******Headers*******");
		System.out.println(headers);
		
		//check the status code
		int statuscode = response.getStatusCode();
		System.out.println("Status code is:\t" +statuscode);
		Assert.assertEquals(200, statuscode);
		
		//check the status line
		String statusline = response.getStatusLine();
		System.out.println("Status line is:\t" +statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", statusline);
		
	}

}
