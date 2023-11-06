package pageoperations;

import static helpers.BrowserSetup.driver;
import static page.Login.*;

public class LoginOperations {

  public static void login(String username, String Password) {
    driver.findElement(userNameLocator).sendKeys(username);
    driver.findElement(passwordLocator).sendKeys(Password);
    driver.findElement(loginButtonLocator).click();
  }
}
