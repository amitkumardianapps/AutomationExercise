package pageoperations;

import static helpers.BrowserSetup.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static pageobject.Cart.*;

import constants.CheckoutConstants;
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
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", cartButtonWebElement);
    cartButtonWebElement.click();
    Assert.assertEquals(CheckoutConstants.actualCartUrl, CheckoutConstants.expectedCartUrl);
  }

  public static void clickCheckout() {
    checkOutButtonWebElement.click();
  }

  public static void enterUserInformation(String firstName, String lastName, String zipCode) {
    firstNameInputWebElement.sendKeys(firstName);
    lastNameInputWebElement.sendKeys(lastName);
    zipCodeInputWebElement.sendKeys(zipCode);
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
