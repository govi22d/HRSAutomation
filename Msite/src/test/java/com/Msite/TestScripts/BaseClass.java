package com.Msite.TestScripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.Msite.Utilities.ReadConfig;
import com.Msite.Utilities.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();
    public String siteUsername=readconfig.getSiteUsername();
    public String sitePassword=readconfig.getSitePassword();
    public String contractorUsername=readconfig.getContractorUsername();
    public String contractorPassword=readconfig.getContractorPassword();
    public String emptyusername=readconfig.getEmptyUsername();
    public String emptypassword=readconfig.getEmptyPassword();
    public String invalidusername=readconfig.getInvalidUsername();
    public String invalidpassword=readconfig.getInvalidPassword();
    public static WebDriver driver;
    public static Logger logger;

    
  
	@Parameters("browser")
    
   @BeforeClass
    public void setUp(String browser)
    {
    	   logger= Logger.getLogger("Msite");
    	   PropertyConfigurator.configure("log4j.properties");
    	   
    	  if(browser.equalsIgnoreCase("chrome"))
    	{
			
    	       System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
    	       driver = new ChromeDriver();
    	       Reporter.log("Chrome browser is launched");
  	  }
    	
    	else if(browser.equalsIgnoreCase("firefox")) 
    	{
    		System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
      	    driver = new FirefoxDriver();

    	}
    	else if(browser.equalsIgnoreCase("ie"))
    	{
    		System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
      	    driver = new InternetExplorerDriver();
    		
    	}
    	 
    	  driver.manage().window().maximize();
    	  Reporter.log("Browser is maximized");
    	  driver.get(baseUrl);
    	  Reporter.log(baseUrl + " is open in browser");
    	  logger.info("Given url is open");
    }
    
  
	@AfterClass
    public void tearDown() 
    {
    	driver.quit();
    }
    
    public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
    
    
    public static boolean isElementPresent(WebElement elmt) {
		boolean display = false;

		try {
			elmt.isDisplayed();
			logger.info(elmt + " displayed");
			display = true;
		} catch (Exception e) {
			logger.info(elmt + " Not displayed");
			display = false;
		}

		return display;
	}

    public static boolean isElementEnabled(WebElement elmt) {
		boolean enable = false;

		try {
			elmt.isEnabled();
			logger.info(elmt + " enabled");
			enable = true;
		} catch (Exception e) {
			logger.info(elmt + " Not enabled");
			enable = false;
		}

		return enable;
	}

    public static boolean isElementPresentById(String Id)
    {
    	boolean display = false;
    	WebElement ele=driver.findElement(By.id(Id));
    	
    	try {
    		if(ele.isDisplayed()) {
			logger.info(ele + " displayed");
			display = true;
    		} 
    		
		} catch (Exception e) {
			logger.info(ele + " Not displayed");
			display = false;
		}

    	return display;
    }
    
    
    
    public static boolean isElementPresentByXpath(String xpath)
    {
    	boolean display = false;
    	WebElement ele=driver.findElement(By.xpath(xpath));
    	
    	try {
    		if(ele.isDisplayed()) {
			logger.info(ele + " displayed");
			display = true;
    		} 
    		
		} catch (Exception e) {
			logger.info(ele + " Not displayed");
			display = false;
		}

    	return display;
    }
    
    public void clickOnSiteInSelectionox(String siteName)
    {
    	WebElement ele=driver.findElement(By.xpath("//*[@id='filters_0_']/*[contains(text(), '"+siteName+"')]"));
    	ele.click();
    	
    }
    
    public static WebElement FindElement( String method, String nameToFind)
    {
        String failMsg = "Unable to find element: " + nameToFind;
      if(method.equalsIgnoreCase("id")) 
      {
    	  Assert.assertTrue(isElementPresentById(nameToFind), failMsg);
          return driver.findElement(By.id(nameToFind));
      }
      else if(method.equalsIgnoreCase("xpath"))
      {
    	  Assert.assertTrue(isElementPresentByXpath(nameToFind), failMsg);
    	  return driver.findElement(By.xpath(nameToFind));
      }
      else
      {
    	  Assert.fail("In FindElement: Invalid find method " + method);
          return null;
      }
        
    }
    public static void selectValueByVisibleText(WebElement wb, String visibletext) {
		
		Select select = new Select(wb);
		select.selectByVisibleText(visibletext);
	   logger.info("Selected value " + visibletext);
	}

	public static void selectValueByIndex(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);
	}

	public  static void selectValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
		logger.info("Selected value : " + value);
	}
    
	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				logger.info("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				logger.info("Clicked on " + element);
				//waitForJSjQuerytoLoad();
			} else {
				logger.info("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			logger.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			logger.info("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			logger.info("Unable to click on element " + e.getStackTrace());
		}
	}

	public static boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}
	public static void isAlertAction(String Action) 
	{ 
	    try 
	    { 
	       Alert alert= driver.switchTo().alert(); 
	       if(Action.equalsIgnoreCase("accept"))
	       alert.accept();
	       else
	    	   alert.dismiss();
	         
	    }   // try 
	    catch (NoAlertPresentException e) 
	    { 
			e.printStackTrace();
	    }   
	}
	
	 public static String getAlphaNumericString(int n,String type) 
     {
		 String ALPHA_NUMERIC_STRING="";
		 if(type.contains("character")) 
		 {
		   ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 }
		 else if(type.contains("numeric"))
		 {
			 ALPHA_NUMERIC_STRING = "0123456789";
		 }	
		 else 
		 {
			 ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#!$%&*<";
		 }
		 int count=n;
		 StringBuilder builder = new StringBuilder();
		 while (count-- != 0) {
		 int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		 builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		 }
	        return builder.toString(); 
	    } 
	 
	 public static void scrollToElement(WebElement element) {
			int elementPosition = element.getLocation().getY();
			String js = String.format("window.scroll(0, %s)", elementPosition);
			((JavascriptExecutor) driver).executeScript(js);
		}
	 
	 public static void scrollToHeader() {
			String js = String.format("window.scroll(0, 0)");
			((JavascriptExecutor) driver).executeScript(js);
		}
	 public static void waitForMinute(int x)
	 {
		  try {
			Thread.sleep(x*60*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	 
	 public static void waitForSeconds(double d) 
	 {  
		  try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public static void waitForElemnetToBeVisible(WebElement element) 
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
}
