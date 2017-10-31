package ua.amalinkovskiy.selenium.rozetka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest()  {

        driver.get("https://www.rozetka.com.ua");
        driver.findElement(By.name("text")).sendKeys("Матрас");
        driver.findElement(By.name("rz-search-button")).click();
        driver.findElement(By.name("width")).sendKeys("160");
        driver.findElement(By.name("dept")).sendKeys("200");
        driver.findElement(By.cssSelector("div.sf-submit button.btn-link-i")).click();
        List<WebElement> catalog_items = driver.findElements(By.name("catalog_item_block"));
        catalog_items.get(0).findElement(By.tagName("a")).click();
        driver.findElement(By.name("topurchases")).click();
        catalog_items = driver.findElements(By.name("catalog_item_block"));

    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
