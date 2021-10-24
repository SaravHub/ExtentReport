package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public RemoteWebDriver driver;
	@BeforeMethod
	public void setUp() {
		//this to create subset for test(when we pass multiple data)
				
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void snap(String mtdName) throws IOException {
		File src=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snaps"+mtdName+".png"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
