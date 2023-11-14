package reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static helpers.BrowserSetup.driver;

public class TestListener implements ITestListener {

  public void onStart(ITestContext context) { // TODO Remove the use of SysOut
    System.out.println("*** Test Suite " + context.getName() + " started ***");
  }

  public void onFinish(ITestContext context) {
    System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
    ExtentTestManager.endTest();
    ExtentManager.getInstance().flush();
  }

  public void onTestStart(ITestResult result) {
    System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
    ExtentTestManager.startTest(result.getMethod().getMethodName());
  }

  public void onTestSuccess(ITestResult result) {
    System.out.println(
        "*** Executed " + result.getMethod().getMethodName() + " test successfully...");
    ExtentTestManager.getTest().log(Status.PASS, "Test passed");
  }

  public void onTestFailure(ITestResult result) {
    System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");

    if (result.getStatus() == ITestResult.FAILURE) {
      ExtentTest test = ExtentTestManager.getTest();
      test.log(Status.FAIL, "Test Failed");

      TakesScreenshot ts = (TakesScreenshot) driver;
      File screenshot = ts.getScreenshotAs(OutputType.FILE);

      String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
      String screenshotPath = System.getProperty("user.dir") + "/screenshots/screenshot_" + timestamp + ".png"; // Absolute path

      try {
        FileUtils.copyFile(screenshot, new File(screenshotPath));
        test.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" + screenshotPath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void onTestSkipped(ITestResult result) {
    System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
    ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println(
        "*** Test failed but within percentage % " + result.getMethod().getMethodName());
  }
}
