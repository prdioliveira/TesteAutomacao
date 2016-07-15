package principal;

import objects.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Paulo on 14/07/2016.
 */
@RunWith(Parameterized.class)
public class CriarIssueTeste {
    private String categoria;
    private String reproducao;
    private String severidade;
    private String prioridade;
    private String perfil;
    private String atribuido;
    private String sumario;
    private String descricao;
    private String passo;
    private String addInfo;

    private BaseObject baseObject = new BaseObject();
    private Login login = new Login(baseObject.getDriver());
    private MyView myView;
    private ReportIssue report;
    private ViewIssue viewIssue;

    public CriarIssueTeste(String categoria, String reproducao, String severidade, String prioridade, String perfil,
                           String atribuido, String sumario, String descricao, String passo, String addInfo){
        this.categoria = categoria;
        this.reproducao = reproducao;
        this.severidade = severidade;
        this.prioridade = prioridade;
        this.perfil = perfil;
        this.atribuido = atribuido;
        this.sumario = sumario;
        this.descricao = descricao;
        this.passo = passo;
        this.addInfo = addInfo;
    }

    @Test
    public void criarIssue() throws Throwable{
        navegar();
        logarUsuario();
        reportIssue();
        closeBrowser();
    }

    public void navegar(){
        this.baseObject.navegar("http://mantis-prova.base2.com.br");
    }

    public void logarUsuario(){
        this.myView = login.logar("paulo.oliveira", "as12fg23");
    }

    public void reportIssue() throws Throwable{
        this.report = myView.criarIssue();
        this.report.reportDetail(categoria, reproducao, severidade, prioridade, perfil, atribuido, sumario,
                descricao, passo, addInfo);
    }

    public void closeBrowser(){
        this.baseObject.fecharNavegador();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataDriven(){
        return Arrays.asList(new Object[][]{
                {"[All Projects] app_14", "always", "feature", "none", "PC Windows 7", "administrator", "Teste 01",
                        "Desscrição do Teste 01", "Passo para reprodução do Teste 01",
                        "Informações adicionais do Teste 01"},

                {"[All Projects] General", "sometimes", "trivial", "low", "PC Windows 8", "administrator", "Teste 02",
                        "Desscrição do Teste 02", "Passo para reprodução do Teste 02",
                        "Informações adicionais do Teste 02"},

                {"[All Projects] principado", "random", "text", "normal", "PC Windows XP", "administrator", "Teste 03",
                        "Desscrição do Teste 03", "Passo para reprodução do Teste 03",
                        "Informações adicionais do Teste 03"},

                {"[All Projects] Teste", "have not tried", "tweak", "high", "platformTest osTest osBuildTest",
                        "paulo.oliveira", "Teste 04", "Desscrição do Teste 04", "Passo para reprodução do Teste 04",
                        "Informações adicionais do Teste 04"},

                {"[All Projects] General", "unable to reproduce", "minor", "urgent", "platformTest osTest osBuildTest",
                        "paulo.oliveira", "Teste 05", "Desscrição do Teste 05", "Passo para reprodução do Teste 05",
                        "Informações adicionais do Teste 05"},

                {"[All Projects] principado", "N/A", "major", "immediate", "PC Windows 7", "paulo.oliveira",
                        "Teste 06", "Desscrição do Teste 06", "Passo para reprodução do Teste 06",
                        "Informações adicionais do Teste 06"},

                {"[All Projects] Teste", "have not tried", "crash", "high", "PC Windows 7", "paulo.oliveira",
                        "Teste 07", "Desscrição do Teste 07", "Passo para reprodução do Teste 07",
                        "Informações adicionais do Teste 07"},

                {"[All Projects] Teste", "have not tried", "block", "urgent", "platformTest osTest osBuildTest",
                        "administrator", "Teste 08", "Desscrição do Teste 08", "Passo para reprodução do Teste 08",
                        "Informações adicionais do Teste 08"}
        });
    }

}
