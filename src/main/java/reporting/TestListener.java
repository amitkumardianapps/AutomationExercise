package reporting;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static helpers.BrowserSetup.driver;

public class TestListener implements ITestListener {

  public void onStart(ITestContext context) { // TODO Remove the use of SysOut
    System.out.println("*** Test Suite " + context.getName() + " started ***");
  }

  public void onFinish(ITestContext context) {
    System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
    ExtentTestManagers.endTest();
    ExtentManagers.getInstance().flush();
  }

  public void onTestStart(ITestResult result) {
    System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
    ExtentTestManagers.startTest(result.getMethod().getMethodName());
  }

  public void onTestSuccess(ITestResult result) {
    System.out.println(
        "*** Executed " + result.getMethod().getMethodName() + " test successfully...");
    ExtentTestManagers.getTest().log(Status.PASS, "Test passed");
  }

  public void onTestFailure(ITestResult result) {
    System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");

    if (result.getStatus() == ITestResult.FAILURE) {
      ExtentTestManagers.getTest().log(Status.FAIL, "Test Failed");
      TakesScreenshot ts = (TakesScreenshot) driver; // Ensure 'driver' is defined and accessible

      File screenshot = ts.getScreenshotAs(OutputType.FILE);
      String screenshotPath = "path/to/save/screenshot.png"; // Define the path where the screenshot will be saved

      try {
        // Copy the screenshot file to the specified path
        FileUtils.copyFile(screenshot, new File(screenshotPath));
        // Add the copied file's path to the Extent Report
        ExtentTestManagers.getTest().addScreenCaptureFromPath(screenshotPath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


  public void onTestSkipped(ITestResult result) {
    System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
    ExtentTestManagers.getTest().log(Status.SKIP, "Test Skipped");
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println(
        "*** Test failed but within percentage % " + result.getMethod().getMethodName());
  }
}
