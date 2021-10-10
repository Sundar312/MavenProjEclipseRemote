package SundarMaven.MavenProjEclipse;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class e2eTest {
	
	@SuppressWarnings("unchecked")
	@Test
	void e2eTesting() throws IOException {
		
		apiBaseClass apiBaseClass = new apiBaseClass();
		
		apiExcelSupport es = apiBaseClass.exelObj();
		//apiConfigSupport cs = apiBaseClass.configFilObj();
				
		RestAssured.baseURI="http://apollo.talentoz.com/api/api/CompanyInformation/GetCompanyList";		
		RequestSpecification rs = RestAssured.given();	
		
		//Getting an Existing record
		Response res = rs.request(Method.GET, "/1");
		System.out.println("Launched the Get request");
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("********Headers**********");
        Headers h = res.headers();
        System.out.println(h);
        
        //Posting a record
        RequestSpecification rq1 = RestAssured.given();
        
        JSONObject param1 = new JSONObject();
        param1.put("clientId", "6");
        param1.put("companyId", "17");
        param1.put("companyName", "SOLAR");
        param1.put("state", "MINNESOTA");
        param1.put("city", "FLORIDA");
        param1.put("postalCode", "123123");
        param1.put("phoneNumber", "7775558877");
        
        rq1.header("Content-Type","application/json");
        rq1.body(param1.toJSONString());
        Response resp1 = rq1.request(Method.POST,"/UpdateCompanyInformation");
        System.out.println("Launched the post request");
        Assert.assertEquals(resp1.statusCode(), 200);
        Assert.assertEquals(resp1.body().asString().contains("ClientID"), true);
        System.out.println("Body after new record insert:\t" +resp1.body().asString());
        
        //Update the record
        RequestSpecification rq2 = RestAssured.given();
        param1.put("clientId", "6");
        param1.put("companyId", "17");
        param1.put("companyName", "SUPERNOVA");
        
        rq2.header("Content-Type","application/json");
        rq2.body(param1.toJSONString());
        Response resp2 = rq2.request(Method.POST,"/UpdateCompanyInformation");
        System.out.println("Launched the post request");
        
        JsonPath jp1 = resp2.jsonPath();
        System.out.println(jp1.get("companyName"));
        Assert.assertEquals(resp2.statusCode(), 200);
        Assert.assertEquals(resp2.body().asString().contains("ClientID"), true);
        System.out.println("Body after updation:\t" +resp2.body().asString());
        
        //Delete the record
        RequestSpecification rq3 = RestAssured.given();
        rq3.header("Contect-Type","application/json");
        Response resp3 = rq3.request(Method.DELETE,"/1/17");
        System.out.println("Launched the Delete request");
        JsonPath jp2 = resp3.jsonPath();
        System.out.println(jp2.get("companyName"));
        Assert.assertEquals(resp3.statusCode(), 200);
        Assert.assertEquals(resp3.body().asString().contains("ClientID"), true);
        System.out.println("Body after deletion:\t" +resp3.body().asString());
        }

}
