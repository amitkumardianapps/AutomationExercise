package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

import static reporting.ExtentTestManagers.test;

public class ExtentManagers {
  private static ExtentReports extent;
  private static final String reportFileName = "Test-Automaton-Report" + ".html";
  private static final String fileSeparator = System.getProperty("file.separator");
  private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
  private static final String reportFilepath =
      System.getProperty("user.dir") + fileSeparator + "TestReport";
  private static final String reportFileLocation = reportFilepath + fileSeparator + reportFileName;

  public static ExtentReports getInstance() {
    if (extent == null) createInstance();
    return extent;
  }

  // Create an extent report instance
  public static void createInstance() {
    String fileName = getReportPath(reportFilepath);

    ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
    htmlReporter.config().setTimelineEnabled(true);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(reportFileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(reportFileName);
    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    // Set environment details
    extent.setSystemInfo("OS", "MacOS");
    extent.setSystemInfo("AUT", "QA");
  }

  // Create the report path
  private static String getReportPath(String path) {
    File testDirectory = new File(path);
    if (!testDirectory.exists()) {
      if (testDirectory.mkdir()) {
        System.out.println("Directory: " + path + " is created!");
        return reportFileLocation;
      } else {
        System.out.println("Failed to create directory: " + path);
        return System.getProperty("user.dir");
      }
    } else {
      System.out.println("Directory already exists: " + path);
    }
    return reportFileLocation;
  }

  public static void log(String logDetails) {

    if (test == null) {
      test = extent.createTest("Generic Test");
      extentTest.set(test);
    }

    test.log(Status.INFO, logDetails);
    extent.flush();
  }
}
