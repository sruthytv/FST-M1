package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "SG9S9PZTTWGYNBHM");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.contacts");
        caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
        caps.setCapability("noReset", true);
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }
    @Test
    public void addContact() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create contact")));
        driver.findElementByAccessibilityId("Create contact").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));

        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");

        firstName.sendKeys("Aaditya");
        lastName.sendKeys("Varma");
        phoneNumber.sendKeys("9991284782");
        // Save the contact
        driver.findElementById("toolbar_button").click();
        // Wait for contact card to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));
        // Assertion
        MobileElement mobileCard = driver.findElementById("action_bar_root");
        Assert.assertTrue(mobileCard.isDisplayed());

        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}