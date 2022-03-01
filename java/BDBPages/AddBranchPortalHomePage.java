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

public class AddBranchPortalHomePage extends GenericMethods {

	//Click on customerOps
	private By customerOps = By.xpath("//div[contains(text(),' Customer Ops')]");

	
	public AddBranchPortalHomePage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);	
	}

	public void fillAddBranchPortalHomePage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Traverse To Add Branch Portal HomePage</B>");
		
		//switchtoframe(driver, "frame-1-2");
		
		
			click(customerOps, "CUSTOMER OPS");
		
		

			
	}	
}





