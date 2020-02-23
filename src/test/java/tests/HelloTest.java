package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        Thread.sleep(1000);

        By callBack = By.className("callback-btn");
        WebElement callBackEl = driver.findElement(callBack);
        callBackEl.click();

        Thread.sleep(1000);
        By callBackMsg = By.xpath("//*[@class='b-header-contacte__detail']");
        WebElement callBackMsgEl = driver.findElement(callBackMsg);
        String msg = callBackMsgEl.getText();
        System.out.println(msg);

        driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']")).click();
        Thread.sleep(500);

        String style = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("style");
        System.out.println(style);

        By exitBtn = By.xpath("(//*[@class='b-header-contacte__close-btn'])[1]");
        WebElement exitBtnEl = driver.findElement(exitBtn);
        exitBtnEl.click();
        Thread.sleep(1000);

        driver.quit();

    }
}
