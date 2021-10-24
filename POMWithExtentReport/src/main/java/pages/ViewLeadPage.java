package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import hooks.TestNgHooks;

public class ViewLeadPage extends TestNgHooks {
	public ViewLeadPage(RemoteWebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}

	public ViewLeadPage verifyFirstName(String firstName) {
		String fName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (fName.equals(firstName))
			System.out.println("All good");
		else
			System.err.println("Something went wrong");

		return this;
	}

}
