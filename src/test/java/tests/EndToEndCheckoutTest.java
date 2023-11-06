package tests;

import dataprovider.CartData;
import dataprovider.LoginData;
import dataprovider.PersonalInformationData;
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

public class EndToEndCheckoutTest {

  @BeforeClass(groups={"sanity","regression"})
  public static void browserSetup() {
    BrowserSetup.navigateToURL();
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class, priority = 1, groups = "regression")
  public static void login(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
  }

  @Test(dataProvider = "CartData", dataProviderClass = CartData.class, priority = 2, groups = "regression")
  public static void addItemToCart(String itemToAdd) {
    PageFactory.initElements(driver, Cart.class);
    ProductsOperations.addToCart(new String[] {itemToAdd});
  }

  @Test(priority = 3, groups = "regression")
  public static void checkoutEndToEnd() {
    PageFactory.initElements(driver, Cart.class);
    CartOperations.clickCart();
    CartOperations.clickCheckout();
  }

  @Test(dataProvider = "PersonalInformationData", priority = 3, dataProviderClass = PersonalInformationData.class, groups = "regression")
  public static void enterPersonalInformation(String firstName,String lastName, String zipCode){
    CartOperations.enterUserInformation(firstName,lastName,zipCode);
  }
  @Test(dataProvider = "CartData", dataProviderClass = CartData.class, priority = 4, groups = "regression")
  public static void verifyCartItems(String itemToAdd) {
    CartOperations.verifyAddedItems(new String[] {itemToAdd});
  }

  @AfterClass
  public static void testCompletion() {
    BrowserSetup.navigateToURL();
  }
}
