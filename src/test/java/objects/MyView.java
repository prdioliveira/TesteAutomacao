package objects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Paulo on 14/07/2016.
 * Essa calsse funciona como um controler.
 * Todas as demais páginas da aplicação são chamadas à partir dela.
 * Ela é como se fosse minha página incial.
 */
public class MyView extends BaseObject {
    public MyView(WebDriver driver){
        super(driver);
    }

    public String getTilte() {
        return getDriver().getTitle();
    }

    public ReportIssue criarIssue(){
        getDriver().findElement(By.xpath("//a[text()='Report Issue']")).click();
        return new ReportIssue(getDriver());
    }

    public ViewIssue viewIssues(){
        getDriver().findElement(By.xpath("//a[text()='View Issues']")).click();
        return new ViewIssue(getDriver());
    }
}
