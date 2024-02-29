package pageObject;


import java.util.List;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Doctor_Details extends BasePage{
	Properties p;
	public Doctor_Details(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="(//input[@class='c-omni-searchbox c-omni-searchbox--small'])[1]") WebElement Ent_searchCity;
	@FindBy(xpath="//i[@class='icon-ic_cross_solid']")WebElement Btn_Cross;
	@FindBy(xpath="//div[@class='c-omni-suggestion-group']/div/span[1]") List<WebElement>drp_City;
	@FindBy(xpath="(//input[@class='c-omni-searchbox c-omni-searchbox--small'])[2]") WebElement Ent_searchDoc;
	@FindBy(xpath="//span[@class='c-omni-suggestion-item__content']/div") List<WebElement> Srch_result;
	@FindBy(xpath="//div[@data-qa-id='doctor_gender_section']") WebElement Slt_Gender;
	@FindBy(xpath="//div[@data-qa-id='doctor_gender_section']/ul/li") List<WebElement> drp_Gender;
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']") WebElement Slt_Stories;
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']/ul/li") List<WebElement> drp_Stories;
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']") WebElement Slt_Exp;
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']/ul/li") List<WebElement> drp_Exp;
	@FindBy(xpath="//span[@data-qa-id='all_filters']") WebElement Slt_AllFilter;
	@FindBy(xpath="//div[@class='pure-u-6-24']//label") List<WebElement> rad_Associate;
	@FindBy(xpath="//div[@class='pure-u-4-24']/div/label") List<WebElement> rad_AllFilter;
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']") WebElement SortBy;
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']/ul/li") List<WebElement> drp_SortBy;
	@FindBy(xpath="//h2[@class='doctor-name']") List<WebElement> get_DocNames;
	@FindBy(xpath="//div[@data-qa-id='doctor_experience']") List<WebElement> get_DocExp;
	@FindBy(xpath="//span[@data-qa-id='consultation_fee']") List<WebElement> get_ConFees;
	
	
	public void get_City() throws InterruptedException{
		
		Ent_searchCity.click();
		Btn_Cross.click();
		p = testing.BaseClass.p;
		Ent_searchCity.sendKeys(p.getProperty("city"));
		Thread.sleep(2000);
		for(int i=0;i<drp_City.size();i++) {
			if(drp_City.get(i).getText().equalsIgnoreCase(p.getProperty("city"))) {
				drp_City.get(i).click();
			}
		}
		
		
		
		Ent_searchDoc.sendKeys(p.getProperty("doctor"));
		Thread.sleep(2000);
		for(int i=0;i<Srch_result.size();i++) {
			if(Srch_result.get(i).getText().equalsIgnoreCase(p.getProperty("doctor"))) {
				Srch_result.get(i).click();
			}
		}
		
	}
	
	public void get_Doctors() throws InterruptedException {
		
		Thread.sleep(2000);
		Slt_Gender.click();
		for(int i=0;i<drp_Gender.size();i++) {
			if(drp_Gender.get(i).getText().equalsIgnoreCase("Male Doctor")) {
				drp_Gender.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		Slt_Stories.click();
		for(int i=0;i<drp_Stories.size();i++) {
			if(drp_Stories.get(i).getText().equalsIgnoreCase("20+ Patient Stories")) {
				drp_Stories.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		Slt_Exp.click();
		for(int i=0;i<drp_Exp.size();i++) {
			if(drp_Exp.get(i).getText().equalsIgnoreCase("10+ Years of experience")) {
				drp_Exp.get(i).click();
			}
		}
		
		
		Thread.sleep(3000);
		Slt_AllFilter.click();
		for(int i=0;i<rad_AllFilter.size();i++) {
			if(rad_AllFilter.get(i).getText().equalsIgnoreCase("Above ₹500")) {
				rad_AllFilter.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		Slt_AllFilter.click();
		for(int i=0;i<rad_AllFilter.size();i++) {
			if(rad_AllFilter.get(i).getText().equalsIgnoreCase("Available Today")) {
				rad_AllFilter.get(i).click();
			}
		}
		
		
		Thread.sleep(3000);
		SortBy.click();
		for(int i=0;i<drp_SortBy.size();i++) {
			if(drp_SortBy.get(i).getText().equalsIgnoreCase("Consultation Fee - Low to High")) {
				drp_SortBy.get(i).click();
			}
		}
		
	}
	
	public void print_Doctor_Names() throws InterruptedException {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)");
			for(int i=0;i<5;i++) {
			System.out.println("Names: "+get_DocNames.get(i).getText()+" Exp: "+ get_DocExp.get(i).getText() +" Consulation Fees: " +get_ConFees.get(i).getText());
			}
	}
}
