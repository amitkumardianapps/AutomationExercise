package tests;

import constants.ProjectConstants;
import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.Login;
import pageoperations.LoginOperations;

import static helpers.BrowserSetup.driver;

public class LoginTest {

  @BeforeTest(groups = {"sanity", "regression"})
  public static void login() {
    BrowserSetup.setupDriver();
    BrowserSetup.navigateToURL(ProjectConstants.url);
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
    LoginOperations.login(username , password);
  }

  @AfterTest
  public static void testCompletion() {
    BrowserSetup.navigateToURL(ProjectConstants.url);
  }
}
