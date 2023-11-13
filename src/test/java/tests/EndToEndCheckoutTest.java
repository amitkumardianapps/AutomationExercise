package tests;

import constants.SetupConstants;
import dataprovider.CartData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.Login;
import pageoperations.CartOperations;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;
import reporting.ExtentManager;

import static helpers.BrowserSetup.driver;

public class EndToEndCheckoutTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void browserSetup() {
    BrowserSetup.setupDriver();
    BrowserSetup.navigateToURL(SetupConstants.url);
  }

  @Test(
          dataProvider = "CartData",
      dataProviderClass = CartData.class,
      groups = "regression")
  public static void endToEndCheckout(String username, String password, String itemToAdd, String firstName, String lastName, String zipCode) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
    ProductsOperations.addToCart(
            new String[] {
                    itemToAdd
            });
    CartOperations.clickCart();
    ExtentManager.log("Navigated to the cart page");
    CartOperations.clickCheckout();
    ExtentManager.log("Clicked the checkout button");
    CartOperations.enterUserInformation(firstName, lastName, zipCode);
    CartOperations.verifyAddedItems(new String[] {itemToAdd});
  }

  @AfterSuite
  public static void suiteCompletion() {
    driver.quit();
  }
}
