package tests;

import constants.SetupConstants;
import dataprovider.CartData;
import helpers.BrowserSetup;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageoperations.CartOperations;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;

import static helpers.BrowserSetup.driver;

public class EndToEndCheckoutTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void browserSetup() {
    BrowserSetup.setupDriver();
    BrowserSetup.navigateToURL(SetupConstants.URL);
  }

  @Test(
          dataProvider = "CartData",
      dataProviderClass = CartData.class,
      groups = "regression")
  public static void endToEndCheckout(String username, String password, String itemToAdd, String firstName, String lastName, String zipCode) {
    CartOperations cartOperations=new CartOperations();
    LoginOperations loginOperations=new LoginOperations();
    LoginOperations.login(username, password);
    ProductsOperations.addToCart(
            new String[] {
                    itemToAdd
            });
    CartOperations.clickCart();
    CartOperations.clickCheckout();
    CartOperations.enterUserInformation(firstName, lastName, zipCode);
    CartOperations.verifyAddedItems(new String[] {itemToAdd});
  }

  @AfterSuite
  public static void suiteCompletion() {
    driver.quit();
  }
}
