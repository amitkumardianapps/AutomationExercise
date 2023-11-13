package tests;

import constants.ProjectConstants;
import dataprovider.CartData;
import helpers.BrowserSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;
import reporting.ExtentManager;

public class AddToCartTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void BrowserLaunch() {
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }


  @Test(
      dataProvider = "CartData",
      dataProviderClass = CartData.class,
      priority = 2,
      groups = {"sanity"})
  public static void addItemToCart(String username, String password,String itemToAdd, String firstName, String lastName, String zipCode) {
    LoginOperations.login(username, password);
    ProductsOperations.addToCart(new String[] {itemToAdd});
    ExtentManager.log("Added " + itemToAdd + " to the cart");
  }

  @AfterClass
  public static void testCompletion() {
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }
}
