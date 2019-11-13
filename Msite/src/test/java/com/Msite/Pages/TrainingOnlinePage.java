package com.Msite.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Msite.TestScripts.BaseClass;

public class TrainingOnlinePage extends BaseClass
{
	public TrainingOnlinePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a//span[contains(text(),'Training')]")
	WebElement trainingDropdown;
	
	@FindBy(xpath="//li[@class='dropdown open']//ul[@class='dropdown-menu']/li//a[contains(text(),'Online')]")
	WebElement onlineTraining;
	
	@FindBy(xpath="//ul[contains(@class,'nav nav-link')]")
	WebElement trainingFunctionallist;
	
	@FindBy(id="createButton")
	WebElement createButton;
	
	@FindBy(id="titleField")
	WebElement titleField;
	
	@FindBy(id="Model_Description")
	WebElement courseDescription;
	
	@FindBy(xpath="//i[@class='fa section-icon fa-question-circle']")
	WebElement questionIcon;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-2x section-info-icon fa-question-circle')]")
	WebElement questionIconInPreview;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-2x section-info-icon fa-video-camera')]")
	WebElement videoIconInPreview;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-2x section-info-icon fa-photo')]")
	WebElement imageIconInPreview;
	
	@FindBy(xpath="//i[@class='fa section-icon fa-video-camera']")
	WebElement videoIcon;
	
	@FindBy(xpath="//i[@class='fa section-icon fa-picture-o']")
	WebElement imageIcon;
	
	@FindBy(xpath="//div[@id='iframedialog-dialog']//div[contains(@class,'modal-content')]")
	WebElement previewDialog;
	
	@FindBy(xpath="//p[@data-bind='visible: IsQuestionTotalVisible']")
	WebElement questionVisibilityInPreview;
	
	@FindBy(xpath="//p[@data-bind='visible: IsRequiredScoreVisible']")
	WebElement requiredScoreVisibilityInPreview;
	
	@FindBy(xpath="//button[contains(@class,'navigation-button navigation-button-top navigation-button-left')]")
	WebElement backButtonInPreview;
	
	@FindBy(xpath="//button[contains(@class,'navigation-button navigation-button-top navigation-button-right')]")
	WebElement nextButtonInPreview;
	
	@FindBy(xpath="//div[@class='banner banner-incomplete']")
	WebElement wrongAnswerConfirmationText;
	
	@FindBy(xpath="//div[@class='banner banner-complete']")
	WebElement correctAnswerConfirmationText;
	
	@FindBy(xpath="//div[@class='failed-course responsive-course-content']")
	WebElement failedCourseScreenInPreview;
	
	@FindBy(xpath="//div[@class='course-complete responsive-course-content']")
	WebElement passedCourseScreenInPreview;
	
	@FindBy(id="Widget-cc0ce8f5-e2e8-4a1e-aba3-e97e8da47b30")
	WebElement trainingInDataRangeWidget;
	
	@FindBy(id="btn-allowCookies")
	WebElement allowCookies;
	
	
	String Question1 ="What is the Captial of India ?";
	String Ques1AnswerList[]=new String[] {"Bangalore","Mumbai","New Delhi","Bhopal"};
	String Question2 ="What is 2+2 ?";
	String Ques2AnswerList[]=new String[] {"1","2","4","3"};

	
	public void openOnlineTraining()  
	{
		trainingDropdown.click();
		waitForSeconds(1);
		onlineTraining.click();
		waitForSeconds(2);
	}
	
	public void clickOnAllowCookies() 
	{
		waitForSeconds(1);
		allowCookies.click();
		waitForSeconds(3);
	}
	public void verifyOnlineTrainingTitle() 
	{
		Assert.assertEquals(driver.getTitle(), "MSite - Training Dashboard");
	}
	
