package testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Workplace_Health;

public class TC003_Set_Wrong_Details extends BaseClass{
	
	public Workplace_Health wh;
	
	
	@Test(groups= {"sanity"})
	//@Test(priority=3)
	public void set_Wrong_Details() throws InterruptedException {
		BaseClass.getLogger().info("****** Starting TC003_Set_Wrong_Details *******");
		wh = new Workplace_Health(driver);
		wh.Select_Health_Wellness_Plans();
		wh.enter_Wrong_Details();
		Assert.assertEquals(wh.btn_NotDisplay.isDisplayed(), true);
		wh.clear_All_Fields();
	}

}
