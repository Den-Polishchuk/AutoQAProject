package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class homeTaskLesson8 {
    WebDriver driver;
    WebDriverWait waitForPresence;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        waitForPresence = new WebDriverWait(driver, 15);
        driver.get("http://iteaua-develop.demo.gns-it.com/");
    }

    @Test
    public void callBackPositive() {
        WebElement callBackEl = driver.findElement(By.xpath("//a[@class='callback-btn']"));
        waitForPresence.until(ExpectedConditions.elementToBeClickable(callBackEl));
        callBackEl.click();

        WebElement nameField = driver.findElement(By.cssSelector("input#b-contacte__full-name"));
        WebElement phoneField = driver.findElement(By.cssSelector("input#b-contacte-phone-tel"));
        waitForPresence.until(ExpectedConditions.elementToBeClickable(nameField));
        waitForPresence.until(ExpectedConditions.elementToBeClickable(phoneField));
        nameField.sendKeys("DenTest");
        phoneField.sendKeys("0635482159");


        WebElement sbmButton = driver.findElement(By.cssSelector("input#b-contacte-phone-tel + input"));
        waitForPresence.until(ExpectedConditions.elementToBeClickable(sbmButton));
        sbmButton.click();

        WebElement confMsg = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-thank hidden']/p"));
        waitForPresence.until(ExpectedConditions.visibilityOf(confMsg));
        String actualMsg = confMsg.getText();

        String expectedValue = "Thank you!\n" + "Our manager will contact you";
        assertEquals(expectedValue, actualMsg);

    }

    @Test
    public void callBackNegative() {
        WebElement callBackEl = driver.findElement(By.xpath("//a[@class='callback-btn']"));
        waitForPresence.until(ExpectedConditions.elementToBeClickable(callBackEl));
        callBackEl.click();

        WebElement sbmButton = driver.findElement(By.cssSelector("input#b-contacte-phone-tel + input"));
        waitForPresence.until(ExpectedConditions.elementToBeClickable(sbmButton));
        sbmButton.click();

        WebElement nameField = driver.findElement(By.cssSelector("input#b-contacte__full-name"));
        waitForPresence.until(ExpectedConditions.attributeContains(nameField, "style", "border-color: red;"));
        String actualValue = nameField.getAttribute("style");

        String expectedValue = "border-color: red;";
        assertEquals(expectedValue, actualValue);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
