package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    static WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }


    // *TIKLAMA METHODU SWITCH-CASE
    public void clickElement(String locatorType, String LocatorValue) {
        WebElement element = null;
        switch (locatorType.toLowerCase()) {
            case "id":
                element = driver.findElement(By.id(LocatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(LocatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(LocatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        element.click();
    }


    // *SEND KEYS SWITCH-CASE
    public void sendKeysToElement(String locatorType, String LocatorValue, String message) {
        WebElement element = null;
        switch (locatorType.toLowerCase()) {
            case "id":
                element = driver.findElement(By.id(LocatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(LocatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(LocatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        element.sendKeys(message);
    }


    // *WAIT SWITCH-CASE
    public void waitUntilElement(String locatorType, String LocatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        switch (locatorType.toLowerCase()) {
            case "id":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(LocatorValue)));
                break;
            case "css":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(LocatorValue)));
                break;
            case "xpath":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocatorValue)));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }


    // *PRESS ENTER SWITCH-CASE
    public void pressEnterOnElement(String locatorType, String LocatorValue) {
        WebElement element = null;
        switch (locatorType.toLowerCase()) {
            case "id":
                element = driver.findElement(By.id(LocatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(LocatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(LocatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        element.sendKeys(Keys.ENTER);
    }




// *sayfayı asagı kaydırma metotu

    public void asagiKaydir() {
        // JavaScriptExecutor'ı başlatın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Sayfayı aşağı kaydırın
        js.executeScript("window.scrollBy(0, 500)"); // Yatay kaydırmayı değiştirmek için 0'ın yerine farklı bir değer kullanabilirsiniz

    }

    //* Özel assertion metotu oluşturun
    public void assertElementIsVisible(String locatorType, String LocatorValue) {
        WebElement element = null;
        switch (locatorType.toLowerCase()) {
            case "id":
                element = driver.findElement(By.id(LocatorValue));
                Assert.assertTrue(element.isDisplayed());
                break;
            case "css":
                element = driver.findElement(By.cssSelector(LocatorValue));
                Assert.assertTrue(element.isDisplayed());
                break;
            case "xpath":
                element = driver.findElement(By.xpath(LocatorValue));
                Assert.assertTrue(element.isDisplayed());
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }


    //* assert equals metotu
    public void assertEq(String expetcted, String actual) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(expetcted, actual);
    }


}