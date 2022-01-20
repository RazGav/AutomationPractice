package Tests;

import Base.Hooks;
import Base.ShareData;
import Help.ElementMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends Hooks {

    public IndexPage indexPage;
    public RegisterPage registerPage;

    @Test
    public void testAutomat() {

        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());

        indexPage.clickSkipSignIn();
        registerPage.validRegisterProcess(inputData);


        //Refresh button
        //WebElement refreshButtonElement = driver.findElement(By.id("Button1"));
        //refreshButtonElement.click();


        // "// = de unde incepi, [@ = dupa ce cauti], / = intri mai adanca in lista cautata pt xpath
        // ex. //textarea[@ng-model='Adress']






    }

}
