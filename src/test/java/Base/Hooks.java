package Base;

import PropertyUtility.PropertyFile;
import org.junit.After;
import org.junit.Before;

import java.util.HashMap;

public class Hooks extends ShareData{

    public HashMap<String, String> inputData;

    @Before
    public void prepareEnvironment(){
        setUp();
        //obtin numele testului care ruleaza
        String testName = this.getClass().getSimpleName();
        //incarc fisieru corespunzator testului care ruleaza
        PropertyFile testData = new PropertyFile("TestData/"+testName+"Resource");
        //pun toate valorile din fisier intr-un hashmap
        inputData = testData.getAllValues();
    }

    @After
    public void cleanEnvironment(){
        quitBrowser();
    }
}