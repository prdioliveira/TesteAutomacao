package objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Paulo on 13/07/2016.
 */
public class Login extends BaseObject {

    public String getTilte() {
        return getDriver().getTitle();
    }

    public Login(WebDriver driver){
        super(driver);
    }

    public MyView logar(String username, String password){
        realizarLogin(username, password);
        return new MyView(getDriver());
    }

    public void realizarLogin(String username, String password){
        getDriver().findElement(By.name("username")).sendKeys(username);
        getDriver().findElement(By.name("password")).sendKeys(password);
        getDriver().findElement(By.xpath("//input[@value='Login']")).click();
    }
}
