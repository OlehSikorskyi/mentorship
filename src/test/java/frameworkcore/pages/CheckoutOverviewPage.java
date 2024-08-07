package frameworkcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    By finishButton = By.cssSelector("button[id=finish]");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
