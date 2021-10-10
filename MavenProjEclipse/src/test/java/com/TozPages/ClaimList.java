package com.TozPages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.utilities.Excelsupport;

public class ClaimList {
	
	WebDriver driver;
	SoftAssert softassert;
	
	public ClaimList(WebDriver driver) {
		this.driver=driver;
	    softassert = new SoftAssert();
	}
	
	//@FindBy(how=How.XPATH, using="//*[@id='mainmenuHdr8']/a") WebElement claimMenu;
	//@FindBy(how=How.XPATH, using="//*[@id=\'133\']") WebElement ClmList;
	
	public void ViewInClaimList(Excelsupport exsupport, String ReqNo) throws Exception {
		
		WebElement claimMenu = driver.findElement(By.xpath("//*[@id='mainmenuHdr8']/a"));
		Actions A1 = new Actions(driver);
		A1.moveToElement(claimMenu).build().perform();
		System.out.println("*******Clicked Claim Menu*************");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ClmList = driver.findElement(By.xpath("//*[@id=\'133\']"));
		A1.moveToElement(ClmList).perform();
		Thread.sleep(5000);
		ClmList.getText();
		System.out.println("Menu clicked on is:\t" +ClmList.getText());
		softassert.assertTrue(ClmList.getText().contains("Claim List"));
		A1.click(ClmList).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='div_sts_id_container_Team_Trk_ClaimReq_ID_3564']//descendant::button")).click();
		driver.findElement(By.xpath("")).sendKeys(exsupport.getStringData("AppClm", 7, 0));
		driver.findElement(By.xpath("//input[@id='dtpSDatecontainer_Team_Trk_ClaimReq_ID_3564_input']")).clear();
		driver.findElement(By.xpath("//input[@id='dtpSDatecontainer_Team_Trk_ClaimReq_ID_3564_input']")).sendKeys(exsupport.getStringData("AppClm", 7, 1));
		driver.findElement(By.xpath("//input[@id='dtpEDatecontainer_Team_Trk_ClaimReq_ID_3564_input']")).clear();
		driver.findElement(By.xpath("//input[@id='dtpEDatecontainer_Team_Trk_ClaimReq_ID_3564_input']")).sendKeys(exsupport.getStringData("AppClm", 7, 2));
		driver.findElement(By.xpath("//div[@id='btn_filter_container_Team_Trk_ClaimReq_ID_3564']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='PendingclaimGrid_container_Team_Trk_ClaimReq_ID_3564_txt_search']")).sendKeys(ReqNo);
		List<WebElement> columns =driver.findElements(By.xpath("//tr[@id='PendingclaimGrid_container_Team_Trk_ClaimReq_ID_3564mygridtr1']//child::td"));
		System.out.println(columns.size());
		softassert.assertEquals(columns.size(), 7);
		String status=driver.findElement(By.xpath("//tr[@id='PendingclaimGrid_container_Team_Trk_ClaimReq_ID_3564mygridtr1']"
				+ "//child::td[@id='PendingclaimGrid_container_Team_Trk_ClaimReq_ID_3564mygridtr1td5']")).getText();
		softassert.assertEquals(status, "Pending", "Status is not precise");
	}

}
