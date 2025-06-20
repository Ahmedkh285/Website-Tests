package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import models.SignupData;
import pages.*;

import java.sql.Driver;
import java.util.UUID;
public class FullTest {
        public String generateRandomEmail() {
       String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return "user_" + uuid + "@testmail.com";
    }
    //i created this function to generate random emails every time.





    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private SignUpPage signuppage;
    //private SignupData signupdata;



    private SignUpPageAfterClick signuppageafterclick;
    private DeleteAccountPage deleteAccountPage;
    //private CompleteSignUpPage completesignuppage;

    private final String baseUrl = "https://www.automationexercise.com";
    private final String email =generateRandomEmail();
    //private final String password = "12345";

    private final String username = "ahmed khalaf";


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void signupAndLoginAndDeleteAccountTest() {
        driver.get(baseUrl);

        HomePage initialHomePage = new HomePage(driver);
        Assert.assertTrue(initialHomePage.CheckHomePageIsVisible());
        //check home page is visable.



        homePage=new HomePage(driver);
        homePage.clickLoginOrSignUp();
        //to navigate to login or signup page.



        signuppage = new SignUpPage(driver);
        Assert.assertTrue(signuppage.isSignUpFormVisible());
        signuppage.signup(username, email);
        //filling username and email to signup and press signup button.



       signuppageafterclick = new SignUpPageAfterClick(driver);
        SignupData data = new SignupData();
        data.password = "Test1234";
        data.day = "10";
        data.month = "5";
        data.year = "1990";
        data.firstName = "Ahmed";
        data.lastName = "khalaf";
        data.company = "BoldRoutes";
        data.address1 = "123 Main St";
        data.address2 = "Building B";
        data.country = "Canada";
        data.state = "Ontario";
        data.city = "Toronto";
        data.zipcode = "12345";
        data.mobile = "0123456789";
        SignUpPageAfterClick signupPage = new SignUpPageAfterClick(driver);
        signuppageafterclick.completeSignupForm(data);
        //filling new account data as above "you can change the data as you like"




        assert signuppageafterclick.isAccountCreatedVisible();
        signuppageafterclick.clickCountinue();
        //clicking continue after creating account to navigate to home page.




        homePage= new HomePage(driver);
        homePage.clickLogOut();
        //logout from account



        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginFormVisible());
        loginPage.login(email,data.password);
        //navigate again to login page to login with account created to check if it is working.



        homePage=new HomePage(driver);
        Assert.assertTrue(homePage.CheckHomePageIsVisible());
        homePage.clickDeleteAccount();
        //navigate to home page again but now to delete the account



        deleteAccountPage =new DeleteAccountPage(driver);
        Assert.assertTrue(deleteAccountPage.isAccountDeletedMessageVisible());
        deleteAccountPage.clickContinue();
        /*
        making sure navigating to deleted account page
         and pressing continue after making sure
        */



        homePage=new HomePage(driver);
        Assert.assertTrue(homePage.CheckHomePageIsVisible());
        homePage.clickLoginOrSignUp();
        //navigate again to home page and then to login page by clicking on login / signup



        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginFormVisible());
        loginPage.login(email,data.password);
        //verify that deleted account unable to login again.
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
