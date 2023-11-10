package tests;

import constants.ProjectConstants;
import dataprovider.CartData;
import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;
import reporting.ExtentManagers;

public class AddToCartTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void BrowserLaunch() {
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }

  @Test(
      dataProvider = "LoginCredentials",
      dataProviderClass = LoginData.class,
      priority = 1,
      groups = {"sanity"})
  public static void login(String username, String password) {
    LoginOperations.login(username, password);
  }

  @Test(
      dataProvider = "CartData",
      dataProviderClass = CartData.class,
      priority = 2,
      groups = {"sanity"})
  public static void addItemToCart(String itemToAdd) {
    ProductsOperations.addToCart(new String[] {itemToAdd});
    ExtentManagers.log("Added " + itemToAdd + " to the cart");
  }

  @AfterClass
  public static void testCompletion() {
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }
}
