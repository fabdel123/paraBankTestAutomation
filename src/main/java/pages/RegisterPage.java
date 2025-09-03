package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DataStore;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import java.util.List;

import static utils.DriverFactory.driver;

public class RegisterPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

        /*public void sendDataInputElement(By argLabel, By argInput, String arg, String arg1) {
        boolean vAssert = false;
        waitForElement(argLabel);
        Assert.assertEquals(arg, driver.findElement(argLabel).getText());
        List<WebElement> elements = driver.findElements(argLabel);
        for (WebElement element0 : elements) {
            List<WebElement> labels = element0.findElements(argInput);
            for (WebElement label : labels) {
                if (label.getText().trim().equalsIgnoreCase(arg.trim())) {
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("arguments[0].scrollIntoView();", label);
                    WebElement input = label.findElement(argLabel);
                    input.clear();
                    input.sendKeys(arg1);
                    vAssert = true;
                }
                break;
            }
            if (vAssert) {
                break;
                }
        }
        Assert.assertTrue("No se encontro el campo " + arg, vAssert);
    }*/


    public void sendDataInputElement(By argLabel, String arg, String arg1) {
        boolean vAssert = false;
        List<WebElement> elements = driver.findElements(argLabel);
        for (WebElement element0 : elements) {
            if (element0.getText().trim().contains(arg.trim())) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].scrollIntoView()", element0);
                WebElement input = element0.findElement(By.xpath("./parent::td/following-sibling::td[1]//input"));
                input.clear();
                String valueToSend;
                if (arg1.trim().equalsIgnoreCase("")) {
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
                    valueToSend = now.format(formatter);
                } else {
                    valueToSend = arg1.trim();
                }
                input.sendKeys(valueToSend);
                vAssert = true;
                break;
            }
        }
        Assert.assertTrue("No se encontro el campo " + arg, vAssert);
    }

    public void alertMessage(By argMessage, String arg) {
        boolean vAssert = false;
        waitForElement(argMessage);
        Assert.assertEquals(arg, driver.findElement(argMessage).getText());
        List<WebElement> elements = driver.findElements(argMessage);
        for (WebElement element0 : elements) {
            if (element0.getText().trim().equals(arg.trim())) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].scrollIntoView();", element0);
                vAssert = true;
            }
            break;
        }
        Assert.assertTrue("No se encontro el campo " + arg, vAssert);
    }

}
