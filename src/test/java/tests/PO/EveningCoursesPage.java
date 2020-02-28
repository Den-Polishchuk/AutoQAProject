package test.java.tests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class EveningCoursesPage extends BasePage {
    Logger logger = LogManager.getLogger(EveningCoursesPage.class);


    public EveningCoursesPage(WebDriver driver) {
        super(driver);
    }

    public List<String> findCourse(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container_12 isotope 21']"))));
        List<WebElement> coursesList = driver.findElements(By.xpath("(//div[@class='container_12 isotope 21'])[1]//h2"));
        List<String> coursesActual = new ArrayList<>();
        for(WebElement el: coursesList){
            coursesActual.add(el.getText());
        }
        return coursesActual;
    }

    public EveningCoursesPage selectCourse(String backgroundStr){
        WebElement course = driver.findElement(By.xpath("//div[@style='" + backgroundStr + "']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(course));
        course.click();
        return this;
    }

    public EveningCoursesPage buyCourse(){
        WebElement buyCourse = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyCourse));
        buyCourse.click();
        return this;
    }

}
