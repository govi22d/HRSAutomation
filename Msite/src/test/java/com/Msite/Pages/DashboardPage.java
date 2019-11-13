package com.Msite.Pages;

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

/** 
* This is Dashboard Page Class 
* All WebElements,Method ,Verification used in Dashboard Test Class are written here
* @author Deepak Malviya 
*/
public class DashboardPage extends BaseClass
{

	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/** 
	* WebElements used in Dashboard Page 
	* @author Deepak Malviya 
	*/
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashboard;

	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	WebElement dashboardTitle;

	@FindBy(id="searchText")
	WebElement searchtext;

	@FindBy(xpath="//*[@class='glyphicon glyphicon-search']")
	WebElement searchBoxIcon;

	@FindBy(xpath="//td[contains(text(),'0 Employees Found')]")
	WebElement employeeSearchResult;

	@FindBy(xpath="//a[contains(text(),'Employees (0)')]")
	WebElement employeeTabInSearchResultText;

	@FindBy(xpath="//td[contains(text(),'0 Contractors Found')]")
	WebElement contractorSearchResultText;

	@FindBy(xpath="//a[@href='#contractors']")
	WebElement contractorTabInSearchResult;

	@FindBy(xpath="//a[contains(text(),'Contractors (0)')]")
	WebElement contractorTabInSearchResultText;

	@FindBy(xpath="//a[@href=\"/Employee\"]")
	WebElement employee;

	@FindBy(id="EmployeeListSearch")
	WebElement employeeListSearch;

	@FindBy(xpath="//tr[@class='rowlink']/td[2]/a")
	WebElement firstname;

	@FindBy(xpath="//div[@id='employees']//tbody/tr")
	WebElement confirmEmployeeSearchResult;

	@FindBy(xpath="//div[@id='contractors']")
	WebElement confirmContractorSearchResult;

	@FindBy(xpath="//a[@href=\"/System/Contractors\"]")
	WebElement contractor;

	@FindBy(xpath="//div[contains(text(),'AAAA')]")
	WebElement contractorname;

	@FindBy(id="Widget-36b6d24a-8514-4dd0-939a-23b4466c8148")
	WebElement widgetid;

	@FindBy(xpath="//Strong[contains(text(),'Latest 10 Transactions')]")
	WebElement widgetheading;

	@FindBy(xpath="//*[@id='Widget-36b6d24a-8514-4dd0-939a-23b4466c8148']")
	WebElement attributeWidgetid;

	@FindBy(id="filters_0_")
	WebElement allSiteDropdown;

	@FindBy(xpath="//div[@class='panel-heading dashboard-widget-row-heading']")
	WebElement allWidgetheadings;

	@FindBy(id="Widget-98b82d67-1175-4a9f-bfea-909e8e092f23")
	WebElement totalOperativeOnSiteAll;

	@FindBy(id="Widget-1200f56a-2b98-401b-8476-e2536f2bb0a0")
	WebElement totalOperativeOnSiteByContractor;
	
	@FindBy(id="Widget-975e0ca6-bb3e-4b66-977c-f8a5fbbc2b66")
	WebElement genderWidget;
	
	@FindBy(xpath="//div[text()='No results found']")
	WebElement noResultFound;
	
	@FindBy(id="btn-allowCookies")
	WebElement allowCookies;

	
	/** 
	* This is method  used to navigate to dashboard page
	* No argument ,return type is void , access modifier is public
	* @author Deepak Malviya 
	*/
	public void clickOnDashboard() 
	{
		waitForSeconds(1);
		dashboard.click();
		waitForSeconds(3);
	}

	public void clickOnAllowCookies() 
	{
		waitForSeconds(1);
		allowCookies.click();
		waitForSeconds(3);
	}
	/** 
	* This is method  used to verify Dashboard title
	* No argument ,return type is void , access modifier is public
	* @author Deepak Malviya 
	*/
	public void verifyDashboardTitle() {
		if(dashboardTitle.getText().equalsIgnoreCase("Dashboard")) 
		{
			System.out.println("Dashboard title Verified ");
		}
	}
	
