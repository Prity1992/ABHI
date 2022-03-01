package GroupPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import edu.emory.mathcs.backport.java.util.Arrays;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class FamilyMemberInfoPage extends GenericMethods {
	//Add button
	private By Addbtn = By.xpath("//button[@id='AddBtn']");
	
	//First Name
	private By FirstName = By.xpath("//input[@id='First Name']");
	
	//Gender
	private By Gender = By.xpath("//select[@id='Gender']");
	
	//Date of Birth
	private By DateOfBirth = By.xpath("//input[@id='Date of Birth']");

	//Relationship with proposer
	private By RelationshipWithProposer = By.xpath("//select[@id='Relationship']");

	//Mobile Number
	private By MobileNumber = By.xpath("//input[@id='Mobile Number']");

	//Height(cms)
	private By Height = By.xpath("//input[@id='Height of the Insured (in cms)']");

	//Weight(kg)
	private By Weight = By.xpath("//input[@id='Weight (in kgs)']");

	//Nationality
	private By Nationality = By.xpath("//select[@id='Nationality']");//

	//Occupation
	private By Occupation = By.xpath("//select[@id='Occupation']");

	//Is Chronic Disease
	private By IsChronicDisease = By.xpath("//select[@id='Is Chronic Disease ?']");

	//Priority Customer
	private By PriorityCustomer = By.xpath("//select[@id='Priority Customer']");

	//Sensitive Customer
	private By SensitiveCustomer = By.xpath("//select[@id='Sensitive Customer']");
	
	//Is Member address same as that of proposer ?
	private By IsMemberAddressSameAsProposer = By.xpath("//input[@name='Is Member address same as that of proposer ?']");
	
	//PinCode
	private By PinCode = By.xpath("//input[@id='Policy-holder ZIP Code']");
	
	//PinCode Search
	private By PinCodeSearch = By.xpath("//i[@title='Search Pin Code']");
	
	
	//opted zone
	private By OptedZone = By.xpath("//select[@id='Opted zone']");
	
	//save btn
	private By SaveBtn = By.xpath("//button[@id='SaveButton']");
	
	//ok btn
	private By OkBtn = By.xpath("//button[contains(text(),'OK')]");
	
	//close btn
	private By CloseBtn = By.xpath("//button[@id='CloseButton']");
	
	//Continue  
	private By ContinueBtn = By.xpath("//button[@id='btncontinue']");
	
	//Party Code
	private By MemberCode = By.xpath("//label[@id='Member Code']");
	
	
	
	//ID details
	
			protected By IDdetailsBtn = By.xpath("//button[@id='ID Details']");

			//ID Type
			
			protected By IDType = By.xpath("//select[@id='ID Type0']");

			//ID No
			
			protected By IDNo = By.xpath("//input[@name='ID Number0']");

			//Save Button
			
			protected By save = By.xpath("//button[@id='SaveBtn']");

			//Close Button
			
			protected By Close = By.xpath("//button[@id='CloseBtn']");
			
			protected By okBTN1 = By.xpath("//button[contains(text(),'OK')]");
			protected By PinCodetemp = By.xpath("//input[@id='Policy-holder ZIP Code']");
	
			
	WebDriverWait wait;
    public FamilyMemberInfoPage (WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, 30);
    }
	
	public void fillFamilyMemberInfoPage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
    {
    	String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To FamilyMemberInfoPage</B>");
	   
	   
	   		
		String Heightval = dataRow.getProperty("Height");
	  	ArrayList<String> HeightList = new ArrayList<String>(Arrays.asList(Heightval.split("\\+")));
	  	
	  	 String Weightval = dataRow.getProperty("Weight");
	 	 ArrayList<String> WeightList = new ArrayList<String>(Arrays.asList(Weightval.split("\\+")));		
	  	
	  	String Genderval = dataRow.getProperty("Gender");
		ArrayList<String> GenderList = new ArrayList<String>(Arrays.asList(Genderval.split("\\+")));
		
		String RelationshipWithProposerval = dataRow.getProperty("Relationship");
  		String RelationshipWithProposerval1= RelationshipWithProposerval.replace(" ", "");
  	    ArrayList<String> RelationshipWithProposerList = new ArrayList<String>(Arrays.asList(RelationshipWithProposerval1.split("\\+")));
	  
		
		   String Relationship_ = dataRow.getProperty("Relationship");
		   String Relationship1 = Relationship_.replace(" ", "");
		ArrayList<String> RelationshipList = new ArrayList<String>(Arrays.asList(Relationship1.split("\\+")));
		
		
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");

		String Parentwindow  = driver.getWindowHandle();
		Thread.sleep(WaitTime.low);
        click(MemberCode, "Party Code");
		
		for (int x = 0; x < RelationshipList.size(); x++) {
			
		if(x==0) {
		
			

	   

	   switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame"); 
		switchtoframe(driver, "memberiframe0");
	   
		String Parentwindow1  = driver.getWindowHandle();

	   
	   //Height
	   clearAndSenKeys(Height,HeightList.get(x),"Height");
	   
	   //Weight
	   clearAndSenKeys(Weight,WeightList.get(x),"Weight");
	   
	   //Occupation
	   selectFromDropdownByVisibleText(Occupation,dataRow.getProperty("Occupation"),"Occupation");
	   
	   if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")){
		 //  ID details
		   
		   click(IDdetailsBtn, "ID details");
			switchToWindow(driver);
			selectFromDropdownByVisibleText(IDType, "PAN Card", "ID Type");
			
			//clearAndSenKeys(IDNo, dataRow.getProperty("ProposerPANNumber"), "Proposer ID Number");
			clearAndSenKeys(IDNo, panNoGenerator(), "Proposer ID Number");
			click(save, "Save");
			
//			  System.out.println(fetchTextFromApplication(By.className(
//			  "bootstrap-dialog-message"), "PopUp"));
			  
			  click(okBTN1, "Ok");
			  
			  click(Close, "Close");
			 
			driver.switchTo().window(Parentwindow1);
			switchtoframe(driver, "display");
			switchtoframe(driver, "containerFrame"); 
			switchtoframe(driver, "memberiframe0");
	   
	   }
	 //  clearAndSenKeys(PinCodetemp,dataRow.getProperty("PinCode"),"Pin Code Party");
	//	sendOneKeys(PinCodetemp,Keys.TAB,"Pincode");
	//	Thread.sleep(WaitTime.low);
	  
	   //opted zone
	  // selectFromDropdownByVisibleText(OptedZone,dataRow.getProperty("OptedZone"),"OptedZone");
	   
	 //Savebtn
	   click(SaveBtn, "Member Details Saved");
	   
	   //ok button
	   click(OkBtn, "Clicked on Ok");
	   
	   //Close button
	   click(CloseBtn, "Member Details Closed");
	   
	   driver.switchTo().window(Parentwindow);
		switchtoframe(driver, "display");
		switchtoframe(driver,"containerFrame");   
	  
	 
		}
	   
	   
		  if(x>0) {
			
	 
	   click(Addbtn, "ADD BTN");
	   
	   Thread.sleep(WaitTime.low);
	   
	   switchToWindow(driver);
	   
	   //Vignesh 30/08/2021
	   //FirstName
	   clearAndSenKeys(FirstName,getRandomString(),"First Name");
	   
	   
	   
	   //Gender
	   selectFromDropdownByVisibleText(Gender,GenderList.get(x),"Gender");
	   
	   //DOB
	   //clearAndSenKeys(DateOfBirth,dataRow.getProperty("DateOfBirth"),"Date of Birth");
	   DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
		Date obj = new Date();
		String acurrdate=dfor.format(obj);
		
		String Ageval = dataRow.getProperty("Age");
		   String Ageval1= Ageval.replace(" ", "");
		   ArrayList<String> AgeList = new ArrayList<String>(Arrays.asList(Ageval1.split("\\+")));
		String CollectAge= AgeList.get(x);
		String[] arrofstr=acurrdate.split("/",3);
		String date3=arrofstr[2];
		int calactual= Integer.parseInt(date3);
		int ageCal=Integer.parseInt(CollectAge);
		int year=calactual-ageCal;
		String yearStr=String.valueOf(year);
		String actualdate1=acurrdate.replaceAll(date3, yearStr);
		
		clearAndSenKeys(DateOfBirth,actualdate1,"Date of Birth");
		
		sendOneKeys(DateOfBirth,Keys.TAB,"DOB");
		Thread.sleep(WaitTime.low);
		
	   //Relation with proposer
				
	   selectFromDropdownByVisibleText(RelationshipWithProposer,RelationshipWithProposerList.get(x),"Relationship With Proposer");
	   
	   //Mob Number
	   clearAndSenKeys(MobileNumber,getRndNumber(),"Mobile Number");
	   
	   //Height
	   clearAndSenKeys(Height,HeightList.get(x),"Height");
	   
	   //Weight
	  
	   clearAndSenKeys(Weight,WeightList.get(x),"Weight");
	   
	   //Nationality
	   selectFromDropdownByVisibleText(Nationality,dataRow.getProperty("Nationality"),"Nationality");
	   Thread.sleep(WaitTime.veryLow);
	   
	   //Occupation
	   selectFromDropdownByVisibleText(Occupation,dataRow.getProperty("Occupation"),"Occupation");
	   
	   //Is Chronic Disease
	  // selectFromDropdownByVisibleText(IsChronicDisease,dataRow.getProperty("IsChronicDisease"),"Is Chronic Disease");
	   
	   //Priority Customer
	   selectFromDropdownByVisibleText(PriorityCustomer,"No","Priority Customer");
	   Thread.sleep(WaitTime.veryLow);
	   
	   //Sensitive Customer
	   selectFromDropdownByVisibleText(SensitiveCustomer,"No","Sensitive Customer");
	   
	 //  selectRadioButton(IsMemberAddressSameAsProposer,dataRow.getProperty("IsMemberAddressSameAsProposer"));
	   
	   //Is Member address same as that of proposer ?
	   /*if(dataRow.getProperty("IsMemberAddressSameAsProposer").equalsIgnoreCase("No"))
	   {
		   Thread.sleep(WaitTime.veryLow);
		   clearAndSenKeys(PinCode,dataRow.getProperty("PinCode"),"Pin Code");
		   click(PinCodeSearch, "Pin code searched");
		   Thread.sleep(WaitTime.veryLow);
		   driver.close();
		   
	   }*/
	   
	   //opted zone
	   selectFromDropdownByVisibleText(OptedZone,dataRow.getProperty("OptedZone")," OptedZone");
	   
	   //Savebtn
	   click(SaveBtn, "Member Details Saved");
	   
	   //ok button
	   click(OkBtn, "Clicked on Ok");
	   
	   //Close button
	   click(CloseBtn, "Member Details Closed");
	   driver.switchTo().window(Parentwindow);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");
	   
	   }
	   
	  
	   }
	   
		
			 
	   click( ContinueBtn, "Clicked continue now in Collection Page");
	   
	   
	    
	   
	   
    }

}
