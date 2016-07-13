package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Paulo on 13/07/2016.
 */
public class Base {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public Base(){
        this.driver = new FirefoxDriver();
    }

    public void navegar(String url){
        driver.navigate().to(url);
    }

    public void fecharNavegador(){
        getDriver().close();
    }

}
