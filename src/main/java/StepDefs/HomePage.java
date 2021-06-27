package StepDefs;

import org.openqa.selenium.By;

import Utilities.Config;
import Utilities.Utility;
import io.cucumber.java.en.Then;

public class HomePage
{
	By btnLogin=By.id(Config.getProperties("homePage.submitButton.id"));
//	private Utility base;
//	public HomePage(Utility base)
//	{
//		this.base=base;
//	}
	
	@Then("^User click on submit button$")
	public void User_clickonsubmitbutton() throws Throwable {
		Utility.driver.findElement(btnLogin).click();	
		 	    }
	@Then("^User landed on home page$")
	public void User_landed_on_home_page() throws Throwable {
//	   WebDriverWait wait=new WebDriverWait(Utility.driver, 1000);
//	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Welcome')]")));
	   Utility.driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
		Thread.sleep(1000);
		System.out.println("From another feature step:"+Utility.SharedData.get("Username"));
	    
	}
	}
