package com.Msite.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Msite.TestScripts.BaseClass;


public class EmployeesPage extends BaseClass
{
	
	public static Logger logger;
	public EmployeesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse bs-navbar-collapse no-padding text-center']//a[contains(text(),'Employees')]")
	WebElement Employees;
	
	@FindBy(xpath="//ul[contains(@class,'nav nav-link')]")
	WebElement employeefunctionallist;
	
	@FindBy(xpath="//div[contains(@class,'employee-list-status-summary-container')]")
	WebElement employeeiconlist;
	
	@FindBy(xpath="//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']")
	WebElement savebutton;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement continueSavebutton;
	
	@FindBy(xpath="//div[contains(text(),'Training')]")
	WebElement trainingExceInEmployee;
	
	@FindBy(xpath="//div[contains(text(),'ID Check')]")
	WebElement IDCheckInEmployee;
	
	@FindBy(xpath="//div[contains(@class,'employee-list-status-summary TrainingPanel employee-list-status-summary-middle')]")
	WebElement trainingException;
	
	@FindBy(xpath="//div[contains(text(),'Accreditation')]")
	WebElement accreditationException;
	
	@FindBy(xpath="//div[contains(text(),'Access & Attendance')]")
	WebElement accessAndAttendanceException;
	
	@FindBy(xpath="//div[contains(text(),'Induction Booking')]")
	WebElement inductionBookingException;
	
	@FindBy(xpath="//div[@class='col-md-9']/div")
	WebElement personalDetailLabelList;
	
	@FindBy(xpath="//div[contains(text(),'ID Check')]")
	WebElement idCheckException;
	
	@FindBy(xpath="//div[@class='col-md-9']/div//label/span")
	WebElement mandatoryField;
	
	@FindBy(xpath="//div[@class='panel panel-default nokPanel panel-employee']")
	WebElement nextofkinDialogBox;
	
	@FindBy(xpath="//strong[contains(text(),'Industry Accreditations')]")
	WebElement industryaccreditationsection;
	
	@FindBy(xpath="//div[@class='panel panel-default accreditationPanel panel-employee']")
	WebElement accreditationsection;
	
	@FindBy(xpath="//div[@class='panel panel-default accreditationPanel training panel-employee']")
	WebElement trainingaccreditationsection;
	
	@FindBy(xpath="//div[contains(@class,'panel panel-default panel-employee panel-declaration-statement')]")
	WebElement declarationStatement;
	
	@FindBy(xpath="//div[contains(@class,'panel panel-default panel-employee panel-requirements-for-health-checks-on-bam-projects')]")
	WebElement healthandCheckup;
	
	@FindBy(xpath="//div[contains(@class,'panel panel-default panel-employee panel-kpi-questions')]")
	WebElement kpiQuestion;
	
	@FindBy(xpath="//strong[contains(text(),'Skills Information')]")
	WebElement skillInformation;
	
	@FindBy(xpath="//div[@class='panel panel-default panel-employee panel-induction-requirements']")
	WebElement inductionRequirement;
	
	@FindBy(xpath="//button[@data-title='Accreditations' and contains(text(), 'Add...')]")
	WebElement accreditationAddButton;
	
	@FindBy(xpath="//h3[contains(text(),'Contact Details Required')]")
	WebElement inviteContactDetailsRequired;
	
	@FindBy(xpath="//tfoot[@class='no-results']")
	WebElement noEmployeePresent;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__message']")
	WebElement noSitePresent;
	
	@FindBy(xpath="//button[contains(text(),'Manage PIN Entry')]")
	WebElement managePinEntry;
	
	@FindBy(xpath="//button[contains(text(),'Add Incident')]")
	WebElement addIncident;
	
	@FindBy(xpath="//button[contains(text(),'Restrict Access')]")
	WebElement restrictAccess;
	
	@FindBy(xpath="//button[contains(text(),'Fix Access Issues')]")
	WebElement fixAccessIssue;
	
	@FindBy(xpath="//a[contains(text(),'Access Restriction History')]")
	WebElement accessRestrictionHistory;
	
	@FindBy(id="panel-AccessAndAttendance")
	WebElement accessAttendencePanel;
	
	@FindBy(id="panel-Training")
	WebElement trainingPanel;
	
	@FindBy(xpath="//div[@class='modal-body']//label[contains(text(),'Certification Number')]")
	WebElement certificationnumber;
	
	@FindBy(xpath="//th[contains(text(),'Data Protection')]")
	WebElement dataprotectionHeading;
	
	@FindBy(xpath="//label[contains(text(),'Biometric Consent Status')]")
	WebElement biometricconsent;
	
	@FindBy(xpath="//div[@class='panel panel-default medicalConditionPanel panel-employee']")
	WebElement medicalConditionSection;
	
	@FindBy(xpath="//td[contains(text(),'0 Employees Found')]")
	WebElement employeeSearchResult;
	
	@FindBy(xpath="//div[@class='panel panel-default attachments-wrapper attachmentsPanel panel-employee']")
	WebElement attachmentSection;
	
	@FindBy(xpath="//span[contains(text(),'Position')]")
	WebElement position;
	
	@FindBy(xpath="//select[@data-automation-id='Non-SensitiveBiographicPersonalDataAcknowledgementCustomField']/parent::div/span")
	WebElement NonSensitiveBiograpic;
	
	@FindBy(xpath="//select[@data-automation-id='BiometricPersonalDataConsentCustomField']/parent::div/span")
	WebElement biometricPersonalConsent;
	
	@FindBy(id="btn-allowCookies")
	WebElement allowCookies;
	
	public void openEmployees() 
	{
		Employees.click();
		if(isAlertPresent()) 
		{
			isAlertAction("accept");
		}
		waitForSeconds(1);
	}
	
	public void clickOnAllowCookies() 
	{
		waitForSeconds(1);
		if(isElementPresent(allowCookies) && isElementEnabled(allowCookies)) 
		{
		  allowCookies.click();
		}
		waitForSeconds(3);
	}
	public void verifyEmployeesTitle() 
	{
		Assert.assertEquals(driver.getTitle(), "MSite - Employees");
	}
	
	public void reviewAndVerifyAllElementInEmployees() 
	{
		List<WebElement> functionallist = employeefunctionallist.findElements(By.xpath("./li"));
		for(WebElement ele:functionallist) 
		{
			String functionheading=ele.getText().replace("\n", "");
			Assert.assertTrue(isElementPresent(ele), ""+functionheading+" is missing in the System list");
		}
		List<WebElement> iconlist = employeeiconlist.findElements(By.xpath("./div"));
		for(WebElement ele:iconlist) 
		{
			String iconlistheading=ele.getText().replace("\n", "");
			Assert.assertTrue(isElementPresent(ele), ""+iconlistheading+" is missing in the System list");
		}
		
	}
	
	public void open_Emplyoee_InEmployeeStatusSummaryContainer() 
	{
		try 
		{
		  FindElement("xpath", "//div[@id='employee-list-summary-stats']").click();;
		  waitForSeconds(1);
		  Assert.assertTrue(isElementPresentByXpath("//*[@id='collSrc']"), "Unable to find employee search box.");
		}
		catch(Exception e) 
		{
			e.getCause();
		}
		
	}
	
	public void choose_NumberOfRecordsShow_And_VerifyCountForExceptionResultInPage(int result)  
	{
		 WebElement numberToShow=FindElement("xpath", "//select[@id='NumberToShow']");
		if(result<=10) 
		{
			  selectValueByIndex(numberToShow, 0);
		}
		else if(result>10 && result<=50) 
		{
			selectValueByIndex(numberToShow, 1);
		}
		else if(result>50 && result<=100)
		{
			selectValueByIndex(numberToShow, 2);
		}
		else if(result>100)
		{
			selectValueByIndex(numberToShow, 2);
			Assert.assertTrue(isElementPresentByXpath("//span[contains(text(),'»')]"),"lastpage arrow is missing");
		}
		if(result==0)
		{
			Assert.assertTrue(isElementPresentByXpath("//td[@class='text-center']"), "Text '0 Employees Found' not present.");
		}
		waitForSeconds(1);
		verify_HeadingAndCountForExceptionResult_InEmployeeStatusSummaryContainer(result);
	}
	
	public void open_Exception_InEmployeeStatusSummaryContainer(WebElement element,String path) 
	{
		try 
		{
		    if(isElementPresent(element)) 
		      {
		         WebElement ExceptionCount=FindElement("xpath", path);
		         String ExceptionCountText=ExceptionCount.getText();
		         int result = Integer.parseInt(ExceptionCountText);
		         element.click();
		         waitForSeconds(1);
		         choose_NumberOfRecordsShow_And_VerifyCountForExceptionResultInPage(result);  
		      }
		}
		catch(Exception e) 
		{
			e.getCause();
		}
	}
	public void open_TrainingException_InEmployeeStatusSummaryContainer() 
	{
		open_Exception_InEmployeeStatusSummaryContainer(trainingException,"//div[@id='TrainingPanel-figure']");	
	}
	
	public void open_AccreditationException_InEmployeeStatusSummaryContainer() 
	{
		open_Exception_InEmployeeStatusSummaryContainer(accreditationException,"//div[@id='AccreditationPanel-figure']");	
	}
	
	public void open_InductionBookingException_InEmployeeStatusSummaryContainer() 
	{
		open_Exception_InEmployeeStatusSummaryContainer(inductionBookingException,"//div[@id='InductionBookingPanel-figure']");
	}
	
	public void open_IDCheckException_InEmployeeStatusSummaryContainer() 
	{
		open_Exception_InEmployeeStatusSummaryContainer(idCheckException,"//div[@id='IDCheckPanel-figure']");
	}
	
	public void open_AccessAndAttendenceException_InEmployeeStatusSummaryContainer() 
	{
		open_Exception_InEmployeeStatusSummaryContainer(accessAndAttendanceException,"//div[@id='AccessAndAttendancePanel-figure']");
	}
	
	public void verify_HeadingAndCountForExceptionResult_InEmployeeStatusSummaryContainer(int result) 
	{
		List<WebElement> headinglist=driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/thead/tr/th"));
		 for(WebElement ele:headinglist)
		 {
			  String headingtext=ele.getText().replace("\n", "");
			  Assert.assertTrue(isElementPresent(ele), ""+headingtext+" is missing in the System list"); 
		 }
		 if(result<=100)
		 {
		  List<WebElement> firstNameList=driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[2]"));
		  Assert.assertEquals(result, firstNameList.size());
		 }
	}
	
	public void browseEmployee_Colapses()
    {
		try {
		      Assert.assertTrue(isElementPresentByXpath("//*[@id='collSrc']"), "Unable to find employee search box.");
		      FindElement("xpath", "//a[@href='#collSrc']/strong").click();
		      Assert.assertTrue(isElementPresentByXpath("//*[@id='collSrc' and @aria-expanded='false']"), "The employee search box was not colapsed.");
		      waitForSeconds(1);
              FindElement("xpath", "//a[@href='#collSrc']").click();
              Assert.assertTrue(isElementPresentByXpath("//*[@id='collSrc' and @aria-expanded='true']"), "The employee search box was not colapsed."); 
		}
		catch(Exception e)
		{
			e.getCause();
		}
    }
	
	 public void browseEmployee_ContentCheck()
     {
         for (String inputfieldID : new String[] { "FilterFirstName", "FilterLastName", "select2-FilterContractorIds-container","FilterBioID" ,"FilterAssignedToUser"})
         {
	    	  Assert.assertTrue(isElementPresentById(inputfieldID), "The employee search box should include the "+inputfieldID+" element.");
         }

         for (String headingText : new String[] { "First Name", "Last Name", "Contractor","Bio ID","Assigned To","Include Non-Associated Employees","Include Archived Employees" })
         {
        	 Assert.assertTrue(isElementPresentByXpath("//div[@id='collSrc']//label[contains(text(), '"+headingText+"')]"), "The employee search box should include the "+headingText+" element.");
         }
         
         Assert.assertTrue(isElementPresentByXpath("//a[contains(text(), 'Reload')]"), "Reload button was not present");
         Assert.assertTrue(isElementPresentByXpath("//button[contains(text(), 'Search') and @id='EmployeeListSearch']"), "Search button was not present.");
     }