	public void employeeSearch(String searchText)
	{
		searchtext.clear();
		searchtext.sendKeys(searchText);
		searchBoxIcon.click();
		waitForSeconds(1);
		Assert.assertEquals(driver.getTitle(), "MSite - Search Results");
	}
	/** 
	* This is method  used to verify "0 Employee Found " in dashboard page
	* No argument ,return type is void , access modifier is public
	* @author Deepak Malviya 
	*/
	public void employeeSearch_NoEmployees()
	{
		Assert.assertTrue(isElementPresent(employeeSearchResult), "Text '0 Employees Found' not present.");  
		Assert.assertTrue(isElementPresent(employeeTabInSearchResultText), "Employee tab text should equal 'Employees (0).'");
	}
	/** 
	* This is method  used to verify "0 Contractors Found " in dashboard page
	* No argument ,return type is void , access modifier is public
	* @author Deepak Malviya 
	*/
	public void contractorSearch_NoContractors()
	{
		contractorTabInSearchResult.click();
		Assert.assertTrue(isElementPresent(contractorSearchResultText), "Text '0 Contractors Found' not present.");  
		Assert.assertTrue(isElementPresent(contractorTabInSearchResultText), "Contractor tab text should equal 'Contractors (0).'");
	}
	
	/** 
	* This is method  used to get Employee from  Employee Page
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public String getEmployee()  
	{
		employee.click();
		waitForSeconds(1);
		employeeListSearch.click();
		waitForSeconds(1);
		String firstName=firstname.getText();
		return firstName;
	}

	/** 
	* This is method  used to verify Search Result in dashboard page
	* Taking two String argument ,return type is void , access modifier is public
	* @author Deepak Malviya 
	*/
	public void confirmSearchResult(String searchname,String tableId) 
	{
		boolean foundMatch = false;
		if (tableId.equalsIgnoreCase("contractors"))
		{
			contractorTabInSearchResult.click();
			waitForSeconds(1);
			List<WebElement> contractorlist =confirmContractorSearchResult.findElements(By.xpath(".//td"));
			for ( WebElement result: contractorlist) { 
				if ( result.getText().contains(searchname)) 
					foundMatch=true;
			}
		}
		else {
			List<WebElement> employeelist =confirmEmployeeSearchResult.findElements(By.xpath("./td"));
			for ( WebElement result: employeelist) {          
				if ( result.getText().contains(searchname)) 
					foundMatch=true;
			}
		}
		Assert.assertTrue(foundMatch, "At least one value must contain the search text");

	}

