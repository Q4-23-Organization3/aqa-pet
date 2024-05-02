package hw18.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By title = By.xpath("//b[text()='Din kurv']");
    private By cartTotalPrice = By.xpath("//span[@class='cart-summary_priceValue__dP9PG']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTitle() {
        return title;
    }

    public String getTotalPriceInCart() {
        return driver.findElement(cartTotalPrice).getText();
    }
}
