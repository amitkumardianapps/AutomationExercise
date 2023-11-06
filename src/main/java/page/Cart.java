package page;

import static helpers.BrowserSetup.driver;

import org.openqa.selenium.By;

public class Cart {
  public static String[] itemsToAdd = {"Sauce Labs Backpack", "Sauce Labs Onesie"};

  public static final By cartButtonLocator =
      By.xpath("//div[@id='shopping_cart_container']//a[contains(@class, 'shopping_cart_link')]");
  public static final String actualCartUrl = driver.getCurrentUrl();
  public static final String expectedCartUrl = "https://www.saucedemo.com/v1/inventory.html";
  public static final By checkoutLocator = By.linkText("CHECKOUT");

  public static final By firstNameLocator = By.xpath("//input[@id='first-name']");
  public static final By lastNameLocator = By.xpath("//input[@id='last-name']");
  public static final By zipCodeLocator = By.xpath("//input[@id='postal-code']");
  public static final By continueButtonLocator = By.xpath("//input[@type='submit']");
}
