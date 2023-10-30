package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {

     WebDriver driver;

    @Before
    public void openup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
       // driver.get("https://jqueryui.com/droppable/");
        //WebDriverManager.chromedriver().setup();
       //ChromeOptions option = new ChromeOptions();
        //option.addArguments("--remote-allow-origins=*");
        //option.addArguments("--disable-notifications");
        //System.setProperty("WebDriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        //driver = new ChromeDriver(option);
       // driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
    }

    @Test
    public void droppable() throws InterruptedException {
        WebElement iframe = driver.findElement(By.cssSelector("[class=demo-frame]"));
        driver.switchTo().frame(iframe);
        WebElement dragItem = driver.findElement(By.cssSelector("[id=draggable]"));
        WebElement dropItem = driver.findElement(By.cssSelector("[id=droppable]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragItem, dropItem).build().perform();
        Thread.sleep(15000);
        String actual = dropItem.getText();
        Assert.assertThat(actual, Matchers.equalTo("Dropped!"));
    }

    @After
    public void close() {
        driver.close();
    }


}



