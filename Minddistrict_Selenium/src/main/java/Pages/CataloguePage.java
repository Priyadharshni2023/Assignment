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
import java.util.List;

public class CataloguePage extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public CataloguePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='catalogue-card__link']")
    List<WebElement> ListOfModules;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement StartButton;

    @FindBy(xpath = "//input[@type='text']")
    WebElement SearchBox;
    @FindBy(xpath = "//a[text()='Home ']")
    WebElement HomeTab;

    @FindBy(xpath = "//button[contains(text(),'fa fa-search')]")
    WebElement SearchButton;
    @FindBy(xpath = "//h2[contains(text(),'Loading...')]")
    WebElement Loader;

    public void selectRequiredModule(String str) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> listItems = ListOfModules;
        for (WebElement listItem : listItems) {
            System.out.println(listItem +" and "+ str);
            if (listItem.getText().equals(str)) {
                listItem.click();
                break;
            }}
            wait.until(ExpectedConditions.visibilityOf(StartButton));
            Assert.assertTrue(StartButton.isDisplayed());
    }

    public void clickOnStartButton(){
        StartButton.click();
    }

    public void searchModuleWithSearchBox(String SearchText) throws InterruptedException {
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Catalogue"));
        wait.until(ExpectedConditions.visibilityOf(SearchBox));
        SearchBox.sendKeys(SearchText);
    }

    public void clickOnHomeTab()
    {
        HomeTab.click();
    }

}
