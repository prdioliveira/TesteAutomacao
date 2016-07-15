package principal;

import objects.BaseObject;
import objects.Login;
import objects.MyView;
import objects.ViewIssue;
import org.junit.Test;

/**
 * Created by Paulo on 14/07/2016.
 */
public class DeleteUpdateIssueTeste {
    private BaseObject baseObject = new BaseObject();
    private Login login = new Login(baseObject.getDriver());
    private MyView myView;
    private ViewIssue viewIssue;

    @Test
    public void updateIssue() throws Throwable{
        navegar();
        logarUsuario();
        atualizarIssue();
        filtrar();
        closeBrowser();
    }

    @Test
    public void deletarIssues() throws Throwable{
        navegar();
        logarUsuario();
        deletarIssue();
        deletarTodasIssues();
        closeBrowser();
    }

    public void navegar(){
        baseObject.navegar("http://mantis-prova.base2.com.br");
    }

    public void logarUsuario(){
        this.myView = login.logar("paulo.oliveira", "as12fg23");
    }

    public void deletarTodasIssues() throws Exception{
        this.viewIssue = myView.viewIssues();
        this.viewIssue.deleteAllIssues();
    }

    public void deletarIssue() throws Throwable{
        this.viewIssue = myView.viewIssues();
        this.viewIssue.deleteOneIssue();
    }

    public void atualizarIssue() throws Throwable{
        this.viewIssue = myView.viewIssues();
        this.viewIssue.updateIssue();
    }

    public void filtrar() throws Throwable{
        this.viewIssue = myView.viewIssues();
        this.viewIssue.filter();
    }

    public void closeBrowser(){
        baseObject.fecharNavegador();
    }
}
