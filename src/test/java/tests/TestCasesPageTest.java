package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestCasesPage;
import setup.Setup;


public class TestCasesPageTest extends Setup {


    @Test
    public void verifyTestCasesPage() {
        test.info("Test case started");
        try{
            Assert.assertTrue(homePage.CheckHomePageIsVisible());
            test.log(Status.PASS,"Home Page verified");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        TestCasesPage testCasesPage = homePage.clickTestCases();
        try{
            Assert.assertTrue(testCasesPage.isTestCasesPageVisible());
            test.log(Status.PASS,"TestCases Page Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }


    }



}
