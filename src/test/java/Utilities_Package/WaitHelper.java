package Utilities_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {

    // Generic function to wait for element to be clickable
    public static void WaitToBeClickable(WebDriver driver, String locator, String locatorValue, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        if (locator == "xpath") {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }

        if (locator == "Id") {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        }

        if (locator == "CssSelector") {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
        }
    }

    public static void WaitToBeVisible(WebDriver driver, String locator, String locatorValue, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        if (locator == "xpath") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        }

        if (locator == "Id") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        }

        if (locator == "CssSelector") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
        }
    }
}
