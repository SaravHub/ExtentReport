package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import hooks.TestNgHooks;

public class LoginPage extends TestNgHooks{
	
	
	public LoginPage(RemoteWebDriver driver,ExtentTest node) {
		
		this.driver  = driver;
		this.node = node;
		PageFactory.initElements(driver, this);
		
	}
	

	public LoginPage typeUserName(String user) throws InterruptedException, IOException {
		try {
			driver.findElement(By.name("USERNAME")).sendKeys(user);
			reportStep(user+" username is entered successfully","pass");
		} catch (Exception e) {
			reportStep(user+" username is not entered successfully: "+e,"fail");
		}
		//Thread.sleep(5000);
		return this;
	}
	
	public LoginPage typePassword(String pass) throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(pass);
			reportStep(pass+" password is entered successfully","pass");
		} catch (Exception e) {
			reportStep(pass+" password is not entered successfully: "+e,"fail");
		}
		return this;
	}
	
	public HomePage clickLogin() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("login button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("login button is not clicked successfully","fail");
		}
		return new HomePage(driver,node);
	}
	
	public LoginPage clickLoginForNegativeData() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	

}
