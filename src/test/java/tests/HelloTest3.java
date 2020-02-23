package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class HelloTest3 extends BaseTest {

    @Test
    public void checkStyle(){
        WebElement uaLang = driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"));
        WebElement ruLang = driver.findElement(By.xpath("(//a[text() = 'RU'])[1]"));
        WebElement enLang = driver.findElement(By.xpath("(//a[text() = 'EN'])[1]"));
//        waitForPresence.until(ExpectedConditions.or(
//                ExpectedConditions.visibilityOf(uaLang),
//                ExpectedConditions.visibilityOf(ruLang),
//                ExpectedConditions.visibilityOf(enLang)
//        ));

        By callBack = By.className("callback-btn");
        WebElement callBackEl = driver.findElement(callBack);

       // waitForPresence.until(ExpectedConditions.elementToBeClickable(callBack));

        callBackEl.click();

        By callBackMsg = By.xpath("//*[@class='b-header-contacte__detail']");
        WebElement callBackMsgEl = driver.findElement(callBackMsg);
        //waitForPresence.until(ExpectedConditions.presenceOfElementLocated(callBackMsg));

        //waitForPresence.until(ExpectedConditions.visibilityOf(callBackMsgEl));
        String msg = callBackMsgEl.getText();
        System.out.println(msg);

        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']"));
        //waitForPresence.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
        //waitForPresence.until(ExpectedConditions.attributeContains(nameInput, "style", "border-color: red;"));
        String style = nameInput.getAttribute("style");

        String expectedValue = "border-color: red;";
        String actualValue = style;
        assertEquals(expectedValue, actualValue);
    }

}
