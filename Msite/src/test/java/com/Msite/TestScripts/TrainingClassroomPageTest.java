package com.Msite.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Msite.Pages.EmployeesPage;
import com.Msite.Pages.MsiteLoginPage;
import com.Msite.Pages.TrainingClassroomPage;

public class TrainingClassroomPageTest extends BaseClass
{
	public void confirmLogin()  
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		if(driver.getTitle().equalsIgnoreCase("MSite - Login"))
		{
			mlp.enterUsername(username);
			mlp.enterPassword(password);
			mlp.clickOnSignIn();
			waitForSeconds(1);
		}
		
	}

	@Test (priority=1)
	public void training_OpenTrainingWithoutTraining_AndVerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		ep.clickOnAllowCookies();
		Reporter.log("Diasabling Online Induction from System Setting");
		ep.change_PropertyVisibility_FromSystemSetting("OnlineInductions","Disabled");
		Reporter.log("Diasabling Classroom Training from System Setting");
		ep.change_PropertyVisibility_FromSystemSetting("Classroom","Disabled");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("opening Training Page and Verifying title");
		tp.openTrainingWithoutDropdown();
		tp.verifyTrainingTitle( "NoTraining");
		
	}
	
	@Test (priority=2)
	public void training_VerifyEmptyTraining() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		tp.openTrainingWithoutDropdown();
		Reporter.log("Open Training Page and Verifying Empty Training");
		tp.verifyEmptyTraining();
		EmployeesPage ep=new EmployeesPage(driver);
		ep.change_PropertyVisibility_FromSystemSetting("OnlineInductions","Enabled");
		ep.change_PropertyVisibility_FromSystemSetting("Classroom","Enabled");
	}
	
	@Test (priority=3)
	public void training_OpenTrainingDropdown() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Opening Training Dropdown");
		tp.openTrainingDropdown();
		Reporter.log("Verifying Dropdown Content");
		tp.verifyTrainingDropdown();
	}
	
	@Test (priority=4)
	public void training_OpenClassroomTrainingFromDropDown_And_VerifyTilte() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Open Training Dropdown");
		tp.openTraining();
		Reporter.log("Open Classroom Training and Verifying Title");
		tp.verifyTrainingTitle("Classroom");
	}
	
	@Test (priority=5)
	public void training_ClassroomTraining_BrowseCourse_NoCourseFound() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Open Training Dropdown");
		tp.openTraining();
		Reporter.log("Open Classroom Training and Verifying No Course Found In Browse Course");
		tp.classroomTraining_BrowseCourseList();
	}
	
	@Test (priority=6)
	public void training_OpenClassroomTrainingFromDropDown_And_VerifyAllElementPresent() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Open Training Dropdown");
		tp.openTraining();
		Reporter.log("Open Classroom Training and Verifying All Avialble Element in Classroom Page");
		tp.reviewAndVerifyAllElementInTraining("Classroom");
	}
	
	@Test (priority=7)
	public void training_ClassroomTraining_Open_AddNewClassroomCourse_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classroom Training ");
		tp.openTraining();
		Reporter.log("Open New Classroom Course and Verifying All Avialable Element in Page");
		tp.open_NewClassroomCourse_And_VerifyAllElement();
	}
	
	@Test (priority=8)
	public void training_ClassroomTraining_CreateEmpty_NewClassroomCourse_NotAdded() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Adding Empty New Classroom Course");
		tp.create_EmptyNewClassroomCourse();
	}
	
	@Test (priority=9)
	public void training_ClassroomTraining_EmptyCourse_CancelInDiscardChanges() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.open_AddNewClassroomCourse();
		Reporter.log("Click On Cancel In Discard Change Dailog , Dailog is closed and no change takes Places");
		tp.performDiscardChangesFunction("Cancel");
	}
	
	@Test (priority=10)
	public void training_ClassroomTraining_EmptyCourse_DiscardInDiscardChanges() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.open_AddNewClassroomCourse();
		Reporter.log("Click On Discard In Discard Change Dailog , Dailog is closed and no change takes Places");
		tp.performDiscardChangesFunction("Discard");
	}
	
	@Test (priority=11)
	public void training_ClassroomTraining_CourseWithData_CancelInDiscardChanges() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		Reporter.log("Click On Cancel In Discard Change Dailog with Data , Dailog is closed and no change takes Places");
		tp.discardChangesWithData("Cancel");
	}
	
	@Test (priority=12)
	public void training_ClassroomTraining_CourseWithData_DiscardInDiscardChanges() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		Reporter.log("Click On Discard In Discard Change Dailog with Data , Dailog is closed and no change takes Places");
		tp.discardChangesWithData("Discard");
	}
	
	@Test (priority=13)
	public void training_ClassroomTraining_CancelInCreate_And_Unpublish_NewClassroomCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.create_NewClassroomCourse("ClassroomCourse_Test_1","UnPublish","Cancel");
		Reporter.log("Click on Cancel in Unpublish Add New Classroom Course ,Verifying No Course is added");
	}
	
	@Test (priority=14)
	public void training_ClassroomTraining_Create_And_Unpublish_NewClassroomCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.create_NewClassroomCourse("ClassroomCourse_Test_1","Unpublish","Create");
		Reporter.log("Clicking on Create in Unpublish Add New Classroom Course ,Verifying New Course is added in courseList");
	}
	
	@Test (priority=15)
	public void training_ClassroomTraining_Create_And_Publish_NewClassroomCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.create_NewClassroomCourse("ClassroomCourse_Test_2","Publish","Create");
		Reporter.log("Clicking on Create in Publish Add New Classroom Course ,Verifying New Course is added in courseList");
	}
	
	@Test (priority=16)
	public void training_ClassroomTraining_CreateWith_InvalidValidadityDays_NewClassroomCourse_NotCreated() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.addNewClassroomCourse_InvalidValidityPeriodDays_NotCreated();
		Reporter.log("Verifying Invalid Validity Period Days are not Added ,Field is Highlighted in Red Color ");
	}
	
	@Test (priority=17)
	public void training_ClassroomTraining_VerifyEmptyModule_NewClassroomCourse_NotCreated() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.addNewClassroomCourse_EmptyModule();
		Reporter.log("Verifying Empty Module In Add new Classroom Course");
	}
	
	@Test (priority=18)
	public void training_ClassroomTraining_AddModuleWith_NoTitle_NotCreated() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.open_AddNewClassroomCourse();
		Reporter.log("Adding Module with no Title ,no module is added and Tilte filed is highlighted in Red Color");
		tp.addNewClassroomCourse_AddModule_NoTitle_NotAdded();
	}
	
	@Test (priority=19)
	public void training_ClassroomTraining_CancelIn_AddModule_NotCreated() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.open_AddNewClassroomCourse();
		Reporter.log("Clicking on Cancel Button in Module ,no module Added and dailog is closed");
		tp.addNewClassroomCourse_addModule("Cancel","Chapter_2");
	}
	

	@Test (priority=20)
	public void training_ClassroomTraining_AddIn_AddModule_Created() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.open_AddNewClassroomCourse();
		tp.addNewClassroomCourse_addModule("Add","Chapter_2");
		Reporter.log("Clicking on Add Button in Module , Module Added in Module Section and dailog is closed");
		tp.verifyAddedModules("Chapter_2");
	}
	
	@Test (priority=21)
	public void training_ClassroomTraining_EditModule_InNewClassroomCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.editModule_InClassroomCourse();
		Reporter.log("Editing Module in Add new Classrooom Course,and verifying Edited Module");
	}
	
	@Test (priority=22)
	public void training_ClassroomTraining_CancelIn_DeleteModule_InNewClassroomCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Add New Classroom Course Page");
		tp.deleteModule_InClassroomCourse("Cancel");
		Reporter.log("Clicking on Cancel in Delete Module Dialog ,Module is not deleted");
	}
	
	@Test (priority=23)
	public void training_ClassroomTraining_DeleteIn_DeleteModule_InNewClassroomCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Clicking on Delete in Delete Module Dialog ,Module is deleted");
		tp.deleteModule_InClassroomCourse("Delete");
	}
	
	@Test (priority=24)
	public void training_ClassroomTraining_OpenBrowseCourse_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Browse Course Page and Verifying alll Available Elements and Course");
		tp.classroomTraining_BrowseCourse_VerifyAllElement();
	}
	
	@Test (priority=25)
	public void training_ClassroomTraining_BrowseCourse_FoundCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Browse Course Page and Verifying Courses");
		tp.classroomTraining_BrowseCourseList();
	}
	
	@Test (priority=26)
	public void training_ClassroomTraining_ViewCourse_And_VerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Browse Course Page");
		tp.classroomTraining_ViewCourse();
		Reporter.log("Open any Course and Verifying View Course Page");
	}
	
	@Test (priority=27)
	public void training_ClassroomTraining_ViewCourse_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Open Browse Course Page");
		tp.classroomTraining_ViewCourse_CheckCourseDetails();
		Reporter.log("Opening A Course From Browse Course and Verifying Data match From Browse Course to View Course");
	}
	
	@Test (priority=28)
	public void training_ClassroomTraining_EditCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Browse Course Page and open A Course");
		tp.classroomTraining_EditCourse();
		Reporter.log("Editing a Course and Veriying Edited Course in Browse Course");
	}
	
	@Test (priority=29)
	public void training_ClassroomTraining_OpenReport_And_VerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Report Page and Verifying  report Page Tilte ");
		tp.classroomTraining_ViewReport_And_VerifyTitle();
	}
	
	@Test (priority=30)
	public void training_ClassroomTraining_OpenReport_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Report Course Page and Verifying All Avialbale Element ");
		tp.classroomTraining_OpenReport_And_VerifyAlllElement();
	}
	
	@Test (priority=31)
	public void training_ClassroomTraining_OpenSessionReport_And_VerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Report Page");
		tp.classroomTraining_OpenReportType_And_VerifyTitle("Session Report");
		Reporter.log("Opening  Session Report Page AnD Verifying Title");
	}
	
	@Test (priority=32)
	public void training_ClassroomTraining_OpenTrainingReport_And_VerifyTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening Report Page");
		tp.classroomTraining_OpenReportType_And_VerifyTitle("Training Report");
		Reporter.log("Opening  Training Report Page AnD Verifying Title");
	}
	
	@Test (priority=33)
	public void training_ClassroomTraining_CancelIn_DeleteCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Opening a Course from Browse Courses");
		tp.classroomTraining_DeleteCourse("Cancel");
		Reporter.log("Clicking on Cancel in Delete course Dailog , No Course is deleted");
	}
	
	@Test (priority=34)
	public void training_ClassroomTraining_DeleteIn_DeleteCourse() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		TrainingClassroomPage tp=new TrainingClassroomPage(driver);
		Reporter.log("Click on Training Dropdown and Open Classrooom Training");
		tp.openTraining();
		Reporter.log("Clicking on Delete in Delete course Dailog , Selected  Course is deleted");
		tp.classroomTraining_DeleteCourse("Delete");
	}
	
}
