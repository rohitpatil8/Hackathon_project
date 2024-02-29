package testing;

import org.testng.annotations.Test;

import pageObject.Surgeries;

public class TC002_Surgeries extends BaseClass{
	
	public Surgeries sr;
	
	
	@Test(groups= {"sanity"})
	//@Test(priority=2)
	public void get_Surgeries_List() throws InterruptedException{
		BaseClass.getLogger().info("****** Starting TC002_Surgeries *******");
		sr = new Surgeries(driver);
		sr.print_Surgeries_Name();
		
	}
}
