package SundarMaven.MavenProjEclipse;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_c2_req {

	@SuppressWarnings("unchecked")
	@Test
	void sample2() throws IOException {
		
		apiBaseClass BC = new apiBaseClass();
		BC.configFilObj();
		String token = BC.authenticateAPI();
		BC.exelObj();
		String b[][] = BC.getMyArray("Sheet1");		
		
		//RestAssured.baseURI=BC.getValue("baseURI2test");
		
		RestAssured.baseURI="https://apollo.talentoz.com/api/api/CompanyBank/";
		
		RequestSpecification a=RestAssured.given();
		
		JSONObject parameters = new JSONObject();
		parameters.put(b[0][0], b[0][1]);
		parameters.put(b[1][0], b[1][1]);
		parameters.put(b[2][0], b[2][1]);
		parameters.put(b[3][0], b[3][1]);
		parameters.put(b[4][0], b[4][1]);
		parameters.put(b[5][0], b[5][1]);
		
		a.header("Content-Type","application/json");
		a.body(parameters.toJSONString());
		
		Response response = a.auth().oauth2(token).request(Method.POST,"/SaveCompanyBank");
		
		String responsebody = response.getBody().asPrettyString();
		System.out.println(responsebody);
		
		/*String xxx = response.jsonPath().get("companyBankId");
		String VVV = new String(xxx);*/
		
		int statuscode = response.getStatusCode();
		System.out.println("Your Status code is:\t" +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		String successcode = response.jsonPath().get("message");
		Assert.assertEquals(successcode, "Company Bank Detail Saved Successfully");
		
		System.out.println("The response time is");
		System.out.println(response.time());
		
	}
	
}
