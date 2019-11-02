import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    private WebDriver driver;

    private WebDriverWait waitFor;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        waitFor = new WebDriverWait(driver, 10);
    }

    @FindBy(css = ".supernova-navi_dashboard > div:nth-child(5)")
    private WebElement loginBtn;

    @FindBy(css = ".HH-AuthForm-Login")
    private WebElement loginBox;

    @FindBy(css = ".HH-AuthForm-Password")
    private WebElement pwdBox;

    @FindBy(css = "input.bloko-button")
    private WebElement authBtn;

    @FindBy(css = ".supernova-icon_profile")
    private WebElement authIcon;

    @FindBy(css = "input.supernova-dropdown-option")
    private WebElement logoutBtn;

    void init() {

        driver.get("https://hh.ru");

        PageFactory.initElements(driver, this);

    }

    void login(String login, String pwd) {

        loginBtn.click();

        waitFor.until(ExpectedConditions.visibilityOf(loginBox));

        loginBox.sendKeys(login);

        pwdBox.sendKeys(pwd);

        authBtn.click();

        waitFor.until(ExpectedConditions.visibilityOf(authIcon));

    }

    void logout() {

        authIcon.click();

        waitFor.until(ExpectedConditions.visibilityOf(logoutBtn));

        logoutBtn.click();

    }

    boolean isAuthPassed() {

        return loginBtn.isDisplayed();

    }

}
