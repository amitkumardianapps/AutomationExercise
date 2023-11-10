package pageoperations;

import static helpers.BrowserSetup.driver;
import static pageobject.Cart.*;

import constants.CheckoutConstants;
import helpers.ScrollHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.WaitUtility;

public class CartOperations {
  static WaitUtility waitUtil = new WaitUtility(driver);

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
      WebElement ele =
          driver.findElement(By.xpath("//div[contains(text(), '" + verifyItem + "')]"));
      WaitUtility.waitForElementVisibility(ele);
      String itemText = ele.getText();
      Assert.assertEquals(itemText, verifyItem);
    }
  }
}
