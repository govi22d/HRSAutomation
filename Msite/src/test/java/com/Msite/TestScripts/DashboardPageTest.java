package com.Msite.TestScripts;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Msite.Pages.DashboardPage;
import com.Msite.Pages.MsiteLoginPage;

/** 
* This is Dashboard Test Class 
* All Test need to execute are written here
* @author Deepak Malviya 
*/
public class DashboardPageTest extends BaseClass
{

/** 
* This is method check already login 
* @author Deepak Malviya 
*/
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

// Set Priority for each test for perfect test execution flow,If we did not set Priority than it will execute in alphabetic order.
	
	@Test (priority=1)
	public void verifyDashboardTitle() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		dp.clickOnAllowCookies();
		Reporter.log("Click on Dashboard");
		dp.clickOnDashboard();
		Reporter.log("Verify Dashboard  Page Title");
		dp.verifyDashboardTitle();
		logger.info("Dashboard title is verified");
	}

	
	@Test (priority=2)
	public void dashboard_EmployeeSearch_EmptySearch_NoResults() 
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Send Empty Employee in Dashboard Search box and Search");
		dp.employeeSearch("");
		logger.info("send empty in search box and search");
		dp.employeeSearch_NoEmployees(); 
		Reporter.log("Verify 0  Employee Found in Dashboard");
		dp.contractorSearch_NoContractors();
		Reporter.log("Verify 0  Contractors Found in Dashboard");
		logger.info("0 Employees and Contractors Found ");
	}
	
	@Test (priority=3)
	public void dashboard_EmployeeSearch_FindEmployees() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Getting Existing Employee Name from Employee List");
		String employeename= dp.getEmployee(); // getting employee from EmployeeList and Store in String
		logger.info("Get existing employee name from list"); 
		Reporter.log("Switch back to Dashbaord Page by clicking on Dashboard");
		dp.clickOnDashboard();
		Reporter.log("Send Existing Employee  Name In Dashboard Search box and search ");
		dp.employeeSearch(employeename);
		logger.info("search employee in employee search box ");
		Reporter.log("Confirm searched Employee Presence in Dashboard Search Result ");
		dp.confirmSearchResult(employeename, "employee");
		logger.info("confiremed searched name  in result list ");
	}

	@Test(priority=4)
	public void  dashboard_ContractorSearch_SearchForEmployee_NoContractorFound()  
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Getting Existing Employee Name From Employee List");
		String employeename= dp.getEmployee();
		Reporter.log("Switch back to Dashbaord Page by clicking on Dashboard");
		logger.info("Get existing employee name from list");
		dp.clickOnDashboard();
		Reporter.log("Send Existing Employee  Name In Dashboard Search box and search ");
		dp.employeeSearch(employeename); 
		Reporter.log("Confirm 0 Contractor Found in Dashboard Search Result ");
		dp.contractorSearch_NoContractors();
	}

	@Test (priority=5)
	public void dashboard_ContractorSearch_FindContractor() 
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Getting Existing Contractor Name From Contractors List");
		String contractorname= dp.getContractor();
		logger.info("Get existing employee name from list"); 
		Reporter.log("Switch back to Dashbaord Page by clicking on Dashboard");
		dp.clickOnDashboard();
		Reporter.log("Send Existing Contractor  Name In Dashboard Search box and search ");
		dp.employeeSearch(contractorname);
		Reporter.log("Confirmed Searched Contractor Name in Dashboard Search Result Page ");
		logger.info("search employee in employee search box ");
		dp.confirmSearchResult(contractorname, "contractors");
		logger.info("confiremed searched name  in result list "); 
	}

	@Test (priority=6)
	public void dashboard_Widget_LastestTransactions_Present()  
	{
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Latest Transaction Widget in Dashboard Page");
		dp.widget_LastestTransactions_Present();
		logger.info("Latest Transaction presents in dashboard widget");
	}

	@Test (priority=7)
	public void dashboard_Widget_Top10TradeOnSite_Present()  
	{ 
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Top 10 Trade On Site Widget in Dashboard Page");
		dp.widget_Top10TradeOnSite_Present();
		logger.info("Top 10 Trades on site  presents in dashboard widget");
	}

	@Test (priority=8)
	public void dashboard_Widget_PeopleOnSite_Present()  
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of People On Site Widget in Dashboard Page");
		dp.widget_PeopleOnSite_Present();
		logger.info("People On site presents in dashboard widget"); 
	}

	@Test (priority=9)
	public void dashboard_Widget_SSSTS_Present() 
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard(); 
		Reporter.log("Verify Presence of SSSTS Widget in Dashboard Page");
		dp.widget_SSSTS_Present();
		logger.info("SSSTS presents in dashboard widget"); 
	}

	@Test (priority=10)
	public void dashboard_Widget_SMSTS_Present()  
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard(); 
		Reporter.log("Verify Presence of SMSTS Widget in Dashboard Page");
		dp.widget_SMSTS_Present();
		logger.info("SMSTS presents in dashboard widget");
	}

	@Test (priority=11)
	public void dashboard_Widget_FireMarshal_Present() 
	{
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Fire Marshal Widget in Dashboard Page");
		dp.widget_FireMarshal_Present();
		logger.info("Fire Marshal presents in dashboard widget"); 
	}

	@Test (priority=12)
	public void dashboard_Widget_FirstAid_Present() 
	{ 
		confirmLogin(); 
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver); 
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of First Aid Widget in Dashboard Page");
		dp.widget_FirstAid_Present();
		logger.info("Fire Marshal presents in dashboard widget"); 
	}

	@Test (priority=13)
	public void dashboard_Widget_Inductions_Present()  
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Inductions Widget in Dashboard Page");
		dp.widget_Inductions_Present();
		logger.info("Fire Marshal presents in dashboard widget");
	}

	@Test (priority=14)
	public void dashboard_Heading_Transactions_Present() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Transaction Heading in Dashboard Page");
		dp.heading_Transactions_Present();
		logger.info("Transaction presents in dashboard widget");
	}

	@Test (priority=15)
	public void dashboard_Heading_RightNowOnSite_Present() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Right Noe On Site Heading in Dashboard Page");
		dp.heading_RightNowOnSite_Present();
		logger.info("Right Now OnSite presents in dashboard widget");
	}

	@Test (priority=16)
	public void dashboard_Heading_TrainedOperatives_Present() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of Trained Operatives Heading in Dashboard Page");
		dp.heading_TrainedOperatives_Present();
		logger.info("Trained Operatives presents in dashboard widget");
	}

	@Test (priority=17)
	public void dashboard_Heading_OnSite_Present() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of On Site Heading in Dashboard Page");
		dp.heading_OnSite_Present();
		logger.info("OnSite presents in dashboard widget");
	}

	@Test (priority=18)
	public void dashboard_Heading_OnSite_SelectionBox()
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Presence of On Site Selection Box Heading in Dashboard Page");
		dp.heading_OnSite_SelectionBox();
		logger.info("Transaction presents in dashboard widget");
	}

	@Test (priority=19)
	public void dashboard_ChangeSite_HeadingsUpdate() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		String site=dp.getSite();
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Verify Updation of headings by Changing Site from Site Selection Box in Dashboard");
		dp.changeSiteTest(site);
		logger.info("Transaction presents in dashboard widget");
	}

	@Test (priority=20)
	public void dashboard_Widget_LastestTransactions_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to Latest Transaction Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_LastestTransactions_Report("MSite - Transaction Diagnostics");
		logger.info("Latest Transaction Report Widget is open in Dashboard");
	}

	@Test (priority=21)
	public void dashboard_Widget_Top10TradeOnSite_Report()
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to Top 10 Trade On Site Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_Top10TradeOnSite_Report("MSite - Trades On Site");
		logger.info("Top10 Trade On Site Report Widget is open in Dashboard");
	}
	
	@Test  (priority=32)
	public void dashboard_Widget_PeopleOnSite_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to People On Site Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_PeopleOnSite_Report("MSite - Roll Call");
		logger.info("People OnSite Report Widget is open in Dashboard");
	}

	@Test (priority=22)
	public void dashboard_Widget_Top10ContractorsOnSite_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to Top 10 Contractors Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_Top10ContractorsOnSite_Report("MSite - Roll Call (by Contractor)");
		logger.info("Top10ContractorsOnSite Report Widget is open in Dashboard");
	}

	@Test (priority=23)
	public void dashboard_Widget_SSSTS_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to SSSTS Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_SSSTS_Report("MSite - Roll Call (Key Personnel)");
		logger.info("SSSTS Report Widget is open in Dashboard");
	}

	@Test (priority=24)
	public void dashboard_Widget_SMSTS_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to SMSTS Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_SMSTS_Report("MSite - Roll Call (Key Personnel)");
		logger.info("SMSTS Transaction Report Widget is open in Dashboard");
	}

	@Test (priority=25)
	public void dashboard_Widget_FireMarshal_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to Fire Marshal Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_FireMarshal_Report("MSite - Roll Call (Key Personnel)");
		logger.info("FireMarshal Report Widget is open in Dashboard");
	}

	@Test (priority=26)
	public void dashboard_Widget_FirstAid_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to First Aid Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_FirstAid_Report("MSite - Roll Call (Key Personnel)");
		logger.info("FirstAid Report Widget is open in Dashboard");
	}

	@Test (priority=27)
	public void dashboard_Widget_Incidents_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to Incidents Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_Incidents_Report("MSite - Incident Audit");
		logger.info("Incidents Report Widget is open in Dashboard");
	}

     @Test (priority=28)
	public void dashboard_Widget_Apprentices_Report() 
	{
		confirmLogin();
		Reporter.log("User Logged In successfully");
		DashboardPage dp=new DashboardPage(driver);
		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
		dp.clickOnDashboard();
		Reporter.log("Navigate to Apprentices Report Page  From Dashboard and Ensure data match in Dashboard and Report Page");
		dp.widget_Apprentices_Report("MSite - Apprentice List");
		logger.info("Apprentices Report Widget is open in Dashboard");
	}

     @Test (priority=29)
  	public void dashboard_Widget_OperativeOnSite_Disabled_HistrogramVisibilityCheck() 
  	{
  		confirmLogin();
  		Reporter.log("User Logged In successfully");
  		DashboardPage dp=new DashboardPage(driver);
  		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
  		dp.widget_OperativeOnSite_HistrogramVisibilityCheck("Disabled");
  		Reporter.log("Disable Histrogram visibility from setting and Check absence of Histrogram in Dashboard Page");
  	}
     
     @Test (priority=30)
 	public void dashboard_Widget_OperativeOnSite_Enabled_HistrogramVisibilityCheck() 
 	{
 		confirmLogin();
 		Reporter.log("User Logged In successfully");
 		DashboardPage dp=new DashboardPage(driver);
 		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
 		dp.widget_OperativeOnSite_HistrogramVisibilityCheck("Enabled");	
 		Reporter.log("Enable Histrogram visibility from setting and Check Presence of Histrogram in Dashboard Page");
 	}

 	@Test (priority=31)
 	public void dashboard_Widget_Gender_Present() 
 	{ 
 		confirmLogin();
 		Reporter.log("User Logged In successfully");
 		DashboardPage dp=new DashboardPage(driver); 
 		Reporter.log("Navigate To Dashboard Page by clicking on Dashboard link");
 		dp.clickOnDashboard(); 
 		Reporter.log("Verify Gender Widget in Dashboard Page");
 		dp.widget_Gender_Present();
 		logger.info("Gender presents in dashboard widget"); 
 	}
}





