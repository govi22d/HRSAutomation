package com.Msite.TestScripts;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Msite.Pages.EmployeesPage;
import com.Msite.Pages.MsiteLoginPage;
import com.aventstack.extentreports.Status;

public class EmployeesPageTest extends BaseClass
{
	public void confirmLogin() 
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		if(driver.getTitle().equalsIgnoreCase("MSite - Login"))
		{
			mlp.enterUsername(username);
			mlp.enterPassword(password);
			mlp.clickOnSignIn();
	    	  waitForSeconds(2); 
	    	  EmployeesPage ep=new EmployeesPage(driver);
	  		 ep.clickOnAllowCookies();
	  		 ep.open_Employee_AndDeleteEmployee("Delete");
		}
	}
	
	String contractorname="Deepak_Automation_Contractor";
	
	@Test (priority=1)
	public void employees_OpenEmployees() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		ep.verifyEmployeesTitle();
		Reporter.log("Verifying Employee Page Title");
		logger.info("Employees is open and title is verified");
	}
	
	@Test (priority=2)
	public void employees_ReviewEmployee_And_VerifyEachAvailableElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Verifying All Element in Employee Page");
		ep.reviewAndVerifyAllElementInEmployees();
		logger.info("Reviewed employees page and all element are verified successfully");
	}
	
	@Test (priority=3)
	public void employee_Open_Emplyoee_InEmployeeStatusSummaryContainer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening Employee List and Verifying Data");
		ep.open_Emplyoee_InEmployeeStatusSummaryContainer();
		logger.info("Open Employee in Employee Status Summary Container");
	}
	
	@Test (priority=4)
	public void employee_Open_TrainingException_InEmployeeStatusSummaryContainer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening Training Exception and Verifying Data");
		ep.open_TrainingException_InEmployeeStatusSummaryContainer();
		logger.info("Open Trainining Exception in Employee Status Summary Container");
	}
	
	@Test (priority=5)
	public void employee_Open_AccreditationException_InEmployeeStatusSummaryContainer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening Accreditation Exception and Verifying Data");
		ep.open_AccreditationException_InEmployeeStatusSummaryContainer();
		logger.info("Open Accreditations Exception in Employee Status Summary Container");
	}
	
	@Test (priority=6)
	public void employee_Open_InductionBookingException_InEmployeeStatusSummaryContainer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		ep.openEmployees();
		Reporter.log("Opening Induction Booking Exception and Verifying Data");
		ep.open_InductionBookingException_InEmployeeStatusSummaryContainer();
		logger.info("Open Induction Exception in Employee Status Summary Container");
	}
	
	@Test (priority=7)
	public void employee_Open_IDCheckException_InEmployeeStatusSummaryContainer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening ID Check Exception and Verifying Data");
		ep.open_IDCheckException_InEmployeeStatusSummaryContainer();
		logger.info("Open IDCheck Exception in Employee Status Summary Container");
	}
	
	@Test (priority=8)
	public void employee_Open_AccessAndAttendenceException_InEmployeeStatusSummaryContainer() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening Access and Attendence Exception and Verifying Data");
		ep.open_AccessAndAttendenceException_InEmployeeStatusSummaryContainer();
		logger.info("Open Access and Attendence Exception in Employee Status Summary Container");
	}
	
	
	@Test (priority=9)
	public void employees_Open_AddNewEmployee_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Verifying All Available Element in Add new Employee Page");
		ep.verify_AllElement_InAddNewEmployeePage();	
	}

	@Test (priority=10)
	public void employees_Open_AddNewEmployee_CancelInReloadDailog() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Click on Cancel button in Reload Employee Dailog,Verifying Changes after Cancel");
		ep.addNewEmployee_ReloadTest(true);	
	}
	
	@Test (priority=11)
	public void employees_Open_AddNewEmployee_ReloadInReloadDailog() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Click on Reload button in Reload Employee Dailog,Verifying Changes after Reload");
		ep.addNewEmployee_ReloadTest(false);		
	}
	
	@Test (priority=12)
	public void employees_Open_AddNewEmployee_Empty() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Adding Empty New Employee,Not Added and All Manadatory Field Are highlighted in Red color");
		ep.addNewEmployee_Epmty();	
	}
	
	@Test (priority=13)
	public void employees_Open_AddNewEmployee_SaveChangesButton() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Verifying Presence of Save Changes Button in Employee Page");
		ep.addNewEmployee_SaveChangesButton();
	}
	
	
	@Test (priority=14)
	public void employee_AddNewEmployee_InAddNewemployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		String role=ep.getRole();
		String site=ep.getSite();
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Adding a New Employee In Employee List,and Verifying new employee");
		ep.addNewEmployee(contractorName, role);
	}
	
	@Test (priority=15)
	public void employee_AddNewEmployee_DuplicateDialogBoxForAddingExistinEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		String role=ep.getRole();
	    ep.change_PropertyVisibility_FromSystemSetting("DeDupeEnabled","Enabled");
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Verifying Presence of Duplicate Employee Dialog box ");
		ep.employee_DuplicateDailogInAddEmplyee(contractorName, role);
	}
	
	@Test (priority=16)
	public void employee_AddNewEmployee_Empty_ManageSiteSection() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Adding a empty site in manage site section");
		ep.employee_ManagaeSiteSection_Empty();
	}
	
	@Test (priority=17)
	public void employee_AddNewEmployee_NoInduction_ManageSiteSection() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Adding a site in Manage site section with  not inducted");
		ep.employee_ManageSiteSection("No");
		Reporter.log("Verifying site is not inducted");
		ep.employee_Verify_ManagaeSiteSection_Induction("Not Inducted");
	}
	
	@Test (priority=18)
	public void employee_AddNewEmployee_Inducted_ManageSiteSection() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Adding a site in Manage site section with inducted");
		ep.employee_ManageSiteSection("Yes");
		Reporter.log("Verifying site is inducted");
		ep.employee_Verify_ManagaeSiteSection_Induction("Inducted");
	}
	
	@Test (priority=19)
	public void employee_AddNewEmployee_Edit_ManageSiteSection() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
	    ep.edit_And_VerifyEdit_ManageSiteSection();
	    Reporter.log("Add New Site and Edit Site In Mange Site Section ,And Verifying Edited Site");
	}
	
	@Test (priority=20)
	public void employee_AddNewEmployee_CancelInDelete_ManageSiteSection() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
	    ep.delete_ManageSiteSection("Cancel");
	    Reporter.log("Clicking On Cancel in Delete Manage Site Dialog, Selected  Site is not deleted ");
	}
	
	@Test (priority=21)
	public void employee_AddNewEmployee_Delete_ManageSiteSection() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Add Site In Manage Site Section Section");
		Reporter.log("Clicking On Delete in Delete Manage Site Dialog, Selected  Site is deleted ");
	    ep.delete_ManageSiteSection("Delete");
	}
	
	@Test (priority=22)
	public void employee_AddNewEmployee_Edit_NextOfKin() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Add Entry In Next of Kin Section");
	    ep.edit_And_VerifyEdit_NextOfKin();
	    Reporter.log("Edit Existing Entry In Next of Kin Section And Verifying Edited Entry");
	}
	
	@Test (priority=23)
	public void employee_AddNewEmployee_CancelInDelete_NextOfKin() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Add Entry In Next of Kin Section");
		Reporter.log("Clicking On Cancel in Delete Next Of Kin Dialog Page, Selected Next of kin Entry is not deleted ");
	    ep.delete_NextOfKin("Cancel");
	}
	
	@Test (priority=24)
	public void employee_AddNewEmployee_Delete_NextOfKin() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Add New Employee Page");
		ep.open_AddNewEmployee();
		Reporter.log("Add Entry In Next of Kin Section");
		Reporter.log("Clicking On Delete in Delete Next Of Kin Dialog Page, Selected Next of kin Entry is deleted ");
	    ep.delete_NextOfKin("Delete");
	}
	
	@Test (priority=25)
	public void employees_BrowseEmployee_Colapses() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Colapses();
		Reporter.log("Verifying  Search Box Colapse Functionality In Browse Employee Page ");
	}
	
	@Test (priority=26)
	public void employees_BrowseEmployee_ContentCheck() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_ContentCheck();
		Reporter.log("Verifying  Content Elements In Browse Employee Page");
	}
	
	@Test (priority=27)
	public void employees_BrowseEmployee_FirstNameSearch() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Search("Deepak_Employee_Test_1", "", "", "", "Contractors");
		Reporter.log("Send First Name And search in Browse Employee");
		ep.searchResults_CheckAttributeValues("2", "Deepak_Employee_Test_1", false);
		Reporter.log("Verifying  First Name Search Result");
	}
	
	@Test (priority=28)
	public void employees_BrowseEmployee_LastNameSearch() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Search("", "TestEmployee", "", "", "Contractors");
		Reporter.log("Send Last Name And search in Browse Employee");
		ep.searchResults_CheckAttributeValues("3", "TestEmployee", false);
		Reporter.log("Verifying  Last Name Search Result");
	}
	
	@Test (priority=29)
	public void employees_BrowseEmployee_ByNameSearch() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Search("Deepak_Employee_Test_1", "TestEmployee", "", "", "Contractors");
		Reporter.log("Search Browse Employee By Name ");
		ep.searchResults_CheckAttributeValues("2", "Deepak_Employee_Test_1", false);
		ep.searchResults_CheckAttributeValues("3","TestEmployee", false);
		Reporter.log("Verifying  Name Search Result");
	}
	
	@Test (priority=30)
	public void employees_BrowseEmployee_ContractorSearch() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
	    String contractorName= ep.getContractor(contractorname);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Search("", "", contractorName,"", "Contractors");
		Reporter.log("Selecting Contractor Name In  Browse Employee Contractor Field and Search ");
		ep.searchResults_CheckAttributeValues("4", contractorName, true);
		Reporter.log("Verifying  Contractor Search Result");
	}
	
	@Test (priority=31)
	public void employees_BrowseEmployee_BioIdSearch() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		String testEmployee[]=ep.getEmployee();
		Reporter.log("Getting Bio Id From Employee Page");
		ep.browseEmployee_Search("", "", "", testEmployee[0],"Contractors");
		Reporter.log("Entering Bio id In Bio Id Search Field And Search");
		ep.searchResults_CheckAttributeValues("1", testEmployee[0], true);
		ep.searchResults_CheckAttributeValues("2", testEmployee[1], true);
		ep.searchResults_CheckAttributeValues("3", testEmployee[2], true);
		Reporter.log("Verifying Bio ID Search Result");
	}
	
	@Test (priority=32)
	public void employees_BrowseEmployee_WithoutAnyDetailSearch() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Search("", "", "", "","Contractors");
		Reporter.log("Entering No Data in Browse Data Field and Reload");
		ep.searchResult_ForEpmtySearch();
		Reporter.log("Verifying Reload Data In Search Result");
	}
	
	@Test (priority=33)
	public void employees_BrowseEmployee_FillAnyDetail_Relaod() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Browse Employee Page");
		ep.browseEmployee_Search("d", "e", contractorName, "16","Contractors");
		Reporter.log("Entering Data in Browse Data Field and Reload");
		ep.browserEmployee_Reload();
		Reporter.log("Verifying Reload Data In Search Result");
		ep.searchResult_ForRelaod();
	}
	
	@Test (priority=34)
	public void employee_OpenAndEditEmployee_CancelInDiscardChanges() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		ep.open_Employee_DiscardChanges("Cancel");
		Reporter.log("Click on Cancel In Discard Changes Dilaog,VErify Cancel Result");
	}
	
	@Test (priority=35)
	public void employee_OpenAndEditEmployee_DiscardInDiscardChanges() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.open_Employee_DiscardChanges("Discard");
		Reporter.log("Click on Discard In Discard Changes Dilaog,All Changes Are Removed Back");
	}
	
	@Test (priority=36)
	public void employee_OpenAndEditEmployee() 
	{
		confirmLogin();
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_Edit_NeworExistingEmployee();
		Reporter.log("Employee is Edited and Veriying Edited Employee");
	}
	
	@Test(priority=37)
	public void employee_OpenEmployee_And_CancelInManagePinEntry() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_OpenEmployee_And_ManagePinEntry("Cancel");
		Reporter.log("Click on Cancel in Manage Pin Entry Dailog,No Entry is Added for Employee");
	}
	@Test(priority=38)
	public void employee_OpenEmployee_And_SaveInManagePinEntry() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_OpenEmployee_And_ManagePinEntry("Save");
		Reporter.log("Click on Save in Manage Pin Entry Dailog, Pin  is Added for Employee");
	  
	}
	
	@Test(priority=39)
	public void employee_OpenEmployee_And_CancelInAddIncident() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_EditEmployee_AddIncident("Cancel");
		Reporter.log("Click on Cancel in Add Incident Dailog,No Incident is Added for Employee");
	  
	}
	@Test(priority=40)
	public void employee_OpenEmployee_And_AddInAddIncident() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_EditEmployee_AddIncident("Add");
		Reporter.log("Adding Incident for Selected Employee");
	}
	
	@Test(priority=41)
	public void employee_OpenEmployee_And_CancelInRestrictAccess() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_EditEmployee_RestrictAccess("Cancel");
		Reporter.log("Click on Cancel in Restrict Access Dailog,No Restriction is Added for Employee");
	}
	
	@Test(priority=42)
	public void employee_OpenEmployee_And_AddManualPunchWithoutDoor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_AddManualPunchWithoutDoor();
		Reporter.log("Add New Punch Without Door In Employee Page"); 
	}
	
	@Test(priority=43)
	public void employee_DisabledBiometricConsentInSetting_And_CheckBiometricConsentStatusInEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Disabled Biometric Consent Setting ");
		Reporter.log("Open Existing Employee");
		Reporter.log("Verify Biometric Consent Status Absence In Employee");
		ep.employee_CheckBiometricConsentStatusInEmployee("Disabled");
	}
	
	@Test(priority=44)
	public void employee_EnabledBiometricConsentInSetting_And_CheckBiometricConsentStatusInEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Enabled Biometric Consent Setting ");
		Reporter.log("Open Existing Employee");
		ep.employee_CheckBiometricConsentStatusInEmployee("Enabled");
		Reporter.log("Verify Biometric Consent Status Presence In Employee");
	}
	
	@Test(priority=45)
	public void employee_AddPhotoByUploadPhoto() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		Reporter.log("Open Existing Employee");
		ep.employee_AddPhoto("Retake","Upload");
		Reporter.log("Add Profile Photo For Employee By Uploading Image from PC");
	}
	
	@Test(priority=46)
	public void employee_AddPhotoByCamera() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Open Existing Employee");
		ep.employee_AddPhoto("Done","Camera"); 
		Reporter.log("Add Profile Photo For Employee By Camera");
	}
	
	@Test(priority=47)
	public void employee_AddPhotoByCameraAndRetake() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Open Existing Employee");
		ep.employee_AddPhoto("Retake","Camera");  
		Reporter.log("Add Profile Photo For Employee By Camera ,Perorm Retake Action");
	}

	@Test (priority=48)
	public void employee_EnabledLockContractorInSetting_And_ViewContractorHistory() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractor=ep.getContractor("Jayesh");
		Reporter.log("Enabled Lock Contractor Setting From System Setting");
		ep.employee_ViewContractorHistory("Enabled"); 
		Reporter.log("Verifying View Contractor History For Existing Employee");
	}
	
	@Test (priority=49)
	public void employee_DisabledLockContractorInSetting_And_ViewContractorHistory() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Disabled Lock Contractor Setting From System Setting");
		ep.employee_ViewContractorHistory("Disabled");  
		Reporter.log("Verifying View Contractor History For Existing Employee");
	}
	
	@Test (priority=50)
	public void employee_OpenEmployee_And_AddInRestrictAccess() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_EditEmployee_RestrictAccess("Add"); 
		Reporter.log("Add Restriction Access For Selected Employee");
	}
	
	@Test (priority=51)
	public void employee_OpenEmployee_And_CancelInFixAccessIssue() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_EditEmployee_FixAccessIssues("Cancel");
		Reporter.log("Click On Cancel Button in Fix Access Issue Dailog ,Access Issue is not Removed"); 
	}
	
	@Test (priority=52)
	public void employee_OpenEmployee_And_RemoveInFixAccessIssue() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.employee_EditEmployee_FixAccessIssues("Remove"); 
		Reporter.log("Remove Access Issue for Selected Employee and Verifying Removal of Issue");
	}
	
	@Test (priority=53)
	public void employee_OpenEmployee_And_CheckAccessRestrictionHistory() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee");
		ep.editEmployee_AccessRestrictionHistory();
		Reporter.log("Navigating and Verifying Access Restriction History Report Page From Employee Page");
	}
	
	
	@Test (priority=54)
	public void employee_OpenEmployee_And_ViewViewSummary() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee And Navigate To View Summary Page");
		ep.employee_OpenEmployee_And_ViewSummary();
		Reporter.log("Verifying Data From Employee Pahe to View Summary Page");
	}
	
	@Test (priority=55)
	public void employee_OpenInviteEmployee_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		ep.openEmployees();
		Reporter.log("Open Invite New Employee And Verifying All Available Element in Invite Employee Page");
		ep.employee_OpenInviteEmployee_And_VerifyAllElement();
	}
	
	@Test (priority=56)
	public void employee_InviteEmployee_Search_ByFirstName() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.openInviteEmployee();
		Reporter.log("Searching  By First Name In Invite Employee,and Verifying Search Result ");
		ep.inviteEmployee_Search("Deepak","","");
	}
	@Test (priority=57)
	public void employee_InviteEmployee_Search_ByLastName() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.openInviteEmployee();
		Reporter.log("Searching  By Last Name In Invite Employee,and Verifying Search Result ");
		ep.inviteEmployee_Search("","Test","");
	}
	@Test (priority=58)
	public void employee_InviteEmployee_Search_ByName() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.openInviteEmployee();
		Reporter.log("Searching  By Name In Invite Employee,and Verifying Search Result ");
		ep.inviteEmployee_Search("Deepak","Test","");
	}
	
	@Test (priority=59)
	public void employee_InviteEmployee_Search_ByContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.openInviteEmployee();
		Reporter.log("Searching  By Contractor In Invite Employee,and Verifying Search Result ");
		ep.inviteEmployee_Search("","","Deepak_Automation_Contractor");
	}
	
	@Test (priority=60)
	public void employee_InviteEmployee_Search_AndReload() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.openInviteEmployee();
		Reporter.log("Select Search Creteria and Search");
		ep.inviteEmployee_Search("Deepak","Test","Deepak_Automation_Contractor");
		Reporter.log("Reload in Search Result,Verifying Reload Result");
		ep.inviteEmployee_Reload_And_VerifyReloadResult();
	}
	
	@Test (priority=61)
	public void employee_SearchEmployee_AndCancelInInviteEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String site=ep.getSite();
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.openInviteEmployee();
		Reporter.log("Select Existing Employee and Press Cancel button in Invite Dailog box");
		ep.open_InviteEmployee_And_Invite("Cancel",site);
		Reporter.log("Invite Dialog is Closed ,and No Invitation Has been Sent");
	}
	
	@Test (priority=62)
	public void employee_SearchEmployee_And_InviteEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String site=ep.getSite();
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite Employee");
		ep.openInviteEmployee();
		Reporter.log("Select Existing Employee via Search and Inviting Employee,Invitation Mail is Sent.");
		ep.open_InviteEmployee_And_Invite("Invite",site);
	}
	
	@Test (priority=63)
	public void employee_OpenInviteNewEmployee_And_VerifyAllElement() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee And Verifying All Available Elements In Invite New  Employee Page");
		ep.employee_OpenInviteNewEmployee_And_VerifyAllElement();
	}
	
	@Test (priority=64)
	public void employees_InviteNewEmployee_IndividualColapses() 
	{
		confirmLogin();
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.inviteNewEmployee();
		Reporter.log("Verifying Individual Invite Section Colapse In Invite New Employee Page");
		ep.inviteNewEmployee_IndividualColapses();
	}
	
	@Test (priority=65)
	public void employees_InviteNewEmployee_BulkColapses() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee");
		ep.inviteNewEmployee();
		Reporter.log("Verifying Bulk Invite Section Colapse In Invite New Employee Page");
		ep.inviteNewEmployee_BulkColapses();
	}
	
	@Test (priority=66)
    public void employee_InviteNewEmployee_IndividualWithoutFillingAnyDetails() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee Individual");
		ep.inviteNewEmployee_IndividualWithoutFillingAnyDetails(contractorName);
		Reporter.log("Send Invitaion Without Filling any Mandatory Detail");
	}
	
	@Test (priority=67)
	public void employee_InviteNewEmployee_Individual() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		String role=ep.getRole();
		String site=ep.getSite();
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee Individual");
		ep.inviteNewEmployee_Individual(contractorName,role,"invite",site);
		Reporter.log("Send Invitaion by Clicking on Invite In Individual Invite");
	}
	
	@Test (priority=68)
    public void employee_InviteNewEmployee_BulkWithoutFillingAnyDetails() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee In Bulk");
		ep.inviteNewEmployee_BulkWithoutFillingAnyDetails(contractorName);
		Reporter.log("Inviting Employee In Bulk Without Entering any Email in Bulk Text area");
	}
	
	@Test (priority=69)
	public void employee_InviteNewEmployee_InBulk() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		String role=ep.getRole();
		String site=ep.getSite();
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Invite New Employee In Bulk");
		ep.inviteNewEmployee_InBulk(contractorName,role,"invite",site);
		Reporter.log("Inviting Employees In Bulk By Entering Multiple Emails and Invite in Bulk Invite Page");
	}
	
	@Test (priority=70)
	public void employee_OpenViewProgress_And_VerifyAllElementsInViewProgress() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open View Progress and Verifying All Avaialable Element in View Progress Page");
		ep.openViewProgress_And_VerifyAllElementsInViewProgress();
	}
	
	@Test (priority=71)
	public void employee_ViewProgress_ReloadWithoutFillingAnyDetails() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open View Progress");
		ep.openViewProgress();
		Reporter.log("Select/Fill no field in View Progress and Reload and Verifying Reload Result ");
		ep.viewProgress_Reload("", "", "");
	}

	@Test (priority=72)
	public void employee_ViewProgress_ReloadWithFillingAnyDetails() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress");
		ep.openViewProgress();
		Reporter.log("Select/Fill Any field in View Progress and Reload ");
		ep.viewProgress_Reload("Deepak", "Malviya", contractorName);
		Reporter.log("Verify Reload Result In View Progress Page");
	}
	
	@Test (priority=73)
	public void employee_ViewProgress_SeachWithoutFillingAnyDetails() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress");
		ep.openViewProgress();
		Reporter.log("Search Withou selecting any search criteria In View Progress and Veriying Result");
		ep.viewProgress_Search("", "", "", "empty");
	}
	
	@Test (priority=74)
	public void employee_ViewProgress_SeachByFirstName() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress");
		ep.openViewProgress();
		Reporter.log("Search By First Name In View Progress and Veriying Result");
		ep.viewProgress_Search("Deepak", "", "", "empty");
	}
	
	@Test (priority=75)
	public void employee_ViewProgress_SeachByLastName() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress");
		ep.openViewProgress();
		Reporter.log("Search By Last Name In View Progress and Veriying Result");
		ep.viewProgress_Search("", "Malviya", "", "empty");
	}
	
	@Test (priority=76)
	public void employee_ViewProgress_SeachByName() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress");
		ep.openViewProgress();
		Reporter.log("Search By Name In View Progress and Veriying Result");
		ep.viewProgress_Search("Deepak", "Malviya", "", "empty");
	}
	
	@Test (priority=77)
	public void employee_ViewProgress_SeachByContractor() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress");
		ep.openViewProgress();
		Reporter.log("Search By Contractor In View Progress and Verifying Result");
		ep.viewProgress_Search("Deepak", "", contractorName, "");	
	}
	
	@Test (priority=78)
	public void employee_ViewProgress_ChangeInviteDateAndSearch() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Opening View Progress Page From Employee Page");
		ep.openViewProgress();
		Reporter.log("Changing Invite Date and Search");
		ep.viewProgress_ChangeInviteDate();
		Reporter.log("Veriying Result In View Profress");
		ep.viewProgress_Search("Deepak", "", contractorName, "");	
	}
	
	@Test (priority=79)
	public void employee_ViewProgress_VerifySearchResultHeadings() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Navigating to View Progress Page and Search");
		ep.openViewProgress();
		ep.viewProgress_Search("", "", contractorName, "");
		Reporter.log("Verifying All Available headings In View Progress Search Result");
		ep.verifyHeadingsInViewProgressSearchResult();
	}
	
	@Test (priority=80)
	public void employee_ViewProgress_Disabled_DataProtectionVisibilityFromSettingAndCheck() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Getting Existing Contractor Name from Contractor List");
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Disable Data Protection from Setting and Verifying absence of Data Protection Column in View Progress Search Result");
		ep.viewProgress_CheckDataProtectionHeadingVisibility(contractorName,"Disabled");
	}
	
	@Test (priority=81)
	public void employee_ViewProgress_Enabled_DataProtectionVisibilityFromSettingAndCheck() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Getting Existing Contractor Name from Contractor List");
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Enable Data Protection from Setting and Verifying Presence of Data Protection Column in View Progress Search Result");
		ep.viewProgress_CheckDataProtectionHeadingVisibility(contractorName,"Enabled");
	}
	
	@Test (priority=82)
	public void employee_ViewProgress_UnublishTrainingCourse_And_CheckPrerequisiteTrainingColumnData() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Getting Existing Contractor Name from Contractor List");
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Opening Data Protrction for You Course and Unublish it");
		ep.viewProgress_CheckPrerequisiteTrainingColumnData("Unublish",contractorName);
		Reporter.log("Opening View Progress In Employee,and Veriying N/A In Prerequisite Training Column Data");
	}
	
	@Test (priority=83)
	public void employee_ViewProgress_PublishTrainingCourse_And_CheckPrerequisiteTrainingColumnData() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Getting Existing Contractor Name from Contractor List");
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Opening Data Protrction for You Course and Publish it");
		ep.viewProgress_CheckPrerequisiteTrainingColumnData("Publish",contractorName);
		Reporter.log("Opening View Progress In Employee,and Veriying Punlish In Prerequisite Training Column Data");
	}
	
	@Test (priority=84)
	public void employee_ViewProgress_ViewInductionBooking() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open View Progress Page In Employee and Search");
		ep.openViewProgress();
		ep.viewProgress_Search("", "", contractorName, "");
		Reporter.log("Opening Induction Booking and verifying All Available Element ");
		ep.viewInductionBooking_InViewProgressSearchResult();
	}
	
	@Test (priority=85)
	public void employee_ViewProgress_Cancel_IncancelInductionBooking() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open View Progress Page In Employee and Search");
		ep.openViewProgress();
		ep.viewProgress_Search("", "", contractorName, "");
		Reporter.log("Open Induction Booking and click on No,Induction booking is not cancelled ");
		ep.open_InductionBooking_InViewProgressSearchResult("Cancel");
	}
	
	@Test (priority=86)
	public void employee_ViewProgress_Yes_InCancelInductionBooking() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Getting Existing Contractor from Contractor List");
		String contractorName=ep.getContractor(contractorname);
		Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open View Progress Page In Employee and Search");
		ep.openViewProgress();
		ep.viewProgress_Search("", "", contractorName, "");
		Reporter.log("Open Induction Booking and click on Yes,Induction booking is cancelled ");
		ep.open_InductionBooking_InViewProgressSearchResult("Yes");
	}
	
	@Test (priority=87)
	public void employee_Disable_MedicalConditionInSetting_And_CheckMedicalConditionSectionVisibilityInEmployee() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Disabled medical Condition fr employee in Dsetting and verifying Absence of medical section in Employee Page");
		ep.employee_CheckMedicalConditionSectionVisibilityInEmployee("Disabled");
	}
	
	@Test (priority=88)
	public void employee_Enable_MedicalConditionInSetting_And_CheckMedicalConditionSectionVisibilityInEmployee() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Enable Employee Medical condition setting from System Setting and Check visibility in Employee ");
		ep.employee_CheckMedicalConditionSectionVisibilityInEmployee("Enabled");
	}
	
	@Test (priority=89)
	public void employee_Edit_MedicalConditionInEmployee() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Edit Medical Condition and verify updated Medical Condition in Employee Page");
		ep.edit_MedicalSection("Edit");
	}
	
	@Test (priority=90)
	public void employee_Delete_MedicalConditionInEmployee() throws InterruptedException
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		EmployeesPage ep=new EmployeesPage(driver);
		Reporter.log("Delete Medical Condition from Medical Condition Section Successfully");
		ep.edit_MedicalSection("Delete");
	}
	
	@Test (priority=91)
	public void employee_AddAttachmentInEmployee() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    EmployeesPage ep=new EmployeesPage(driver);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee From The List, And Add New Attachment in Attachment section");
		ep.employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
		ep.employee_Attachments();
	}
	
	@Test (priority=92)
	public void employee_EditAttachmentInEmployee() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    EmployeesPage ep=new EmployeesPage(driver);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee and Click on Edit in attchment Section");
		Reporter.log("Open Edit Attachment,Change Name or Anything and Update");
		ep.employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
		Reporter.log("Verify Edit Attachement in Employee");
		ep.edit_And_VerifyEdit_Attachments();
	}
	
	@Test (priority=93)
	public void employee_Cancel_AttachmentInEmployee() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    EmployeesPage ep=new EmployeesPage(driver);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
	    Reporter.log("Open an existing Employee ,add An Attachment");
		ep.employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
		Reporter.log("Cancel In Delete Attachement, Atatchment is not deleted");
		ep.delete_Attachments("Cancel");
	}
	@Test (priority=94)
	public void employee_Delete_AttachmentInEmployee() throws InterruptedException, AWTException 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    EmployeesPage ep=new EmployeesPage(driver);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee from Employee list,and Add Attachment");
		ep.employee_Open_Edit_NeworExistingEmployee("Deepak_Employee_Test_2");
		Reporter.log("Delete Attachement from attachment Section Successfully");
		ep.delete_Attachments("Delete");
	}
	
	@Test (priority=95)
	public void employee_Cancel_InDeleteEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    EmployeesPage ep=new EmployeesPage(driver);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee and Click on Delete button");
		ep.open_Employee_AndDeleteEmployee("Cancel");
		Reporter.log("Click on Cancel in Delete Employee Dailog, Dialog is closed and Employee is not Deleted from the list");
	}
	
	@Test (priority=96)
	public void employee_Delete_InDeleteEmployee() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    EmployeesPage ep=new EmployeesPage(driver);
	    Reporter.log("Navigate to Employee Page by clicking on Employee link");
		ep.openEmployees();
		Reporter.log("Open Existing Employee and Click on Delete button");
		ep.open_Employee_AndDeleteEmployee("Delete");
		Reporter.log("Click on Delete in Delete Employee Dailog, Dialog is closed and Employee is Deleted from the list");
	}
}
