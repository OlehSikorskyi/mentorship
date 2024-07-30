package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;
    public static final String USER_DIR = "user.dir";
    public static final String CHROME_DRIVER_PATH = "\\src\\test\\resources\\chromedriver.exe";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(USER_DIR) + CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "Check page title")
    public void getTitleTest() {
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }


    @Test(description = "Check that user can login. Xpath locators.")
    public void loginTestXpath() {
        driver.get("https://www.saucedemo.com/");
        WebElement user_name = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
        user_name.clear();
        user_name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
        loginButton.click();
        WebElement title = driver.findElement(By.xpath("//div[@class=\"app_logo\"]"));
        String expectedTitle = title.getText();
        Assert.assertEquals(expectedTitle, "Swag Labs");
    }

    @Test(description = "Check tha user can login. Css locators.")
    public void loginTestCss() {
        driver.get("https://www.saucedemo.com/");
        WebElement user_name = driver.findElement(By.id("user-name"));
        user_name.clear();
        user_name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id=\"login-button\"]"));
        loginButton.click();
        WebElement title = driver.findElement(By.cssSelector("div.app_logo"));
        String expectedTitle = title.getText();
        Assert.assertEquals(expectedTitle, "Swag Labs");
    }

    @Test(description = "Check that Performance Glitch user can login. Css locators. Use explicit wait")
    public void performanceGlitchLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement user_name = driver.findElement(By.id("user-name"));
        user_name.clear();
        user_name.sendKeys("performance_glitch_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id=\"login-button\"]"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.app_logo")));
        WebElement title = driver.findElement(By.cssSelector("div.app_logo"));
        String expectedTitle = title.getText();
        Assert.assertEquals(expectedTitle, "Swag Labs");
    }

    @Test(description = "Check that locked out user cannot login.")
    public void errorLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement user_name = driver.findElement(By.id("user-name"));
        user_name.clear();
        user_name.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id=\"login-button\"]"));
        loginButton.click();
        WebElement error = driver.findElement(By.cssSelector("div.error-message-container h3"));
        String expectedTitle = error.getText();
        Assert.assertEquals(expectedTitle, "Epic sadface: Sorry, this user has been locked out.");
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
