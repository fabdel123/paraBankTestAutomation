package stepdefinitions;

import org.openqa.selenium.By;
import pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver;
    HomePage homePage;

    private final By labelClick = By.tagName("a");
    private final By buttonInput = By.cssSelector("input.button");

    @Given("Navigate to the page ParaBank")
    public void navigate_To_The_Page_ParaBank() {
        homePage = new HomePage(driver);
        homePage.getUrl();
    }

    @And("ParaBank page, Click on the field with the name {string}")
    public void click_Any_Element(String arg) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickAny(labelClick, arg.trim());
    }

    @And("ParaBank page, Click on the element with the name {string}")
    public void click_Any_Element_Value(String arg) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickAnyAttribute(buttonInput, arg.trim());
    }


}
