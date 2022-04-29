package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

public class GoogleTask {
    AndroidDriver<MobileElement> driver;
    WebDriver wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("deviceId", "lf5l4luccm6djr9d");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.google.android.apps.tasks");
        caps.setCapability("appActivity",".ui.TaskListsActivity");
        caps.setCapability("noReset",true);

        //server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Diver Initialization
        driver = new AndroidDriver<>(serverURL, caps);
        wait= (WebDriver) new WebDriverWait(driver,5);


    }
    @Test
    public void taskFunction(){
        driver.findElementById("tasks_fab").click();
//        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();
        driver.findElementById("tasks_fab").click();
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();
        driver.findElementById("tasks_fab").click();
        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();

        Assert.assertTrue(driver.findElementByAccessibilityId("Complete Activity with Google Tasks").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Complete Activity with Google Keep").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Complete the second Activity Google Keep").isDisplayed());

   }
    @AfterClass
    public void tearDown(){
        driver.quit();   //close wont work in Appium
    }
}
