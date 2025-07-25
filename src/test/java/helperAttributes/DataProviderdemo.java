package helperAttributes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderdemo {
	@Test(dataProvider = "loginDetails")
	
	public void login(String username,String password)
	{
		System.out.println(username+"==="+password);
	}
	
	
	@DataProvider
	public Object[][] loginDetails(){
		Object[][] objarr= new Object[3][2];
		objarr[0][0]="virat";
		objarr[0][1]="v123";
		objarr[1][0]="sachin";
		objarr[1][1]="v456";
		objarr[2][0]="rohi";
		objarr[2][1]="v789";
		
		return objarr;
	}

}
