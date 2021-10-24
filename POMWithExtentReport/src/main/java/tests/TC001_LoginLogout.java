package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class TC001_LoginLogout extends TestNgHooks{
	
	@BeforeTest
	public void setDetails() {
		excelFileName = "Login";
		testName = "Loginlogout";
		testDescription = "Login and Logout for leafTaps";
		testCategory = "smoke";
		testAuthor = "Sarav";

	}
	
	@Test(dataProvider = "fetchData")
	public void loginLogout(String uName, String pWord) throws InterruptedException, IOException {
		System.out.println(driver);
		new LoginPage(driver,node)
			.typeUserName(uName)
			.typePassword(pWord)
			.clickLogin();
			/*.clickLogout();	*/
	}

}

