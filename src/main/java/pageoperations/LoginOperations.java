package pageoperations;

import static pageobject.Login.*;

public class LoginOperations {

  public static void login(String username, String Password) {
    userNameWebElement.sendKeys(username);
    passwordWebElement.sendKeys(Password);
    loginButtonWebElement.click();
  }
}
