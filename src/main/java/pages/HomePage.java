package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import java.util.List;

import static utils.DriverFactory.driver;

public class HomePage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private final By industriesLink = By.id("menu-item-4871");
    private final By industriesTitleLink = By.cssSelector("h6.industry-item__title");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getUrl() {
        driver.get(ConfigReader.get("base.url"));
    }


    public void clickAny(By arg, String arg1) throws InterruptedException {
        clickAnyValue(arg, arg1);
    }

    public void clickAnyAttribute(By arg, String arg1) throws InterruptedException {
        clickAnyValueWithValue(arg, arg1);
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
                input.sendKeys(arg1);
                vAssert = true;
                break;
            }
        }
        Assert.assertTrue("No se encontro el campo " + arg, vAssert);
    }

    public void hoverMouseAndClickLinkText(String linkText) {
        // Verify that the field 'Industries' menu is visible
        waitForElement(industriesLink);
        //Assert.assertEquals("Industries", driver.findElement(industriesLink).getText());

        // Hover over the element
        WebElement hoverable = driver.findElement(industriesLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String mouseOverScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent('mouseover', true, true, window, 0, 0, 0, 0, 0," +
                "false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        js.executeScript(mouseOverScript, hoverable);

        // Obtain all available titles under the industry
        List<WebElement> industryTitles = driver.findElements(industriesTitleLink);
        for (WebElement title : industryTitles) {
            String actualText = title.getText().trim();
            if (actualText.equals(linkText)) {
                title.click();
                break;
            }
        }
    }


}
