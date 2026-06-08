package PetShopQACenter;

import org.junit.Assert;
import org.junit.Test;

import PetShopQACenter.paginas.PaginaHome;
import PetShopQACenter.paginas.PaginaLogin;

public class PruebaHome extends BaseTest {

    // Escenario 3: Validar promoción
    @Test
    public void validarPromocion(){
        PaginaLogin login = new PaginaLogin(driver);
        PaginaHome home = new PaginaHome(driver);

        login.realizarLogin("admin", "123456");
        home.hacerClickPromocion();

        Assert.assertTrue(home.esPromocionVisible());
    }

    // Escenario 4: Validar tabla de servicios
    @Test
    public void validarCantidadServicios(){
        PaginaLogin login = new PaginaLogin(driver);
        PaginaHome home = new PaginaHome(driver);

        login.realizarLogin("admin", "123456");

        Assert.assertEquals(4, home.obtenerCantidadServicios());
    }

    // Escenario 5: Logout
    @Test
    public void validarLogout(){
        PaginaLogin login = new PaginaLogin(driver);
        PaginaHome home = new PaginaHome(driver);

        login.realizarLogin("admin", "123456");
        home.cerrarSesion();

        // Validación indirecta: vuelve a login
        PaginaLogin loginNuevo = new PaginaLogin(driver);
        Assert.assertTrue(loginNuevo.campoUsuario.isDisplayed());
    }
}

