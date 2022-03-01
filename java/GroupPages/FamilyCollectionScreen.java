package GroupPages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
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

public class FamilyCollectionScreen extends GenericMethods {

	// Issue QUOTE BTN
	private By IssueQuoteBtn = By.xpath("//button[@id='IssueQuoteBtn']");
	// ok btn
	private By OkBtn = By.xpath("//button[contains(text(),'OK')]");
	// CreateCollectionBtn
	private By CreateCollectionBtn = By.xpath("//button[@id='createColBtn']");
	// Collection Payment Amount
	private By CollectionPaymentAmt = By.xpath("//input[@id='CollectionAmount']");
	// Instrument Amount
	private By InstrumentAmt = By.xpath("//input[@id='pInstrumentAmt']");
	// Payment Mode
	private By Paymode = By.xpath("//select[@id='CollectionMode']");
	// Cheque Date
	private By ChequeDate = By.xpath("//input[@id='InsDate']");
	// Cheque Number
	private By ChequeNo = By.xpath("//input[@id='InsNum']");
	// Drawee Bank Name
	private By DraweeBnk = By.xpath("//input[@id='BankName']");
	// Drawee Branch
	private By DraweeBrnch = By.xpath("//input[@id='BankBranch']");
	// Total Button
	private By GetTotal = By.xpath("//span[contains(text(),'Get Total')]");
	// Narration
	private By Narration = By.xpath("//input[@id='Narration']");
	// Save Button
	private By Save = By.xpath("//a[@name='Saver']/span[contains(text(),'Save')]");
	// Post Button
	private By Post = By.xpath("//a[@id='BtnPostSpan1']/span[contains(text(),'Post')]");
	// Receipt Type
	private By RecType = By.xpath("//select[@id='pReceiptType']");

	//subcode
	private By SubCode = By.xpath("//input[@id='SubCodeLookup']");

	//SubCodeVAlue
	private By SubCodeValue = By.xpath("(//a[contains(text(),'ABHIG')])[1]");


	// Policy Number
	private By FamilyPolicyNumber = By.xpath("//label[@id='Number']");

	// Sub-Status
	private By SubStatus = By.xpath("//label[@id='Sub-Status']");

	// Status
	private By Status = By.xpath("//label[@id='Status']");

	// Confirm button
	private By Confirmbtn = By.xpath("//button[@id='confirm1']");

	// Confirm button
	private By CalculatePremiumbtn = By.xpath("//button[@id='CalPrmBtn']");

	//Gross Premium Amount
	private By GrossPremiumAmt = By.xpath("//input[@id='Total Premium']");

	// Net Premium Amount
	private By NetPremiumAmt = By.xpath("//label[@id='Total Premium']");

	// Navigate to Group Policy
	private By NavToGP = By.xpath("//button[@id='navGP']");

	// Navigate to Employee Class Info
	private By NavToECF = By.xpath("(//i[@class='ng-scope fa fa-id-badge'])[4]");

	private By upload = By.xpath("//button[@id='UploadBtn']");

	private By EffDate = By.xpath("//input[@id='EffectiveDate']");

	private By RecNumber = By.xpath("//input[@id='pVoucherNo']");

	private By Company = By.xpath("//select[@id='pBusinessUnit']");
	WebDriverWait wait;

