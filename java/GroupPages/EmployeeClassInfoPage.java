package GroupPages;

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

public class EmployeeClassInfoPage extends Coverdetails {

	//Click on ADD btn
	private By Addbtn = By.xpath("//button[@id='AddBtn']");

	//	Category Description 
	private By CategoryDescription = By.xpath("//textarea[@id='Category Description']");

	//Currency
	private By Currency = By.xpath("//select[@id='Currency']");
	//Save 
	private By Save = By.xpath("//button[@id='Save']");

	//Save 
	private By Save1 = By.xpath("//button[@id='SaveBtn']");
	//Ok
	private By OKBtn = By.xpath("//button[contains(text(),'OK')]");

	//PED Applicability
	private By PEDApplicability = By.xpath("//select[@id='PED Applicable']");

	//	Base Sum Insured
	private By BaseSumInsuredArogya = By.xpath("//select[@id='Applicable Sum Insured']");

	private By BaseSumInsured = By.xpath("//input[@id='Base Sum Insured']");
	private By BaseSumInsured1 = By.xpath("//input[@id='Applicable Sum Insured']");

	//TripType
	private By TripType = By.xpath("//select[@id='Trip Type1']");

	//TripDurationSingle
	private By TripDurationSingle = By.xpath("//input[@id='Trip Duration']");

	//TripDurationMulty
	private By TripDurationMulty = By.xpath("//select[@id='Trip Duration1']");

	//Total Number of Lives
	private By TotalNoOfLives = By.xpath("//input[@id='Total Number of Lives']");

	//Plan
	private By Plan = By.xpath("//select[@id='Plan']");

	//SubPlan
	private By SubPlan = By.xpath("//select[@id='Sub Plan Type']");

	//Coverage Area
	private By CoverageArea=By.xpath("//select[@id='Coverage Area']");


	//Demographic Details 
	private By demographicDetails = By.xpath("//button[@id='Demographic Details']");

	//from Age
	private By fromAge = By.xpath("//input[@id='From Age']");

	//Family Construct 
	private By FamilyConstruct = By.xpath("//select[@id='Family Construct0']");

	//To Age
	private By toAge = By.xpath("//input[@id='To Age']");

	//Relationship Type
	private By relationshipType = By.xpath("//select[@id='Type Of Relationship0']");

	//Gender
	private By gender = By.xpath("//select[@id='Gender0']");

	//No of lives
	private By nooflives = By.xpath("//input[@id='Number of Lives0']");

	//Sum Insured
	private By applicableSumInsured = By.xpath("//input[@id='Applicable SumInsured0']");

	// Add Row btn 
	private By Addrowbtn = By.xpath("//button[@id='Add Row']");

	// Close btn 
	private By closebtn = By.xpath("//button[@id='CloseBtn']");

	// close btn			
	private By  closebutton = By.xpath("//button[@id='Close']");

	// Continue btn			
	private By  Continue = By.xpath("//button[@id='btncontinue']");



	//Relationship Details
	//Details button
	private By RelationshipDetailsbtn = By.xpath("//button[@id='Relationship Details']");

	//Relationship List
	private By RelationshipList = By.xpath("//select[@id='Relationship0']");
	
	
	//Applicable Reation
		private By ApplicableRelation = By.xpath("//select[@id='Relationship List0']");

	//Relationship Minimum Age
	private By RelationshipMinAge = By.xpath("//input[@id='Minimum Age0']");

	//Relationship Maximum Age
	private By RelationshipMaxAge = By.xpath("//input[@id='Maximum Age0']");

	//Relationshio Exit Age
	private By RelationshipExitAge = By.xpath("//input[@id='Exit Age0']");

	//Relationship Type
	private By RelationshipType = By.xpath("//select[@id='Type Of Relationship0']");

	//Maximum SI
	private By RelationshipMaxSI = By.xpath("//input[@id='Applicable SumInsured0']");



	//coverage list Details
	private By covragelistbtn = By.xpath("//button[@id='Coverage List']");


	//EW Selected
	private By EWSelected = By.xpath("//select[@id='EW Selected']");

	//Welcome Call   	
	private By WelcomeCall = By.xpath("//select[@id='Welcome Call']");


	// Close btn on Covrage List 	


	private By closebtncover = By.xpath("(//button[contains(text(),'Close')])[1]");

	//RiskClass
	private By RiskClass= By.xpath("//select[@id='Risk Class']");
	
	//Sum Insured Type
	
	private By SumInsuredType= By.xpath("//select[@id='Sum Insured Type']");


	//Continue btn		
	private By  continuebtn = By.xpath("//button[@id='btncontinue']");

