package hw18;

import hw18.fragments.HeaderFragment;
import hw18.pages.CartPage;
import hw18.pages.InternetPage;
import hw18.pages.MainEcommPage;
import hw18.pages.MobilePhonesPage;
import hw18.pages.ProductCardPage;
import hw18.pages.StreamingPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageObjectTest {
    private WebDriver driver;
    private MainEcommPage mainEcommPage;
    private MobilePhonesPage mobilePhonesPage;
    private InternetPage internetPage;
    private ProductCardPage productCardPage;
    private CartPage cartPage;
    private StreamingPage streamingPage;

    private By gdprButtomAgree = By.xpath("//button[@id='acceptButton']");
    private By firstTimeUserMenu = By.xpath("//span[@class='customer-type-popover_optionText__uWqV1' and text()='Nej, jeg har ikke et mobilabonnement hos YouSee.']");
    private By firstTimeUserPopup = By.xpath("//div[@class='customer-type-popover_root__HOhqz modal_container__yKQvx']");
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        HeaderFragment headerFragment = new HeaderFragment(driver);
        mainEcommPage = new MainEcommPage(driver);
        mobilePhonesPage = new MobilePhonesPage(driver, headerFragment);
        internetPage = new InternetPage(driver, headerFragment);
        productCardPage = new ProductCardPage(driver);
        cartPage = new CartPage(driver);
        streamingPage = new StreamingPage(driver, headerFragment);
        driver.get("https://yousee.dk/");
        WebElement acceptCookies = driver.findElement(gdprButtomAgree);
        acceptCookies.click();
    }

    @Test
    public void mainPageBannerTextCorrect() {
        String actualTitle = mainEcommPage.getMainTitle();
        Assertions.assertThat(actualTitle).isEqualTo("Få halv pris de første 3 mdr.");
    }

    @Test
    public void checkApplyFiltersOnMobilePage(){
        mobilePhonesPage.open();
        mobilePhonesPage.selectAppleFilter();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhonesPage.getAppliedFiltersRow()));
        String selectedFilterTitle = mobilePhonesPage.getLastSelectedFilterText();
        Assertions.assertThat(selectedFilterTitle).isEqualTo("Apple");
    }

    @Test
    public void addToCartFlowWorking() {
        internetPage.open();
        internetPage.selectFirstItemInList();

        WebDriverWait addToCartButtonWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        addToCartButtonWait.until(ExpectedConditions.visibilityOfElementLocated(productCardPage.getAddToCartButton()));
        productCardPage.clickAddToCart();

        WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        popupWait.until(ExpectedConditions.visibilityOfElementLocated(firstTimeUserPopup));
        WebElement popupElement = driver.findElement(firstTimeUserMenu);
        popupElement.click();

        WebDriverWait cartLoadedWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        cartLoadedWait.until(ExpectedConditions.urlToBe("https://yousee.dk/shop/kurv"));
        String title = driver.findElement(cartPage.getTitle()).getText();
        Assertions.assertThat(title).isEqualTo("Din kurv");
    }

    @Test
    public void productPriceInCartShowingCorrectly() {
        internetPage.open();
        internetPage.selectFirstItemInList();

        WebDriverWait addToCartButtonWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        addToCartButtonWait.until(ExpectedConditions.visibilityOfElementLocated(productCardPage.getAddToCartButton()));
        productCardPage.clickAddToCart();

        WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        popupWait.until(ExpectedConditions.visibilityOfElementLocated(firstTimeUserPopup));
        WebElement popupElement = driver.findElement(firstTimeUserMenu);
        popupElement.click();

        WebDriverWait cartLoadedWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        cartLoadedWait.until(ExpectedConditions.urlToBe("https://yousee.dk/shop/kurv"));
        String totalPrice = cartPage.getTotalPriceInCart();
        Assertions.assertThat(totalPrice).isEqualTo("59,50");
    }

    @Test
    public void pageNetflixStreamingOpens() {
        streamingPage.open();
        String title = streamingPage.getTitle();
        Assertions.assertThat(title).isEqualTo("Bland Netflix ind i din tv-pakke");
    }

    @AfterEach
    void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
