package hw18.pages;

import hw18.fragments.HeaderFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MobilePhonesPage {

    private WebDriver driver;
    private HeaderFragment headerFragment;
    private By title = By.xpath("//h1[text()='Stort udvalg af de nyeste mobiltelefoner']");
    private By chips = By.xpath("//span[@class='chips-filters__chip']");
    private By applied = By.xpath("//span[@class='applied-filters__chip']");
    private By appliedFiltersRow = By.xpath("//div[@class='applied-filters__chips']");
    private By headerLink = By.xpath("//a[@href='https://yousee.dk/shop/mobiltelefoner']");
    private List<WebElement> filters;

    public MobilePhonesPage(WebDriver driver, HeaderFragment headerFragment) {
        this.driver = driver;
        this.headerFragment = headerFragment;
    }

    public void open() {
        headerFragment.openMobileMenu();
        driver.findElement(headerLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    public void selectAppleFilter() {
        filters = driver.findElements(chips);
        for (WebElement filter : filters) {
            if (filter.getText().equals("Apple")) {
                filter.click();
                break;
            }
        }
    }

    public By getAppliedFiltersRow() {
        return appliedFiltersRow;
    }

    public String getLastSelectedFilterText() {
        List<WebElement> selected = driver.findElements(applied);
        return selected.get(selected.size() - 1).getText();
    }
}
