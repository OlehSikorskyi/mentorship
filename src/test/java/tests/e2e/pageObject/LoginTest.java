package tests.e2e.pageObject;

import frameworkcore.pages.LoginPage;
import frameworkcore.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Check that user can login. Xpath locators.")
    public void loginTestXpath() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        String title = productsPage.getTitle();

        Assert.assertEquals(title, "Swag Labs");
    }

    @Test(description = "Check that Performance Glitch user can login. Css locators. Use explicit wait")
    public void performanceGlitchLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        loginPage.login("performance_glitch_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.waitLoad();
        String title = productsPage.getTitle();

        Assert.assertEquals(title, "Swag Labs");
    }

    @Test(description = "Check that locked out user cannot login.")
    public void errorLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out22.");
    }
}
