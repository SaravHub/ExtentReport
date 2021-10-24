package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import hooks.TestNgHooks;

public class MyLeadsPage extends TestNgHooks {

	public MyLeadsPage(RemoteWebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateLeadPage clickCreateLeadMenu() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage(driver);
	}

}
