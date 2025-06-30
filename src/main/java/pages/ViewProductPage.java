package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ViewProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    private By productTitle = By.xpath("//div[@class='product-information']/h2[text()='Blue Top']");
    private By categoryText = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    private By priceText = By.xpath("//div[@class='product-information']//span[contains(text(),'Rs. 500')]");
    private By conditionText = By.xpath("//div[@class='product-information']//b[contains(text(),'Condition:')]");
    private By availabilityText = By.xpath("//div[@class='product-information']//b[contains(text(),'Availability:')]");
    private By brandText = By.xpath("//div[@class='product-information']//b[contains(text(),'Brand:')]");
    public String verifyProductName() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String verifyCategory() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(categoryText));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String verifyPrice() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(priceText));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String verifyCondition() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(conditionText));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String verifyAvailability() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(availabilityText));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String verifyBrand() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(brandText));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }



}
