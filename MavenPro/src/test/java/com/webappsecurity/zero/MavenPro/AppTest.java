package com.webappsecurity.zero.MavenPro;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.Methods;
import utilities.GenericMethods;
import utilities.TestBase;

public class AppTest 
{

	String path = System.getProperty("user.dir");
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	@Test
	public void applicationTest() throws IOException {
		System.out.println(path);
		String[][] data = GenericMethods.getData(path +"\\src\\main\\java\\testdata\\TestData.xlsx", "Sheet1");
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			
			case "openBrowser": //i=1, i=10
				Methods.openBrowser();
				log.info("Browser Opened Successfully");
				break;
				
			case "maxBrowser": //i=2, i=11
				Methods.maximizeBrowser();
				log.info("Browser maximised Successfully");
				break;
			
			case "impWait": //i=3, i=12
				Methods.implicitlyWait();
				log.info("Wait implemented Successfully");
				break;
				
			case "navigateToApp": //i=4, i=13
				Methods.navigatetoApplication(data[i][6]);
				log.info("Application navigated Successfully");
				break;
			
			case "enterInvalidUN": //i=5, i =14
				Methods.enterUserName(data[i][4],data[i][5], data[i][6]);
				log.info("Username entered Successfully");
				break;
			
			case "enterinvalidPassword": //i=6
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				log.info("Password entered Successfully");
				break;
			
			case "clickSubmit": //i=7
				Methods.clickSubmit(data[i][4],data[i][5]);
				log.info("Submit button pressed Successfully");
				break;
				
			case "verifyErrMsg": //i=8
				Methods.verifyErrorMessage(data[i][4],data[i][5], data[i][6]);
				log.info("Message Verified Successfully");
				//log.fatal("Message DID NOT Verified Successfully");
				break;
			
			case "closeBrowser":
				Methods.closeBrowser();
				log.info("Browser closed Successfully");
				//log.fatal("Browser DID NOT closed Successfully");
				break;
				//comment2:25pm
			}
		}
	}

}
