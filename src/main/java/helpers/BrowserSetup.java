package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSetup {

  public static WebDriver driver = new ChromeDriver();

  public static void setup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-application-cache");
    options.addArguments("--disable-cache");
    options.addArguments("--disable-local-storage");
    options.addArguments("--disable-session-storage");
    driver = new ChromeDriver(options);
  }

  public static void navigateToURL() {
    driver.get("https://www.saucedemo.com/v1/");
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
  }
}
