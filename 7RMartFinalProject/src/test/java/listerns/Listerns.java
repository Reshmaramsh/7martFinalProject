package listerns;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.Base;
import utilities.ExtentReportUtility;

public class Listerns extends Base implements ITestListener {//detailed html report generation.
	ExtentTest test;

	ExtentReports extent = ExtentReportUtility.createExtentReports();

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());

		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);

		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) { // Called when a test method fails.

		ITestListener.super.onTestFailure(result);

		extentTest.get().log(Status.FAIL, "Test Failed");

		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")

					.get(result.getInstance());

		} catch (IllegalArgumentException e) {

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		} catch (NoSuchFieldException e) {

			e.printStackTrace();

		} catch (SecurityException e) {

			e.printStackTrace();

		}

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")

					.get(result.getInstance());

		} catch (Exception e) {

		}

	}

	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);

		extentTest.get().log(Status.SKIP, "Test Skipped");

		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);

	}

	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);

	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);

	}

	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);

		extent.flush();

	}

}
//avenstack dependency add cheyyunnu.
//predefined interfaceaanu listers
//itest listener=predefined interface
//threadlocker=when we need to execute more than one method
//all these methods are from itest listers.
//override cheythikkan
//itestresult=interface to manage report lifecycle.to manage pass,fail etcc....method run cheyynnathin munne invoak aavm
//ontest success method=creates status of the particular method,if it passes ...invokes aftr running
//on test failure contra of on test pass
//printstack,,,=nthukond fail aayiii
//ontest skipped=skipn aavumboo work aavum
//flush metghod(imp)=to confirm the stAatus of testing,if it passes or fails