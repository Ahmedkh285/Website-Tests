package pages;
import models.SignupData;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPageAfterClick {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPageAfterClick(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By signUpPageAfterClickIden = By.xpath("//b[text()='Enter Account Information']");
    private By titleMrRadio = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");

    // Address Info Section
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");


    public boolean CheckSignUpPageAfterClickIsVisible() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(signUpPageAfterClickIden));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    // Verification (Optional)


    public void completeSignupForm(SignupData data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleMrRadio)).click();

        driver.findElement(passwordField).sendKeys(data.password);

        new Select(driver.findElement(dayDropdown)).selectByValue(data.day);
        new Select(driver.findElement(monthDropdown)).selectByValue(data.month);
        new Select(driver.findElement(yearDropdown)).selectByValue(data.year);

        driver.findElement(firstNameField).sendKeys(data.firstName);
        driver.findElement(lastNameField).sendKeys(data.lastName);
        driver.findElement(companyField).sendKeys(data.company);
        driver.findElement(address1Field).sendKeys(data.address1);
        driver.findElement(address2Field).sendKeys(data.address2);

        new Select(driver.findElement(countryDropdown)).selectByVisibleText(data.country);

        driver.findElement(stateField).sendKeys(data.state);
        driver.findElement(cityField).sendKeys(data.city);
        driver.findElement(zipcodeField).sendKeys(data.zipcode);
        driver.findElement(mobileNumberField).sendKeys(data.mobile);



    }
    public AccountCreated clickCrateAccount() {

        driver.findElement(createAccountButton).click();
        return new AccountCreated(driver);

    }

}
