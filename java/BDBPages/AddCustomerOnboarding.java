package BDBPages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class AddCustomerOnboarding extends GenericMethods {

	
	private By customerType = By.xpath("//select[@name='bpClientType']");
	private By customerSubType = By.xpath("//select[@name='clientSubType']");
	private By customerClassification = By.xpath("//select[@name='custClassification']");
	
	private By customerDateofBirth = By.xpath("//input[@name='dateOfBirthEng']");
	private By primaryIDType = By.xpath("//select[@id='cust_custidentification_l_idType']");
	private By primaryIDReference = By.xpath("//input[@id='cust_custidentification_l_idReference']");
	private By validFromDate = By.xpath("//input[@id='cust_custidentification_l_idIssueDate']");
	private By validToDate = By.xpath("//input[@id='cust_custidentification_l_idExpiryDate']");
	private By registeredNameTextField = By.xpath("//input[@id='cust_custmaindetails_c_customerTradingName']");
	private By registeredNameLocalLangTextField = By.xpath("//input[@id='cust_custmaindetails_c_businessName']");
	private By validateBtn = By.xpath("//button[@name='validateId']");
	private By customerSegment = By.xpath("//select[@name='customerSegment']");
	private By taxCategory = By.xpath("//select[@name='taxCategory']");
	private By legalForm = By.xpath("//select[@name='legalForm']");
	private By shareHolderDeclaration = By.xpath("//select[@name='cntrlgShareholderDeclaration']");
	//Other Details Tab
	private By otherDetailsTabClick = By.xpath("//h2[contains(text(),'Other Details')]");
	
	
	
	
	
	
	
	
	public AddCustomerOnboarding (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);	
	}

	public void fillAddCustomerOnboarding (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Traverse To Add Customer Onboarding</B>");
		
		switchtoframe(driver, "frame-1-2");
		
		/*
		 * if(dataRow.getProperty("Product").equalsIgnoreCase("CIF)")){
		 * click(customerOps, "CUSTOMER OPS"); }
		 */
		

			
	}	
}





