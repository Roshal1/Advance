package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled{
	@Test(enabled = true)
	public void a11() {
		Reporter.log("a11 done",true);
	}
@Test(enabled = false)
public void a22() {
	Reporter.log("a22 done",true);

}
@Test
public void a10()
{
	Reporter.log("a10 executed",true);
}
}

