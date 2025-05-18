package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Test
public class AddGoodsToCartTest extends BaseTest {
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.isOpen();
        productPage.addToCart(0);
        productPage.addToCart(2);
        productPage.addToCart(3);
        productPage.openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
    }
}
