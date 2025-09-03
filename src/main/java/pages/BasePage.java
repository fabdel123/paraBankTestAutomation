package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.DriverFactory.driver;

public class BasePage {

    public BasePage(WebDriver driver) {
    }

    //Explicits waits
    protected void waitForElement(By argLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(argLocator));
    }

    //Explicits waits presence of ElementLocated
    protected void waitForPresenceElement(By argLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(argLocator));
    }

    //Explicits waits and click
    protected void waitForElementAndClick(By argLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(argLocator)).click();
    }

    //Click with Attribute Text
    protected void clickAnyValue(By arg, String arg1) {
        boolean vAssert = false;
        List<WebElement> elements = driver.findElements(arg);
        for (WebElement element0 : elements) {
            if (element0.getText().trim().equalsIgnoreCase(arg1.trim())) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click();", element0);
                vAssert = true;
                break;
            }
        }
        if (vAssert) Assert.assertTrue("No se encontro el campo con label " + arg, vAssert);
    }

    //Click with Attribute Text Value
    protected void clickAnyValueWithValue(By arg, String arg1) throws InterruptedException {
        boolean vAssert = false;
        List<WebElement> elements = driver.findElements(arg);
        for (WebElement element0 : elements) {
            if (element0.getAttribute("value").trim().equalsIgnoreCase(arg1.trim())) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click();", element0);
                vAssert = true;
                break;
            }
        }
        if (vAssert) Assert.assertTrue("No se encontro el campo con label " + arg, vAssert);
    }

}