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

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;



public class TcsCommonPages extends GenericMethods {
	
	
	
	private By policymanagement = By.xpath("(//p[contains(text(),'Policy Management')])[1]");
	
	
	private By quickquote = By.xpath("//a[contains(text(),'Quick Quote')]");
	
	private By ApplicationDataCapture = By.xpath("//a[contains(text(),'Application Data Capture')]");
	
	private By Product = By.xpath("//select[@id='pProduct']");
	
	private By ProceedBtn = By.xpath("//a[contains(text(),'Proceed')]");
	
    WebDriverWait wait;
	public TcsCommonPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}
	
	public void navigateToQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{

		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   
		Reporter.log("<B>Traverse To CommonPage</B>");

		switchtoframe(driver, "display");
		
		clickForLogin(policymanagement, "Policy Management");
		
		switchtodefaultframe(driver);
		
		switchtoframe(driver, "head");
		
//		clickForLogin(quickquote, "Quick Quote");
		
		clickForLogin(ApplicationDataCapture, "Application Data Capture");
		
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		
		//Product DropDown
		selectFromDropdownByVisibleText(Product,dataRow.getProperty("Product"),"Product");
		
		Thread.sleep(WaitTime.low);
		
		click(ProceedBtn, "Proceed Btn");
				
		switchtodefaultframe(driver);
		
		
		
}
}