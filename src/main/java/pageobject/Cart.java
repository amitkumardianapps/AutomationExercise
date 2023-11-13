package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.BrowserSetup.driver;

public class Cart {

  @FindBy(xpath = "//div[@id='shopping_cart_container']//a[contains(@class, 'shopping_cart_link')]")
  public static WebElement cart_Button_Element;

  @FindBy(linkText = "CHECKOUT")
  public static WebElement checkOut_Button_Element;

  @FindBy(xpath = "//input[@id='first-name']")
  public static WebElement firstName_Input_Element;

  @FindBy(xpath = "//input[@id='last-name']")
  public static WebElement lastName_Input_Element;

  @FindBy(xpath = "//input[@id='postal-code']")
  public static WebElement zipCode_Input_Element;

  @FindBy(xpath = "//input[@type='submit']")
  public static WebElement continue_Button_Element;

  @FindBy(
      xpath =
          "//div[@class='inventory_item_label']//a//div[contains(text(), 'Sauce Labs Backpack')]")
  public static WebElement itemWebElement;

  public static WebElement getProductByName(String productName) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath(
                "//div[@class='inventory_item_label']//a//div[contains(text(), '"
                    + productName
                    + "')]")));
  }

  public static WebElement getAddToCartButton(WebElement productElement) {
    return productElement.findElement(
        By.xpath(
            "./ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']"));
  }
}
