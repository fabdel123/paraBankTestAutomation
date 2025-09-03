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
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

}
