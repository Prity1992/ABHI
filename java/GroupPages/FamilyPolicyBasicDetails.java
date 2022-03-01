 package GroupPages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Date;


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
import edu.emory.mathcs.backport.java.util.Arrays;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class FamilyPolicyBasicDetails extends GenericMethods{
	//Sandip 28/08/2021 
	//Application Number Entry1
	private By ApplicationNumberEntry1 = By.xpath("//input[@id='Application Number entry 1']");

	//Confirm ApplicationNumber
	private By ConfirmApplicationNumber = By.xpath("//input[@id='Application Number entry 2']");

	//Number Of Member
	private By NumberOfMembers = By.xpath("//input[@id='Total Number of Member']");

	//Inwarding Branch Code
	private By InwardingBranchCode = By.xpath("//input[@id='Policy Branch Code']");

	//Inwarding Branch Name
	private By InwardingBranchName = By.xpath("//input[@id='Inwarding Branch Name']");

	//Business Type
	private By BusinessType = By.xpath("//select[@id='Type of Business']");

	//Policy Tenure
	private By PolicyTenure = By.xpath("//select[@id='Policy Tenure']");

	//Duration
	private By Duration = By.xpath("//input[@id='Policy_Duration']");

	//Policy Duration Unit
	private By PolicyDurationUnit = By.xpath("//select[@id='Policy Duration Unit']");

	//Premium Frequency
	private By PremiumFrequency = By.xpath("//select[@id='Payment Frequency']");

	//Category
	private By Category = By.xpath("//select[@id='Group Category']");

	//Plan
	private By Plan = By.xpath("//select[@id='Plan']");

	//Sub Plan
	private By SubPlan = By.xpath("//select[@id='Sub Plan Type']");

	//Employee Discount
	private By EmployeeDiscount = By.xpath("//select[@id='Employee Discount']");

	//Go Green
	private By GoGreen = By.xpath("//select[@id='Go Green']");
	
    //Vignesh 28/08/2021
	//Intermediary Code
	private By IntermediaryCode = By.xpath("//input[@id='Producer Code']");
	
   //Intermediary Code Search
	private By IntermediarySearch = By.xpath("//a[@id='openLookUp Producer Code']");
	 
	//Party Type
	private By PartyType = By.xpath("//select[@id='Party Links']");
	
	//Proposer
	private By Proposer = By.xpath("//input[@id='Policy-holder Code']"); 
	
	//Proposer Search
	private By ProposerSearch = By.xpath("//a[@id='openLookUp Policy-holder Code']");
	
	 //Proposer also a Member
    private By ProposerAlsoMember = By.xpath("//input[@name='Policy Holder also a Member?']");
	
	//Select Type of Address
    private By AddressType = By.xpath("//select[@id='Select Type of Address']");
    
   //Is proposer also the Payer
   // private By ProposerAlsoPayer = By.xpath("//input[@name='Is proposer also the Payer ?']");
    
    //Payer
    private By Payer = By.xpath("//input[@id='Payer Pay']");
    
    //Save
    private By SaveBtn = By.xpath("//button[@id='Save']");
    
    //Ok
    private By OKBtn = By.xpath("//button[contains(text(),'OK')]");
    
    //FamilyPolicynumber
    private By FamilyPolicynumber = By.xpath("//label[@id='Number']");
    
  //Continue  
  	private By ContinueBtn = By.xpath("//button[@id='btncontinue']");
  	
  //Add Proposer
  	
  	private By AddProposer = By.xpath("//i[@title='Add Proposer']");
  	
  //First Name
  	
  	private By firstname = By.xpath("//input[@id='First Name']");
  	
  //Last Name
  	
  	private By LastNameTxtbox = By.xpath("//input[@id='Last Name (2)']");
  	
  //Gender
  	
  	private By gender = By.xpath("//select[@id='Gender']");
  	
  //Title
  	
  	private By title = By.xpath("//select[@id='Title']");
  	
  //Date Of Birth
  	
  	private By dateofbirth = By.xpath("//input[@id='Date of Birth']");
  	
  //GST Registration Type
  	
  	private By GSTregistrationtype = By.xpath("//select[@id='GST Registration Type']");
  	
  // Is The Mailing
  	
  	private By mailing = By.xpath("//input[@value='Y']");
  	
 //Permanent Contact
  	
  	private By PermanentContact = By.xpath("//div[@id='img1']");
  	
 //Fill Address line 1
  	
  	private By AddressLine1 = By.xpath("//input[@id='Address Pty 1']");
  	
  //Fill Address line 2
  	
  	private By AddressLine2 = By.xpath("//input[@id='Address Pty 2']");
  	
  //Fill Pincode
  	
  	private By Pincode = By.xpath("//input[@id='Zip CodeParty']");
  	
	//Landline Number
  	
  	private By Landline = By.xpath("//input[@id='Landline NumberP']");
  	
  	
  //Mobile Number
  	
  	private By Mobile = By.xpath("//input[@id='Mobile Number']");
  	
  //Fill Email ID
  	
  	private By Email = By.xpath("//input[@id='{objQuestion.strParameterName}}']");
  	
  //saveBTN
  	private By saveBTN = By.xpath("//button[@id='Save']");
  	
  //Ok
    private By okBTN = By.xpath("//button[contains(text(),'OK')]");
    	
  //Activate Client
    
    private By activateclient = By.xpath("//button[@id='Back']");
    
    //Group Quote Number 
    private By GrpQuoteNumber = By.xpath("//input[@id='Source Reference Number']");
    
    //Yes button Is proposer also a Payer?
    private By ProposerPayer = By.xpath("//input[@name='Is proposer also the Payer ?' and @value='Y']");
    
  //No button Is proposer also a Payer?
    private By ProposerPayerN = By.xpath("//input[@name='Is proposer also the Payer ?' and @value='N']");
    
    protected By bankaccountdetails = By.xpath("//button[@id='Bank Account Details']");

	
   	protected By accountNo = By.xpath("//input[@id='Bank A/C No0']");

   	
   	protected By confirmaccountNo = By.xpath("//input[@id='Confirm Account Number0']");

   	
   	protected By ifsccode = By.xpath("//input[@id='IFSC Code0']");

   	
   	protected By bankaccounttype = By.xpath("//select[@name='Bank Account Type0']");
   	
   	protected By bankname = By.xpath("//input[@id='Bank Name0']");

   	//Bank Detail Save btn
   	
   	protected By savebtn = By.xpath("//button[@id='SaveBtn']");

   	
   	protected By ifsciconbtn = By.xpath("//a[@id='openLookUp IFSC Code']//img");

   	
   	protected By searchifscbtn = By.xpath("//a[@id='openLookUp IFSC Code']");

   	
   	protected By ifcselectbtn = By.xpath("//a[@name='firstFocus']");

   	
   	protected By closebtn = By.xpath("//button[@id='CloseBtn']");

   	
   	protected By IFSCCode = By.xpath("//input[@id='IFSC Code']");
       
       

    
    
  	WebDriverWait wait;
    public FamilyPolicyBasicDetails (WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, 30);	
    }
    
    public void fillFamilyPolicyBasicDetails (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
    {
    	String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To FamilyPolicyBasicDetails</B>");
	     
	   
	    switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		Thread.sleep(WaitTime.low);
		switchtoframe(driver, "containerFrame"); 
		Thread.sleep(WaitTime.low);
		String uniqueNo= getRndNumber();
		//String Grpquoteno = fetchTextFromApplication(GrpQuoteNumber,"Quote Number");

		
		//ApplicationNumberEntry1
		clearAndSenKeys(ApplicationNumberEntry1,uniqueNo,"Application Number Entry1");
		
		//ConfirmApplicationNumber
		clearAndSenKeys(ConfirmApplicationNumber,uniqueNo,"Confirm Application Number");
		
		//Number Of Members
		clearAndSenKeys(NumberOfMembers,dataRow.getProperty("NumberOfMembers"),"Number Of Members");
		
		//Inwarding Branch Code
		//clearAndSenKeys(InwardingBranchCode,dataRow.getProperty("InwardingBranchCode"),"Inwarding Branch Code");
		
		//Inwarding Branch Name
		//clearAndSenKeys(InwardingBranchName,dataRow.getProperty("InwardingBranchName"),"Inwarding Branch Name");
		
		//Business Type
		//selectFromDropdownByVisibleText(BusinessType,dataRow.getProperty("BusinessType"),"Business Type");

		//Policy Tenure
		//selectFromDropdownByVisibleText(PolicyTenure,dataRow.getProperty("PolicyTenure"),"Policy Tenure");

		//Duration
		//clearAndSenKeys(Duration,dataRow.getProperty("Duration"),"Duration");

		//Policy Duration Unit
		//selectFromDropdownByVisibleText(PolicyDurationUnit,dataRow.getProperty("PolicyDurationUnit"),"Policy Duration Unit");

		//Premium Frequency
		//selectFromDropdownByVisibleText(PremiumFrequency,dataRow.getProperty("PremiumFrequency"),"Premium Frequency");

		//Category
		selectFromDropdownByVisibleText(Category,dataRow.getProperty("Category"),"Category");

		//Plan
		//selectFromDropdownByVisibleText(Plan,dataRow.getProperty("Plan"),"Plan");

		//Sub Plan
		//selectFromDropdownByVisibleText(SubPlan,dataRow.getProperty("SubPlan"),"Sub Plan");

		//Employee Discount
		selectFromDropdownByVisibleText(EmployeeDiscount,dataRow.getProperty("EmployeeDiscount"),"Employee Discount");
		Thread.sleep(WaitTime.veryLow);
		
		//Go Green
		selectFromDropdownByVisibleText(GoGreen,dataRow.getProperty("GoGreen"),"Go Green");
		
		//Intermediary Code
//		String parentWindow = driver.getWindowHandle();
//		clearAndSenKeys(IntermediaryCode,dataRow.getProperty("IntermediaryCode"),"Intermediary Code");
//		
//		//Click Intermediary Search
//		click(IntermediarySearch,"Search");
//		switchToWindow(driver);
//		
//        click(By.xpath("//a[contains(text(),'"+dataRow.getProperty("IntermediaryCode")+"')]"),"Intermediary Code");
//		
//		driver.switchTo().window(parentWindow);
// 		switchtodefaultframe(driver);
// 		switchtoframe(driver, "display"); 
// 		switchtoframe(driver, "containerFrame");
// 		
// 		Thread.sleep(WaitTime.veryLow);
		
		//Party Type
		selectFromDropdownByVisibleText(PartyType,dataRow.getProperty("PartyType"),"Party Type");
		Thread.sleep(WaitTime.veryLow);
		
		//Proposer
		/*
		 * clearAndSenKeys(Proposer,dataRow.getProperty("Proposer"),"Proposer");
		 * 
		 * click(ProposerSearch, "Proposer Search"); switchToWindow(driver);
		 * 
		 * click(By.xpath("//a[contains(text(),'"+dataRow.getProperty("Proposer")+"')]")
		 * ,"Proposer");
		 * 
		 * driver.switchTo().window(parentWindow); switchtodefaultframe(driver);
		 * switchtoframe(driver, "display"); switchtoframe(driver, "containerFrame");
		 * Thread.sleep(WaitTime.veryLow);
		 */
		
		
		//Add New Proposer
		
		//Click on Proposer Icon
		click( AddProposer, "Add Proposer");
		String parentWindow0 = driver.getWindowHandle();
		switchToWindow(driver);
		
		//First Name
		clearAndSenKeys(firstname,getRandomString(),"First Name" );
		
		//Last Name
		clearAndSenKeys(LastNameTxtbox,getRandomString(),"Last Name" );
		
		//Title
		
		String Genderval = dataRow.getProperty("Gender");
		ArrayList<String> GenderList = new ArrayList<String>(Arrays.asList(Genderval.split("\\+")));
		
		if(GenderList.get(0).equalsIgnoreCase("Male")) {
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(title,"Mr.","Title");
		}
		else if(GenderList.get(0).equalsIgnoreCase("Female")){
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(title,"Mrs.","Title");
			
		}
		
		else if(GenderList.get(0).equalsIgnoreCase("Others Male")||dataRow.getProperty("Gender").equalsIgnoreCase("Others Female")){
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(title,"Mx.","Title");
		}

		//Gender
		
		
		selectFromDropdownByVisibleText(gender,GenderList.get(0),"Gender");
		Thread.sleep(WaitTime.low);
		
		//Date Of Birth
		DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
		Date obj = new Date();
		String acurrdate=dfor.format(obj);
		
		String Ageval = dataRow.getProperty("Age");
		   String Ageval1= Ageval.replace(" ", "");
		   ArrayList<String> AgeList = new ArrayList<String>(Arrays.asList(Ageval1.split("\\+")));
		String CollectAge= AgeList.get(0);
		String[] arrofstr=acurrdate.split("/",3);
		String date3=arrofstr[2];
		int calactual= Integer.parseInt(date3);
		int ageCal=Integer.parseInt(CollectAge);
		int year=calactual-ageCal;
		String yearStr=String.valueOf(year);
		String actualdate1=acurrdate.replaceAll(date3, yearStr);
		
		clearAndSenKeys(dateofbirth,actualdate1,"Date of Birth");
		
		sendOneKeys(dateofbirth,Keys.TAB,"DOB");
		Thread.sleep(WaitTime.low);
		
		//GST Registration Type
		selectFromDropdownByVisibleText(GSTregistrationtype,dataRow.getProperty("GST Registration Type"),"GST Registration Type");
		
		//IstheMailing Radiobutton
		
		click(mailing,"IstheMailing");
		
		//Click Permanent Contact
 		click(PermanentContact,"Permanent Contact");
 		
 		sendTwoKeys(By.cssSelector("body"),Keys.CONTROL, Keys.PAGE_DOWN,"Body Element");
		
 		//Fill Address line 1
		
		clearAndSenKeys(AddressLine1,dataRow.getProperty("Address Line 1"),"Address Line 1");
		Thread.sleep(WaitTime.high);

		//Fill Address line 2	
		clearAndSenKeys(AddressLine2,dataRow.getProperty("Address Line 2"),"Address Line 2");
		Thread.sleep(WaitTime.low);

		//Fill Pincode
		
		clearAndSenKeys(Pincode,dataRow.getProperty("PinCode"),"Pincode");
		sendOneKeys(Pincode,Keys.TAB,"Pincode");
		Thread.sleep(WaitTime.low);

		//Landline Number
		clearAndSenKeys(Landline,getRndNumber(),"Landline number");



		//Mobile Number
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(Mobile,getRndNumber(),"Mobile Number");

		

		//Fill Email ID
		
		clearAndSenKeys(Email,generateRandomEmail(),"Email ID");
		Thread.sleep(WaitTime.low);
		
		String ChildWindow2=driver.getWindowHandle();
		
		
//bank account details
		
		click(bankaccountdetails,"bankaccountdetail");
		switchToWindow(driver);
		
		wait.until(expectedCondition);
		
		clearAndSenKeys(accountNo,dataRow.getProperty("AccountNo"),"Account No");
		
		clearAndSenKeys(confirmaccountNo,dataRow.getProperty("AccountNo"),"ConformAccount No");
		
		clearAndSenKeys(ifsccode,dataRow.getProperty("IFSCcode"),"IFSC Code");
		
		selectFromDropdownByVisibleText(bankaccounttype,dataRow.getProperty("AccountType"),"account Type");
		
		//clearAndSenKeys(bankname,dataRow.getProperty("BankName"),"bank name");

		//Bank Account Window
		/*String ChildWindow=driver.getWindowHandle();
				
				
				click(ifsciconbtn,"Iconbtn");
				
				switchToWindow(driver);		
						
				
				clearAndSenKeys(ifsccode,dataRow.getProperty("IFSCcode"),"IFSC Code");
				
				
				
				click(searchifscbtn,"IFSCsearchbtn");
				
				
				
				click(ifcselectbtn,"IFSCselectbtn");
				
				
		       driver.switchTo().window(ChildWindow2);
		*/
		click(savebtn,"Savebtn");

		//System.out.println(fetchTextFromApplication(By.className("bootstrap-dialog-message"), "PopUp"));
 		
		
		click(okBTN,"OK");
		

		// close btn on ifsc code 	
		
		click(closebtn,"Closebtn");
		

		driver.switchTo().window(ChildWindow2);

		
		
		
		
		click(saveBTN,"Save");
		Thread.sleep(WaitTime.low);
		
		//Click OK Button 
		click(okBTN,"OK");
		
		Thread.sleep(WaitTime.high);
		
		//Activate Client
		click(activateclient,"Activate Client");
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(activateclient)));
		
		
		
		
		
		driver.switchTo().window(parentWindow0);
		switchtoframe(driver, "display");
		Thread.sleep(WaitTime.low);

		switchtoframe(driver,"containerFrame");

 		
		//Address Type
 		selectFromDropdownByVisibleText(AddressType,dataRow.getProperty("AddressType"),"Type of Address");
 		
 		//ProposerAlsoPayer
 		//selectRadioButton(ProposerAlsoPayer,dataRow.getProperty("ProposerAlsoPayer"));
 
 		
 		//Payer
 		//clearAndSenKeys(Payer,fetchTextFromApplication(Proposer,"proposer"),"Payer");
 		
 		if(dataRow.getProperty("ProposerAlsoPayer").equalsIgnoreCase("Yes"))
 		{
 			Thread.sleep(WaitTime.veryLow);
 			click(ProposerPayer,"Proposer is also a payer");
 		}
 		else
 		{
 			Thread.sleep(WaitTime.veryLow);
 			click(ProposerPayerN,"Proposer is also a payer");
 			
 		}
 		
 		
 		
 		
 		//Save btn
 				click(SaveBtn,"Save");
 				Thread.sleep(WaitTime.low);
 						
 				//Ok btn
 				click(OKBtn,"Ok");
 				
 				
 				String FamilyPolicyNo = fetchTextFromApplication(FamilyPolicynumber,"Quote/Policy/Proposal Number");
 				System.out.println("Family Policy No:"+FamilyPolicyNo);
 				Reporter.log("------------------------");
 				Reporter.log("Family Policy No.:" + FamilyPolicyNo);
 				//Continue
 				Thread.sleep(WaitTime.low);
 				click(ContinueBtn, "ContinueBtn");
 				
 				Thread.sleep(WaitTime.veryLow);
 				
 				//Clicked on Family Policy Payment Info
 			     click( ContinueBtn, "Clicked on Family Policy Payment Info");
 				Thread.sleep(WaitTime.veryLow);
 				
 				//Clicked on Family Policy Relations
 				click( ContinueBtn, "Clicked on Family Policy Relations");
 				
 				Thread.sleep(WaitTime.veryLow);
 				
 				
 				
 				
 				
 		
 		
        
		
		
		
	   
	   
	
    }

}
