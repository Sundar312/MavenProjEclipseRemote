package SundarMaven.MavenProjEclipse;

import java.io.IOException;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiBaseClass {
	
	apiConfigSupport apiConfigSupport;
	apiExcelSupport apiExcelSupport;
		
	public apiExcelSupport exelObj() throws IOException {	
	    apiExcelSupport = new apiExcelSupport();
		return apiExcelSupport;
	}

	public void configFilObj() {
		 apiConfigSupport = new apiConfigSupport();
	}
	
	public String getValue(String Key) {
		String value = apiConfigSupport.getKeyValue(Key);
		return value;
	}
	
	public String [][] getMyArray(String sheetname){
		int rc = apiExcelSupport.rowcount(sheetname);
		String a[][] = new String[rc][3];		
		for(int i=2;i<rc;i++) {
			for(int j=1;j<3;j++) {
				a[i-2][j-1]=apiExcelSupport.getStringData(sheetname, i, j);
			}
		}
		return a;
	}
		
	@SuppressWarnings("unchecked")
	public String authenticateAPI() {	
			
		RestAssured.baseURI=apiConfigSupport.getKeyValue("authbaseURI");	
		RequestSpecification request = RestAssured.given();
		
		JSONObject params = new JSONObject();
		params.put("email", apiConfigSupport.getKeyValue("authemail"));
		params.put("password", apiConfigSupport.getKeyValue("authpassword"));
		params.put("id", "0");
		
		request.header("Content-Type","application/json");
		request.body(params.toJSONString());
		
		Response response = request.request(Method.POST, "/Login");
		
		System.out.println(response.jsonPath().get("token"));
		String token = response.jsonPath().get("token");
		return token;
	}
}
