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
import util.WaitTime;


public class TCSLogout extends GenericMethods{
	
	
	private By Logout = By.xpath("//i[@title='Logout']");
	
	WebDriverWait wait;
	public TCSLogout(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}
	
	
	public void ClickLogout(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, "TCS_LoginPage", testCaseName,stepGroup);
		Reporter.log("<B>Logout from Application</B>");
	
		
		switchtodefaultframe(driver);
		
		switchtoframe(driver, "head");
		
		clickForLogin(Logout,"Logout Button");
		
		driver.switchTo().alert().accept();
		
		System.out.println("Complete");
		
  }
	
}

