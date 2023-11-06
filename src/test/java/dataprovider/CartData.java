package dataprovider;

import org.testng.annotations.DataProvider;

public class CartData {

  @DataProvider(name = "CartData")
  public Object[][] cartData() {
    Object[][] Data = {
      {"Your Cart"},
    };
    return Data;
  }
}
