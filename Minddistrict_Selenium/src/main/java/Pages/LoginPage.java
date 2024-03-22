package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {


    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login']")
    WebElement userNameInput;

    @FindBy(xpath = "//button[@type='button']")
    WebElement AcceptBtn;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void login(String un, String pwd)
    {
        AcceptBtn.click();
        userNameInput.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
    }
}
