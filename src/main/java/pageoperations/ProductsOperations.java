package pageoperations;

import org.openqa.selenium.WebElement;

import static pageobject.Cart.getAddToCartButton;
import static pageobject.Cart.getProductByName;

public class ProductsOperations {

  public static void addToCart(String[] itemsToAdd) {
    for (String itemToAdd : itemsToAdd) {
      WebElement item = getProductByName(itemToAdd);
      WebElement addToCartButton = getAddToCartButton(item);
      addToCartButton.click();
    }
  }
}
