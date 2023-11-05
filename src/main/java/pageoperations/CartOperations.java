package pageoperations;

import constants.CheckoutConstants;
import helpers.ScrollHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static helpers.BrowserSetup.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static pageobject.Cart.*;

public class CartOperations {

  public static void clickCart() {
    ScrollHelper.scroll(0, -100);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButtonWebElement);
    cartButtonWebElement.click();
    Assert.assertEquals(CheckoutConstants.actualCartUrl, CheckoutConstants.expectedCartUrl);
  }

  public static void clickCheckout() {
    checkOutButtonWebElement.click(); // TODO Pagefactory
  }

  public static void enterCheckoutInformation() {
    firstNameInputWebElement.sendKeys("firstName"); // TODO remove hard coded values
    lastNameInputWebElement.sendKeys("lastName");
    zipCodeInputWebElement.sendKeys("48343");
    continueButtonWebElement.click();
  }

  public static void verifyAddedItems(String[] itemsToAdd) {
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
