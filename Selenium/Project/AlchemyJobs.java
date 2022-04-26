package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlchemyJobs {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void verifyTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title,"Alchemy Jobs – Job Board Application");
    }
    @Test
    public void verifyHeading(){

        String heading=driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        System.out.println("Page heading is: " + heading);
        Assert.assertEquals(heading,"Welcome to Alchemy Jobs");
    }
    @Test
    public void getHeaderImageURL(){

        String headerURL=driver.findElement(By.xpath("//img[@itemprop='image']")).getAttribute("src");
        System.out.println("Image URL is: " + headerURL);
    }
    @Test
    public void verifySecondHeading(){

        String heading=driver.findElement(By.xpath("//div[@class='entry-content clear']//h2")).getText();
        System.out.println("Page Second heading is: " + heading);
        Assert.assertEquals(heading,"Quia quis non");
    }
    @Test
    public void verifyJobPage(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']//a[text()='Jobs']")).click();
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title,"Jobs – Alchemy Jobs");
    }
    @Test
    public void applyJob(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']//a[text()='Jobs']")).click();
        driver.findElement(By.xpath("//input[@id=('search_keywords')]")).sendKeys("Banking");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type=('submit')]")).click();
        driver.findElement(By.xpath("//ul[@class='job_listings']//li[1]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class='application_button button']")).click();
        String emailid= driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
        System.out.println("Email Id is: " + emailid);

    }
    @Test
    public void postJob() {
        driver.findElement(By.xpath("//ul[@id='primary-menu']//a[text()='Post a Job']")).click();
        driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys("test123y@gmail.com");
        driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys("TesterQA");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("QA Jobs");
//      driver.findElement(By.xpath("//textarea[@id='job_description']")).sendKeys("QA Jobs");
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys("qajobs123y@gmail.com");
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
        driver.findElement(By.xpath("//ul[@id='primary-menu']//a[text()='Jobs']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id=('search_keywords')]")).sendKeys("Tester");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type=('submit')]")).click();
        String jobTitle= driver.findElement(By.xpath("//ul[@class='job_listings']//li[1]//a[1]//div//h3")).getText();
        Assert.assertEquals(jobTitle,"TesterQA");

    }

    @Test
    public void verifyAdminPage(){
        driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        try{
        if(driver.findElement(By.xpath("//div[text()='Dashboard']")).isDisplayed()){
            System.out.println("Logged in as Admin");
        }}
        catch (Exception e){
            System.out.println("Log in as Admin is failed");
            e.printStackTrace();
        }
    }
    @Test
    public void jobPostViaAdmin(){
        driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        driver.findElement(By.xpath("//div[text()='Job Listings ']")).click();
        driver.findElement(By.xpath("//div[@id='wpbody-content']//a[text()='Add New']")).click();
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys("qajobs123y@gmail.com");
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("IBM");
        driver.findElement(By.xpath("//button[text()='Publish…']")).click();
    }
        @AfterMethod
    public void afterMethod() {
        //Close the browser
            driver.quit();
    }
}
