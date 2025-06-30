package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By allproductspageide = By.xpath("//h1/span[text()='Automation']");
    private By loggedInUserText = By.xpath("//a[contains(text(), 'Logged in as')]");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By logoutButton = By.xpath("//a[@href='/logout' and contains(text(),'Logout')]");
    private By loginOrSignUp=By.xpath("//a[contains(text(),'Signup / Login')]");
    private By testCasesButton = By.xpath("//a[@href='/test_cases' and contains(text(),'Test Cases')]");
    private By allProductsTitle = By.xpath("//h2[@class='title text-center' and text()='All Products']");
    private By viewProductButton = By.xpath("//a[@href='/product_details/1' and contains(text(),'View Product')]");

    public boolean CheckAllProductsPageIsVisible() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(allproductspageide));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public boolean isUserLoggedIn(String username) {
        WebElement userText = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserText));
        return userText.getText().contains(username);
    }

    public DeleteAccountPage clickDeleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountButton)).click();
        return new DeleteAccountPage(driver);
    }
    public void clickLogOut() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
    public SignUpOrLoginPage clickLoginOrSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(loginOrSignUp)).click();
        return new SignUpOrLoginPage(driver);

    }
    public TestCasesPage clickTestCases() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesButton)).click();
        return new TestCasesPage(driver);

    }

    public boolean verifyProductsListIsVisible() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(allProductsTitle));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public ViewProductPage clickViewProductButton() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(viewProductButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(viewProductButton));
//        button.click();
        return new ViewProductPage(driver);

    }
//    public boolean verifyViewProductsButtonIsVisible() {
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(viewProductButton));
//        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
//    }
}
