package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import PropertiesFileUtility.PropertiesUtility;
import webDriverUtility.WebDriverUtility;

public class productdummy {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		PropertiesUtility putil=new PropertiesUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("Url");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");
		
		
		
		ExcelUtility eutil=new ExcelUtility();
		String pname = eutil.getDataFromExcel("Product", 1, 2);
		String psize = eutil.getDataFromExcel("Product", 1, 3);
		String pprice = eutil.getDataFromExcel("Product", 1, 4);
		JavaUtility jutil=new JavaUtility();
		
//		WebDriver driver=new EdgeDriver();


		
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Products")).click();


		driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		driver.findElement(By.name("productName")).sendKeys(pname+jutil.getRandomNumber());
		
		WebElement categorydropdown=driver.findElement(By.name("productCategory"));
		//Dropdown 1
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.select(categorydropdown,"Electricals");
//		
		WebElement quantity=driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys(psize);
		
		WebElement price=driver.findElement(By.name("price"));
		quantity.clear();
		price.sendKeys(pprice);
		//DropDown 2
		WebElement vendordropdown=driver.findElement(By.name("vendorId"));
		wutil.select(vendordropdown,"VID_007" );

		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		 

	}


	}


