package testcases;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	@Test
	public void demo() {
		String expectedTitle = "Facebook – log in or sign u";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("R1@gmail.com");
		@Nullable
		String actualTitle = driver.getTitle();
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle);
		System.out.println("Step 1");
		System.out.println("Step 2");
		soft.assertAll();
	}

}
