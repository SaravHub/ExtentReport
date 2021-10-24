package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import hooks.TestNgHooks;

public class MyHomePage extends TestNgHooks {

	public MyHomePage(RemoteWebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}

	public MyLeadsPage clickLeadsTab() {
		driver.findElement(By.linkText("Leads")).click(); //Prospects 
		return new MyLeadsPage(driver);
	}

}
