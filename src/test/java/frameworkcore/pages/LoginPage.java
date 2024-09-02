package frameworkcore.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"user-name\"]")
    WebElement userName;

    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    WebElement loginButton;

    @FindBy(css = "div.error-message-container h3")
    WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with username {userEmail} and password {userPassword}")
    public void login(String userEmail, String userPassword) {
        userName.clear();
        userName.sendKeys(userEmail);
        password.clear();
        password.sendKeys(userPassword);
        loginButton.click();
    }

    public String getErrorMessage() {
        return error.getText();
    }
}