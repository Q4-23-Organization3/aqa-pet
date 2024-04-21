package hw19;

import hw19.fragments.HeaderFragment;
import hw19.pages.CartPage;
import hw19.pages.InternetPage;
import hw19.pages.MainEcommPage;
import hw19.pages.MobilePhonesPage;
import hw19.pages.ProductCardPage;
import hw19.pages.StreamingPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageFactoryTest {

    private WebDriver driver;
    private MainEcommPage mainEcommPage;
    private HeaderFragment headerFragment;
    private ProductCardPage productCardPage;
    private InternetPage internetPage;
    private CartPage cartPage;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainEcommPage = new MainEcommPage(driver);
        headerFragment = new HeaderFragment(driver);
        internetPage = new InternetPage(driver, headerFragment);
        productCardPage = new ProductCardPage(driver);
        cartPage = new CartPage(driver);
        driver.get("https://yousee.dk/");
        mainEcommPage.closeGdprPopup();
    }

    @Test
    public void mainPageBannerTextCorrect() {
        String actualTitle = mainEcommPage.getMainTitle();
        Assertions.assertThat(actualTitle).isEqualTo("Få halv pris de første 3 mdr.");
    }

    @Test
    public void checkApplyFiltersOnMobilePage() {
        MobilePhonesPage mobilePhonesPage = new MobilePhonesPage(driver, headerFragment);
        mobilePhonesPage.open();
        mobilePhonesPage.selectAppleFilter();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(mobilePhonesPage.getAppliedFiltersRow()));
        String selectedFilterTitle = mobilePhonesPage.getLastSelectedFilterText();
        Assertions.assertThat(selectedFilterTitle).isEqualTo("Apple");
    }

    @Test
    public void addToCartFlowWorking() {
        internetPage.open();
        internetPage.selectFirstItemInList();

        WebDriverWait addToCartButtonWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        addToCartButtonWait.until(ExpectedConditions.visibilityOf(productCardPage.getAddToCartButton()));
        productCardPage.clickAddToCart();

        WebDriverWait cartLoadedWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        cartLoadedWait.until(ExpectedConditions.urlToBe("https://yousee.dk/shop/kurv"));
        String title = cartPage.getTitle().getText();
        Assertions.assertThat(title).isEqualTo("Din kurv");
    }

    @Test
    public void productPriceInCartShowingCorrectly() {
        internetPage.open();
        internetPage.selectFirstItemInList();

        WebDriverWait addToCartButtonWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        addToCartButtonWait.until(ExpectedConditions.visibilityOf(productCardPage.getAddToCartButton()));
        productCardPage.clickAddToCart();

        WebDriverWait cartLoadedWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        cartLoadedWait.until(ExpectedConditions.urlToBe("https://yousee.dk/shop/kurv"));
        String totalPrice = cartPage.getTotalPriceInCart();
        Assertions.assertThat(totalPrice).isEqualTo("59,50");
    }

    @Test
    public void pageNetflixStreamingOpens() {
        StreamingPage streamingPage = new StreamingPage(driver, headerFragment);
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
