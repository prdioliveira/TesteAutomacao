package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Paulo on 13/07/2016.
 */
public class Login extends Base{

    public Login(WebDriver driver){
        super(driver);
    }

    public void realizarLogin(String username, String password){
        getDriver().findElement(By.name("username")).sendKeys(username);
        getDriver().findElement(By.name("password")).sendKeys(password);
        getDriver().findElement(By.xpath("//input[@value='Login']")).click();
    }
}
