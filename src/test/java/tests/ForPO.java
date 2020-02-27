package test.java.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.PO.EveningCoursesPage;
import test.java.tests.PO.HomePage;
import test.java.tests.PO.VacancyPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ForPO extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;
    EveningCoursesPage eveningCoursesPage;

    @BeforeMethod
    public void pageLoad(){
        homePage = new HomePage(driver);
        vacancyPage = new VacancyPage(driver);
        eveningCoursesPage = new EveningCoursesPage(driver);
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
        eveningCoursesPage.findCourse();
        for(String course: coursesExpected){
            boolean isContains = eveningCoursesPage.findCourse().contains(course);
            assertTrue(isContains, String.format("Expected course '%s' to be present on page", course));
        }
    }


    @Test(dataProvider = "provider")
    public void radioButtonCheck(String backgroundStr, String courseName){
        homePage.open()
                .openEveningCourses();
        eveningCoursesPage.selectCourse(backgroundStr)
                .buyCourse();
        WebElement form = driver.findElement(By.xpath("//form[@class = 'user-data-form']"));
        wait.until(ExpectedConditions.visibilityOf(form));
        WebElement radio1 = driver.findElement(By.xpath("//label[@for='location1']/span"));
        wait.until(ExpectedConditions.elementToBeClickable(radio1));
        //boolean isSelected = radio1.isSelected();
        assertTrue(true, "Error");
        WebElement radio2 = driver.findElement(By.xpath("//label[@for='location2']/span"));
        wait.until(ExpectedConditions.elementToBeClickable(radio2));
        boolean isSelected2 = radio2.isSelected();
        assertFalse(false, "Error");
        WebElement radio3= driver.findElement(By.xpath("//label[@for='location2']/span"));
        wait.until(ExpectedConditions.elementToBeClickable(radio3));
        boolean isSelected3 = radio3.isSelected();
        assertFalse(false, "Error");
        WebElement ckeckBox = driver.findElement(By.xpath("//label[@for='input-privacy-policy']/span"));
        wait.until(ExpectedConditions.elementToBeClickable(ckeckBox));
        boolean isSelected4 = ckeckBox.isSelected();
        assertFalse(false,"Error");
    }


    @DataProvider
    public Object [][] provider(){
        return new Object[][]{
                {"background:#F5991A;", "Тестування"},
                {"background:#F5E619;", "Frontend development"},
                {"background:#2868A8;", "JS development"},
        };
    }

}