package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PropertiesFileUtility.PropertiesUtility;

public class Propertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		//FileInputStream fis = new FileInputStream("C:\\Users\\Shrinivas Anant\\Documents\\ninzaCrmCommondata.properties");
//		FileInputStream fis= new FileInputStream("./ConfigData/ninzaCrmCommondata.properties");
//        //create object of properties file
//		Properties prop = new Properties();
//		//load all keys
//		prop.load(fis);
//		//get properties
//		String BROWSER = prop.getProperty("Browser");
//		String URL = prop.getProperty("URL");
//		String USERNAME = prop.getProperty("Username");
//		String PASSWORD = prop.getProperty("Password");
//		
		
		PropertiesUtility putil=new PropertiesUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("Url");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");

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
		
		
		//actual Script
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
	}

}
