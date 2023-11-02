package tests;

import static helpers.BrowserSetup.driver;

import dataprovider.LoginData;
import helpers.BrowserSetup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageoperations.LoginOperations;

public class LoginTest {

  @BeforeTest
  public static void login() {
    BrowserSetup.setup();
  }

  @Test(dataProvider = "LoginCredentials", dataProviderClass = LoginData.class)
  public static void loginPage(String username, String password) {
    LoginOperations.login(username, password);
  }

  @AfterTest
  public static void testCompletion() {
    driver.quit();
  }
}