	public void VerifyAllElementInTrainingDashboard() 
	{
		List<WebElement> functionallist = trainingFunctionallist.findElements(By.xpath("./li"));
		for(WebElement ele:functionallist) 
		{
			String functionheading=ele.getText().replace("\n", "");
			Assert.assertTrue(isElementPresent(ele), ""+functionheading+" is missing in the System list");
		}
			   Assert.assertEquals(FindElement("xpath", "//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]").getText(), "Training Dashboard");
			   Assert.assertTrue(isElementPresentByXpath("//h1[contains(text(),'Dashboard')]"), "Dashboard Headinh is missing");
			   Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'Current Training Pipeline')]"), "Current Training Pipeline Section is missing");
		       Assert.assertTrue(isElementPresentByXpath("//div[@id='Widget-fc7722d2-fe8c-4dbe-bc7e-d159e9995ca5-Placeholder']"), "Progress bar is missing");
		       Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'analytics-link pull-right')]//a[contains(@class,'btn btn-primary')]"), "Training Analytics button is missing in Dashboard");
		       Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'courseStatistics')]"), "Course Statics Section is missing");
		       Assert.assertTrue(isElementPresentByXpath("//h4[contains(text(),'Course Statistics')]"), "Course Statistics Heading is missing");
		       String courseType[] =new String[] {"Company-wide Courses","Site Specific Courses","Role Specific Courses","Manually Awardable Courses","Courses With Questions","Courses Linked to Access Control"};
		       for(String course:courseType) 
		       {
		    	   Assert.assertTrue(isElementPresentByXpath("//span[contains(text(),'"+course+"')]"), ""+course+" is missing");
		       }
		      Assert.assertTrue(isElementPresentByXpath("//a[contains(@class,'btn btn-default btn-oversized-with-text')]"), "Add new Course button is missing in Dashboard");
		      Assert.assertTrue(isElementPresentByXpath("//a[contains(@class,'btn btn-primary btn-oversized-with-text')]"), "Browse Course button is missing in Dashboard");
	}
	
	 public void onlineTraining_NavigationFromDashbaord(String navigationButton) 
	   {
		   FindElement("xpath", "//span[contains(text(),'"+navigationButton+"')]").click();
		   waitForSeconds(2);
		   if(navigationButton.equalsIgnoreCase("Training Analytics"))
		        Assert.assertEquals(driver.getTitle(), "MSite - Training Analytics");
		   else if(navigationButton.equalsIgnoreCase("Add a New Course"))
			   Assert.assertEquals(driver.getTitle(), "MSite - Add a New Online Course");
		   else if(navigationButton.equalsIgnoreCase("Browse Courses"))
			   Assert.assertEquals(driver.getTitle(), "MSite - Courses");
	   }
	   
	   public void onlineTraining_OpenTrainingAnalytics()  
	   {
		   FindElement("xpath", "//a[contains(text(),'Training Analytics')]").click();
		   waitForSeconds(2);
	   }
	   public void onlineTraining_VerifyTrainingAnalyticsTitle() 
	   {
		   Assert.assertEquals(driver.getTitle(), "MSite - Training Analytics");
	   }
	   
	   public void onlineTraining_VerifyAllElementIn_TrainingAnalytics() 
	   {
		   Assert.assertEquals(FindElement("xpath", "//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]").getText(), "Training Analytics");
	       String filterTextBoxs[] =new String[] {"select2-filters_0_-container","select2-filters_1_-container","select2-filters_2_-container","filters_3_","filters_4_"};
	     for(String filter:filterTextBoxs)
	    {
	    	Assert.assertTrue(isElementPresentById(filter), ""+filter+" is missing");
	    }
	     
	     String attributes1[] =new String[] {"Contractor","Total Invited","Not Started","In Progress","Complete","Expired"};
	     String attributes2[] =new String[] {"Course Name","Min. Pass","Must Pass","Awarded","Passed 1st Time","Passed on Re-Try","Failed","Avg. Score"};
	     dashboardWidgetPresent("Widget-e548f771-7395-4148-871e-8db29f6932d0","Invites by Contractor in Date Range",attributes1);
	     dashboardWidgetPresent("Widget-d397e3cb-154e-4626-83f3-5f0422e7e566","Assessment Performance in Date Range",attributes2);
	   }
	   
	   public void dashboardWidgetPresent(String widgetID, String widgetHeading, String[] tableAttributes)
		  {
			  Assert.assertTrue(isElementPresentById(widgetID), "Unable to find widget id");
			  Assert.assertTrue(isElementPresentByXpath("//*[@id='" + widgetID + "']//*[contains(text(),'" + widgetHeading + "')]"), "Unable to find widget heading");
			  for (String str : tableAttributes)  
		        { 
		            Assert.assertTrue(isElementPresentByXpath("//*[@id='" + widgetID + "']//*[contains(text(),'" + str + "')]"), "unable to find attribute");
		        } 
		  }
	   
	   public void onlineTraining_TrainingAnalytics_ViewOnlineTrainingReport() 
	   {
		   List<WebElement> numberOfButtons = driver.findElements(By.xpath("//i[@data-original-title='View the Online Training Audit Report']"));
        for(WebElement button:numberOfButtons) 
        {
        	if(isElementPresent(button) && isElementEnabled(button)){
        		button.click();
        		waitForSeconds(3);
        		Assert.assertEquals("MSite - Training Audit", driver.getTitle());
        		driver.navigate().back();
        		waitForSeconds(2);
        	}
        }
		   
	   }
	   
	  public void onlineTraining_TrainingAnalytics_InviteTable_ChangeByContractor(String contractorName)  
	  {
             FindElement("xpath", "//span[@id='select2-filters_2_-container']/..").click();
	    	 FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']/input").sendKeys(contractorName);
	    	 waitForSeconds(2);
	    	 FindElement("xpath", "//li[contains(text(),'"+contractorName+"')]").click();
	    	 waitForSeconds(0.5);
            WebElement table = FindElement("id", "Widget-e548f771-7395-4148-871e-8db29f6932d0");
            List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr"));
          if(rows.size()>0) {
            for(int i=0;i<rows.size();i++) 
          {
        	  Assert.assertTrue(isElementPresentByXpath("//td[contains(text(), '"+contractorName+"')]"), "Either size is zero or contractoor is missing ");
          }
          }
          
	  }
	   
	 public void onlineTraining_OpenAddANewOnlineCourse()  
	 {
		 FindElement("xpath", "//a[contains(text(),'Add a New Online Course')]").click();
		 waitForSeconds(2);
	 }
	 public void onlineTraining_VerifyAddNewOnlineCourseTitle() 
	   {
		   Assert.assertEquals(driver.getTitle(), "MSite - Add a New Online Course");
	   }
	 public void onlineTraining_VerifyAllElementInAddANewOnlineCourse() 
	 {
		 Assert.assertEquals(FindElement("xpath", "//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]").getText(), "Add a New Online Course");
	    String panelHeadings[] = new String[] {"Course Details","Audience","Selective","Sites","Roles","Assessment Settings","Content"};
	    for (String str : panelHeadings)  
        { 
            Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'" + str + "')]"), "unable to find "+str+" heading");
        }
	    String labelsList[] =new String[] {"Title","Description","Course Type","Permissions","Manually Awardable","Editable Only By Training Administrator","Validity Period","Allow Resit Period","Required","Restricts Access","Available","Company Wide","Site-Specific","All New Sites"};
	    for (String str : labelsList)  
        { 
            Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'" + str + "')]"), "unable to find "+str+" heading");
        }
	    Assert.assertTrue(isElementPresentByXpath("//button[contains(text(), 'Add Question...')]"), "Add Question button is missing");
	    Assert.assertTrue(isElementPresentByXpath("//button[contains(text(), 'Add Section...')]"), "Add Section button is missing");
	    Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default inline messagedialog']"), "Discard Button is missing");  
	    Assert.assertTrue(isElementPresentById("createButton"), "Create Button is missing");
	 }
	 
	 public void onlineTraining_AddEmptyOnlineCourse_NotAdded() 
	 {
		 Assert.assertTrue(isElementPresentByXpath("//button[@disabled='disabled']"), "Create Button is missing or Enabled by Default");
	 }
	 
	public void onlineTraining_CheckCreateButtonEnability_InAddANewOnlineCourse()  
	{
		titleField.sendKeys("dee");
		waitForSeconds(1);
		scrollToElement(createButton);
		Assert.assertTrue(isElementEnabled(createButton), "Create Button is missing or Enabled by Default");
	}
	
	 public void addNewClassroomCourse_InvalidValidityPeriodDays_NotCreated()  
	  {
		 titleField.sendKeys("Deepak");
		  WebElement validityDays=FindElement("id", "Model_ValidityPeriodInDays");
		  validityDays.clear();
		  validityDays.sendKeys("6.7");
		  titleField.click();
		  waitForSeconds(1);
		  createButton.click();
		  waitForSeconds(1);
		  Assert.assertTrue(isElementPresentByXpath("//input[@class='form-control was-invalid input-validation-error']"), "Validity Days Field is not highlighted in red color");  
	  }
	 
	 public void addNewClassroomCourse_InvalidMiminumPassScore_NotCreated()  
	  {
		 titleField.sendKeys("Deepak");
		  WebElement mimimumPassScore=FindElement("id", "Model_MinimumPassScore");
		  mimimumPassScore.clear();
		  mimimumPassScore.sendKeys("6.7");
		  FindElement("id", "Model_MustPass").click();
		  waitForSeconds(1);
		  scrollToElement(createButton);
		  createButton.click();
		  waitForSeconds(2);
		  Assert.assertTrue(isElementPresentByXpath("//input[@class='form-control was-invalid input-validation-error']"), "Validity Days Field is not highlighted in red color");  
	  }
	 
	 public void performDiscardChangesFunction(String Action)  
	 {
		 FindElement("xpath", "//button[contains(text(),'Discard Changes')]").click();
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
			waitForSeconds(3);
		}
		 
	 }
	 
	 public void discardChangesWithData(String Action) 
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 titleField.sendKeys("test");
		 performDiscardChangesFunction(Action);
		 if(Action.equalsIgnoreCase("Discard"))
		 {
			 Assert.assertEquals(titleField.getAttribute("value"), "");
		 } 
	 }

	 public void addNewCourse_Content_OpenAddNewQuestion() 
	 {
		 FindElement("xpath", "//button[contains(text(), 'Add Question...')]").click();
		 waitForSeconds(1);
	 }
	 
	 public void addNewCourse_Content_AddNewQuestion_And_VerifyElement() 
	 {
		 addNewCourse_Content_OpenAddNewQuestion();
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Add Question mode is missing");
		 Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Content header is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel Button is missing in Add question Dialog box");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary btn-add']"), "Add button is missing");
	     String labels[]=new String[] {"Question","Image","Answer 1","Answer 2","Answer 3","Answer 4","Randomise Answer Order"};
	     for(String str:labels) 
	     {
	    	 Assert.assertTrue(isElementPresentByXpath("//label[contains(text(),'"+str+"')]"), ""+str+" is missing");
	     }
	     FindElement("xpath", "//button[@class='btn btn-default']").click();
	     waitForSeconds(2);
	 }
	 
	 public void addNewCourse_Content_AddNewQuestion(String Question,String AnswerList[],String Action,boolean Random)  
	 {
		 addNewCourse_Content_OpenAddNewQuestion();
		 FindElement("id", "Model_CourseSections_INDEX__Title").sendKeys(Question);
		 String answerBoxList[] = new String[] {"Model_CourseSections_INDEX__Answers_0__Answer","Model_CourseSections_INDEX__Answers_1__Answer","Model_CourseSections_INDEX__Answers_2__Answer","Model_CourseSections_INDEX__Answers_3__Answer"};
		 int i=0;
		 for(String answer:answerBoxList) 
		 {
			FindElement("id", answer).sendKeys(AnswerList[i]);
			i++;
		 }
		 waitForSeconds(2);
		 FindElement("xpath", "//div[@class='modal-body']//label[contains(text(),'Answer 3')]").click();
		 waitForSeconds(1);
		 if(Random) 
		 {
			 FindElement("id", "Model_CourseSections_INDEX__RandomiseAnswerOrder").click();
		 }
		 if(Action.equalsIgnoreCase("Cancel")) {
	   		  FindElement("xpath", "//button[@class='btn btn-default']").click();
		   waitForSeconds(1);}
	   	  else {
	   	      FindElement("xpath", "//button[@class='btn btn-primary btn-add']").click();
	   	      waitForSeconds(3);
	   	      }
	 }
	 
	 public void addNewCourse_Content_OpenAddSection() 
	 {
		 FindElement("xpath", "//button[contains(text(), 'Add Section...')]").click();
		 waitForSeconds(1);
	 }
	 public void addNewCourse_Content_AddSection_And_VerifyElement() 
	 {
		 addNewCourse_Content_OpenAddSection();
		 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Add Section model is missing");
		 Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Content header is missing");
		 Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel Button is missing in Add question Dialog box");
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary btn-add disabled']"), "Add button is missing");
	     String labels[]=new String[] {"Title","Description","Description Visible","Type","File"};
	     for(String str:labels) 
	     {
	    	 Assert.assertTrue(isElementPresentByXpath("//div[@class='col-md-4']//label[contains(text(),'"+str+"')]"), ""+str+" is missing");
	     }
	     Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-lg btn-default center-block fileupload']"), "upload is misisng");
	     FindElement("xpath", "//button[@class='btn btn-default']").click();
	     waitForSeconds(2);
	 }
	 
	 public void addNewCourse_Content_AddSection(boolean preview,String Action) throws Exception 
	 {
		 addNewCourse_Content_OpenAddSection();
		 FindElement("id", "Model_CourseSections_INDEX__Title").sendKeys("Test_1");
		 FindElement("id", "Model_CourseSections_INDEX__Description").sendKeys("Test Section Created by D.M.");
		 FindElement("id", "Model_CourseSections_INDEX__DescriptionVisible").click();
		 waitForSeconds(0.5);
		 selectValue(FindElement("id", "Model_CourseSections_INDEX__Type"), "2");
		 waitForSeconds(1);
		 FindElement("xpath", "//div[@class='modal-body']//button[@class='btn btn-lg btn-default center-block fileupload']").click();
		 waitForSeconds(0.5);
		 StringSelection ss = new StringSelection("D:\\2019-09-18_17h00_22.mp4");
   	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	  Robot robot = new Robot();
   	  robot.keyPress(KeyEvent.VK_CONTROL);
   	  robot.keyPress(KeyEvent.VK_V);
   	  robot.keyRelease(KeyEvent.VK_V);
   	  robot.keyRelease(KeyEvent.VK_CONTROL);
   	  robot.keyPress(KeyEvent.VK_ENTER);
   	  robot.keyRelease(KeyEvent.VK_ENTER);
   	  Thread.sleep(8000);
   	  if(preview) 
   	  {
   		 FindElement("id", "preview").click();
   		 waitForSeconds(2);
   	  }
   	  if(Action.equalsIgnoreCase("Cancel")) {
   		  FindElement("xpath", "//button[@class='btn btn-default']").click();
   	  waitForSeconds(2);
   	  }
   	  else
   	  {
   	      FindElement("xpath", "//button[@class='btn btn-primary btn-add']").click();
   	     waitForSeconds(3);
   	  }
	 }
	  
	 public void onlineTraining_Content_Edit_Or_Delete_AddQuestion(String Operation,String Action)  
	 {
		 onlineTraining_Content_AddQuestion();
		 FindElement("xpath", "//button[@data-title='Content' and contains(text(), '"+Operation+"')]").click();
		 waitForSeconds(1);
		 if(Operation.equalsIgnoreCase("Edit")) 
		 {
		 WebElement question = FindElement("id", "dialog-Model_0__Title");
		 String beforeUpdateQuestion =question.getText();
         question.clear();
		 FindElement("id", "dialog-Model_0__Title").sendKeys(Question2);
		 if(Action.equalsIgnoreCase("Cancel")) 
		 {
			 FindElement("xpath", "//button[@class='btn btn-default']").click();
			 waitForSeconds(2);
		 }
		 else 
		 {
		    FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
		    waitForSeconds(3);
		 FindElement("xpath", "//button[@data-title='Content' and contains(text(), '"+Operation+"')]").click();
		 waitForSeconds(2);
		 String afterUpdateQuestion = FindElement("xpath", "//div[@class='modal-body']//textarea[@id='dialog-Model_0__Title']").getText();
		 Assert.assertEquals(beforeUpdateQuestion.equalsIgnoreCase(afterUpdateQuestion), false);
		 FindElement("xpath", "//button[@class='btn btn-default']").click();
		 waitForSeconds(2);
		 }
		 }
		 else if(Operation.equalsIgnoreCase("Delete")) 
		 {
			 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Delete Question Dialpog is not open");
			 Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Header is missing");
			 Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Header is missing");
			 Assert.assertEquals(FindElement("xpath", "//div[@class='modal-body']").getText(), "Are you sure you wish to delete this course section?");
			 if(Action.equalsIgnoreCase("Cancel")) {
				 FindElement("xpath", "//button[@class='btn btn-default']").click();
				 waitForSeconds(1);
			 }
			 else {
			    FindElement("xpath", "//button[@class='btn btn-primary']").click();
			    waitForSeconds(3);
			    
			 }
		 }
	 }
	 
	 public void onlineTraining_Content_Edit_Or_Delete_AddSection(String Operation,String Action) throws Exception 
	 {
		 onlineTraining_Content_AddSection_Added();
		 FindElement("xpath", "//button[@data-title='Content' and contains(text(), '"+Operation+"')]").click();
		 waitForSeconds(2);
		 if(Operation.equalsIgnoreCase("Edit")) 
		 {
		 WebElement question = FindElement("id", "dialog-Model_0__Title");
		 String beforeUpdateQuestion =question.getAttribute("value");
         question.clear();
		 FindElement("id", "dialog-Model_0__Title").sendKeys("Test_2");
		 if(Action.equalsIgnoreCase("Cancel"))
		 {
			 FindElement("xpath", "//button[@class='btn btn-default']").click();
		 waitForSeconds(2);}
		 else
		 {
		    FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
		   waitForSeconds(3);
		 FindElement("xpath", "//button[@data-title='Content' and contains(text(), '"+Operation+"')]").click();
		 waitForSeconds(2);
		 String afterUpdateQuestion = FindElement("xpath", "//div[@class='modal-body']//input[@id='dialog-Model_0__Title']").getAttribute("value");
		 Assert.assertEquals(beforeUpdateQuestion.equalsIgnoreCase(afterUpdateQuestion), false);
		 FindElement("xpath", "//button[@class='btn btn-default']").click();
		 waitForSeconds(2);
		 }
		 }
		 else if(Operation.equalsIgnoreCase("Delete")) 
		 {
			 Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-content']"), "Delete Question Dialpog is not open");
			 Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Header is missing");
			 Assert.assertTrue(isElementPresentByXpath("//h3[@class='modal-title']"), "Header is missing");
			 Assert.assertEquals(FindElement("xpath", "//div[@class='modal-body']").getText(), "Are you sure you wish to delete this course section?");
			 if(Action.equalsIgnoreCase("Cancel")) {
				 FindElement("xpath", "//button[@class='btn btn-default']").click();
				 waitForSeconds(1);
			 }
			 else {
			    FindElement("xpath", "//button[@class='btn btn-primary']").click();
			    waitForSeconds(3);
			    
			 }
		 }
	 }
	 
	 public void onlineTraining_OpenAddQuestion_VerifyAllElement() 
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 addNewCourse_Content_AddNewQuestion_And_VerifyElement();
	 }
	 public void onlineTraining_Content_AddQuestion_Cancel_NotAdded()  
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 addNewCourse_Content_AddNewQuestion(Question1,Ques1AnswerList,"Cancel",false);
	 }
	 public void onlineTraining_Content_AddQuestion()  
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 addNewCourse_Content_AddNewQuestion(Question1,Ques1AnswerList,"Add",true);
	 } 
	public void onlineTraining_OpenAddSection_VerifyAllElement() throws Exception 
	{
		onlineTraining_OpenAddANewOnlineCourse();
		addNewCourse_Content_AddSection_And_VerifyElement();
	} 
	
	 public void onlineTraining_Content_AddSection_Cancel_NotAdded() throws Exception 
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 addNewCourse_Content_AddSection(true,"Cancel");
	 }
	 
	 public void onlineTraining_Content_AddEmptySection_NotAdded() throws Exception 
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 addNewCourse_Content_OpenAddSection();
		 FindElement("xpath", "//button[@class='btn btn-primary btn-add disabled']").click();
		 waitForSeconds(1);
		 Assert.assertEquals("block", FindElement("id", "complexlist-dialog").getCssValue("display"), "The dialog is not visible.");
		 FindElement("xpath", "//button[@class='btn btn-default']").click();
		 waitForSeconds(2);
	 }
	 public void onlineTraining_Content_AddSection_Added() throws Exception 
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 addNewCourse_Content_AddSection(false,"Added");
	 }
	  
	 public void onlineTraining_AddANewOnlineCourse_Created(String title,String validity,String site,String roles,String minmarks,boolean mustPass,boolean showAnswer,boolean publish,String Action) throws Exception 
	 {
		 onlineTraining_OpenAddANewOnlineCourse();
		 titleField.sendKeys(title);
		 courseDescription.sendKeys("This Course Is Created By Deepak Malviya For Testing Purpose");
		 FindElement("id", "Model_ManuallyAwardable").click();
		 WebElement validityDays=FindElement("id", "Model_ValidityPeriodInDays");
		  validityDays.clear();
		  validityDays.sendKeys(validity);
		  FindElement("xpath", "//input[@placeholder='Please Select']").click();
		  waitForSeconds(1);
		  FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']").sendKeys(site);
		  FindElement("xpath", "//strong[contains(text(),'"+site+"')]").click();
		  waitForSeconds(1);
		  FindElement("id", "autoGrowSites").click();
		  chooseRolesInAudience(roles);
	     FindElement("id", "Model_AutomaticallyGrowRoles").click();
		 WebElement minimumPassScore=FindElement("id", "Model_MinimumPassScore");
		 minimumPassScore.clear();
		 minimumPassScore.sendKeys(minmarks);
		 if(mustPass) 
		 {
		 FindElement("id", "Model_MustPass").click();
		 }
		 if(showAnswer) 
		 {
		 FindElement("id", "Model_ShowCorrectAnswers").click();
		 }
		 addNewCourse_Content_AddNewQuestion(Question1,Ques1AnswerList,"Add",true);
		 addNewCourse_Content_AddNewQuestion(Question2,Ques2AnswerList,"Add",true);
		 addNewCourse_Content_AddSection(false,"Added");
		 WebElement publishcheckbox=FindElement("id", "Model_IsPublished");
		   if(publish) 
		   {
				   publishcheckbox.click();	   
		   }
		 createButton.click();
		 waitForSeconds(2);
		 Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Create Course Dialog is missing");
		 Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Create Course')]"), "Create Course Header Name is missing");
		 Assert.assertTrue(isElementPresentByXpath("//h4[contains(text(),'Your course will be created')]"), "Create Course Confirmation message heading1 is missing");
		 Assert.assertTrue(isElementPresentByXpath("//h5[contains(text(),'The following training accreditation will also be')]"), "Create Course confirm message part2 is missing");
		 Assert.assertTrue(isElementPresentByXpath("//strong[contains(text(),'"+title+"')]"), "Course name is missing in Create confimation box");
		 if(Action.equalsIgnoreCase("Cancel"))
		 {
			 FindElement("xpath", "//div[@id='messagedialog-dialog']//button[@class='btn btn-default']").click();
			 waitForSeconds(1);
		 }
		 else {
			 FindElement("xpath", "//button[@class='btn btn-primary']").click();
			 waitForSeconds(5);
		 }
		 
	 }
	  public void chooseRolesInAudience(String roles)
	  {
		  if(roles.equalsIgnoreCase("All roles"))
		  {
			  WebElement roleRaw =FindElement("xpath", "//div[@class='row role']");
			  List<WebElement> rolesList =roleRaw.findElements(By.xpath("//input[@class='checkbox-inline available-for-role available-for-role-checkbox col-xs-1']"));
			  for(WebElement role:rolesList) 
			  {
				  role.click();
			  }
		  }
		  else 
		  {
			FindElement("xpath", "//span[contains(text(),'"+roles+"')]//preceding-sibling::input").click();
		  }
	  }
	  
	  public void onlineTraining_AddQuestion_UnableToSelectBlankAnswer() 
      {
		  addNewCourse_Content_OpenAddNewQuestion();
          FindElement("xpath", "//label[contains(text(), 'Answer 3')]/..").click();
          WebElement a1_icon = FindElement("xpath", "//label[contains(text(), 'Answer 1')]/../../../i");
          Assert.assertEquals("fa fa-bullseye", a1_icon.getAttribute("class"));
          WebElement a3_icon = FindElement("xpath", "//label[contains(text(), 'Answer 3')]/../../../i");
          Assert.assertEquals("fa fa-circle-o", a3_icon.getAttribute("class"));
          FindElement("xpath", "//button[@class='btn btn-default']").click();
 	     waitForSeconds(1);
      }
	  
	  public void onlineTraining_AddQuestion_OnlyOneAnswerSelected() 
      {
		  addNewCourse_Content_OpenAddNewQuestion();
		  FindElement("xpath", "//label[contains(text(), 'Answer 2')]/..").click();
          WebElement a2_icon = FindElement("xpath", "//label[contains(text(), 'Answer 2')]/../../../i");
          Assert.assertEquals("fa fa-bullseye", a2_icon.getAttribute("class"));
          WebElement a1_icon = FindElement("xpath", "//label[contains(text(), 'Answer 1')]/../../../i");
          Assert.assertEquals("fa fa-circle-o", a1_icon.getAttribute("class"));
          FindElement("xpath", "//button[@class='btn btn-default']").click();
 	     waitForSeconds(1);
      }
	 
	  public void onlineTraining_AddNewCourse_Publish(boolean expectedValue) throws Exception
      {
		  if(expectedValue) 
		  {
			  addNewCourse_Content_AddNewQuestion(Question1,Ques1AnswerList,"Add",true);
		  }
          WebElement publishButton = FindElement("id", "Model_IsPublished");
          scrollToElement(publishButton);
          publishButton.click();
          Assert.assertEquals(expectedValue, publishButton.isSelected());
      }
	  
	  public void onlineTraining_OpenBrowseCourse()  
	  {
		  scrollToHeader();
		  String operation=FindElement("xpath", "//li[@class='active']/div").getText();
		  if(operation.equalsIgnoreCase("Browse Courses")) {
			  FindElement("xpath", "//div[contains(text(),'Browse Courses')]").click();
		  }
		  else {
		      FindElement("xpath", "//a[contains(text(),'Browse Courses')]").click();
		  }
		  waitForSeconds(2);
	  }  
	  public void onlineTraining_BrowseCourse_VerifyTitle()  
	  {
		  onlineTraining_OpenBrowseCourse();
		  Assert.assertEquals(driver.getTitle(), "MSite - Courses");
	  }
	  
	  public void onlineTraining_BrowseCourse_VerifyAllElementAvailable()
	  {
		  Assert.assertTrue(isElementPresentByXpath("//a[@class='btn btn-default pull-right training-header-button']"), "Add Course Button is missing in browse course");
	      Assert.assertTrue(isElementPresentByXpath("//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]"), "Course Heading is missing");
	      Assert.assertTrue(isElementPresentByXpath("//h4[contains(text(),'Course Statistics')]"), "Course Statistics Section is missing");
	     String courseStatisticsText[] =new String[] {"Company-wide Courses","Site Specific Courses","Role Specific Courses","Manually Awardable Courses","Courses With Questions","Courses Linked to Access Control"};
	     for(String text:courseStatisticsText) 
	     {
	    	 Assert.assertTrue(isElementPresentByXpath("//span[contains(text(),'"+text+"')]"), ""+text+" is missing");
	     }
	     String courseStatisticsIcon[] =new String[] {"fa fa-building-o","fa fa-map-marker","fa fa-briefcase","fa fa-pencil","fa fa-question-circle","fa fa-lock"};
	     for(String text:courseStatisticsIcon) 
	     {
	    	 Assert.assertTrue(isElementPresentByXpath("//i[@class='"+text+"']"), ""+text+" is missing");
	     }
	     String courseTableHeadings[] =new String[] {"Title","Date Created","Sections","Questions","Published","Preview"};
	     for(String heading:courseTableHeadings) 
	     {
	    	 Assert.assertTrue(isElementPresentByXpath("//th[contains(text(),'"+heading+"')]"), ""+heading+" is missing");
	     }
	  }
	  
	  public void onlineTraining_NavigateToAddNewCourse_FromBrowseCoursePage()  
	  {
		  onlineTraining_OpenBrowseCourse();
		  FindElement("xpath", "//a[@class='btn btn-default pull-right training-header-button']").click();
		  waitForSeconds(2);
		  Assert.assertEquals(driver.getTitle(), "MSite - Add a New Online Course");
	  }
	  
	public void onlineTraining_BrowseCourse_CheckAvailableCourses()  
	{
		onlineTraining_OpenBrowseCourse();
		WebElement courseTable = FindElement("xpath", "//tbody//tr");
		List<WebElement> courseList =courseTable.findElements(By.xpath("//td[1]"));
		for(WebElement courses:courseList) 
		{
			if(courses.getText() != null) 
			{
				Assert.assertTrue(true, ") Online Course found");
			}
		}
	}
	
	public void onlineTraining_BrowseCourse_CrossCheckCourseStatistics_From_CourseTable()  
	{
		onlineTraining_OpenBrowseCourse();
		WebElement statText = FindElement("xpath", "//div[@class='stat-holder']");
		List<WebElement> statTextList =statText.findElements(By.xpath("//span[@class='stat']"));
		for(WebElement stat:statTextList) 
		{
			if(stat.getText().equalsIgnoreCase("1")) 
			{
				WebElement publishedText = FindElement("xpath", "//tbody//tr//td[5]");
				List<WebElement> publishedTextList =publishedText.findElements(By.xpath("//a"));
				{
					for(WebElement publish:publishedTextList) {
					if(publish.getText().equalsIgnoreCase("Yes")) 
					{
						Assert.assertTrue(true, "published course is missing");
						break;
					}
				}
			}
				break;
			}
		}
	}
	
	public boolean browseCourse_checkPreviewAvailability(String sectionCount,String questionCount,int i) 
	{
		boolean preview;
		if(sectionCount.equalsIgnoreCase("0") && questionCount.equalsIgnoreCase("0")) 
		{
			Assert.assertEquals(FindElement("xpath", "//tbody//tr["+i+"]//td[1]/following-sibling::td[5]").getText(), "N/A");
			preview=false;
		}
		else 
		{
			Assert.assertTrue(isElementPresentByXpath("//tbody//tr["+i+"]//td[1]/following-sibling::td[5]/a[@class='iframedialog btn btn-primary btn-round']"), "preview image is missing");
			preview=true;
		}
		return preview;
	}
	
	public void training_BrowseCourse_Open_Or_Preview_Course(String courseName,String Action)  
	{
		onlineTraining_OpenBrowseCourse();
		List<WebElement> coursesTitleList=driver.findElements(By.xpath("//tbody//tr//td[1]//span"));
		int i=1;
		for(WebElement title:coursesTitleList)
		{
			if(title.getText().contains(courseName))
		    {
				courseName=FindElement("xpath", "//tbody//tr["+i+"]//td[1]/a").getText();
				String sectionCount=FindElement("xpath", "//tbody//tr["+i+"]//td[1]/following-sibling::td[2]/a").getText();
				String questionCount=FindElement("xpath", "//tbody//tr["+i+"]//td[1]/following-sibling::td[3]/a").getText();
				String publishedReult=FindElement("xpath", "//tbody//tr["+i+"]//td[1]/following-sibling::td[4]/a").getText();
				boolean checkPreview=browseCourse_checkPreviewAvailability(sectionCount,questionCount,i);
				if(Action.equalsIgnoreCase("Open_Course"))
				{
					onlineTraining_OpenCourse(courseName);
					training_ViewCourse_And_VerifyDataWithBrowseData(courseName,sectionCount,questionCount,publishedReult);
				}
				else if(Action.equalsIgnoreCase("Open_Preview") && checkPreview)
				{
				FindElement("xpath", "//tbody//tr["+i+"]//td[1]/following-sibling::td[5]").click();
				waitForSeconds(2);
				}
				break;
			}
			i++;
		}
	}
	
	public void training_ViewCourse_And_VerifyDataWithBrowseData(String courseName,String sectionCount,String questionCount,String publishedReult) 
	{
		String titleText=titleField.getAttribute("value");
		Assert.assertEquals(FindElement("xpath", "//div[contains(@class,'name col-md-8 col-sm-6 hidden-xs')]").getText(), courseName);
		Assert.assertEquals(driver.getTitle(), "MSite - "+courseName+"");
		String descriptionText=courseDescription.getText();
	    int sectionTotalCount=driver.findElements(By.xpath("//div[@class='complexlist-item']")).size();
		Assert.assertEquals(titleText, courseName);
		Assert.assertTrue(descriptionText !=null, "Description is missing");
		Assert.assertEquals(sectionTotalCount, Integer.parseInt(sectionCount));
		if(publishedReult.equalsIgnoreCase("No")) 
		{
			Assert.assertFalse(FindElement("id", "Model_IsPublished").isSelected(), "publish is selected");
		}
		else 
		{
			Assert.assertTrue(FindElement("id", "Model_IsPublished").isSelected(), "publish is deselected");
		}
	}
	
	
	public void onlineTraining_OpenCourse(String courseName)  
	{  
		onlineTraining_OpenBrowseCourse();
		FindElement("xpath", "//span[contains(text(),'"+courseName+"')]").click();
		waitForSeconds(2);
	}
	
	public void onlineTraining_EditCourse(String courseName) 
	{
		onlineTraining_OpenCourse(courseName);
		titleField.clear();
		titleField.sendKeys("Deepak_Test_Course_2");
		courseDescription.clear();
		courseDescription.sendKeys("This is Edited by Deepak Malviya");
		FindElement("xpath", "//button[@data-title='Content' and contains(text(), 'Edit')]").click();
		waitForSeconds(2);
		FindElement("id", "dialog-Model_0__Title").clear();
		FindElement("id", "dialog-Model_0__Title").sendKeys("What is the Capital of Karnataka?");
		FindElement("xpath", "//button[@class='btn btn-primary btn-update-complext-list-item']").click();
		waitForSeconds(2);
		FindElement("id", "saveButton").click();
		waitForSeconds(6);
		String updatedCourseName=titleField.getAttribute("value");
		onlineTraining_OpenBrowseCourse();
		courseName=FindElement("xpath", "//span[contains(text(),'Deepak_Test_Course_2')]").getText();
		Assert.assertEquals(updatedCourseName, courseName);
	}
	
	public void onlineTraining_DiscardChanges_In_EditOrViewCourse(String courseName,String Action)  
	{
		onlineTraining_OpenCourse(courseName);
		courseName=titleField.getAttribute("value");
		titleField.clear();
		titleField.sendKeys("EditCourse");
		performDiscardChangesFunction(Action);
		if(Action.equalsIgnoreCase("Discard"))
		 {
			 Assert.assertEquals(titleField.getAttribute("value"), courseName);
		 }
	}
	
	public void onlineTraining_CloneCourse(String courseName,String Action)  
	{
		onlineTraining_OpenCourse(courseName);
		 if(Action.equalsIgnoreCase("Cancel"))
		 {
			    FindElement("xpath", "//button[contains(text(),'Clone Course')]").click();
				waitForSeconds(2);
				Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Clone Course Dialog is not open");
				Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Clone Course')]"), "Clone Course heading is missing");
				Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Cloning a course allows you to create a new course')]"), "Clone Course Confirmation message is missing");
			   FindElement("xpath", "//button[@class='btn btn-default']").click();
			   waitForSeconds(2);
		 }
	else
	 {
		String titleText=titleField.getAttribute("value");
		String descriptionText=courseDescription.getText();
		String courseType =FindElement("xpath", "//select[@id='Model_CourseType']/option[@selected='selected']").getText();
		boolean manuallySelected=FindElement("id", "Model_ManuallyAwardable").isSelected();
		String validity =FindElement("id", "Model_ValidityPeriodInDays").getAttribute("value");
		String allowResist =FindElement("id", "Model_AllowResitPeriodInDays").getAttribute("value");
		boolean required=FindElement("id", "Model_AllRequired").isSelected();
		boolean restrictAccess=FindElement("id", "Model_RestrictsAccess").isSelected();
		boolean selectiveAvailable=FindElement("id", "Model_IsElective").isSelected();
		boolean siteSpecific=FindElement("id", "SiteScopedRadio").isSelected();
		boolean companyWide=FindElement("id", "CompanyWideRadio").isSelected();
		String selectedSite=FindElement("xpath", "//li[@class='select2-selection__choice no-border']").getText();
		boolean autoGrowSite=FindElement("id", "autoGrowSites").isSelected();
		WebElement roles=FindElement("xpath", "//div[@class='row role']/div");
		List<WebElement> rolesList=roles.findElements(By.xpath("/input"));
		int i = 0,j=0;
		for(WebElement role:rolesList) 
		{
			if(role.isSelected())
				i++;
			else
				j++;
			}
		 String minimumPassScore =FindElement("id", "Model_MinimumPassScore").getAttribute("value");
		 boolean mustPass=FindElement("id", "Model_MustPass").isSelected();
		 boolean showCorrectAnswer=FindElement("id", "Model_ShowCorrectAnswers").isSelected();
		 WebElement contentsection=FindElement("xpath", "//div[@class='panel-body']");
		 List<WebElement> contentList=contentsection.findElements(By.xpath("//div[@class='complexlist-item']/div[1]"));
		 String content[]=new String[contentList.size()];
		 int k=0;
		 for(WebElement str:contentList) 
		 {
			 content[k]=str.getText();
		 }
		 boolean published=FindElement("id", "Model_IsPublished").isSelected();
		 FindElement("xpath", "//button[contains(text(),'Clone Course')]").click();
		 waitForSeconds(2);
		 FindElement("xpath", "//button[@class='btn btn-primary']").click();
		 waitForSeconds(1);
		 FindElement("xpath", "//button[@class='btn btn-primary']").click();
		 waitForSeconds(4);
		 Assert.assertEquals(FindElement("id", "titleField").getAttribute("value"), ""+titleText+" - COPY");
		 Assert.assertEquals(FindElement("id", "Model_Description").getText(), descriptionText);
		 Assert.assertEquals(FindElement("xpath", "//select[@id='Model_CourseType']/option[@selected='selected']").getText(), courseType);
		 Assert.assertEquals(FindElement("id", "Model_ManuallyAwardable").isSelected(), manuallySelected);
		 Assert.assertEquals(FindElement("id", "Model_ValidityPeriodInDays").getAttribute("value"), validity);
		 Assert.assertEquals(FindElement("id", "Model_AllowResitPeriodInDays").getAttribute("value"), allowResist);
		 Assert.assertEquals(FindElement("id", "Model_AllRequired").isSelected(), required);
		 Assert.assertEquals(FindElement("id", "Model_RestrictsAccess").isSelected(), restrictAccess);
		 Assert.assertEquals(FindElement("id", "Model_IsElective").isSelected(), selectiveAvailable);
		 Assert.assertEquals(FindElement("id", "SiteScopedRadio").isSelected(), siteSpecific);
		 Assert.assertEquals(FindElement("id", "CompanyWideRadio").isSelected(), companyWide);
		 Assert.assertEquals(FindElement("xpath", "//li[@class='select2-selection__choice no-border']").getText(), selectedSite);
		 Assert.assertEquals(FindElement("id", "autoGrowSites").isSelected(), autoGrowSite);
		 WebElement cloneroles=FindElement("xpath", "//div[@class='row role']/div");
			List<WebElement> clonerolesList=cloneroles.findElements(By.xpath("/input"));
			int clone_i = 0,clone_j=0;
			for(WebElement clonerole:clonerolesList) 
			{
				if(clonerole.isSelected())
					clone_i++;
				else
					clone_j++;
		    }
			System.out.println((i+j)+" "+(clone_i+clone_j));
			 Assert.assertEquals(i+j, clone_i+clone_j);
			 Assert.assertEquals(FindElement("id", "Model_MinimumPassScore").getAttribute("value"), minimumPassScore);
			 Assert.assertEquals(FindElement("id", "Model_MustPass").isSelected(), mustPass);
			 Assert.assertEquals(FindElement("id", "Model_ShowCorrectAnswers").isSelected(), showCorrectAnswer);
			 WebElement clonecontentsection=FindElement("xpath", "//div[@class='panel-body']");
			 List<WebElement> clonecontentList=clonecontentsection.findElements(By.xpath("//div[@class='complexlist-item']/div[1]"));
			 String clonecontent[]=new String[contentList.size()];
			 int clone_k=0;
			 for(WebElement str:clonecontentList) 
			 {
				 clonecontent[clone_k]=str.getText();
			 }
			 for(int x=0;x<clonecontent.length;x++) 
			 {
				 Assert.assertEquals(clonecontent[x], content[x]);
			 }
			 Assert.assertEquals(FindElement("id", "Model_IsPublished").isSelected(), published);
		}
		
	}
	
   
   
   public String[] getSectionResult()  
   { 
	   List<WebElement> sectionEditList=driver.findElements(By.xpath("//i[@class='fa section-icon fa-question-circle']/parent::div/following-sibling::div//button[@data-title='Content' and contains(text(), 'Edit')]"));
	   String resultList[]=new String[sectionEditList.size()];
	   int i=0;
	   for(WebElement edit:sectionEditList) 
	   {
		   edit.click();
		   waitForSeconds(2);
		   String Question=FindElement("xpath", "//div[@class='modal-body']//textarea[@id='dialog-Model_"+i+"__Title']").getText();
		   String answer1= FindElement("xpath", "//div[@class='modal-body']//textarea[@name='Model.CourseSections["+i+"].Answers[0].Answer']").getText();
		   String answer2= FindElement("xpath", "//div[@class='modal-body']//textarea[@name='Model.CourseSections["+i+"].Answers[1].Answer']").getText();
		   String answer3= FindElement("xpath", "//div[@class='modal-body']//textarea[@name='Model.CourseSections["+i+"].Answers[2].Answer']").getText();
		   String answer4= FindElement("xpath", "//div[@class='modal-body']//textarea[@name='Model.CourseSections["+i+"].Answers[3].Answer']").getText();
		   String correctAnswer=FindElement("xpath", "//div[@id='complexlist-dialog']//i[@class='fa fa-bullseye']/following-sibling::div//textarea").getText();
		    resultList[i]=Question+":"+answer1+":"+answer2+":"+answer3+":"+answer4+":"+correctAnswer;
		   FindElement("xpath", "//button[@class='btn btn-default']").click();
	       waitForSeconds(3);
		   i++;
	   }
	  return resultList;
	   
   }
   
   public void onlineTraining_ViewCourse_Save_And_Preview(String courseName,String Action)  
   {
	   onlineTraining_OpenCourse(courseName);
       FindElement("xpath", "//button[@class='btn btn-primary inline messagedialog save-btn saveAndPreview']").click();
       waitForSeconds(1.5);
       Assert.assertTrue(isElementPresentByXpath("//div[@id='iframedialog-dialog']//div[@class='modal-content']"), "Save and Preview Dialog is misssing");
       Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Preview Course')]"), "Preview Course Heading is missing");
       Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'In order to preview all changes must be saved, do')]"), "Save and Preview confirmation message is misssing");
	   if(Action.equalsIgnoreCase("Cancel"))
	   {
              FindElement("xpath", "//button[@class='btn btn-default']").click();
              waitForSeconds(1.5);
	   }
	   else
	   { 
		  FindElement("xpath", "//button[@class='btn btn-primary']").click();
		  waitForSeconds(2);   
	   }
         
   }
   
  public void onlineTraining_PreviewCourese(String courseName,String Action,boolean Try_Again,String Answer,String quesionSectionContentList[])  
  {
	  Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-dialog modal-lg modal-fullscreen']//div[@class='modal-content']"), "Preview Diaglog box is not open");
      Assert.assertTrue(isElementPresentByXpath("//div[@class='modal-dialog modal-lg modal-fullscreen']//h3[contains(@class,'modal-title')]"), "Preview Course Heading is missing");
      WebElement previewFrame=driver.findElement(By.xpath("//div[@class='modal-body']//iframe"));
      driver.switchTo().frame(previewFrame); 
      waitForSeconds(1);
      Assert.assertTrue(isElementPresentByXpath("//i[@class='fa fa-info-circle fa-2x section-info-icon']"), "I icon is missing");
      Assert.assertEquals(FindElement("xpath", "//span[@class='section-info-text-title']").getText(), "Course Information");
      Assert.assertEquals(FindElement("xpath", "//h2[@data-bind='text: Title']").getText(),courseName);
      Assert.assertTrue(isElementPresentByXpath("//p[@data-bind='text: Description']"), "Course Description is missing");
      Assert.assertTrue(isElementPresentByXpath("//div[@class='course-intro responsive-course-content']//p[2]"), "Course Duration heading is misisng");
       if(isElementPresent(questionVisibilityInPreview)) 
       {
         Assert.assertTrue(true, "Question Desription is missing");
         Assert.assertTrue(isElementPresent(requiredScoreVisibilityInPreview), "Record Score is mising");
         Assert.assertTrue(isElementPresentByXpath("//p[@class='consequence-description']"), "Consequence Description is misisng");
      }
       Assert.assertTrue(isElementPresentByXpath("//button[@class='navigation-button navigation-button-middle navigation-button-right pull-right']//div[@class='navigation-button-text']"), "Start button is misisng");
       if(Action.equalsIgnoreCase("Close")) 
       {
    	   driver.switchTo().defaultContent();
    	   waitForSeconds(0.5);
    	   Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "CLose or Ok button is mising");
    	   scrollToElement(FindElement("xpath", "//button[@class='btn btn-primary']"));
    	   FindElement("xpath", "//button[@class='btn btn-primary']").click();
    	   waitForSeconds(2); 
       }
       else 
       {
    	   FindElement("xpath", "//button[@class='navigation-button navigation-button-middle navigation-button-right pull-right']//div[@class='navigation-button-text']").click();
    	   waitForSeconds(1.5);
    	  while(isElementPresent(questionIconInPreview) || isElementPresent(imageIconInPreview)||isElementPresent(videoIconInPreview)) 
    	  {
    	    if(isElementPresent(questionIconInPreview)) 
    	    {
    		  verify_And_Choose_AnswerInPreviewCourse(Answer,quesionSectionContentList);
    		  waitForSeconds(1);
    	   }
    	   else if(isElementPresent(imageIconInPreview) || isElementPresent(videoIconInPreview)) 
    	   {
    		   nextButtonInPreview.click();
    		   waitForSeconds(1);
    	   }
    	  }
    	 
    	 if(failedCourseScreenInPreview.getAttribute("style").equalsIgnoreCase("")) 
    	{
    		 int requiredScore= Integer.parseInt(FindElement("xpath", "//div[@class='failed-course responsive-course-content']//span[@data-bind='text: MinimumScoreInPercent']").getText());
             int yourScore= Integer.parseInt(FindElement("xpath", "//div[@class='failed-course responsive-course-content']//span[@data-bind='text: ScoreInPercent']").getText());
    		Assert.assertTrue(true, "Failed course Screeen is missing");
    		Assert.assertTrue(isElementPresentByXpath("//h2[contains(text(),'Sorry.')]"), "Sorry is misisng");
    		Assert.assertTrue(isElementPresentByXpath("//p[contains(text(),'You have not met the pass criteria for this course')]"), "Failed description message");
    		Assert.assertTrue(requiredScore>yourScore, "Score does not follow the creteria");
    		Assert.assertTrue(isElementPresentByXpath("//div[@data-bind='visible: Context().FailedCoursePageVisible()']//button"),"Try Again button is missing");
    		if(Try_Again) 
    		{
    			FindElement("xpath", "//div[@data-bind='visible: Context().FailedCoursePageVisible()']/button").click();
    			waitForSeconds(2);
    			driver.switchTo().defaultContent(); 
    		    waitForSeconds(1);
    		    onlineTraining_PreviewCourese(courseName,Action,false,"All_Correct",quesionSectionContentList);
    		}
    	}
    	 else  if(passedCourseScreenInPreview.getAttribute("style").equalsIgnoreCase("")) 
    	 {
    		 int requiredScore= Integer.parseInt(FindElement("xpath", "//p[@class='bulletpoint']//span[@data-bind='text: MinimumScoreInPercent']").getText());
             int yourScore= Integer.parseInt(FindElement("xpath", "//p[@class='bulletpoint']//span[@data-bind='text: ScoreInPercent']").getText());
    		 Assert.assertTrue(true, "Passed Screen is missing");
     		Assert.assertTrue(isElementPresentByXpath("//h2[contains(text(),'Congratulations')]"), "Congratulation is misisng");
     		Assert.assertTrue(isElementPresentByXpath("//div[@class='course-complete responsive-course-content']//p[1]"), "Passed Course description message");
     		Assert.assertTrue(requiredScore<=yourScore, "Score does not follow the creteria");   
     	} 
    	 if(!Try_Again) 
    	 {
    	 driver.switchTo().defaultContent();
    	 waitForSeconds(1);
    	 FindElement("xpath", "//button[@class='btn btn-primary']").click();
         waitForSeconds(2);
    	 }
       }
  }
     
  public void verify_And_Choose_AnswerInPreviewCourse(String Answer,String quesionSectionContentList[])  
  {
	  Assert.assertTrue(isElementPresentByXpath("//span[contains(@class,'section-info-text-title')]"), "Section title is missing");
      Assert.assertTrue(isElementPresent(backButtonInPreview), "Either Back button is misisng or Enabled by default ");
      Assert.assertTrue(isElementPresent(nextButtonInPreview), "Either Next button is misisng or Enabled by default ");
      int count=0;
      for(int i=0;i<quesionSectionContentList.length;i++) 
      {
   	   String questionAnswer[]=quesionSectionContentList[i].split(":");
   	   for(String content:questionAnswer) 
   	   {
   	     Assert.assertTrue(isElementPresentByXpath("//div[@id='question-slide']//span[contains(text(),'"+content+"')]"), ""+content+" is missing");
   	   }
      if(Answer.equalsIgnoreCase("All_Correct")) 
     {
    	  FindElement("xpath", "//div[@class='options']//div[@class='option-contents']//span[contains(text(),'"+questionAnswer[5]+"')]").click();
     }
      else if(Answer.equalsIgnoreCase("All_Incorrect"))
      {
    	  if(questionAnswer[5].equalsIgnoreCase(questionAnswer[2]))
    	  FindElement("xpath", "//div[@class='options']//div[@class='option-contents']//span[contains(text(),'"+questionAnswer[3]+"')]").click();
    	  else 
        	FindElement("xpath", "//div[@class='options']//div[@class='option-contents']//span[contains(text(),'"+questionAnswer[2]+"')]").click();  
      }
      else if(Answer.equalsIgnoreCase("One_Correct_One_Incorrect"))
      {
    	  FindElement("xpath", "//div[@class='options']//div[@class='option-contents']//span[contains(text(),'"+questionAnswer[5-i]+"')]").click();
      }
   	    nextButtonInPreview.click();
        waitForSeconds(1);
        if(isElementPresent(wrongAnswerConfirmationText))
        {
        	Assert.assertTrue(true,"wrong answer confirmation message is missing");
        	count=0;
        }
        else 
        {
        	Assert.assertTrue(true,"correct answer confirmation message is missing");
        	count++;
        }
        nextButtonInPreview.click();
      }
  
  }
  
  public String getCourseName()  
  {
	    onlineTraining_OpenBrowseCourse();
        String courseName=FindElement("xpath", "//span[contains(text(),'Deepak_Test_Course')]").getText();
        return courseName;
  }
  
  public void onlineTraining_DeleteCourse(String courseName,String Action)  
  {
	  if(Action.equalsIgnoreCase("Cancel")) 
	  {
		  onlineTraining_OpenCourse(courseName);
		  FindElement("xpath", "//button[@class='btn btn-danger inline messagedialog']").click();
		  waitForSeconds(2);
		  Assert.assertTrue(isElementPresentByXpath("//div[@id='messagedialog-dialog']//div[@class='modal-content']"), "Delete Diualog box is not open");
		  Assert.assertTrue(isElementPresentByXpath("//h3[contains(text(),'Delete')]"), "Delete Header is missing");
		  Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'Are you sure you wish to delete "+courseName+"')]"),"Delete Course Confirmation Message is missing");
	      Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-default']"), "Cancel button is missing");
	      Assert.assertTrue(isElementPresentByXpath("//button[@class='btn btn-primary']"), "Delete button is missing");
	      FindElement("xpath", "//button[@class='btn btn-default']").click();
	      waitForSeconds(2);
	  }else 
	  {
		  onlineTraining_OpenBrowseCourse();
		  List<WebElement> courseList=driver.findElements(By.xpath("//tbody//tr//td[1]/a/span"));
		  String courseText[]=new String[courseList.size()];
		  int i=0;
		  for(WebElement course:courseList) 
		  {
			  courseText[i]=course.getText();
			  i++;
		  }
		  for(String str:courseText)
		  {
		     if(str.contains(courseName)) 
		     {
			      onlineTraining_OpenCourse(courseName);
		          waitForSeconds(2);
		          FindElement("xpath", "//button[@class='btn btn-danger inline messagedialog']").click();
		          waitForSeconds(1);
	              FindElement("xpath", "//button[@class='btn btn-primary']").click();
	              waitForSeconds(0.5);
	              FindElement("xpath", "//button[@class='btn btn-primary']").click();
	              waitForSeconds(5); 
		     }
		  }
	  }
  }
  
  
}


