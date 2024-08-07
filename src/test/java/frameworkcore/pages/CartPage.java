package frameworkcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    By checkoutButton = By.cssSelector("button[id=checkout]");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
