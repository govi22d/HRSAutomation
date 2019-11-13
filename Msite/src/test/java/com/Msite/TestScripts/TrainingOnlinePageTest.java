package com.Msite.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Msite.Pages.MsiteLoginPage;
import com.Msite.Pages.TrainingOnlinePage;

public class TrainingOnlinePageTest extends BaseClass
{
	public void confirmLogin() 
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		if(driver.getTitle().equalsIgnoreCase("MSite - Login"))
		{
			mlp.enterUsername(username);
			mlp.enterPassword(password);
			mlp.clickOnSignIn();
		}
	}
	
	
	@Test (priority=1)
	public void training_OpenOnlineTrainingFromDropDown_And_VerifyTilte() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		tp.clickOnAllowCookies();
		tp.openOnlineTraining();
		tp.verifyOnlineTrainingTitle();
	}
	
	@Test (priority=2)
	public void onlineTraining_OpenDashboard_And_VerifyAllElementInDashboard() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Verifying All Avaialble Element in Training Dashboard Page");
		tp.VerifyAllElementInTrainingDashboard();
	}
	
	@Test (priority=3)
	public void onlineTraining_OpenDashboard_And_NavigateToTrainingAnalytics_FromDashboard() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Verifying Navigation to Training Analytics Page from Dahboard Page");
		tp.onlineTraining_NavigationFromDashbaord("Training Analytics");
	}
	
	@Test (priority=4)
	public void onlineTraining_OpenDashboard_And_NavigateToBrowseCourse_FromDashboard() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Verifying Navigation to Browse Course Page from Dahboard Page");
		tp.onlineTraining_NavigationFromDashbaord("Browse Courses");
	}
	
	@Test (priority=5)
	public void onlineTraining_OpenDashboard_And_NavigateToAddANewCourse_FromDashboard() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Verifying Navigation to Add a New Course Page from Dahboard Page");
		tp.onlineTraining_NavigationFromDashbaord("Add a New Course");
	}
	
	@Test (priority=6)
	public void onlineTraining_OpenTrainingAnalytics_And_VerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Training Analytics Page");
		tp.onlineTraining_OpenTrainingAnalytics();
		Reporter.log("Verifying Training Analytics Page Tilte");
		tp.onlineTraining_VerifyTrainingAnalyticsTitle();
	}
	
	@Test (priority=7)
	public void onlineTraining_OpenTrainingAnalytics_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Training Analytics Page");
		tp.onlineTraining_OpenTrainingAnalytics();
		Reporter.log("Verifying All Avaialable Element Present In Training Analytics Page");
		tp.onlineTraining_VerifyAllElementIn_TrainingAnalytics();
	}
	
	@Test (priority=8)
	public void onlineTraining_OpenTrainingAnalytics_And_ViewReports() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Training Analytics Page");
		tp.onlineTraining_OpenTrainingAnalytics();
		Reporter.log("Opening Online Training Report and Verifying Title");
		tp.onlineTraining_TrainingAnalytics_ViewOnlineTrainingReport();
	}
	
	@Test (priority=9)
	public void onlineTraining_OpenTrainingAnalytics_And_InviteTable_ChangeByContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Training Analytics Page");
		tp.onlineTraining_OpenTrainingAnalytics();
		Reporter.log("Verifying Invitable Data is changing by Changing Contractor");
		tp.onlineTraining_TrainingAnalytics_InviteTable_ChangeByContractor("Deepak_Automation_Contractor");
	}
	
	@Test (priority=10)
	public void onlineTraining_OpenAddANewOnlineCoures_And_VerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Verifying Add New Online Course Title Page");
		tp.onlineTraining_VerifyAddNewOnlineCourseTitle();
	}
	
	@Test (priority=11)
	public void onlineTraining_OpenAddANewOnlineCoures_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Verifying All Available Element in Add New Course Page");
		tp.onlineTraining_VerifyAllElementInAddANewOnlineCourse();
	}
	
	@Test (priority=12)
	public void onlineTraining_AddANewOnlineCoures_AddEmptyCourse_NotAdded() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Ading A Empty New Course ,All Mandatory Fields are Highlighted in Red Color");
		tp.onlineTraining_AddEmptyOnlineCourse_NotAdded();
	}
	
	@Test (priority=13)
	public void onlineTraining_AddANewOnlineCoures_CheckCreateButtonEnability_InAddANewOnlineCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Checking Enability of Create Button in Add New Course");
		tp.onlineTraining_CheckCreateButtonEnability_InAddANewOnlineCourse();
	}
	
	@Test (priority=14)
	public void onlineTraining_AddANewOnlineCoures_CheckInvalidValidityPeriodDays() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Checking invalidity of Validity Periods of Days");
		tp.addNewClassroomCourse_InvalidValidityPeriodDays_NotCreated();
	}
	
	@Test (priority=15)
	public void onlineTraining_AddANewOnlineCoures_CancelIn_DiscardChangesWithData() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.discardChangesWithData("Cancel");
		Reporter.log("Clicking on Cancel in Discard Change Dialog,Dialog is closed and No Changes");
	}
	
	@Test (priority=16)
	public void onlineTraining_AddANewOnlineCoures_DiscardIn_DiscardChangesWithData() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.discardChangesWithData("Discard");
		Reporter.log("Clicking on Discard in Discard Change Dialog,Dialog is closed and verified Changes");
	}
	
	@Test (priority=17)
	public void onlineTraining_AddANewOnlineCoures_CheckInvalidMinimumPassScore() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Verifying invalid Minimum Pass Score in Add New Course");
		tp.addNewClassroomCourse_InvalidMiminumPassScore_NotCreated();
	}
	
	
	@Test (priority=18)
	public void onlineTraining_AddANewOnlineCoures_OpenAddQuestion_AndVerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddQuestion_VerifyAllElement();
		Reporter.log("Opening  Add New Question Dialog and Verifying All Avalibale Element");
	}
	
	@Test (priority=19)
	public void onlineTraining_AddANewOnlineCoures_AddQuestion_UnableToSelectBlankAnswer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		tp.onlineTraining_OpenAddANewOnlineCourse();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_AddQuestion_UnableToSelectBlankAnswer();
		Reporter.log("Checking Selection of inactive Answer Selection");
	}
	
	@Test (priority=20)
	public void onlineTraining_AddANewOnlineCoures_AddQuestion_OnlyOneAnswerSelected() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		tp.onlineTraining_AddQuestion_OnlyOneAnswerSelected();
		Reporter.log("Verifying Only One Answer is selected at atime in Add New Question Dailog");
	}
	
	@Test (priority=21)
	public void onlineTraining_AddANewOnlineCoures_AddQuestion_Cancel_NotAdded() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_Content_AddQuestion_Cancel_NotAdded();
		Reporter.log("Clicking on Cancel in Add New Question Dialog,Dialog is Closed and No Question is Created");
	}
	
	@Test (priority=22)
	public void onlineTraining_AddANewOnlineCoures_AddQuestion_Added() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_Content_AddQuestion();
		Reporter.log("Clicking on Added in Add New Question Dialog,Dialog is Closed and Question is Created");
	}
	
	@Test (priority=23)
	public void onlineTraining_AddANewOnlineCoures_EditAddQuestion_Cancel_NotAdded() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Creating a Question");
		tp.onlineTraining_Content_Edit_Or_Delete_AddQuestion("Edit","Cancel");
		Reporter.log("Clicking on Cancel in Edit  Question Dialog,Dialog is Closed and No Question is Edited");
	}
	
	@Test (priority=24)
	public void onlineTraining_AddANewOnlineCoures_EditAddQuestion_Added() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Createing a Question");
		tp.onlineTraining_Content_Edit_Or_Delete_AddQuestion("Edit","Edit");
		Reporter.log("Clicking on Edit in Edit Question Dialog,Dialog is Closed and  Question is Edited");
	}
	
	@Test (priority=25)
	public void onlineTraining_AddANewOnlineCoures_DeleteAddQuestion_Cancel_NotDelete() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page And Creating A Question");
		tp.onlineTraining_Content_Edit_Or_Delete_AddQuestion("Delete","Cancel");
		Reporter.log("Clicking on Cancel in Delete Question Dialog,Dialog is Closed and No Question is Deleted");
	}
	
	@Test (priority=26)
	public void onlineTraining_AddANewOnlineCoures_DeleteAddQuestion_Deleted() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Creating a Question");
		tp.onlineTraining_Content_Edit_Or_Delete_AddQuestion("Delete","Delete");
		Reporter.log("Clicking on Delete in Delete Question Dialog,Dialog is Closed and No Question is Delete");
	}
	
	@Test (priority=27)
	public void onlineTraining_AddANewOnlineCoures_OpenAddSection_AndVerifyAllElement() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddSection_VerifyAllElement();
		Reporter.log("Opening Add NEw Section And Verifying All Availabale Elements");
	}
	
	@Test (priority=28)
	public void onlineTraining_AddANewOnlineCoures_Content_AddEmptySection_NotAdded() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_Content_AddEmptySection_NotAdded();
		Reporter.log("Adding Empty Section in Content,Not Created");
	}
	
	@Test (priority=29)
	public void onlineTraining_AddANewOnlineCoures_AddSection_Cancel_NotAdded() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page,and Open Add section");
		tp.onlineTraining_Content_AddSection_Cancel_NotAdded();
		Reporter.log("Clicking on Cancel in Add New Section Dialog,Dialog is Closed and No Section is Created");
	}
	
	@Test (priority=30)
	public void onlineTraining_AddANewOnlineCoures_AddSection_Added() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_Content_AddSection_Added();
		Reporter.log("Clicking on Add in Add New Section Dialog,Dialog is Closed and  Section is Created");
	}
	
	@Test (priority=31)
	public void onlineTraining_AddANewOnlineCoures_EditAddSection_Cancel_NotAdded() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Creating a Section");
		tp.onlineTraining_Content_Edit_Or_Delete_AddSection("Edit","Cancel");
		Reporter.log("Clicking on Cancel in Edit Section Dialog,Dialog is Closed and No Section is Edited");
	}
	
	@Test (priority=32)
	public void onlineTraining_AddANewOnlineCoures_EditAddSection_Added() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Creating a Section");
		tp.onlineTraining_Content_Edit_Or_Delete_AddSection("Edit","Edit");
		Reporter.log("Clicking on Edit in Edit Section Dialog,Dialog is Closed and  Section is Edited");
	}
	
	@Test (priority=33)
	public void onlineTraining_AddANewOnlineCoures_DeleteAddSection_Cancel_NotDelete() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Creating a Section");
		tp.onlineTraining_Content_Edit_Or_Delete_AddSection("Delete","Cancel");
		Reporter.log("Clicking on Cancel in Delete Section Dialog,Dialog is Closed and not Section is Delete");
	}
	
	@Test (priority=34)
	public void onlineTraining_AddANewOnlineCoures_DeleteAddSection_Deleted() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page and Creating a Section");
		tp.onlineTraining_Content_Edit_Or_Delete_AddSection("Delete","Delete");
		Reporter.log("Clicking on Delete in Delete Section Dialog,Dialog is Closed and  Section is Deleted");
	}
	
	@Test (priority=35)
	public void onlineTraining_AddANewOnlineCoures_NoContent_UnableToPublish() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		tp.onlineTraining_AddNewCourse_Publish(false);
		Reporter.log("Verifying Publish Button Visibility without Any Content");
	}
	
	@Test (priority=36)
	public void onlineTraining_AddANewOnlineCoures_Content_EnableToPublish() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_OpenAddANewOnlineCourse();
		tp.onlineTraining_AddNewCourse_Publish(true);
		Reporter.log("Verifying Publish Button is Enable with data in Content Section");
	}
	
	@Test (priority=37)
	public void onlineTraining_AddANewOnlineCoures_Cancel_NotAdded() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_AddANewOnlineCourse_Created("Deepak_Test_Course_1","80","Select All","All roles","50",true,true,false,"Cancel");
		Reporter.log("Clicking on Cancel in Add New Course ,Dailog is closed and No Course is added");
	}
	
	@Test (priority=38)
	public void onlineTraining_AddANewOnlineCoures_Create_Added() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Add New Online Course Page");
		tp.onlineTraining_AddANewOnlineCourse_Created("Deepak_Test_Course_1","80","Select All","All roles","50",true,true,false,"Create");
		Reporter.log("Clicking on Create in Add New Course ,Dailog is closed and  Course is added");
	}
	
	@Test (priority=39)
	public void onlineTraining_OpenBrowseCourse_And_VerifyTitle() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		tp.onlineTraining_OpenBrowseCourse();
		Reporter.log("Opening Browse Course Page and Verifying Page Title");
		tp.onlineTraining_BrowseCourse_VerifyTitle();
	}
	
	@Test (priority=40)
	public void onlineTraining_OpenBrowseCourse_And_VerifyAllElementAvailable() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		tp.onlineTraining_OpenBrowseCourse();
		Reporter.log("Opening Browse Course Page and Verifying All Available Elements");
		tp.onlineTraining_BrowseCourse_VerifyAllElementAvailable();
	}
	
	@Test (priority=41)
	public void onlineTraining_BrowseCourse_And_NaviagteToAddANewCourseFromBrowseCourseDashboard() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course Page");
		tp.onlineTraining_NavigateToAddNewCourse_FromBrowseCoursePage();
		Reporter.log("Verifying Navigation to Add New Course From Browse Course Page");
	}
	
	@Test (priority=42)
	public void onlineTraining_BrowseCourse_And_CheckAvailableCourses() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course Page");
		tp.onlineTraining_BrowseCourse_CheckAvailableCourses();
		Reporter.log("Checking All Available Courses");
	}

	@Test (priority=43)
	public void onlineTraining_BrowseCourse_CrossCheckCourseStatistics_From_CourseTable() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		tp.onlineTraining_BrowseCourse_CrossCheckCourseStatistics_From_CourseTable();
		Reporter.log("Opening Browse Course Page and Verifying Course Statistics Data with Course Table Data");
	}
	
	@Test (priority=44)
	public void onlineTraining_ViewCourse_And_VerifyDataWith_BrowseCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course Page");
		tp.training_BrowseCourse_Open_Or_Preview_Course("Deepak_Test_Course_1","Open_Course");
		Reporter.log("Viewing a Course and Verifying Data With Browse course data");
	}
	
	@Test (priority=45)
	public void onlineTraining_Cancel_In_DiscardChanges_EditOrViewCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course Page and Open a Course");
		tp.onlineTraining_DiscardChanges_In_EditOrViewCourse("Deepak_Test_Course_1","Cancel");
		Reporter.log("Clicking on Cancel in Discard Changes, DAilog is closed and no changes reflected");
	}
	
	@Test (priority=46)
	public void onlineTraining_Discard_In_DiscardChanges_EditOrViewCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		tp.onlineTraining_DiscardChanges_In_EditOrViewCourse("Deepak_Test_Course_1","Discard");
		Reporter.log("Clicking on Discard in Discard Changes, DAilog is closed and  changes reflected");
	}
	
	@Test (priority=47)
	public void onlineTraining_EditCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course and open A course");
		tp.onlineTraining_EditCourse("Deepak_Test_Course_1");
		Reporter.log("Editing a Course and Verifying Edited Course in Browse Coure");
	}
	
	@Test (priority=48)
	public void onlineTraining_Cancel_InCloneCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course and open A course");
		tp.onlineTraining_CloneCourse("Deepak_Test_Course_2","Cancel");
		Reporter.log("Clicking on Cancel in Clone Course Dialog,Dialog is Closed and No Clone Course is created");
	}
	
	@Test (priority=49)
	public void onlineTraining_Clone_InCloneCourse_And_VerifyWithOriginalOne() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course and open A course");
		tp.onlineTraining_CloneCourse("Deepak_Test_Course_2","Clone");
		Reporter.log("Clicking on Clone in Clone Course Dialog,Dialog is Closed and  Clone Course is created");
	}
	
	@Test (priority=50)
	public void onlineTraining_Cancel_InSaveAndPreviewCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course and open A course");
		tp.onlineTraining_ViewCourse_Save_And_Preview("Deepak_Test_Course_2","Cancel");
		Reporter.log("Clicking on Cancel in Save And Preview Course Dialog,Dialog is Closed");
	}
	
	@Test (priority=51)
	public void onlineTraining_Save_And_Preview_InSaveAndPreviewCourse_Close_Preview() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		String courseName=tp.getCourseName();
		String quesionSectionContentList[]= {};
		Reporter.log("Opening Browse Course and open A course");
		tp.onlineTraining_ViewCourse_Save_And_Preview(courseName,"Continue");
		tp.onlineTraining_PreviewCourese(courseName,"Close",false,"All_Correct",quesionSectionContentList);
		Reporter.log("Clicking on Continue in Save And Preview Dialog,But Close in Preview Course Dailog ");
	}
	
	@Test (priority=52)
	public void onlineTraining_Save_And_Preview_Course_PassedCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("");
		String courseName=tp.getCourseName();
		Reporter.log("Opening Browse Course and Open A course");
		tp. onlineTraining_OpenCourse(courseName);
		String quesionSectionContentList[]=tp.getSectionResult();
		tp.onlineTraining_ViewCourse_Save_And_Preview(courseName,"Continue");
		Reporter.log("Clicking on Continue in Save And Preview Course Dailog");
		tp.onlineTraining_PreviewCourese(courseName,"Preview",false,"All_Correct",quesionSectionContentList);
		Reporter.log("Verifying Preview Course for Passed Score");
	}
	

	@Test (priority=53)
	public void onlineTraining_SaveAndPreviewCourse_FailedCourse_NoTryAgain() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		String courseName=tp.getCourseName();
		Reporter.log("Opening Browse Course and Open A course");
		tp. onlineTraining_OpenCourse(courseName);
		String quesionSectionContentList[]=tp.getSectionResult();
		tp.onlineTraining_ViewCourse_Save_And_Preview(courseName,"Continue");
		Reporter.log("Clicking on Continue in Save And Preview Course Dailog");
		tp.onlineTraining_PreviewCourese(courseName,"Preview",false,"All_Incorrect",quesionSectionContentList);
		Reporter.log("Verifying Preview Course for Failed  Score But No Try Again");
	}
	
	@Test (priority=54)
	public void onlineTraining_SaveAndPreviewCourse_FailedCourse_TryAgain() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		String courseName=tp.getCourseName();
		Reporter.log("Opening Browse Course and Open A course");
		tp. onlineTraining_OpenCourse(courseName);
		String quesionSectionContentList[]=tp.getSectionResult();
		tp.onlineTraining_ViewCourse_Save_And_Preview(courseName,"Continue");
		Reporter.log("Clicking on Continue in Save And Preview Course Dailog");
		tp.onlineTraining_PreviewCourese(courseName,"Preview",true,"All_Incorrect",quesionSectionContentList);
		Reporter.log("Verifying Preview Course for Failed Score And  Try Again course");
	}
	
	@Test (priority=55)
	public void onlineTraining_SaveAndPreviewCourse_PassedCourse_CheckCreteria() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		String courseName=tp.getCourseName();
		Reporter.log("Opening Browse Course and Open A course");
		tp. onlineTraining_OpenCourse(courseName);
		String quesionSectionContentList[]=tp.getSectionResult();
		tp.onlineTraining_ViewCourse_Save_And_Preview(courseName,"Continue");
		Reporter.log("Clicking on Continue in Save And Preview Course Dailog");
		tp.onlineTraining_PreviewCourese(courseName,"Preview",false,"One_Correct_One_Incorrect",quesionSectionContentList);
		Reporter.log("Verifying Pass Course Creteria in Preview Course");
	}
	
	@Test (priority=56)
	public void onlineTraining_Cancel_InDeleteCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course and Open A course");
		tp.onlineTraining_DeleteCourse("Deepak_Test_Course_2","Cancel");
		Reporter.log("Clicking on Cancel in Delete Course Dailog, Dailog is Closed and Course is not deleted");
	}
	
	@Test (priority=57)
	public void onlineTraining_Delete_InDeleteCourse() throws Exception
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingOnlinePage tp=new TrainingOnlinePage(driver);
		Reporter.log("Opening Online Training");
		tp.openOnlineTraining();
		Reporter.log("Opening Browse Course and Open A course");
		tp.onlineTraining_DeleteCourse("Deepak_Test_Course","Delete");
		Reporter.log("Clicking on Delete in Delete Course Dailog, Dailog is Closed and Course is deleted");
	}
}
