package dataprovider;

import org.testng.annotations.DataProvider;

public class CartData {

  @DataProvider(name = "CartData")
  public Object[][] cartData() {
    return new Object[][] {
      {"standard_user", "secret_sauce","Sauce Labs Backpack","Amit", "Kumar", "10001"},
    };
  }
}
