package frameworkcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    By thankYouText = By.cssSelector("div.checkout_complete_container h2");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getThankYouMessage() {
        return driver.findElement(thankYouText).getText();
    }
}
