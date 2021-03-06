package test.java.tests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(){
        logger.debug("Home page is opened ("+ driver.getCurrentUrl() +") and ready to be tested");
        logger.info("Home page was opened");
        logger.error("Home page wasn't opened");
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
        WebElement spinner = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this;
    }

    public HomePage selectLanguage(String lang){
        logger.info("Language is checked to " + lang);
        WebElement uaLang = driver.findElement(By.xpath("(//a[@hreflang='" + lang + "'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(uaLang));
        uaLang.click();
        return this;
    }

    public HomePage openAbout(){
        logger.info("About page is opened");
        logger.error("About page wasn't opened");
        logger.debug("About page is opened and ready to be tested");
        WebElement aboutBtn = driver.findElement(By.xpath("//a[(contains(@href, 'about_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(aboutBtn));
        aboutBtn.click();
        return this;
    }

    public HomePage openVacancies(){
        logger.info("Vacancy page is opened");
        logger.error("Vacancy page wasn't opened");
        logger.debug("Vacancy page is opened and ready to be tested");
        WebElement vacancies = driver.findElement(By.xpath("//li[@id='menu-item-15362']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        return this;
    }

    public HomePage openEveningCourses(){
        WebElement eveningCoursesDropdown = driver.findElement(By.xpath("//a[(contains(@href, 'courses_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(eveningCoursesDropdown));
        eveningCoursesDropdown.click();
        return this;
    }

    public HomePage openCoursesEven(){
        WebElement coursesEven = driver.findElement(By.xpath("//li[@id='menu-item-7871']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(coursesEven));
        coursesEven.click();
        return this;
    }

}
