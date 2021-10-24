package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(listener.Listener.class)
public class LoginLogout extends Base{
	@Test
	public  LoginLogout Login() {
		driver.findElement(By.name("USERNAME")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}
}
