package step_Defination;


import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import testing.BaseClass;

public class Hooks{
	
	static WebDriver driver;
	static Logger logger;
	static Properties p;


	@BeforeAll
	public static void getWebDriver() throws IOException{
	
		driver = testing.BaseClass.Intiate_WebDriver("Windows", "chrome");
		p = BaseClass.p;
		logger = BaseClass.getLogger();
	}

	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
    	
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());
    	            
      
	}
}
