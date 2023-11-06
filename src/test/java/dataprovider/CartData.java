package dataprovider;

import org.testng.annotations.DataProvider;

public class CartData {

  @DataProvider(name = "CartData")
  public Object[][] cartData() {
    return new Object[][] {
      {"Sauce Labs Backpack"},
    };
  }
}
