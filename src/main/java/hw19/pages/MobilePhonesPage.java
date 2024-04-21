package hw19.pages;

import hw19.fragments.HeaderFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class MobilePhonesPage extends BasePage {

    private final HeaderFragment headerFragment;
    @FindBy(xpath = "//h1[text()='Stort udvalg af de nyeste mobiltelefoner']")
    private WebElement title;
    @FindBys(@FindBy(xpath = "//span[@class='chips-filters__chip']"))
    private List<WebElement> chips;
    @FindBys(@FindBy(xpath = "//span[@class='applied-filters__chip']"))
    private List<WebElement> applied;
    @FindBys(@FindBy(xpath = "//div[@class='applied-filters__chips']"))
    private List<WebElement> appliedFiltersRow;
    @FindBy(xpath = "//a[@href='https://yousee.dk/shop/mobiltelefoner']")
    private WebElement headerLink;

    public MobilePhonesPage(WebDriver driver, HeaderFragment fragment) {
        super(driver);
        this.headerFragment = fragment;
    }

    public void open() {
        headerFragment.openMobileMenu();
        headerLink.click();
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void selectAppleFilter() {
        for (WebElement filter : chips) {
            if (filter.getText().equals("Apple")) {
                filter.click();
                break;
            }
        }
    }

    public List<WebElement> getAppliedFiltersRow() {
        return appliedFiltersRow;
    }

    public String getLastSelectedFilterText() {
        return applied.get(applied.size() - 1).getText();
    }
}
