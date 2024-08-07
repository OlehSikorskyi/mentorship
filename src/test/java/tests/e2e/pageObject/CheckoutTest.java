package tests.e2e.pageObject;

import frameworkcore.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "Check that standard_user can purchase the products.")
    public void CheckThatUserCanPurchaseProducts() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getProduct("Sauce Labs Backpack").addToCart();
        productsPage.getProduct("Sauce Labs Bike Light").addToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInShippingForm("Oleh", "Sikorskyi", "79000");
        checkoutPage.clickContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualThankYuoText = checkoutCompletePage.getThankYouMessage();

        Assert.assertEquals(actualThankYuoText, "Thank you for your order!");
    }
}
