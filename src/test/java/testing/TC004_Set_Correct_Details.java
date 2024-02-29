package testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Workplace_Health;

public class TC004_Set_Correct_Details extends BaseClass{
	
	public Workplace_Health wh;
	
	
	@Test(groups= {"sanity"})
	//@Test(priority=4)
	public void set_Correct_Details() throws InterruptedException {
		BaseClass.getLogger().info("****** Starting TC004_Set_Correct_Details *******");
		wh = new Workplace_Health(driver);
		wh.enter_Correct_Details();
		wh.get_ThankYou_Message();
		Assert.assertEquals(wh.txt_Thankyou.isDisplayed(), true);
		
	}
	
	

}
