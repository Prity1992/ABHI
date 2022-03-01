package GroupPages;

import java.util.Properties;
import java.util.Set;

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

public class PolicySummaryPage extends GenericMethods{
	
	
	//Data Entry Complete button  
	private By DataEntryCompletebtn = By.xpath("//button[@id='DataEnt']");
	
	//Submit button
	private By Submitbtn = By.xpath("//button[@id='Submit']");
	
	//Quote Released button
	private By QuoteReleasedbtn = By.xpath("//button[@id='Quote_Relaesed']");
	
	//GroupQuotationDetails page
	private By GroupQuotationDetails = By.xpath("(//a[@name='Group Quotation Details'])[2]");
	
	//Accept Quotation
	private By AcceptQuotationbtn = By.xpath("//button[@id='AcptQuote']");
	
	//Finalize green button in Quotation details page
	private By FinalizeGreenbtn = By.xpath("//table[@id='tblmember']/tbody/tr[2]/td[11]/div/div/a/img");
	
	//Sub-Status 
	private By SubStatus = By.xpath("//label[@id='Sub-Status']");
	
	//Status
	private By Status = By.xpath("//label[@id='Status']");
	
	//Finalize button //button[@id='Final']
	private By Finalizebtn = By.xpath("//button[@id='Final']");
	
	//Follow-up page
	private By Followup = By.xpath("(//a[@name='Follow-up'])[2]");
	
	//Group Summary page
	private By GroupSummary = By.xpath("(//a[@name='Group Summary'])[2]");
	
	//Team Name column
	private By TeamName = By.xpath("//table[@id='tblmember']/tbody/tr[1]/td[6]");
	
	//Issue Policy button
	private By IssuePolicybtn = By.xpath("//button[@id='IssuePol']");
	
	//Policy Number 
		private By GrpPolicyNumber = By.xpath("//label[@id='Number']");
		
	//Ok
    private By OKBtn = By.xpath("//button[contains(text(),'OK')]");
    
    //Create Family Policy Button 
    private By CreateFamilyPolicybtn = By.xpath("//button[@id='CreateFamPol']");
    
    private By AccApp = By.xpath("//b[contains(text(),'Accounting Appplication')]");
    
    //click on reqirment tab
    private By Requirement = By.xpath("//a[@name='Requirements']//img");
    
    
  //Click On Show Requirement
    private By ShowRequirement = By.xpath("//img[@title='Show Requirement']");
    
 // Upload Requirement A
	
 	private By uploadrequirementA = By.xpath("(//img[@title='Upload Requirement'])[1]/ancestor::a");
	
 //Type of Document
 		private By typeofdocument=By.xpath("//select[@required='required']");	
 
 		
 // Choose File
 		
 	private By choosefile = By.xpath("//input[@type='file']");	
 	
 // Upload File
	
 	private By upload = By.xpath("//button[@title='Upload']");
 	
 // Ok Button Click
	
 	private By OK = By.xpath("//button[@class='btn btn-default']");	
 	
 // Save
	
 	private By saverequire = By.xpath("//button[@id='SaveRequire']");
 		
