package com.TozPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.tozTCs.BaseClass;
import com.utilities.Excelsupport;


public class ApplyClaim {
	
	WebDriver driver;
	BaseClass BC = new BaseClass();
	int j;
	
	public ApplyClaim(WebDriver driver) {
		this.driver=driver;			
	}

	//Elements in the Apply claim page
	@CacheLookup
	@FindBy(how=How.XPATH,using="//*[@id='mainmenuHdr8']/a") WebElement claimmenu;
	@FindBy(how=How.XPATH,using="//*[@id='132']") WebElement Applyclaim;
	@FindBy(how=How.XPATH,using="//*[@id='txtCl_Pg_tle_container_Clm_Aply_ClaimEntitlement_ID_2904']") WebElement Purpose;
	@FindBy(how=How.XPATH,using="//input[@id='txtCl_Pg_St_Dte_container_Clm_Aply_ClaimEntitlement_ID_2904_input' and @class='picker']") WebElement FromDate;
	@FindBy(how=How.XPATH,using="//input[@id='txtCl_Pg_ed_Dte_container_Clm_Aply_ClaimEntitlement_ID_2904_input' and @class='picker']") WebElement ToDate;
	@FindBy(how=How.XPATH,using="//*[@id='txtCl_Pg_curr_container_Clm_Aply_ClaimEntitlement_ID_2904']/div/button/span[1]") WebElement currencybtn;
	@FindBy(how=How.XPATH,using="//*[@id='tozbody']/div/div/div/input") WebElement currencySearchbox;
	
	
	public void clickClaimMenu() throws Exception {
		Actions A1 = new Actions(driver);
		A1.moveToElement(claimmenu).build().perform();
		System.out.println("*****Clicked into Claim Menu********");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		A1.moveToElement(Applyclaim).perform();
		Thread.sleep(5000);
		System.out.println("Menu clicked on is:\t" +Applyclaim.getText());
		A1.click(Applyclaim).perform();
		Thread.sleep(5000);	
	}
	
