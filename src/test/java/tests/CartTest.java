package tests;

import dataprovider.CartData;
import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.Cart;
import pageobject.Login;
import pageoperations.CartOperations;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;

import static helpers.BrowserSetup.driver;

public class CartTest {

  @BeforeClass
  public static void browserSetup() {
    BrowserSetup.setup();
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class, priority = 1)
  public static void login(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
  }

  @Test(dataProvider = "CartData", dataProviderClass = CartData.class, priority = 2)
  public static void addItemToCart(String itemToAdd) {
    PageFactory.initElements(driver, Cart.class);
    ProductsOperations.addToCart(new String[] {itemToAdd});
  }

  @Test(dataProvider = "CartData", dataProviderClass = CartData.class, priority = 3)
  public static void checkoutEndToEnd(String itemToAdd) {
    PageFactory.initElements(driver, Cart.class);
    CartOperations.clickCart();
    CartOperations.clickCheckout();
    CartOperations.enterCheckoutInformation(); // TODO Rename method
    CartOperations.verifyAddedItems(new String[] {itemToAdd});
  }

  @AfterClass
  public static void testCompletion() {
    driver.get("https://www.saucedemo.com/v1/");
  }
}
