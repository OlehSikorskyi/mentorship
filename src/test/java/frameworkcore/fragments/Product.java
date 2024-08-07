package frameworkcore.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product extends BaseFragment {

    By addToCartButton = By.cssSelector("button.btn_inventory");

    WebElement product;

    public Product(WebDriver driver, String productName) {
        super(driver);
        this.product = driver.findElements(By.cssSelector("div.inventory_item")).stream()
                .filter(product -> product.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(productName))
                .findFirst().orElseThrow(() -> new RuntimeException("Product with name " + productName + " is missing"));
    }

    public void addToCart() {
        product.findElement(addToCartButton).click();
    }
}
