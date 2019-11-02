import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    private WebDriver driver;



    public PageObject(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(css = ".supernova-navi_dashboard > div:nth-child(5)")
    private WebElement loginBtn;

    @FindBy(css = ".HH-AuthForm-Login")
    private WebElement loginBox;

    @FindBy(css = ".HH-AuthForm-Password")
    private WebElement pwdBox;

    @FindBy(css = "input.bloko-button")
    private WebElement getLoginBtn;

    @FindBy(css = ".supernova-icon_profile")
    private WebElement AuthIcon;
    
    @FindBy(css = "input.supernova-dropdown-option")
    private WebElement LogoutBtn;
    


    public void init(){

        driver.get("https://hh.ru");

        PageFactory.initElements(driver,this);


    }


    public void login(String login, String pwd){

        loginBtn.click();

        WebDriverWait waitForLoginBox = new WebDriverWait(driver, 10);

        waitForLoginBox.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".HH-AuthForm-Login")));

        loginBox.sendKeys(login);

        pwdBox.sendKeys(pwd);

        getLoginBtn.click();

        WebDriverWait waitForAuth = new WebDriverWait(driver, 10);

        waitForAuth.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".supernova-icon_profile")));




    }


    public void logout(){

        AuthIcon.click();

        WebDriverWait waitForProfileDropDown = new WebDriverWait(driver, 10);

       waitForProfileDropDown.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.supernova-dropdown-option")));

        LogoutBtn.click();

    }

    boolean isAuthPassed(){

       return loginBtn.isDisplayed();


    }







}
