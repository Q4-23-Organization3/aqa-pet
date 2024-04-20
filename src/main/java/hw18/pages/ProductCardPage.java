package hw18.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCardPage {

    private WebDriver driver;

    private By addToCartButton = By.xpath("//button[@id='mui-1']");

    public ProductCardPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}