	WebDriverWait wait;
    public PolicySummaryPage (WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, 30);	
    }
    
    public void fillPolicySummaryPage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
    {
    	String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To Policy Summary Page</B>");
	   String parentWindow=driver.getWindowHandle();
	   
	    switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		click( GroupSummary, "Group Summary page");
		
		switchtoframe(driver, "containerFrame"); 
		
		
		click( DataEntryCompletebtn, "Data Entry Complete btn");
		
		click( Submitbtn, "Submit btn");
		
		click( QuoteReleasedbtn, "Quote Released btn");
		
		
        Reporter.log("<B> After Quote Released button is clicked Now Status:-  </B>"+fetchTextFromApplication(Status,"Status")); 
	    
	   // Reporter.log("<B>  Now Sub-Status:-  </B>"+fetchTextFromApplication(SubStatus,"Sub-Status")); 
		
		
		
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
	    click(GroupQuotationDetails, "Group Quotation Details page");
	    
	    
	    
		switchtoframe(driver,"containerFrame");
		
		click(FinalizeGreenbtn, "Finalize button in Group details page");
		
		click(OKBtn, "Ok BTN");
		
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		/*
		 * click(GroupSummary, "Now in Group summary page");
		 * 
		 * switchtoframe(driver,"containerFrame");
		 */
		
		
		
		if(dataRow.getProperty("ProposalSegment").equalsIgnoreCase("Employer-Employee"))
		{
			
			
			click(Requirement, "Now In Requirement Page");
			switchtoframe(driver,"containerFrame");
			click(ShowRequirement, "ShowRequirement");
			
			java.util.List<WebElement> ShowRequirement_list = driver.findElements(By.xpath("(//img[@title='Upload Requirement'])/ancestor::a"));
			
			int ShowRequirement_listSize=ShowRequirement_list.size();
			
			for(int i=1;i<=ShowRequirement_listSize;i++)
			{
				
				
				click(By.xpath("(//input[@title='Received'])["+i+"]"), "Received(GreenRadio) Button");
				
				By  DropDown= By.xpath("//td[contains(text(),'Created/Uploaded By')]/following::select["+i+"]");
				
				selectFromDropdownByVisibleText(DropDown,"Optional","DropDown");
				
			}
			
			// Save
			
			click(saverequire, "Save");
					

			// Ok Button
					
			click(OK, "Modification Successfully Completed");
			switchtodefaultframe(driver);
			switchtoframe(driver,"display");
			
		}
		 
		
		click(GroupSummary, "Now in Group summary page");   
	    switchtoframe(driver,"containerFrame");
		click(AcceptQuotationbtn, "Accept Quotation");
		
		
		 Reporter.log("<B> After Accept Quotation button is clicked Now Status:-  </B>"+fetchTextFromApplication(Status,"Status")); 
		    
		 Reporter.log("<B>  Now Sub-Status:-  </B>"+fetchTextFromApplication(SubStatus,"Sub-Status")); 
		 
		
		
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
	    click(Followup, "Now in Follow-up page");
	    
        switchtoframe(driver,"containerFrame");
		
        Reporter.log("<B>  Team Name:-  </B>"+fetchTextFromApplication(TeamName,"Sub-Status"));
        
        switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		click( GroupSummary, "Now in Group Summary page");
		switchtoframe(driver,"containerFrame");
		
		click(Finalizebtn, "Finalize button");
		
		//click(IssuePolicybtn, "Issue Policy button");
		
		
		/*
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		
		click(Requirement, "Now In Requirement Page");
		
		switchtoframe(driver,"containerFrame");
		//Click On Show Requirement
		click(ShowRequirement, "ShowRequirement");
		
		// Upload Requirement 
	
		
		
		click(uploadrequirementA, "Upload Document of BanK");
				
		fetchTextFromAngularApplicationClass();
		switchToWindow(driver);
		fetchTextFromAngularApplicationClass();

		// Choose File 1
		Thread.sleep(WaitTime.high);
		selectFromDropdownByVisibleText(typeofdocument,dataRow.getProperty("TypeofDocument"),"Type Of Ducuments");
				
		clickForLogin(choosefile, "Choose File");
				
		sendOneKeyForLogin(choosefile, "D:\\code.txt", "Choose File");
				

		// Upload File 1
				
		clickForLogin(upload, "File Uploaded");
				
		driver.switchTo().window(parentWindow);
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");

		// Ok Button

				
		click(OK, "File Uploaded Successfully"); 
		
		// Save
		
		click(saverequire, "Save");
				

		// Ok Button
				
		click(OK, "Modification Successfully Completed");
		
		
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		click( GroupSummary, "Now in Group Summary page");
		switchtoframe(driver,"containerFrame");
		
		click(IssuePolicybtn, "Issue Policy button");
		
		*/
		
		/*click(IssuePolicybtn, "Issue Policy button");
		
		Reporter.log("<B>Policy Created </B>");
		 
		 Reporter.log("<B> Group Policy No:-  </B>"+fetchTextFromApplication(GrpPolicyNumber,"Group Policy Number")); 
		
		 System.out.println(fetchTextFromApplication(GrpPolicyNumber,"Group Policy Number"));
		 
			*/
		
		 String parent=driver.getWindowHandle();
	        AccountingApplication a=new AccountingApplication(driver);
	        
	        switchtodefaultframe(driver);
	        switchtoframe(driver, "head");
	        WebElement hivenId =driver.findElement(By.xpath("//span[contains(text(), 'Welcome')]/span"));
			String hid=hivenId.getText();
			System.out.println("id:"+hid);
	        click(AccApp,"Role Click");	

	        Set<String> handles=driver.getWindowHandles();
	      
	        for(String child: handles) {
	        	
	        if(!child.equalsIgnoreCase(parent)) {
	      
	        //Switch to the opened tab
	        driver.switchTo().window(child);
	        a.createCDandBG(driver,testCaseName,workbook,conn,
	     			stepGroup, customAssert,parent,child,hid);
	        }
	        }
		 
	    	driver.switchTo().window(parent);
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "display"); 
	 		switchtoframe(driver, "containerFrame");
		 
		 
		 
		 
	 		click(IssuePolicybtn, "Issue Policy button");
	 		Thread.sleep(WaitTime.veryLow);
			Reporter.log("<B>Policy Created </B>");
			 
			 Reporter.log("<B> Group Policy No:-  </B>"+fetchTextFromApplication(GrpPolicyNumber,"Group Policy Number")); 
			
			 System.out.println(fetchTextFromApplication(GrpPolicyNumber,"Group Policy Number"));
			 
				
		click(CreateFamilyPolicybtn, "Create Family Policy button");


	   
    
    }
	
}
