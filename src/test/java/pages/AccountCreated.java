package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreated {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountCreated(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By accountCreatedHeader = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    public boolean isAccountCreatedVisible() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedHeader)).isDisplayed();


    }


    public HomePage clickCountinue(){

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new HomePage(driver);

    }


}
