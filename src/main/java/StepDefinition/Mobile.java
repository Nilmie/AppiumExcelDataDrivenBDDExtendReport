package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import Utility.ReadExcel;
import Utility.ExtendReport;


public class Mobile {
	
	static public AndroidDriver<MobileElement> driver, tempDrv;
    static public AndroidDriver<MobileElement> driver2;
	
	@Given("^I have Opens a calculator Application$")
	public void i_have_Opens_a_calculator_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("deviceName","HYMFM7QSTGSWZ5SC");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.android.bbkcalculator");
        capabilities.setCapability("appActivity", "com.android.bbkcalculator.Calculator"); 
        
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  
	}

	@When("^When click on two buttons and  click on Equals button$")
	public void when_click_on_two_buttons_and_click_on_Equals_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String number1=ReadExcel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1");
        String number2=ReadExcel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1");
        String answer=ReadExcel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1");
        
        driver.findElementById("com.android.bbkcalculator:id/digit"+number1).click();
        
        driver.findElementById("com.android.bbkcalculator:id/plus").click();
     
        driver.findElementById("com.android.bbkcalculator:id/digit"+number2).click();
         
         WebElement equalTo = driver.findElementById("com.android.bbkcalculator:id/equal");
         equalTo.click();
         
	    
	}

	@Then("^I should navigate display the correct answer$")
	public void i_should_navigate_display_the_correct_answer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement results = driver.findElementById("com.android.bbkcalculator:id/input_edit");
        Assert.assertEquals(results.getText(), ReadExcel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	}

}
