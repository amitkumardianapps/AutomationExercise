package pageoperations;

import org.openqa.selenium.WebElement;

import static pageobject.Cart.getAddToCartButton;
import static pageobject.Cart.getProductByName;

public class ProductsOperations {

  public static void addToCart(String[] itemsToAdd) {
    for (String itemToAdd : itemsToAdd) {

      // Get product element
      WebElement item = getProductByName(itemToAdd);

      // Get "Add to Cart" button and click
      WebElement addToCartButton = getAddToCartButton(item);
      addToCartButton.click();
    }
  }
}
