package pageoperations;

import static pageobject.Login.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginOperations {

  public static void login(String username, String Password) {
    userNameWebElement.sendKeys(username);
    passwordWebElement.sendKeys(Password);
    loginButtonWebElement.click();
    log.info("Clicked the login button");
  }
}
