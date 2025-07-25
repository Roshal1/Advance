package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import PropertiesFileUtility.PropertiesUtility;
import webDriverUtility.WebDriverUtility;

public class Dummy {

	public static void main(String[] args) throws IOException {
	PropertiesUtility putil=new PropertiesUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("Url");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");
		
		ExcelUtility eutil=new ExcelUtility();
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);


		WebDriver driver = null;
		
		if(BROWSER.equals("Edge"))
		{
			driver= new EdgeDriver();
		}
		if(BROWSER.equals("Chrome"))
		{
			driver= new ChromeDriver();
		}
		if(BROWSER.equals("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		WebDriverUtility wutil=new WebDriverUtility();
		
		//actual Script
		driver.manage().window().maximize();
		wutil.waitForPageToload(driver);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		

		JavaUtility jutil=new JavaUtility();
	
		
		
		//create Campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campname+ jutil.getRandomNumber());
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys(size);
	
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));

		wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		
		if(msg.contains(campname)) {
			System.out.println("campaign is created");
		}
		else{
			System.out.println("campaign not created");
			
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));

		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	    wutil.clickonWebElement(driver, logout);
	     

	}
		
	

}
