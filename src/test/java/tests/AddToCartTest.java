package tests;

import static helpers.BrowserSetup.driver;

import dataprovider.CartData;
import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.Cart;
import pageobject.Login;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;

public class AddToCartTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void BrowserLaunch() {
    BrowserSetup.navigateToURL();
  }

  @Test(
      dataProvider = "LoginCredentials",
      dataProviderClass = LoginData.class,
      priority = 1,
      groups = {"sanity"})
  public static void login(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
  }

  @Test(
      dataProvider = "CartData",
      dataProviderClass = CartData.class,
      priority = 2,
      groups = {"sanity"})
  public static void addItemToCart(String itemToAdd) {
    PageFactory.initElements(driver, Cart.class);
    ProductsOperations.addToCart(new String[] {itemToAdd});
  }

  @AfterClass
  public static void testCompletion() {
    BrowserSetup.navigateToURL();
  }
}
