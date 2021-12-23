package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest {

    public WebDriver driver;

    @Test
    public void testAutomat() {
        //Specificam unde se afla driverul pentru browser
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\Automation\\chromedriver.exe");
        //Deschidem un browser
        driver = new ChromeDriver();
        //Introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");
        //Schimbar rezolutia in maximize
        driver.manage().window().maximize();

        //Identificam "Skip sign in" element
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //Validam pagina de "Register"
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register", actualRegister);

        //Identificam elementul Spatiul pentru Nume
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder=\"First Name\"]"));
        String firstName = "Ala";
        firstNameElement.sendKeys(firstName);

        //Identificam elementul Spatiul pentru Prenume
        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder=\"Last Name\"]"));
        String lastName = "Bala";
        lastNameElement.sendKeys(lastName);

        //Identificam elemntul Adresa
        WebElement adressElement = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String adresa = "Str. Ajun, nr. 1, bloc D12, Ap.24";
        adressElement.sendKeys(adresa);

        //Identificam elementul Email
        WebElement emailElement = driver.findElement(By.cssSelector("input[ng-model=\"EmailAdress\"]"));
        String email = "portocala@gmail.ru";
        emailElement.sendKeys(email);

        //Identificam elementul "Phone"
        WebElement phoneElement = driver.findElement(By.cssSelector("input[type=\"tel\"]"));
        String phoneNumber = "0763298431";
        phoneElement.sendKeys(phoneNumber);

        //Identificam elementul radiobutton Male
        WebElement radiobuttonMaleElement = driver.findElement(By.cssSelector("input[value=\"Male\"]"));
        radiobuttonMaleElement.click();

        //Identificam elementul radiobutton Female
        WebElement radiobuttonFemaleElement = driver.findElement(By.cssSelector("input[value=\"FeMale\"]"));
        radiobuttonFemaleElement.click();

        //Identificam "Cricket" element
        WebElement checkboxCricketElement = driver.findElement(By.id("checkbox1"));
        checkboxCricketElement.click();

        //Identificam "Movies" element
        WebElement checkboxMoviesElement = driver.findElement(By.id("checkbox2"));
        checkboxMoviesElement.click();

        //Identificam "Hockey" element
        WebElement checkboxHockeyElement = driver.findElement(By.id("checkbox3"));
        checkboxHockeyElement.click();

        //Identificam Skills dropbox element
        WebElement skillsDropboxElement = driver.findElement(By.id("Skills"));
        Select skillsSelect = new Select(skillsDropboxElement);
        skillsSelect.selectByVisibleText("Android");

        //Identificam Select Country dropbox element
        WebElement selectCountryDropboxElement = driver.findElement(By.id("country"));
        Select selectCountry = new Select(selectCountryDropboxElement);
        selectCountry.selectByVisibleText("Denmark");

        //Identificam Year dropbox element
        WebElement yearDropboxElement = driver.findElement(By.id("yearbox"));
        Select yearSelect = new Select(yearDropboxElement);
        yearSelect.selectByValue("1998");

        //Identificam Month dropbox element
        WebElement monthDropboxElement = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        Select monthSelect = new Select(monthDropboxElement);
        monthSelect.selectByVisibleText("March");

        //Identificam Day dropbox element
        WebElement dayDropboxElement = driver.findElement(By.id("daybox"));
        Select daySelect = new Select(dayDropboxElement);
        daySelect.selectByValue("14");

        //Identificam Password element
        WebElement passwordElement = driver.findElement(By.id("firstpassword"));
        String password = "Parola1";
        passwordElement.sendKeys(password);

        //Identificam Password element
        WebElement secondPasswordElement = driver.findElement(By.id("secondpassword"));
        String password2 = "Parola1";
        secondPasswordElement.sendKeys(password2);

        //Identificam fake dropbox Language element
        WebElement fakeLanguageDropboxElement = driver.findElement(By.id("msdd"));
        fakeLanguageDropboxElement.click();
        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for(int i = 0; i < languageElements.size(); i++){
            if(languageElements.get(i).getText().equals("Bulgarian")){
                languageElements.get(i).click();
            }
        }

        //Click pe imagine pentru a inchide lista de mai sus
        //WebElement imageElement = driver.findElement(By.id("imagetrgt"));
        //imageElement.click();

        //Upload photo
        WebElement photoElement = driver.findElement(By.id("imagesrc"));
        photoElement.sendKeys("C:\\Users\\razvu\\OneDrive\\Desktop\\Untitled.png");

        //Submit button
        WebElement submitButtonElement = driver.findElement(By.id("submitbtn"));
        submitButtonElement.click();

        //Refresh button
        //WebElement refreshButtonElement = driver.findElement(By.id("Button1"));
        //refreshButtonElement.click();


        // "// = de unde incepi, [@ = dupa ce cauti], / = intri mai adanca in lista cautata pt xpath
        // ex. //textarea[@ng-model='Adress']




    }

}
