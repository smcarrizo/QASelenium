
package PetShopQACenter.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaRegistro {

    public WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "open-register-page")
    public WebElement botonIrRegistro;

    @FindBy(id = "pet-name")
    WebElement campoNombre;

    @FindBy(id = "pet-owner")
    public WebElement campoDuenio;

    @FindBy(id = "pet-species")
    public WebElement campoEspecie;

    @FindBy(id = "pet-age")
    public WebElement campoEdad;

    @FindBy(id = "pet-vaccinated")
    public WebElement checkVacunado;

    @FindBy(id = "pet-photo")
    public WebElement inputArchivo;

    @FindBy(id = "save-pet-button")
    public WebElement botonGuardar;

    @FindBy(id = "pet-success")
    public WebElement mensajeExito;

    public PaginaRegistro(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void irARegistro(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("open-register-page"))).click();
    }

    public void completarFormulario(String nombre, String duenio, String especie){
        campoNombre.sendKeys(nombre);
        campoDuenio.sendKeys(duenio);
        campoEspecie.sendKeys(especie);

        if(!checkVacunado.isSelected()){
            checkVacunado.click();
        }
    }

    public void guardar(){
        botonGuardar.click();
    }

    public boolean esRegistroExitoso(){
        return mensajeExito.isDisplayed();
    }
}

