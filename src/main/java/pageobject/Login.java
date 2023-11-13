package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

  @FindBy(how = How.ID, using = "user-name")
  public static WebElement userName_Element;

  @FindBy(how = How.ID, using = "password")
  public static WebElement password_Element;

  @FindBy(xpath = "//input[@id='login-button']")
  public static WebElement loginButton_Element;
}
