package SundarMaven.MavenProjEclipse;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_c3_req {
	
	@SuppressWarnings("unchecked")
	@Test
	public void putFields() {
		
		apiBaseClass apiBaseClass = new apiBaseClass();
		apiBaseClass.configFilObj();
		String token = apiBaseClass.authenticateAPI();
		
		RestAssured.baseURI = "https://apollo.talentoz.com/api/api/CompanyBank";	
		
		RequestSpecification rs = RestAssured.given();
		
		rs.header("Content-Type","application/json");
		
		JSONObject params = new JSONObject();
		params.put("clientId", "1");
		params.put("companyBankId", "61");
		params.put("companyId", "13");
		params.put("bankId", "10");
		params.put("branchId", "101");
		params.put("accountNo", "14414000");
		params.put("accountType", "3");
		
		rs.body(params.toJSONString());
		
		Response response = rs.auth().oauth2(token).request(Method.PUT,"/UpdateCompanyBank");
		
		System.out.println("Your status code is:\t" +response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String message = response.jsonPath().get("message");
		Assert.assertEquals(message, "Company Bank Updated Successfully");
		
		
	}

}
