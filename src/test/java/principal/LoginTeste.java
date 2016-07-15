package principal;

import objects.BaseObject;
import objects.Login;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Paulo on 13/07/2016.
 */
@RunWith(Parameterized.class)
public class LoginTeste {
    private String username;
    private String password;

    public LoginTeste(String username, String password){
        this.username = username;
        this.password = password;
    }

    private BaseObject baseObject = new BaseObject();
    private Login login = new Login(baseObject.getDriver());

    @Test
    public void validarLogin(){
        acessarPaginaLogin();
        validarTitulo();
        logar();
        validarPermissao();
        closeBrowser();
    }

    public void acessarPaginaLogin(){
        this.baseObject.navegar("http://mantis-prova.base2.com.br");
    }

    public void closeBrowser(){
        this.baseObject.fecharNavegador();
    }

    public void logar(){
        this.login.realizarLogin(username, password);
    }

    public void validarPermissao(){
        String msg = "Your account may be disabled or blocked or the username/password " +
                "you entered is incorrect.";
        Assert.assertEquals(baseObject.getDriver().findElement(By.xpath("//font")).getText(), msg);
    }

    public void validarTitulo(){
        Assert.assertEquals("MantisBT", this.login.getTilte());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dados (){
        return Arrays.asList(new Object[][]{
                {"admin", ""},
                {"", "admin"},
                {"admin", "admin"},
                {"", ""}
        });
    }
}
