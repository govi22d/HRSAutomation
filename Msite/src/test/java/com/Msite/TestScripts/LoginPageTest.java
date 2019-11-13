package com.Msite.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Msite.Pages.MsiteLoginPage;

/** 
* 
* @author Deepak Malviya 
*/
public class LoginPageTest extends BaseClass 
{
	/** 
	* This Test Method Verify All Available Element in Login Page
	* @author Deepak Malviya 
	*/
	@Test(priority=1)
	public void openLoginPage_And_VerifyAllAvailableElement() 
	{
		 MsiteLoginPage mlp=new MsiteLoginPage(driver);
	     Reporter.log("Login Page is open");
		 mlp.verifyLoginPageElement();	
		 Reporter.log("All Available Web Elements are verified");
	}

	/** 
	* This Test Method Verify Automatic logout by inactivity popup for Hrs User
	* @author Deepak Malviya 
	*/
	
	@Test(priority=7, enabled=false)
	public void login_InactivityLogout_ForHRSUser() 
	{
		 MsiteLoginPage mlp=new MsiteLoginPage(driver);
		 Reporter.log("Login Page is open");
		 mlp.enterUsername(username);
		 Reporter.log("Enter Hrs username in Username Field");
		 mlp.enterPassword(password);
		 Reporter.log("Enter Password in Password Field");
		 mlp.clickOnSignIn();
		 Reporter.log("Click on SignIn Button");
		 mlp.inactivityAutomaticLogout( username);
		 Reporter.log("Verify Inactivity automatic logout Popup for Hrs User");
	}

	/** 
	* This Test Method Verify Automatic logout by inactivity popup for Site  User
	* @author Deepak Malviya 
	*/
	
	@Test (priority=8,enabled=false)
	public void login_InactivityLogout_ForSiteUser()
	{
		 MsiteLoginPage mlp=new MsiteLoginPage(driver);
		 Reporter.log("Login Page is open");
		 mlp.enterUsername(siteUsername);
		 Reporter.log("Enter Site  user username in Username Field");
		 mlp.enterPassword(sitePassword);
		 Reporter.log("Enter Password in Password Field");
		 mlp.clickOnSignIn();
		 Reporter.log("Click on SignIn Button");
		 mlp.inactivityAutomaticLogout( siteUsername);
		 Reporter.log("Verify Inactivity automatic logout Popup for Site User");
	}
	
	/** 
	* This Test Method Verify Automatic logout by inactivity popup for Contractor User
	* @author Deepak Malviya 
	*/
	
	@Test (priority=9,enabled=false)
	public void login_InactivityLogout_ForContractorUser() 
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		Reporter.log("Login Page is open");
		mlp.enterUsername(contractorUsername);
		Reporter.log("Enter Contractor  user username in Username Field");
		mlp.enterPassword(contractorPassword);
		Reporter.log("Enter Password in Password Field");
		mlp.clickOnSignIn();
	    Reporter.log("Click on SignIn Button");
		mlp.inactivityAutomaticLogout(contractorUsername);
		Reporter.log("Verify Inactivity automatic logout Popup for Contractor User");
	}

	/** 
	* This Test Method Verify Empty Username and empty Password login
	* @author Deepak Malviya 
	*/
	
	@Test (priority=2)
	public void emptyUsernameAndPassword() 
	{
		 MsiteLoginPage mlp=new MsiteLoginPage(driver);
		 Reporter.log("Login Page is open");
		 mlp.enterUsername(emptyusername);
		 Reporter.log("Username Field is empty");
		 mlp.enterPassword(emptypassword);
		 Reporter.log("Password Field is empty");
		 mlp.clickOnSignIn();
		 Reporter.log("Click on SignIn button");
		logger.info("Username and password fields are empty ");
	}

	/** 
	* This Test Method Verify Invalid Username and Invalid Password login
	* @author Deepak Malviya 
	*/
	@Test (priority=3)
	public void invalidUsernameAndInvalidPassword() 
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		Reporter.log("Login Page is open");
		mlp.enterUsername(invalidusername);
		Reporter.log("Enter Invalid username In Username Field");
		mlp.enterPassword(invalidpassword);
		Reporter.log("Enter Invalid Password in Password Field");
		mlp.clickOnSignIn();
		Reporter.log("Click on SignIn Button");
		mlp.verifyLogin();
		Reporter.log("Failed Login Message is appeared on Screen");
		logger.info("Username and password are invalid ");
	}

	/** 
	* This Test Method Verify Invalid Username and Valid Password  and Failed login
	* @author Deepak Malviya 
	*/
	@Test (priority=4)
	public void invalidUsernameAndValidPassword()  
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		Reporter.log("Login Page is open");
		mlp.enterUsername(invalidusername);
		Reporter.log("Enter Invalid username In Username Field");
		mlp.enterPassword(password);
		Reporter.log("Enter Valid Password in Password Field");
		mlp.clickOnSignIn();
		Reporter.log("Click on SignIn Button");
		mlp.verifyLogin();
		Reporter.log("Failed Login Message is appeared on Screen");
		logger.info("Username is invalid and password is valid");
	}

	/** 
	* This Test Method Verify Valid Username and Invalid Password login
	* @author Deepak Malviya 
	*/
	
	@Test  (priority=6)
	public void validUsernameAndInvalidPassword() 
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		Reporter.log("Login Page is open");
		mlp.enterUsername(username);
		Reporter.log("Enter Valid username In Username Field");
		mlp.enterPassword(invalidpassword);
		Reporter.log("Enter Invalid Password in Password Field");
		mlp.clickOnSignIn();
		Reporter.log("Click on SignIn Button");
		mlp.verifyLogin();
		Reporter.log("Failed Login Message is appeared on Screen");
		logger.info("Username is valid and password is invalid");
	}
	
	/** 
	* This Test Method Verify Valid Username and Password and Successful login
	* @author Deepak Malviya 
	*/

	@Test(priority=5)
	public void successfullLoginTest() throws  Exception
	{
		MsiteLoginPage mlp=new MsiteLoginPage(driver);
		Reporter.log("Login Page is open");
		mlp.enterUsername(username);
		Reporter.log("Enter Valid username In Username Field");
		mlp.enterPassword(password);
		Reporter.log("Enter Valid password In Password Field");
		logger.info("Username and password is entered successfully");
		mlp.clickOnSignIn();
		Reporter.log("Click on SignIn Button");
		logger.info("Login successfully");
		mlp.verifyTitle(username);
		Reporter.log("Verify Successfully Login");
		mlp.verifyLogin();
	}

}
