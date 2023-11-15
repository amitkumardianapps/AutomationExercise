package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSetup {

  public static WebDriver driver;

  private BrowserSetup() {}

  public static WebDriver getDriverInstance() {
    if (driver == null) {
      setupDriver();
    }
    return driver;
  }

  public static void setupDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-application-cache");
    options.addArguments("--disable-cache");
    options.addArguments("--disable-local-storage");
    options.addArguments("--disable-session-storage");
    driver = new ChromeDriver(options);
  }

  public static void navigateToURL(String url) {
    getDriverInstance().manage().deleteAllCookies();
    getDriverInstance().get(url);
    getDriverInstance().manage().window().maximize();
  }
}
