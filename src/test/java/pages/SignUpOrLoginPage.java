package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpOrLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpOrLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By signupform = By.xpath("//h2[text()='New User Signup!']");
    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By signupemailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");



    private By loginForm = By.xpath("//h2[text()='Login to your account']");
    private By loginemailInput = By.xpath("//input[@data-qa='login-email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    public boolean isSignUpFormVisible() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(signupform));
        return form.isDisplayed();
    }

    public void signup(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
        driver.findElement(signupemailInput).sendKeys(email);

    }
    public SignUpPageAfterClick clickSignUp() {

        driver.findElement(signupButton).click();
        return new SignUpPageAfterClick(driver);
    }


    public boolean isLoginFormVisible() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
        return form.isDisplayed();
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginemailInput)).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);

    }
    public HomePage clickLogin() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

}