	/** 
	* This is method is used to get contractor from Contractor Page
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public String getContractor()
	{
		contractor.click();
		waitForSeconds(1);
		String contname = FindElement("xpath", "//table[@id='contractorsList']//tbody/tr/td[1]").getText();
		return contname;
	}
	/** 
	* This is method is used to get site name from Site Page
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public String getSite()
	{
		Select sitesdropdown =  new Select(allSiteDropdown);
		List <WebElement> elementCount = sitesdropdown.getOptions();
		String site = elementCount.get(1).getText();
		return site;
	}
	/** 
	* This is method is used to Verify Latest Transaction Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_LastestTransactions_Present() 
	{
		String[] attributes = new String[] { "Employee", "Contractor", "TimeStamp", "Event", "Site Name", "Door", "Area", "Bio ID" };
		dashboardWidgetPresent("Widget-36b6d24a-8514-4dd0-939a-23b4466c8148", "Latest 10 Transactions", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-36b6d24a-8514-4dd0-939a-23b4466c8148']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}

	/** 
	* This is method is used to Verify Top 10 Trade On Site Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Top10TradeOnSite_Present() 
	{
		String[] attributes = new String[] { "Trade", "Count", "# Supervisor" };
		dashboardWidgetPresent("Widget-5c2169ac-6bca-48a9-b4c9-b8a9c5d04b88", "Top 10 Trade On Site", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-5c2169ac-6bca-48a9-b4c9-b8a9c5d04b88']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}

	/** 
	* This is method is used to Verify People On Site Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void  widget_PeopleOnSite_Present()
	{
		String attributes[] = new String[0];
		dashboardWidgetPresent("Widget-0377d750-1268-4b16-80a8-c5b713acf673", "People On Site", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-0377d750-1268-4b16-80a8-c5b713acf673']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}
	/** 
	* This is method is used to Verify Top 10 Contractor On Site Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Top10ContractorsOnSite_Present()
	{
		String[] attributes = new String[] { "Contractor", "Count", "# Supervisor" };
		dashboardWidgetPresent("Widget-8c7355eb-710e-4fa5-b4b1-acc6e1cf8a69", "Top 10 Contractors On Site", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-8c7355eb-710e-4fa5-b4b1-acc6e1cf8a69']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}

	/** 
	* This is method is used to Verify SSSTS Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_SSSTS_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-737c153b-742d-46fb-ad7f-78c1dbb54f16", "SSSTS", attributes); 
	}

	/** 
	* This is method is used to Verify Gender Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Gender_Present()
	{
		dashboard_AddNewCustomDashboardWidget_And_Verify(); //Add new Custom field first and verify 
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-975e0ca6-bb3e-4b66-977c-f8a5fbbc2b66", "Gender", attributes); 
	}

	/** 
	* This is method is used to Verify SMSTS Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_SMSTS_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-c5afacf3-39c5-48a6-8c20-281c7585948e", "SMSTS", attributes);
	}

	/** 
	* This is method is used to Verify FIre Marshal Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_FireMarshal_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-449e661f-6326-4cf1-9dd6-5cf2c96b8e81", "Fire Marshal", attributes);
	}

	/** 
	* This is method is used to Verify FIrst Aid Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_FirstAid_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-f15e2a32-f956-4fc2-b1c7-6d47fb4dcadc", "First Aid", attributes);
	}

	/** 
	* This is method is used to Verify Nationality Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Nationality_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-975e0ca6-bb3e-4b66-977c-f8a5fbbc2b66", "Nationality", attributes);
	}

	/** 
	* This is method is used to Verify Inductions Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Inductions_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-199e73eb-a058-4740-9809-64a0b6541511", "Inductions", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-199e73eb-a058-4740-9809-64a0b6541511']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}

	/** 
	* This is method is used to Verify Incidents Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Incidents_Present()
	{
		String[] attributes = new String[0];
		dashboardWidgetPresent("Widget-c17e542d-6fb2-461a-ae71-28927e209f8d", "Incidents", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-c17e542d-6fb2-461a-ae71-28927e209f8d']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}

	/** 
	* This is method is used to Verify Apprentices Widget Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void widget_Apprentices_Present()
	{
		String[] attributes = new String[] { "Apprentices" };
		dashboardWidgetPresent("Widget-2c6035a4-6854-4c44-a3d5-07cfa693132e", "Apprentices", attributes);
		Assert.assertTrue(BaseClass.isElementPresentByXpath("//div[@id='Widget-2c6035a4-6854-4c44-a3d5-07cfa693132e']//i[@class='fa fa-question-circle ui-tooltip']"), "Unable to find tooltip");
	}


	/** 
	* This is method is used to Verify Transaction  Heading Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void heading_Transactions_Present()
	{
		dashboardHeadingPresent("Transactions");
	}

	/** 
	* This is method is used to Verify Right Now On Site  Heading Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void heading_RightNowOnSite_Present()
	{
		dashboardHeadingPresent("Right now on Site");
	}

	/** 
	* This is method is used to Verify Trained Operatives  Heading Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void heading_TrainedOperatives_Present()
	{
		dashboardHeadingPresent("Trained Operatives on Site");     
	}

	/** 
	* This is method is used to Verify On Site  Heading Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void heading_OnSite_Present()
	{
		dashboardHeadingPresent("On Site");
	}

	/** 
	* This is method is used to Verify On Site Selection Box  Heading Presence 
	* No argument ,return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void heading_OnSite_SelectionBox()
	{
		String selectionBoxPath = "//select[@data-dashboard-row-filter='DateRangeFilter']";
		String[] values = new String[] { "Today", "Yesterday", "This Week", "This Month", "This Quarter", "This Year", "All Time" };
		Assert.assertTrue(isElementPresentByXpath(selectionBoxPath), "Unable to find the Onsite selection box.");
		for (String value : values)
		{
			Assert.assertTrue((isElementPresentByXpath(selectionBoxPath + "//option[contains(text(),'"+value+"')]")), "Unable to find " + value + " within the onsite selection box");
		}
	}

	/** 
	* This is method is used to Verify Dashboard Widget Present
	* Taking two String arguments,one String array argument
	* return type is String , access modifier is public
	* @author Deepak Malviya 
	*/
	public void dashboardWidgetPresent(String widgetID, String widgetHeading, String[] tableAttributes)
	{
		Assert.assertTrue(isElementPresentById(widgetID), "Unable to find widget id");
		Assert.assertTrue(isElementPresentByXpath("//*[@id='" + widgetID + "']//*[contains(text(),'" + widgetHeading + "')]"), "Unable to find widget heading");
		for (String str : tableAttributes)  
		{ 
			Assert.assertTrue(isElementPresentByXpath("//*[@id='" + widgetID + "']//*[contains(text(),'" + str + "')]"), "unable to find attribute");
		} 
	}

