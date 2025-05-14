package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");

    public ProductPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }
}
