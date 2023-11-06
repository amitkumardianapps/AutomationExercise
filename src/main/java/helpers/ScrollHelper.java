package helpers;

import static helpers.BrowserSetup.driver;

import org.openqa.selenium.JavascriptExecutor;

public class ScrollHelper {
  public static void scroll(int xOffset, int yOffset) {
    ((JavascriptExecutor) driver)
        .executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
  }
}
