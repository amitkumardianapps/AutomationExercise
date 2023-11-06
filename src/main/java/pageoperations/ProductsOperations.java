package pageoperations;

import static helpers.BrowserSetup.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static page.Cart.itemsToAdd;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsOperations {

  public static void addToCart() {

    for (String itemToAdd : itemsToAdd) {
      WebDriverWait wait =
          new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration for wait time
      WebElement item =
          wait.until(
              visibilityOfElementLocated(
                  By.xpath(
                      "//div[@class='inventory_item_label']//a//div[contains(text(), '"
                          + itemToAdd
                          + "')]")));
      WebElement addToCartButton =
          item.findElement(
              By.xpath(
                  "./ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']"));
      addToCartButton.click();
      System.out.println("Added " + itemToAdd + " to the cart.");
    }
  }
}
