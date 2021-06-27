package StepDefs;

import Utilities.Utility;
import io.cucumber.java.en.Then;

public class Something {
//	private Utility base;
//	public Dummy(Utility base){
//		this.base=base;
//	}
//	Utility util=new Utility();
//	public void dsd()
//	{
//		util.driver.findElement(By.xpath("")).clear();
//		base.driver.findElement(By.xpath("")).clear();
//	}
	@Then("^User take screenshot$")
	public void user_take_screenshot() throws Throwable {
//	   Utility.getFullScreentshot();
	   Utility.getScreenshot();
	}
}
