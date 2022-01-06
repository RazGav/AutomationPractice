package Help;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert(){
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

    public void cancelAlert(){
        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();
    }

    public void acceptFillAlert(String value){
        Alert alertOk = driver.switchTo().alert();
        alertOk.sendKeys(value);
        alertOk.accept();
    }

    public void dismissFillAlert(String value){
        Alert alertOk = driver.switchTo().alert();
        alertOk.sendKeys(value);
        alertOk.dismiss();
    }
}