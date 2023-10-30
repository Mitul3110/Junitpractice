package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Resizable2 {

    WebDriver driver;
    @Before

    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/resizable/");
    }
    @Test
    public  void resizable(){
       /* WebElement iframe = driver.findElement(By.cssSelector("[class='demo-frame']"));
        driver.switchTo().frame(iframe);*/
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
