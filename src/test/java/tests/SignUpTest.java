package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import models.SignupData;
import setup.Setup;
import pages.*;

import java.util.UUID;
public class SignUpTest extends Setup {
    public String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return "user_" + uuid + "@testmail.com";
    }
    //i created this function to generate random emails every time.






    private final String email =generateRandomEmail();


    private final String username = "ahmed khalaf";




    @Test
    public void signuptest() {



        Assert.assertTrue(homePage.CheckHomePageIsVisible());
        //check home page is visable.



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


    }



}
