package objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Paulo on 13/07/2016.
 */
public class BaseObject {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BaseObject(WebDriver driver){
        this.driver = driver;
    }

    public BaseObject(){
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void navegar(String url){
        driver.navigate().to(url);
    }

    public void fecharNavegador(){
        getDriver().close();
    }

    public void getScreenShot(String imageName) throws Exception{
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image, new File("screenshots/" + imageName));
    }

}
