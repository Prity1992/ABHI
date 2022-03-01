package stepDefination;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;

import BDBPages.AddBranchPortalHomePage;
import BDBPages.AddCustomerOnboarding;
import BDBPages.BDBLogout;
import BDBPages.BDBlogin;
import BDBPages.CustomerSearchPage;
import GroupPages.AccountingApplication;
import GroupPages.EmployeeClassInfoPage;
import GroupPages.FamilyCollectionScreen;
import GroupPages.FamilyMemberInfoPage;
import GroupPages.FamilyPolicyBasicDetails;
import GroupPages.GroupBasicDetailsPage;

import GroupPages.GroupQuotationDetailsPage;
import GroupPages.PaymentInfoPage;
import GroupPages.PolicySummaryPage;
import GroupPages.QuoteSearchPage;
import GroupPages.TCSLogout;
import GroupPages.TCSlogin;
import GroupPages.TcsCommonPages;
import util.CustomAssert;
import util.ExcelDatabase;
import util.GenericMethods;

public class StepDefination extends GenericMethods {

	String dbConnectionSheetName = "DatabaseLogin";
	String puttyLoginSheetName = "PuttyLogin";
   static String party="";
	public static String getParty() {
	return party;
}
	
public static void setParty(String party) {
	StepDefination.party = party;
}

	ExcelDatabase excelDatabase = new ExcelDatabase();

    
	public StepDefination(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	
//rahul 11-07-2021  
	public void tcsLogin(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		TCSlogin tcslogin = new TCSlogin(driver);
		tcslogin.fillAndSubmitNewTCSLogin(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	public void bdbLogin(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		BDBlogin bdblogin = new BDBlogin(driver);
		bdblogin.fillAndSubmitNewBDBLogin(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	public void addBranchPortalHomePage(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		AddBranchPortalHomePage addBranchPortalHomePage = new AddBranchPortalHomePage(driver);
		addBranchPortalHomePage.fillAddBranchPortalHomePage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	public void customerSearchPage(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
		customerSearchPage.fillCustomerSearchPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	public void addCustomerOnboarding(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		AddCustomerOnboarding addCustomerOnboarding = new AddCustomerOnboarding(driver);
		addCustomerOnboarding.fillAddCustomerOnboarding(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}

//rahul 11-07-2021
	public void navigateToQuote(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		TcsCommonPages tcsCommon = new TcsCommonPages(driver);
		tcsCommon.navigateToQuote(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void navigateToGroupDetails(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		GroupBasicDetailsPage grpDetails = new GroupBasicDetailsPage(driver);
		grpDetails.fillGroupBasicDetailsPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void navigateToPaymentInfo(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		PaymentInfoPage paymentinfo = new PaymentInfoPage(driver);
		paymentinfo.fillPaymentInfoPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void navigateToEmployeeClassInfo(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		EmployeeClassInfoPage paymentinfo = new EmployeeClassInfoPage(driver);
		paymentinfo.fillEmployeeClassDetailsPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	public void fillpremiumcalculation(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		GroupQuotationDetailsPage groupquotation = new GroupQuotationDetailsPage(driver);
		groupquotation.fillGroupQuotationDetailsPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void SearchQuote(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		QuoteSearchPage quotesearch = new QuoteSearchPage(driver);
		quotesearch.searchQuote(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void PolicyCreation(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		PolicySummaryPage policycreation = new PolicySummaryPage(driver);
		policycreation.fillPolicySummaryPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void FamilyPolicyBasicDetailsPage(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		FamilyPolicyBasicDetails familypolicycreation = new FamilyPolicyBasicDetails(driver);
		familypolicycreation.fillFamilyPolicyBasicDetails(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void familyMemberInfoPage(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		FamilyMemberInfoPage familyMemberInfoPage = new FamilyMemberInfoPage(driver);
		familyMemberInfoPage.fillFamilyMemberInfoPage(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
	public void familycollectionscreenPage(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		FamilyCollectionScreen familyCollectionScreen = new FamilyCollectionScreen(driver);
		familyCollectionScreen.fillcollectionscreen(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}
	
//	public void AccountingApplicationPage(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
//			String stepGroup, CustomAssert customAssert) throws Exception {		
//		AccountingApplication accountingApplication = new AccountingApplication(driver);
//		accountingApplication.createCDandBG(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
//	}
	
	
	
	public void tcsLogout(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
				String stepGroup, CustomAssert customAssert) throws Exception {
			TCSLogout tcslogout = new TCSLogout(driver);
			tcslogout.ClickLogout(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
		}
	public void bdbLogout(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		BDBLogout bdblogout = new BDBLogout(driver);
		bdblogout.ClickLogout(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}

}