package hw19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//b[text()='Din kurv']")
    private WebElement title;
    @FindBy(xpath = "//span[@class='cart-summary_priceValue__dP9PG']")
    private WebElement cartTotalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public String getTotalPriceInCart() {
        return cartTotalPrice.getText();
    }
}
