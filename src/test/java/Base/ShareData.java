package Base;

import PropertyUtility.PropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShareData {
    //WebDriver = variabila care ne ajuta sa interactionam cu site-ul si elementele de pe site
    public WebDriver driver;

    public void setUp(){
        PropertyFile driverResource = new PropertyFile("DriverResource");

        //Specificam unde se afla driverul pentru browser
        System.setProperty(driverResource.getValue("driverBrowser"), driverResource.getValue("pathDriver"));
        //Deschidem un browser
        driver = new ChromeDriver();
        //Introducem o adresa
        driver.get(driverResource.getValue("url"));
        //Schimbar rezolutia in maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitBrowser(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
