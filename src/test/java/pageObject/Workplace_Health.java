package pageObject;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Workplace_Health extends BasePage{
	
	Properties p;
	
	public Workplace_Health(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']") WebElement Slt_Corporate;
	@FindBy(xpath="//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']//div/div") List<WebElement> drp_Corporate;
	@FindBy(xpath="(//input[@id='name'])[1]") WebElement Name;
	@FindBy(xpath="(//input[@id='organizationName'])[1]") WebElement Org_Name;
	@FindBy(xpath="(//input[@id='contactNumber'])[1]") WebElement Cont_No;
	@FindBy(xpath="(//input[@id='officialEmailId'])[1]") WebElement Email;
	@FindBy(xpath="(//select[@id='organizationSize'])[1]") WebElement drp_OrgSize;
	@FindBy(xpath="(//select[@id='interestedIn'])[1]") WebElement drp_Int;
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-grey-3'])[1]") public WebElement btn_NotDisplay;
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue'])[1]") public WebElement btn_Display;
	@FindBy(xpath="(//div[@class=\"text-center\"]/div)[1]") public WebElement txt_Thankyou;
	
	
	public void Select_Health_Wellness_Plans() {
		Slt_Corporate.click();
		for(int i=0;i<drp_Corporate.size();i++) {
			if(drp_Corporate.get(i).getText().equalsIgnoreCase("Health & Wellness Plans")) {
				drp_Corporate.get(i).click();
			}
		}
	}
		
		
	public void enter_Wrong_Details() {
		p = testing.BaseClass.p;
		Name.sendKeys(p.getProperty("wrongName"));
		Org_Name.sendKeys(p.getProperty("wrongOrg"));
		Cont_No.sendKeys(p.getProperty("wrongCon"));
		Email.sendKeys(p.getProperty("wrongEmail"));
		Select sl = new Select(drp_OrgSize);
		sl.selectByVisibleText("501-1000");
		Select sl1 = new Select(drp_Int);
		sl1.selectByVisibleText("Taking a demo");
		btn_NotDisplay.isDisplayed();
		
	}
	
	public void clear_All_Fields() throws InterruptedException {
		Thread.sleep(2000);
		Name.clear();
		Org_Name.clear();
		Cont_No.clear();
		Email.clear();
		
	}
	
	public void enter_Correct_Details() throws InterruptedException {
		Thread.sleep(2000);
		p = testing.BaseClass.p;
		Name.sendKeys(p.getProperty("correctName"));
		Org_Name.sendKeys(p.getProperty("correctOrg"));
		Cont_No.sendKeys(p.getProperty("correctCon"));
		Email.sendKeys(p.getProperty("correctEmail"));
		Select sl = new Select(drp_OrgSize);
		sl.selectByVisibleText("501-1000");
		Select sl1 = new Select(drp_Int);
		sl1.selectByVisibleText("Taking a demo");
		
		System.out.println(btn_Display.isDisplayed());
		btn_Display.click();
	}
	
	public void get_ThankYou_Message() throws InterruptedException {
		Thread.sleep(14000);
		System.out.println(txt_Thankyou.getText());
		
	}
}
