package testNGExamples;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;

import extentReports.ReporterManager;

public class Listeners implements ITestListener {

	ExtentReports report = ReporterManager.createReport();

	@Override
	public void onTestStart(ITestResult result) {
		report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		report.createTest(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		report.createTest(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		report.createTest(result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		report.createTest(result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		report.createTest(context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		report.createTest(context.getName());
	}

	

}