	 public void selectContracotr(String contractorName) 
	 {
        	 FindElement("xpath", "//span[@class='select2 select2-container select2-container--bootstrap']").click();
        	 FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']/input").sendKeys(contractorName);
        	 waitForSeconds(2);
        	 FindElement("xpath", "//li[contains(text(),'"+contractorName+"')]").click();
	 }
	 
	 public void selectRole(String Role) 
	 {
		 FindElement("xpath", "//select[@name='RoleID']/following-sibling::span//span[@class='select2-selection__placeholder']").click();
    	 FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']/input").sendKeys(Role);
    	 waitForSeconds(2);
    	 FindElement("xpath", "//li[contains(text(),'"+Role+"')]").click();
	 }
	 public void uploadDoc(String doc) 
	 {
		 StringSelection ss = new StringSelection(doc);
   	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	      Robot robot;
		try {
			  robot = new Robot();
			  robot.keyPress(KeyEvent.VK_CONTROL);
	    	  robot.keyPress(KeyEvent.VK_V);
	    	  robot.keyRelease(KeyEvent.VK_V);
	    	  robot.keyRelease(KeyEvent.VK_CONTROL);
	    	  robot.keyPress(KeyEvent.VK_ENTER);
	    	  robot.keyRelease(KeyEvent.VK_ENTER);
	    	  waitForSeconds(4);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	 }
	 public void browseEmployee_Search(String firstName, String lastName, String contractorName, String bioID,String ContractorType) 
     {
         FindElement("id", "FilterFirstName").sendKeys(firstName);
         FindElement("id", "FilterLastName").sendKeys(lastName);
         if (contractorName != null && contractorName !="")
         {
        	 selectContracotr(contractorName);
         }
         if(ContractorType == "Contractors")
         {
            FindElement("id", "FilterBioID").sendKeys(bioID);
         }
         else
         {
             Assert.assertFalse((isElementPresentById("FilterBioID")), "The Bio Id filter should be disabled in non-construction mode");
             Assert.assertEquals("", bioID, "Searching by BioID is disabled in non-construction mode. Unable to search for bio id = '{bioID}'");
         }
         FindElement("id", "IncludeNonAssociatedEmployees").click();
         FindElement("id", "EmployeeListSearch").click();
         waitForSeconds(2);
         WebElement numberToShow=FindElement("xpath", "//select[@id='NumberToShow']");
         numberToShow.click();
         Select select = new Select(numberToShow);
 		 select.selectByIndex(2);
 		 waitForSeconds(2); 
     }
	
	 public void searchResults_CheckAttributeValues(String attributeID, String valueToCheck, boolean exactMatch)
     {
         for (WebElement row : driver.findElements(By.xpath("//tr[@class='rowlink']")))
         {
             String actualValue = row.findElement(By.xpath(".//td["+attributeID+"]/a")).getText().toLowerCase();
             if (exactMatch)
                 Assert.assertEquals(valueToCheck.toLowerCase(), actualValue);
             else
                 Assert.assertTrue(actualValue.contains(valueToCheck.toLowerCase())); 
         }
         
     }
	 
	 public String[] getEmployee() 
     {
         FindElement("id", "EmployeeListSearch").click();
           waitForSeconds(1);
         for (WebElement row : driver.findElements(By.xpath("//tr[@class='rowlink']")))
         {
             String bioId = row.findElement(By.xpath("./td[1]/a")).getText();
             if (!bioId.equalsIgnoreCase(""))
             {
                 String[] employee = new String[3];
                 int constructionModeOffset = 0;
                 employee[0] = bioId;
                 employee[1] = row.findElement(By.xpath("./td[2 - "+constructionModeOffset+"]/a")).getText();
                 employee[2] = row.findElement(By.xpath("./td[3 -"+ constructionModeOffset+"]/a")).getText(); 
                 return employee;
             }
         }
         return null;
     }
	 
	 public void searchResult_ForEpmtySearch() 
	 {
		 Assert.assertTrue(isElementPresentByXpath("//tr[@class='rowlink']"), "No employee found");
	 }
	 
	public void browserEmployee_Reload() 
	{
		FindElement("xpath", "//a[contains(text(), 'Reload')]").click();
	}
	 public void searchResult_ForRelaod() 
	 {
		 for (String inputfieldID : new String[] { "FilterFirstName", "FilterLastName","FilterBioID"})
         {
			 Assert.assertEquals(FindElement("id", inputfieldID).getText(), "");	 
         }	 
	 }
	 
	 public void open_AddNewEmployee()
	 {
		 FindElement("xpath", "//a[contains(text(),'Add a New Employee')]").click();
		 waitForSeconds(2);
		 Assert.assertEquals(driver.getTitle(), "MSite - Add a New Employee"); 
	 }
	 
	 public void verify_AllElement_InAddNewEmployeePage() 
	 {
		 Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]"), "Add Employee Heading in Section is not present");
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default personalDetailsPanel panel-employee']"), "Personal Detail Section is not present");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default inline messagedialog']"), "Reload button is missing");
		 WebElement savebutton=FindElement("xpath", "//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']");
		 Assert.assertTrue(isElementEnabled(savebutton), "Either Save button is missing or its is enabled by default");
	 }
	 
	 public void addNewEmployee_ReloadTest(boolean cancelReload)
     {
         FindElement("id", "FirstName").sendKeys("Automated_Test");
         FindElement("id", "LastName").sendKeys("Employee");
         addNewEmployee_Reload(cancelReload);
     }
	 
	 public void addNewEmployee_Reload(boolean cancelReload) 
	 {
		 String firstNameValue = FindElement("id", "FirstName").getAttribute("value");
         FindElement("xpath", "//button[contains(text(), 'Reload')]").click();;
         waitForSeconds(3);
         Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Reload Dialog box is  not present.");
 		 Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Reload')]"), "Reload button in Dialog box is  not present.");
 		 Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to reset the form?')]"), "Relaod Dialog box Message is  not present.");
 		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Reload Dialog box Reload button is  not present.");
 		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Reload Dialog box Cancel button is  not present.");
         if (!cancelReload)
         {
        	 FindElement("xpath", "//button[@class='btn btn-primary']").click();
        	 waitForSeconds(2);
             Assert.assertEquals("", FindElement("id", "FirstName").getAttribute("value"), "Reload did not correctly reset the form.");
         }
         else
         {
        	 FindElement("xpath", "//button[@class='btn btn-default']").click();
        	 waitForSeconds(2);
             Assert.assertEquals(firstNameValue, FindElement("id", "FirstName").getAttribute("value"), "Reload changed the contents of the form.");
         }
	 }
	 
	 public void addNewEmployee_Epmty() 
	 {
		 if(savebutton.isEnabled()) 
			 Assert.fail("Save button can not be enabled by default");
		 else 
			 Assert.assertTrue(true, "Save button is enabled by default");	 
	 }
	 
	 public void addNewEmployee_SaveChangesButton() 
	 {
		 FindElement("id", "FirstName").sendKeys("Automated_Test");
		 FindElement("id", "LastName").sendKeys("Employee");
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='changeprompt unsaved']"), "Save Changes buttons are missing");
	 }
	 
	
	 public boolean change_PropertyVisibility_FromSystemSetting(String propertyName,String visible)  
	 {
		  FindElement("xpath", "//a[@href='/System']").click();
		  waitForSeconds(1);
		  FindElement("xpath", "//a[@href='/System/Settings']").click();
		  waitForSeconds(1);
		  FindElement("xpath", "//input[@placeholder='Search settings...']").click();
		  waitForSeconds(1);
     	  FindElement("xpath", "//input[@placeholder='Search settings...']").sendKeys(propertyName);
     	  waitForSeconds(1);
		   FindElement("xpath", "//td[contains(text(),'"+propertyName+"')]").click();
		   waitForSeconds(2);
		  WebElement visibility= FindElement("xpath", "//select[@id='BooleanValue']");
		  visibility.click();
		  if(visible.equalsIgnoreCase("Enabled"))
		  {
		    selectValueByIndex(visibility, 0);
		    FindElement("xpath", "//button[@class='btn btn-primary']").click();
		    waitForSeconds(4);
		    return true;
		  }
	    else
	     {
			    selectValueByIndex(visibility, 1);
		        FindElement("xpath", "//button[@class='btn btn-primary']").click();
		        waitForSeconds(4);
		       return false;
		  }
	 }
	 	 
	 public void check_TrainingOrIDCheck_Visibility_InEmployeesPage(String visible,String propertyName) 
	  {
		  boolean visiblity=change_PropertyVisibility_FromSystemSetting(propertyName,visible);
		  waitForSeconds(3);
		  openEmployees();
		  waitForSeconds(0.5);
		  if(visiblity) 
		  {
			  if(propertyName.contains("OnlineInduction"))
			   Assert.assertTrue(isElementPresent(trainingExceInEmployee), "trainingExceInEmployee is missing");
			  else
			  Assert.assertTrue(isElementPresent(IDCheckInEmployee), "IDCheckInEmployee is missing");
		  }
		  else 
		  {
			     if(propertyName.contains("OnlineInduction"))
				      Assert.assertFalse(isElementPresent(trainingExceInEmployee), "trainingExceInEmployee is not missing");
				  else
					  Assert.assertFalse(isElementPresent(IDCheckInEmployee), "IDCheckInEmployee is not  missing");	
		  }
		  
	  }
	 
	 public void addNewEmployee_NonSensitiveBiograpic() 
	 {
		 if(isElementPresent(NonSensitiveBiograpic) && isElementEnabled(NonSensitiveBiograpic)) 
		 {
			 NonSensitiveBiograpic.click();
			 waitForSeconds(0.5);
			 FindElement("xpath", "//select[@data-automation-id='Non-SensitiveBiographicPersonalDataAcknowledgementCustomField']//option[contains(text(),'Yes')]").click();
			 waitForSeconds(2);
		 }
	 }
	 
	 public void addNewEmployee_BiometricAndBiographicConsent() 
	 {
		 if(isElementPresent(biometricPersonalConsent) && isElementEnabled(biometricPersonalConsent)) 
		 {
			 biometricPersonalConsent.click();
			 waitForSeconds(0.5);
			 FindElement("xpath", "//select[@data-automation-id='BiometricPersonalDataConsentCustomField']//option[contains(text(),'Yes')]").click();
			 waitForSeconds(0.5);
			 FindElement("xpath", "//label[contains(text(),'Biometric and Biographic Consent')]").click();
			 waitForSeconds(1);
		 }
	 }
	 public void addNewEmployee(String contractorName,String Role) 
	 {
		 employee_PersonalDetailSection(contractorName,Role);
		 check_SaveButtonVisibility();
		 employee_InductionRequirements();
		 employee_ManageSiteSection("No");
		 employee_NextOfKin();
		 employee_Accreditations(9);
		 employee_Accreditations(56);
		 employee_IndustryAccreditations("Construction Industry Scaffolders Record Scheme");
		 employee_IndustryAccreditations("ACTA");
		 employee_TrainingAccreditations("Data Protection and you");
		 employee_TrainingAccreditations("CITB Site Safety Plus Site Management Safety Training Scheme");
		 employee_TrainingAccreditations("CITB Site Safety Plus Site Supervisors Safety Training Scheme");
		 addNewEmployee_NonSensitiveBiograpic();
		 addNewEmployee_BiometricAndBiographicConsent();
		 employee_SkillInformation();
		 employee_KPIQuestions();
		 employee_RequirementForHealthCheck();
		 employee_DeclarationStatement();
		 waitForSeconds(2);
		 scrollToElement(savebutton);
	     Assert.assertTrue(isElementEnabled(savebutton),"save button is not enabled");
	     savebutton.click();
	     waitForSeconds(2);
	     Assert.assertTrue(isElementPresentById("messagedialog-dialog"), "Message Dialog is missing");
	     Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to save?')]"), "Message Dialog Message is missing");
	     Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//button[@class='btn btn-default'][contains(text(),'Cancel')]"), "Message Dialog Cancel button is missing");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Save button is missing");
	     FindElement("xpath", "//button[@class='btn btn-primary']").click();
	     waitForSeconds(5);  
	     Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'Create Date')]"), "Created Date label is missing");
	     Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'Created Via')]"), "Created Via label is missing");
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String currentdatetime = simpleDateFormat.format(new Date());
		 Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'"+currentdatetime+"')]"), "Created Date is missing");	
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='col-md-9']//span[contains(text(),'MSite')]"), "Created via name is missing");	
	 }
	 	 
	 public void employee_PersonalDetailSection(String contractorName,String Role)  
	 {
		 List<WebElement> personalDetailLabelElements=driver.findElements(By.xpath("//div[@class='col-md-9']/div//label"));
		 for(WebElement label:personalDetailLabelElements) 
		 {
				 if((label.getText().contains("First Name")))
				 {
					 FindElement("id", "FirstName").sendKeys("Deepak_Employee_Test_1");
				 }
				 else if(label.getText().contains("Last Name")) 
				 {
					 FindElement("id", "LastName").sendKeys("TestEmployee");
				 } 
				 else if(label.getText().contains("Contractor")) {
                     selectContracotr(contractorName);
			    	 waitForSeconds(0.5);
				 }
				 else  if(label.getText().contains("Role")) {
					 selectRole(Role);
				 }
				 else  if(label.getText().contains("Contact Number")) 
				 {
					 FindElement("xpath", "//input[@data-automation-id='ContactNumberCustomField']").sendKeys("07986543210");
				 }	
				 else if(label.getText().contains("Date of Birth")) {
					 WebElement dob= FindElement("xpath", "//input[@data-automation-id='DateofBirthCustomField']");
			    	 dob.sendKeys("03/02/2000");
			    	 dob.sendKeys(Keys.ENTER);
			    	 waitForSeconds(0.5);
				 }
				 else if(label.getText().contains("Gender")) {
					 FindElement("xpath", "//select[contains(@data-automation-id,'Gender')]/parent::div/span").click();
			    	 waitForSeconds(0.5);
			    	 FindElement("xpath", "//li[contains(text(),'Male')]").click(); 
				 }
				 else if(label.getText().contains("Email Address")) 
				 {
					 FindElement("xpath", "//input[@data-automation-id='EmailAddressCustomField']").sendKeys("meem.deep.test1+16@gmail.com");
				 }
				 else if(label.getText().contains("Post Code")) 
				 {
					 FindElement("xpath", "//input[@data-automation-id='PostCodeCustomField']").sendKeys("l45 7bh");
				     waitForSeconds(0.5); 
				 } 
		          else if(label.getText().contains("Are you an Apprentice")) 
				 {
					 FindElement("xpath", "//select[@id='CustomFields_6__Value']").click();
					 FindElement("xpath", "//select[@data-automation-id='AreyouanApprenticeCustomField']//option[contains(text(),'No')]").click();
				     waitForSeconds(0.5);	 
				 }
				 else if(label.getText().contains("Trade *")) 
				 {
					 FindElement("xpath", "//select[@data-automation-id='TradeCustomField']/parent::div/span").click();
					 waitForSeconds(1);
					 FindElement("xpath", "//input[@class='select2-search__field']").sendKeys("Asbestos Work");
					 waitForSeconds(1);
			    	 FindElement("xpath", "//li[contains(text(),'Asbestos Work')]").click();
				     waitForSeconds(0.5);	 
				 }
				 else if(label.getText().contains("Add Attachment")) 
				 {
					 Assert.assertTrue(isElementPresentByXpath("//div[@class='panel-heading panel-heading-sm']"), "Char CF Dialog is missing in personal detail");
					 if(isElementPresentByXpath("//strong[contains(text(),'Charl CF')]")) 
					 {
					   FindElement("xpath", "//label[@class='btn btn-default btn-xs btn-file']").click();
					   waitForSeconds(1);
					   uploadDoc("D:\\Deepak Doc\\79e3552b-f419-4209-8491-b09f9f6f802c.pdf");
					 }
				 }
				 else if(label.getText().equalsIgnoreCase("Charl CF 2")) 
				 {
					 FindElement("xpath", "//input[@data-automation-id='CharlCF2CustomField']").sendKeys("document");;
					 waitForSeconds(1);	 
				 }
				 else if(label.getText().equalsIgnoreCase("Confirm Charl CF 2")) 
				 {
					 FindElement("xpath", "//input[@data-automation-id='ConfirmCharlCF2CustomField']").sendKeys("document");;
					 waitForSeconds(1); 
				 }
				 
				 else if(label.getText().contains("Are You Under 18 Years Old *")) 
				 {
					 FindElement("xpath", "//span[@id='select2-CustomFields_1__Value-container']").click();
					 waitForSeconds(1);
			    	 FindElement("xpath", "//select[@id='CustomFields_1__Value']//option[contains(text(),'Yes')]").click();
				     waitForSeconds(0.5);	 
				 }
				 
				 else if(label.getText().contains("NI Number *")) 
				 {
					 FindElement("xpath", "//input[@data-automation-id='NINumberCustomField']").sendKeys("AB 12 34 56 C");;
					 waitForSeconds(1); 
				 }
		 }
		      waitForSeconds(2); 
	 }
	 
	 public void employee_DuplicateDailogInAddEmplyee(String contractorName,String Role ) 
	 {
		 FindElement("id", "FirstName").sendKeys("Deepak_Employee_Test_1");
		 FindElement("id", "LastName").sendKeys("TestEmployee");
		 selectContracotr(contractorName);
    	 waitForSeconds(0.5);
    	 selectRole(Role);
    	 waitForSeconds(0.5);
    	 WebElement dob= FindElement("xpath", "//input[@data-automation-id='DateofBirthCustomField']");
    	 dob.sendKeys("03/02/2000");
    	 dob.sendKeys(Keys.ENTER);
    	 waitForSeconds(3);
		 Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Duplication Dialog Box is missing");
		 Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Duplication')]"), "Duplication Header is missing");
		 Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'A duplicate entry has been detected, would you lik')]"), "Duplicate Confirmation Message is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button  is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Load button is missing");
		 FindElement("xpath", "//button[@class='btn btn-default']").click();
		 waitForSeconds(2); 
	 }
	  
   public void employee_ManageSiteSection(String inducted)  
   {
	   if(isElementPresentByXpath("//div[@class='panel panel-default siteAccessPanel panel-employee']"))
	     {
		   Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default siteAccessPanel panel-employee']//div[@class='complexlist-empty'][contains(text(),'None')]").getText(), "None", "None is missing");
	 	   FindElement("xpath", "//button[@data-title='Manage Site Association' and contains(text(), 'Add...')]").click();
	 	   waitForSeconds(2);
		   isElementPresentById("complexlist-dialog");
	 	   WebElement siteselector=FindElement("id", "Sites_INDEX__SiteID");
	 	   siteselector.click();
	 	   waitForSeconds(1);
	 	   FindElement("xpath", "//option[contains(text(),'Deepak_Test')]").click();
	 	   waitForSeconds(1);
	 	   WebElement modeoftransport=FindElement("id", "Sites_INDEX__ModeOfTransportID");
	 	  modeoftransport.click();;
	 	  selectValueByIndex(modeoftransport, 1);
	 	  waitForSeconds(1);
	 	  if(inducted.equalsIgnoreCase("Yes")) 
	 	  {
	 		   FindElement("xpath", "//select[@id='Sites_INDEX__Inducted']").click();
	 		   FindElement("xpath", "//select[@id='Sites_INDEX__Inducted']//option[contains(text(),'Yes')]").click();
	 		   waitForSeconds(1);
	 		   FindElement("xpath", "//div[@class='input-append date input-group induction-date change active']").click();
	 		   FindElement("xpath", "//div[@class='datepicker-days']//th[@class='today'][contains(text(),'Today')]").click();
	 		   waitForSeconds(1);
	 	  }
	 	  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	 	  waitForSeconds(3);
	     }
   }
   
   public void employee_ManagaeSiteSection_Empty() 
   {
	   if(isElementPresentByXpath("//div[@class='panel panel-default siteAccessPanel panel-employee']")) 
	   {
		   Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default siteAccessPanel panel-employee']//div[@class='complexlist-empty'][contains(text(),'None')]").getText(), "None", "None is missing");
	   }
   }
   
   public void employee_Verify_ManagaeSiteSection_Induction(String inductionType) 
   {
	   if(isElementPresentByXpath("//div[@class='panel panel-default siteAccessPanel panel-employee']")) 
	   {
		   Assert.assertTrue(isElementPresentByXpath("//span[contains(text(),'"+inductionType+"')]"), ""+inductionType+" is missing");
	   }
   }
  
   public void edit_And_VerifyEdit_ManageSiteSection()  
   {
	      employee_ManageSiteSection("No");
	      FindElement("xpath", "//button[@data-title='Manage Site Association' and contains(text(), 'Edit')]").click();
	      waitForSeconds(1);
	      String beforeEdit=FindElement("xpath", "//select[@id='dialog-Sites_0__ModeOfTransportID']").getAttribute("value");
	      Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary btn-update-complext-list-item']"), "Update button is missing");
	 	  WebElement modeoftransport=FindElement("id", "dialog-Sites_0__ModeOfTransportID");
	 	  modeoftransport.click();;
	 	  selectValueByIndex(modeoftransport, 2);
	 	  waitForSeconds(1);
	 	  FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
	 	  waitForSeconds(2);
	 	  FindElement("xpath", "//button[@data-title='Manage Site Association' and contains(text(), 'Edit')]").click();
	 	  waitForSeconds(1);
	 	  String afterEdit=FindElement("xpath", "//div[@class='modal-body']//select[@id='dialog-Sites_0__ModeOfTransportID']").getAttribute("value");
	 	  if(beforeEdit.equalsIgnoreCase(afterEdit)) 
	 	  {
	 		  Assert.fail("not updated");
	 	  }
	 	  FindElement("xpath", "//button[@class='btn btn-default']").click();
	 	  waitForSeconds(2);  
   }
   
   public void cancelAction() 
   {
	   WebElement cancelbutton=FindElement("xpath", "//button[@class='btn btn-default']");
	   cancelbutton.click();
	   waitForSeconds(1);
   }
   
   public void delete_Or_Add_Action() 
   {
	   WebElement deleteindialogbutton=FindElement("xpath", "//button[@class='btn btn-primary']");
	   deleteindialogbutton.click();
	   waitForSeconds(1);
   }
   public void delete_ManageSiteSection(String Action)  
   {
	     employee_ManageSiteSection("No");
	     FindElement("xpath", "//button[@data-title='Manage Site Association' and contains(text(), 'Delete')]").click();
	     waitForSeconds(1);
	     Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//div[@class='modal-content']"), "Delete Dialog box is not open.");
	     Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Delete manage site section heading  is  not present.");
	     Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete this site')]"), "Delete confirm message is  missing.");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is  not present.");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is  not present.");
	    if(Action.contains("Cancel"))
	   {
	    	cancelAction();
	   }
	   else 
	   {
		   delete_Or_Add_Action();
	   }
	
   }
   public void employee_Attachments() 
   {
	  
	   if(isElementPresent(attachmentSection))
	     {
		      Assert.assertEquals(FindElement("xpath", "//div[@class='complexlist soft-delete']//div[@class='complexlist-empty'][contains(text(),'None Provided')]").getText(), "None Provided", "None is missing");
	    	  FindElement("xpath", "//button[@data-title='Attachments' and contains(text(), 'Add...')]").click();
	    	  waitForSeconds(2);
	    	  Assert.assertTrue(isElementPresentById("complexlist-dialog"));
	    	  Assert.assertTrue(isElementPresentByXpath("//label[@for='Attachments_INDEX__Title']"),"Title Field is missing");
	    	  Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//label[contains(text(),'Type')]"),"Type Field is missing");
	    	  Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//button[contains(@class,'btn btn-default')][contains(text(),'Cancel')]"));
	    	  Assert.assertTrue(isElementPresentByXpath("//button[contains(@class,'btn btn-primary btn-add disabled')]"));
	    	  FindElement("id", "Attachments_INDEX__Title").sendKeys("attachment");
	    	  selectValueByIndex(FindElement("id", "Attachments_INDEX__TypeId"), 1);
	    	  FindElement("xpath", "//div[@id='complexlist-dialog']//div[@class='col-xs-4 img-upload-button-col']//button").click();
	    	  waitForSeconds(0.5);
              uploadDoc("D:\\Deepak Doc\\79e3552b-f419-4209-8491-b09f9f6f802c.pdf");
	    	  Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'fileupload-progresstext')]"), "Image is not uploaded successfully");
	    	  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	    	  waitForSeconds(2);
	    	  savebutton.click();
	    	  waitForSeconds(7);
	     }
   }
   
   public void edit_And_VerifyEdit_Attachments()  
   {
	   if(isElementPresent(attachmentSection)) {
	      FindElement("xpath", "//button[@data-title='Attachments' and contains(text(), 'Edit')]").click();
	      waitForSeconds(1);
	      WebElement title=FindElement("id", "dialog-Attachments_0__Title");
	      String firstName= title.getAttribute("value");
	      title.clear();
	      title.sendKeys("deepak");
	      FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
	 	  waitForSeconds(1);
	 	   FindElement("xpath", "//button[@data-title='Attachments' and contains(text(), 'Edit')]").click();
	      waitForSeconds(1);
	      String updatedfirstName= FindElement("xpath", "//div[@class='modal-body']//input[@id='dialog-Attachments_0__Title']").getAttribute("value");
	      if(updatedfirstName.equalsIgnoreCase(firstName)) 
	 	  {
	 		  Assert.fail("not updated");
	 	  }
	       
	      FindElement("xpath", "//button[@class='btn btn-default']").click();
	 	  waitForSeconds(1);
	   }
   }
   public void delete_Attachments(String Action)  
   {
	   if(isElementPresent(attachmentSection)) {
	      FindElement("xpath", "//button[@data-title='Attachments' and contains(text(), 'Delete')]").click();
	     waitForSeconds(1);
	     Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//div[@class='modal-content']"), "Delete Dialog box is not open.");
	     Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Delete manage site section heading  is  not present.");
	     Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete this attachment?')]"), "Delete confirm message is  missing.");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is  not present.");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is  not present.");
	    if(Action.contains("Cancel"))
	    {
	    	cancelAction();
	   }
	   else 
	   {
		   delete_Or_Add_Action();
	   }
	   }
   }
   
   public void employee_NextOfKin() 
   {
	   if(isElementPresent(nextofkinDialogBox))
	     {
		   Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default nokPanel panel-employee']//div[@class='complexlist-empty'][contains(text(),'None Provided')]").getText(), "None Provided", "None is missing");
	    	 FindElement("xpath", "//button[@data-title='Next of Kin' and contains(text(), 'Add...')]").click();
	    	  waitForSeconds(2);
	    	  Assert.assertTrue(isElementPresentById("complexlist-dialog"));
	    	  FindElement("id", "NextOfKin_INDEX__FirstName").sendKeys("ddd");
	    	  FindElement("id", "NextOfKin_INDEX__LastName").sendKeys("ffff");
	    	  FindElement("id", "NextOfKin_INDEX__Relationship").sendKeys("rrrr");
	    	  FindElement("id", "NextOfKin_INDEX__TelephoneNumber").sendKeys("09999999999999");
	    	  FindElement("id", "NextOfKin_INDEX__MobileNumber").sendKeys("87878787787777");
	    	  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	    	  waitForSeconds(2);
	     }
   }
   
   public void edit_And_VerifyEdit_NextOfKin()  
   {
	   if(!isElementPresent(nextofkinDialogBox))
	   {
		    selectContracotr("Deepak_Automation_Contractor");
	    	 waitForSeconds(0.5);
	   }
	   else {
	      employee_NextOfKin();
	      FindElement("xpath", "//button[@data-title='Next of Kin' and contains(text(), 'Edit')]").click();
	      waitForSeconds(1);
	      String firstName= FindElement("xpath", "//input[@id='dialog-NextOfKin_0__FirstName']").getAttribute("value");
	      FindElement("xpath", "//input[@id='dialog-NextOfKin_0__FirstName']").sendKeys("deepak");
	      FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
	 	  waitForSeconds(1);
	 	   FindElement("xpath", "//button[@data-title='Next of Kin' and contains(text(), 'Edit')]").click();
	      waitForSeconds(1);
	      String updatedfirstName= FindElement("xpath", "//div[@class='modal-body']//input[@id='dialog-NextOfKin_0__FirstName']").getAttribute("value");
	      if(updatedfirstName.equalsIgnoreCase(firstName)) 
	 	  {
	 		  Assert.fail("not updated");
	 	  }
	       
	      FindElement("xpath", "//button[@class='btn btn-default']").click();
	 	  waitForSeconds(2);
	   }
   }
   public void delete_NextOfKin(String Action)  
   {
	   if(!isElementPresent(nextofkinDialogBox))
	   {
		   selectContracotr("Deepak_Automation_Contractor");
	    	 waitForSeconds(0.5);
	   }
	   else {
	      employee_NextOfKin();
	      FindElement("xpath", "//button[@data-title='Next of Kin' and contains(text(), 'Delete')]").click();
	     waitForSeconds(1);
	     Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//div[@class='modal-content']"), "Delete Dialog box is not open.");
	     Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Delete manage site section heading  is  not present.");
	     Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete this next of kin?')]"), "Delete confirm message is  missing.");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is  not present.");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is  not present.");
	    if(Action.contains("Cancel"))
	   {
		   cancelAction();
	   }
	   else 
	   {
		   delete_Or_Add_Action();
	   }
	   }
	
   }
   
   public void employee_IndustryAccreditations(String Accreditaion) 
   {
	   if(isElementPresent(industryaccreditationsection))
	     {
	    	  FindElement("xpath", "//button[@data-title='Industry Accreditations' and contains(text(), 'Add...')]").click();
	    	  waitForSeconds(2);
	    	  isElementPresentById("complexlist-dialog");
	    	  List<WebElement> accreditaionList=driver.findElements(By.xpath("//select[@id='Accreditations_INDEX__AccreditationTypeID']/option"));
	    	  int i=0;
	    	  for(WebElement option:accreditaionList) 
	    	{ 
	    		if(option.getText().contains(Accreditaion)) 
	    		{
	    			selectValueByIndex(FindElement("id", "Accreditations_INDEX__AccreditationTypeID"), i);
	    			break;
	    		}
	    		else {
	    			selectValueByIndex(FindElement("id", "Accreditations_INDEX__AccreditationTypeID"), 12);
	    		}
	    		i++;
	    	}
	    	  waitForSeconds(2);
	    	  if(isElementEnabled(certificationnumber)) 
	    	  {
	    		  FindElement("xpath", "//input[@id='Accreditations_INDEX__CertificationNumber']").sendKeys("1234");
	    		  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
		    	  waitForSeconds(2);
	    	  }
	    	  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	    	  waitForSeconds(5);
	     }
   }
   
   public void employee_Accreditations(int index) 
   {
	   if(isElementPresent(accreditationsection))
	     {
		   if(isElementPresent(accreditationAddButton)) {
	    	  FindElement("xpath", "//button[@data-title='Accreditations' and contains(text(), 'Add...')]").click();
	    	  waitForSeconds(2);
	    	  isElementPresentById("complexlist-dialog");
	    	  FindElement("id", "Accreditations_INDEX__AccreditationTypeID").click();
	    	  waitForSeconds(1);
	    	  selectValueByIndex(FindElement("xpath", "//select[@id='Accreditations_INDEX__AccreditationTypeID']"), index);
	    	  if(isElementEnabled(certificationnumber)) 
	    	  {
	    		  FindElement("xpath", "//input[@id='Accreditations_INDEX__CertificationNumber']").sendKeys("1234");
	    		  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
		    	  waitForSeconds(2);
	    	  }
	    	  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	    	  waitForSeconds(2);
	    	  isElementPresentByXpath("//label[contains(text(),'Main Card Category')]");
	    	  WebElement mainCard= FindElement("xpath", "//select[@id='CustomFields_20__Value']/parent::div/span");
	    	  mainCard.click();
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']/input").sendKeys("Black - Manager");
	    	  FindElement("xpath", "//li[contains(text(),'Black - Manager')]").click();
	    	  waitForSeconds(0.5);
		   }
	     }
   }
   public void employee_InductionRequirements() 
   {
	   if(isElementPresent(inductionRequirement))
	     {
	    	  Assert.assertEquals(FindElement("xpath", "//label[contains(text(),'Will you require an interpreter for induction?')]").getText().trim(), "Will you require an interpreter for induction? *");
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath","//select[@id='CustomFields_18__Value']/parent::div/span").click();
	    	  waitForSeconds(0.5);;
	    	  FindElement("xpath", "//li[contains(text(),'No')]").click();
	    	  waitForSeconds(0.5);
	     }
   }
   
   public void employee_SkillInformation() 
   {
	   if(isElementPresent(skillInformation))
	     {
	    	  Assert.assertEquals(FindElement("xpath", "//label[contains(text(),'Has the RAMS briefing been carried out for this individual?')]").getText().trim(), "Has the RAMS briefing been carried out for this individual? *");
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath", " //select[@id='CustomFields_28__Value']/parent::div/span").click();
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath", "//li[contains(text(),'No')]").click();
	    	  waitForSeconds(1);
	     }
   }
   
   public void employee_KPIQuestions() 
   {
	   if(isElementPresent(kpiQuestion))
	     {
		   String[] kpiquestionList = new String[] { "Please confirm your age range", "Previous Employment Status", "When did you start working with your current employer?", "Disability", "KPI Training", "Whilst on site do you anticipate completing any of the following training?", "Ethnic background? (N/A Unless advised otherwise)", "Are you currently completing an NVQ?" };
		   for (String str : kpiquestionList)  
	        { 
	            Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'"+str+"')]"), "unable to find "+str+"");
	        }  
		     List<WebElement> kpianswerlist=driver.findElements(By.xpath("//div[contains(@class,'panel panel-default panel-employee panel-kpi-questions')]//span[@class='select2 select2-container select2-container--bootstrap']"));
		     int i=0;
		     for(WebElement answer:kpianswerlist)
		      {
		    	  answer.click();
		    	  String[] kpiansweroptionList = new String[] { "18-24", "Full Time", "Within a Fortnight", "No", "First Aid", "NVQ", "Arab", "No" };
		    	  String[] kpifieldidList = new String[] { "PleaseconfirmyouragerangeCustomField", "PreviousEmploymentStatusCustomField", "Whendidyoustartworkingwithyourcurrentemployer?CustomField", "DisabilityCustomField", "KPITrainingCustomField", "Whilstonsitedoyouanticipatecompletinganyofthefollowingtraining?CustomField", "Ethnicbackground?(N/AUnlessadvisedotherwise)CustomField", "AreyoucurrentlycompletinganNVQ?CustomField" };
		    	  
			            FindElement("xpath", "//select[@data-automation-id='"+kpifieldidList[i]+"']//option[contains(text(),'"+kpiansweroptionList[i]+"')]").click();
			            waitForSeconds(0.5);
			            i++;
			        
		    	  waitForSeconds(0.5);
		      }
	     }
   }
   
   public void employee_RequirementForHealthCheck() 
   {
	   if(isElementPresent(healthandCheckup))
	     {
	    	  Assert.assertEquals(FindElement("xpath", "//label[contains(text(),'Is your role listed above?')]").getText().trim(), "Is your role listed above? *");
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath", "//div[contains(@class,'panel panel-default panel-employee panel-requirements-for-health-checks-on-bam-projects')]//span[contains(@class,'select2 select2-container select2-container--bootstrap')]").click();
	    	  waitForSeconds(0.5);;
	    	  FindElement("xpath", "//li[contains(text(),'No')]").click();
	    	  waitForSeconds(0.5);
	     }
   }
   
   public void employee_DeclarationStatement() 
   {
	   if(isElementPresent(declarationStatement))
	     {
	    	  Assert.assertEquals(FindElement("xpath", "//label[contains(text(),'decleration statement')]").getText().trim(), "decleration statement *");
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath", "//div[contains(@class,'panel panel-default panel-employee panel-declaration-statement')]//span[contains(@class,'select2 select2-container select2-container--bootstrap')]").click();
	    	  waitForSeconds(0.5);
	    	  FindElement("xpath", "//li[contains(text(),'I agree')]").click();
	    	  waitForSeconds(1);
	     }
   }
   public void employee_TrainingAccreditations(String Accreditaion) 
   {
	   if(isElementPresent(trainingaccreditationsection))
	     {
	    	  FindElement("xpath", "//button[@data-title='Training Accreditations' and contains(text(), 'Add...')]").click();
	    	  waitForSeconds(2);
	    	  isElementPresentById("complexlist-dialog");
	    	  
	    	  List<WebElement> accreditaionList=driver.findElements(By.xpath("//select[@id='AccreditationTraining_INDEX__AccreditationTypeID']/option"));
	    	  int i=0;
	    	  for(WebElement option:accreditaionList) 
	    	{ 
	    		if(option.getText().contains(Accreditaion)) 
	    		{
	    			selectValueByIndex(FindElement("id", "AccreditationTraining_INDEX__AccreditationTypeID"), i);
	    			break;
	    		}
	    		else 
	    		{
	    			selectValueByIndex(FindElement("id", "AccreditationTraining_INDEX__AccreditationTypeID"), i);
	    		}
	    		i++;
	    	}
	    	  waitForSeconds(2);
	    	  if(isElementEnabled(certificationnumber)) 
	    	  {
	    		  FindElement("xpath", "//input[@id='AccreditationTraining_INDEX__CertificationNumber']").sendKeys("1234");
	    		  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	    		  waitForSeconds(2);
	    	  }
	    	  FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	    	  waitForSeconds(2);
	     }
   }
   
   public void check_SaveButtonVisibility() 
   {
	   FindElement("xpath", "//strong[contains(text(),'Manage Site Association')]").click();
	   Assert.assertTrue(savebutton.isEnabled(), "save button is not enabled");
	   
   }
    
   public void employee_Open_Edit_NeworExistingEmployee(String firstName)  
   {
	   browseEmployee_Search(firstName, "", "", "", "Contractors");
	   FindElement("xpath", "//tr[@class='rowlink']//td[1]/a").click();
	   waitForSeconds(2);   
   }
   public void verifyAllElement_InEditEmployee() 
   {
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='name col-md-8 col-sm-6 hidden-xs']"), "Edit Empployee Name Heading is missing");
	   String firstName=FindElement("xpath", "//input[@id='FirstName']").getAttribute("value");
	   String lastName=FindElement("xpath", "//input[@id='LastName']").getAttribute("value");
	   Assert.assertEquals(FindElement("xpath","//div[@class='name col-md-8 col-sm-6 hidden-xs']").getText().trim(), firstName+" "+lastName);
	   Assert.assertTrue(isElementPresentById("btnEmployeeChangePromptAction"),"View Summary button is missing" );
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-danger inline messagedialog']"), "Delete Employee button Heading is missing");
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default inline messagedialog']"), "Discard Empployee Name Heading is missing");
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']"), "Save button Heading is missing");
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='name col-md-8 col-sm-6 hidden-xs']"), "Edit Empployee Name Heading is missing");   
   }
   
   public void open_Employee_DiscardChanges(String Action)  
   {
	    employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_1");
	     WebElement firstName=FindElement("id", "FirstName");
	     firstName.click();
	     firstName.clear();
	     waitForSeconds(0.5);
	     firstName.sendKeys("deepakmalviya");
	     FindElement("xpath", "//button[@class='btn btn-default inline messagedialog']").click();
	     waitForSeconds(1);
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button  is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Discard button is missing");
		 Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to reload the employee and d')]"), "Discard Changes message is missing");
		 if(Action.contains("Cancel"))
		   {
			    cancelAction();
			    waitForSeconds(2);
		   }
		   else 
		   {
			   delete_Or_Add_Action();
			   waitForSeconds(4);
		   }
		    
   }
   
   public void open_Employee_AndDeleteEmployee(String Action)  
   {  
		 if(Action.contains("Cancel"))
		   {
			   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
		       FindElement("xpath", "//button[@class='btn btn-danger inline messagedialog']").click();
		       waitForSeconds(1);
		       Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button  is missing");
			   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Discard button is missing");
			   cancelAction();
		   }
		   else 
		   {
			   while(true)
			   {   
				   FindElement("id", "searchText").clear();
				   FindElement("id", "searchText").sendKeys("Deepak_Automation_Contractor");
				   FindElement("xpath", "//*[@class='glyphicon glyphicon-search']").click();
				   waitForSeconds(2);
				   if(isElementPresent(employeeSearchResult)) 
				   {
					   Assert.assertTrue(isElementPresent(employeeSearchResult), "Text '0 Employees Found' not present."); 
					   break;
				   }
				   FindElement("xpath", "//div[@id='employees']//tbody//td[4]").click();
				   waitForSeconds(2);
				   FindElement("xpath", "//button[@class='btn btn-danger inline messagedialog']").click();
				   waitForSeconds(1);
				   FindElement("xpath", "//button[@class='btn btn-primary']").click();
				   waitForSeconds(1);
				   FindElement("xpath", "//button[@class='btn btn-primary']").click();
				   waitForSeconds(1);
				   
			   }
			 
		   }    
   }
   
    public void employee_Edit_NeworExistingEmployee()  
    {
    	 String updatedFirstName="Deepak_Employee_Test_2";
    	 String updatedLastName="TestEmployee2";
    	 employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_1");
    	 verifyAllElement_InEditEmployee();
    	 WebElement firstName=FindElement("id", "FirstName");
  	     WebElement lastName=FindElement("id", "LastName");
  	     firstName.click();
  	     firstName.clear();
  	     waitForSeconds(0.5);
  	     firstName.sendKeys(updatedFirstName);
  	     lastName.click();
  	     lastName.clear();
	     waitForSeconds(0.5);
	     lastName.sendKeys(updatedLastName);
	     FindElement("xpath", "//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']").click();
	     waitForSeconds(2);
	     if(isElementPresent(continueSavebutton)) 
	    {
	    	continueSavebutton.click();
	    	waitForSeconds(1);
	    }
	     waitForSeconds(5);
	     Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'Modify Date')]"), "Created Date label is missing");
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String currentdatetime = simpleDateFormat.format(new Date());
		 Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'"+currentdatetime+"')]"), "Modify Date is missing");	   
    }
   
   public void employee_OpenEmployee_And_ViewSummary() 
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   String firstName=FindElement("xpath", "//input[@id='FirstName']").getAttribute("value");
	   String lastName=FindElement("xpath", "//input[@id='LastName']").getAttribute("value");
	   String contractorName=FindElement("xpath", "//span[@id='select2-ContractorID-container']").getAttribute("title");
	   String role=FindElement("xpath", "//span[@id='select2-RoleID-container']").getAttribute("title");
	   FindElement("xpath", "//button[@id='btnEmployeeChangePromptAction']").click();
	   waitForSeconds(2);
	   Assert.assertTrue(isElementPresentById("btnEmployeeChangePromptAction"), "EditProfile button is missing");
	   Assert.assertEquals(FindElement("xpath","//div[@class='row employee-name-summary-view']").getText().trim(), firstName+" "+lastName);
	   Assert.assertEquals(FindElement("xpath","//div[contains(text(),'Deepak_Automation_Contractor')]").getText().trim(),contractorName);
	   Assert.assertEquals(FindElement("xpath","//div[contains(text(),'TestAnalyst')]").getText().trim(), role);
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='row secondary-info-summary-view']/div"), "Profile Created Date is missing");
	   Assert.assertTrue(isElementPresentById("btnSetEmployeeSummaryAsDefault"), "Set Summary view in Employee Record button is missing");
	   if(isElementPresent(trainingPanel)) 
	   {
	   Assert.assertTrue(isElementPresentById("panel-Training"), "Training Container is missing");
	   }
	   
	 //  Assert.assertTrue(isElementPresentById("panel-Accreditations"), "Accreditation panel  is missing");
	   if(isElementPresent(accessAttendencePanel))
	   {
	       Assert.assertTrue(true, "Access and Attendence Panel is missing");  
	   }
	   
   }
    
   public void employee_OpenEmployee_And_ManagePinEntry(String Action)  
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(isElementPresent(managePinEntry)) {
	   managePinEntry.click();
	   waitForSeconds(1);
	   Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Manage PIN Entry')]"), "Manage Pin entry is missing");
	   Assert.assertTrue(isElementPresentByXpath("//h4[@class='warning-message']"), "Warning Message is missing");
	   Assert.assertTrue(isElementPresentById("isPinEnabled"), "IsPinenabled Check box is missing");
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is missing");
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Save button is missing");
	   Assert.assertTrue(isElementPresentById("generatedPin"));
	   String beforeEnablePin=FindElement("id", "generatedPin").getText();
	   String afterEnablePin="";
	   if(beforeEnablePin.equalsIgnoreCase(" ")) 
	   {
	    FindElement("id", "isPinEnabled").click();
	    waitForSeconds(2);
	    afterEnablePin=FindElement("id", "generatedPin").getText();
	   if(beforeEnablePin.equalsIgnoreCase(afterEnablePin)) 
	   {
		   Assert.fail("pin is not there");
	   }
	   }
	   else 
	   {
		   afterEnablePin= beforeEnablePin;
	   }
	   FindElement("id", "generatePin").click();
	   waitForSeconds(2);
	   String newgeneratedpin=FindElement("id", "generatedPin").getText();
	   if(newgeneratedpin.equalsIgnoreCase(afterEnablePin)) 
	   {
		   Assert.fail("pin is not genereated");
	   }
	   if(Action.contains("Cancel"))
	   {
		   cancelAction();
		   waitForSeconds(1);
		   Assert.assertTrue(isElementPresentByXpath("//span[contains(text(),'Disabled')]"));
	   }
	   else 
	   {
		   delete_Or_Add_Action();
		   waitForSeconds(4);
		   Assert.assertTrue(isElementPresentByXpath("//span[contains(text(),'Enabled')]"));
	   }  
	   }
   }
   
   public void  employee_EditEmployee_AddIncident(String Action)  
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(isElementPresent(addIncident)) {
	   FindElement("xpath", "//button[contains(text(),'Add Incident')]").click();
	   waitForSeconds(1);
	   Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']"));
	   Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Add Incident')]"), "Add Incident Heading is missing");
	   FindElement("id", "SiteID").click();
	   selectValueByIndex(FindElement("id", "SiteID"), 2);
	   FindElement("id", "IncidentID").click();
	   selectValueByIndex(FindElement("id", "IncidentID"), 2);
	   FindElement("id", "Notes").sendKeys("Fire Accident");
	   if(Action.contains("Cancel"))
	   {
		  cancelAction();
	   }
	   else 
	   {
		   delete_Or_Add_Action();
		   waitForSeconds(4);
	   }    
	   }
   }
   
   public void  employee_EditEmployee_RestrictAccess(String Action)  
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(isElementPresent(restrictAccess)) {
	   FindElement("xpath", "//button[contains(text(),'Restrict Access')]").click();
	   waitForSeconds(2);
	   Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']"));
	   Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Restrict Access')]"), "Restrict Access Heading is missing");
	   FindElement("id", "Notes").sendKeys("Attendence issue");
	   if(Action.contains("Cancel"))
	   {
		  cancelAction();
	   }
	   else 
	   {
		   delete_Or_Add_Action();
		   waitForSeconds(4);
	   }   
	   }
	   
   }
   
   
   public void  employee_EditEmployee_FixAccessIssues(String Action)  
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(isElementPresent(fixAccessIssue)) {
	   FindElement("xpath", "//button[contains(text(),'Fix Access Issues')]").click();
	   waitForSeconds(1);
	   Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']"));
	   Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Fix Access Issues')]"), "Fix Access Issues Heading is missing");
	   Assert.assertTrue(isElementPresentByXpath("//span[@class='access-restriction-description']"), "Access restriction issue  is missing");
	   FindElement("xpath", "//input[@id='ActiveBans_0__Selected']").click();
	   if(Action.contains("Cancel"))
	   {
		   cancelAction();
	   }
	   else 
	   {
		   delete_Or_Add_Action();
		   waitForSeconds(4);
		   FindElement("xpath", "//button[contains(text(),'Fix Access Issues')]").click();
		   waitForSeconds(1);
		   Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'No Active Restrictions Found.')]"), "No Active Restrictions Found. is missing");
		   FindElement("xpath", "//button[@class='btn btn-primary']").click();
		   waitForSeconds(1); 
	   }  
	   }
	   
   }
   
   public void employee_OpenInviteEmployee_And_VerifyAllElement()  
   {
	   openInviteEmployee();
	   verifyAllElementIn_InviteEmployee();
   }
   
    public void openInviteEmployee()  
    {
    	FindElement("xpath", "//a[contains(text(),'Invite Employees')]").click();
    	waitForSeconds(2);
    	Assert.assertEquals(driver.getTitle(), "MSite - Invite Employees");
    } 
   
   public void verifyAllElementIn_InviteEmployee() 
   {
	   Assert.assertTrue(isElementPresentByXpath("//a[contains(text(),'New Employees')]"), "New Employee child is missing in Invite Employee");
	   Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]"), "Invite Employee heading is missing");
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default']"), "Search panel is missing");
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='panel-heading']"), "Search heading is missing");
	   String labels[]=new String[]{"First Name","Last Name","Contractor"};
	   for(String label:labels) 
	   {
	     Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'"+label+"')]"), ""+label+" is missing");   
	   }
	   String TextBoxes[]=new String[]{"FilterFirstName","FilterLastName"};
	   for(String id:TextBoxes) 
	   {
	     Assert.assertTrue(isElementPresentById(""+id+""), ""+id+" is missing");   
	   }
	   Assert.assertTrue(isElementPresentByXpath("//span[@class='select2 select2-container select2-container--bootstrap']"), "contractor selecr box ix missing");
	   Assert.assertTrue(isElementPresentByXpath("//a[@class='btn btn-default inline resetform']"), "Reload button is missing");  
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary inline listSearch']"), "Search button is missing is missing");     
   }
   
    public void inviteEmployee_Search(String firstName,String lastName,String contractorName)  
    {
    	FindElement("id", "FilterFirstName").sendKeys(firstName);
        FindElement("id", "FilterLastName").sendKeys(lastName);
        if (contractorName != null && contractorName !="")
        {
       	   selectContracotr(contractorName);
        }
        FindElement("xpath", "//button[@class='btn btn-primary inline listSearch']").click();
        waitForSeconds(3);
    }
   public void confirmInviteSearchResult(String firstName,String lastName,String contractorName)  
   {
	   if (contractorName.contains(null) && contractorName.contains(""))
       {
      	 String actualcolor=FindElement("xpath", "//span[@class='select2 select2-container select2-container--bootstrap']").getCssValue("color");
      	 Assert.assertEquals(actualcolor, "rgba(85, 85, 85, 1)");
       }
	   else 
	   {
		   for (WebElement row : driver.findElements(By.xpath("//tr[@class='rowlink']")))
	         {
	             String actualValue = row.findElement(By.xpath("./td[5]/a")).getText();
	             Assert.assertEquals(actualValue, "Invite"); 
	         }
	   }
   }
    
   public void inviteEmployee_Reload_And_VerifyReloadResult()  
   {
	   String FirstName =FindElement("id", "FilterFirstName").getAttribute("value");
	   String LastName =FindElement("id", "FilterLastName").getAttribute("value");
	   String ContractorName =FindElement("id", "select2-ContractorId-container").getText();
	   FindElement("xpath", "//a[@class='btn btn-default inline resetform']").click();
       waitForSeconds(3); 
       Assert.assertFalse(FirstName.equalsIgnoreCase(""), "FirstName is not empty");
       Assert.assertFalse(LastName.equalsIgnoreCase(""), "");
       Assert.assertFalse(ContractorName.equalsIgnoreCase("Please Select"), "Please Select");
   }
   
   public void open_InviteEmployee_And_Invite(String Action,String site)  
   {
	   inviteEmployee_Search("Deepak","Test","Deepak_Automation_Contractor");
	   FindElement("xpath", "//tr[@class='rowlink']/td[5]/a").click();
	   waitForSeconds(3);
	   inviteEmployee(Action,site);    
   }
   
   public void inviteEmployee(String Action,String site) 
   {
	   if(isElementPresent(inviteContactDetailsRequired))
	   {
		   FindElement("xpath", "//input[@id='Model_EmailAddress']").sendKeys("deepak@meemmemory.com");
		   FindElement("xpath", "//button[@class='btn btn-primary']").click();
		   waitForSeconds(2);
	   }
	    isElementPresentById("messagedialog-dialog");
	    String trade=FindElement("id", "select2-TradeID-container").getText();
	    if(trade.equalsIgnoreCase("Please Select")) 
	    {
	    	 FindElement("id", "select2-TradeID-container").click();
			 waitForSeconds(1);
			 if(isElementPresent(position)) 
		    	{
				  FindElement("xpath", "//li[contains(text(),'Junior Software Developer')]").click();
			      waitForSeconds(0.5);
		    	}
			 else
		    	{
				  String tradeText=FindElement("xpath", "//ul[@id='select2-TradeID-results']/li[1]").getText();
	    	      FindElement("xpath", "//li[contains(text(),'"+tradeText+"')]").click();
		          waitForSeconds(0.5);
		     }
	    }
	    String placeOfWork=FindElement("id", "select2-SiteID-container").getText();
	    if(placeOfWork.equalsIgnoreCase("Please Select")) 
	    {
	    	 FindElement("id", "select2-SiteID-container").click();
			 waitForSeconds(1);
			 selectValueByIndex(FindElement("id", "SiteID"), 0);
	    	 FindElement("xpath", "//li[contains(text(),'"+site+"')]").click();
		     waitForSeconds(1);
	    }
	         WebElement bookingInductionCheckbox = FindElement("id", "BookAWelcomeMeeting");
	         if(!bookingInductionCheckbox.isSelected()) 
	         {
	        	 bookingInductionCheckbox.click();
	        	 waitForSeconds(1);
	         }
	           FindElement("xpath", "//div[@class='TimeSlotDropDownReplacement']").click();
	           waitForSeconds(2);
	           FindElement("xpath", "//div[@class='TimeSlot-Avail']").click();
	           FindElement("xpath", "//div[contains(@class,'TimeSlot-TimeAvail')]").click();
	       if(Action.contains("Cancel"))
		   {
               cancelAction();
			   waitForSeconds(2);

		   }
		   else 
		   {
			   WebElement invitebutton=FindElement("xpath", "//button[@class='btn btn-primary']");
			   scrollToElement(invitebutton);
			   waitForSeconds(1);
			   invitebutton.click();
			   waitForSeconds(10);   
		   }   
	   
   }
   
   public void editEmployee_AccessRestrictionHistory() 
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(isElementPresent(accessRestrictionHistory)) {
	   FindElement("xpath", "//a[contains(text(),'Access Restriction History')]").click();
	   waitForSeconds(7);
	   Assert.assertEquals(driver.getTitle(), "MSite - Access Restriction History");
	   }
   }
   
   public void inviteNewEmployee() 
   {
	   openInviteEmployee();
	   FindElement("xpath", "//a[contains(text(),'New Employees')]").click();
	   waitForSeconds(2);  
	   if(driver.getTitle().equalsIgnoreCase("MSite - Add & Invite New Employees"))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
	      Assert.assertEquals(driver.getTitle(), "MSite - Invite Employee");
	   }
   }
   
   public void verifyAllElementIn_InviteNewEmployee() 
   {
	  Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]"), "Add and Invite heading is missing");
	  String labels[]=new String[] {"Contractor","First Name","Last Name","Email Address","Mobile Number"};
	 for(String label:labels) 
	 {
		 Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'"+label+"')]"), ""+label+" heading is missing");
	 }  
	  Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'Individual')]"), "Individual heading is missing");
	  Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'Bulk')]"), "Individual heading is missing");
	  Assert.assertTrue(isElementPresentByXpath("//a[@id='individualInviteSend']"), "Send button is missing");
   }
   
   public void employee_OpenInviteNewEmployee_And_VerifyAllElement()  
   {
	   inviteNewEmployee();
	   verifyAllElementIn_InviteNewEmployee();
   }
   
   public void inviteNewEmployee_IndividualColapses()
   {
		try 
		{
		     Assert.assertTrue(isElementPresentByXpath("//*[@id='individualHeading']"), "Unable to find Individaul heading.");
		     FindElement("xpath", "//a[@href='#individualBody']/strong").click();
		     Assert.assertTrue(isElementPresentByXpath("//a[@href='#individualBody' and @aria-expanded='false']"), "The individual was not colapsed.");
             waitForSeconds(1);
             FindElement("xpath", "//a[@href='#individualBody']").click();
             Assert.assertTrue(isElementPresentByXpath("//a[@href='#individualBody' and @aria-expanded='true']"), "The individual was not colapsed."); 
		}
		catch(Exception e)
		{
			e.getCause();
		}
   }
   
   public void inviteNewEmployee_BulkColapses()
   {
		try {
		    Assert.assertTrue(isElementPresentByXpath("//*[@id='individualHeading']"), "Unable to find Individaul heading.");
		    Assert.assertTrue(isElementPresentByXpath("//a[@href='#bulkBody' and @aria-expanded='false']"), "The bulk was not colapsed.");
            FindElement("xpath", "//a[@href='#bulkBody']").click();
            Assert.assertTrue(isElementPresentByXpath("//a[@href='#individualBody' and @aria-expanded='true']"), "The bulk was not colapsed."); 
		}
		catch(Exception e)
		{
			e.getCause();
		}
   }
   
   public void inviteNewEmployee_Individual(String contractorName,String Role,String Action,String site)  
   {
	     inviteNewEmployee();
	     selectContracotr(contractorName);
    	 waitForSeconds(0.5);
     	 waitForSeconds(0.5);
     	 FindElement("xpath", "//input[@id='Model_FirstName']").sendKeys("Deepak");
     	 FindElement("xpath", "//input[@id='Model_LastName']").sendKeys("Malviya");
     	 FindElement("xpath", "//input[@id='Model_EmailAddress']").sendKeys("deepak@meemmemory.com");
     	 FindElement("id", "individualInviteSend").click();
     	 waitForSeconds(8);
         selectRole(Role);
   	     waitForSeconds(0.5);
   	     inviteEmployee(Action,site);  	
   }
   
   public void inviteNewEmployee_IndividualWithoutFillingAnyDetails(String contractorName) 
   {
	   inviteNewEmployee();
       selectContracotr(contractorName);
   	   waitForSeconds(0.5);
       FindElement("id", "individualInviteSend").click();
       waitForSeconds(0.5);
       Assert.assertTrue(isElementPresentByXpath("//input[@class='form-control email-field input-validation-error was-invalid']"), "Email Address Field is not highlighted in red color");  	   
   }
   
   public void inviteNewEmployee_BulkWithoutFillingAnyDetails(String contractorName) 
   {
	   inviteNewEmployee();
	   selectContracotr(contractorName);
   	   waitForSeconds(0.5);
       FindElement("xpath", "//a[@href='#bulkBody']").click();
       waitForSeconds(0.5);
       FindElement("id", "bulkInviteSend").click();
       waitForSeconds(0.5);
       Assert.assertTrue(isElementPresentByXpath("//textarea[@class='form-control email-field input-validation-error was-invalid']"), "Email Address Field is not highlighted in red color");  	   
   }
   
   public void inviteNewEmployee_InBulk(String contractorName,String Role,String Action,String site)  
   {
	     inviteNewEmployee();
	     selectContracotr(contractorName);
     	 waitForSeconds(0.5);
     	 FindElement("xpath", "//a[@href='#bulkBody']").click();
     	 waitForSeconds(1);
     	 WebElement bulkEmailTextArea=FindElement("xpath", "//textarea[@id='Model_BulkEmailAddresses']");
     	 bulkEmailTextArea.sendKeys("deepak@meemmemory.com");
     	 bulkEmailTextArea.sendKeys(Keys.ENTER);
     	 bulkEmailTextArea.sendKeys("deepak+1@meemmemory.com");
    	 bulkEmailTextArea.sendKeys(Keys.ENTER);
    	 bulkEmailTextArea.sendKeys("deepak+2@meemmemory.com");
     	 FindElement("id", "bulkInviteSend").click();
     	 waitForSeconds(4);
     	 selectRole(Role);
   	     waitForSeconds(0.5);
   	     inviteEmployee(Action,site);  	
   }
   
   
   public void openViewProgress_And_VerifyAllElementsInViewProgress()  
   {
	   openViewProgress();
	   verifyAllElementInViewProgress();
   }
   
   public void viewProgressRefreshPage(String firstName,String lastName,String contractorName)  
   {
	   FindElement("id", "FilterFirstName").sendKeys(firstName);
       FindElement("id", "FilterLastName").sendKeys(lastName);
       selectContracotr(contractorName); 
   }
   
   public void viewProgress_Search(String firstName,String lastName,String contractorName,String search)  
   {
	   FindElement("id", "FilterFirstName").sendKeys(firstName);
       FindElement("id", "FilterLastName").sendKeys(lastName);
       if (contractorName != null && contractorName !="")
       {
    	   selectContracotr(contractorName);
       }
       FindElement("xpath", "//button[@class='btn btn-primary inline listSearch']").click();
       waitForSeconds(3);
       if(search.equalsIgnoreCase("empty")) 
       {
	   Assert.assertTrue(isElementPresentByXpath("//select[@class='form-control select2-remote select2-single select2-hidden-accessible input-validation-error was-invalid']"), "Contractor Field is not highlighted in Red Color");
       }
       else 
	   {
	      Assert.assertTrue(isElementPresentByXpath("//div[@class='employeelist']//td"), "No invitation");
	   }
    
   }
   
   public void verifyHeadingsInViewProgressSearchResult()
   {
	   String headings[]=new String[] {"Name","Site","Prerequisite Training","Profile Status","Training Status","Site Orientation Induction","Actions"};
	   for(String heading:headings) 
	   { 
		   Assert.assertTrue(isElementPresentByXpath("//th[contains(text(),'"+heading+"')]"), ""+heading+" is missing");
	   }
	   if(isElementPresent(dataprotectionHeading)) 
	   {
		   Assert.assertTrue(true, "Data Protection is missing");
	   }
	   
   } 
   
   public void viewInductionBooking_InViewProgressSearchResult()  
   {
     WebElement viewInductionBooking=FindElement("xpath", "//td[@class='view-progress-actions']/span[@data-title='View Induction Booking']");
     scrollToElement(viewInductionBooking);
     viewInductionBooking.click();
     waitForSeconds(3);
     Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "View Induction Booking popup is misssing");
     Assert.assertEquals(FindElement("xpath", "//h3[@class='modal-title']").getText(), "View Induction Booking");
     Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Booking Details')]"), "Booking Detail Heading is missing");
     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Ok button is missing");
     FindElement("xpath", "//button[@class='btn btn-primary']").click();
     waitForSeconds(1);
     
   }
   
   public void open_InductionBooking_InViewProgressSearchResult(String Action) 
   {
	   String profileStatusBeforeCancelInduction=FindElement("xpath", "//td[@class='hidden-xs']//div[@class='induction_pill state-noprogress'][contains(text(),'Not Started')]").getText();
	   String siteorientaionBeforeCancel=FindElement("xpath", "//td[@class='hidden-xs']//div[@class='induction_pill state-earlyprogress']").getText();
	   FindElement("xpath", "//td[@class='view-progress-actions']/span[@title='Cancel Induction Booking']").click();
	   waitForSeconds(2);
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Cancel Induction Booking popup is misssing");
	   Assert.assertEquals(FindElement("xpath", "//h3[@class='modal-title']").getText(), "Cancel Induction Booking");
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-body']"), "Confirmation message is missing");
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "No Keep Booking button is missing");
	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Yes Cnacel booking button is missing");
	   if(Action.contains("Cancel"))
	   {
	       cancelAction();
		   waitForSeconds(2);
	   }
	   else 
	   {
		   WebElement invitebutton=FindElement("xpath", "//button[@class='btn btn-primary']");
		   invitebutton.click();
		   waitForSeconds(6); 
		   FindElement("xpath", "//button[@class='btn btn-primary']").click();
		   waitForSeconds(4); 
		   viewProgress_Search("", "", "Deepak_Automation_Contractor", "");
		   waitForSeconds(1);
		   String profileStatusAfterCancelInduction=FindElement("xpath", "//td[@class='hidden-xs']//div[@class='induction_pill state-cancelled'][contains(text(),'Cancelled')]").getText();
		   String siteorientaionAfterCancel=FindElement("xpath", "//td[@class='hidden-xs']//div[@class='induction_pill state-cancelled']").getText();
		   if(profileStatusAfterCancelInduction.equalsIgnoreCase(profileStatusBeforeCancelInduction)) 
		   {
			   Assert.fail("Profile Status is not cancelled");
		   }
		    if(siteorientaionAfterCancel.equalsIgnoreCase(siteorientaionBeforeCancel)) 
		   {
			   Assert.fail("Site Induction is not cancelled");
		   }
		   
	   }   
	   
   } 
   
   public void openViewProgress()  
   {
	   FindElement("xpath", "//a[contains(text(),'View Progress')]").click();
	   waitForSeconds(2);
	   Assert.assertEquals(driver.getTitle(), "MSite - View Progress"); 
   }
   
   public void verifyAllElementInViewProgress() 
   {
	  Assert.assertEquals(FindElement("xpath", "//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]").getText().trim(), "View Progress");
	  Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default']"), "Search box Panel is missing");
	  String labels[]=new String[] {"Contractor","First Name","Last Name","Invite Date From","Invite Date To"};
		 for(String label:labels) 
		 {
			 Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'"+label+"')]"), ""+label+" heading is missing");
		 }  
		Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default inline resetform']"), "Reload button is missing");
		Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary inline listSearch']"), "Search button is missing"); 
   }
     
   public void viewProgress_Reload(String firstName,String lastName,String contractorName) 
   {
	   FindElement("id", "FilterFirstName").sendKeys(firstName);
       FindElement("id", "FilterLastName").sendKeys(lastName);
       if (contractorName != null && contractorName !="")
       {
    	   selectContracotr(contractorName);
       }
       FindElement("xpath", "//button[@class='btn btn-default inline resetform']").click();
       waitForSeconds(2);
       Assert.assertEquals(FindElement("id", "FilterFirstName").getAttribute("value"), "");
       Assert.assertEquals(FindElement("id", "FilterLastName").getAttribute("value"), "");
       Assert.assertEquals(FindElement("id", "FilterDateInvitedFrom").getAttribute("value"), "");
       Assert.assertEquals(FindElement("id", "FilterDateInvitedTo").getAttribute("value"), "");
       if(contractorName.equalsIgnoreCase(""))
             Assert.assertEquals(FindElement("id", "select2-ContractorId-container").getText(), "Please Select");
       else
    	   Assert.assertEquals(FindElement("id", "select2-ContractorId-container").getText(), contractorName);
   }
   
   public void viewProgress_ChangeInviteDate()
   {
	   WebElement inviteDateFrom = FindElement("id", "FilterDateInvitedFrom");
	   inviteDateFrom.clear();
	   inviteDateFrom.sendKeys("20/06/2019");
	   WebElement inviteDateTo = FindElement("id", "FilterDateInvitedTo");
	   inviteDateTo.clear();
	   inviteDateTo.sendKeys("31/08/2019");
   }   
   
   public void viewProgress_CheckDataProtectionHeadingVisibility(String contractorName,String visible)  
   {
	  boolean visibility=change_PropertyVisibility_FromSystemSetting("PreInductionDataProtection",visible);
	  openEmployees();
	  openViewProgress();
	  viewProgress_Search("", "", contractorName, "");
	  if(visibility) 
	  {
		 Assert.assertTrue(isElementPresent(dataprotectionHeading), "Data Protection Heading is missing");
	  }
	  else 
	  {
		  Assert.assertFalse(isElementPresent(dataprotectionHeading), "Data Protection Heading is present");
	  }
   }
   
   public void employee_CheckBiometricConsentStatusInEmployee(String visible)  
   {
	  boolean visibility=change_PropertyVisibility_FromSystemSetting("BiometricConsent",visible);
	  openEmployees();
	  employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	  if(visibility) 
	  {
		 Assert.assertTrue(isElementPresent(biometricconsent), "Bio Metric  Heading is missing");
	  }
	  else 
	  {
		  Assert.assertFalse(isElementPresent(biometricconsent), "Bio Metric Heading is present");
	  }
   }
   
   
   public void employee_AddPhoto(String Action,String type)  
   {
	      openEmployees();
		  employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
		  if(type.equalsIgnoreCase("Camera")) {
		  FindElement("xpath", "//div[@class='col-md-push-3 hidden-xs hidden-sm']//button[contains(@class,'messagedialog btn btn-default center-block btn-xs employeeicon capture')]").click();
		  waitForSeconds(2);
		  Robot robot;
		try {
			  robot = new Robot();
			  robot.delay(2000);
		      robot.keyPress(KeyEvent.VK_TAB);	
		      robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		  
		  waitForSeconds(2);
		  FindElement("xpath", "//button[contains(text(),'Capture')]").click();
		  waitForSeconds(1);
		 if(Action.equalsIgnoreCase("Done"))
		 {
		 FindElement("xpath", "//button[contains(text(),'Done')]").click();
		 waitForSeconds(7);
		 }else
		 {
		      FindElement("xpath", "//button[contains(text(),'Retake')]").click();
		     waitForSeconds(1);
		     FindElement("xpath", "//button[contains(text(),'Capture')]").click();
			 waitForSeconds(1);
			 FindElement("xpath", "//button[contains(text(),'Done')]").click();
			 waitForSeconds(5);
		 }
		  }
		  else 
		  {
			  FindElement("xpath", "//div[@class='col-md-push-3 hidden-xs hidden-sm']//button[contains(@class,'btn btn-default center-block btn-xs fileupload employeeicon upload')]").click();
		      waitForSeconds(1);
		      uploadDoc("C:\\Users\\ADMIN\\Pictures\\Camera Roll\\WIN_20190828_18_18_40_Pro");
		  }
		  FindElement("xpath", "//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']").click();
		  waitForSeconds(5);	  	 
   }
   
   public void employee_ViewContractorHistory(String visible) 
   {
	   boolean visibility=change_PropertyVisibility_FromSystemSetting("Lock Contractor",visible);
	   openEmployees();
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(visibility) 
		  {
		     FindElement("xpath", "//a[@class='messagedialog']").click();
		     waitForSeconds(1);
			 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-content']"), "Employee Contractor History Dialog is missing");
			 Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Employee Contractor History')]"), "Employee Contractor History Heading is missing");
			 List<WebElement> contractorhistroryList=driver.findElements(By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-body']//div[@class='col-md-12']"));
			 Assert.assertEquals(contractorhistroryList.size(), 1, "Either records are more than one or zero"); 
			 FindElement("xpath", "//div[@class='modal-dialog modal-lg']//button[@class='close'][contains(text(),'×')]").click();
			 waitForSeconds(1);
		  }
		  else 
		  {
			  selectContracotr("Jayesh");
	          waitForSeconds(1);
	          FindElement("xpath", "//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']").click();
	          waitForSeconds(5);
	          FindElement("xpath", "//a[@class='messagedialog']").click();
	          waitForSeconds(2);
	          List<WebElement> contractorhistroryList=driver.findElements(By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-body']//div[@class='col-md-12']"));
			  Assert.assertTrue(contractorhistroryList.size()>1, "Either record is one or zero"); 
			  FindElement("xpath", "//div[@class='modal-dialog modal-lg']//button[@class='close'][contains(text(),'×')]").click();
			  waitForSeconds(1);
			  selectContracotr("Deepak_Automation_Contractor");
	          waitForSeconds(1);
	          FindElement("xpath", "//button[@class='btn btn-primary inline messagedialog employee-save-changes save-btn']").click();
	          waitForSeconds(5);
	          change_PropertyVisibility_FromSystemSetting("Lock Contractor","Enabled");
		  }
	   
   }
   
  public void employee_CheckMedicalConditionSectionVisibilityInEmployee(String visible)  
  {
	  boolean visibility=change_PropertyVisibility_FromSystemSetting("MedicalCondition",visible);
	   openEmployees();
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   if(visibility) 
	   {
		 Assert.assertTrue(isElementPresent(medicalConditionSection),"Medical Section is missing");
		 Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default medicalConditionPanel panel-employee']//div[@class='complexlist-empty'][contains(text(),'None Provided')]").getText(), "None Provided", "None Provided is missing");
		 addMedicalCondition("Asthma");
	   }
	   else 
	   {
		   Assert.assertFalse(isElementPresent(medicalConditionSection),"Medical Section is missing");
	   }
  }
   
  public void edit_MedicalSection(String Action)  
  {
	   openEmployees();
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   FindElement("xpath", "//button[@data-title='Medical Conditions' and contains(text(), '"+Action+"')]").click();
	   waitForSeconds(1);
	   if(Action.equalsIgnoreCase("Edit")) 
	   {
	      selectValueByVisibleText(FindElement("id", "dialog-MedicalConditions_0__MedicalConditionID") ,"Blackouts");
	      FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
	      waitForSeconds(1);
	       Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default medicalConditionPanel panel-employee']//div[@class='complexlist-summary pull-left'][contains(text(),'Blackouts')]").getText(), "Blackouts", "Blackouts is missing");
	   }
	   else 
	   {
		  Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//div[@class='modal-content']"),"Delete Dialog is missing");
		  Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete this medical condition')]"), "Delete Confirmation Message is missing");
		  FindElement("xpath", "//button[@class='btn btn-primary']").click();
		  waitForSeconds(2);
		  Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default medicalConditionPanel panel-employee']//div[@class='complexlist-empty'][contains(text(),'None Provided')]").getText(), "None Provided", "None Provided is missing");
	   }
  }
  
  
  public void addMedicalCondition(String condition)  
  {
	     FindElement("xpath", "//button[@data-title='Medical Conditions' and contains(text(), 'Add...')]").click();
	 	 waitForSeconds(1);
	 	 Assert.assertTrue(isElementPresentByXpath("//div[@id='complexlist-dialog']//div[@class='modal-content']"), "Add Medical Condition Dialog is missing");
	 	 Assert.assertEquals(FindElement("xpath", "//h3[@class='modal-title']").getText(), "Medical Conditions");
	 	 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is missing");
	 	 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary btn-add']"), "Add Button is missing");
	 	 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-body']//label[contains(text(),'Condition')]"), "Condition Label is missing");
	 	 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-body']//label[contains(text(),'Notes')]"), "Notes Label is missing");
	 	 selectValueByVisibleText(FindElement("id", "MedicalConditions_INDEX__MedicalConditionID") ,condition);
	 	 FindElement("xpath", "//button[@class='btn btn-primary btn-add']").click();
	 	 waitForSeconds(2);  
	 	 savebutton.click();
	 	 waitForSeconds(7);
	 	 Assert.assertEquals(FindElement("xpath", "//div[@class='panel panel-default medicalConditionPanel panel-employee']//div[@class='complexlist-summary pull-left'][contains(text(),'"+condition+"')]").getText(), condition, "condition is missing");
  }
  
   public void viewProgress_CheckPrerequisiteTrainingColumnData(String Action,String contractorName) 
   {
	   FindElement("xpath", "//ul[@class='nav navbar-nav']//a[contains(@class,'dropdown-toggle')]").click();
	   waitForSeconds(1);
	   FindElement("xpath", "//a[contains(text(),'Online')]").click();
	   waitForSeconds(1);
	   FindElement("xpath", "//a[contains(text(),'Browse Courses')]").click();
	   waitForSeconds(1);
	   FindElement("xpath", "//span[contains(text(),'Data Protection and you')]").click();
	   waitForSeconds(1);
	   WebElement publishcheckbox=FindElement("id", "Model_IsPublished");
	   if(Action.equalsIgnoreCase("Publish")) 
	   {
		   if(!publishcheckbox.isSelected()) 
			   publishcheckbox.click();
		   
	   }
	   else 
	   {
		   if(publishcheckbox.isSelected()) 
			   publishcheckbox.click(); 
	   }
	   waitForSeconds(1);
	   FindElement("id", "saveButton").click();
	   waitForSeconds(4);
	   openViewProgress();
	   viewProgress_Search("", "", contractorName, "");
	   List<WebElement> prerequisitetraininglist=driver.findElements(By.xpath("//div[contains(@class,'employeelist')]//tbody//td[4]/div"));
	   for(WebElement ele:prerequisitetraininglist) 
	   {
		   if(Action.equalsIgnoreCase("Publish")) 
		   {
			  if(ele.getText()!="N/A") 
			  {
				 Assert.assertTrue(true); 
			  }
		   } else 
		        Assert.assertEquals(ele.getText(), "N/A");
	   }
	   
   }
   
   public void employee_AddManualPunchWithoutDoor() 
   {
	   employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
	   FindElement("xpath", "//button[contains(text(),'Add Manual Punch')]").click();
	   waitForSeconds(1);
	   FindElement("xpath", "//div[@id='messagedialog-dialog']//button[@class='btn btn-primary']").click();;
	   waitForSeconds(1);
	   Assert.assertTrue(isElementPresentByXpath("//select[@class='form-control input-validation-error was-invalid']"), "Door Field is not highlighted in red color");
	   FindElement("xpath", "//div[@id='messagedialog-dialog']//button[@class='btn btn-default']").click();
	   waitForSeconds(1);
   }
   
   public String getContractor(String contractorname) 
   {
	   try 
	   {
	     FindElement("xpath", "//a[contains(text(),'Contractors')]").click();
	     if(isAlertPresent()) 
			{
				isAlertAction("accept");
			}
	     waitForSeconds(1);
	     FindElement("xpath", "//input[contains(@placeholder,'Search Contractor...')]").sendKeys(contractorname);
	     waitForSeconds(3);
	     String check=FindElement("xpath","//table[@id='contractorsList']//tbody/tr/td").getText();
	     if(check.contains(contractorname))
	     {
	    	 Assert.assertTrue(true);
	     }
	     else {
	     FindElement("xpath", "//a[contains(text(),'Add New Contractor')]").click();
	     waitForSeconds(1); 
	     FindElement("xpath", "//input[@id='Model_Name']").sendKeys(contractorname);
	     FindElement("xpath", "//button[contains(text(),'Save')]").click();
	     waitForSeconds(5);
	     }
	   }
	   catch(Exception e) 
	   {
		   e.getCause();
	   }
	   return contractorname;
   }
   
   public String getRole() 
   {
	   String role="TestAnalyst";
	   try 
	   {
	     FindElement("xpath", "//a[contains(text(),'System')]").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//a[contains(text(),'Employee Roles')]").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//input[@placeholder='Search roles...']").sendKeys(role);
	     waitForSeconds(2);
	     if(!(isElementPresent(noEmployeePresent))) 
	     {
	    	 String check=FindElement("xpath","//td[contains(text(),'"+role+"')]").getText();
		     if(check.contains(role))
		     {
		    	 Assert.assertTrue(true);
		     } 
	     }
	     else { 	 
	     FindElement("xpath", "//button[@class='callbackdialog']").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//input[@id='Name']").click();
	     FindElement("xpath", "//input[@id='Name']").sendKeys(role);
	     FindElement("xpath", "//input[@id='IsActive']").click();
	     FindElement("xpath", "//input[@placeholder='Please Select']").click();
	     waitForSeconds(1);
    	 FindElement("xpath", "//strong[contains(text(),'Select All')]").click();
    	 waitForSeconds(0.5);
	     FindElement("xpath", "//button[contains(@class,'btn btn-primary')]").click();
	     waitForSeconds(5);
		}
	     
	   }
	   catch(Exception e) 
	   {
		   e.getCause();
	   }
	   return role;
   }
   
   public String getSite() 
   {
	   String site="Deepak_Test";
	   try 
	   {
	     FindElement("xpath", "//a[contains(text(),'System')]").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//a[contains(text(),'Site Configuration')]").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//span[@class='select2-selection__placeholder']").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//input[@class='select2-search__field']").sendKeys(site);
	     waitForSeconds(2);
	     if(!(isElementPresent(noSitePresent))) 
	     {
		    	 Assert.assertTrue(true);   
	     }
	     else { 	 
	     FindElement("xpath", "//button[contains(text(),'Add New Site')]").click();
	     waitForSeconds(2);
	     FindElement("xpath", "//input[@id='SiteContactInformationViewModel_SiteName']").sendKeys(site);
	     FindElement("id", "SiteContactInformationViewModel_EnrolmentType").click();
	     waitForSeconds(1);
	     selectValue(FindElement("id", "SiteContactInformationViewModel_EnrolmentType"), "Fingerprint");
	     waitForSeconds(1);
	     FindElement("xpath", "//input[@id='SiteContactInformationViewModel_PostCode']").sendKeys("l23 6bh");
	     FindElement("id", "SiteContactInformationViewModel_ExternalID").sendKeys("1234");
	     FindElement("xpath", "//button[contains(@class,'btn btn-primary')]").click();
	     waitForSeconds(5);
	     FindElement("xpath", "//ul[@class='nav nav-link']//a[contains(text(),'Induction Bookings')]").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//button[@class='messagedialog']").click();
	     waitForSeconds(1);
	     FindElement("xpath", "//select[@id='SiteID']").click();
	     waitForSeconds(0.5);
	     FindElement("xpath", "//option[contains(text(),'Deepak_Test')]").click();
	     WebElement time=  FindElement("xpath", "//input[@id='Time_Value']");
	     time.clear();
	     time.sendKeys("09:00");
	     time.sendKeys(Keys.ENTER);
	      waitForSeconds(0.5);
	      FindElement("id", "MaxCapacity").sendKeys("10");
	      FindElement("xpath", "//span[@class='select2 select2-container select2-container--bootstrap']").click();
	      waitForSeconds(0.5);
	      String days[]=new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday"};
	      for(String str :days) 
	    {
	    	FindElement("xpath", "//option[contains(text(),'"+str+"')]").click();
	    }
	       waitForSeconds(0.5);
	       FindElement("xpath", "//button[@class='btn btn-primary']").click();
	        waitForSeconds(2);
		}
	     
	   }
	   catch(Exception e) 
	   {
		   e.getCause();
	   }
	   return site;
   }
     
}