	public void dashboardHeadingPresent(String headingText)
	{
		Assert.assertTrue(isElementPresentByXpath("//div[@class='panel-heading dashboard-widget-row-heading']//*[contains(text(),'" + headingText + "')]"), "Unable to find heading: " + headingText);
	}
	public void changeSiteTest(String siteName) 
	{
		allSiteDropdown.click();
		waitForSeconds(1);
        clickOnSiteInSelectionox(siteName);
		List<WebElement> list = allWidgetheadings.findElements(By.xpath("./small"));

		for (WebElement label :list)
		{
			Assert.assertTrue(label.getText().contains(siteName), "Expected '{label.Text}' to contains '{siteName}'.");
		}

	}

	public void widget_LastestTransactions_Report(String transactionDiagnosticsReportTitle) 
	{
		String employeeList[]=widget_AttributesAvailableData(1,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		String contractorList[]=widget_AttributesAvailableData(2,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		String timeStampList[]=widget_AttributesAvailableData(3,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		String eventList[]=widget_AttributesAvailableData(4,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		String siteNameList[]=widget_AttributesAvailableData(5,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		String doorList[]=widget_AttributesAvailableData(6,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		String areaList[]=widget_AttributesAvailableData(7,"Widget-36b6d24a-8514-4dd0-939a-23b4466c8148");
		dashboardWidgetReport("Latest 10 Transactions", transactionDiagnosticsReportTitle);
		if(checkDataAvailabilityForWidgetInDashboard("Widget-36b6d24a-8514-4dd0-939a-23b4466c8148"))
		{
		  verifyLatest_10_Transaction_Data_From_DashboardPage_In_ReportPage(employeeList,contractorList,timeStampList,eventList,siteNameList,doorList,areaList);
	   }
	}	

	public void widget_Top10TradeOnSite_Report(String transactionDiagnosticsReportTitle) 
	{	
		String tradeList[]=widget_AttributesAvailableData(1,"Widget-5c2169ac-6bca-48a9-b4c9-b8a9c5d04b88");
	   String countList[]=widget_AttributesAvailableData(2,"Widget-5c2169ac-6bca-48a9-b4c9-b8a9c5d04b88");
	   dashboardWidgetReport("Top 10 Trade On Site", transactionDiagnosticsReportTitle);
	   if(checkDataAvailabilityForWidgetInDashboard("Widget-5c2169ac-6bca-48a9-b4c9-b8a9c5d04b88")) 
	   {
	    verify_Trades_On_Site_DashbaordData_InReportPage(tradeList,countList);
	   }
	}

	public void widget_PeopleOnSite_Report(String rollCallReportTitle) 
	{
		String peopleOnSiteCount=FindElement("xpath", "//span[@data-original-title='Total people across all areas']").getText();
		dashboardWidgetReport("People On Site", rollCallReportTitle);
		  if(!peopleOnSiteCount.equalsIgnoreCase("0"))
		  {
		     verify_People_On_Site_Data_InReportPage(peopleOnSiteCount);
		  }
	}

	public void widget_Top10ContractorsOnSite_Report(String rollCallContractorReportTitle) 
	{
		String contractorList[]=widget_AttributesAvailableData(1,"Widget-8c7355eb-710e-4fa5-b4b1-acc6e1cf8a69");
		String countList[]=widget_AttributesAvailableData(2,"Widget-8c7355eb-710e-4fa5-b4b1-acc6e1cf8a69");
		dashboardWidgetReport("Top 10 Contractors On Site", rollCallContractorReportTitle);
		 if(checkDataAvailabilityForWidgetInDashboard("Widget-8c7355eb-710e-4fa5-b4b1-acc6e1cf8a69")) 
		 {
			 verify_Contractor_On_Site_Data_InReportPage(contractorList,countList);
		 }
		
	}

	public void widget_SSSTS_Report(String rollCallPersonnelReportTitle) 
	{
		String SSSTSCount=FindElement("xpath", "//div[@id='Widget-737c153b-742d-46fb-ad7f-78c1dbb54f16']//span[@class='badge ui-tooltip']").getText();
		dashboardWidgetReport("SSSTS", rollCallPersonnelReportTitle);
		if(!SSSTSCount.equalsIgnoreCase("0"))
		  {
			verify_Trained_Operatives_On_Site_Data_InReportPage(SSSTSCount);
		  }
		
	}

	public void widget_SMSTS_Report(String rollCallPersonnelReportTitle) 
	{
		String SMSTSCount=FindElement("xpath", "//div[@id='Widget-c5afacf3-39c5-48a6-8c20-281c7585948e']//span[@class='badge ui-tooltip']").getText();
		dashboardWidgetReport("SMSTS", rollCallPersonnelReportTitle);
		if(!SMSTSCount.equalsIgnoreCase("0"))
		  {
			verify_Trained_Operatives_On_Site_Data_InReportPage(SMSTSCount);
		  }
	}

	public void widget_FireMarshal_Report(String rollCallPersonnelReportTitle)
	{
		String FireMarshalCount=FindElement("xpath", "//div[@id='Widget-449e661f-6326-4cf1-9dd6-5cf2c96b8e81']//span[@class='badge ui-tooltip']").getText();
		dashboardWidgetReport("Fire Marshal", rollCallPersonnelReportTitle);
		if(!FireMarshalCount.equalsIgnoreCase("0")) {
		verify_Trained_Operatives_On_Site_Data_InReportPage(FireMarshalCount);
		}

	}

	public void widget_FirstAid_Report(String rollCallPersonnelReportTitle) 
	{
		dashboardWidgetReport("First Aid", rollCallPersonnelReportTitle);
	}

	public void widget_Incidents_Report(String incidentAuditReportTitle) 
	{
		FindElement("xpath", "//div/strong[contains(text(), 'Incidents')]/..//a").click();
		waitForSeconds(1);
		Assert.assertEquals(incidentAuditReportTitle, driver.getTitle());
	}

	public void widget_Apprentices_Report(String apprenticeListReportTitle) 
	{
		dashboardWidgetReport("Apprentices", apprenticeListReportTitle);
	}


	public void dashboardWidgetReport(String widgetHeading, String expectedTitle) 
	{
		FindElement("xpath", "//div/strong[contains(text(), '"+widgetHeading+"')]/..//a").click();
		waitForSeconds(3);
		Assert.assertEquals(expectedTitle, driver.getTitle()); 
		waitForSeconds(2);      
	}

	public void widget_OperativeOnSite_HistrogramVisibilityCheck(String visible) 
	{
		boolean visiblity=change_VisiblityofOperativeOnSite_FromSystemSetting(visible);
		waitForSeconds(3);
		clickOnDashboard();
		waitForSeconds(1);
		if(visiblity) 
		{
			Assert.assertTrue(isElementPresent(totalOperativeOnSiteAll), "Total Operative on site all histrogram is missing");
			Assert.assertTrue(isElementPresent(totalOperativeOnSiteByContractor), "Total Operative on site by Contractor histrogram is missing");
		}
		else 
		{
			Assert.assertFalse(isElementPresent(totalOperativeOnSiteAll), "Total Operative on site all histrogram is missing");
			Assert.assertFalse(isElementPresent(totalOperativeOnSiteByContractor), "Total Operative on site by Contractor histrogram is missing");
		}

	}

	public boolean change_VisiblityofOperativeOnSite_FromSystemSetting(String visible)  
	{
		FindElement("xpath", "//a[@href='/System']").click();
		waitForSeconds(1);
		FindElement("xpath", "//a[@href='/System/Settings']").click();
		waitForSeconds(1);
		FindElement("xpath", "//input[@placeholder='Search settings...']").click();
		waitForSeconds(1);
		FindElement("xpath", "//input[@placeholder='Search settings...']").sendKeys("Operative");
		waitForSeconds(1);
		FindElement("xpath", "//td[contains(text(),'Dashboard:OperativesOnSite')]").click();
		waitForSeconds(1);
		WebElement visibility= FindElement("xpath", "//select[@id='BooleanValue']");
		visibility.click();
		if(visible.equalsIgnoreCase("Enabled"))
		{
			selectValueByIndex(visibility, 0);
			FindElement("xpath", "//button[@class='btn btn-primary']").click();
			waitForSeconds(1);
			return true;
		}
		else
		{
			selectValueByIndex(visibility, 1);
			FindElement("xpath", "//button[@class='btn btn-primary']").click();
			waitForSeconds(1);
			return false;
		}

	}

	public void dashboard_AddNewCustomDashboardWidget_And_Verify() 
	{
		FindElement("xpath", "//a[@href='/System']").click();
		waitForSeconds(1);
		FindElement("xpath", "//a[contains(text(),'Custom Fields')]").click();
		waitForSeconds(1);
		FindElement("xpath", "//input[@placeholder='Search custom fields...']").sendKeys("Gender");
		waitForSeconds(1);
		FindElement("xpath", "//td[contains(text(),'Gender')]").click();
		waitForSeconds(1);
		WebElement hidden=FindElement("xpath", "//input[@id='Hidden']");
		if(hidden.isSelected()) 
		{
			hidden.click();
			waitForSeconds(1);
		}
		FindElement("xpath", "//button[@class='btn btn-primary']").click();
		waitForSeconds(4);
		FindElement("xpath", "//div[@class='collapse navbar-collapse bs-navbar-collapse no-padding text-center']//a[contains(text(),'Employees')]").click();
		waitForSeconds(2);
		FindElement("xpath", "//a[contains(text(),'Add a New Employee')]").click();
		waitForSeconds(2);
		if(isElementPresentByXpath("//label[contains(text(),'Gender')]")) 
		{
			String customFieldText=FindElement("xpath", "//label[contains(text(),'Gender')]").getAttribute("for");
			String customFieldValue="";
			for(int i=0;i<customFieldText.length();i++)
			{
				if(Character.isDigit(customFieldText.charAt(i))) 
				{
					customFieldValue=String.valueOf(customFieldText.charAt(i));
					break;
				}
			}
			setValueAndTitleForCustomFieldInSetting("CustomField1",customFieldValue);
			setValueAndTitleForCustomFieldInSetting("CustomFieldTitle1","Gender");
			clickOnDashboard();
			waitForSeconds(2);
		}

	}

	public void setValueAndTitleForCustomFieldInSetting(String fieldName,String fieldValue) 
	{
		FindElement("xpath", "//a[@href='/System']").click();
		waitForSeconds(1);
		FindElement("xpath", "//a[@href='/System/Settings']").click();
		waitForSeconds(1);
		FindElement("xpath", "//input[@placeholder='Search settings...']").click();
		waitForSeconds(1);
		FindElement("xpath", "//input[@placeholder='Search settings...']").sendKeys(fieldName);
		waitForSeconds(1);
		FindElement("xpath", "//td[contains(text(),'"+fieldName+"')]").click();
		waitForSeconds(1);
		if(fieldName.equalsIgnoreCase("CustomField1")) 
		{
		FindElement("id", "NumberValue").clear();
		FindElement("id", "NumberValue").sendKeys(fieldValue);
		}
		else 
		{
			FindElement("id", "StringValue").clear();
			FindElement("id", "StringValue").sendKeys(fieldValue);
		}
		waitForSeconds(1);
		FindElement("xpath", "//button[@class='btn btn-primary']").click();
		waitForSeconds(4);
	}

	public void updateOnSiteFilter_and_CheckLatestTransaction(String filter,String site)
	{
		WebElement onSiteFilter=FindElement("id", "OrderedWidgetRows_3__filters_0_");
		scrollToElement(onSiteFilter);
		selectValueByVisibleText(onSiteFilter, filter);
		waitForSeconds(1);
		WebElement siteFilter=FindElement("xpath", "//select[@id='filters_0_']");
		scrollToElement(siteFilter);
		selectValueByVisibleText(siteFilter, site);
		waitForSeconds(1);
	}

	public int changeMonthNameIntoMonthNumber(String month) 
	{
		int monthNumber = 0;
		switch (month) {
		case "Jan":  monthNumber = 1;
		break;
		case "Feb":  monthNumber = 2;
		break;
		case "Mar":  monthNumber = 3;
		break;
		case "Apr":  monthNumber = 4;
		break;
		case "May":  monthNumber = 5;
		break;
		case "Jun":  monthNumber = 6;
		break;
		case "jul":  monthNumber = 7;
		break;
		case "Aug":  monthNumber = 8;
		break;
		case "Sept":  monthNumber = 9;
		break;
		case "Oct": monthNumber = 10;
		break;
		case "Nov": monthNumber = 11;
		break;
		case "Dec": monthNumber = 12;
		break;
		default:
			break;
		}

		return monthNumber;
	}

	public String[] widget_AttributesAvailableData(int i,String id) 
	{
		String data[]=new String[10];
		try 
		{
			if(isElementPresentByXpath("//div[@id='"+id+"']//td")) 
			{   int j=0;
			List<WebElement> attributesDataList=driver.findElements(By.xpath("//div[@id='"+id+"']//td["+i+"]"));
			for(WebElement attributedata:attributesDataList) 
			{
				data[j]=attributedata.getText();
				j++;
			} 
			}
			return data;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return data;  
	}

	public boolean checkDataAvailabilityForWidgetInDashboard(String id) 
	{
		boolean available=false;
		try 
		{
			if(isElementPresentByXpath("//div[@id='"+id+"']//td"))
			 available=true;
		}
		catch(Exception e)
		{
			 available=false;
		}
		return available;
	
	}
	public void verifyLatest_10_Transaction_Data_From_DashboardPage_In_ReportPage(String employeeList[],String contractorList[],String timeStampList[],String eventList[],String siteNameList[],String doorList[],String areaList[])  
	{
		if(timeStampList.length !=0) 
		{
			String Date=leastDateInTimeStamp(timeStampList);
			String dateArray[]=Date.split(" ");
			int month=changeMonthNameIntoMonthNumber(dateArray[0]);
			String fromDateText=dateArray[1]+"/"+month+"/"+dateArray[2];
			WebElement fromDateField=FindElement("xpath", "//input[@id='Parameters_0__Value_0_']");
			fromDateField.clear();
			fromDateField.sendKeys(fromDateText);
			fromDateField.sendKeys(Keys.ENTER);
			waitForSeconds(1);
			FindElement("xpath", "//select[@id='Parameters_2__Value']/following-sibling::span").click();
			waitForSeconds(1);
			FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
			waitForSeconds(1);
			for(String site:siteNameList)
			{
				FindElement("xpath", "//li[contains(text(),'"+site+"')]").click();
			}
			FindElement("xpath", "//label[contains(text(),'Area')]").click();
			waitForSeconds(1);
			FindElement("xpath", "//select[@id='Parameters_3__Value']/following-sibling::span").click();
			waitForSeconds(1);
			FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
			waitForSeconds(1);
			for(String area:areaList)
			{
				FindElement("xpath", "//li[contains(text(),'"+area+"')]").click();
			}
			FindElement("xpath", "//label[contains(text(),'Door')]").click();
			waitForSeconds(1);
			FindElement("xpath", "//select[@id='Parameters_4__Value']/following-sibling::span").click();
			waitForSeconds(1);
			FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
			waitForSeconds(1);
			for(String door:doorList)
			{
				FindElement("xpath", "//li[contains(text(),'"+door+"')]").click();
			}
			FindElement("xpath", "//label[contains(text(),'Contractor')]").click();
			waitForSeconds(1);
			FindElement("xpath", "//select[@id='Parameters_5__Value']/following-sibling::span").click();
			waitForSeconds(1);
			FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
			waitForSeconds(1);
			for(String contractor:contractorList)
			{
				WebElement input=FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']");
				input.clear();
				input.sendKeys(contractor);
				waitForSeconds(1);
				FindElement("xpath", "//li[contains(text(),'"+contractor+"')]").click();
			}
			FindElement("xpath", "//label[contains(text(),'Employee')]").click();
			waitForSeconds(1);
			FindElement("xpath", "//select[@id='Parameters_7__Value']/following-sibling::span").click();
			waitForSeconds(1);
			FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
			waitForSeconds(1);
			for(String event:eventList)
			{
				WebElement input=FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']");
				input.clear();
				input.sendKeys(event);
				waitForSeconds(1);
				FindElement("xpath", "//li[contains(text(),'"+event+"')]").click();
			}
			FindElement("xpath", "//label[contains(text(),'Employee')]").click();
			waitForSeconds(1);
		}
		 FindElement("xpath", "//button[contains(@class,'btn btn-default inline reportrun')]").click();
		 waitForSeconds(2);

		if(isElementPresent(noResultFound)) 
		{
			Assert.assertTrue(true,"result found");
		}
		else 
		{
			Assert.assertTrue(isElementPresentByXpath("//table[contains(@class,'a115')]"), "Report is not gennerated");
		}

	}

	public void verify_Trades_On_Site_DashbaordData_InReportPage(String tradeList[],String countList[]) 
	{
		FindElement("xpath", "//select[@id='Parameters_4__Value']/following-sibling::span").click();
		waitForSeconds(1);
	    FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
	    waitForSeconds(1);
		for(String trade:tradeList)
		{
			WebElement input=FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']");
			input.clear();
			input.sendKeys(trade);
			waitForSeconds(1);
			FindElement("xpath", "//li[contains(text(),'"+trade+"')]").click();
		}
		int countTotal=0;
		for(String count:countList) 
		{
			countTotal=countTotal+Integer.parseInt(count);
		}
		FindElement("xpath", "//button[contains(@class,'btn btn-default inline reportrun')]").click();
		waitForSeconds(2);
		if(isElementPresent(noResultFound)) 
		{
			Assert.assertTrue(true,"result found");
		}
		else
		{
			for(String trade:tradeList)
			{
				Assert.assertTrue(isElementPresentByXpath("//div[contains(text(),'"+trade+"')]"), trade+" is missing");
			}

			int grandTotal=Integer.parseInt(FindElement("xpath", "//div[@class='a97']").getText());
			Assert.assertEquals(countTotal, grandTotal);
		}
	} 

	public void verify_People_On_Site_Data_InReportPage(String peopleOnSiteCount)  
	{
		FindElement("xpath", "//button[contains(@class,'btn btn-default inline reportrun')]").click();
		waitForSeconds(2);
		if(isElementPresent(noResultFound)) 
		{
			Assert.assertTrue(true,"result found");
		}else 
		{
			String total=FindElement("xpath", "//div[@class='a100']").getText();
			Assert.assertEquals(total, peopleOnSiteCount);
		}
	}

	public void verify_Trained_Operatives_On_Site_Data_InReportPage(String Count)  
	{
		FindElement("xpath", "//button[contains(@class,'btn btn-default inline reportrun')]").click();
		waitForSeconds(2);
		if(isElementPresent(noResultFound)) 
		{
			Assert.assertTrue(true,"result found");
		}else 
		{
			String total=FindElement("xpath", "//div[@class='a100']").getText();
			Assert.assertEquals(total, Count);
		}
	}
	public void verify_Contractor_On_Site_Data_InReportPage(String contractorList[],String countList[]) 
	{
		FindElement("xpath", "//select[@id='Parameters_2__Value']/following-sibling::span").click();
		waitForSeconds(1);
		FindElement("xpath", "//strong[contains(text(),'Unselect All')]").click();
		waitForSeconds(1);
		for(String contractor:contractorList)
		{
			WebElement input=FindElement("xpath", "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']");
			input.clear();
			input.sendKeys(contractor);
			waitForSeconds(1);
			FindElement("xpath", "//li[contains(text(),'"+contractor+"')]").click();
		}
		FindElement("xpath", "//button[contains(@class,'btn btn-default inline reportrun')]").click();
		waitForSeconds(2);
		if(isElementPresent(noResultFound)) 
		{
			Assert.assertTrue(true,"result found");
		}else {
			int countTotal=0;
			for(String count:countList) 
			{
				countTotal=countTotal+Integer.parseInt(count);
			}
			int grandTotal=0;
			for(String contractor:contractorList)
			{
				Assert.assertTrue(isElementPresentByXpath("//div[text()='"+contractor+"']"), contractor +" is missing");
				grandTotal=grandTotal+Integer.parseInt(FindElement("xpath", "//div[contains(@class,'a100')]").getText());
				while(FindElement("xpath", "//div[@id='main-body']//span[text()='›']").isEnabled()) 
				{
					FindElement("xpath", "//div[@id='main-body']//span[text()='›']").click();
					waitForSeconds(1);
				}
			}
			Assert.assertEquals(countTotal, grandTotal);
		}
	}

	public String leastDateInTimeStamp(String timeStampList[]) 
	{
		int result=0;
		String month="",year="";
		for(int i=0;i<timeStampList.length;i++)
		{
			String[] arrOfStr = timeStampList[i].split("[ ,]", 5); 
			month=arrOfStr[0];
			year=arrOfStr[3];
			result = Integer.parseInt(arrOfStr[1]);

		}
		String x =month +" "+ result+" "+year;
		return x;
	}

}
