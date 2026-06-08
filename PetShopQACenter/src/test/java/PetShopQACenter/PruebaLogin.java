package PetShopQACenter;

import org.junit.Assert;
import org.junit.Test;

import PetShopQACenter.paginas.PaginaLogin;

public class PruebaLogin extends BaseTest {
    private PaginaLogin paginaLogin;

    // Escenario 1: Login exitoso
    @Test
    public void loginExitoso(){
        paginaLogin  = new PaginaLogin(driver);
        paginaLogin.realizarLogin("admin", "123456");

        Assert.assertTrue(paginaLogin.esLoginExitoso());
    }

    // Escenario 2: Login fallido
    @Test
    public void loginInvalido(){
        paginaLogin = new PaginaLogin(driver);
        paginaLogin.realizarLogin("admin", "123");

        Assert.assertTrue(paginaLogin.esLoginFallido());
    }
}
