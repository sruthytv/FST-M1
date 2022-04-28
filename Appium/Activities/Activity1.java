package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("deviceId", "lf5l4luccm6djr9d");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.miui.calculator");
        caps.setCapability("appActivity",".cal.CalculatorActivity");
        caps.setCapability("noReset",true);

        //server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Diver Initialization
        driver = new AndroidDriver<>(serverURL, caps);


    }
    @Test
    public void additionTest(){
        driver.findElementById("btn_2_s").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("btn_6_s").click();
        driver.findElementByAccessibilityId("equals");

        String result=driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("8"));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();   //close wont work in Appium
    }
}
