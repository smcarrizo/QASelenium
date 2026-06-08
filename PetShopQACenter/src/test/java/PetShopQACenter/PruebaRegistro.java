package PetShopQACenter;

import org.junit.Assert;
import org.junit.Test;

import PetShopQACenter.paginas.PaginaLogin;
import PetShopQACenter.paginas.PaginaRegistro;

public class PruebaRegistro extends BaseTest {

    // Escenario 6: Registro exitoso
    @Test
    public void registrarMascotaCorrectamente(){
        PaginaLogin login = new PaginaLogin(driver);
        PaginaRegistro registro = new PaginaRegistro(driver);

        login.realizarLogin("admin", "123456");
        registro.irARegistro();

        registro.completarFormulario("Thor", "Carlos Perez", "Cachorro");
        registro.guardar();

        Assert.assertTrue(registro.esRegistroExitoso());
    }
}

