package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Slider {
    WebDriver driver;

    @Before
    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://jqueryui.com/slider/");
    }
    @Test
    public void slide(){
        WebElement iframe= driver.findElement(By.cssSelector("[class=demo-frame]"));
        driver.switchTo().frame(iframe);


    }

}
