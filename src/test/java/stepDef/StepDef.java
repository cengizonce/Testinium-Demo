package stepDef;

import base.Log;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class StepDef extends MethodDef {

    public void existElementClick(WebElement element, long timeOutInSeconds) {
        List<WebElement> elements = new ArrayList<>();
        elements.add(element);
        if (elements.size() > 0) {
            Log.info("Detected Cookie");
            clickWithWait(element, timeOutInSeconds);
            Log.info("Cookie is disable");
        }
    }

    public void hover(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        actions(element);
    }

    public void clickWithWait(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        clickElement(element);
    }

    public void sendTextWithWait(WebElement element, String key, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        sendKeysElement(element, key);
    }

    public void clickWithScroll(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        scrollElement(element);
        clickElement(element);
    }

    public void selectPageNumber(List<WebElement> elements, String key, long timeOutInSeconds) {
        scrollForPageNumber(elements.get(1), timeOutInSeconds);
        for (WebElement element : elements) {
            String pageNumber = getTextElement(element);
            if (pageNumber.equals(key)) {
                Log.info("Selected page number = " + pageNumber);
                clickWithWait(element, timeOutInSeconds);
                break;
            }
        }
    }

    public void controlPageNumber(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        Assert.assertEquals("Page number is false!!!", getAttributeWithStrValue(element, "href"), currentUrl());
        Log.info("Page number is true.");
    }

    public void randomSelectProduct(List<WebElement> elements, long timeOutInSeconds) {
        int productNumber = randomNumberBetweenOneAndInt(elements.size());
        Log.info("Random product number = " + productNumber);
        WebElement element = elements.get(productNumber);
        clickWithScroll(element, timeOutInSeconds);
    }

    public static String productPagePrice = null;

    public void keepProductPrice(WebElement highPrice, WebElement lowPrice, long timeOutInSeconds) {
        waitForClickablility(highPrice, timeOutInSeconds);
        WebElement existElement = selectExistElement(highPrice, lowPrice);
        productPagePrice = getTextElement(existElement);
        Log.info("Product page price = " + productPagePrice);
    }

    public void controlForStrValues(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        String productBasketPrice = getTextElement(element);
        Log.info("Product basket price = " + productBasketPrice);
        Assert.assertEquals("Product Page price is not equal to Basket price", productBasketPrice, productPagePrice);
        Log.info("Product Page price is equal to Basket price");
    }

    public void selectElement(WebElement selectListElement, WebElement selectOption, long timeOutInSeconds) {
        waitForVisibility(selectListElement, timeOutInSeconds);
        Select select = new Select(selectListElement);
        select.selectByValue(getAttributeWithStrValue(selectOption, "Value"));
    }

    public void productAmountControl(WebElement selectedList, WebElement productAmountBasket, long timeOutInSeconds) {
        waitForVisibility(selectedList, timeOutInSeconds);
        String expectedAmount = getAttributeWithStrValue(selectedList, "Value");
        String actualAmount = getTextElement(productAmountBasket);
        Assert.assertTrue("Product amount is false!!!", actualAmount.contains(expectedAmount));
        Log.info("Product amount is true");
    }

    public void loginControl(WebElement element, String userName, long timeOutInSeconds) {
        hover(element, timeOutInSeconds);
        System.out.println(userName);
        System.out.println(getTextElement(element));
        Assert.assertTrue("Login is unsuccessful!!!", getTextElement(element).contains(userName));
        Log.info("Login is successful");
    }

    public void emptyBasketControl(WebElement element, long timeOutInSeconds) {
        waitForClickablility(element, timeOutInSeconds);
        Assert.assertNotNull("Basket is not empty!!!", element);
        Log.info("Basket is empty.");
    }

    public void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            Log.info("Wait for loading page...");
            wait.until(expectation);
            Log.info("Loading successful.");
        } catch (Throwable error) {
            Log.error("Load page unsuccessful!!!");
        }
    }

}




