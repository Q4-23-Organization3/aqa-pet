package hw19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainEcommPage extends BasePage {
    @FindBy(xpath = "//h1[@class='banner__title jsBannerTitle']")
    private WebElement mainTitle;

    @FindBy(xpath = "//button[@id='acceptButton']")
    private WebElement gdprButtonAgree;

    public MainEcommPage(WebDriver driver) {
        super(driver);
    }

    public void closeGdprPopup() {
        gdprButtonAgree.click();
    }

    public String getMainTitle(){
        return mainTitle.getText();
    }
}
