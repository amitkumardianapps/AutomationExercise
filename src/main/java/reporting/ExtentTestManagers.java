package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManagers {
  static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
  static ExtentReports extent = ExtentManagers.getInstance();
  static ExtentTest test;

  public static synchronized ExtentTest getTest() {
    return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
  }

  public static synchronized void endTest() {
    extent.flush();
  }

  public static synchronized ExtentTest startTest(String testName) {
    test = extent.createTest(testName);
    extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
    return test;
  }
}
