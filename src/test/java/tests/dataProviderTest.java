package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.PO.HomePage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class dataProviderTest {
    HomePage homePage;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void checkLang() {
        String langExpected[] = {"UA", "EN", "RU"};

        homePage.open();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"))));

        List<WebElement> langElements = driver.findElements(By.xpath("(//ul[@class='lang'])[1]//a"));
        List<String> langActual = new ArrayList<>();

        for (WebElement el : langElements) {
            langActual.add(el.getText());
        }

        for(String lang: langExpected){
            boolean isContains = langActual.contains(lang);
            assertTrue(isContains, String.format("Expected language '%s' to be present on page", lang));
        }
    }

    @Test(dataProvider = "provider")
    public void someTest(String langStr){
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        WebElement lang = driver.findElement(By.xpath("(//a[@hreflang='" + langStr + "'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(lang));
        lang.click();
        WebElement logo = driver.findElement(By.xpath("//img[@alt='ITEA']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        //boolean isDisplayed = logo.isDisplayed();
        assertTrue(true, "Error");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] provider(){
        return new Object[][]{
                {"ru-RU"},
                {"uk"},
                {"en-GB"},
        };
    }
}
