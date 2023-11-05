package tests;

import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.Login;
import pageoperations.LoginOperations;

import static helpers.BrowserSetup.driver;

public class LoginTest {

  @BeforeTest
  public static void login() {
    BrowserSetup.setup();
    BrowserSetup.navigateToURL();
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class)
  public static void loginPage(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
  }

  @AfterClass
  public static void testCompletion() {
    driver.get("https://www.saucedemo.com/v1/");
  }
}
