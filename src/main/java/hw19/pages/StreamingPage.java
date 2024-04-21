package hw19.pages;

import hw19.fragments.HeaderFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StreamingPage extends BasePage {
    private final HeaderFragment fragment;
    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-6l2s2y']")
    private WebElement title;
    @FindBy(xpath = "//a[@href='https://yousee.dk/netflix']")
    private WebElement headerLink;

    public StreamingPage(WebDriver driver, HeaderFragment fragment) {
        super(driver);
        this.fragment = fragment;
    }

    public void open() {
        fragment.openTvAndStreamingMenu();
        headerLink.click();
        wait.until(ExpectedConditions.urlToBe("https://yousee.dk/netflix"));
    }

    public String getTitle() {
        return title.getText();
    }
}
