package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.UUID;
public class LoginTest {

    //i created this function to generate random emails every time.





    private WebDriver driver;
    private HomePage homePage;
    private final String baseUrl = "https://www.automationexercise.com";
    //private final String email =generateRandomEmail();


    private final String email = "ahmedkhalaf1233@yahoo.com";
    private final String password = "12345";
    private final String username = "ahmed khalaf";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void logintest() {
        driver.get(baseUrl);

        HomePage initialHomePage = new HomePage(driver);
        Assert.assertTrue(initialHomePage.CheckHomePageIsVisible());
        homePage=new HomePage(driver);
        SignUpOrLoginPage signUpOrLoginPage = homePage.clickLoginOrSignUp();
        Assert.assertTrue(signUpOrLoginPage.isSignUpFormVisible());
        signUpOrLoginPage.login(email, password);
        signUpOrLoginPage.clickLogin();
        Assert.assertTrue(homePage.isUserLoggedIn(username));
        DeleteAccountPage deleteAccountPage=homePage.clickDeleteAccount();
        Assert.assertTrue(deleteAccountPage.isAccountDeletedMessageVisible());
        deleteAccountPage.clickContinue();
        Assert.assertTrue(homePage.CheckHomePageIsVisible());



    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        //finish test
    }

}
