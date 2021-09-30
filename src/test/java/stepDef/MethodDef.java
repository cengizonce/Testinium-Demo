package stepDef;

import base.Driver;
import base.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class MethodDef extends Driver {

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendKeysElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void scrollElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }

    public void waitForVisibility(WebElement element, long timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickablility(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void actions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public String getAttributeWithStrValue(WebElement element, String key) {
        return element.getAttribute(key);
    }


    public void wait(int timeOutInSeconds) throws InterruptedException {
        int second = timeOutInSeconds * 1000;
        Thread.sleep(second);
    }

    public void scrollForPageNumber(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        scrollElement(element);
    }

    public int randomNumberBetweenOneAndInt(int size) {
        Random random = new Random();
        Log.info("Random number selecting...");
        int min = 1;
        Log.info("Min number = " + min);
        Log.info("Max number = " + size);

        return random.nextInt(size - min) + min;
    }

    public WebElement selectExistElement(WebElement firstElement, WebElement secondElement) {
        WebElement activeElement = null;
        if (firstElement.isEnabled()) {
            activeElement = firstElement;
            Log.info("Product have high price text");
        }
        if (secondElement.isEnabled()) {
            activeElement = secondElement;
            Log.info("Product have low price text");
        }
        return activeElement;
    }

    public String currentUrl() {
        Log.info("Current url = " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

}




