package com.Msite.TestScripts;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Msite.Pages.ContractorsPage;

import com.Msite.Pages.MsiteLoginPage;

/** 
* This is Contractors Test Class 
* All Test need to execute are written here
* @author Deepak Malviya 
*/
public class ContractorsPageTest extends BaseClass
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
	public void openContractors() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
        ContractorsPage cp=new ContractorsPage(driver);
        cp.clickOnAllowCookies();
        Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Verify Title of Contractor Page");
		cp.verifyContractorsTitle();
		logger.info("contractors is open and title is verified");
	}
	
	@Test (priority=2)
	public void reviewContractorsAndVerifyEachAvailableElement()  
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Verify All Available Elements In ContractorsPage");
		cp.reviewContractorsAndVerifyAllElement();
		logger.info("Reviewed contractors page and all element are verified successfully");
	}
	
	@Test (priority=3)
	public void contractorSearch_NoContractors_ForNameCombination() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
	    Reporter.log("Send Diffrent combination of Contractor name in Search box");
		cp.contractorSearch_NoContractors();   //Search by contractor which is not present in the list
		logger.info("search for different combination of contractor name which is not in the list");
	}
	
	@Test (priority=4)
	public void contractor_ContractorSearch_FindContractor()  
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Getting Contractor Name from Contractor list");
	    String contractorname= cp.getContractor();
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
	    cp.openContractors();
	    Reporter.log("Send Existing Contactor Name in Contractor Search box ");
		cp.contractorSearch(contractorname);
		 Reporter.log("Confirm Presence of searched Contractor in Search Result");
		cp.confirmSearchResult(contractorname);
		 Reporter.log("Delete newly Create Contracotr");
		cp.delete_Newly_Added_ContractorByName(contractorname);
		logger.info("verify search contractor");
	}
	
	@Test (priority=5)
	public void contractor_SortContractor_ByContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		 Reporter.log("Sort ContractorsList by Clicking on Contractor column in Contractors table");
		cp.sort_ContractorList_ByContractor();
		logger.info("Sort the list by contractor");
	}
	
	@Test (priority=6)
	public void contractor_SortContractor_ByAdminEmail() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
	    Reporter.log("Sort ContractorsList by Clicking on Admin Email column in Contractors table");
		cp.sort_ContractorList_ByAdminEmail();
		logger.info("Sort the list by Admin Email");
	}
	
	@Test (priority=7)
	public void contractor_Open_And_Save_Add_New_Contractor_NoDataInFields() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Add New Contractor without filling any Mandatory field");
		cp.open_And_Save_Add_New_Contractor_NoDataInFields();
		logger.info("Save contractor without filling detail ");
	}
	
	@Test (priority=8)
	public void contractor_Reload_Add_New_Contractor_And_Reload_WithDataInFields() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Fill data and Reload in Add New Contractor ");
		cp.open_And_Reload_Add_New_Contractor_WithDataInFields("Relaod");
		logger.info("Check Reload Functionality ");
	}
	
	@Test (priority=9)
	public void contractor_Open_And_Review_AddNewContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Navigate to Add new Contractor and Verify All Avialble Element");
		cp.open_And_Review_AddNewContractor();
		logger.info("Reviewd add new contractor ");
	}
	
	@Test (priority=10)
	public void contractor_Add_And_Verify_AddNewContractor_withValidData() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
	    Reporter.log("Add New Contractor by Filling accurate data in all mandatory field");
		cp.open_And_AddNewContractor_withValidData(); // Add new Contractor
		 Reporter.log("Verify Newly Added Contractor in Contractors List");
	    cp.verify_Newly_Added_Contractor();
		logger.info("Add and Verify Newly added contractor in the list ");
	}
	
	@Test (priority=11)
	public void contractor_CancelInDelete_AddNewContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Open Delete Contractor Dialog and Click on Cancel");
		cp.delete_Newly_Added_Contractor("Cancel");
		Reporter.log("Delete Dailog is Closed and Contractor is not deleted from the list");
		logger.info("Cancel Newly added contractor in the list ");
	}
	
	@Test (priority=12)
	public void contractor_Delete_AddNewContractor_FromTheList() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
		Reporter.log("Open Delete Contractor Dialog and Click on Delete");
		cp.delete_Newly_Added_Contractor( "Delete");
		 Reporter.log("Delete Dailog is Closed and Contractor is  Deleted from the Contractor list");
		logger.info("Delete Newly added contractor in the list ");	
	}
	
	@Test (priority=13)
	public void contractor_Edit_ExistingContractor_FromTheList() 
	{
		String number = getAlphaNumericString(1, "numberic");
		String name="Deepak_Automation+"+number+"";
		String Updatename="Deepak_Automation_updated_+"+number+"";
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
		cp.openContractors();
	    Reporter.log("Add New Contractor with Name only");
		cp.add_AddNewConstructor_ByNameOnly(name);
		 Reporter.log("Open Newly Created Contractor and Edit Contractor");
		cp.open_AnyConstructor_And_Edit_FromtheList(name,Updatename);
		 Reporter.log("Delete newly updated Contractor");
		cp.verify_And_Delete_EditedOrUpdated_Contractor( Updatename);
		logger.info("Edit  Existing contractor and Verify Updated and Delete contractor from the list ");	
	}
	
	@Test (priority=14)
	public void contractor_Verify_DuplicateNameErrorMessage_InContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
	    String contractorname= cp.getContractor();
	    Reporter.log("Add Contractor with existing contractor Name,Duplicate Contractor name error message is appeared");
		cp.verify_DuplicateEmailOrNameErrorMessage_InContractor(contractorname);
		cp.openContractors();
		cp.delete_Newly_Added_ContractorByName( contractorname);	
	}
	
	@Test (priority=15)
	public void contractor_Verify_DuplicateEmailErrorMessage_InContractor() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
	    String contractoremail= cp.getContractorEmail();
	    Reporter.log("Add Contractor with existing Email Name,Duplicate Email name error message is appeared");
		cp.verify_DuplicateEmailOrNameErrorMessage_InContractor(contractoremail);	
	}
	
	@Test (priority=16)
	public void contractor_Add_ContractorUser_InContractor() 
	{
		confirmLogin();
	    ContractorsPage cp=new ContractorsPage(driver);
	    Reporter.log("Navigate to Contractors by Clicking on Contractors link");
	    String contractoremail= cp.getContractorEmail();
	    Reporter.log("Add Contractor User in Existing Contractor");
		cp.add_ContractorUser_InContractor();
		cp.delete_Newly_Added_Contractor("Delete");	
	}
	
}
