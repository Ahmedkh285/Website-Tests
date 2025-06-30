package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    private By testCasesHeading = By.cssSelector("h2.title.text-center");
    public boolean isTestCasesPageVisible() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeading)).isDisplayed();

    }




}
