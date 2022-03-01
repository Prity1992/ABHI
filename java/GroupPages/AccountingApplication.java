package GroupPages;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;
import util.WaitTime;

public class AccountingApplication extends GroupBasicDetailsPage {
	private By username = By.xpath("//input[@id='pUserName']");
	private By password = By.xpath("//input[@id='textfield2']");
	private By loginBTN = By.xpath("//a[@id='button']");
	private By AccApp = By.xpath("//b[contains(text(),'Accounting Appplication')]");
	private By SwitchRole = By.xpath("//div[@id='role']");
	private By CdBg = By.xpath("//td[@id='pMenu_4']");
	private By CreateCD = By.xpath("//td[text()='reate CD']");
	private By Company = By.xpath("//select[@name='pCompanyCode']");
	private By CashDepositBankGuarantee_link = By.xpath("//td[text()='ash Deposit/Bank Guarantee']");
	private By CreateBG = By.xpath("//td[text()='eate BG']");
	private By IssuingBank = By.xpath("//tbody/tr[11]/td[2]/a[1]/img[1]");
	private By Ifsc = By.xpath("//input[@id='pIFSC']");
	private By Micr = By.xpath("//input[@id='pMICR']");
	private By BankName = By.xpath("//input[@id='pBankName']");
	private By IssueDate = By.xpath("//input[@name='pEffectiveStartDate']");
	private By ExpiryDate = By.xpath("//input[@name='pEffectiveEndDate']");
	private By GuaranteeAmt = By.xpath("//input[@name='pGuaranteeAmnt']");
	private By BGref = By.xpath("//input[@id='pbgrefno']");
	private By OpnDate = By.xpath("//tbody/tr[22]/td[2]/input[1]");
	private By PartyCode = By.xpath("//input[@name='pPartyCode']");
	// private By PartyCode1 = By.xpath("//tbody/tr[5]/td[2]/input[1]");
	private By PartyLevel = By.xpath("//select[@id='pTypeLevel']");
	private By Accounting = By.cssSelector("#administration");
	private By PartyCodeTab = By.xpath("//tbody/tr[5]/td[2]/a[1]/img[1]");
	private By PartyC = By.xpath("//a[contains(text(),'PCPTY_PROCESS']");
	private By SGOPSrole = By.xpath("//table[@class='headerModuleTbl']/tbody/tr/td[(text()='SGOPS')]");
	//private By BOPSrole = By.xpath("//table[@class='headerModuleTbl']/tbody/tr/td[(text()='GOPS')]");
	private By StakeName = By.xpath("//select[@id='pFunctionCode']");
	private By Save = By.xpath("//span[contains(text(),'Save')]");
	private By Search = By.xpath("//span[contains(text(),'Search')]");
	private By Activate = By.xpath("//span[contains(text(),'Activate')]");
	private By AccountingApplication_Link = By.xpath("//b[contains(text(),'Accounting Appplication')]");
	private By CDnum = By.xpath("//input[@name='pAccCode']");
	private By BOPS = By.xpath("//td[contains(text(),'BOPS')]");
	
	private By AccountingButton = By.xpath("(//img[@class='module'])[1]");
	private By Collection = By.xpath("//td[@transid='99999']");
	private By CreateCollection = By.xpath("//td[@id='999992']");
	private By CompanyName = By.xpath("//select[@id='pBusinessUnit']");
	private By InstrumentAmt = By.xpath("//input[@id='pInstrumentAmt']");
	private By PayerID = By.xpath("//input[@id='pReceivedFrom']");
	private By CollectionPaymentType = By.xpath("//select[@id='pCollectionType']");
	private By RecType = By.xpath("//select[@id='pReceiptType']");
	private By Paymode = By.xpath("//select[@id='CollectionMode']");
	private By CreditAccountCode = By.xpath("//input[@id='CrAccountCodeLookup']");
	private By PartyCode1 = By.xpath("(//img[@src='../images/new/LookUp.bmp'])[5]");
	private By partyCode2 = By.xpath("//input[@name='pPartyCode']");
	private By SearchButton = By.xpath("//span[contains(text(),'Search')]");
	private By CollectionPaymentAmt = By.xpath("//input[@id='CollectionAmount']");
	private By ChequeDate = By.xpath("//input[@id='InsDate']");
	private By ChequeNo = By.xpath("//input[@id='InsNum']");
	private By DraweeBnk = By.xpath("//input[@id='BankName']");
	private By DraweeBrnch = By.xpath("//input[@id='BankBranch']");
	private By Narration = By.xpath("//input[@id='Narration']");
	private By Save1 = By.xpath("//a[@name='Saver']/span[contains(text(),'Save')]");
	private By Post = By.xpath("//a[@id='BtnPostSpan1']/span[contains(text(),'Post')]");
	
	
	

	private By logout = By.xpath("//img[contains(@src,'/images/icon_logout.png')]");

