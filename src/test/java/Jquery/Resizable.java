package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {


    WebDriver driver;

    @Before

    public void openup (){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();
    }
    @Test

    public void Resize() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        WebElement iframe = driver.findElement(By.cssSelector("[class=demo-frame]"));
        driver.switchTo().frame(iframe);
        WebElement size = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(size).moveByOffset(100, 300);
        Thread.sleep(15000);
    }
    @After
    public void teardown () {
        driver.close();
    }




    }

