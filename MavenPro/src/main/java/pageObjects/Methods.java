package pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.Assert;

import utilities.TestBase;

public class Methods extends TestBase {

	
	public static void openBrowser() throws IOException {
		driver = initializeDriver();
	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
		
	}

	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void navigatetoApplication(String baseURL) {
		driver.get(baseURL);
	}

	public static void enterUserName(String locName,String locValue,String userName) {
		if(locName.equals("id")) {
			driver.findElement(By.id(locValue)).sendKeys(userName);
		}
		else if(locName.equals("name")) {
			driver.findElement(By.name(locValue)).sendKeys(userName);
		}
	}

	public static void enterPassword(String locName,String locValue,String password) {
		if(locName.equals("id")) {
			driver.findElement(By.id(locValue)).sendKeys(password);
		}
		else if(locName.equals("name")) {
			driver.findElement(By.name(locValue)).sendKeys(password);
		}
	}

	public static void clickSubmit(String locName,String locValue) {
		if(locName.equals("id")) {
			driver.findElement(By.id(locValue)).click();
		}
		else if(locName.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
	}


	@SuppressWarnings("deprecation")
	public static void verifyErrorMessage(String locName,String locValue,String expectedResult) {
		String actualResult = null ;
		if(locName.equals("id")) {
			actualResult = driver.findElement(By.id(locValue)).getText();
		}
		else if(locName.equals("cssSelector")) {
			actualResult = driver.findElement(By.cssSelector(locValue)).getText();
		}
		Assert.assertEquals(expectedResult, actualResult);

	}

	public static void closeBrowser() {
		driver.close();
		driver=null;
	}

}
