package hw19.pages;

import hw19.fragments.HeaderFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class InternetPage extends BasePage {
    private final HeaderFragment headerFragment;
    @FindBys(@FindBy(xpath = "//div[@class='product-card__button']"))
    private List<WebElement> productCardButtons;
    @FindBy(xpath = "//h1[text()='Oplev mobilt internet med Danmarks bedste 5G-dækning']")
    private WebElement title;
    @FindBy(xpath = "//a[@href='https://yousee.dk/shop/mobilt-internet']")
    private WebElement headerLink;
    public InternetPage(WebDriver driver, HeaderFragment headerFragment) {
        super(driver);
        this.headerFragment = headerFragment;
    }

    public void open() {
        headerFragment.openInternetMenu();
        headerLink.click();
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void selectFirstItemInList() {
        productCardButtons.get(0).click();
    }
}
