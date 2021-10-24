package listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.Base;

public class Listener extends Base implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart executed...");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Passed...");
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Case failed...");
		try {
			snap(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped...");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart Started...");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Case executed...");
		
	}

}
