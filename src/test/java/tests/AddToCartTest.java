package tests;

import constants.SetupConstants;
import dataprovider.CartData;
import dataprovider.CartTestData;
import helpers.BrowserSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageoperations.LoginOperations;
import pageoperations.ProductsOperations;

public class AddToCartTest {

  @BeforeClass(groups = {"sanity", "regression"})
  public static void BrowserLaunch() {
    BrowserSetup.navigateToURL(SetupConstants.URL);
  }


  @Test(
      dataProvider = "CartData",
      dataProviderClass = CartData.class,
      priority = 2,
      groups = {"sanity"})
  public static void addItemToCart(CartTestData testData) {
    LoginOperations loginOperations=new LoginOperations();
    ProductsOperations productsOperations=new ProductsOperations();
    LoginOperations.login(testData.getUsername(), testData.getPassword());
    ProductsOperations.addToCart(new String[] {testData.getItemToAdd()});
  }

  @AfterClass
  public static void testCompletion() {
    BrowserSetup.navigateToURL(SetupConstants.URL);
  }
}
