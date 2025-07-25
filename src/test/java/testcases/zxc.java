package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zxc {
public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.instagram.com/");
	Date d=new Date();
	String newDate = d.toString().replace(" ","_").replace(":","_");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File perm = new File("./errorShots/takeSS_"+newDate+".png");
	org.openqa.selenium.io.FileHandler.copy(temp, perm);
	//Thu Jul 17 12:46:58 IST 2025
	//Thu Jul 17 12:47:36 IST 2025
}
}
