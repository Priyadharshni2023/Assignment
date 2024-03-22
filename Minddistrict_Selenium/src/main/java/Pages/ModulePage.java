package Pages;
import Base.TestBase;
import Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ModulePage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String ModuleText="Module for test automation";

    public ModulePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='progressbar']")
    WebElement ProgressBar;
    @FindBy(xpath = "//span[text()='Open overview']")
    WebElement OpenCollapsableSidebar;
    @FindBy(xpath = "//div[@class='element__body']")
    WebElement ContentsOfSideBar;
    @FindBy(xpath = "//button[@aria-controls='pageMenu']")
    WebElement CloseCollapsableSidebar;
    @FindBy(xpath = "//ol[@class='breadcrumb']/li[2]")
    WebElement Title;
    @FindBy(xpath = "//textarea[@placeholder='Placeholder text']")
    WebElement TextInputField;
    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::span")
    List<WebElement> CheckBoxText;
    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> CheckBoxes;
    @FindBy(xpath = "//span[text()='A skinny rat.']")
    WebElement RadioButton;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-full-width']")
    WebElement ContinueButton;
    @FindBy(xpath = "//span[@class='element-section-options__title']")
    List<WebElement> TileOptions;
    @FindBy(xpath = "//h1[text()='You have completed all the steps!']")
    WebElement SuccessText;

    public void verifyUIElements(){
        ProgressBar.isDisplayed();
        OpenCollapsableSidebar.click();
     ContentsOfSideBar.isDisplayed();
    CloseCollapsableSidebar.click();
        wait.until(ExpectedConditions.visibilityOf(Title));
        Assert.assertEquals(Title.getText(),ModuleText);
    }

    public void enterDataToTextField(String Input){
        TextInputField.sendKeys(Input);
    }

    public void clickOnCheckboxes(int value){
        java.util.List<WebElement> TextList = CheckBoxText;
        List<WebElement> BtnList = CheckBoxes;
        for (int i=0;i<TextList.size()-1;i++) {
            String a = TextList.get(i).getText();
            String[] parts = a.split("-");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            if (value >= start && value <= end){
                BtnList.get(i).click();
            }
        }
        if(value>7){BtnList.get(BtnList.size()-1).click();}
    }

    public void clickOnRadioBtn(String Type){
        String TypeOfRat = String.format("//span[contains(text(), '%s')]", Type);
        System.out.println(TypeOfRat);
        driver.findElement(By.xpath(TypeOfRat)).click();
    }

    public void clickOnContinueButton() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            ContinueButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(ContinueButton));
        }
    }
    public void clickOnContinue1(){
        ContinueButton.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Second page"));
    }
    public void clickOnContinue2(){
        ContinueButton.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: What can you do if you don't like rats"));
    }
    public void clickOnContinue3(){
        ContinueButton.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Try mice"));
    }
    public void clickOnContinue4(){
        ContinueButton.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: What can you do if you don't like rats"));
    }

    public void clickOnContinue5(){
        ContinueButton.click();
        ContinueButton.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: Your answers"));
    }

    public void clickOnContinue6(){
        ContinueButton.click();
        wait.until(ExpectedConditions.titleIs("Dev qa-assignment-priyadharshini: You have completed all the steps!"));
    }

    public void clickOnAnyTile(String TileData) throws InterruptedException {
        List<WebElement> Options = TileOptions;
        System.out.println(Options.size());
        for (WebElement listItem2 : Options) {
            System.out.println(listItem2.getText());
            wait.until(ExpectedConditions.elementToBeClickable(listItem2));
            if (listItem2.getText().equals("Try mice")) {
                listItem2.click();
                break; }
        }
    }

    public void VerifySuccessMessage(){
        Assert.assertTrue(SuccessText.isDisplayed());
    }

}
