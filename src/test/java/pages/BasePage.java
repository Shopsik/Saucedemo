package pages;

import org.openqa.selenium.Webdriver;

public abstract class BasePage {
    Webdriver driver;
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
}
