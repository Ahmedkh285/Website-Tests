package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.SignUpOrLoginPage;
import setup.Setup;
import utils.provider.ExcelDataProvider;

public class LoginTest extends Setup {

    //i created this function to generate random emails every time.






//    private final String baseUrl = "https://www.automationexercise.com";
    //private final String email =generateRandomEmail();


//    private final String email = "ahmedkhalaf1813@yahoo.com";
//    private final String password = "12345";
//    private final String username = "ahmed khalaf";


    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "logintest")
    public void logintest(String email, String password, String username) {
        Assert.assertTrue(homePage.CheckHomePageIsVisible());
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



}
