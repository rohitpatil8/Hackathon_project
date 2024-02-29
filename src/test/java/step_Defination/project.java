package step_Defination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Doctor_Details;
import pageObject.Surgeries;
import pageObject.Workplace_Health;
import testing.BaseClass;




public class project{
	WebDriver driver = Hooks.driver;
	Doctor_Details dd;
	Surgeries sr;
	Workplace_Health wh;
	

	@Given("get City and get Doctor type")
	
	public void get_city_and_get_doctor_type() throws InterruptedException {
	    dd = new Doctor_Details(driver);
	    dd.get_City();
	    BaseClass.getLogger().info("**** get City and get Doctor type ****");
	   //Assert.assertEquals(driver.getTitle(),"Best Dentists Near Me In Bangalore - Instant Appointment Booking, View Fees, Feedbacks | Practo");
	}

	@When("Filter the Doctor as per Requirement")
	public void filter_the_doctor_as_per_requirement() throws InterruptedException {
	    dd.get_Doctors();
	    BaseClass.getLogger().info("**** Filter the Doctor as per Requirement ****");
	}

	@Then("get Doctor Names,  Expierence, and Fees")
	public void get_doctor_names_expierence_and_fees() throws InterruptedException {
	    dd.print_Doctor_Names();
	    BaseClass.getLogger().info("get Doctor Names,  Expierence, and Fees");
	}

	@When("click on Surgeries")
	public void click_on_surgeries() {
		sr = new Surgeries(driver);
	    System.out.println(driver.getTitle());
	    //Assert.assertEquals(driver.getTitle(), "Practo Care Surgeries | End to end care from top surgeons in your city");
	    BaseClass.getLogger().info("click on Surgeries");
	}

	@Then("print all the Surgies names")
	public void print_all_the_surgies_names() throws InterruptedException {
	   sr.print_Surgeries_Name();
	   BaseClass.getLogger().info("print all the Surgies names");
	}

	@When("click the Workplace Health")
	public void click_the_workplace_health() {
	   wh = new Workplace_Health(driver);
	   wh.Select_Health_Wellness_Plans();
	   BaseClass.getLogger().info("click the Workplace Health");
	   
	}

	@When("enter the Wrong Details")
	public void enter_the_wrong_details() throws InterruptedException {
	   wh.enter_Wrong_Details();
	   Assert.assertEquals(driver.getTitle(),"Employee Health | Corporate Health & Wellness Plans | Practo");
	   BaseClass.getLogger().info("enter the Wrong Details");
	}

	@Then("check the submit button is diaplayed or not")
	public void check_the_submit_button_is_diaplayed_or_not() throws InterruptedException {
		  Assert.assertEquals(wh.btn_NotDisplay.isDisplayed(), true);
		  wh.clear_All_Fields();
		  BaseClass.getLogger().info("check the submit button is diaplayed or not"); 
	}

	@When("enter the Correct Details")
	public void enter_the_correct_details() throws InterruptedException {
	    wh.enter_Correct_Details();
	    wh.get_ThankYou_Message();
	    BaseClass.getLogger().info("enter the Correct Details"); 
	   
	}

	@Then("check the ThankYou message")
	public void check_the_thank_you_message() throws InterruptedException {
		 wh.get_ThankYou_Message();
		 driver.quit();
		 BaseClass.getLogger().info("check the ThankYou message"); 
	}
	
	
	

}
