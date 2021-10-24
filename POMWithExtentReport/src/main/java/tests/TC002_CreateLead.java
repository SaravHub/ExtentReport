package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class TC002_CreateLead extends TestNgHooks{
	
	@BeforeTest
	public void setDetails() {
		excelFileName = "CreateLead";
		testName = "CreateLead";
		testDescription = "Create Lead with mandatory informations";
		testCategory = "functional";
		testAuthor = "Hari";

	}
	
	@Test(dataProvider = "fetchData")
	public void createLead(String uName, String pWord, String company, String firstName, String lastName) throws InterruptedException, IOException {
		
		new LoginPage(driver,node)
			.typeUserName(uName)
			.typePassword(pWord)
			.clickLogin()
			.clickCrm()
			.clickLeadsTab()
			.clickCreateLeadMenu()
			.typeCompanyName(company)
			.typeFirstName(firstName)
			.typeLastName(lastName)
			.clickCreateLeadButton()
			.verifyFirstName(firstName);
	}

}

/* Page designed tests becomes easy to manage and highly verbose 
 * You can reuse the pages and its methods for other testscases
 * You can avoid duplicates !!
 * 
 */
