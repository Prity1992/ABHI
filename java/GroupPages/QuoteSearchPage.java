package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class QuoteSearchPage extends GenericMethods {
	
	
	private By PolicyManagement = By.xpath("(//p[contains(text(),'Policy Management')])[1]");
	
	
	private By QuoteNoSearch = By.xpath("//input[@id='Policy No.']");
	
	
	private By SearchButton = By.xpath("//button[@id='Search']");
	
	WebDriverWait wait;
	public QuoteSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
		}

	public void searchQuote(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testScenarioID, stepGroup);

		Reporter.log("<B>Search Quote</B>");
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		click(PolicyManagement,"Policy Management tab");
		
		
//		clearAndSenKeys(QuoteNoSearch,getQuoteNo(testCaseName),"Quote No Input");
		clearAndSenKeys(QuoteNoSearch, dataRow.getProperty("QuoteNumber"), "Quote No Input");
		
		
		
		click(SearchButton, "search");
		
		sendOneKeys(By.xpath("//input[@id='Policy No.']"), Keys.PAGE_DOWN, "Policy No.");
		
		click(By.xpath("//a[contains(text(),'"+dataRow.getProperty("QuoteNumber")+"')]"),"Quote no");
		
		
	}
}
