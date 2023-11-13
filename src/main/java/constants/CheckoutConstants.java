package constants;

import static helpers.BrowserSetup.driver;

public class CheckoutConstants {
  public static final String CART_URL = driver.getCurrentUrl(); //TODO extract url at runtime
  public static final String EXPECTED_CART_URL = "https://www.saucedemo.com/v1/cart.html";
}
