package GroupPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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
import junit.framework.Assert;
import testRunner.TestEngine;
import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.SetUpWebdriver;
import util.WaitTime;

public class GroupQuotationDetailsPage extends GenericMethods {

	private By GroupQuotationDetails = By.xpath("(//a[@name='Group Quotation Details'])[2]");

	private By QuotationDetailsbtn = By.xpath("//button[@id='Quotation Details']");

	private By QuotationStartDate = By.xpath("//input[@id='Quotation Start Date']");

	private By QuotationEndDate = By.xpath("//input[@id='Quotation End Date']");

	private By PremiumCalculationBasis = By.xpath("//select[@id='Premium Calculation Basis']");

	private By CreateQuotationBtn = By.xpath("//button[@id='CreateQuotationBtn']");

	private By QuoteCreationNumber = By.xpath("//div[contains(text(),'Quotation Number')]");

	private By OKBtn = By.xpath("//button[contains(text(),'OK')]");

	private By CloseBtn = By.xpath("//button[@id='CloseBtn']");

	// private By QuotationNumber = By.xpath("//button[@id='CloseBtn']");

	// Group Burning Cost field
	// Paid Cashless Claims Count
	private By PaidCashlessClaimsCount = By.xpath("//input[@id='Paid Cashless Claims Count']");

	// Paid Cashless Claims Amount
	private By PaidCashlessClaimsAmount = By.xpath("//input[@id='Paid Cashless Claims Amount']");

	// Paid Reimbursement Claims Count
	private By PaidReimbursementClaimsCount = By.xpath("//input[@id='Paid Reimbursement Claims Count']");

	// Paid Reimbursement C//button[@id='SaveBtn']laims Amount
	private By PaidReimbursementClaimsAmount = By.xpath("//input[@id='Paid Reimbursement Claims Amount']");

	// Outstanding Cashless Claims Count
	private By OutstandingCashlessClaimsCount = By.xpath("//input[@id='Outstanding Cashless Claims Count']");

	// Outstanding Cashless Claims Amount
	private By OutstandingCashlessClaimsAmount = By.xpath("//input[@id='Outstanding Cashless Claims Amount']");

	// Outstanding Reimbursement Claims Count
	private By OutstandingReimbursementClaimsCount = By.xpath("//input[@id='Outstanding Reimbursement Claims Count']");

	// Outstanding Reimbursement Claims Amount
	private By OutstandingReimbursementClaimsAmount = By
			.xpath("//input[@id='Outstanding Reimbursement Claims Amount']");

	// Closed Cashless Claims Count
	private By ClosedCashlessClaimsCount = By.xpath("//input[@id='Closed Cashless Claims Count']");

	// Closed Cashless Claims Amount
	private By ClosedCashlessClaimsAmount = By.xpath("//input[@id='Closed Cashless Claims Amount']");

	// Closed Reimbursement Claims Count
	private By ClosedReimbursementClaimsCount = By.xpath("//input[@id='Closed Reimbursement Claims Count']");

	// Closed Reimbursement Claims Amount
	private By ClosedReimbursementClaimsAmount = By.xpath("//input[@id='Closed Reimbursement Claims Amount']");

	// Claimed amount for paid claims
	private By Claimedamountforpaidclaims = By.xpath("//input[@id='Claimed amount for paid claims']");

	// No of lives at inception
	private By Nooflivesatinception = By.xpath("//input[@id='No of lives at inception']");

	// Proposed count
	private By Proposedcount = By.xpath("//input[@id='Proposed count']");

	// Claimed Amount for Paid claims
	private By ClaimedAmountforPaidclaims = By.xpath("//input[@id='Claimed Amount for Paid claims']");

	// Average Delay in Registration of Reimbursement Claims
	private By AverageDelayRegistrationClaims = By
			.xpath("//input[@id='Average Delay in Registration of Reimbursement Claims']");

	// Premium at inception(excluding ST)
	private By PremiuminceptionExcludingST = By.xpath("//input[@id='Premium at inception(excluding ST) ']");

	// Premium paid as of date(Total Premium)
	private By TotalPremiumpaidasofdate = By.xpath("//input[@id='Premium paid as of date(Total Premium)']");

	// Large Claims
	private By LargeClaims = By.xpath("//input[@id='Large Claims']");

	// Vignesh take xpath after Large Claims

	// Claims Discount
	private By ClaimsDiscount = By.xpath("//input[@id='Claims Discount']");

	// Claim Analysis Date
	private By ClaimAnalysisDate = By.xpath("//input[@id='Claim Analysis Date']");

	// Policy Start Date
	private By PolicyStartDate = By.xpath("//input[@id='Policy Start Date1']");

	// Member at inception
	private By MemberAtInception = By.xpath("//input[@id='Member at inception']");

	// Proposed Count
	private By ProposedCount = By.xpath("//input[@id='Proposed count1']");

	// Requested Premium
	private By RequestedPremium = By.xpath("//input[@id='Requested Premium']");

	// Approved MCR
	private By ApprovedMCR = By.xpath("//input[@id='Approved MCR']");

	// Inflation (%)
	private By Inflation = By.xpath("//input[@id='Inflation Percentage']");

	// Health Assessment Gross Premium - Per Life
	private By HealthAssessmentGrossPremiumPerLife = By
			.xpath("//input[@id='Health Assessment Gross Premium - per Life']");

	// Risk Expiry Date
	private By RiskExpiryDate = By.xpath("//input[@id='Risk Expiry Date']");

	// UW Loading
	private By UWLoading = By.xpath("//input[@id='Loading']");

	// UWDiscount
	private By UWDiscount = By.xpath("//input[@id='Discount']");

	// Credability Calculation---Rack Rate Premium
	private By RackRatePremium = By.xpath("//input[@id='Rack Rate Premium']");

	// Level of Confidence (%)
	private By LevelofConfidence = By.xpath("//select[@id='Level of Confidence (%)']");

	// Level of Tolerance (%)
	private By LevelofTolerance = By.xpath("//select[@id='Level of Tolerance (%)']");

	// GPA Claims
	private By TotalNoGPAClaimforYear1 = By.xpath("//input[@id='GPA Claim Number Year1']");

	private By TotalAmountGPAClaimforYear1 = By.xpath("//input[@id='GPA Claim Amount Year1']");

	private By TotalNoGPAClaimforYear2 = By.xpath("//input[@id='GPA Claim Number Year2']");

	private By TotalAmountGPAClaimforYear2 = By.xpath("//input[@id='GPA Claim Amount Year2']");

	private By TotalNoGPAClaimforYear3 = By.xpath("//input[@id='GPA Claim Number Year3']");

	private By TotalAmountGPAClaimforYear3 = By.xpath("//input[@id='GPA Claim Amount Year3']");

