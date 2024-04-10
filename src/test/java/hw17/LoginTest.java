package hw17;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private static String usernameXPath = "//input[@id=\"username\"]";
    private static String passwordXPath = "//input[@id=\"password\"]";
    private static String loginButtonXPath = "//button[@class=\"radius\"]";

    private static String alertXPath = "//div[@id=\"flash\"]";
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void correctLogin() {
        String login = "tomsmith";
        String pass = "SuperSecretPassword!";
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameInput = driver.findElement(By.xpath(usernameXPath));
        WebElement passwordInput = driver.findElement(By.xpath(passwordXPath));
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(pass);
        loginButton.click();
        WebElement successAlert = driver.findElement(By.xpath(alertXPath));
        String message = successAlert.getText();
        assertEquals("You logged into a secure area!\n×", message);
    }

    @Test
    void incorrectLogin() {
        String login = "tomsmith";
        String pass = "WrongPassword!";
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameInput = driver.findElement(By.xpath(usernameXPath));
        WebElement passwordInput = driver.findElement(By.xpath(passwordXPath));
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(pass);
        loginButton.click();
        WebElement successAlert = driver.findElement(By.xpath(alertXPath));
        String message = successAlert.getText();
        assertEquals("Your password is invalid!\n×", message);
    }

    @AfterEach
    void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
