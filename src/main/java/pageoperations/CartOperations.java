package pageoperations;

import constants.CheckoutConstants;
import helpers.ScrollHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobject.Cart;
import reporting.ExtentManager;
import utilities.WaitUtility;

import static helpers.BrowserSetup.driver;
import static pageobject.Cart.*;

public class CartOperations {
  static WaitUtility waitUtil = new WaitUtility(driver);
  public CartOperations(){
    PageFactory.initElements(driver, Cart.class);
  }

  public static void clickCart() {
    ScrollHelper.scroll(0, -100);
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", cart_Button_Element);
    cart_Button_Element.click();
    ExtentManager.log("Clicked the Cart Button");
    String cart_url=driver.getCurrentUrl();
    Assert.assertEquals(cart_url, CheckoutConstants.EXPECTED_CART_URL);
    ExtentManager.log("Verified redirection to cart page");
  }

  public static void clickCheckout() {
    checkOut_Button_Element.click();
    ExtentManager.log("Clicked the checkout button");
  }

  public static void enterUserInformation(String firstName, String lastName, String zipCode) {
    firstName_Input_Element.sendKeys(firstName);
    lastName_Input_Element.sendKeys(lastName);
    zipCode_Input_Element.sendKeys(zipCode);
    ExtentManager.log("Entered user checkout information");
    continue_Button_Element.click();
    ExtentManager.log("Clicked the continue button");
  }

  public static void verifyAddedItems(String[] itemsToAdd) {
    for (String verifyItem : itemsToAdd) {
      WebElement ele =
          driver.findElement(By.xpath("//div[contains(text(), '" + verifyItem + "')]"));
      WaitUtility.waitForElementVisibility(ele);
      String itemText = ele.getText();
      Assert.assertEquals(itemText, verifyItem);
    }
    ExtentManager.log("Verified that the added items are the same");
  }
}