	private By TotalNoGPAClaimforYear4 = By.xpath("//input[@id='GPA Claim Number Year4']");

	private By TotalAmountGPAClaimforYear4 = By.xpath("//input[@id='GPA Claim Amount Year4']");

	private By TotalNoGPAClaimforYear5 = By.xpath("//input[@id='GPA Claim Number Year5']");

	private By TotalAmountGPAClaimforYear5 = By.xpath("//input[@id='GPA Claim Amount Year5']");

	// GCI Claims
	private By TotalNoGCIClaimforYear1 = By.xpath("//input[@id='GCI Claim Number Year1']");

	private By TotalAmountGCIClaimforYear1 = By.xpath("//input[@id='GCI Claim Amount Year1']");

	private By TotalNoGCIClaimforYear2 = By.xpath("//input[@id='GCI Claim Number Year2']");

	private By TotalAmountGCIClaimforYear2 = By.xpath("//input[@id='GCI Claim Amount Year2']");

	private By TotalNoGCIClaimforYear3 = By.xpath("//input[@id='GCI Claim Number Year3']");

	private By TotalAmountGCIClaimforYear3 = By.xpath("//input[@id='GCI Claim Amount Year3']");

	private By TotalNoGCIClaimforYear4 = By.xpath("//input[@id='GCI Claim Number Year4']");

	private By TotalAmountGCIClaimforYear4 = By.xpath("//input[@id='GCI Claim Amount Year4']");

	private By TotalNoGCIClaimforYear5 = By.xpath("//input[@id='GCI Claim Number Year5']");

	private By TotalAmountGCIClaimforYear5 = By.xpath("//input[@id='GCI Claim Amount Year5']");

	// GHC Claims
	private By TotalNoGHCClaimforYear1 = By.xpath("//input[@id='GHC Claim Number Year1']");

	private By TotalAmountGHCClaimforYear1 = By.xpath("//input[@id='GHC Claim Amount Year1']");

	private By TotalNoGHCClaimforYear2 = By.xpath("//input[@id='GHC Claim Number Year2']");

	private By TotalAmountGHCClaimforYear2 = By.xpath("//input[@id='GHC Claim Amount Year2']");

	private By TotalNoGHCClaimforYear3 = By.xpath("//input[@id='GHC Claim Number Year3']");

	private By TotalAmountGHCClaimforYear3 = By.xpath("//input[@id='GHC Claim Amount Year3']");

	private By TotalNoGHCClaimforYear4 = By.xpath("//input[@id='GHC Claim Number Year4']");

	private By TotalAmountGHCClaimforYear4 = By.xpath("//input[@id='GHC Claim Amount Year4']");

	private By TotalNoGHCClaimforYear5 = By.xpath("//input[@id='GHC Claim Number Year5']");

	private By TotalAmountGHCClaimforYear5 = By.xpath("//input[@id='GHC Claim Amount Year5']");

	// Loadings
	private By ManagementExpenses = By.xpath("//input[@id='Management Expenses']");

	private By ProfitMargin = By.xpath("//input[@id='Profit Margin']");

	private By UnderwritingLoading = By.xpath("//input[@id='Underwriting Loading Percentage']");

	private By UnderwritingDiscount = By.xpath("//input[@id='Underwriting Discount percentage']");

	// Claims Amount for Year
	private By ClaimsAmountforYear1 = By.xpath("//input[@id='Claims Year1']");

	private By ClaimsAmountforYear2 = By.xpath("//input[@id='Claims Year2']");

	private By ClaimsAmountforYear3 = By.xpath("//input[@id='Claims Year3']");

	private By ClaimsAmountforYear4 = By.xpath("//input[@id='Claims Year4']");

	private By ClaimsAmountforYear5 = By.xpath("//input[@id='Claims Year5']");

	// Save btn
	private By Savebtn = By.xpath("//button[@id='SaveBtn']");

	// Calculate Btn
	private By CalculateBtn = By.xpath("//button[@id='CalculateBtn']");

	// ActiveSecure Assert values
	// Premium Details
	private By PremiumBeforeTaxforYear1Value = By.xpath("//input[@id='Premium Before Tax Year1']");

	private By GSTforYear1Value = By.xpath("//input[@id='GST Year1']");

	private By PremiumAfterTaxforYear1Value = By.xpath("//input[@id='Premium After Tax Year1']");

	private By PerMilleValue = By.xpath("//input[@id='Per Mille']");

	private By MCRPercentageValue = By.xpath("//input[@id='MCR%']");
	
	private By BurningCostPremium = By.xpath("//input[@id='Burning Cost Premium']");

	// Group Arogya Sanjeevani
	private By installment=By.id("Installment");
	private By grossPremiumBeforeGst= By.id("Gross Premium before GST");
	private By gst=By.id("GST");
	private By Fqist= By.id("Final Quote Including Service Tax");


	// ActiveTravel & Protect
	private By RiskInceptionDate = By.xpath("//input[@id='Risk Inception Date']");

	private By RiskExpiryDateTravel = By.xpath("//input[@id='Risk Expiry Date']");

	private By ClaimAnalysisDateTravel = By.xpath("//input[@id='Claim Analysis Date']");

	// Claims History

	private By CountofClaimsonYear1 = By.xpath("//input[@id='Count of Claims on Year 1']");

	private By AmountofClaimsonYear1 = By.xpath("//input[@id='Amount of Claims on Year 1']");

	private By CountofClaimsonYear2 = By.xpath("//input[@id='Count of Claims on Year 2']");

	private By AmountofClaimsonYear2 = By.xpath("//input[@id='Amount of Claims on Year 2']");

	private By CountofClaimsonYear3 = By.xpath("//input[@id='Count of Claims on Year 3']");

	private By AmountofClaimsonYear3 = By.xpath("//input[@id='Amount of Claims on Year 3']");

	private By CountofClaimsonYear4 = By.xpath("//input[@id='Count of Claims on Year 4']");

	private By AmountofClaimsonYear4 = By.xpath("//input[@id='Amount of Claims on Year 4']");

	private By CountofClaimsonYear5 = By.xpath("//input[@id='Count of Claims on Year 5']");

	private By AmountofClaimsonYear5 = By.xpath("//input[@id='Amount of Claims on Year 5']");

	// Travel Details

	private By AverageDurationofthetrip = By.xpath("//input[@id='Average Duration of the trip']");

	private By TotalTravelDays = By.xpath("//input[@id='Total Travel Days']");

	// Loadings

	private By IBNR = By.xpath("//input[@id='IBNR %']");

	private By InflationTravel = By.xpath("//input[@id='Inflation %']");

	/*
	 * private By ManagementExpenses=By.xpath("//input[@id='Management Expenses']");
	 * 
	 * private By ProfitMargin=By.xpath("//input[@id='Profit Margin']");
	 * 
	 * private By UnderwritingLoading
	 * =By.xpath("//input[@id='Underwriting Loading Percentage']");
	 */
	private By UnderwritingDiscountPercentage = By.xpath("//input[@id='Underwriting Discount']");

