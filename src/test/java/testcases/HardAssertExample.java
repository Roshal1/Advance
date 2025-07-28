package testcases;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {
	@Test
	public void demo() {
		String expectedTitle="Facebook – log in or sign u";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		@Nullable
		String actualtitle = driver.getTitle();
		
		Assert.assertEquals(actualtitle, expectedTitle);
		System.out.println("step1");
		System.out.println("step2");

		System.out.println("step 32");
		System.out.println();

	
		
	}

}
