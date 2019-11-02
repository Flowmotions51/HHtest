import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseTest {


    private WebDriver driver;

    PageObject PJ;


    @DataProvider
    public static Object[][] HHruCredentials() {
        return new Object[][]{
                {"qwerrw.erwrw@bk.ru", "pspgo415120"}
        };
    }

    @BeforeSuite
    public void initFirefoxDriver() {

        System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/geckodriver");

        driver = new FirefoxDriver();

    }

    @Test(dataProvider = "HHruCredentials")
    public void loginToHHru(String login, String pwd) {

        PJ = new PageObject(driver);

        PJ.init();

        PJ.login(login, pwd);

        PJ.logout();

        Assert.assertTrue(PJ.isAuthPassed());

    }

    @AfterSuite
    public void tearDown() {

        driver.quit();

    }
}
