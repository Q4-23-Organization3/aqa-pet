package hw19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardPage extends BasePage {
    @FindBy(xpath = "//button[@id='mui-1']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//span[@class='customer-type-popover_optionText__uWqV1' and text()='Nej, jeg har ikke et mobilabonnement hos YouSee.']")
    private WebElement firstTimeUserMenu;
    @FindBy(xpath = "//div[@class='customer-type-popover_root__HOhqz modal_container__yKQvx']")
    private WebElement firstTimeUserPopup;

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickAddToCart() {
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstTimeUserPopup));
        firstTimeUserMenu.click();
    }
}
