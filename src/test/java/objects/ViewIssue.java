package objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**
 * Created by Paulo on 14/07/2016.
 */
public class ViewIssue extends BaseObject {
    public ViewIssue(WebDriver driver){
        super(driver);
    }

    public void deleteAllIssues()throws Exception{
        try{
            getDriver().findElement(By.xpath("//input[@value='all']")).click();
            Select action = new Select(getDriver().findElement(By.name("action")));
            action.selectByVisibleText("Delete");
            getDriver().findElement(By.xpath("//input[@value='OK']")).click();

            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete Issues']")));
            validarDeleteAllIssues();
            getDriver().findElement(By.xpath("//input[@value='Delete Issues']")).click();
        } catch (Exception e){
            getScreenShot("no_issues_delete.png");
            throw new Exception("Erro: Não há issues para deletar");
        }
    }

    public void validarDeleteAllIssues(){
        String texto = getDriver().findElement(By.xpath("//div[2]/form/table/tbody/tr/td[@class='category']")).getText();
        Assert.assertEquals("Are you sure you wish to delete these issues?", texto);
    }

    public void updateIssue() throws Exception{
       try{
           getDriver().findElement(By.xpath("//tr[4]/td[1]/input[@type='checkbox']")).click();
           Select action = new Select(getDriver().findElement(By.name("action")));
           action.selectByVisibleText("Resolve");
           getDriver().findElement(By.xpath("//input[@value='OK']")).click();

           WebDriverWait wait = new WebDriverWait(getDriver(), 10);
           wait.until(ExpectedConditions.elementToBeClickable(By.name("resolution")));

           Select resolution = new Select(getDriver().findElement(By.name("resolution")));
           resolution.selectByVisibleText("unable to reproduce");
           getDriver().findElement(By.name("bugnote_text")).sendKeys("Resolvido");
           getDriver().findElement(By.xpath("//input[@value='Resolve Issues']")).click();
       } catch (Exception e){
           getScreenShot("update_solve_issue.png");
           throw new Exception("Erro: Não foi possivel atualizar issue");
       }
    }

    public void deleteOneIssue() throws Exception{
        try{
            getDriver().findElement(By.xpath("//tr[4]/td[1]/input[@type='checkbox']")).click();
            Select action = new Select(getDriver().findElement(By.name("action")));
            action.selectByVisibleText("Delete");
            getDriver().findElement(By.xpath("//input[@value='OK']")).click();

            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete Issues']")));
            validarDeleteAllIssues();
            getDriver().findElement(By.xpath("//input[@value='Delete Issues']")).click();
        } catch (Exception e){
            getScreenShot("delete_one_issue.png");
            throw new Exception("Erro: Não há issue para deletar");
        }
    }

    public void filter() throws Throwable{
        try{
            getDriver().findElement(By.id("handler_id_filter")).click();
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='Assigned To:']")));
            Select assign = new Select(getDriver().findElement(By.name("handler_id[]")));
            assign.selectByVisibleText("paulo.oliveira");
            getDriver().findElement(By.name("filter")).click();
            validarAssigned();
        } catch (Exception e){
            getScreenShot("filtrar_assigned.png");
            throw new Exception("Erro: Não foi possível aplicar o filtro ou Filtro Vazio");
        }
    }

    public void validarAssigned(){
        Assert.assertEquals(getDriver().findElement(By.xpath("//table/tbody/tr[4]/td[9]/a")).getText(),
                "paulo.oliveira");
    }
}
