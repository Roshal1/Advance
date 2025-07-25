package testcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createDate {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login to NINZA CRM
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		Random ran = new Random();
		int rancount = ran.nextInt(10000);
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String datereq = sim.format(cal.getTime());
		
		//create Campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Roshal"+ rancount);
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys("10");
		WebElement closedate = driver.findElement(By.name("expectedCloseDate"));
		Actions act1 = new Actions(driver);
		act1.click(closedate).sendKeys(datereq).perform();
	
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
		String msg = toast.getText();
		
		if(msg.contains("Roshal"+ rancount)) {
			System.out.println("campaign is created");
		}
		else{
			System.out.println("campaign not created");
			
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		Thread.sleep(3000);
		//logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).perform();
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	     act.moveToElement(logout).click().perform();
	     

	}

}