	public FamilyCollectionScreen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void fillcollectionscreen(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
		Reporter.log("<B>Traverse To Family CollectionScreen Page</B>");
		//		switchToWindow(driver);
		//		switchtodefaultframe(driver);
		//		switchtoframe(driver, "display"); ~
		//		switchtoframe(driver, "containerFrame");

		String Parentwindow = driver.getWindowHandle();

		click(CalculatePremiumbtn, "Clicked on Calculate Premium");

		WebElement element = driver.findElement(By.xpath("//input[@id='Total Premium']"));
		// String Amt = element.getText();
		String InstrumentAmount = element.getAttribute("value");

		// String InstrumentAmount =
		// fetchTextFromApplication(NetPremiumAmt,"NetPremiumAmt");
		System.out.println(InstrumentAmount);
		// System.out.println(Amt);
		click(CreateCollectionBtn, "Clicked on Create Collection Button");

		Thread.sleep(WaitTime.high);
		switchToWindow(driver);
		Thread.sleep(WaitTime.veryLow);
		sendTwoKeysForLogin(By.cssSelector("body"), Keys.CONTROL, Keys.PAGE_UP, "Body Element");
		List elements = driver.findElements(By.xpath("//input[@id='pInstrumentAmt']"));
		if (elements.size() == 0) {
			driver.close();

			click(CreateCollectionBtn, "Clicked on Create Collection Button");

			Thread.sleep(WaitTime.high);
			switchToWindow(driver);
			Thread.sleep(WaitTime.veryLow);
			sendTwoKeysForLogin(By.cssSelector("body"), Keys.CONTROL, Keys.PAGE_UP, "Body Element");
		}
		sendOneKeyForLogin(InstrumentAmt, Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "instrument amount");

		//	selectFromDropdownByVisibleText(Company,"ADITYA BIRLA HEALTH AFFINITY", "ADITYA BIRLA HEALTH AFFINITY");

		// Instrument Amount
		clearAndSenKeys(InstrumentAmt, InstrumentAmount, "Instrument Amount");

		// Receipt Type
		selectFromDropdownByVisibleText(RecType, dataRow.getProperty("ReceiptType"), "Receipt Type");
		// Payment Mode
		selectFromDropdownByVisibleText(Paymode, dataRow.getProperty("Paymode"), "Payment Mode");
		// Collection Payment Amount
		clearAndSenKeys(CollectionPaymentAmt, InstrumentAmount, "Collection Payment Amount");

		if(dataRow.getProperty("Paymode").equalsIgnoreCase("RTGS/NEFT"))
		{
			// Cheque Date
			clearAndSenKeys(ChequeDate, dataRow.getProperty("ChequeDate"), "Cheque Date");
			// Cheque Number
			clearAndSenKeys(ChequeNo, dataRow.getProperty("ChequeNo"), "Cheque Number");
			// Drawee Bank
			clearAndSenKeys(DraweeBnk, dataRow.getProperty("DraweeBnk"), "Drawee Bank");
			// Drawee Branch
			clearAndSenKeys(DraweeBrnch, dataRow.getProperty("DraweeBrnch"), "Drawee Branch");
		}
		else
		{
			//If Paymode As CD Or BG
			String ChildWindow = driver.getWindowHandle();

			//click on subcode button
			click(SubCode, "Clicked on SubCode");

			Thread.sleep(WaitTime.high);
			switchToWindow(driver);
			Thread.sleep(WaitTime.veryLow);
			sendTwoKeysForLogin(By.cssSelector("body"), Keys.CONTROL, Keys.PAGE_UP, "Body Element");

			click(SubCodeValue, "Clicked on SubCodeValue");
			driver.close();
			driver.switchTo().window(ChildWindow);
			System.out.println("Succssfull!");


		}
		// Narration
		clearAndSenKeys(Narration, dataRow.getProperty("Narration"), "Narration");


		// click(GetTotal, "Get Total Amount");

		click(Save, "Save");

		click(Post, "Post");
		Thread.sleep(WaitTime.veryLow);


		//		LocalDate date = LocalDate.now();
		//		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//		String CurrentDate=date.format(formatter);
		//		 UpdateExcel ue=new UpdateExcel("D:\\UploadExcel.xls");
		//		 ue.updateValueInExcelSheet("Collection Amount",InstrumentAmount);
		//		
		//		//updating Action Effective Date in Excel
		//		 ue.updateValueInExcelSheet("Action Effective Date",CurrentDate);
		//		
		//		 
		//		 WebElement rec=driver.findElement(By.xpath("//input[@id='pVoucherNo']"));
		//		 WebElement rec1=driver.findElement(By.xpath("//input[@id='pCollectionNo']"));
		//		 WebElement eDate=driver.findElement(By.xpath("//input[@id='EffectiveDate']"));
		//		 System.out.println(rec.getAttribute("value")+" "+rec1.getAttribute("value")+" "+eDate.getAttribute("value"));
		//		//updating CD Receipt Number in Excel
		//		 ue.updateValueInExcelSheet("CD Receipt Number",rec.getAttribute("value")+"/1");
		//		 
		//		//Updating Family Identification Number in excel
		//		ue.updateValueInExcelSheet("Family Identification Number",getRndNumber());
		//			
		//		//Updating Category in excel	
		//		//ue.updateValueInExcelSheet("Category","CATEGORY 1");
		//		
		driver.close();

		driver.switchTo().window(Parentwindow);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");
		click(IssueQuoteBtn, "Clicked on issue Quote Button");
		click(Confirmbtn, "Clicked on Confirm Button");
		Thread.sleep(WaitTime.veryLow);

		Reporter.log(
				"<B> Family Policy No:-  </B>" + fetchTextFromApplication(FamilyPolicyNumber, "Family Policy Number"));

		System.out.println(fetchTextFromApplication(FamilyPolicyNumber, "Family Policy Number"));




		Reporter.log("<B> After Accept Quotation button is clicked Now Status:-  </B>"
				+ fetchTextFromApplication(Status, "Status"));

		//click(Confirmbtn, "Clicked on Confirm Button");


		/*
		 * String condition=ConfigReader.getInstance().getValue("UploadExcel");
		 * if(condition.equalsIgnoreCase("true")) { // Navigate to Group Policy
		 * click(NavToGP, "Navigate to Group Policy");
		 * 
		 * switchtodefaultframe(driver); switchtoframe(driver, "display");
		 * 
		 * 
		 * click(NavToECF, "Navigate to Employee Class Info");
		 * switchtodefaultframe(driver); switchtoframe(driver, "display");
		 * switchtoframe(driver, "containerFrame"); Thread.sleep(WaitTime.low);
		 * 
		 * // Updating Source Reference Number in Exccel
		 * ue.updateValueInExcelSheet("Source Reference Number",fetchTextFromApplication
		 * (FamilyPolicyNumber, "Family Policy Number")); WebElement
		 * category=driver.findElement(By.
		 * xpath("//label[@class='ng-pristine ng-untouched ng-valid ng-binding ng-empty']"
		 * )); ue.updateValueInExcelSheet("Category", category.getText().trim());
		 * 
		 * click(upload, "Navigate to Upload Page"); String parent =
		 * driver.getWindowHandle(); UploadPage up=new UploadPage(driver); Set<String>
		 * handles = driver.getWindowHandles(); for (String child : handles) { if
		 * (!child.equalsIgnoreCase(parent)) { // Switch to the opened tab
		 * driver.switchTo().window(child); up.uploadExcel(); break; } }
		 * driver.switchTo().window(parent); }
		 */
		// click(OkBtn, "Clicked On OK Button");

	}

}
