package SundarMaven.MavenProjEclipse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_c4 {
	
	@Test
	public void deleteFields() {
		
		apiBaseClass apiBaseClass = new apiBaseClass();
		apiBaseClass.configFilObj();
		String token = apiBaseClass.authenticateAPI();
		
		RestAssured.baseURI="https://apollo.talentoz.com/api/api/CompanyBank/DeleteCompanyBank/1";
		
		RequestSpecification a=RestAssured.given();
		
		a.header("Content-Type", "application/json");
		Response response = a.auth().oauth2(token).request(Method.DELETE,"/57");
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String message = response.jsonPath().get("message");
		Assert.assertEquals(message.contains("Company Bank deleted successfully"), true);
		
		
		
		
	}

}
