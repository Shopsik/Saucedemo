package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "проверка верной авторизации")
    public void correctLogin() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.titleIsDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(invocationCount = 4)
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
    }

    @Test(priority = 1)
    public void incorrectPasswordLogin() {
        loginPage.open();
        loginPage.login("", "secret_");
    }
}
