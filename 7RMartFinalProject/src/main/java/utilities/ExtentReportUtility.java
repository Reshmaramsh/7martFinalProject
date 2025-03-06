package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {//detailed html report creation/pass/fail/skip
	public static final ExtentReports extentReports = new ExtentReports();
	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("7RMartFinalProject");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", " ReshmaRamesh"); 
		return extentReports;
	}

}
//extent reports predefined class
//extent spark reports - folder creation,extent-report(folder name)next file name
//setsystem report=file name creation predefined method
//