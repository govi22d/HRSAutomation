package com.Msite.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
   Properties pro;
   public ReadConfig() {
	   File src= new File("./Configuration/config.properties");
	   try 
	   {
		   FileInputStream fis= new FileInputStream(src);
		   pro=new Properties();
		   pro.load(fis);
	   }
	   catch(Exception e)
	   {
		   System.out.println("Exception is" +e.getMessage());
	   }
   }
   
   public String getApplicationURL()
   {
	   String url = pro.getProperty("baseUrl");
	   return url;
   }
   public String getUsername()
   {
	   String username = pro.getProperty("username");
	   return username;
   }
   public String getPassword()
   {
	   String password = pro.getProperty("password");
	   return password;
   }
   public String getSiteUsername()
   {
	   String username = pro.getProperty("siteUsername");
	   return username;
   }
   public String getSitePassword()
   {
	   String password = pro.getProperty("sitePassword");
	   return password;
   }
   
   public String getContractorUsername()
   {
	   String username = pro.getProperty("contractorUsername");
	   return username;
   }
   public String getContractorPassword()
   {
	   String password = pro.getProperty("contractorPassword");
	   return password;
   }
   public String getChromePath()
   {
	   String chromepath = pro.getProperty("chromepath");
	   return chromepath;
   }
   public String getIEPath()
   {
	   String iepath = pro.getProperty("iepath");
	   return iepath;
   }
   public String getFirefoxPath()
   {
	   String firefoxpath = pro.getProperty("firefoxpath");
	   return firefoxpath;
   }
   
   public String getEmptyUsername()
   {
	   String emptyusername = pro.getProperty("emptyUsername");
	   return emptyusername;
   }
   
   public String getEmptyPassword()
   {
	   String emptypassword = pro.getProperty("emptyPassword");
	   return emptypassword;
   }
   public String getInvalidUsername()
   {
	   String invalidusername = pro.getProperty("invalidUsername");
	   return invalidusername;
   }
   
   public String getInvalidPassword()
   {
	   String invalidpassword = pro.getProperty("invalidPassword");
	   return invalidpassword;
   }
}
