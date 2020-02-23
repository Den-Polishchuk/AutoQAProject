package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homeTaskLesson7 {
    public static void main(String[] args) throws InterruptedException {
        By selectors[] = {By.xpath("//div[@class='phones-block']/a"), By.cssSelector(".phones-block > a")};
        for(int i = 0; i < 2; i++) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        Thread.sleep(5000);


        String num = driver.findElement(selectors[i]).getText();
        System.out.println(num.substring(4).replace("044", "050"));
        Thread.sleep(5000);

        driver.quit();

        }
    }
}
