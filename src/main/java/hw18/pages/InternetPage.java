package hw18.pages;

import hw18.fragments.HeaderFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InternetPage {

    private WebDriver driver;
    private HeaderFragment headerFragment;
    private By productCardButton = By.xpath("//div[@class='product-card__button']");
    private By title = By.xpath("//h1[text()='Oplev mobilt internet med Danmarks bedste 5G-dækning']");
    private By headerLink = By.xpath("//a[@href='https://yousee.dk/shop/mobilt-internet']");
    public InternetPage(WebDriver driver, HeaderFragment headerFragment) {
        this.driver = driver;
        this.headerFragment = headerFragment;
    }

    public void open() {
        headerFragment.openInternetMenu();
        driver.findElement(headerLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    public void selectFirstItemInList() {
        List<WebElement> buttons = driver.findElements(productCardButton);
        buttons.get(0).click();
    }
}
