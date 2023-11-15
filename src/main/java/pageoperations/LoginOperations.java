package pageoperations;

import org.openqa.selenium.support.PageFactory;
import pageobject.Login;
import reporting.ExtentManager;

import static helpers.BrowserSetup.driver;
import static pageobject.Login.*;

public class LoginOperations {

  public LoginOperations(){
    PageFactory.initElements(driver, Login.class);
  }

  public static void login(String username, String Password) {
    userName_Element.sendKeys(username);
    password_Element.sendKeys(Password);
    loginButton_Element.click();
    ExtentManager.log("Attempted login");
  }
}
