package hw19.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderFragment {

    @FindBy(xpath = "//button[@class='nav-menu__label jsNavMenuLabel' and text()='Mobil']")
    private WebElement mobilMenu;
    @FindBy(xpath = "//button[@class='nav-menu__label jsNavMenuLabel' and text()='Internet']")
    private WebElement internetMenu;
    @FindBy(xpath = "//button[@class='nav-menu__label jsNavMenuLabel' and text()='Tv & streaming']")
    private WebElement streamingMenu;

    public HeaderFragment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openMobileMenu() {
        mobilMenu.click();
    }

    public void openInternetMenu() {
        internetMenu.click();
    }

    public void openTvAndStreamingMenu() {
        streamingMenu.click();
    }
}
