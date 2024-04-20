package hw18.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderFragment {
    private WebDriver driver;

    private final By mobilMenu = By.xpath("//button[@class='nav-menu__label jsNavMenuLabel' and text()='Mobil']");
    private final By internetMenu = By.xpath("//button[@class='nav-menu__label jsNavMenuLabel' and text()='Internet']");
    private final By streamingMenu = By.xpath("//button[@class='nav-menu__label jsNavMenuLabel' and text()='Tv & streaming']");

    public HeaderFragment(WebDriver driver) {
        this.driver = driver;
    }

    public void openMobileMenu() {
        driver.findElement(mobilMenu).click();
    }

    public void openInternetMenu() {
        driver.findElement(internetMenu).click();
    }

    public void openTvAndStreamingMenu() {
        driver.findElement(streamingMenu).click();
    }
}
