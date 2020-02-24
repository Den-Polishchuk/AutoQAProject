package test.java.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.tests.PO.HomePage;
import test.java.tests.PO.VacancyPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForPO extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;

    @BeforeMethod
    public void pageLoad(){
        homePage = new HomePage(driver);
        vacancyPage = new VacancyPage(driver);
    }


    @Test
    public void anyTest() {

        homePage.open()
                .selectLanguage("uk")
                .openAbout()
                .openVacancies();
        vacancyPage
                .selectVacancy("Викладач UX")
                .setName("Denys")
                .setEmail("email@email.com")
                .submit();
        String actualMsg = vacancyPage.getPhoneErrorMsg();
        String expectedMsg = "Поле не має бути пустим";
        assertEquals(actualMsg, expectedMsg);
    }


    @Test
    public void eveningCourses(){
        String coursesExpected[] = {"Тестування", "Frontend development", "JS development", "Веб-дизайн", "PHP", "Java programming", "Python", "Data Science/Machine Learning", "C# /.NET development", "C++", "Game Development", "DEVOPS", "Digital Marketing", "Управління персоналом", "Управління проектами", "Mobile development", "Відеомонтаж", "Cisco", "Go development", "Кібербезпека", "Менеджмент"};
        homePage.open()
                .openEveningCourses()
                .openCoursesEven();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container_12 isotope 21']"))));
        List<WebElement> coursesList = driver.findElements(By.xpath("(//div[@class='container_12 isotope 21'])[1]//h2"));
        List<String> coursesActual = new ArrayList<>();

        for(WebElement el: coursesList){
            coursesActual.add(el.getText());
        }

        for(String course: coursesExpected){
            boolean isContains = coursesActual.contains(course);
            assertTrue(isContains, String.format("Expected course '%s' to be present on page", course));
        }
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


}