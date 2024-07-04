package tek.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetupSeleniumProject {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://google.com");

        //Fluent Wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("buttonId")))
                .click();

        //Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("InputName")));

        element.clear();

        driver.quit();

    }
}
