package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import advance_reports.LoginTest;


public class List_Imp implements ISuiteListener, ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ad_rep2.html");
		spark.config().setDocumentTitle("LoginReport");
		spark.config().setReportName("FbLoginReport");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		String methodName = "instaLoginTest";
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "This is passed.......");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "This is failed.......");

		TakesScreenshot tks = (TakesScreenshot) LoginTest.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(ss, "chitra");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "This is skipped.......");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
}