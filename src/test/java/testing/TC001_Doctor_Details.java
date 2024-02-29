package testing;


import org.testng.annotations.Test;
import pageObject.Doctor_Details;

public class TC001_Doctor_Details extends BaseClass{
	
	
	public Doctor_Details dd;

	@Test(groups= {"sanity"})
	//@Test(priority=1)
	public void Get_Doctor_Details() throws InterruptedException {
		BaseClass.getLogger().info("****** Starting TC001_Doctor_Details *******");
		dd = new Doctor_Details(driver);
		dd.get_City();
		dd.get_Doctors();
		dd.print_Doctor_Names();
		
	}
	
	
	

}
