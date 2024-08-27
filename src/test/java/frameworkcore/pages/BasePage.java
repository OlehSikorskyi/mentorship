package frameworkcore.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Navigate to the home page")
    public void launch() {
        driver.get("https://www.saucedemo.com/");
    }
}
