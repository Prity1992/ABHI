package stepDefination;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;

public class StepKeyword extends StepDefination {
	public StepKeyword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void executeTestStep(WebDriver driver,String testScenarioID, String step,String stepGroup,String GSTNID,String ReturnType,XSSFWorkbook workbook,Connection conn,CustomAssert customAssert) throws Exception {
		switch (step){
/*
  Madonna 02-08-2021 For creating and executing TCS Keyword */
		case "Login_Into_NewTCS":
			tcsLogin(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "Login_Into_NewBDB":
			bdbLogin(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "AddBranchPortalHomePage":
			addBranchPortalHomePage(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "CustomerSearchPage":
			customerSearchPage(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "AddCustomerOnboarding":
			addCustomerOnboarding(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
			
		case "Navigate_TO_Quote":
			navigateToQuote(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "Navigate_TO_GroupDetails":
			navigateToGroupDetails(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;	
		case "Navigate_TO_PaymentInfo":
			navigateToPaymentInfo(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "Navigate_TO_EmployeeClassInfo":
			navigateToEmployeeClassInfo(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "Create_PremiumCalculation":
			fillpremiumcalculation(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
			
		case "Create_PolicyNumber":
			PolicyCreation(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
			
		case "Navigate_To_FamilyBasicDetailspage":
			FamilyPolicyBasicDetailsPage(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
			
		case "Navigate_To_FamilyMemberInfoPage":
			familyMemberInfoPage(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
			
		case "Navigate_To_FamilycollectionscreenPage":
			familycollectionscreenPage(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
//		case "Navigate_To_AccountingApplication":
//			AccountingApplicationPage(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
//			break;
		
			
		case "Search_Quote":
			SearchQuote(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		
		case "Logout_from_NewTCS":
			tcsLogout(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
		case "LogOutUserBDB":
			bdbLogout(driver, testScenarioID, workbook, conn,stepGroup,customAssert);
			break;
					
			
	}
}

	
}
	

	

	
	


		


	
		
	