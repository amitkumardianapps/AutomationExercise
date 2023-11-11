package helpers;

import org.openqa.selenium.JavascriptExecutor;

import static helpers.BrowserSetup.driver;

public class ScrollHelper {
  public static void scroll(int xOffset, int yOffset) {
    ((JavascriptExecutor) driver)
        .executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
  }
}
