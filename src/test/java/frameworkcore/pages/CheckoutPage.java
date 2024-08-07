package frameworkcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    By firstName = By.cssSelector("input[id=first-name]");
    By lastName = By.cssSelector("input[id=last-name]");
    By zipCode = By.cssSelector("input[id=postal-code]");
    By continueButton = By.cssSelector("input[id=continue]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInShippingForm(String firstName, String lastName, String zipCode) {
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.zipCode).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
