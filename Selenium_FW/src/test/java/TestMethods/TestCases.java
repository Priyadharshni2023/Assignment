package TestMethods;
import Base.TestBase;
import Pages.LoginPage;
import Pages.csvPage;
import Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static Base.TestBase.driver;

public class TestCases extends TestBase {

    public TestCases() {
        super();
    }

 
    LoginPage LoginPageObj;
    csvPage csvObj= new csvPage;
   

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        initialization();
        LoginPageObj = new LoginPage();
        LoginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    // TC1: Valid CSV File Upload
@Test
public void testValidCsvFileUpload() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 1.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage();
}

// TC2: Invalid Data Format in CSV
@Test
public void testInvalidDataFormat() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 2.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Invalid data format found.");
}

// TC3: Missing Required Field in CSV
@Test
public void testMissingRequiredField() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 3.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Missing required field.");
}

// TC4: Duplicate Records in CSV
@Test
public void testDuplicateRecords() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 4.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Duplicate records found.");
}

// TC5: CSV File with Special Characters
@Test
public void testSpecialCharactersCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 5.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifySuccessMessage();
}

// TC6: Empty CSV File Upload
@Test
public void testEmptyCsvFileUpload() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 6.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("CSV file is empty.");
}

// TC7: CSV with Invalid Characters
@Test
public void testInvalidCharactersCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 7.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Invalid characters found.");
}

// TC8: CSV with Missing Rows
@Test
public void testMissingRowsCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 8.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Missing rows in CSV.");
}

// TC9: CSV with Date Format Issues
@Test
public void testDateFormatIssuesCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 9.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Date format issue found.");
}

// TC10: CSV with Invalid Email Format
@Test
public void testInvalidEmailFormatCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 10.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Invalid email format.");
}

// TC11: Incorrect File Extension
@Test
public void testIncorrectFileExtension() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 11.txt";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Invalid file format. Only CSV files are allowed.");
}


// TC13: Verigy Harmful files
@Test
public void testInvalidFileSize() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 13.exe";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("File exceeds maximum allowed size.");
}

// TC14: Large file size
@Test
public void testInvalidHeaderCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 14.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("File size exceeds");
}

// TC15: Incomplete Rows
@Test
public void testIncompleteRowsCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 1.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Incomplete rows found.");
}

// TC16: Incorrect Delimiters
@Test
public void testIncorrectDelimitersCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 16.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Incorrect delimiter used.");
}

// TC17: Extra Columns
@Test
public void testExtraColumnsCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 17.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifySuccessMessage(); 
}

// TC18: Extra Rows
@Test
public void testExtraRowsCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 18.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifySuccessMessage();
}

// TC19: Large Number of Columns
@Test
public void testLargeNumberOfColumnsCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 19.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifySuccessMessage();
}

// TC20: Embedded New Lines
@Test
public void testEmbeddedNewLinesCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 20.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifySuccessMessage();
}

// TC21: Mixed Data Types
@Test
public void testMixedDataTypesCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 21.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Mixed data types found.");
}

// TC22: Missing File Headers
@Test
public void testMissingFileHeadersCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 22.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifyErrorMessage("Missing file headers.");
}

// TC23: Concurrent CSV Imports
@Test
public void testConcurrentCsvImports() throws InterruptedException {
    String filePath1 = "Selenium_FW/src/main/java/TestData/TC_ 1.csv";
    String filePath2 = "Selenium_FW/src/main/java/TestData/TC_ 12.csv";
    
    Thread t1 = new Thread(() -> uploadCSV(filePath1));
    Thread t2 = new Thread(() -> uploadCSV(filePath2));
    
    t1.start();
    t2.start();
    
    t1.join();
    t2.join();
    
    csvObj.verifySuccessMessage();
}

// TC24: Unicode Characters
@Test
public void testUnicodeCharactersCsv() {
    String filePath = "Selenium_FW/src/main/java/TestData/TC_ 24.csv";
    csvObj.uploadCSV(filePath);
    csvObj.verifySuccessMessage();
}
    @AfterMethod
    public void AfterTest()
    {
        HomePagObj.manageHomePage();
        driver.quit();
    }
}
