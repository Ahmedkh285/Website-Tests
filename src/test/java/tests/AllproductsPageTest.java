package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.TestCasesPage;
import pages.ViewProductPage;
import setup.Setup;

public class AllproductsPageTest extends Setup {



    @Test
    public void verifyAllProductsPage() {
        test.info("Test case started");
        try{
            Assert.assertTrue(homePage.CheckHomePageIsVisible());
            test.log(Status.PASS,"Home Page verified");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        AllProductsPage allProductsPage = homePage.clickProductsButton();

        try{
            Assert.assertTrue(allProductsPage.verifyProductsListIsVisible());
            test.log(Status.PASS,"Products List Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }

//        try{
//            Assert.assertTrue(allProductsPage.verifyViewProductsButtonIsVisible());
//            test.log(Status.PASS,"View Products Button Is Visible");
//        }catch (Exception e){
//            test.log(Status.FAIL,e.getCause() + e.getMessage());
//        }


        ViewProductPage viewProductPage = allProductsPage.clickViewProductButton();



        try{
            Assert.assertEquals(viewProductPage.verifyProductName(),"Blue Top");
            test.log(Status.PASS,"Product Name Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        try{
            Assert.assertTrue(viewProductPage.verifyCategory().contains("Women > Tops"));
            test.log(Status.PASS,"Product Category Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        try{
            Assert.assertEquals(viewProductPage.verifyPrice().trim(),"Rs. 500");
            test.log(Status.PASS,"Product Price Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        try{
            Assert.assertEquals(viewProductPage.verifyAvailability(),"Availability:");
            test.log(Status.PASS,"Product Availability Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        try{
            Assert.assertEquals(viewProductPage.verifyCondition(),"Condition:");
            test.log(Status.PASS,"Product Condition Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
        try{
            Assert.assertEquals(viewProductPage.verifyBrand(),"Brand:");
            test.log(Status.PASS,"Product Brand Is Visible");
        }catch (Exception e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }




    }



}


