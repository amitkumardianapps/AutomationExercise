package pageoperations;

import org.openqa.selenium.support.PageFactory;
import pageobject.Login;

import static helpers.BrowserSetup.driver;
import static pageobject.Login.*;

public class LoginOperations {

  public static void login(String username, String Password) {
    PageFactory.initElements(driver, Login.class);
    userNameWebElement.sendKeys(username);
    passwordWebElement.sendKeys(Password);
    loginButtonWebElement.click();
  }
}