	// Assert for Active Protect
	// Calculation Output
	private By TotalPremiumbeforeTaxValue = By.xpath("//input[@id='Total Premium before Tax']");

	private By GSTValue = By.xpath("//input[@id='GST']");

	private By TotalPremiumAfterTaxValue = By.xpath("//input[@id='Total Premium after Tax']");

	private By FinalpremiumValue = By.xpath("//input[@id='Final premium']");


	//Other Rating
	//PremiumbeforeTax
	private By PremiumbeforeTax = By.xpath("//input[@id='Premium before Tax']");



	//Quotation Number
	//private By QuotationNumber = By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[1]");

	// CloseBtn
	private By CloseBTN = By.xpath("//button[@id='CloseBtn']");

	private By GrossPremium = By.xpath("//input[@id='Gross Premium RRT']");

	//Assertion
	private By TotalPaidClaimsCount = By.xpath("//input[@id='Total Paid Claims Count']");

	private By TotalPaidClaimsAmount = By.xpath("//input[@id='Total Paid Claims Amount']");


	WebDriverWait wait;

	public GroupQuotationDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void fillGroupQuotationDetailsPage(WebDriver driver, String testCaseName, XSSFWorkbook workbook,
			Connection conn, String stepGroup, CustomAssert customAssert) throws Exception {
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
		Reporter.log("<B>Traverse To GroupQuotationDetailsPage</B>");

		// switchtodefaultframe(driver);
		// switchtoframe(driver,"display");
		// click(GroupQuotationDetails, "Group Quotation Details");
		// switchtoframe(driver,"containerFrame");
		String Parentwindow = driver.getWindowHandle();
		// Quotation Details
		click(QuotationDetailsbtn, "Quotation Details btn");

		switchToWindow(driver);
		// Quotation Start Date

		//clearAndSenKeys(QuotationStartDate, dataRow.getProperty("QuotationStartDate"), "Quotation Start Date");
		DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
		Date obj = new Date();
		String acurrdate=dfor.format(obj);
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String actualdate=date.format(formatter);
		clearAndSenKeys(QuotationStartDate,actualdate,"Quotation Start Date");
		Thread.sleep(WaitTime.low);
		sendOneKeys(QuotationStartDate, Keys.TAB, "DOB");

		// Quotation End Date

		//	clearAndSenKeys(QuotationEndDate, dataRow.getProperty("QuotationEndDate"), "Quotation End Date");

		// Premium Calculation Basis

		selectFromDropdownByVisibleText(PremiumCalculationBasis, dataRow.getProperty("PremiumCalculationBasis"),
				"Premium Calculation Basis");

		// Create Quotation Btn
		click(CreateQuotationBtn, "Create Quotation Btn");


		String QuotationNo = fetchTextFromApplication(QuoteCreationNumber, "Group Quotation Number");
		String QuoteNo = QuotationNo.replaceAll("[^0-9]", "");
		click(OKBtn, "OK Btn");

		// Close

		click(CloseBtn, "Close Btn");
		driver.switchTo().window(Parentwindow);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");
		// Quotation number --GQ121780359
		WebElement QuotationNumber = driver.findElement(By.partialLinkText(QuoteNo));

		clickWebElement(QuotationNumber, "Group Quotation Number");






		switchToWindow(driver);

		// If Flow equals To RackRates
		if (dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Rack Rates")) {

			//String InstallmentAmountval =fetchTextFromApplication(InstallmentAmount,"Installment Amount").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
			// Assert.assertEquals("Expected value",InstallmentAmount,dataRow.getProperty("InstallmentAmount_Assert").replace(",",""));

			//String InstallmentPremiumval = fetchTextFromApplication(InstallmentPremium,"InstallmentPremium").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
			//Assert.assertEquals("Expected value",InstallmentPremium,dataRow.getProperty("InstallmentAmount_Assert").replace(",",""));

			// Save BTN
			click(Savebtn, "Save BTN");


			// Ok btn
			click(OKBtn, "Ok");

			// CalculateBTN
			click(CalculateBtn, "Calculate BTN");

			SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));


			// Ok btn
			click(OKBtn, "Ok");
			Thread.sleep(WaitTime.low);

			//Assert

			/*
			 * String GrossPremiumval =
			 * fetchTextFromAngularApplication(GrossPremium,"Gross Premium").toString();
			 * Assert.assertEquals("Expected value",GrossPremiumval,dataRow.getProperty(
			 * "GrossPremium_Assert").replace(",",""));
			 * Reporter.log("                     "); Reporter.log("---------------------");
			 * 
			 * Reporter.log("");
			 * Reporter.log("<B> -------------------------------------------</B>");
			 * Reporter.log("<B>  Gross Premium </B>");
			 * Reporter.log("<B> GrossPremium:-  </B>"+
			 * fetchTextFromApplication(GrossPremium,"Gross Premium From Application"));
			 * Reporter.log("<B> Gross Premium_Assert:-  </B>"+
			 * dataRow.getProperty("GrossPremium_Assert"));
			 * if(GrossPremiumval==dataRow.getProperty("GrossPremium_Assert")) {
			 * Reporter.log("<B>  PASS </B>"); } else { Reporter.log("<B>  FAIL </B>"); }
			 * Reporter.log("<B> -------------------------------------------</B>");
			 */





