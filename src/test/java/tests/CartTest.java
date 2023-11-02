package tests;

import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageoperations.CartOperations;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;

public class CartTest {

  @BeforeClass
  public static void login() {
    BrowserSetup.setup();
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class)
  public static void loginPage(String username, String password) {
    LoginOperations.login(username, password);
    ProductsOperations.addToCart();
    CartOperations.clickCart();
    CartOperations.verifyHeading();
    CartOperations.clickCheckout();
  }
}
