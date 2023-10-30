package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeClass  {

    WebDriver driver;

    @Before

    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");

    }
    @Test

    public void droppable() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement iframe = driver.findElement(By.cssSelector("[class=demo-frame]"));
        driver.switchTo().frame(iframe);
        Thread.sleep(15000);

        WebElement drag= driver.findElement(By.cssSelector("[id=draggable]"));
        WebElement drop= driver.findElement(By.cssSelector("[id=droppable]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag,drop).build().perform();
        Thread.sleep(15000);
        String actual= drop.getText();
        Assert.assertThat(actual,Matchers.equalTo("Dropped!"));
    }

    @After
    public void close(){
        driver.close();
    }
}


