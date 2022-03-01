package GroupPages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class UploadPage extends GenericMethods {
	private By BrowseButton = By.xpath("//label[@class = 'custom-file-upload ng-binding']");
	private By UploadButton = By.xpath("//button[@id='UploadBtn']");
	private By ProceedButton = By.xpath("//button[contains(text(),'PROCESSED')]");
	private By StartUpld = By.xpath("//button[contains(., 'Start Upload')]");
	WebDriver driver;

	public UploadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void uploadExcel() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		switchtodefaultframe(driver);
		driver.switchTo().defaultContent();
		
		Thread.sleep(WaitTime.low);
		//System.out.println(driver.findElement(By.xpath("//input[@id='file-upload']")).isDisplayed());
		click(BrowseButton, "Browse Button");

		Thread.sleep(WaitTime.high);
		WebElement u = driver.findElement(By.xpath("//input[@id='file-upload']"));
		u.sendKeys("D:\\UploadExcel.xls");
		Thread.sleep(WaitTime.low); // suspending execution for specified time period
		
		click(StartUpld, "Start Upload");
		Thread.sleep(WaitTime.high);
		// click(ProceedButton, "Proceed Button");
		driver.close();
	}

}
