package tests.e2e.pageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String USER_DIR = "user.dir";
    public static final String CHROME_DRIVER_PATH = "\\src\\test\\resources\\chromedriver.exe";
    public static final String GECKO_DRIVER_PATH = "\\src\\test\\resources\\geckodriver.exe";
    public static final String OUTPUT_FOLDER = "\\src\\test\\output\\";
    protected static WebDriver driver;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty(USER_DIR) + CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", System.getProperty(USER_DIR) + GECKO_DRIVER_PATH);
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(System.getProperty(USER_DIR) + OUTPUT_FOLDER + testResult.getName() + ".png"));
        }
    }
}
