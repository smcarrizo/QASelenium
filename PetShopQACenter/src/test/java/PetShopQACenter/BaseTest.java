package PetShopQACenter;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    private final String URL = "file:///C:/Users/smcarrizo/Downloads/desafio_final_selenium_java.html";
    protected WebDriver driver;

    @Before
    public void iniciar() {
        driver = new ChromeDriver();
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-page"))).isDisplayed());
    }

    @After
    public void cerrar() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
