package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class PaymentInfoPage extends GenericMethods{
	
	//Payer Type
	private By PayerType = By.xpath("//select[@id='Payer Type']");
	
	//Payment Frequency
	private By PaymentFrequency = By.xpath("//select[@id='Payment Frequency']");
	
	//Save btn
	private By Savebtn = By.xpath("//button[@id='SaveButton']");
		
	//Ok
	private By OKBtn = By.xpath("//button[contains(text(),'OK')]");
	
	//Continue  
	private By ContinueBtn = By.xpath("//button[@id='btncontinue']");
	
	WebDriverWait wait;
    public PaymentInfoPage (WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, 30);	
    }
    
    public void fillPaymentInfoPage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
    {
    	
    	String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To PaymentInfoPage</B>");
	   
	   switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame"); 
		Thread.sleep(WaitTime.low);
		
		//Payer Type
		selectFromDropdownByVisibleText(PayerType,dataRow.getProperty("PayerType"),"Payer Type");
		
		//PaymentFrequency
		selectFromDropdownByVisibleText(PaymentFrequency,dataRow.getProperty("PaymentFrequency"),"Payment Frequency");
    	
		//Save
		click( Savebtn, "Paymeny Info Saved");
    	
    	//Ok
		click( OKBtn, "OK");
    	
		//Continue
		click( ContinueBtn, "Clicked continue now in Group Relation");
    	
		//Continue
		click( ContinueBtn, "Clicked continue now in Employee class Info");
    	
    	
    }
    
    }
