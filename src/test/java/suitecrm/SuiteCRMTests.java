package suitecrm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import suitecrmpages.SuiteCRMCreateTaskPage;
import suitecrmpages.SuiteCRMHomePage;
import suitecrmpages.SuiteCRMLoginPage;
import suitecrmpages.SuiteCRMTaskOverviewPage;
import static utilities.ConfigReader.*;

public class SuiteCRMTests extends TestBase{
	
	SuiteCRMLoginPage loginPage;
	SuiteCRMHomePage homepage;
	SuiteCRMCreateTaskPage createTaskpage;
	SuiteCRMTaskOverviewPage taskOverviewpage;
	
	@BeforeMethod
	public void navigate() {
		//navigate to page
		driver.get(getProperty("suitecrm.url"));
		loginPage = new SuiteCRMLoginPage(driver);
		homepage = new SuiteCRMHomePage(driver);
		createTaskpage = new SuiteCRMCreateTaskPage(driver);
		taskOverviewpage = new SuiteCRMTaskOverviewPage(driver);
	}
	
	@Test
	public void createTaskInSuiteCRM() {
		loginPage.login(getProperty("suitecrm.username"), getProperty("suitecrm.password"));
		homepage.createNewItem("Create Task");
		
	}
	
}
