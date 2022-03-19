package MyRunner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import Utilities.MainConfig;
import Utilities.Utility;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@CucumberOptions(
        features = ".\\Features"  /* U can use ./Features or .\\Features anything  will work*/
        , glue = {"StepDefs"}
        , tags = "@tag", monochrome = true, dryRun = false, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:Reports/Cucumber.html", "json:Reports/Cucumber.json"})
public class TestRunners extends AbstractTestNGCucumberTests {

    //	private TestNGCucumberRunner testNgcucumberrunner;
//	
//    @Before()
//    public void SetUpClass() {
//        System.setProperty("webdriver.chrome.driver", MainConfig.getProperties("chromeDriver"));
//        WebDriverManager.chromedriver().setup();
//        Utility.driver = new ChromeDriver();
//    }
//	@Test(groups="cucumber",description="Runs Cucumber Feature",dataProvider="features")
//	public void feature(CucumberFeatureWrapper cucumberFeature)
//	{
//		testNgcucumberrunner.runCucumber(cucumberFeature.getCucumberFeature());
//	}
//	@DataProvider(parallel=true)
//	public Object[][] features()
//	{
//		return testNgcucumberrunner.provideFeatures();
//	}
//	@AfterClass(alwaysRun=true)
//	public void tearDownClass()
//	{
//		
//	}
	   @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

		@Parameters("browser")
		@Test
		public void checking(String checkingtest)
		{
			System.out.println(checkingtest);
			System.out.println(checkingtest);
		}
}