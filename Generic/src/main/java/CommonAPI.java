import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver =null ;
    @Parameters({"url"})
    @BeforeMethod
    public void start(String url){
        System.setProperty("webdriver.gecko.driver","/Users/anour-mbp/GDrive/Projects/Intellij/ANourWebMVN/Generic/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void clean(){
        driver.close();
    }
    public void typeOnID(String locator,String Value){
        driver.findElement(By.id(locator)).sendKeys(Value, Keys.ENTER);
    }
    public void typeOnCSS(String locator,String Value){
        driver.findElement(By.cssSelector(locator)).sendKeys(Value, Keys.ENTER);
    }
    public void typeOnWebElement(String locator,String Value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(Value, Keys.ENTER);
        }catch(Exception ex){
            System.out.println("Tried with CSS, did not work. will try by ID now");
            driver.findElement(By.id(locator)).sendKeys(Value, Keys.ENTER);
        }
    }
    public void typeOnElement(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value,Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value,Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value,Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value,Keys.ENTER);
                }
            }
        }
    }
}
