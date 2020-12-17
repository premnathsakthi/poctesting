package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectWrappers extends GenericWrappers {

	@BeforeMethod
	public void launchApplication( ) {
		
		invokeApp("chrome", "https://www.ftr.irctc.co.in/ftr/");
	}
	
	@AfterMethod
	public void closeApplication() {
		closeAllBrowsers();
	}
}
