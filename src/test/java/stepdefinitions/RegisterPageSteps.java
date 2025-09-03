package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

public class RegisterPageSteps {
    WebDriver driver;
    RegisterPage registerPage;

    private final By labelFormRegister = By.tagName("b");
    private final By labelResultCreateAcc = By.cssSelector("div [id=rightPanel] p");


    @And("ParaBank page, send data on the field {string} with the value {string}")
    public void send_Value_Input(String arg, String arg1) {
        registerPage = new RegisterPage(driver);
        registerPage.sendDataInputElement(labelFormRegister, arg.trim(), arg1.trim());
    }

    @And("ParaBank page, check if the value of the alert message is {string}")
    public void check_Alert_Message(String arg) {
        registerPage = new RegisterPage(driver);
        registerPage.alertMessage(labelResultCreateAcc, arg.trim());
    }


}
