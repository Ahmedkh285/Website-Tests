package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.SignUpOrLoginPage;
import setup.Setup;
import utils.provider.ExcelDataProvider;
public class RegisterWithExistingEmail extends Setup {

    //i created this function to generate random emails every time.







    //private final String email =generateRandomEmail();


//    private final String email = "ahmedkhalaf1813@yahoo.com";
//    private final String password = "12345";
//    private final String username = "ahmed khalaf";


    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "registerWithExistingEmail")
    public void registerWithExistingEmail(String username ,String email) {
        test.info("Test case started");
        try{
            Assert.assertTrue(homePage.CheckHomePageIsVisible());
            test.log(Status.PASS,"Home Page verified");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        SignUpOrLoginPage signUpOrLoginPage = homePage.clickLoginOrSignUp();
        try{
        Assert.assertEquals(signUpOrLoginPage.isNewUserSignupVisible(),"New User Signup!");
            test.log(Status.PASS,"New User Signup Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        signUpOrLoginPage.signup(username,email);
        signUpOrLoginPage.clickSignUp();
        try{
        Assert.assertEquals(signUpOrLoginPage.emailAlreadyExistMessage(),"Email Address already exist!");
            test.log(Status.PASS,"Email Address already exist! Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }

    }



}
