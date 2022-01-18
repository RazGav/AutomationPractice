package Help;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert(){
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //wait explicit
        waitAlertPresence();
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

    public void waitAlertPresence(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    }

    public void cancelAlert(){
        waitAlertPresence();
        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();
    }

    public void acceptFillAlert(String value){
        waitAlertPresence();
        Alert alertOk = driver.switchTo().alert();
        alertOk.sendKeys(value);
        alertOk.accept();
    }

    public void cancelFillAlert(String value){
        waitAlertPresence();
        Alert alertOk = driver.switchTo().alert();
        alertOk.sendKeys(value);
        alertOk.dismiss();
    }
}