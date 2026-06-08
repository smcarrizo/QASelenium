package PetShopQACenter.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {

    public WebDriver driver;

    @FindBy(id = "login-username")
    public WebElement campoUsuario;

    @FindBy(id = "login-password")
    public WebElement campoPassword;

    @FindBy(id = "login-submit")
    public WebElement botonLogin;

    @FindBy(id = "login-success")
    public WebElement mensajeExito;

    @FindBy(id = "login-error")
    public WebElement mensajeError;

    public PaginaLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void realizarLogin(String usuario, String clave){
        campoUsuario.sendKeys(usuario);
        campoPassword.sendKeys(clave);
        botonLogin.click();
    }

    public boolean esLoginExitoso(){
        return mensajeExito.isDisplayed();
    }

    public boolean esLoginFallido(){
        return mensajeError.isDisplayed();
    }
}
