package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private By continueAfterDeleteButton = By.xpath("//a[@data-qa='continue-button' and contains(text(),'Continue')]");

    public boolean isAccountDeletedMessageVisible() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedText));
        return message.isDisplayed();
    }
    public HomePage clickContinue(){

        driver.findElement(continueAfterDeleteButton).click();
        return new HomePage(driver);
    }
}
