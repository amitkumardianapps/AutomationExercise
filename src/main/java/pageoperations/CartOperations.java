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
        .executeScript("arguments[0].scrollIntoView(true);", cart_Button_Element);
    cart_Button_Element.click();
    Assert.assertEquals(CheckoutConstants.CART_URL, CheckoutConstants.EXPECTED_CART_URL);
  }

  public static void clickCheckout() {
    PageFactory.initElements(driver, Cart.class);
    checkOut_Button_Element.click();
  }

  public static void enterUserInformation(String firstName, String lastName, String zipCode) {
    PageFactory.initElements(driver, Cart.class);
    firstName_Input_Element.sendKeys(firstName);
    lastName_Input_Element.sendKeys(lastName);
    zipCode_Input_Element.sendKeys(zipCode);
    continue_Button_Element.click();
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