			// Close BTN
			click(CloseBTN, "Close BTN");

		}




		// If Flow equals To Other Rating
		if (dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Other Rating"))
		{
			//PremiumbeforeTax
			clearAndSenKeys(PremiumbeforeTax, dataRow.getProperty("PremiumbeforeTax"),"Premium before Tax");

			// Save BTN
			click(Savebtn, "Save BTN");
			Thread.sleep(WaitTime.low);

			// Ok btn
			click(OKBtn, "Ok");

			// CalculateBTN
			click(CalculateBtn, "Calculate BTN");

			// Ok btn
			click(OKBtn, "Ok");

			// Close BTN
			click(CloseBTN, "Close BTN");
		}






		if (dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Burning Cost")) {

			// Group Arogya Sanjeevani (4231)

			Thread.sleep(WaitTime.low);

			if (dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)")|| dataRow.getProperty("Product").equalsIgnoreCase("Activ Health V2 (5211)")
					|| dataRow.getProperty("Product").equalsIgnoreCase("Group Arogya Sanjeevani (4231)")) {

				// Paid Cashless Claims Count
				clearAndSenKeys(PaidCashlessClaimsCount, dataRow.getProperty("Paid Cashless Claims Count"),
						"Paid Cashless Claims Count");

				// Paid Cashless Claims Amount
				clearAndSenKeys(PaidCashlessClaimsAmount, dataRow.getProperty("Paid Cashless Claims Amount"),
						"Paid Cashless Claims Amount");

				// Paid Reimbursement Claims Count
				clearAndSenKeys(PaidReimbursementClaimsCount, dataRow.getProperty("Paid Reimbursement Claims Count"),
						"Paid Reimbursement Claims Count");

				// Paid Reimbursement Claims Amount
				clearAndSenKeys(PaidReimbursementClaimsAmount, dataRow.getProperty("Paid Reimbursement Claims Amount"),
						"Paid Reimbursement Claims Amount");

				// Outstanding Cashless Claims Count
				clearAndSenKeys(OutstandingCashlessClaimsCount,
						dataRow.getProperty("Outstanding Cashless Claims Count"), "Outstanding Cashless Claims Count");

				// Outstanding Cashless Claims Amount
				clearAndSenKeys(OutstandingCashlessClaimsAmount,
						dataRow.getProperty("Outstanding Cashless Claims Amount"),
						"Outstanding Cashless Claims Amount");

				// Outstanding Reimbursement Claims Count
				clearAndSenKeys(OutstandingReimbursementClaimsCount,
						dataRow.getProperty("Outstanding Reimbursement Claims Count"),
						"Outstanding Reimbursement Claims Count");

				// Outstanding Reimbursement Claims Amount
				clearAndSenKeys(OutstandingReimbursementClaimsAmount,
						dataRow.getProperty("Outstanding Reimbursement Claims Amount"),
						"Outstanding Reimbursement Claims Amount");

				// Closed Cashless Claims Count
				clearAndSenKeys(ClosedCashlessClaimsCount, dataRow.getProperty("Closed Cashless Claims Count"),
						"Closed Cashless Claims Count");

				// Closed Cashless Claims Amount
				clearAndSenKeys(ClosedCashlessClaimsAmount, dataRow.getProperty("Closed Cashless Claims Amount"),
						"Closed Cashless Claims Amount");

				// Closed Reimbursement Claims Count
				clearAndSenKeys(ClosedReimbursementClaimsCount,
						dataRow.getProperty("Closed Reimbursement Claims Count"), "Closed Reimbursement Claims Count");

				// Closed Reimbursement Claims Amount
				clearAndSenKeys(ClosedReimbursementClaimsAmount,
						dataRow.getProperty("Closed Reimbursement Claims Amount"),
						"Closed Reimbursement Claims Amount");

				// Claimed amount for paid claims
				clearAndSenKeys(Claimedamountforpaidclaims, dataRow.getProperty("Claimed amount for paid claims"),
						"Claimed amount for paid claims");

				// No. of lives at inception
				clearAndSenKeys(Nooflivesatinception, dataRow.getProperty("No. of lives at inception"),
						"No. of lives at inception");

				// Proposed count
				clearAndSenKeys(Proposedcount, dataRow.getProperty("Proposed count"), "Proposed count");

				// Claimed Amount for Paid claims
				clearAndSenKeys(ClaimedAmountforPaidclaims, dataRow.getProperty("Claimed Amount for Paid claims"),
						"Claimed Amount for Paid claims");

				// Average Delay in Registration of Reimbursement Claims
				clearAndSenKeys(AverageDelayRegistrationClaims,
						dataRow.getProperty("Average Delay in Registration of Reimbursement Claims"),
						"Average Delay in Registration of Reimbursement Claims");

				// Premium at inception(excluding ST)
				clearAndSenKeys(PremiuminceptionExcludingST, dataRow.getProperty("Premium at inception(excluding ST)"),
						"Premium at inception(excluding ST)");

				// Premium paid as of date(Total Premium)
				clearAndSenKeys(TotalPremiumpaidasofdate, dataRow.getProperty("Premium paid as of date(Total Premium)"),
						"Premium paid as of date(Total Premium)");

				// Large Claims
				clearAndSenKeys(LargeClaims, dataRow.getProperty("Large Claims"), "Large Claims");

				// Claims Discount
				clearAndSenKeys(ClaimsDiscount, dataRow.getProperty("Claims Discount"), "Claims Discount");

				// Date of Claims Analysis
				clearAndSenKeys(ClaimAnalysisDate, dataRow.getProperty("Date of Claims Analysis"),
						"Date of Claims Analysis");

				// Risk Inception Date
				clearAndSenKeys(PolicyStartDate, actualdate, "Risk Inception Date");

				// Member at inception
				clearAndSenKeys(MemberAtInception, dataRow.getProperty("No. of lives at inception"),
						"Member at inception");

				// Proposed count
				clearAndSenKeys(ProposedCount, dataRow.getProperty("Proposed count"), "Proposed count");

				// Requested Premium
				clearAndSenKeys(RequestedPremium, dataRow.getProperty("Premium at inception(excluding ST)"),
						"Requested Premium");

				// Approved MCR
				clearAndSenKeys(ApprovedMCR, dataRow.getProperty("Approved MCR"), "Approved MCR");

				// Inflation
				clearAndSenKeys(Inflation, dataRow.getProperty("Inflation"), "Inflation");

				// Health Assessment Gross Premium Per Life
				clearAndSenKeys(HealthAssessmentGrossPremiumPerLife, dataRow.getProperty("UW rate"),
						"Health Assessment Gross Premium Per Life");

				// Risk Expiry Date
				clearAndSenKeys(RiskExpiryDate, dataRow.getProperty("Risk Expiry Date"), "Risk Expiry Date");

				// UW Loading
				clearAndSenKeys(UWLoading, dataRow.getProperty("Loading"), "UW Loading");

				// UW Discount
				clearAndSenKeys(UWDiscount, dataRow.getProperty("Discounting"), "UW Discount");

				// Rack Rate Premium
				clearAndSenKeys(RackRatePremium, dataRow.getProperty("RackRatePremium"), "Rack Rate Premium");

				// Level of Confidence
				selectFromDropdownByVisibleText(LevelofConfidence, dataRow.getProperty("LevelofConfidence"),
						"Level of Confidence");

				// Level of Tolerance
				selectFromDropdownByVisibleText(LevelofTolerance, dataRow.getProperty("LevelofTolerance"),
						"Level of Tolerance");

				// Save btn
				click(Savebtn, "Save");


				// Ok btn
				click(OKBtn, "Ok");

				// Calculate Btn
				click(CalculateBtn, "Calculate");
				Thread.sleep(WaitTime.low);

				// Ok btn
				click(OKBtn, "Ok");

				//Assertion
				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)"))
				{
					// Ok btn
					click(OKBtn, "Ok");

					String TotalPaidClaimsCount_X = fetchTextFromAngularApplication(TotalPaidClaimsCount,"Total Paid Claims Count").toString().replace(".00", "");
					Assert.assertEquals("Expected value", TotalPaidClaimsCount_X,dataRow.getProperty("Total Paid Claims Count").replace(",", ""));


					String TotalPaidClaimsAmount_X = fetchTextFromAngularApplication(TotalPaidClaimsAmount,"Total Paid Claims Amount").toString().replace(".00", "");
					Assert.assertEquals("Expected value", TotalPaidClaimsAmount_X,dataRow.getProperty("Total Paid Claims Amount").replace(",", ""));

					Reporter.log("");
					Reporter.log("<B> -------------------------------------------</B>");
					Reporter.log("<B> Total Paid Claims Count:-  </B>"+dataRow.getProperty("Total Paid Claims Count"));
					Reporter.log("<B> Total Paid Claims Amount:-  </B>"+dataRow.getProperty("Total Paid Claims Amount"));
					Reporter.log("<B>After calculation</B>");
					Reporter.log("<B> Total Paid Claims Count:-  </B>"+TotalPaidClaimsCount_X);
					Reporter.log("<B> Total Paid Claims Amount:-  </B>"+TotalPaidClaimsAmount_X);

					Reporter.log("<B> -------------------------------------------</B>");




				}

				//-------------------------------------------------------------assertion for Group arogya sanjeevani-------------------------------
				//				String GrossPremiumBeforeGST = fetchTextFromApplication(grossPremiumBeforeGst,
				//						"Gross Premium before GST").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				//				Assert.assertEquals("Expected value", GrossPremiumBeforeGST,
				//						dataRow.getProperty("Gross Premium before GST").replace(",", ""));
				//
				//				String Installment = fetchTextFromApplication(installment, "Installment").toString().replace("₹ ", "")
				//						.replace(",", "").replace(".00", "");
				//				Assert.assertEquals("Expected value", Installment, dataRow.getProperty("Installment").replace(",", ""));
				//
				//				String Gst = fetchTextFromApplication(gst, "GST").toString().replace("₹ ", "").replace(",", "")
				//						.replace(".00", "");
				//				Assert.assertEquals("Expected value", Gst, dataRow.getProperty("GST").replace(",", ""));
				//
				//				String FQist = fetchTextFromApplication(Fqist, "Final Quote Including Service Tax").toString()
				//						.replace("₹ ", "").replace(",", "").replace(".00", "");
				//				Assert.assertEquals("Expected value", FQist,
				//						dataRow.getProperty("Final Quote Including Service Tax").replace(",", ""));
				//
				//				 Reporter.log("");
				//					Reporter.log("<B> -------------------------------------------</B>");
				//					Reporter.log("<B>After calculation</B>");
				//					Reporter.log("<B>Installment:-  </B>"+fetchTextFromApplication(installment,"Installment"));
				//					Reporter.log("<B>Gross Premium before GST:-  </B>"+fetchTextFromApplication(grossPremiumBeforeGst,"GST for Year 1"));
				//					Reporter.log("<B>GST:-  </B>"+fetchTextFromApplication(gst,"GST"));
				//					Reporter.log("<B>Final Quote Including Service Tax:-  </B>"+fetchTextFromApplication(Fqist,"Final Quote Including Service Tax"));	
				//					Reporter.log("<B> -------------------------------------------</B>");


				// CloseBtn
				click(CloseBtn, "Close");

				if (dataRow.getProperty("Product").equalsIgnoreCase("Group Arogya Sanjeevani (4231)")) {


					driver.switchTo().window(Parentwindow);
					switchtoframe(driver, "display");
					switchtoframe(driver, "containerFrame");
					// Quotation number --GQ121780359


					clickWebElement(QuotationNumber, "Group Quotation Number");
					switchToWindow(driver);
					WebElement MCRatRequestedPremiumele = driver.findElement(By.xpath("//input[@id='MCR at requested Premium']"));
					// String Amt = element.getText();
					String 	MCRatRequestedPremium = 	MCRatRequestedPremiumele.getAttribute("value");
					System.out.println(MCRatRequestedPremium);
					// Approved MCR
					clearAndSenKeys(ApprovedMCR, MCRatRequestedPremium, "Approved MCR");

					// Save btn
					click(Savebtn, "Save");

					// Ok btn
					click(OKBtn, "Ok");

					// Calculate Btn
					click(CalculateBtn, "Calculate");
					Thread.sleep(WaitTime.low);

					// CloseBtn
					click(CloseBtn, "Close");

				}

			}

			if (dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)")) {
				// GPA Claims
				clearAndSenKeys(TotalNoGPAClaimforYear1, dataRow.getProperty("TotalNoGPAClaimforYear1"),
						"Total Number GPA Claim for Year1");

				clearAndSenKeys(TotalAmountGPAClaimforYear1, dataRow.getProperty("TotalAmountGPAClaimforYear1"),
						"Total Amount GPA Claim for Year1");

				clearAndSenKeys(TotalNoGPAClaimforYear2, dataRow.getProperty("TotalNoGPAClaimforYear2"),
						"Total Number GPA Claim for Year2");

				clearAndSenKeys(TotalAmountGPAClaimforYear2, dataRow.getProperty("TotalAmountGPAClaimforYear2"),
						"Total Amount GPA Claim for Year2");

				clearAndSenKeys(TotalNoGPAClaimforYear3, dataRow.getProperty("TotalNoGPAClaimforYear3"),
						"Total Number GPA Claim for Year3");

				clearAndSenKeys(TotalAmountGPAClaimforYear3, dataRow.getProperty("TotalAmountGPAClaimforYear3"),
						"Total Amount GPA Claim for Year3");

				clearAndSenKeys(TotalNoGPAClaimforYear4, dataRow.getProperty("TotalNoGPAClaimforYear4"),
						"Total Number GPA Claim for Year4");

				clearAndSenKeys(TotalAmountGPAClaimforYear4, dataRow.getProperty("TotalAmountGPAClaimforYear4"),
						"Total Amount GPA Claim for Year4");

				clearAndSenKeys(TotalNoGPAClaimforYear5, dataRow.getProperty("TotalNoGPAClaimforYear5"),
						"Total Number GPA Claim for Year5");

				clearAndSenKeys(TotalAmountGPAClaimforYear5, dataRow.getProperty("TotalAmountGPAClaimforYear5"),
						"Total Amount GPA Claim for Year5");

				// GCI Claims
				clearAndSenKeys(TotalNoGCIClaimforYear1, dataRow.getProperty("TotalNoGCIClaimforYear1"),
						"Total Number GCI Claim for Year1");

				clearAndSenKeys(TotalAmountGCIClaimforYear1, dataRow.getProperty("TotalAmountGCIClaimforYear1"),
						"Total Amount GCI Claim for Year1");

				clearAndSenKeys(TotalNoGCIClaimforYear2, dataRow.getProperty("TotalNoGCIClaimforYear2"),
						"Total Number GCI Claim for Year2");

				clearAndSenKeys(TotalAmountGCIClaimforYear2, dataRow.getProperty("TotalAmountGCIClaimforYear2"),
						"Total Amount GCI Claim for Year2");

				clearAndSenKeys(TotalNoGCIClaimforYear3, dataRow.getProperty("TotalNoGCIClaimforYear3"),
						"Total Number GCI Claim for Year3");

				clearAndSenKeys(TotalAmountGCIClaimforYear3, dataRow.getProperty("TotalAmountGCIClaimforYear3"),
						"Total Amount GCI Claim for Year3");

				clearAndSenKeys(TotalNoGCIClaimforYear4, dataRow.getProperty("TotalNoGCIClaimforYear4"),
						"Total Number GCI Claim for Year4");

				clearAndSenKeys(TotalAmountGCIClaimforYear4, dataRow.getProperty("TotalAmountGCIClaimforYear4"),
						"Total Amount GCI Claim for Year4");

				clearAndSenKeys(TotalNoGCIClaimforYear5, dataRow.getProperty("TotalNoGCIClaimforYear5"),
						"Total Number GCI Claim for Year5");

				clearAndSenKeys(TotalAmountGCIClaimforYear5, dataRow.getProperty("TotalAmountGCIClaimforYear5"),
						"Total Amount GCI Claim for Year5");

				// GHC Claims
				clearAndSenKeys(TotalNoGHCClaimforYear1, dataRow.getProperty("TotalNoGHCClaimforYear1"),
						"Total Number GHC Claim for Year1");

				clearAndSenKeys(TotalAmountGHCClaimforYear1, dataRow.getProperty("TotalAmountGHCClaimforYear1"),
						"Total Amount GHC Claim for Year1");

				clearAndSenKeys(TotalNoGHCClaimforYear2, dataRow.getProperty("TotalNoGHCClaimforYear2"),
						"Total Number GHC Claim for Year2");

				clearAndSenKeys(TotalAmountGHCClaimforYear2, dataRow.getProperty("TotalAmountGHCClaimforYear2"),
						"Total Amount GHC Claim for Year2");

				clearAndSenKeys(TotalNoGHCClaimforYear3, dataRow.getProperty("TotalNoGHCClaimforYear3"),
						"Total Number GHC Claim for Year3");

				clearAndSenKeys(TotalAmountGHCClaimforYear3, dataRow.getProperty("TotalAmountGHCClaimforYear3"),
						"Total Amount GHC Claim for Year3");

				clearAndSenKeys(TotalNoGHCClaimforYear4, dataRow.getProperty("TotalNoGHCClaimforYear4"),
						"Total Number GHC Claim for Year4");

				clearAndSenKeys(TotalAmountGHCClaimforYear4, dataRow.getProperty("TotalAmountGHCClaimforYear4"),
						"Total Amount GHC Claim for Year4");

				clearAndSenKeys(TotalNoGHCClaimforYear5, dataRow.getProperty("TotalNoGHCClaimforYear5"),
						"Total Number GHC Claim for Year5");

				clearAndSenKeys(TotalAmountGHCClaimforYear5, dataRow.getProperty("TotalAmountGHCClaimforYear5"),
						"Total Amount GHC Claim for Year5");

				// Loadings
				clearAndSenKeys(ManagementExpenses, dataRow.getProperty("ManagementExpenses"), "Management Expenses");

				clearAndSenKeys(ProfitMargin, dataRow.getProperty("ProfitMargin"), "Profit Margin");

				clearAndSenKeys(UnderwritingLoading, dataRow.getProperty("UnderwritingLoading"), "UnderwritingLoading");

				clearAndSenKeys(UnderwritingDiscount, dataRow.getProperty("UnderwritingDiscount"),
						"UnderwritingDiscount");

				// Claims Amount for Year
				clearAndSenKeys(ClaimsAmountforYear1, dataRow.getProperty("ClaimsAmountforYear1"),
						"Claims Amount for Year1");

				clearAndSenKeys(ClaimsAmountforYear2, dataRow.getProperty("ClaimsAmountforYear2"),
						"Claims Amount for Year2");

				clearAndSenKeys(ClaimsAmountforYear3, dataRow.getProperty("ClaimsAmountforYear3"),
						"Claims Amount for Year3");

				clearAndSenKeys(ClaimsAmountforYear4, dataRow.getProperty("ClaimsAmountforYear1"),
						"Claims Amount for Year4");

				clearAndSenKeys(ClaimsAmountforYear5, dataRow.getProperty("ClaimsAmountforYear1"),
						"Claims Amount for Year5");

				// Rack Rate Premium
				clearAndSenKeys(RackRatePremium, dataRow.getProperty("RackRatePremium"), "Rack Rate Premium");

				// Level of Confidence
				selectFromDropdownByVisibleText(LevelofConfidence, dataRow.getProperty("LevelofConfidence"),
						"Level of Confidence");

				// Level of Tolerance
				selectFromDropdownByVisibleText(LevelofTolerance, dataRow.getProperty("LevelofTolerance"),
						"Level of Tolerance");

				// Save btn
				click(Savebtn, "Save");


				// Ok btn
				click(OKBtn, "Ok");

				// Calculate Btn
				click(CalculateBtn, "Calculate");

				SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
				// Ok btn
				click(OKBtn, "Ok");



				
				/*
				 * String GSTforYear1val
				 * =fetchTextFromApplication(GSTforYear1Value,"GST for Year 1").toString().
				 * replace("₹ ", "").replace(",", "").replace(".00", "");
				 * Assert.assertEquals("Expected value",GSTforYear1val,dataRow.getProperty(
				 * "GSTforYear1").replace(",",""));
				 * 
				 * String PremiumAfterTaxforYear1val = fetchTextFromApplication(
				 * PremiumAfterTaxforYear1Value,"Premium After Tax for Year1").toString().
				 * replace("₹ ", "").replace(",", "").replace(".00", "");
				 * Assert.assertEquals("Expected value",PremiumAfterTaxforYear1val,dataRow.
				 * getProperty("PremiumAfterTaxforYear1").replace(",",""));
				 * 
				 * 
				 * String PerMilleval
				 * =fetchTextFromApplication(PerMilleValue,"Per Mille").toString().replace("₹ "
				 * ,"").replace(",", "").replace(".00", "");
				 * Assert.assertEquals("Expected value",PerMilleval,dataRow.getProperty(
				 * "PerMille").replace(",",""));
				 * 
				 * String MCRPercentageval
				 * =fetchTextFromApplication(MCRPercentageValue,"MCR %").toString().replace("₹ "
				 * ,"").replace(",", "").replace(".00", "");
				 * Assert.assertEquals("Expected value",MCRPercentageval,dataRow.getProperty(
				 * "MCRPercentage").replace(",",""));
				 */

				String BurningCostPremium_x = fetchTextFromAngularApplication(BurningCostPremium,"Burning Cost Premium").toString();
				Assert.assertEquals("Expected value",BurningCostPremium_x,dataRow.getProperty("PremiumBeforeTaxforYear1").replace(",",""));



				Reporter.log("");
				Reporter.log("<B> -------------------------------------------</B>");
				Reporter.log("<B>After calculation</B>");
				Reporter.log("<B> Premium Before Tax for Year1 Value From Data:-  </B>"+dataRow.getProperty("PremiumBeforeTaxforYear1"));
				Reporter.log("<B> Premium Before Tax for Year1 Value From Application:-  </B>"+fetchTextFromApplication(PremiumBeforeTaxforYear1Value,"Premium Before Tax for Year1"));
				Reporter.log("<B> Burning Cost Premium :-  </B>"+BurningCostPremium_x);

				Reporter.log("<B> -------------------------------------------</B>");


				// CloseBtn
				click(CloseBtn, "Close");


				//Assertion
				/*String PremiumBeforeTaxforYear1val = fetchTextFromApplication(PremiumBeforeTaxforYear1Value,"Premium Before Tax for Year1").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				 Assert.assertEquals("Expected value",PremiumBeforeTaxforYear1val,dataRow.getProperty("PremiumBeforeTaxforYear1").replace(",",""));

				 String GSTforYear1val =fetchTextFromApplication(GSTforYear1Value,"GST for Year 1").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				 Assert.assertEquals("Expected value",GSTforYear1val,dataRow.getProperty("GSTforYear1").replace(",",""));

				 String PremiumAfterTaxforYear1val = fetchTextFromApplication(PremiumAfterTaxforYear1Value,"Premium After Tax for Year1").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				 Assert.assertEquals("Expected value",PremiumAfterTaxforYear1val,dataRow.getProperty("PremiumAfterTaxforYear1").replace(",",""));


				 String PerMilleval =fetchTextFromApplication(PerMilleValue,"Per Mille").toString().replace("₹ ","").replace(",", "").replace(".00", "");
				 Assert.assertEquals("Expected value",PerMilleval,dataRow.getProperty("PerMille").replace(",",""));

				 String MCRPercentageval =fetchTextFromApplication(MCRPercentageValue,"MCR %").toString().replace("₹ ","").replace(",", "").replace(".00", "");
				 Assert.assertEquals("Expected value",MCRPercentageval,dataRow.getProperty("MCRPercentage").replace(",",""));

				 */
				/*String PremiumBeforeTaxforYear1val = fetchTextFromApplication(PremiumBeforeTaxforYear1Value, "Premium Before Tax for Year1");
				System.out.println("Premium Before Tax for Year1"+ PremiumBeforeTaxforYear1val);
				 Reporter.log("");
				 Reporter.log("<B> -------------------------------------------</B>");
				 Reporter.log("<B>After calculation</B>");
				 Reporter.log("<B> Premium Before Tax for Year1 Value:-  </B>"+fetchTextFromApplication(PremiumBeforeTaxforYear1Value,"Premium Before Tax for Year1"));
				 Reporter.log("<B> GST for Year 1 Value:-  </B>"+fetchTextFromApplication(GSTforYear1Value,"GST for Year 1"));
				 Reporter.log("<B>Premium After Tax for Year1 Value:-  </B>"+fetchTextFromApplication(PremiumAfterTaxforYear1Value,"Premium After Tax for Year1"));
				 Reporter.log("<B>Per Mille Value:-  </B>"+fetchTextFromApplication(PerMilleValue,"Per Mille"));
				 Reporter.log("<B> MCR % Value:-  </B>"+fetchTextFromApplication(MCRPercentageValue,"MCR %"));


				 Reporter.log("<B> -------------------------------------------</B>");
				 */

			}

			if (dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")
					|| dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")) {
				clearAndSenKeys(RiskInceptionDate,dataRow.getProperty("RiskInceptionDate"),"Risk Inception Date");	

				clearAndSenKeys(RiskExpiryDateTravel,dataRow.getProperty("RiskExpiryDate"),"Risk Expiry Date");	

				clearAndSenKeys(ClaimAnalysisDateTravel,dataRow.getProperty("ClaimAnalysisDate"),"Claim Analysis Date");	

				//Claims History
				clearAndSenKeys(CountofClaimsonYear1,dataRow.getProperty("CountofClaimsonYear1"),"Count of Claims on Year1");	

				clearAndSenKeys(AmountofClaimsonYear1,dataRow.getProperty("AmountofClaimsonYear1"),"Amount of Claims on Year1");	

				clearAndSenKeys(CountofClaimsonYear2,dataRow.getProperty("CountofClaimsonYear2"),"Count of Claims on Year2");	

				clearAndSenKeys(AmountofClaimsonYear2,dataRow.getProperty("AmountofClaimsonYear2"),"Amount of Claims on Year2");	

				clearAndSenKeys(CountofClaimsonYear3,dataRow.getProperty("CountofClaimsonYear3"),"Count of Claims on Year3");

				clearAndSenKeys(AmountofClaimsonYear3,dataRow.getProperty("AmountofClaimsonYear3"),"Amount of Claims on Year3");	

				clearAndSenKeys(CountofClaimsonYear4,dataRow.getProperty("CountofClaimsonYear4"),"Count of Claims on Year4");	

				clearAndSenKeys(AmountofClaimsonYear4,dataRow.getProperty("AmountofClaimsonYear4"),"Amount of Claims on Year4");	

				clearAndSenKeys(CountofClaimsonYear5,dataRow.getProperty("CountofClaimsonYear5"),"Count of Claims on Year5");	

				clearAndSenKeys(AmountofClaimsonYear5,dataRow.getProperty("AmountofClaimsonYear5"),"Amount of Claims on Year5");	

				//Travel Details
				clearAndSenKeys(AverageDurationofthetrip,dataRow.getProperty("AverageDurationofthetrip"),"Average Duration of the trip");	

				clearAndSenKeys(TotalTravelDays,dataRow.getProperty("TotalTravelDays"),"Total Travel Days");

				//Loadings
				clearAndSenKeys(IBNR,dataRow.getProperty("IBNR"),"IBNR");

				clearAndSenKeys(InflationTravel,dataRow.getProperty("Inflation"),"Inflation2");

				clearAndSenKeys(ManagementExpenses,dataRow.getProperty("ManagementExpenses"),"Management Expenses");

				clearAndSenKeys(ProfitMargin,dataRow.getProperty("ProfitMargin"),"Profit Margin");

				clearAndSenKeys(UnderwritingLoading,dataRow.getProperty("UnderwritingLoadingPercentage"),"Underwriting Loading Percentage");

				clearAndSenKeys(UnderwritingDiscountPercentage,dataRow.getProperty("UnderwritingDiscount"),"Underwriting Discount");

				clearAndSenKeys(RackRatePremium,dataRow.getProperty("RackRatePremium"),"Rack Rate Premium 2");

				selectFromDropdownByVisibleText(LevelofConfidence,dataRow.getProperty("LevelofConfidence"),"Level of Confidence");

				selectFromDropdownByVisibleText(LevelofTolerance,dataRow.getProperty("LevelofTolerance"),"Level of Confidence");

				//Save btn
				click(Savebtn, "Save");
				Thread.sleep(WaitTime.low);

				//Ok btn
				click(OKBtn,"Ok");

				// Calculate Btn
				click(CalculateBtn,"Calculate");
				Thread.sleep(WaitTime.low);

				//Vignesh20/08/2021

				//	 			String TotalPremiumBeforeTax = fetchTextFromApplication(TotalPremiumbeforeTax,"Total Premium Before Tax").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				//				Assert.assertEquals("Expected value",TotalPremiumBeforeTax, dataRow.getProperty("TotalPremiumbeforeTax").replace(",",""));
				//				
				//				String GST1 = fetchTextFromApplication(GST,"GST").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				//				Assert.assertEquals("Expected value",GST1, dataRow.getProperty("GST").replace(",",""));
				//				
				//				String TotalPremiumAfterTax = fetchTextFromApplication(TotalPremiumafterTax,"Total Premium Before Tax").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				//				Assert.assertEquals("Expected value",TotalPremiumAfterTax, dataRow.getProperty("TotalPremiumafterTax").replace(",",""));
				//				
				//				Thread.sleep(WaitTime.low);

				//CloseBtn
				click(CloseBtn,"Close");
			}

			if (dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)")
					|| dataRow.getProperty("Product").equalsIgnoreCase("Group Protect v2 (5224)")) {
				clearAndSenKeys(RiskInceptionDate, dataRow.getProperty("RiskInceptionDate"), "Risk Inception Date");

				clearAndSenKeys(RiskExpiryDateTravel, dataRow.getProperty("RiskExpiryDate"), "Risk Expiry Date");

				clearAndSenKeys(ClaimAnalysisDateTravel, dataRow.getProperty("ClaimAnalysisDate"),
						"Claim Analysis Date");

				// Claims History
				clearAndSenKeys(CountofClaimsonYear1, dataRow.getProperty("CountofClaimsonYear1"),
						"Count of Claims on Year1");

				clearAndSenKeys(AmountofClaimsonYear1, dataRow.getProperty("AmountofClaimsonYear1"),
						"Amount of Claims on Year1");

				clearAndSenKeys(CountofClaimsonYear2, dataRow.getProperty("CountofClaimsonYear2"),
						"Count of Claims on Year2");

				clearAndSenKeys(AmountofClaimsonYear2, dataRow.getProperty("AmountofClaimsonYear2"),
						"Amount of Claims on Year2");

				clearAndSenKeys(CountofClaimsonYear3, dataRow.getProperty("CountofClaimsonYear3"),
						"Count of Claims on Year3");

				clearAndSenKeys(AmountofClaimsonYear3, dataRow.getProperty("AmountofClaimsonYear3"),
						"Amount of Claims on Year3");

				clearAndSenKeys(CountofClaimsonYear4, dataRow.getProperty("CountofClaimsonYear4"),
						"Count of Claims on Year4");

				clearAndSenKeys(AmountofClaimsonYear4, dataRow.getProperty("AmountofClaimsonYear4"),
						"Amount of Claims on Year4");

				clearAndSenKeys(CountofClaimsonYear5, dataRow.getProperty("CountofClaimsonYear5"),
						"Count of Claims on Year5");

				clearAndSenKeys(AmountofClaimsonYear5, dataRow.getProperty("AmountofClaimsonYear5"),
						"Amount of Claims on Year5");

				// Loadings
				clearAndSenKeys(IBNR, dataRow.getProperty("IBNR"), "IBNR");

				clearAndSenKeys(InflationTravel, dataRow.getProperty("Inflation"), "Inflation2");

				clearAndSenKeys(ManagementExpenses, dataRow.getProperty("ManagementExpenses"), "Management Expenses");

				clearAndSenKeys(ProfitMargin, dataRow.getProperty("ProfitMargin"), "Profit Margin");

				clearAndSenKeys(UnderwritingLoading, dataRow.getProperty("UnderwritingLoadingPercentage"),
						"Underwriting Loading Percentage");

				clearAndSenKeys(UnderwritingDiscountPercentage, dataRow.getProperty("UnderwritingDiscount"),
						"Underwriting Discount");

				clearAndSenKeys(RackRatePremium, dataRow.getProperty("RackRatePremium"), "Rack Rate Premium 2");

				selectFromDropdownByVisibleText(LevelofConfidence, dataRow.getProperty("LevelofConfidence"),
						"Level of Confidence");

				selectFromDropdownByVisibleText(LevelofTolerance, dataRow.getProperty("LevelofTolerance"),
						"Level of Confidence");

				// Save btn
				click(Savebtn, "Save");
				Thread.sleep(WaitTime.low);

				// Ok btn
				click(OKBtn, "Ok");

				// Calculate Btn
				click(CalculateBtn, "Calculate");
				Thread.sleep(WaitTime.low);

				// CloseBtn
				click(CloseBtn, "Close");

				String TotalPremiumbeforeTaxval = fetchTextFromApplication(TotalPremiumbeforeTaxValue,"Total Premium before Tax").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				Assert.assertEquals("Expected value", TotalPremiumbeforeTaxval,dataRow.getProperty("TotalPremiumbeforeTax").replace(",", ""));

				String GSTval = fetchTextFromApplication(GSTValue, "GST").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				Assert.assertEquals("Expected value", GSTval, dataRow.getProperty("GST").replace(",", ""));

				String TotalPremiumAfterTaxval = fetchTextFromApplication(TotalPremiumAfterTaxValue,"Total Premium After Tax").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				Assert.assertEquals("Expected value", TotalPremiumAfterTaxval,dataRow.getProperty("TotalPremiumAfterTax").replace(",", ""));

				String Finalpremiumval = fetchTextFromApplication(FinalpremiumValue, "Final premium").toString().replace("₹ ", "").replace(",", "").replace(".00", "");
				Assert.assertEquals("Expected value", Finalpremiumval,dataRow.getProperty("Finalpremium").replace(",", ""));

			}

		}





		driver.switchTo().window(Parentwindow);
		System.out.println(dataRow.getProperty("TCID"));
		System.out.println("Generated Group Quotation No:" + QuotationNumber);
		Reporter.log("<B> -------------------------------------------</B>");

	}

}
