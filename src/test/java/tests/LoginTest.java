package tests;

import constants.SetupConstants;
import dataprovider.LoginData;
import helpers.BrowserSetup;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageoperations.LoginOperations;

@Slf4j
public class LoginTest {

  @BeforeTest(groups = {"sanity", "regression"})
  public static void login() {
    BrowserSetup.setupDriver();
    BrowserSetup.navigateToURL(SetupConstants.URL);
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class, groups = "sanity")
  public static void loginSuccess(String username, String password) {
    LoginOperations loginOperations=new LoginOperations();
    LoginOperations.login(username, password);
  }

  @Test(
      dataProvider = "LoginCredentials",
      dataProviderClass = LoginData.class,
      groups = "sanity",
      priority = 2)
  public static void failedLogin(String username, String password) {
    LoginOperations loginOperations=new LoginOperations();
    LoginOperations.login(username, password);
  }

  @AfterTest
  public static void testCompletion() {
    BrowserSetup.navigateToURL(SetupConstants.URL);
  }
}