	WebDriverWait wait;

	public AccountingApplication(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void createCDandBG(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert, String parent, String child, String user)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
		Properties dataRow1 = ExcelRead.readRowDataInProperties(workbook, "TCS_LoginPage", testCaseName, stepGroup);
		Reporter.log("<B>Traverse To Accounting Page</B>");
		String partycode=getParty();
		// switchtodefaultframe(driver);
		// switchtoframe(driver, "head");
		// click(AccountingApplication_Link, "Accounting Application Link");
		System.out.println("In accounting");

		switchtodefaultframe(driver);
		Thread.sleep(WaitTime.veryHigh);
		switchtoframe(driver, "display");

		// LogIn Id and Password
		clearAndSenKeysLogin(username, user, "UserName");
		clearAndSenKeysLogin(password, dataRow1.getProperty("Password"), "Password");

		clickForLogin(loginBTN, "Login Button");

		// Switching to current window
		String parent1 = driver.getWindowHandle();
		driver.switchTo().window(parent1);

		// Switching to Head frame
		switchtodefaultframe(driver);
		switchtoframe(driver, "head");

		// Select Role
		click(SwitchRole, "Role Click");
		click(SGOPSrole, "Selected Role as SGOPS");

//		// Switching to Display frame
//		switchtodefaultframe(driver);
//		switchtoframe(driver, "display");
//
//		// Go to Accounting Page
//		click(Accounting, "Accounting");

//		switchtodefaultframe(driver);
//		switchtoframe(driver, "head");

		// Select Cash Deposit/Bank Guarantee
		// click(CdBg, "CdBgOption");
		String s = "yes";

		click(CashDepositBankGuarantee_link, "CashDepositBankGuarantee_link");
		
		if (s.equalsIgnoreCase("Yes")) {
			// Create Cash Deposit
			click(CreateCD, "CreateCD");

			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			// Select Party Level
			// selectFromDropdownByVisibleText(PartyLevel,
			// dataRow.getProperty("PartyLevel"), "Party Level");
			
			
			selectFromDropdownByVisibleText(Company,dataRow.getProperty("Company_1"), "Company");
			
			click(PartyCodeTab, "PartyCodeTab");
			switchToWindow(driver);

			// selecting Organisation radio option
			List<WebElement> RadioButton = driver.findElements(By.name("pIndvOrg"));
			int Size = RadioButton.size();
			for (int i = 0; i < Size; i++) {
				String val = RadioButton.get(i).getAttribute("value");
				if (val.equalsIgnoreCase("O")) {
					RadioButton.get(i).click();
					break;
				}
			}

			
			// click(Organisation, "Organisation");
			clearAndSenKeys(PartyCode, partycode, "InterMediaryCode ");

			selectFromDropdownByVisibleText(StakeName, "Employer", "StakeName");
			click(Search, "Search");

			// Getting perticular Party code
			click(By.xpath("//a[contains(text(),'" + partycode + "')]"), "Party Code");

			// Control back to 2nd tab
			driver.switchTo().window(parent1);
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");

			// On parent window
			click(Save, "Save");

			click(Activate, "Activate");
			String CDNumber = fetchTextFromAngularApplication(CDnum, "CD/Ac Number");
			System.out.println("" + CDNumber);
			Reporter.log("<B> After creating CD CD/AC number generated:-  </B>" + CDNumber);
			
			
			//If ProposalSegment Is Employer-Employee 
			//Avinash 25-11-2021
			
			if(dataRow.getProperty("ProposalSegment").equalsIgnoreCase("Employer-Employee"))
			{
			switchtodefaultframe(driver);
			switchtoframe(driver, "head");
			click(SwitchRole, "Role Click");
			click(BOPS, "BOPS");
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			click(AccountingButton, "Accounting Button");
			switchtodefaultframe(driver);
			switchtoframe(driver, "head");
			click(Collection, "Collection");
			click(CreateCollection, "Create Collection");
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			selectFromDropdownByVisibleText(CompanyName, dataRow.getProperty("Company_1"), "Company");
			sendOneKeyForLogin(InstrumentAmt, Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "instrument amount");
			clearAndSenKeys(InstrumentAmt, dataRow.getProperty("InstrumentAmt"), "Instrumen tAmt");
			clearAndSenKeys(PayerID, partycode, "Payer ID");
			selectFromDropdownByVisibleText(CollectionPaymentType, dataRow.getProperty("Collection/Payment Type"), "Collection/Payment Type");
			selectFromDropdownByVisibleText(RecType, dataRow.getProperty("ReceiptType"), "Receipt Type");
			selectFromDropdownByVisibleText(Paymode, dataRow.getProperty("Paymode"), "Payment Mode");
			String Parent2 = driver.getWindowHandle();
			click(CreditAccountCode, "CreditAccountCode");
			switchToWindow(driver);
			String child1 = driver.getWindowHandle();
			click(PartyCode1, "Party Code1");
			switchToWindow(driver);
			List<WebElement> RadioButton1 = driver.findElements(By.name("pIndvOrg"));
			int Size1 = RadioButton1.size();
			for (int i = 0; i < Size; i++) {
				String val = RadioButton1.get(i).getAttribute("value");
				if (val.equalsIgnoreCase("O")) {
					RadioButton1.get(i).click();
					break;
				}
			}
				clearAndSenKeys(partyCode2, partycode, "Party Code");
				click(SearchButton, "Search Button");
				click(By.xpath("//a[contains(text(),'"+partycode+"')]"), "partycode");
				driver.switchTo().window(child1);
				click(SearchButton, "Search Button");
				WebElement GLCodenew=driver.findElement(By.xpath("//a[contains(text(),'"+partycode+"000"+"')]"));
				System.out.println(GLCodenew.getText());
				String GLCode1=GLCodenew.getText();
				//				String GLCode1=fetchTextFromAngularApplication(GLCodenew, "GLCode");
				
				System.out.println(GLCode1);
				Reporter.log("GLCode1" + GLCode1 );
				click(By.xpath("//a[contains(text(),'"+partycode+"000"+"')]"), "GL Code");
				driver.switchTo().window(Parent2);
				switchtoframe(driver, "display");
				Thread.sleep(WaitTime.medium);
				System.out.println(driver.getTitle());
				clearAndSenKeys(Narration, dataRow.getProperty("Narration"), "Narration");
				clearAndSenKeys(CollectionPaymentAmt, dataRow.getProperty("InstrumentAmt"), "Collection Payment Amount");
				clearAndSenKeys(ChequeDate, dataRow.getProperty("ChequeDate"), "Cheque Date");
				clearAndSenKeys(ChequeNo, dataRow.getProperty("ChequeNo"), "Cheque Number");
				clearAndSenKeys(DraweeBnk, dataRow.getProperty("DraweeBnk"), "Drawee Bank");
				clearAndSenKeys(DraweeBrnch, dataRow.getProperty("DraweeBrnch"), "Drawee Branch");
				
				click(Save1, "Save");
				click(Post, "Post");
		
			// LogOut From Accounting Page
			switchtodefaultframe(driver);
			switchtoframe(driver, "head");
			click(logout, "LogoutFromAccounting");

			driver.close();
		}

		if (s.equalsIgnoreCase("no")) {
			switchtodefaultframe(driver);
			switchtoframe(driver, "head");
			// Create Bank Guarantee
			click(CreateBG, "CreateBG");
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			// Select Party Level
			// selectFromDropdownByVisibleText(PartyLevel,
			// dataRow.getProperty("PartyLevel"), "Party Level");
			click(PartyCodeTab, "PartyCodeTab");
			switchToWindow(driver);

			// Choose option from Party Search
			// selecting Organisation radio option
			List<WebElement> RadioButton2 = driver.findElements(By.name("pIndvOrg"));
			int Size2 = RadioButton2.size();
			for (int i = 0; i < Size2; i++) {
				String val = RadioButton2.get(i).getAttribute("value");
				if (val.equalsIgnoreCase("O")) {
					RadioButton2.get(i).click();
					break;
				}
			}

			clearAndSenKeys(PartyCode, partycode, "InterMediaryCode ");

			selectFromDropdownByVisibleText(StakeName, dataRow.getProperty("StakeName"), "StakeName");
			click(Search, "Search");

			// Getting perticular Party code
			click(By.xpath("//a[contains(text(),'" + partycode + "')]"), "Party Code");

			// Control back to 2nd tab
			driver.switchTo().window(parent1);
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			

			// Bank Details
			clearAndSenKeys(Ifsc, dataRow.getProperty("IFSC Code"), "IFSC Code");

			// Fetch Automatically it just for option
			// clearAndSenKeys(Micr, "DB869i47", "Micr code");
			// clearAndSenKeys(BankName, "SBI", "Bank Name");

			// Date Details
			clearAndSenKeys(IssueDate, dataRow.getProperty("IssueDateCD/BG"), "Issue Date");
			clearAndSenKeys(ExpiryDate, dataRow.getProperty("ExpiryDateCD/BG"), "Expiry Date");

			// Amount of Guarantee
			clearAndSenKeys(GuaranteeAmt, dataRow.getProperty("GuaranteeAmt"), "Guarantee Amount");
			clearAndSenKeys(BGref, "PR9568I95", "BG Reference Number");
			// clearAndSenKeys(OpnDate, dataRow.getProperty("OpnDate"), "Opening Date");
			// On parent window
			click(Save, "Save");

			click(Activate, "Activate");
			// click(logout,"LogOut Accounting");
			driver.close();
		}
		
		
		
		
		
	}
}
}

