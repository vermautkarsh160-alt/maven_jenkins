package advance_reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginTest2 {

	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ad_rep.html");

		spark.config().setDocumentTitle("LoginReport");
		spark.config().setReportName("LoginReport");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
	}

	@Test
	public void fbLoginTest() {
		ExtentTest test = report.createTest("fbLoginTest");
		test.log(Status.INFO, "This is info.......");
		test.log(Status.SKIP, "This is skipped.......");
		test.log(Status.WARNING, "This is warning.......");
		test.log(Status.PASS, "This is passed.......");
	}

	@Test
	public void instaLoginTest() {
		ExtentTest test = report.createTest("instaLoginTest");
		test.log(Status.INFO, "This is info.......");
		test.log(Status.SKIP, "This is skipped.......");
		test.log(Status.WARNING, "This is warning.......");
		test.log(Status.PASS, "This is passed.......");
		test.log(Status.FAIL, "This is failed.......");
	}

	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}