package com.Msite.Pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Msite.TestScripts.BaseClass;

public class ContractorsPage extends BaseClass
{
	
	public ContractorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Contractors')]")
	WebElement contractors;

	@FindBy(xpath="//a[contains(text(),'System')]")
	WebElement system;

	@FindBy(xpath="//div[@class='container no-padding']//span[contains(text(),'hrs')]")
	WebElement username;

	@FindBy(xpath="//input[contains(@placeholder,'Search Contractor...')]")
	WebElement searchbox;

	@FindBy(xpath="//a[@href=\"/System/Contractors\"]")
	WebElement contractor;

	@FindBy(xpath="//div[contains(text(),'AAAA')]")
	WebElement contractorname;

	@FindBy(xpath="//div[contains(@class,'pagepanel-sidebar')]/ul")
	WebElement systemfunctionallist;

	@FindBy(xpath="//table[@id='contractorsList']//tbody/tr")
	WebElement confirmEmployeeSearchResult;

	@FindBy(xpath="//th[contains(text(),'Contractor')]")
	WebElement contractorheadinlist;

	@FindBy(xpath="//th[contains(text(),'Admin Email')]")
	WebElement adminemailheadinlist;
	
	@FindBy(xpath="//a[contains(text(),'Add New Contractor')]")
	WebElement addNewContractor;

	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement addNewContractorSaveButton;
	
	@FindBy(xpath="//button[contains(text(),'Reload')]")
	WebElement addNewContractorReloadButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement saveBoxOkButton;
	
	@FindBy(xpath="//input[@id='Model_Name']")
	WebElement addNewContractorName;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement reloadBoxCancelButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement reloadBoxReloadButton;
	
	@FindBy(xpath="//button[contains(text(),'×')]")
	WebElement reloadBoxXButton;
	
	@FindBy(xpath="//button[@class='btn btn-danger messagedialog pull-left']")
	WebElement deleteButtonInContractor;
	
	@FindBy(id="btn-allowCookies")
	WebElement allowCookies;
	
	
	String firstName = getAlphaNumericString(4, "character");;
	String lastName = getAlphaNumericString(6, "character");;
	String emailaddress="deepak+2@meemmemory.com";
	String expectedcolor="rgba(85, 85, 85, 1)";
	
