package PetShopQACenter.paginas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaHome {

    public WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "promotion-button")
    public WebElement botonPromocion;

    @FindBy(id = "promotion-message")
    WebElement mensajePromocion;

    @FindBy(id = "logout-button")
    public WebElement botonLogout;

    @FindBy(xpath = "//table[@id='services-table']//tbody//tr")
    List<WebElement> filasServicios;

    public PaginaHome(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, PaginaHome.this);
    }

    public void hacerClickPromocion(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("promotion-button"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public boolean esPromocionVisible(){
        return mensajePromocion.isDisplayed();
    }

    public int obtenerCantidadServicios(){
        return filasServicios.size();
    }

    public void cerrarSesion(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout-button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
    }
}
