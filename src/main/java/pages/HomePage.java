package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By homePageIdent = By.xpath("//h1/span[text()='Automation']");
    private By loggedInUserText = By.xpath("//a[contains(text(), 'Logged in as')]");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By logoutButton = By.xpath("//a[@href='/logout' and contains(text(),'Logout')]");
    private By loginOrSignUp=By.xpath("//a[contains(text(),'Signup / Login')]");
    private By testCasesButton = By.xpath("//a[@href='/test_cases' and contains(text(),'Test Cases')]");
    private By productsButton = By.xpath("//a[@href='/products' and contains(text(),'Products')]");
    public boolean CheckHomePageIsVisible() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(homePageIdent));
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
    public AllProductsPage clickProductsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(productsButton)).click();
        return new AllProductsPage(driver);

    }
}
