package setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.lang.reflect.Method;

public class Setup {
    protected WebDriver driver;
    protected HomePage homePage;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter htmlReporter;
    protected ExtentTest test;
//        protected static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    @BeforeSuite
    public void setUpExtentReport() {
        extent = new ExtentReports();
        htmlReporter = new ExtentSparkReporter("src/test/java/utils/reports/UI_test_report.html");
        extent.attachReporter(htmlReporter);
    }

    @BeforeClass
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "resources/webdriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
//        chromeOptions.addExtensions(new File("resources/extensions/AdBlock — best ad blocker 5.18.0.0.crx"));
        driver = new ChromeDriver(chromeOptions);
        goHome();
//        closeLastOpenedTab();
    }

    public void goHome() {
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void startTest(Method method){
        test = extent.createTest(method.getName());
    }
//
//    public void closeLastOpenedTab() {
//        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
//        String lastWindowHandle = allWindowHandles.get(allWindowHandles.size() - 1);
//        driver.switchTo().window(lastWindowHandle);
//        driver.close();
//        String originalWindowHandle = allWindowHandles.get(0);
//        driver.switchTo().window(originalWindowHandle);
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }

//    public ExtentTest extentTest() {
//        return extentTestThreadLocal.get();
//    }
}