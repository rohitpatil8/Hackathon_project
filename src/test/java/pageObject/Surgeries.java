package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Surgeries extends BasePage{
	
	public Surgeries(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="(//div[@class='product-tab'])[5]//div[1]") WebElement Slt_Surgeries;
	@FindBy(xpath="//div[@class='SurgicalSolutions-module_ailmentItemWrapper__Krx-u']//p") List<WebElement> get_SurgeriesName;
	
	
	
	public void print_Surgeries_Name() throws InterruptedException{
		Slt_Surgeries.click();
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
		
		System.out.println("Surgeries Name: ");
		for(int i=0;i<get_SurgeriesName.size();i++) {
			System.out.println(get_SurgeriesName.get(i).getText());
		}
		
		
	}
	
	
}
