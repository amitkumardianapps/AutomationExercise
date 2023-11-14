package tests;

import constants.SetupConstants;
import dataprovider.CartData;
import dataprovider.CartTestData;
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
  public static void endToEndCheckout(CartTestData testData) {
    CartOperations cartOperations = new CartOperations();
    LoginOperations loginOperations = new LoginOperations();
    LoginOperations.login(testData.getUsername(), testData.getPassword());
    ProductsOperations.addToCart(new String[]{testData.getItemToAdd()});
    CartOperations.clickCart();
    CartOperations.clickCheckout();
    CartOperations.enterUserInformation(testData.getFirstName(), testData.getLastName(), testData.getZipCode());
    CartOperations.verifyAddedItems(new String[]{testData.getItemToAdd()});
  }


  @AfterSuite
  public static void suiteCompletion() {
    driver.quit();
  }
}
