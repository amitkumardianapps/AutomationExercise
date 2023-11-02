package pageoperations;

import static helpers.BrowserSetup.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static page.Cart.*;

import helpers.ScrollHelper;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartOperations {

  public static void clickCart() {
    ScrollHelper.scroll(0, -100);
    WebElement cartButton = driver.findElement(cartButtonLocator);

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
    cartButton.click();
  }

  public static void verifyHeading() {
    Assert.assertEquals(actualCartUrl, expectedCartUrl);
  }

  public static void clickCheckout() {
    driver.findElement(checkoutLocator).click();
    driver.findElement(firstNameLocator).sendKeys("firstName");
    driver.findElement(lastNameLocator).sendKeys("lastName");
    driver.findElement(zipCodeLocator).sendKeys("48343");
    driver.findElement(continueButtonLocator).click();

    for (String verifyItem : itemsToAdd) {
      WebDriverWait wait =
          new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration for wait time
      WebElement item =
          wait.until(
              visibilityOfElementLocated(
                  By.xpath("//div[contains(text(), '" + verifyItem + "')]")));
      String itemText = item.getText();
      Assert.assertEquals(itemText, verifyItem);
    }
  }
}