	public String submitClaim() throws Exception {
		String path ="C:\\Java\\Claims data.xlsx";
	    BC.setup(path);
	    Excelsupport exsupport = BC.exsupport;
	    int rowss = exsupport.getPhysicalRowCount("AppClm");
	    System.out.println(rowss);
		System.out.println("Providing the Header details..");
		Purpose.sendKeys(exsupport.getStringData("AppClm", 1, 0));
		FromDate.sendKeys(exsupport.getStringData("AppClm", 1, 1));
		ToDate.sendKeys(exsupport.getStringData("AppClm", 1, 2));
		currencybtn.click();
		currencySearchbox.sendKeys(exsupport.getStringData("AppClm", 1, 3));
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Completed header!!");		
		System.out.println("Started data inside Apply claims form..");
		for(int i=1;i<rowss;i++) {		
		    j=i-1;
		    driver.findElement(By.xpath("//a[@id='divCl_Req_Itm_Add_container_Clm_Aply_ClaimEntitlement_ID_2904']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Clicked btn");
						
			//Values inside the form			
			String clmtype = exsupport.getStringData("AppClm", i, 4);
			driver.findElement(By.xpath("//*[@id=\'cmbCl_Req_typ_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"\']/div/button/span[1]")).click();                          
			driver.findElement(By.xpath("//*[@id=\'cmbCl_Req_typ_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"\']/div/div/div/input")).sendKeys(clmtype);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			String clmdate = exsupport.getStringData("AppClm", i, 5);
			driver.findElement(By.xpath("//*[@id=\'dpkCl_Req_Dte_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"_input\']")).sendKeys(clmdate); 
			System.out.println("Date Provided");
			String clmdte = driver.findElement(By.xpath("//*[@id=\'dpkCl_Req_Dte_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"_input\']")).getText();
			String clmdescrip = exsupport.getStringData("AppClm", i, 6);
			driver.findElement(By.xpath("//textarea[@id='txtCl_Req_Dsc_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"' and @class='gray']")).sendKeys(clmdescrip);
			System.out.println("Description Provided");
			String recdte = driver.findElement(By.xpath("//div[@id='divitm_recdtVal_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"' and @class='col_rht wed2']")).getText();
			if (recdte.equals(clmdte)) {
				System.out.println("Receipt date is similar to Claim date");
			}
			String clmRecno = exsupport.getStringData("AppClm", i, 8);
			driver.findElement(By.xpath("//*[@id=\'txtCl_Recp_No_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"\']")).sendKeys(clmRecno);
			System.out.println("Receipt number provided");
			driver.findElement(By.xpath("//*[@id=\'txtCl_Pjt_vdr_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"\']/div/button")).click();
			//Thread.sleep(2000);
			//WebElement ProjDD =driver.findElement(By.xpath("//*[@id='Select_txtCl_Pjt_vdr_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"']"));
			//driver.findElement(By.xpath("//*[@id=\'txtCl_Pjt_vdr_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"\']/div/button")).click();
			/*Select selectDD = new Select(ProjDD);
			selectDD.selectByVisibleText("Project 1");*/
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Project dropdown clicked");
			driver.findElement(By.xpath("//*[@id=\'divCl_Req_Pgm_pjt_isbill_container_Clm_Aply_ClaimEntitlement_ID_2904_" +j+ "\']")).click();
			driver.findElement(By.xpath("//*[@id=\'txtCl_Req_Amt_container_Clm_Aply_ClaimEntitlement_ID_2904_"+j+"\']")).sendKeys(exsupport.getStringData("AppClm", i, 9));
			driver.findElement(By.xpath("//*[@id=\'btn_Claim_Save_\']")).click();
			Thread.sleep(5000);
		}
		exsupport.closexel();		
		//Selecting approver
		driver.findElement(By.xpath("//*[@id='btn_sl_appr-1810']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='itemWL_112_wl_SA-1']")).click();
		String Approver = driver.findElement(By.xpath("//*[@id='itemWL_112_wl_SA-1']")).getText();
		if(Approver.contains("Venkat")) {
			System.out.println("Approver chosen:\t" +Approver);
		}
		//Assign button
		driver.findElement(By.xpath("//*[@id='Assign_sa_-1']")).click();
		driver.findElement(By.xpath("//*[@id=\"ClaimDeclare_Chk_container_Clm_Aply_ClaimEntitlement_ID_2904\"]")).click();
		System.out.println("Declaration checked");
		//Submit button
		driver.findElement(By.xpath("//*[@id='act_ClaimRequest_container_Clm_Aply_ClaimEntitlement_ID_2904_SUBMIT']")).click();
		driver.findElement(By.xpath("//*[@id='btnYesCofirm']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		Thread.sleep(6000);
		//confirmation text verification
		String vertxt =driver.findElement(By.xpath("//*[@id='fbNewComp_feedback']/div")).getText();
		driver.findElement(By.xpath("//*[@id='fbNewComp_Close']")).click();
		
		if(vertxt.contains("Request submitted for approval successfully.")) {
			System.out.println(vertxt);
		}else {
			System.out.println("No the Statement is:\t" +vertxt);
		}
		
		//Copying the request number and writing to the excel
		String Reqno =driver.findElement(By.xpath("//*[@id=\"divCl_Req_Hdr_Req_Colm_container_Clm_Aply_ClaimEntitlement_ID_2904\"]/div[2]/div[2]")).getText();
		System.out.println("The request number generated:\t" +Reqno);
		String path1 ="C:\\Java\\Claim Output.xlsx";
		exsupport.writeData(path1, "Sheet1", Reqno);
		Thread.sleep(2000);	
		/*JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("window.scrollBy(0,-350)", "");*/
		driver.navigate().refresh();
		Thread.sleep(10000);
		return Reqno;
	}
}
