package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class GroupQuotationDetailsRackRatePage extends GenericMethods {
	
	
	//DetailsBtn
	private By DetailBtn = By.xpath("//button[@id='Quotation Details']");
	
	//Quotation StartDate
	private By QuotationStartDate = By.xpath("//input[@id='Quotation Start Date']");
	
	//Quotation EndDate
	private By QuotationEndDate = By.xpath("//input[@id='Quotation End Date']");
	
	//PremiumCalculationBasis
	private By PremiumCalculationBasis = By.xpath("//select[@id='Premium Calculation Basis']");
	
	//Create Quotation Btn
	private By CreateQuotationBtn = By.xpath("//button[@id='CreateQuotationBtn']");
	
	//Ok
	private By OKBtn = By.xpath("//button[contains(text(),'OK')]");
	
	//CloseBtn
	private By CloseBTN = By.xpath("//button[@id='CloseBtn']");
	
	//QuoteCreationNumber
	private By QuoteCreationNumber = By.xpath("//div[contains(text(),'Quotation Number')]");
	
	//SaveBTN
	private By SaveBTN = By.xpath("//button[@id='SaveBtn']");
	
	//CalculateBTN
	private By CalculateBTN = By.xpath("//button[@id='CalculateBtn']");
	
	
	WebDriverWait wait;
    public GroupQuotationDetailsRackRatePage (WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, 30);	
    }
    
    public void fillGroupQuotationDetailsRackRatePage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
    {
    	String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To CommonPage</B>");
	   
	  
	   
	   //Click On Detail Button
	   click(DetailBtn, "Detail Btn");
	   switchToWindow(driver);
	   String ChildWindow1=driver.getWindowHandle();
	   
	   //Data Frequency
	   clearAndSenKeys(QuotationStartDate,dataRow.getProperty("QuotationStartDate"),"Quotation StartDate");
	   Thread.sleep(WaitTime.low);
	 
	   //Data Frequency
	   clearAndSenKeys(QuotationEndDate,dataRow.getProperty("QuotationEndDate"),"Quotation EndDate");
	   Thread.sleep(WaitTime.low);
	   
	   //Premium Calculation Basis
	   selectFromDropdownByVisibleText(PremiumCalculationBasis,dataRow.getProperty("PremiumCalculationBasis"),"Premium Calculation Basis");
	   
	   //Create Quotation Btn
	   click(CreateQuotationBtn, "Create QuotationBtn");
	   Thread.sleep(WaitTime.low);

		String QuotationID = fetchTextFromApplication(QuoteCreationNumber,"Quotation Id");
		String QuoteID=QuotationID.replaceAll("[^0-9]", "");
		System.out.println(QuoteID);
		Reporter.log("------------------------");
		Reporter.log("QuoteNo. :" + QuoteID );
	   
	   //Ok btn
	   click(OKBtn,"Ok");
	   
	   //Close BTN
	   click(CloseBTN, "Close BTN");
	   
	   driver.switchTo().window(ChildWindow1);
	   
	   
	   
	   //Quotation number --GQ121780359
	   WebElement QuotationNumber=driver.findElement(By.xpath("(//label[contains(text(),'"+QuoteID+"')]/../preceding-sibling::td/a)[1]"));
	   String QuoteNo=QuotationNumber.getText();
	   clickWebElement(QuotationNumber, "Quotation Number");
	   Reporter.log("------------------------");
	   Reporter.log("Quotation Id :"+ QuoteNo);
	   switchToWindow(driver);
	   
	   //Save BTN
	   click(SaveBTN, "Save BTN");
	   Thread.sleep(WaitTime.low);
	   
	  //Ok btn
	   click(OKBtn,"Ok");
	   
	  //CalculateBTN
	   click(CalculateBTN,"Calculate BTN");
	   
	  //Ok btn
	  click(OKBtn,"Ok");
	  
	  //Close BTN
	  click(CloseBTN, "Close BTN");
	   
	   
	   
	}
    
  
    	

}
