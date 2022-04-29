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

public class GoogleKeep {
    AndroidDriver<MobileElement> driver;
    WebDriver wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("deviceId", "lf5l4luccm6djr9d");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.google.android.keep");
        caps.setCapability("appActivity",".activities.BrowseActivity");
        caps.setCapability("noReset",true);

        //server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Diver Initialization
        driver = new AndroidDriver<>(serverURL, caps);
        wait= (WebDriver) new WebDriverWait(driver,5);


    }
    @Test
    public void keepFunction(){
        driver.findElementById("new_note_button").click();
//        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
        driver.findElementById("editable_title").click();
        driver.findElementById("editable_title").setValue("Task1");
        driver.findElementById("edit_note_text").setValue("Description Notes");
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        String notes= driver.findElementById("index_note_title").getText();

        Assert.assertEquals(notes,"Task1");
        System.out.println("The notes added is "+notes);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();   //close wont work in Appium
    }
}
