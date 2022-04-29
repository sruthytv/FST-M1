package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Chrome {
    AndroidDriver<MobileElement> driver;
    WebDriver wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("deviceId", "lf5l4luccm6djr9d");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
        caps.setCapability("noReset",true);

        //server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Diver Initialization
        driver = new AndroidDriver<>(serverURL, caps);
        driver.get("https://www.training-support.net/selenium");
        wait= (WebDriver) new WebDriverWait(driver,5);


    }
    @Test
    public void toDoList(){
        // Open page in browser
        driver.get("https://www.training-support.net/selenium");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));


        /// Scroll to To do list
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(5).scrollIntoView(text(\"To-Do List\"))")).click();


        //Wait for new page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")
        ));


        WebElement task = driver.findElementById("taskInput");
        task.sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //Add task2
        MobileElement task2 = driver.findElementById("taskInput");
        task2.sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //Add task3
        MobileElement task3 = driver.findElementById("taskInput");
        task3.sendKeys("Clear the list");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //strike
        MobileElement striketask1 = driver.findElementByXPath("//android.widget.TextView[@text='Add tasks to list']");
        striketask1.click();

        MobileElement striketask2 = driver.findElementByXPath("//android.widget.TextView[@text='Get number of tasks']");
        striketask2.click();

        MobileElement striketask3 = driver.findElementByXPath("//android.widget.TextView[@text='Clear the list']");
        striketask3.click();

        //Clearlist
        MobileElement clearlist = driver.findElementByXPath("//android.widget.TextView[@text='Clear List']");
        clearlist.click();

        // Assertions
        Assert.assertNotEquals(striketask1,"Add tasks to list");
        System.out.println("AssertNotEquals Test Passed\n");

    }


    @AfterClass
    public void tearDown(){
        driver.quit();   //close wont work in Appium
    }
}
