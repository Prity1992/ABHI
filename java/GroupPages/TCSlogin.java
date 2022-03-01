package GroupPages;


import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;
import util.WaitTime;

public class TCSlogin extends GenericMethods {
	
	
	private By username = By.xpath("//input[@id='login-username']");
	
	
	private By password = By.xpath("//input[@id='password']");
	
	private By loginBTN = By.xpath("//span[contains(text(),'Login')]");
	/*
	 * private By role = By.xpath("//input[@id='textfield4']");
	 * 
	 * 
	  private By loginBTN = By.xpath("//span[contains(text(),'Login')]");
	 * 
	 * 
	 * private By GSTIN = By.xpath(
	 * "//label[contains(text(),'GSTIN')]/parent::div/following-sibling::div/p-autocomplete/span/input"
	 * );
	 * 
	 * 
	 * private By FinancialYear = By.xpath("//select[@id='finyear']");
	 * 
	 * 
	 * private By TaxPayerPeriod = By.xpath("//select[@id='taxper']");
	 * 
	 * 
	 * private By Submit = By.xpath("//button[@type='submit']");
	 * 
	 * private By roleCLICK=By.xpath("//i[@id='roleIcon']");
	 * 
	 * private By Role=By.xpath("//span[@id='rolePan']");
	 */
	
    WebDriverWait wait;
	public TCSlogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}
	
	public void fillAndSubmitNewTCSLogin(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, "LoginPage", testCaseName,stepGroup);
		
		
		Reporter.log("<B>Login To Application</B>");
		
		//switchtoframe(driver, "display");

		
		String user=LoginUserFromSyncMap.userIDForLogin(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution,testCaseName);
        System.out.println("");
        System.out.println("Below details are from login Page::");
        System.out.println(user+" USER ID sent for login.");
        System.out.println("At the time of login using USER ID: "+user+" Updated MAP shows as below:");
        System.out.println("Status wise MAP::"+MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.toString());
		
		clearAndSenKeysLogin(username,user, "UserName");
		clearAndSenKeysLogin(password,dataRow.getProperty("Password"), "Password");
		//clearAndSenKeys(role, dataRow.getProperty("Role"), "Role");
		clickForLogin(loginBTN, "Login Button");
	
		/*
		 * switchtodefaultframe(driver);
		 * 
		 * switchtoframe(driver, "head");
		 * 
		 * String Role1= fetchTextFromApplication(Role, "Role");
		 * 
		 * if(!Role1.equalsIgnoreCase("BOPS")) { click(roleCLICK,"Role Click");
		 * 
		 * click(By.xpath("//div[contains(text(),'BOPS')]"),"Selected Role as BOPS"); }
		 */
		//switchtodefaultframe(driver);
	}

}
