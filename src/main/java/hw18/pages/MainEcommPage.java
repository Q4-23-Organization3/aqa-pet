package hw18.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainEcommPage {
    public WebDriver driver;

    private By mainTitle = By.xpath("//h1[@class='banner__title jsBannerTitle']");

    public MainEcommPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMainTitle(){
        return driver.findElement(mainTitle).getText();
    }
}
