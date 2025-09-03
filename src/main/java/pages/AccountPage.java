package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickAnyWhere(By argElement, String arg) throws InterruptedException {
        clickAnyValue(argElement, arg);
    }

}