	public void openContractors() 
	{
		try {
			if(contractors.isDisplayed())
			{
				contractors.click();
				waitForSeconds(1);
			}
			else
			{
				system.click();
				waitForSeconds(1);
				contractors.click(); 
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

	public void clickOnAllowCookies() 
	{
		waitForSeconds(1);
		allowCookies.click();
		waitForSeconds(3);
	}

	public void verifyContractorsTitle() 
	{
		Assert.assertEquals(driver.getTitle(), "MSite - Contractors");
	}

	public void reviewContractorsAndVerifyAllElement() 
	{
		Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]"), "Contractors Heading in Table is missing");
		Assert.assertTrue(isElementPresentByXpath("//div[@class='container no-padding']//span[contains(text(),'hrs')]"), "username is missing");
		Assert.assertTrue(isElementPresentByXpath("//img[@src='/BrandingLogo']"), "Human Recognisation System logo is missing");
		Assert.assertTrue(isElementPresentByXpath("//ol[contains(@class,'breadcrumb')]"), "System contractor heading in Table is missing");
		Assert.assertTrue(isElementPresentByXpath("//input[contains(@placeholder,'Search Contractor...')]"), "Contractors Seacrh box is missing");
		Assert.assertTrue(isElementPresentByXpath("//table[@id='contractorsList']//th[contains(text(),'Contractor')]"), "Contractors  header not present in table.");
		Assert.assertTrue(isElementPresentByXpath("//table[@id='contractorsList']//th[contains(text(), 'Admin Email')]"), "Admin Email header not present in table.");
		Assert.assertTrue(isElementPresentByXpath("//table[@id='contractorsList']//th[contains(text(), 'Users')]"), "Users header not present in table.");
		Assert.assertTrue(isElementPresentByXpath("//table[@id='contractorsList']//th[contains(text(), 'Employees')]"), "Employees header not present in table.");
		if((username.getText()).contains("hrs"))
		{
			List<WebElement> functionallist = systemfunctionallist.findElements(By.xpath("./li"));
			for(WebElement ele:functionallist) 
			{
				String functionheading=ele.getText().replace("\n", "");
				Assert.assertTrue(isElementPresent(ele), ""+functionheading+" is missing in the System list");
			}

		}

	}

	public void contractorSearch_NoContractors()  
	{
		String searchname=getAlphaNumericString(5, "character");
		String searchnumber="123456";
		String searchalphanumeric="xrdh@34#1234";
		searchbox.sendKeys(searchname);//send any  contractor name  which is not present in contractor list
        waitForSeconds(2);
		Assert.assertTrue(isElementPresentByXpath("//td[contains(text(),'0 Contractors Found')]"), "Text '0 Contractors Found' not present."); 
		searchbox.clear();
		searchbox.sendKeys(searchnumber);//send number in search box
		waitForSeconds(2);
		Assert.assertTrue(isElementPresentByXpath("//td[contains(text(),'0 Contractors Found')]"), "Text '0 Contractors Found' not present."); 
		searchbox.clear();
		searchbox.sendKeys(searchalphanumeric);//send number in search box
		waitForSeconds(2);
		Assert.assertTrue(isElementPresentByXpath("//td[contains(text(),'0 Contractors Found')]"), "Text '0 Contractors Found' not present."); 
	}

	public String getContractor() 
	{
		contractor.click();
		waitForSeconds(1);
		String contractorname=getAlphaNumericString(6, "character");
		add_AddNewConstructor_ByNameOnly(contractorname);
		return contractorname;
	}

	public void contractorSearch(String contractorname)  
	{
		searchbox.sendKeys(contractorname);
		waitForSeconds(2);
	}

	public void confirmSearchResult(String searchname) 
	{

		boolean foundMatch = false;
		List<WebElement> contractorlist =confirmEmployeeSearchResult.findElements(By.xpath("./td"));
		for ( WebElement result: contractorlist) { 

			if ( result.getText().contains(searchname)) 
			{
				foundMatch=true;
			}
		}
		Assert.assertTrue(foundMatch, "At least one value must contain the search text");
	}

	public void sort_ContractorList_ByContractor()  
	{
		int i=0;
		List<WebElement> contractorlist = driver.findElements(By.xpath("//table[@id='contractorsList']//tbody/tr/td[1]"));
		String beforesort[]=new String[contractorlist.size()];
		for(WebElement con:contractorlist)
		{
			beforesort[i]= con.getText();
			i++;
		}
		contractorheadinlist.click();
		waitForSeconds(1);
		contractorheadinlist.click();
		waitForSeconds(1);
	  }
	
	public void sort_ContractorList_ByAdminEmail() 
	{
		int i=0;
		List<WebElement> contractorlist = driver.findElements(By.xpath("//table[@id='contractorsList']//tbody/tr/td[2]"));
		String beforesort[]=new String[contractorlist.size()];
		for(WebElement con:contractorlist)
		{
			beforesort[i]= con.getText();
			i++;
		}
		adminemailheadinlist.click();
		waitForSeconds(1);
		adminemailheadinlist.click();
		waitForSeconds(1);
	    }

	public void open_And_Save_Add_New_Contractor_NoDataInFields() 
	{
		addNewContractor.click();
		waitForSeconds(1);
		addNewContractorSaveButton.click();
		waitForSeconds(1);
		Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Save Dialog box is  not open.");
		Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Save')]"), "Save button in Dialog box is  not present.");
		Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'The Contractor Name field is required.')]"), "Save Dialog box Message is  not present.");
		Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Save Dialog box Ok button is  not present.");
	    saveBoxOkButton.click();
	    waitForSeconds(1);
		Assert.assertFalse(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Save Dialog box is  still open.");
		waitForSeconds(1);
	}
	 
	public void open_And_Reload_Add_New_Contractor_WithDataInFields(String Action)
	{
		addNewContractor.click();
		waitForSeconds(1);
		addNewContractorName.sendKeys("Malviya");
		addNewContractorReloadButton.click();
		waitForSeconds(1);
		Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Reload Dialog box is  not present.");
		Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Reload')]"), "Reload button in Dialog box is  not present.");
		Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to reset the form?')]"), "Relaod Dialog box Message is  not present.");
		Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Reload Dialog box Reload button is  not present.");
		Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Reload Dialog box Cancel button is  not present.");
	    if(Action.equalsIgnoreCase("Cancel"))
	    {
	      reloadBoxCancelButton.click();
	    }
	    else
	    {
	          reloadBoxReloadButton.click();
	          waitForSeconds(1);
              Assert.assertEquals(addNewContractorName.getText(), "");
	    }
	}
	 
	public void open_And_Review_AddNewContractor()
	{
		try {
		      addNewContractor.click();
		      waitForSeconds(1);
		      Assert.assertEquals(driver.getTitle(), "MSite - Add New Contractor");
		      for (String headingText : new String[] { "Contractor Name", "Contractor Group", "Custom Field Group", "External ID", "Notes" })
	            {
		    	  Assert.assertTrue(isElementPresentByXpath("//form[@action='/System/Contractors/Save']//label[contains(text(), '"+headingText+"')]"), ""+headingText+" is  not present.");
	             
	            }
		   }
		catch(Exception e) 
		{
			e.getCause();
		}
		
	}
	public void  open_And_AddNewContractor_withValidData() 
	{
		String contractorname=getAlphaNumericString(5, "character");
		addNewContractor.click();
		waitForSeconds(1);
		addNewContractorName.sendKeys(contractorname);
		waitForSeconds(1);
		contractor_WorkforceResgistration();
		waitForSeconds(1);
        addNewContractorSaveButton.click();
        waitForSeconds(1);
        driver.navigate().refresh();
        waitForSeconds(1);
	}
	 
	public void verify_Newly_Added_Contractor() 
	{
		contractor.click();
		waitForSeconds(1);
		contractorSearch(emailaddress);
		waitForSeconds(1);
		List<WebElement> usernamelist=driver.findElements(By.xpath("//table[@id='contractorsList']//tbody/tr/td[2]"));
		for(WebElement email:usernamelist) 
		{
			if((email.getText()).equalsIgnoreCase(emailaddress))
			{
				Assert.assertTrue(true,""+email.getText()+" is not present in the list");
			}
		}
		
	}
	
	public  void delete_Newly_Added_Contractor(String Action) 
	{
		contractors.click();
		waitForSeconds(1);
		contractorSearch(emailaddress);
		waitForSeconds(1);
		List<WebElement> usernamelist=driver.findElements(By.xpath("//table[@id='contractorsList']//tbody/tr/td[2]"));
		for(WebElement email:usernamelist) 
		{
			if((email.getText()).equalsIgnoreCase(emailaddress))
			{
		      email.click();
		      waitForSeconds(2);
		      deleteButtonInContractor.click();
		      waitForSeconds(1);
		     Assert.assertTrue(isElementPresentByXpath("//div[@id='delete']//div[@class='modal-content']"), "Delete Dialog box is not open.");
		     Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Delete Contractor')]"), "Delete contractor heading  is  not present.");
		     Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete this contractor?')]"), "Delete confirm message is  not missing.");
		     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is  not present.");
		     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is  not present.");
		   if(Action.contains("Cancel"))
		   {
			   WebElement cancelbutton=FindElement("xpath", "//button[@class='btn btn-default']");
			   cancelbutton.click();
			   waitForSeconds(1);
		   }
		   else 
		   {
			   WebElement deleteindialogbutton=FindElement("xpath", "//button[@class='btn btn-primary']");
			   deleteindialogbutton.click();
			   waitForSeconds(0.5);
			   Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Contractor Deleted Successfully.')]"), "Delete successfully message is  not missing.");
			   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "OK button is  not present.");
			   saveBoxOkButton.click();
		   }
		     break;
			}
			
		}
		
	}
	
