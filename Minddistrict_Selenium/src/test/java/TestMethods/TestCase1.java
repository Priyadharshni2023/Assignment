package TestMethods;
import Base.TestBase;
import Pages.CataloguePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ModulePage;
import Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static Base.TestBase.driver;

public class TestCase1 extends TestBase {

    public TestCase1() {
        super();
    }

    HomePage HomePagObj = new HomePage();;
    CataloguePage CatPageObj;
    LoginPage LoginPageObj;
    ModulePage moduleObj;
    String SheetName = "TextField";
    String TrainingModule = "Module for test automation";
    String DiaryModule = "Moment";
    String SearchText = "po";
    String SearchModule = "Positive diary";

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        initialization();
        LoginPageObj = new LoginPage();
        LoginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(enabled = false)
    public void VerifyIfTrainingModuleIsAddedToHomePage() throws InterruptedException {
        HomePagObj.clickOnCatalogueTab();
        CatPageObj = new CataloguePage();
        CatPageObj.selectRequiredModule(TrainingModule);
        CatPageObj.clickOnStartButton();
        CatPageObj.clickOnHomeTab();
        HomePagObj = new HomePage();
        HomePagObj.verifyModuleAddedSuccessfully(TrainingModule);
    }

    @Test
    public void VerifyIfDiaryModuleIsAddedToHomePage() throws InterruptedException {
        HomePagObj.clickOnCatalogueTab();
        CatPageObj = new CataloguePage();
        CatPageObj.selectRequiredModule(DiaryModule);
        CatPageObj.clickOnStartButton();
        CatPageObj.clickOnHomeTab();
        HomePagObj = new HomePage();
        HomePagObj.verifyModuleAddedSuccessfully(DiaryModule);
    }

    @Test
    public void VerifyIfModuleIsAddedUsingSearchBox() throws InterruptedException {
        HomePagObj.clickOnCatalogueTab();
        CatPageObj = new CataloguePage();
        CatPageObj.searchModuleWithSearchBox(SearchText);
        CatPageObj.selectRequiredModule(SearchModule);
        CatPageObj.clickOnStartButton();
        CatPageObj.clickOnHomeTab();
        HomePagObj = new HomePage();
        HomePagObj.verifyModuleAddedSuccessfully(SearchModule);
    }

    @DataProvider
    public Object[][] getMDTestData(){
        Object data1[][] = TestUtil.getTestData(SheetName);
        return data1;
    }

   @Test(dataProvider = "getMDTestData")
    public void VerifyModuleForAutomation(String InputText, String Type, String TileData) throws InterruptedException {
        HomePagObj.clickOnCatalogueTab();
        CatPageObj = new CataloguePage();
        CatPageObj.selectRequiredModule(TrainingModule);
        CatPageObj.clickOnStartButton();
        ModulePage moduleObj = new ModulePage();
        moduleObj.verifyUIElements();
        moduleObj.enterDataToTextField(InputText);
        moduleObj.clickOnCheckboxes(9);
        moduleObj.clickOnRadioBtn(Type);
        moduleObj.clickOnContinue1();
        moduleObj.clickOnContinue2();
        moduleObj.clickOnAnyTile(TileData);
        moduleObj.clickOnContinue3();
        moduleObj.clickOnContinue4();
        moduleObj.clickOnContinue5();
        moduleObj.clickOnContinue6();
        moduleObj.VerifySuccessMessage();
       CatPageObj.clickOnHomeTab();
       HomePagObj = new HomePage();
       HomePagObj.verifyModuleAddedSuccessfully(TrainingModule);
    }

    @AfterMethod
    public void AfterTest()
    {
        HomePagObj.manageHomePage();
        driver.quit();
    }
}
