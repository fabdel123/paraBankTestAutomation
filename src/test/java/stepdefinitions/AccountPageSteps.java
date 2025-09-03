package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;

public class AccountPageSteps {
    WebDriver driver;
    AccountPage accountPage;

    private final By labelAccMenu = By.cssSelector("div [id=leftPanel] a");


    @And("ParaBank page, Account Page click on the field with the value {string}")
        public void click_Any_Value_Acc(String arg) throws InterruptedException {
            accountPage = new AccountPage(driver);
            accountPage.clickAnyWhere(labelAccMenu, arg);
        }

}
