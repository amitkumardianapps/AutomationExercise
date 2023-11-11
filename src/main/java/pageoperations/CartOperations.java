package pageoperations;

import constants.CheckoutConstants;
import helpers.ScrollHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobject.Cart;
import utilities.WaitUtility;

import static helpers.BrowserSetup.driver;
import static pageobject.Cart.*;

public class CartOperations {
  static WaitUtility waitUtil = new WaitUtility(driver);

  public static void clickCart() {
    PageFactory.initElements(driver, Cart.class);
    ScrollHelper.scroll(0, -100);
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", cartButtonWebElement);
    cartButtonWebElement.click();
    Assert.assertEquals(CheckoutConstants.actualCartUrl, CheckoutConstants.expectedCartUrl);
  }

  public static void clickCheckout() {
    PageFactory.initElements(driver, Cart.class);
    checkOutButtonWebElement.click();
  }

  public static void enterUserInformation(String firstName, String lastName, String zipCode) {
    PageFactory.initElements(driver, Cart.class);
    firstNameInputWebElement.sendKeys(firstName);
    lastNameInputWebElement.sendKeys(lastName);
    zipCodeInputWebElement.sendKeys(zipCode);
    continueButtonWebElement.click();
  }

  public static void verifyAddedItems(String[] itemsToAdd) {
    PageFactory.initElements(driver, Cart.class);
    for (String verifyItem : itemsToAdd) {
      WebElement ele =
          driver.findElement(By.xpath("//div[contains(text(), '" + verifyItem + "')]"));
      WaitUtility.waitForElementVisibility(ele);
      String itemText = ele.getText();
      Assert.assertEquals(itemText, verifyItem);
    }
  }
}