	public EmployeeClassInfoPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);	
	}

	public void fillEmployeeClassDetailsPage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Traverse To Employee Class Info</B>");


		String Category_Description_ = dataRow.getProperty("CategoryDescription");
		//String Category_Description2 =Category_Description_name.replace(" ", "");
		//ArrayList<String> Category_DescriptionList1 = new ArrayList<String>(Arrays.asList(Category_Description2.split("\\+")));
		ArrayList<String> Category_DescriptionList1 = new ArrayList<String>(Arrays.asList(Category_Description_.split("\\+")));	  

		for (int x = 0; x < Category_DescriptionList1.size(); x++) {


			click(Addbtn, "ADD BTN");
			String Parentwindow = driver.getWindowHandle();
			switchToWindow(driver);



			// Category Description

			String Category_Description = dataRow.getProperty("CategoryDescription");
			String Category_Description1= Category_Description.replace(" ", "");
			ArrayList<String> Categorylist = new ArrayList<String>(Arrays.asList(Category_Description1.split("\\+")));				
			clearAndSenKeys(CategoryDescription,Categorylist.get(x),"Category Description");
			Thread.sleep(WaitTime.low);

			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")) 
			{

				//Currency	 
				String Currencyval = dataRow.getProperty("Currency");
				// String Currencyval1= Currencyval.replace(" ", "");
				//ArrayList<String> CurrencyList = new ArrayList<String>(Arrays.asList(Currencyval1.split("\\+")));	
				ArrayList<String> CurrencyList = new ArrayList<String>(Arrays.asList(Currencyval.split("\\+")));
				selectFromDropdownByVisibleLogin(Currency,CurrencyList.get(x),"Currency");
				Thread.sleep(WaitTime.low);
			}

			//save btn
			sendTwoKeys(By.cssSelector("body"),Keys.CONTROL, Keys.END,"Body Element");
			click(Save, "Save BTN");


			//ok btn

			click(OKBtn, "Ok BTN");

			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)")) {
				//Plan
				String Planval = dataRow.getProperty("Plan");
				//String Planval1= Planval.replace(" ", "");
				//ArrayList<String> PlanList = new ArrayList<String>(Arrays.asList(Planval1.split("\\+")));
				ArrayList<String> PlanList = new ArrayList<String>(Arrays.asList(Planval.split("\\+")));
				selectFromDropdownByVisibleLogin(Plan ,PlanList.get(x),"Plan");

				//SubPlan
				String SubPlanval = dataRow.getProperty("SubPlan");
				//String SubPlanval1= SubPlanval.replace(" ", "");
				ArrayList<String> SubPlanList = new ArrayList<String>(Arrays.asList(SubPlanval.split("\\+")));
				selectFromDropdownByVisibleLogin(SubPlan ,SubPlanList.get(x),"SubPlan");
			}
			if(!dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)")) {

				//PED Applicability
				selectFromDropdownByVisibleText(PEDApplicability,dataRow.getProperty("PEDApplicability"),"PED Applicability");


			}
			Thread.sleep(WaitTime.low);

			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")) {

				//Coverage Area
				String CoverageAreaval = dataRow.getProperty("CoverageArea");
				// String CoverageAreaval1= CoverageAreaval.replace(" ", "");
				//	ArrayList<String> CoverageAreaList = new ArrayList<String>(Arrays.asList(CoverageAreaval1.split("\\+")));
				ArrayList<String> CoverageAreaList = new ArrayList<String>(Arrays.asList(CoverageAreaval.split("\\+")));
				selectFromDropdownByVisibleLogin(CoverageArea,CoverageAreaList.get(x),"Coverage Area");

				selectFromDropdownByVisibleText(TripType,dataRow.getProperty("TripType"),"Trip Type");

				if(dataRow.getProperty("TripType").equalsIgnoreCase("AMTAnnual Multi Trip"))
				{
				selectFromDropdownByVisibleText(TripDurationMulty,dataRow.getProperty("TripDurationAMT"),"Trip Duration AMT");

				Thread.sleep(WaitTime.low);
				}
				else
				{
				clearAndSenKeys(TripDurationSingle,dataRow.getProperty("TripDurationSingle"),"TripDurationSingle");
				Thread.sleep(WaitTime.low);

				}


			}   



			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Arogya Sanjeevani (4231)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Assure - Covid19 (4230)"))
			{
				String BaseSumInsuredArogyaval = dataRow.getProperty("BaseSumInsured");
				String BaseSumInsuredArogyaval1= BaseSumInsuredArogyaval.replace(" ", "");
				ArrayList<String> BaseSumInsuredArogyaList = new ArrayList<String>(Arrays.asList(BaseSumInsuredArogyaval1.split("\\+")));

				selectFromDropdownByVisibleLogin(BaseSumInsuredArogya,BaseSumInsuredArogyaList.get(x),"Base Sum Insured");
			}
			//Base Sum Insured

			String BaseSumInsuredval = dataRow.getProperty("BaseSumInsured");
			String BaseSumInsuredval1= BaseSumInsuredval.replace(" ", "");
			ArrayList<String> BaseSumInsuredList = new ArrayList<String>(Arrays.asList(BaseSumInsuredval1.split("\\+")));	
			if(!dataRow.getProperty("Product").equalsIgnoreCase("Group Assure - Covid19 (4230)")){


				clearAndSenKeys(BaseSumInsured,BaseSumInsuredList.get(x),"Base Sum Insured");

			}


			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")){
				selectFromDropdownByVisibleLogin(EWSelected,dataRow.getProperty("EWSelected"),"EWSelected");
				if(dataRow.getProperty("EWSelected").equalsIgnoreCase("Yes"))
				{
					selectFromDropdownByVisibleLogin(WelcomeCall,dataRow.getProperty("WelcomeCall"),"WelcomeCall");
				}

			}
			
			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)"))
			{
				//Risk Class
				
				selectFromDropdownByVisibleLogin(RiskClass,dataRow.getProperty("RiskClass"),"Risk Class");
				
				//Sum Insured Type
				
				selectFromDropdownByVisibleLogin(SumInsuredType,dataRow.getProperty("SumInsuredType"),"Sum Insured Type");
			}
			

			click(Save, "Save BTN");
			Thread.sleep(WaitTime.low);
			click(OKBtn, "Ok BTN");

			//Total No of Lives
			//clearAndSenKeys(TotalNoOfLives,dataRow.getProperty("TotalNoOfLives"),"Total No of Lives");
			// Demographic Details



			String ChildWindow1=driver.getWindowHandle();
			click(demographicDetails, "Demographic Details BTN");
			switchToWindow(driver);


			//from Age
			String fromAgeval = dataRow.getProperty("fromAge");
			String fromAgeval1= fromAgeval.replace(" ", "");
			ArrayList<String> fromAgeList = new ArrayList<String>(Arrays.asList(fromAgeval1.split("\\+")));	
			clearAndSenKeys(fromAge,fromAgeList.get(x),"from Age");


			//to Age
			String toAgeval = dataRow.getProperty("toAge");
			String toAgeval1= toAgeval.replace(" ", "");
			ArrayList<String> toAgeList = new ArrayList<String>(Arrays.asList(toAgeval1.split("\\+")));	
			clearAndSenKeys(toAge,toAgeList.get(x),"to Age");


			//relationship_Type
			String relationshipTypeval = dataRow.getProperty("relationship_Type");
			String relationshipTypeval1= relationshipTypeval.replace(" ", "");
			ArrayList<String> relationshipTypeList = new ArrayList<String>(Arrays.asList(relationshipTypeval1.split("\\+")));
			selectFromDropdownByVisibleText(relationshipType,relationshipTypeList.get(x),"relationship Type");

			//Family Construct dataRow.getProperty("Product")
			selectFromDropdownByVisibleText(FamilyConstruct,dataRow.getProperty("FamilyConstruct"),"FamilyConstruct");

			//Gender
			String Genderval = dataRow.getProperty("Gender");
			//String Genderval1= Genderval.replace(" ", "");
			//ArrayList<String> GenderList = new ArrayList<String>(Arrays.asList(Genderval1.split("\\+")));
			ArrayList<String> GenderList = new ArrayList<String>(Arrays.asList(Genderval.split("\\+")));
			selectFromDropdownByVisibleText(gender,GenderList.get(x),"gender");


			//No_Oflives
			String nooflivesval = dataRow.getProperty("No_Oflives");
			String nooflivesval1= nooflivesval.replace(" ", "");
			ArrayList<String> nooflivesList = new ArrayList<String>(Arrays.asList(nooflivesval1.split("\\+")));

			clearAndSenKeys(nooflives,nooflivesList.get(x),"no of lives");


			//SumInsured
			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)")) 
			{


				String applicableSumInsuredval = dataRow.getProperty("BaseSumInsured");
				String applicableSumInsuredval1= applicableSumInsuredval.replace(" ", "");
				ArrayList<String> applicableSumInsuredList = new ArrayList<String>(Arrays.asList(applicableSumInsuredval1.split("\\+")));

				clearAndSenKeys(applicableSumInsured,applicableSumInsuredList.get(x),"applicable SumInsured");
			}


			//	Add row btn

			//click(Addrowbtn, "Add row BTN");

			// Demographic Details save btn
			click(Save1, "Save BTN");


			//ok btn
			click(OKBtn, "Ok BTN");

			// Demographic Details close btn
			click(closebtn, "Close BTN");

			driver.switchTo().window(ChildWindow1);



			//Relationship Details
			click(RelationshipDetailsbtn, "Relationship Details btn");
			switchToWindow(driver);

			//Relationship List
			String RelationshipListval = dataRow.getProperty("RelationshipList");
			String RelationshipListvalval1= RelationshipListval.replace(" ", "");
			ArrayList<String> RelationshipListvalList = new ArrayList<String>(Arrays.asList(RelationshipListvalval1.split("\\+")));
			if(!dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)"))
 			{
 			selectFromDropdownByVisibleLogin(RelationshipList,RelationshipListvalList.get(x),"Relationship List");
 			
 			}
 			
 			else
 			
 			{
 				selectFromDropdownByVisibleLogin(ApplicableRelation,RelationshipListvalList.get(x),"Relationship List");
 			}


			//Relationship Min Age
			clearAndSenKeys(RelationshipMinAge,fromAgeList.get(x),"Relationship Min Age");


			//Relationship Max Age
			clearAndSenKeys(RelationshipMaxAge,toAgeList.get(x),"Relationship Max Age");

			if(!dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)"))
 			{
 			//Relationshio Exit Age
 			String RelationshipExitAgeval = dataRow.getProperty("RelationshipExitAge");
 			String RelationshipExitAgeval1= RelationshipExitAgeval.replace(" ", "");
 			ArrayList<String> RelationshipExitAgeList = new ArrayList<String>(Arrays.asList(RelationshipExitAgeval1.split("\\+")));
 			clearAndSenKeys(RelationshipExitAge,RelationshipExitAgeList.get(x),"Relationship Exit Age");
 			
 			
 			
 			
 			selectFromDropdownByVisibleLogin(RelationshipType,relationshipTypeList.get(x),"Relationship Type");
 			
 			clearAndSenKeys(RelationshipMaxSI,BaseSumInsuredList.get(x),"Relationship MAx SI");
 			}

			// Relationship Details save btn
			click(Save1, "Save BTN");


			//ok btn
			click(OKBtn, "Ok BTN");

			// Relationship Details close btn
			click(closebtn, "Close BTN");

			driver.switchTo().window(ChildWindow1);



			if(dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Rack Rates")||dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Protect v2 (5224)"))
			{
				//dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Burning Cost")||

				// Coverage List Details

				click(covragelistbtn, "Coverage  BTN");
				switchToWindow(driver);
				Thread.sleep(WaitTime.low);

				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)"))
				{
					//Group Activ Health Cover
					fillEmployeeDetailsGroup_active_healthPage(driver,testCaseName, workbook, conn, stepGroup, customAssert);

				}


				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)"))
				{
					//Group Activ Secure Cover
					fillEmployeeDetailsGroup_active_SecurePage(driver,testCaseName, workbook, conn, stepGroup, customAssert);
				}

				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Assure - Covid19 (4230)"))
				{
					//Group Assure - Covid19
					fillEmployeeDetailsGroup_AssureCovid19Page(driver,testCaseName, workbook, conn, stepGroup, customAssert);
				}

				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)"))
				{
					//Group Assure - Covid19
					fillEmployeeDetailsGroup_active_TravelPage(driver,testCaseName, workbook, conn, stepGroup, customAssert);
				}

				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Arogya Sanjeevani (4231)"))
				{
					//Group Activ Secure Cover

					fillEmployeeDetailsGroup_Arogya_SanajeevaniPage(driver, testCaseName, workbook, conn, stepGroup, customAssert);
				}

				if(dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)") || dataRow.getProperty("Product").equalsIgnoreCase("Group Protect v2 (5224)"))
				{
					//Group Activ Secure Cover

					fillEmployeeDetailsGroup_protect_Page(driver,testCaseName ,workbook,conn, stepGroup, customAssert);
				}

				if( dataRow.getProperty("Product").equalsIgnoreCase("Group Protect v2 (5224)") || dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)"))
				{
					//Group Activ Secure Cover

					ffillEmployeeDetailsGroup_protectv2_Page(driver,testCaseName ,workbook,conn, stepGroup, customAssert);
				}

				driver.switchTo().window(ChildWindow1);
			}




			// Save btn		
			sendTwoKeys(By.cssSelector("body"),Keys.CONTROL, Keys.END,"Body Element");
			click(Save, "Save BTN");
			Thread.sleep(WaitTime.low);

			//ok btn
			Thread.sleep(WaitTime.low);
			click(OKBtn, "Ok BTN");

			// Close btn
			click(closebutton,"Close button");



			driver.switchTo().window(Parentwindow);
			switchtodefaultframe(driver);
			switchtoframe(driver, "display"); 
		}	 	
		//			if(dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Other Rating"))
		//			{
		//		     // Close btn
		//	           click(closebutton,"Close button");
		//	           driver.switchTo().window(Parentwindow);
		//		 		switchtodefaultframe(driver);
		//		 		switchtoframe(driver, "display"); 
		//	            
		//			}


		Thread.sleep(WaitTime.low);
		switchtoframe(driver,"containerFrame");
		// Continue btn	

		click(Continue,"Continue button");;

	}	
}





