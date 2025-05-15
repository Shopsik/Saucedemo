package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "проверка верной авторизации")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), "Products");
        productPage.addToCart("Sauce Labs Bike Light");
    }

    @Test(priority = 2)
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String errorMsg = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Username is required", "Epic sadface");
    }

    @Test(priority = 1)
    public void incorrectPasswordLogin() {
        loginPage.open();
        loginPage.login("", "secret_");
        String errorMsg = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Username is required", "Epic sadface");
    }
}
