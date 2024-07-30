package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    public WebDriver driver;
    public static final String USER_DIR = "user.dir";
    public static final String CHROME_DRIVER_PATH = "\\src\\test\\resources\\chromedriver.exe";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(USER_DIR) + CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test(description = "Check that standard_user can purchase the products.")
    public void performanceGlitchLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement user_name = driver.findElement(By.id("user-name"));
        user_name.clear();
        user_name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id=\"login-button\"]"));
        loginButton.click();

        WebElement addToCartBackpack = driver.findElement(By.cssSelector("div.inventory_item button[id=add-to-cart-sauce-labs-backpack]"));
        addToCartBackpack.click();

        WebElement addToCartBikeLight = driver.findElement(By.cssSelector("div.inventory_item button[id=add-to-cart-sauce-labs-bike-light]"));
        addToCartBikeLight.click();

        WebElement cartIcon = driver.findElement(By.cssSelector("div[id=shopping_cart_container] a"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("button[id=checkout]"));
        checkoutButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("input[id=first-name]"));
        firstName.sendKeys("Oleh");

        WebElement lastName = driver.findElement(By.cssSelector("input[id=last-name]"));
        lastName.sendKeys("Sikorskyi");

        WebElement zipCode = driver.findElement(By.cssSelector("input[id=postal-code]"));
        zipCode.sendKeys("79000");

        WebElement continueButton = driver.findElement(By.cssSelector("input[id=continue]"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.cssSelector("button[id=finish]"));
        finishButton.click();

        WebElement thankYouText = driver.findElement(By.cssSelector("div.checkout_complete_container h2"));
        String actualThankYuoText = thankYouText.getText();

        Assert.assertEquals(actualThankYuoText, "Thank you for your order!");
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
