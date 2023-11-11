package tests;

import static helpers.BrowserSetup.driver;

import constants.ProjectConstants;
import dataprovider.CartData;
import dataprovider.LoginData;
import dataprovider.PersonalInformationData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.Login;
import pageoperations.CartOperations;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;
import reporting.ExtentManagers;

public class EndToEndCheckoutTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void browserSetup() {
    BrowserSetup.setupDriver();
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }

  @Test(
      dataProvider = "LoginCredentials",
      dataProviderClass = LoginData.class,
      priority = 1,
      groups = "regression")
  public static void login(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
  }

  @Test(
      dataProvider = "CartData",
      dataProviderClass = CartData.class,
      priority = 2,
      groups = "regression")
  public static void addItemToCart(String itemToAdd) {
    ProductsOperations.addToCart(
        new String[] {
          itemToAdd
        }); // TODO the item is coming as pre-selected in the cart that is why the cart cannot be
    // found need to fix this
    ExtentManagers.log("Added " + itemToAdd + " to the cart");
  }

  @Test(priority = 3, groups = "regression")
  public static void checkoutEndToEnd() {
    CartOperations.clickCart();
    ExtentManagers.log("Navigated to the cart page");
    CartOperations.clickCheckout();
    ExtentManagers.log("Clicked the checkout button");
  }

  @Test(
      dataProvider = "PersonalInformationData",
      priority = 4,
      dataProviderClass = PersonalInformationData.class,
      groups = "regression")
  public static void enterPersonalInformation(String firstName, String lastName, String zipCode) {
    CartOperations.enterUserInformation(firstName, lastName, zipCode);
    ExtentManagers.log("Successfully submitted the details of the user ");
  }

  @Test(
      dataProvider = "CartData",
      dataProviderClass = CartData.class,
      priority = 5,
      groups = "regression")
  public static void verifyCartItems(String itemToAdd) {
    CartOperations.verifyAddedItems(new String[] {itemToAdd});
    ExtentManagers.log("Verified the item" + itemToAdd);
  }

  @AfterClass
  public static void testCompletion() {
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }

  @AfterSuite
  public static void suiteCompletion() {
    driver.quit();
  }
}
