package Tests;

import Base.Hooks;
import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowsPage;
import org.junit.Test;

public class WindowTest extends Hooks {

    public IndexPage indexPage;
    public RegisterPage registerPage;
    public WindowsPage windowsPage;

    @Test
    public void testAutomat() {
        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());
        windowsPage = new WindowsPage(getDriver());

        indexPage.clickSkipSignIn();
        registerPage.goToWindowsPage();
        windowsPage.tabbedProcess();
        windowsPage.separateProcess();
        windowsPage.multipleProcesses();
    }
}
