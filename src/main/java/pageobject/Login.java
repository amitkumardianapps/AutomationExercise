package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

  @FindBy(how = How.ID, using = "user-name")
  public static WebElement userNameWebElement;

  @FindBy(how = How.ID, using = "password")
  public static WebElement passwordWebElement;

  @FindBy(xpath = "//input[@id='login-button']")
  public static WebElement loginButtonWebElement;
}
