package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import models.SignupData;
import pages.*;
import setup.Setup;

import java.util.UUID;
public class FullTest extends Setup {
        public String generateRandomEmail() {
       String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return "user_" + uuid + "@testmail.com";
    }
    //i created this function to generate random emails every time.







    private final String email =generateRandomEmail();


    private final String username = "ahmed khalaf";




    @Test
    public void signupAndLoginAndDeleteAccountTest() {



        Assert.assertTrue(homePage.CheckHomePageIsVisible());
        //check home page is visable.



        homePage=new HomePage(driver);
        SignUpOrLoginPage signUpOrLoginPage = homePage.clickLoginOrSignUp();
        //to navigate to login or signup page.





        Assert.assertTrue(signUpOrLoginPage.isSignUpFormVisible());
        signUpOrLoginPage.signup(username, email);
        //filling username and email to signup and press signup button.



       SignUpPageAfterClick signUpPageAfterClick = signUpOrLoginPage.clickSignUp();
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
        signUpPageAfterClick.completeSignupForm(data);
        //filling new account data as above "you can change the data as you like"




        AccountCreated accountCreated = signUpPageAfterClick.clickCrateAccount();

        //create account and navigate to a page telling you account created by clicking "create account" button




        assert accountCreated.isAccountCreatedVisible();
        accountCreated.clickCountinue();
        //clicking continue after creating account to navigate to home page.




        homePage.clickLogOut();
        //logout from account and navigate to login or signup page




        Assert.assertTrue(signUpOrLoginPage.isLoginFormVisible());
        signUpOrLoginPage.login(email,data.password);
        //filling login data



        signUpOrLoginPage.clickLogin();
        //click login button to check if it is working





        Assert.assertTrue(homePage.CheckHomePageIsVisible());
        DeleteAccountPage deleteAccountPage=homePage.clickDeleteAccount();
        //by clicking login we navigate to home page again but now to delete the account




        Assert.assertTrue(deleteAccountPage.isAccountDeletedMessageVisible());
        deleteAccountPage.clickContinue();
        /*
        making sure navigating to deleted account page
         and pressing continue after making sure
        */




        Assert.assertTrue(homePage.CheckHomePageIsVisible());
        homePage.clickLoginOrSignUp();
        //navigate again to home page and then to login page by clicking on login / signup




        Assert.assertTrue(signUpOrLoginPage.isLoginFormVisible());
        signUpOrLoginPage.login(email,data.password);
        //verify that deleted account unable to login again.
    }



}
