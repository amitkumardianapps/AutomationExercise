package tests;

import static helpers.BrowserSetup.driver;

import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.Login;
import pageoperations.LoginOperations;

public class LoginTest {

  @BeforeTest(groups = {"sanity", "regression"})
  public static void login() {
    BrowserSetup.setup();
    BrowserSetup.navigateToURL();
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class, groups = "sanity")
  public static void loginSuccess(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username, password);
  }

  @Test(
      dataProvider = "LoginCredentials",
      dataProviderClass = LoginData.class,
      groups = "sanity",
      priority = 2)
  public static void failedLogin(String username, String password) {
    PageFactory.initElements(driver, Login.class);
    LoginOperations.login(username + "1", password);
  }

  @AfterTest
  public static void testCompletion() {
    BrowserSetup.navigateToURL();
  }
}