	public void add_AddNewConstructor_ByNameOnly(String contructorname)  
	{
		addNewContractor.click();
		waitForSeconds(1);
		addNewContractorName.sendKeys(contructorname);
		addNewContractorSaveButton.click();
		waitForSeconds(4);
	}
	
	public void  open_AnyConstructor_And_Edit_FromtheList(String contractorname,String Updatename) 
	{
		contractors.click();
		waitForSeconds(1);
		FindElement("xpath", "//input[@placeholder='Search Contractor...']").clear();
		FindElement("xpath", "//input[@placeholder='Search Contractor...']").sendKeys(contractorname);
		waitForSeconds(2);
		FindElement("xpath", "//table[@id='contractorsList']//tbody/tr/td").click();
		waitForSeconds(2);
		addNewContractorName.clear();
		addNewContractorName.sendKeys(Updatename);
		contractor_WorkforceResgistration();
		addNewContractorSaveButton.click();
		waitForSeconds(1);
	    driver.navigate().refresh();
	    waitForSeconds(2);
	}
	
	
	public void verify_And_Delete_EditedOrUpdated_Contractor(String Updatename) 
	{
		contractors.click();
		contractorSearch(Updatename);
		waitForSeconds(2);
		delete_ContractorByName(Updatename);
	}
	
