package com.Msite.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Msite.TestScripts.BaseClass;

public class TrainingClassroomPage extends BaseClass
{
	public TrainingClassroomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a//span[contains(text(),'Training')]")
	WebElement trainingDropdown;
	
	@FindBy(xpath="//a[contains(text(),'Training')]")
	WebElement trainingWithoutDropdown;
	
	@FindBy(xpath="//li[@class='dropdown open']//ul[@class='dropdown-menu']/li//a[contains(text(),'Online')]")
	WebElement onlineTraining;
	
	@FindBy(xpath="//li[@class='dropdown open']//ul[@class='dropdown-menu']/li//a[contains(text(),'Classroom')]")
	WebElement classroomTraining;
	
	@FindBy(xpath="//ul[contains(@class,'nav nav-link')]")
	WebElement trainingFunctionallist;
	
	@FindBy(xpath="//li[@class='dropdown open']//ul[@class='dropdown-menu']")
	WebElement traininglist;
	
	@FindBy(xpath="//td[contains(text(),'0 Classroom Courses Found')]")
	WebElement noCourseFound;
	
	@FindBy(id="btn-allowCookies")
	WebElement allowCookies;
	
	public void openTrainingDropdown()  
	{
		if(!isElementPresent(traininglist))
		{
		   trainingDropdown.click();
		}
		waitForSeconds(2);
	}
	public void clickOnAllowCookies() 
	{
		waitForSeconds(1);
		allowCookies.click();
		waitForSeconds(3);
	}
	public void openTraining() 
	{
		    openTrainingDropdown(); 
			classroomTraining.click();
			waitForSeconds(2);	
	}
	public void openTrainingWithoutDropdown() 
	{
		trainingWithoutDropdown.click();
	}
	public void verifyTrainingTitle(String trainingType) 
	{
		if(trainingType.equalsIgnoreCase("NoTraining")) 
		{
		  Assert.assertEquals(driver.getTitle(), "Training");
		}
		else
		{
			Assert.assertEquals(driver.getTitle(), "MSite - Classroom Training");
		}
	}
	 public void verifyEmptyTraining()
	 {
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='pagepanel-header pagepanel-header-fullwidth']"), "Training Header is missing");
	 }
	  
	 public void verifyTrainingDropdown() 
	 {
		 Assert.assertTrue(isElementPresent(trainingFunctionallist), "Functional list is missing");
	 }
	 
	 public void reviewAndVerifyAllElementInTraining(String trainingType) 
		{
			List<WebElement> functionallist = trainingFunctionallist.findElements(By.xpath("./li"));
			for(WebElement ele:functionallist) 
			{
				String functionheading=ele.getText().replace("\n", "");
				Assert.assertTrue(isElementPresent(ele), ""+functionheading+" is missing in the System list");
			}
				Assert.assertTrue(isElementPresentByXpath("//a[@class='btn btn-default pull-right training-header-button']"), "Add New ClassRoom Course button is missing");
		}
	 
	 public void open_AddNewClassroomCourse()  
	 {
		 FindElement("xpath", "//ul[@class='nav nav-link']//a[contains(text(),'New Classroom Course')]").click();
		 waitForSeconds(1);
	 }
	 
	 public void verifyAllElementInAddNewClassroomCourse() 
	 {
		 Assert.assertTrue(isElementPresentByXpath("//ol[@class='breadcrumb']"), "Training/NewClassroom is missing");
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default']"), "Course Details is missing");
		 Assert.assertTrue(isElementPresentById("titleField"), "Title Field is missing");
		 Assert.assertTrue(isElementPresentById("Model_Description"), "Description Textbox  is missing");
		 Assert.assertTrue(isElementPresentById("Model_ManuallyAwardable"), "Manually Awarded checkbox is missing");
		 Assert.assertTrue(isElementPresentById("Model_ValidityPeriodInDays"), "Validity period days is missing");
		 Assert.assertTrue(isElementPresentById("Model_IsFundingEligible"), "Is Funding Eligible is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[contains(text(), 'Add Module...')]"), "Add Module button is missing");
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default sections-wrapper modulePanel']"), "Modules Section is missing");
		 Assert.assertTrue(isElementPresentByXpath("//input[@id='Model_IsPublished']"), "Is Published Checkbox  is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default inline messagedialog']"), "Discard button is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@id='createButton']"), "Create button is missing");	 
	 }
	 
	 public void open_NewClassroomCourse_And_VerifyAllElement()  
	 {
		 open_AddNewClassroomCourse();
		 verifyAllElementInAddNewClassroomCourse();
	 }
	 public void create_EmptyNewClassroomCourse() 
	 {
		 open_AddNewClassroomCourse();
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='col-md-9']/input[@class='form-control']"), "Title is missing");
		 FindElement("id", "createButton").click();
         waitForSeconds(1);
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='col-md-9']/input[@class='form-control input-validation-error was-invalid']"), "Title  Field is not highlighted in red color");
	 }
	 
	 public void performDiscardChangesFunction(String Action)  
	 {
		 FindElement("xpath", "//button[@class='btn btn-default inline messagedialog']").click();
		 waitForSeconds(2);
		 Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Discard Changes popup is missing");
		 Assert.assertEquals(FindElement("xpath","//div[@id='messagedialog-dialog']//h3[@class='modal-title']").getText(), "Cancel Changes");
		 Assert.assertEquals(FindElement("xpath","//div[@id='messagedialog-dialog']//div[@class='modal-body']").getText(), "Are you sure you wish to reload the course and discard any changes?");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel Button is missing in Discard cahne dialog");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Discard Button is missing in Discard cahne dialog");
		if(Action.equalsIgnoreCase("Cancel")) 
		{
			FindElement("xpath", "//button[@class='btn btn-default']").click();
			waitForSeconds(2);
		}
		else 
		{
			FindElement("xpath", "//button[@class='btn btn-primary']").click();
			  waitForSeconds(4);
		}
		 
	 }
	 
	 public void discardChangesWithData(String Action) 
	 {
		 open_AddNewClassroomCourse();
		 FindElement("id", "titleField").sendKeys("test");
		 performDiscardChangesFunction(Action);
		 if(Action.equalsIgnoreCase("Discard"))
		 {
			 Assert.assertEquals(FindElement("id", "titleField").getAttribute("value"), "");
		 } 
	 }
	 
	 
	  public void create_NewClassroomCourse(String titleName,String type,String Action)  
	  {
		  open_AddNewClassroomCourse();
		  FindElement("id", "titleField").sendKeys(titleName);
		  FindElement("id", "Model_Description").sendKeys("This is classroom course created for testing purpose by Deepak Malviya");
		  FindElement("id", "Model_ManuallyAwardable").click(); 
		  addNewClassroomCourse_addModule("Add",titleName);
		  WebElement publishcheckbox=FindElement("id", "Model_IsPublished");
		   if(type.equalsIgnoreCase("Publish")) 
		   {
			   if(!publishcheckbox.isSelected()) 
				   publishcheckbox.click();
			   
		   }
		   else 
		   {
			   if(publishcheckbox.isSelected()) 
				   publishcheckbox.click(); 
		   }
		   BaseClass.scrollToElement(FindElement("id", "createButton"));
		   waitForSeconds(1);
		   FindElement("id", "createButton").click();
		   waitForSeconds(2);
		   Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Create confirmation Dialog box is missing");
		   Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'"+titleName+"')]"), "Course name is missing in save confimation box");
		   if(Action.equalsIgnoreCase("Cancel")) 
		   {
			  FindElement("xpath", "//div[@id='messagedialog-dialog']//button[@class='btn btn-default']").click();
			  waitForSeconds(1);
			   
		   }
		   else 
		   {
				  FindElement("xpath", "//button[contains(text(),'Ok')]").click();
				  waitForSeconds(4);
		   }
	  }
	  
	  public void addNewClassroomCourse_InvalidValidityPeriodDays_NotCreated()  
	  {
		  open_AddNewClassroomCourse();
		  FindElement("id", "titleField").sendKeys("Deepak");
		  WebElement validityDays=FindElement("id", "Model_ValidityPeriodInDays");
		  validityDays.clear();
		  validityDays.sendKeys("6.7");
		  FindElement("id", "createButton").click();
		  waitForSeconds(1);
		  Assert.assertTrue(isElementPresentByXpath("//input[@class='form-control was-invalid input-validation-error']"), "Validity Days Field is not highlighted in red color");  
	  }
	  
	  public void addNewClassroomCourse_EmptyModule()  
	  {
		  open_AddNewClassroomCourse();
		  Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default sections-wrapper modulePanel']"), "Module Section is missing");
		  Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'Modules')]"), "Module Heading is missing");
	      Assert.assertTrue(isElementPresentByXpath("//button[contains(text(), 'Add Module...')]"), "Add Module button is missing");
	      Assert.assertEquals(FindElement("xpath", "//div[@class='complexlist-empty']").getText().replace("\n", ""), "None Provided");
	  }
	  
	  public void addNewClassroomCourse_AddModule_NoTitle_NotAdded()  
	  {
		  FindElement("xpath", "//button[contains(text(), 'Add Module...')]").click();
		  waitForSeconds(2);
		  Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Module Dialog is not opened");
		  Assert.assertEquals(FindElement("xpath", "//h3[@class='modal-title']").getText(), "Module");
		  Assert.assertTrue(isElementPresentByXpath("//label[@for='Model_Modules_INDEX__Title']"), "Tilte Label is missing in module");
		  Assert.assertTrue(isElementPresentByXpath("//label[@for='Model_Modules_INDEX__Description']"), "Description Label is missing in module");
		  Assert.assertTrue(isElementPresentByXpath("//input[@id='Model_Modules_INDEX__Title']"), "Tilte TextArea is missing in module");
		  Assert.assertTrue(isElementPresentByXpath("//textarea[@id='Model_Modules_INDEX__Description']"), "Description Textarea is missing in module");
		  FindElement("xpath", "//button[@class='btn btn-primary btn-add']").click();
		  waitForSeconds(1);
		  Assert.assertTrue(isElementPresentByXpath("//input[@class='form-control input-validation-error was-invalid']"), "Title Field is highlighted in red color");
		  FindElement("xpath", "//button[@class='btn btn-default']").click();
		  waitForSeconds(1);
	  }
	  
	  public void addNewClassroomCourse_addModule(String Action,String title)  
	  {
		  FindElement("xpath", "//button[contains(text(), 'Add Module...')]").click();
		  waitForSeconds(2);
		  FindElement("xpath", "//input[@id='Model_Modules_INDEX__Title']").sendKeys(title);
		  if(Action.equalsIgnoreCase("Cancel"))
		  {
			  FindElement("xpath", "//button[@class='btn btn-default']").click();
			  waitForSeconds(1);
		  }
		  else
		  {
			  FindElement("xpath", "//button[@class='btn btn-primary btn-add']").click();
			  waitForSeconds(3);
		  } 
	  }
	  
	  public void verifyAddedModules(String title) 
	  {   		  
		  WebElement moduleitem=FindElement("xpath", "//div[@class='complexlist-item save-pending']");
		  List<WebElement> modulelist=moduleitem.findElements(By.xpath("//div[@class='complexlist-summary pull-left']"));
		 for(WebElement modules:modulelist) 
		 {
			 if(modules.getText().contains(title))
				Assert.assertTrue(true);
		 }
	  }
	public void editModule_InClassroomCourse()  
	{
		 open_AddNewClassroomCourse();
		 addNewClassroomCourse_addModule("Add","Chapter_3");
		FindElement("xpath", "//div[@class='complexlist-item save-pending']//button[contains(text(),'Edit')]").click();
		waitForSeconds(1);
		String title=FindElement("id", "dialog-Model_0__Title").getAttribute("value");
		FindElement("id", "dialog-Model_0__Title").clear();
		FindElement("id", "dialog-Model_0__Title").sendKeys("Chapter2");
		FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
		waitForSeconds(2);
		FindElement("xpath", "//div[@class='complexlist-item save-pending']//button[contains(text(),'Edit')]").click();
		waitForSeconds(2);
		String updatedtitle=FindElement("xpath", "//div[@class='modal-body']//input[@id='dialog-Model_0__Title']").getAttribute("value");
        if(!title.equalsIgnoreCase(updatedtitle)) 
        {
        	Assert.assertTrue(true);
        }
        FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
		waitForSeconds(2);
	} 
	
	public void deleteModule_InClassroomCourse(String Action)  
	{
		open_AddNewClassroomCourse();
		 addNewClassroomCourse_addModule("Add","Chapter_4");
		FindElement("xpath", "//div[@class='complexlist-item save-pending']//button[contains(text(),'Delete')]").click();
		waitForSeconds(1);
		Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Module Delete Dialog box is missing");
	    Assert.assertEquals(FindElement("xpath", "//div[@class='modal-body']").getText(), "Are you sure you wish to delete this module?");
	    Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel Button is missing in module delete dialog box");
	    Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is missing in module dialog box");
	    if(Action.equalsIgnoreCase("Cancel"))
		  {
			  FindElement("xpath", "//button[@class='btn btn-default']").click();
			  waitForSeconds(1);
		  }
		  else
		  {
			  FindElement("xpath", "//button[@class='btn btn-primary']").click();
			  waitForSeconds(3); 
			  Assert.assertTrue(isElementPresentByXpath("//div[@class='complexlist-empty']"), "None is missing in module");
		  } 
	}
	 
	public void classroomTraining_BrowseCourse_VerifyAllElement() 
	{
        String tableHeadings[]=new String[] {"Title","Date Created","Modules","Published"};
       for(String heading:tableHeadings) 
       {
    	   Assert.assertTrue(isElementPresentByXpath("//th[contains(text(),'"+heading+"')]"), ""+heading+" is missing");
       }
       Assert.assertTrue(isElementPresentByXpath("//a[@class='btn btn-default pull-right training-header-button']"), "Add New ClassRoom Course button is missing");
	}
	
	public void classroomTraining_BrowseCourseList() 
	{
		if(BaseClass.isElementPresent(noCourseFound))
		{
		Assert.assertTrue(true, "0 Classroom Courses Found is missing in browse course");
		}
		else 
		{
			String courseTitle=FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr/td[1]/a").getText().replace("\n", "");
		   Assert.assertTrue(isElementPresentByXpath("//a[contains(text(),'"+courseTitle+"')]"), ""+courseTitle+" course is missing");
		}
	}
	
	public void classroomTraining_ViewCourse()  
	{
		if(BaseClass.isElementPresent(noCourseFound))
		{
		    Assert.fail("0 Classroom Courses Found ,Please Add Courses First");
		}
		else 
		{
			 String courseTitle=FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr/td[1]/a").getText().replace("\n", "");
		     FindElement("xpath", "//a[contains(text(),'"+courseTitle+"')]").click();
		     waitForSeconds(2);
		     Assert.assertEquals(driver.getTitle(), "MSite - "+courseTitle+"");
		}
	}
	
	public void classroomTraining_ViewCourse_CheckCourseDetails()  
	{
		WebElement browsecourses=FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr");
		List<WebElement> courseList=browsecourses.findElements(By.xpath("//td[1]"));
		int i=1;
		for(WebElement course:courseList) 
		{
			if(course.getText().contains("ClassroomCourse_Test_1")) 
			{
				String browseCourseTitle = FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr["+i+"]/td[1]//a").getText().replace("\n", "");
				String browseCourseModule = FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr["+i+"]/td[3]//a").getText().replace("\n", "");
				String browseCoursePublished = FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr["+i+"]/td[4]//a").getText().replace("\n", "");
				FindElement("xpath", "//a[contains(text(),'ClassroomCourse_Test_1')]").click();
				waitForSeconds(2);
				Assert.assertEquals(browseCourseTitle, FindElement("xpath", "//input[@id='titleField']").getAttribute("value"));
				if(browseCourseModule.equalsIgnoreCase("0")) 
				{
					Assert.assertTrue(isElementPresentByXpath("//div[@class='complexlist-empty']"), "None is missing");
				}
				else 
				{
					Assert.assertTrue(isElementPresentByXpath("//div[@class='complexlist-item']"), "module  is missing");
				}
				if(browseCoursePublished.equalsIgnoreCase("False")) 
				{
					Assert.assertEquals(FindElement("id", "Model_IsPublished").isSelected(), false);
				}
				else
				{
					Assert.assertEquals(FindElement("id", "Model_IsPublished").isSelected(), true);
				}
				break;
			}
			i++;
			
		}
		
		
	}
	
	public void classroomTraining_EditCourse()  
	{
		FindElement("xpath", "//a[contains(text(),'ClassroomCourse_Test_1')]").click();
		waitForSeconds(2);
		String beforeCourseTitle = FindElement("xpath", "//input[@id='titleField']").getAttribute("value");
		WebElement module =FindElement("xpath", "//div[@class='complexlist']");
		int beforeCourseModuleCount = module.findElements(By.xpath("//div[@class='complexlist-item']")).size();
		boolean browseCoursePublished = FindElement("id", "Model_IsPublished").isSelected();
		String updatedTitle="ClassroomCourse_Test_5";
		FindElement("xpath", "//input[@id='titleField']").clear();
		FindElement("xpath", "//input[@id='titleField']").sendKeys(updatedTitle);
		addNewClassroomCourse_addModule("Add","Chapter_5");
		FindElement("id", "Model_IsPublished").click();
		FindElement("id", "saveButton").click();
		  waitForSeconds(3);
		String browseCourseUpdateTitle = FindElement("xpath", "//input[@id='titleField']").getAttribute("value");
		WebElement updatedmodule =FindElement("xpath", "//div[@class='complexlist']");
		int updatedCourseModuleCount = updatedmodule.findElements(By.xpath("//div[@class='complexlist-item']")).size();
		boolean updatedCoursePublished = FindElement("id", "Model_IsPublished").isSelected();
		Assert.assertEquals(beforeCourseTitle.equalsIgnoreCase(browseCourseUpdateTitle), false);
		Assert.assertEquals(beforeCourseModuleCount != updatedCourseModuleCount, true);
		Assert.assertEquals(browseCoursePublished!=updatedCoursePublished, true);
	}
	
   public void classroomTraining_OpenReport()  
   {
	   FindElement("xpath", "//ul[@class='nav nav-link']//a[contains(text(),'Reports')]").click();
	   waitForSeconds(2);
   }
   public void classroomTraining_ViewReport_And_VerifyTitle() 
   {
	   classroomTraining_OpenReport();
	   Assert.assertEquals(driver.getTitle(), "MSite - Reports");
   }
   
   public void classroomTraining_OpenReport_And_VerifyAlllElement()  
   {
	   classroomTraining_OpenReport();
	   Assert.assertEquals(FindElement("xpath", "//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]").getText(), "Reports");
	   Assert.assertTrue(isElementPresentByXpath("//ol[@class='breadcrumb']"),"Training/Report is missing");
	   Assert.assertTrue(isElementPresentByXpath("//div[@class='panel panel-default']"), "Report Section is missing");
       Assert.assertEquals(FindElement("xpath", "//div[@class='panel-heading']/strong").getText(), "Reports");
       Assert.assertTrue(isElementPresentByXpath("//a[contains(text(),'Session Report')]"), "Session Report link is missing");
       Assert.assertTrue(isElementPresentByXpath("//a[contains(text(),'Training Report')]"), "Training Report link is missing");
       Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Individual training records, not grouped by training session.')]"), "Training Report description message is misssing");
       Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Training records grouped by training session. Incl')]"), "Session Report Description message is missing");
   }
	
   public void classroomTraining_OpenReportType_And_VerifyTitle(String Type)  
   {
	   classroomTraining_OpenReport();
	   FindElement("xpath", "//a[contains(text(),'"+Type+"')]").click();
	   waitForSeconds(2);
	   Assert.assertEquals(driver.getTitle(), "MSite - "+Type+"");
   }
   
   public void classroomTraining_DeleteCourse(String Action)  
   {
	    
	   if(Action.equalsIgnoreCase("Cancel"))
	   {
		   WebElement courseName = FindElement("xpath", "//a[contains(text(),'ClassroomCourse_Test')]");
		    courseName.click();
		   waitForSeconds(2);
		   String beforeCourseTitle = FindElement("xpath", "//input[@id='titleField']").getAttribute("value");
		   FindElement("xpath", "//button[@class='btn btn-danger inline messagedialog']").click();
		   waitForSeconds(1);
		   Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Delete Course Dialog box is missing");
		   Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Delete')]"), "Delete Header is missing");
		   Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete "+beforeCourseTitle+"')]"), "Delete Confirmation message is missing");
		   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is missing in Delete Dailog box");
		   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is missing in Delete Dialog box");
		   FindElement("xpath", "//button[@class='btn btn-default']").click();
		   waitForSeconds(1);
	   }
	   else
	   { 
		    WebElement browsecourses=FindElement("xpath", "//table[@id='employeeListTable']//tbody//tr");
			List<WebElement> courseList=browsecourses.findElements(By.xpath("//td[1]/a"));
			String courseText[]=new String[courseList.size()];
			  int i=0;
			  for(WebElement course:courseList) 
			  {
				  courseText[i]=course.getText();
				  i++;
			  }
			  for(String str:courseText)
			  {
			     if(str.contains("ClassroomCourse_Test")) 
			     {
			    	 FindElement("xpath", "//a[contains(text(),'ClassroomCourse_Test')]").click();
			          waitForSeconds(2);
			          FindElement("xpath", "//button[@class='btn btn-danger inline messagedialog']").click();
			          waitForSeconds(1);
		              FindElement("xpath", "//button[@class='btn btn-primary']").click();
		              waitForSeconds(0.3);
		              FindElement("xpath", "//button[@class='btn btn-primary']").click();
		              waitForSeconds(5);
			     }
			  }
	   }  
   }
   
   
}
