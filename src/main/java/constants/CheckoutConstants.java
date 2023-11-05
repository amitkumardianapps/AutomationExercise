package constants;

import static helpers.BrowserSetup.driver;

public class CheckoutConstants {
  public static final String actualCartUrl = driver.getCurrentUrl();
  public static final String expectedCartUrl = "https://www.saucedemo.com/v1/cart.html";
}
