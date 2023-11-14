package pageoperations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobject.Cart;
import reporting.ExtentManager;

import static helpers.BrowserSetup.driver;
import static pageobject.Cart.getAddToCartButton;
import static pageobject.Cart.getProductByName;

public class ProductsOperations {

  public ProductsOperations()
  {
    PageFactory.initElements(driver, Cart.class);
  }

  public static void addToCart(String[] itemsToAdd) {
    for (String itemToAdd : itemsToAdd) {
      WebElement item = getProductByName(itemToAdd);
      WebElement addToCartButton = getAddToCartButton(item);
      addToCartButton.click();
      ExtentManager.log("Added " + itemToAdd + " to the cart");
    }
  }
}
