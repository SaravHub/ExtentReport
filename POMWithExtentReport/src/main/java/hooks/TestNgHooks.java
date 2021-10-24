package hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class TestNgHooks {

	// I wanted to have single browser reference
	// Can't I run in parallel? Yes, you cannot run.
	public RemoteWebDriver driver;
	public String excelFileName;
	
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String testName, testDescription, testCategory, testAuthor;

	@BeforeSuite
	public void setupReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}
	
	@BeforeClass
	public void setTestDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random()* 999999);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(source, target);
		return ranNum;
	}
		
	
	public void reportStep(String msg, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")) {
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			throw new RuntimeException();
		}
	}
	
	@BeforeMethod
	public void setUp() {
		//this to create subset for test(when we pass multiple data)
		node = test.createNode(testName);
				
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	// close the browser
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {

		return ReadExcel.readData(excelFileName);
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