	public  void delete_Newly_Added_ContractorByName(String contractorname)
	{
		delete_ContractorByName(contractorname);	
	}
	
	public void verify_DuplicateEmailOrNameErrorMessage_InContractor(String name) 
	{
		openContractors();
		addNewContractor.click();
		waitForSeconds(1);
		if(name.contains("@")) 
		{
			WebElement Workregistdropdown =FindElement("xpath", "//select[@id='Model_AdminUser_PreEnrolEnabled']");
			Workregistdropdown.click();
			selectValueByIndex(Workregistdropdown, 0);
			waitForSeconds(1);
			WebElement workregistrForSitedropdown=FindElement("xpath", "//input[1][contains(@placeholder,'Please Select')]");
			workregistrForSitedropdown.click();
	        WebElement ForSiteselection=FindElement("xpath", "//li[@class='select2-results__option select-all select']");
	        ForSiteselection.click();
	        waitForSeconds(1);
	        WebElement emailaddressbox=FindElement("xpath", "//input[@id='Model_AdminUser_EmailAddress']");
	        emailaddressbox.click();
	        emailaddressbox.sendKeys(emailaddress);
	    	String actaulcolor = emailaddressbox.getCssValue("color");
			Assert.assertEquals(actaulcolor,expectedcolor);
	        
		}
		else 
		{
		addNewContractorName.sendKeys(name);
		FindElement("xpath", "//input[@id='Model_ExternalId']").click();
		waitForSeconds(1);
		String actaulcolor =addNewContractorName.getAttribute("class");
		Assert.assertTrue(isElementPresent(FindElement("xpath", "//input[@class='"+actaulcolor+"']")), "Contractor Name Field is not highlighted in red color");
		}
	}
	
	public String getContractorEmail()
	{
		contractor.click();
		waitForSeconds(1);
		String contractorEmail="";
		List<WebElement> usernamelist=driver.findElements(By.xpath("//table[@id='contractorsList']//tbody/tr/td[2]"));
		for(WebElement email:usernamelist) 
		{
			if(email.getText().contains("@")) 
			{
				contractorEmail=email.getText();
			}
		     break;
		}
		return contractorEmail;
	}
	
