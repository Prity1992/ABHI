package GroupPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import stepDefination.StepDefination;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class GroupBasicDetailsPage extends GenericMethods {

	// Proposal Segment
	private By ProposalSegment = By.xpath("//select[@id='Type of Proposal']");

	// Cancellation Retention Period (days)
	private By CancellationRetentionPeriod = By.xpath("//input[@id='Cancellation Retention Period (days)']");
	// Business Type
	private By BusinessType = By.xpath("//select[@id='Type of Business']");

	// Renewal Flag
	private By RenewalFlag = By.xpath("//select[@id='Policy Renewal Applicable']");

	// Policy Tenure
	private By PolicyTenure = By.xpath("//select[@id='Policy Tenure']");

	// Enterprise Type
	private By EnterpriseType = By.xpath("//select[@id='Enterprise Type']");

	// Policy Type
	private By PolicyType = By.xpath("//select[@id='Plan Type']");

	// Total Number of Lives
	private By TotalNoOfLives = By.xpath("//input[@id='Number of Lives']");

	// Industry Type
	private By IndustryType = By.xpath("//input[@id='industrytype']");

	// Industry Type Search
	private By IndustryTypeSearch = By.xpath("//button[@id='btncontinue']");

	// Source
	private By Source = By.xpath("//select[@id='Source of Business']");

	// Data Frequency
	private By DataFrequency = By.xpath("//input[@id='Data Frequency']");

	// Refer to Underwriter
	private By RefertoUnderwriter = By.xpath("//select[@id='Refer to Underwriter']");

	// Intermediary Details Section
	// Intermediary Code
	private By IntermediaryCode = By.xpath("//input[@id='Producer Code']");

	//// Intermediary Code
	private By IntermediarySearch = By.xpath("//a[@id='openLookUp Producer Code']");

	// Group Policy Holder Details
	// Group Code
	private By GroupCode = By.xpath("//input[@id='Agreemnet-Manager Code']");

	// Group Code Search
	private By GroupCodeSearch = By.xpath("//a[@id='openLookUp Agreemnet-Manager Code']");

	// Add Group Code
	private By AddGroupCode = By.xpath("//i[@title='Add Group Code']");

	// Activate
	private By ActivateButton = By.xpath("//button[@id='Back']");

	// Party Type
	private By PartType = By.xpath("//select[@id='Party Links']");

	// Business Name
	private By BusinessName = By.xpath("//input[@id='Business Name']");

	// Type of Organization
	private By TypeOfOrganization = By.xpath("//select[@id='Type of Organization']");
	
	//Registration Date
	
	private By RegistrationDate = By.xpath("//input[@id='Registration Date']");

	// Start Date
	private By StartDate = By.xpath("//input[@id='Start Date']");

	// ID Type
	private By IDType = By.xpath("//select[@id='ID Type']");

	// ID NUmber
	private By IDNumber = By.xpath("//input[@id='ID Number']");
	
	//Party GST No
	
	private By PartyGSTNo = By.xpath("//input[@id='Party GST No']");

	// Business Type
	private By TypeOfBusiness = By.xpath("//select[@id='Business Type']");

	// PriorityCustomer
	private By PriorityCustomer = By.xpath("//select[@id='Priority Customer']");

	// Address Icon
	private By AddressIcon = By.xpath("//img[@class='circle_img']");

	// Address1
	private By AddressLine1 = By.xpath("//input[@id='Address Pty 1']");

	// Address2
	private By AddressLine2 = By.xpath("//input[@id='Address Pty 2']");

	// Pincode
	private By PinCodeParty = By.xpath("//input[@id='Zip CodeParty']");

	// Pincode search
	private By PinCodePartySearch = By.xpath("//i[@class='fa fa-search fawesomeSearchIcon']");

	// MobileNo
	private By MobileNo = By.xpath("//input[@id='Mobile Number']");

	// EmailId
	private By EmailId = By.xpath("//input[@id='{objQuestion.strParameterName}}']");

	// Landline number
	private By Landline = By.xpath("//input[@id='Landline NumberP']");

	// GST Enrollment
	private By GSTEnrolment = By.xpath("//select[@id='GST Enrolment']");

	// Special Economic Zone (SEZ Client)
	private By SEZClient = By.xpath("//select[@id='SEZ Client']");

	// Select Type of Address
	private By AddressType = By.xpath("//select[@id='Select Type of Address']");

	// Group Other Information
	// Sales Vertical
	private By SalesVertical = By.xpath("//input[@id='Sales Vertical']");

	// Location
	private By Location = By.xpath("//textarea[@id='Location']");

	// Quote Type
	private By QuoteType = By.xpath("//select[@id='Quote Type']");

	// Nature of Duties
	private By NatureofDuties = By.xpath("//select[@id='Nature of Duties']");

	// Existing Insurer
	private By ExistingInsurer = By.xpath("//select[@id='Existing Insurer']");

	// No of Lives at Inception
	private By NumberofLivesInception = By.xpath("//input[@id='Number of Lives Inception']");

	// No of Lives as on Date
	private By NumberofLivesOnDate = By.xpath("//input[@id='Number of Lives On Date']");

	// Premium at Inception
	private By PremiumatInception = By.xpath("//input[@id='Premium at Inception']");

	// Premium as on Date
	private By PremiumonasonDate = By.xpath("//input[@id='Premium on Date']");

	// No of Employees
	private By NoofEmployees = By.xpath("//input[@id='No of Employees']");

	// No of Primary Members
	private By NoofPrimaryMembers = By.xpath("//input[@id='No of Primary Members']");

	// Reward Applicability
	private By RewardApplicability = By.xpath("//select[@id='Reward Applicability']");

	// Reward %
	private By RewardinPercentage = By.xpath("//input[@id='Reward%']");
	
	//TPA Name
	private By TPAName = By.xpath("//select[@id='TPA Name']");
	
	
	
	//TPA %
	
	private By TPAPercentage = By.xpath("//input[@id='TPA %']");

	// Brokerage %
	private By BrokerageinPercentage = By.xpath("//input[@id='Brokerage(%)']");

	// Co-Insurance
	private By CoInsurance = By.xpath("//select[@id='Co-insurance Applicable']");

	// GST Applicability
	private By GSTApplicability = By.xpath("//select[@id='GST Applicable?']");
	
	
	//GST Registration Date
	private By GSTRegistrationDate = By.xpath("//input[@id='GST Registration Date']");
	

	// Data Sharing Agreement
	private By DataSharingAgreement = By.xpath("//select[@id='Data Sharing Agreement']");

	// Proposal Type
	private By ProposalType = By.xpath("//select[@id='Proposal type']");

	// Save
	private By Save = By.xpath("//button[@id='Save']");

	// Ok
	private By OKBtn = By.xpath("//button[contains(text(),'OK')]");

	// Quote/Policy Number
	private By ProposalNo = By.xpath("//label[@id='Number']");
	// Continue
	private By ContinueBtn = By.xpath("//button[@id='btncontinue']");

	// Agent Branch
	private By AgentBranch = By.xpath("//input[@id='Agent Branch Name']");

	// Agent Sales Manager
	private By AgentSalesManager = By.xpath("//input[@id='Agent Sales Manager']");

	// popup
	private By popup = By.xpath(
			"//div[contains(text(),'Cause: There is already an existing party PT00340777 with same Policy Holder Details.')]");

	//Group Sales Manager
	private By GroupSalesManager = By.xpath("//input[@id='Group Sales Manager']");


	WebDriverWait wait;

	public GroupBasicDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void fillGroupBasicDetailsPage(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet).trim();
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
		Reporter.log("<B>Traverse To GroupDetailsPage</B>");

		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");

		// Proposal Segment
		selectFromDropdownByVisibleText(ProposalSegment, dataRow.getProperty("ProposalSegment"), "Proposal Segment");
		Thread.sleep(WaitTime.low);

		if (dataRow.getProperty("ProposalSegment").equalsIgnoreCase("Employer-Employee")) 
		{

			// Cancellation Retention Period
			clearAndSenKeys(CancellationRetentionPeriod, dataRow.getProperty("CancellationRetentionPeriod"),
					"Cancellation Retention Period");
		}
		// Business Type
		selectFromDropdownByVisibleText(BusinessType, dataRow.getProperty("BusinessType"), "Business Type");
		Thread.sleep(WaitTime.low);

		// Renewal Flag
		selectFromDropdownByVisibleText(RenewalFlag, dataRow.getProperty("RenewalFlag"), "Renewal Flag");
		Thread.sleep(WaitTime.low);

		// Policy Tenure
		selectFromDropdownByVisibleText(PolicyTenure, dataRow.getProperty("PolicyTenure"), "Policy Tenure");
		Thread.sleep(WaitTime.low);

		// Enterprise Type
		selectFromDropdownByVisibleText(EnterpriseType, dataRow.getProperty("EnterpriseType"), "Enterprise Type");
		Thread.sleep(WaitTime.low);

		// Policy Type
		selectFromDropdownByVisibleText(PolicyType, dataRow.getProperty("PolicyType"), "Policy Type");
		Thread.sleep(WaitTime.low);

		// Industry Type
		// clearAndSenKeys(IndustryType,dataRow.getProperty("IndustryType"),"Industry
		// Type");
		HashMap<String, Integer> BtnPress1 = new HashMap<String, Integer>();
		BtnPress1.put("Travel & Transportation", 1);
		BtnPress1.put("IT AND ITES  /BPO", 1);
		BtnPress1.put(
				"Sports Activity (Jockeys, Circus personal, persons engaged in activities like racing on wheels or Horseback, Ship crews, Professional Sports teams, Diving, Big Game Hunting, Race show or Stunt show participants, Mountaineering, Winter Sports, Skiing, Ice Skating, Ballooning, Hang gliding, River Rafting, Polo)",
				1);// risk2
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(IndustryType, dataRow.getProperty("IndustryType"), "Industry Type");

		for (String key : BtnPress1.keySet()) {
			if (key.equalsIgnoreCase(dataRow.getProperty("IndustryType"))) {
				// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='occupation']"))));

				Thread.sleep(WaitTime.medium);
				click(By.xpath("//span[contains(text(),'" + key + "')]"), key);
				sendOneKeys(IndustryType, Keys.TAB, key);
				Thread.sleep(WaitTime.low);
			}
		}

		// Data Frequency
		clearAndSenKeys(DataFrequency, dataRow.getProperty("DataFrequency"), "Data Frequency");
		Thread.sleep(WaitTime.low);

		// Source
		selectFromDropdownByVisibleText(Source, dataRow.getProperty("Source"), "Source");
		Thread.sleep(WaitTime.low);

		// Refer to Underwriter
		// selectFromDropdownByVisibleText(RefertoUnderwriter,dataRow.getProperty("RefertoUnderwriter"),"Refer
		// to Underwriter");
		// Thread.sleep(2000);

		// Intermediary Code
		String parentWindow = driver.getWindowHandle();
		clearAndSenKeys(IntermediaryCode, dataRow.getProperty("IntermediaryCode"), "InterMediaryCode ");

		click(IntermediarySearch, "Search");
		switchToWindow(driver);

		click(By.xpath("//a[contains(text(),'" + dataRow.getProperty("IntermediaryCode") + "')]"), "Intermediary Code");

		driver.switchTo().window(parentWindow);
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");

		// Group Policy Holder Details
		// Group Code
		// clearAndSenKeys(GroupCode,dataRow.getProperty("GroupCode"),"GroupCode");
		// click(GroupCodeSearch, "Group Code Search");
		// switchToWindow(driver);
		// click(By.xpath("//a[contains(text(),'"+dataRow.getProperty("GroupCode")+"')]"),"Group
		// Code");
		//
		// Vignesh 07/09/2021
		click(AddGroupCode, "Clicked to create party code");
		switchToWindow(driver);
		Thread.sleep(WaitTime.low);

		// Party Type
		// selectFromDropdownByVisibleText(PartType,dataRow.getProperty("PartType"),"Party
		// Type");

		// Business Name
		Random r = new Random();
		String BussName = getRandomString() + getRandomString();
		clearAndSenKeys(BusinessName, BussName, "Business Name");
		Thread.sleep(WaitTime.veryLow);

		// Start Date
		// clearAndSenKeys(StartDate,dataRow.getProperty("StartDate"),"Start Date");

		// Type Of Organization
		selectFromDropdownByVisibleText(TypeOfOrganization, dataRow.getProperty("TypeOfOrganization"),"Type Of Organization");

		//Registration Date
		
		DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
		Date obj = new Date();
		String acurrdate=dfor.format(obj);
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String actualdate=date.format(formatter);
		clearAndSenKeys(RegistrationDate,actualdate,"GST Registration Date");
		Thread.sleep(WaitTime.low);
		
		
		// IDType
		selectFromDropdownByVisibleText(IDType, dataRow.getProperty("IDType"), "ID Type");

		// ID Number
		clearAndSenKeys(IDNumber, panNoGenerator(), "ID Number");
		
		//Party GST No
		
		clearAndSenKeys(PartyGSTNo, dataRow.getProperty("PartyGSTNo"), "Party GST No");
		

		// Type Of Business
		// selectFromDropdownByVisibleText(TypeOfBusiness,dataRow.getProperty("TypeOfBusiness"),"Type
		// Of Business");

		// Priority Customer
		selectFromDropdownByVisibleText(PriorityCustomer, dataRow.getProperty("PriorityCustomer"), "Priority Customer");

		// Click Icon Address
		click(AddressIcon, "Clicked to Address Icon");
		Thread.sleep(WaitTime.veryLow);

		// Address line 1
		clearAndSenKeys(AddressLine1, getRandomString(), "Address Line 1");
		Thread.sleep(WaitTime.low);

		// Address Line 2
		clearAndSenKeys(AddressLine2, getRandomString(), "Address Line2");
		Thread.sleep(WaitTime.veryLow);

		// Pincode
		clearAndSenKeys(PinCodeParty, dataRow.getProperty("PinCode"), "Pin Code Party");
		sendOneKeys(PinCodeParty, Keys.TAB, "Pincode");
		Thread.sleep(WaitTime.low);

		// click(PinCodePartySearch,"Pin Code Party");

		// Landline Number
		clearAndSenKeys(Landline, getRndNumber(), "Landline number");

		// Mobile Number
		clearAndSenKeys(MobileNo, getRndNumber(), "Mobile Number");

		Thread.sleep(WaitTime.veryLow);

		// EmailId
		clearAndSenKeys(EmailId, generateRandomEmail(), "Email Id");
		Thread.sleep(WaitTime.veryLow);

		click(Save, "Save");
		Thread.sleep(WaitTime.veryLow);

		/*
		 * boolean okBTNIPTT = getSize(By.
		 * xpath("//div[contains(text(),'Cause: There is already an existing party')]"),
		 * "Button") !=0; if (okBTNIPTT == true) { click(OKBtn, "Ok"); //Business Name
		 * clearAndSenKeys(BusinessName,BussName,"Business Name");
		 * Thread.sleep(WaitTime.veryLow);
		 * 
		 * click(Save, "Save"); Thread.sleep(WaitTime.veryLow);
		 * 
		 * 
		 * click(OKBtn, "Ok");
		 * 
		 * }
		 * 
		 * else { click(OKBtn, "Ok"); }
		 * 
		 */
		click(ActivateButton, "Click on Activate Button");
		// click(OKBtn, "Ok");

		driver.switchTo().window(parentWindow);
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");

		String GroupCodeNumber = fetchTextFromAngularApplication(GroupCode, "Group Party Code");
		System.out.println("" + GroupCodeNumber);

		
		setParty(GroupCodeNumber.trim());
		Reporter.log("Group Party Code :" + GroupCodeNumber);

		// GST Enrollment
		// selectFromDropdownByVisibleText(GSTEnrolment,dataRow.getProperty("GSTEnrolment"),"GSTEnrolment");

		// Special Economic Zone (SEZ Client)
		selectFromDropdownByVisibleText(SEZClient, dataRow.getProperty("SEZClient"), "SEZ Client");

		// Select Type of Address
		selectFromDropdownByVisibleText(AddressType, dataRow.getProperty("AddressType"), "Address Type");

		// Group Other Information

		// SalesVertical
		clearAndSenKeys(SalesVertical, dataRow.getProperty("SalesVertical"), "SalesVertical");
		Thread.sleep(WaitTime.low);

		// Location"
		clearAndSenKeys(Location, dataRow.getProperty("Location"), "Location");
		Thread.sleep(WaitTime.low);

		// Quote Type
		selectFromDropdownByVisibleText(QuoteType, dataRow.getProperty("QuoteType"), "Quote Type");

		// Nature of Duties
		selectFromDropdownByVisibleText(NatureofDuties, dataRow.getProperty("NatureofDuties"), "NatureofDuties");

		// ExistingInsurer
		selectFromDropdownByVisibleText(ExistingInsurer, dataRow.getProperty("ExistingInsurer"), "ExistingInsurer");

		// Premium at Inception
		clearAndSenKeys(PremiumatInception, dataRow.getProperty("PremiumatInception"), "PremiumatInception");

		// Premium as on Date
		clearAndSenKeys(PremiumonasonDate, dataRow.getProperty("PremiumonasonDate"), "PremiumonasonDate");


		// No of Employees
		//clearAndSenKeys(NoofEmployees,dataRow.getProperty("NoofEmployees"),"NoofEmployees");

		// Reward Applicability
		selectFromDropdownByVisibleText(RewardApplicability, dataRow.getProperty("RewardApplicability"),"Reward Applicability");

		// Reward%
		clearAndSenKeys(RewardinPercentage, dataRow.getProperty("RewardinPercentage"), "Reward%");

		//TPA Name
		
		selectFromDropdownByVisibleText(TPAName, dataRow.getProperty("TPAName"),"TPA Name");
		
		//TPA %
		
		clearAndSenKeys(TPAPercentage, dataRow.getProperty("TPA%"), "TPA %");
		
		
		
		// Brokerage%
		clearAndSenKeys(BrokerageinPercentage, dataRow.getProperty("BrokerageinPercentage"), "Brokerage%");




		// GST Applicability
		selectFromDropdownByVisibleText(GSTApplicability, dataRow.getProperty("GSTApplicability"), "GST Applicability");
		
		//GST Registration Date
		clearAndSenKeys(GSTRegistrationDate,actualdate,"GST Registration Date");
		Thread.sleep(WaitTime.low);

		// Co-Insurance
		selectFromDropdownByVisibleText(CoInsurance, dataRow.getProperty("CoInsurance"), "Co-Insurance");

		// Proposal Type
		selectFromDropdownByVisibleText(ProposalType, dataRow.getProperty("ProposalType"), "Proposal Type");

		// Data Sharing Agreement
		selectFromDropdownByVisibleText(DataSharingAgreement, dataRow.getProperty("DataSharingAgreement"),"Data Sharing Agreement");
		Thread.sleep(WaitTime.low);

		//
		clearAndSenKeys(NoofPrimaryMembers, dataRow.getProperty("NoofPrimaryMembers"), "No of Primary Members");
		Thread.sleep(WaitTime.low);

		// Agent Branch
		clearAndSenKeys(AgentBranch, dataRow.getProperty("AgentBranch"), "Agent Branch");
		Thread.sleep(WaitTime.low);

		// Agent Sales Manager
		clearAndSenKeys(AgentSalesManager, dataRow.getProperty("AgentSalesManager"), "Agent Sales Manager");
		Thread.sleep(WaitTime.low);

		// Number of Lives On Date
		clearAndSenKeys(NumberofLivesOnDate, dataRow.getProperty("NumberofLivesOnDate"), "NumberofLivesOnDate");
		Thread.sleep(WaitTime.low);

		// Number of Lives Inception
		clearAndSenKeys(NumberofLivesInception, dataRow.getProperty("NumberofLivesInception"),
				"NumberofLivesInception");
		Thread.sleep(WaitTime.low);

		// Total No of Lives
		clearAndSenKeys(TotalNoOfLives, dataRow.getProperty("TotalNoOfLives"), "Total No of Lives");
		Thread.sleep(WaitTime.low);


		//Group Sales Manager
		//clearAndSenKeys(GroupSalesManager,dataRow.getProperty("GroupSalesManager"),"Group Sales Manager");


		// Save btn
		click(Save, "Save");

		// Ok btn
		click(OKBtn, "Ok");

		// click(OKBtn,"Ok");
		Thread.sleep(WaitTime.low);

		String ProposalNumber = fetchTextFromApplication(ProposalNo, "Quote/Policy/Proposal Number");
		System.out.println(ProposalNumber);
		Reporter.log("------------------------");
		Reporter.log("ProposalNumber. :" + ProposalNumber);
		// Continue

		click(ContinueBtn, "ContinueBtn");

	}

}
