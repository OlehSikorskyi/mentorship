package frameworkcore.pages;

import frameworkcore.fragments.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {
    By title = By.xpath("//div[@class=\"app_logo\"]");
    By cartIcon = By.cssSelector("div[id=shopping_cart_container] a");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void waitLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    public Product getProduct(String name) {
        return new Product(driver, name);
    }
}
