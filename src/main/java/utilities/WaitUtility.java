package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
  private final WebDriver driver;
  private static WebDriverWait wait;

  public WaitUtility(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default timeout set to 10 seconds
  }

  public void setImplicitWait(int timeInSeconds) {
    driver.manage().timeouts().implicitlyWait(timeInSeconds, java.util.concurrent.TimeUnit.SECONDS);
  }

  public static void waitForElementVisibility(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForElementVisibility(WebElement element, Duration customTimeoutInSeconds) {
    WebDriverWait customWait = new WebDriverWait(driver, customTimeoutInSeconds);
    customWait.until(ExpectedConditions.visibilityOf(element));
  }
}
