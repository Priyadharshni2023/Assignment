package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class HomePage extends TestBase {
    WebDriverWait wait;
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='Home ']")
    WebElement HomeTab;

    @FindBy(xpath = "//a[text()='Catalogue ']")
    WebElement CatalogueTab;

    @FindBy(xpath = "//button[@aria-label='Your profile and settings']")
    WebElement ProfileDropdown;

    @FindBy(xpath = "//button[@class='header__profilemenu-button']")
    WebElement LogoutButton;

    @FindBy(xpath = "//h2[contains(text(), '%s')]")
    WebElement TrainingModuleInHomepage;

    @FindBy(xpath = "//b[text()='You have completed all the steps!']")
    WebElement SuccessMessage;

    @FindBy(xpath = "//a[@class='full-width-xs btn btn-outline-primary']")
    WebElement ManageHome;

    @FindBy(xpath = "//button[@role='button']")
    WebElement ArchiveBtn;

    public HomePage clickOnHomeTab()
    {
        HomeTab.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Home"));
        return new HomePage();
    }
    public void clickOnCatalogueTab()
    {
        driver.findElement(By.xpath("//a[text()='Catalogue ']")).click();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Catalogue"));
    }
    public void verifyModuleAddedSuccessfully(String Module) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini"));
        String TrainingModuleInHome = String.format("//h2[contains(text(), '%s')]", Module);
       Assert.assertTrue( driver.findElement(By.xpath(TrainingModuleInHome)).isDisplayed());
    }

    public void verifyAllStepsCompleted()
    {
        Assert.assertTrue(SuccessMessage.isDisplayed());
    }
    public void logOut(){
          ProfileDropdown.click();
            LogoutButton.click();
    }

    public void manageHomePage ()
    {
        ManageHome.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Manage your homepage"));
        ArchiveBtn.click();
    }

}
