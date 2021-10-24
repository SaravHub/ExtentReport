package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import hooks.TestNgHooks;

public class HomePage extends TestNgHooks {

	public HomePage(RemoteWebDriver driver,ExtentTest node) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogout() throws IOException {
		try {
			driver.findElement(By.xpath("//input[@value='Logout']")).click();
			reportStep("logout button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("logout button is not clicked successfully","fail");
		}
		return new LoginPage(driver,node);
	}

	public MyHomePage clickCrm() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}

}
