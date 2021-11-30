package StepDefs;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import Utilities.Config;
import Utilities.ExcelData;
import Utilities.JsonConfig;
import Utilities.MainConfig;
import Utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPage 
{
	
//	private Utility base;
//	public LoginPage(Utility base)
//	{
//		this.base=base;
//	}
//	@Before
//	public void Startup()
//	{
//		
//	}
//	@After
//	public void TearDown()
//	{
//		base.driver.quit();
//	}
	By user=By.id(Config.getProperties("loginPage.username.id"));
	By pass=By.id(Config.getProperties("loginPage.password.id"));
	
	@Given("^User enters the Url \"([^\"]*)\"$")
	public void user_enters_the_Url(String url) throws Throwable {
//		Utility.startVideo();
//		ScreenRecorderUtil.startRecord("OrangeHRM");
//		System.setProperty("webdriver.chrome.driver",MainConfig.getProperties("chromeDriver"));
		WebDriverManager.chromedriver().setup();
	    Utility.driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver",MainConfig.getProperties("geckoDriver"));
//	    Utility.driver=new FirefoxDriver();
		Utility.driver.get(url);
		Utility.driver.manage().window().maximize();
		Utility.driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	}

	@When("^User landed on webpage$")
	public void user_landed_on_webpage() throws Throwable {
			Utility.driver.findElement(By.xpath("//div[contains(text(),'LOGIN Panel')]")).isDisplayed();
	    }
	@Then("^User enter the username and password from Excel and Json File$")
	public void user_enter_the_username_and_password_from_Excel_and_Json_File() throws Throwable {
		System.out.println("Excel Value :"+ExcelData.getMapData("User1"));
		System.out.println("Json Value :"+JsonConfig.readJson("Password"));
		Utility.driver.findElement(user).sendKeys(ExcelData.getMapData("User1"));
		Utility.driver.findElement(pass).sendKeys(JsonConfig.readJson("Password"));
		
		
		  Utility.SharedData.put("Username", Utility.driver.findElement(By.xpath("//div[contains(text(),'LOGIN Panel')]")).getText());
//		  JsonConfig.writJson("UserName", base.driver.findElement(By.xpath("//div[contains(text(),'LOGIN Panel')]")).getText());
	}

	@Then("^User enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_and(String username, String password) throws Throwable {

		Utility.driver.findElement(user).sendKeys(username);
		Utility.driver.findElement(pass).sendKeys(password);
		
	}

	@Then("^User close the Browser$")
	public void userclosethebrowser()
	{
		Utility.driver.close();
//		Utility.stopVideo();
//		try {
//			ScreenRecorderUtil.stopRecord();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
