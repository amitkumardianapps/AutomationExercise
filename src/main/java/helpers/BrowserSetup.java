package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {

  public static WebDriver driver = new ChromeDriver();

  public static void setup() {
    WebDriverManager.chromedriver().setup();
    driver.get("https://www.saucedemo.com/v1/");
    driver.manage().window().maximize();
  }
}
