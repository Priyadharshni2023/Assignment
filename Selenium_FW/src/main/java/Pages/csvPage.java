package Pages;
import Base.TestBase;
import Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class csvPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public csvPage() {
        PageFactory.initElements(driver, this);
    }


 public void uploadCSV(String filePath) {
        WebElement uploadElement = driver.findElement(By.id("uploadFileInput"));
        uploadElement.sendKeys(filePath);
        driver.findElement(By.id("submitButton")).click();
    }
    
    // General function to verify error message
    public void verifyErrorMessage(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertEquals(errorMessage.getText(), expectedMessage);
    }

    // General function to verify successful import
    public void verifySuccessMessage() {
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

}
