package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReporterManager {

	public static ExtentReports createReport() {

		// Extent Reports Engine Creation
		ExtentReports reporterEngine = new ExtentReports();

		// Mention type of the report
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("JiraReport.html");
		sparkReport.config().setReportName("Shareef");
		sparkReport.config().setDocumentTitle("JiraAPIsReport");
		sparkReport.config().setTheme(Theme.DARK);

		// Add the spark report into extent report engine
		reporterEngine.attachReporter(sparkReport);
		
		return reporterEngine;

	}

}
