package hw18.pages;

import hw18.fragments.HeaderFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StreamingPage {

    private WebDriver driver;
    private HeaderFragment fragment;

    private By title = By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1 css-6l2s2y']");
    private By headerLink = By.xpath("//a[@href='https://yousee.dk/netflix']");

    public StreamingPage(WebDriver driver, HeaderFragment fragment) {
        this.driver = driver;
        this.fragment = fragment;
    }

    public void open() {
        fragment.openTvAndStreamingMenu();
        driver.findElement(headerLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://yousee.dk/netflix"));
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
