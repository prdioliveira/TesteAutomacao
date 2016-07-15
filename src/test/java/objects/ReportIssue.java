package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Paulo on 14/07/2016.
 */
public class ReportIssue extends BaseObject {
    public ReportIssue(WebDriver driver){
        super(driver);
    }

    public String getTilte() {
        return getDriver().getTitle();
    }

    public void reportDetail(String categoria, String reproducao, String severidade, String prioridade, String perfil,
                             String atribuido, String sumario, String descricao, String passo, String addInfo) throws Throwable{
        try{
            /* Primeira Sessão - Cabeçalho */
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.name("category_id")));
            Select category = new Select(getDriver().findElement(By.name("category_id")));
            category.selectByVisibleText(categoria);

            Select reproducibility = new Select(getDriver().findElement(By.name("reproducibility")));
            reproducibility.selectByVisibleText(reproducao);

            Select severity = new Select(getDriver().findElement(By.name("severity")));
            severity.selectByVisibleText(severidade);

            Select priority = new Select(getDriver().findElement(By.name("priority")));
            priority.selectByVisibleText(prioridade);

            Select profile = new Select(getDriver().findElement(By.name("profile_id")));
            profile.selectByVisibleText(perfil);

        /* Corpo */
            Select assignTo = new Select(getDriver().findElement(By.name("handler_id")));
            assignTo.selectByVisibleText(atribuido);
            WebElement summary = getDriver().findElement(By.name("summary"));
            summary.sendKeys(sumario);
            WebElement description = getDriver().findElement(By.name("description"));
            description.sendKeys(descricao);
            WebElement stepsToReproduce = getDriver().findElement(By.name("steps_to_reproduce"));
            stepsToReproduce.sendKeys(passo);
            WebElement additionalInfo = getDriver().findElement(By.name("additional_info"));
            additionalInfo.sendKeys(addInfo);
            WebElement buttonSubmit = getDriver().findElement(By.xpath("//input[@value='Submit Report']"));
            buttonSubmit.click();
            wait.until(ExpectedConditions.titleIs("View Issues - MantisBT"));
        } catch (Exception e){
            getScreenShot("erro_criar_issue.png");
            throw new Exception("Erro: Não foi possivel criar issue");
        }

    }
}