	public void contractor_WorkforceResgistration() 
	{
		WebElement Workregistdropdown = FindElement("xpath", "//select[@id='Model_AdminUser_PreEnrolEnabled']");
		Workregistdropdown.click();
		selectValueByIndex(Workregistdropdown, 0);
		waitForSeconds(1);
		WebElement workregistrForSitedropdown=FindElement("xpath", "//input[1][contains(@placeholder,'Please Select')]");
		workregistrForSitedropdown.click();
        WebElement ForSiteselection=FindElement("xpath", "//li[@class='select2-results__option select-all select']");
        ForSiteselection.click();
        waitForSeconds(1);
        WebElement emailaddressbox=FindElement("xpath", "//input[@id='Model_AdminUser_EmailAddress']");
        emailaddressbox.click();
        emailaddressbox.sendKeys(emailaddress);
        WebElement confirmemailaddressbox=FindElement("xpath", "//input[@id='Model_AdminUser_ConfirmEmailAddress']");
        confirmemailaddressbox.click();
        confirmemailaddressbox.sendKeys(emailaddress);
        WebElement firstname=FindElement("xpath", "//input[@id='Model_AdminUser_FirstName']");
        firstname.click();
        firstname.sendKeys(firstName);
        WebElement lastname=FindElement("xpath", "//input[@id='Model_AdminUser_LastName']");
        lastname.click();
        lastname.sendKeys(lastName);
	}
	
	
	public void delete_ContractorByName(String contractorname) 
	{
		FindElement("xpath", "//input[@placeholder='Search Contractor...']").clear();
		FindElement("xpath", "//input[@placeholder='Search Contractor...']").sendKeys(contractorname);
		waitForSeconds(2);
		FindElement("xpath", "//table[@id='contractorsList']//tbody/tr/td").click();
		waitForSeconds(2);
		deleteButtonInContractor.click();
		waitForSeconds(1);
	    WebElement deleteindialogbutton=FindElement("xpath", "//button[@class='btn btn-primary']");
	    deleteindialogbutton.click();
	    waitForSeconds(1);
	   saveBoxOkButton.click();
	}
	
	public void add_ContractorUser_InContractor() 
	{
		    String contractorname=getAlphaNumericString(5, "character");
		    addNewContractor.click();
		    waitForSeconds(1);
		    addNewContractorName.sendKeys(contractorname);
		    contractor_WorkforceResgistration();
		    waitForSeconds(1);
		    FindElement("xpath", "//button[@class='complexlist-add pull-right btn btn-default btn-xs inline']").click();
		    waitForSeconds(1);
		    Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Add New User Dialog box is not open.");
		    WebElement Workregistdropdown =FindElement("xpath", "//select[@id='Model_NonAdminUsers_INDEX__PreEnrolEnabled']");
			Workregistdropdown.click();
			selectValueByIndex(Workregistdropdown, 0);
			waitForSeconds(1);
			WebElement workregistrForSitedropdown=FindElement("xpath", "//div[contains(@class,'row')]//div//div//div[contains(@class,'row')]//div[4]");
			workregistrForSitedropdown.click();
	        WebElement ForSiteselection=FindElement("xpath", "//li[@class='select2-results__option select-all select']");
	        ForSiteselection.click();
	        waitForSeconds(1);
	        WebElement emailaddressbox=FindElement("xpath", "//input[@id='Model_NonAdminUsers_INDEX__EmailAddress']");
	        emailaddressbox.click();
	        emailaddressbox.sendKeys("deepak+5@meemmemory.com");
	        WebElement confirmemailaddressbox=FindElement("xpath", "//input[@id='Model_NonAdminUsers_INDEX__ConfirmEmailAddress']");
	        confirmemailaddressbox.click();
	        confirmemailaddressbox.sendKeys("deepak+5@meemmemory.com");
	        WebElement firstname=FindElement("xpath", "//input[@id='Model_NonAdminUsers_INDEX__FirstName']");
	        firstname.click();
	        firstname.sendKeys(firstName);
	        WebElement lastname=FindElement("xpath", "//input[@id='Model_NonAdminUsers_INDEX__LastName']");
	        lastname.click();
	        lastname.sendKeys(lastName);
	        waitForSeconds(1);
	        FindElement("xpath", "//button[contains(@class,'btn btn-primary btn-add')]").click();
	        waitForSeconds(1);
	        addNewContractorSaveButton.click();
	        waitForSeconds(1);
	        driver.navigate().refresh();
	        waitForSeconds(1);
	}
	
	
}
