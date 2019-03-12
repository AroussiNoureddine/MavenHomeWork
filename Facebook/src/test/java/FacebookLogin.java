import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FacebookLogin extends CommonAPI{
    @Test
    public void facebookLogIn() throws InterruptedException {
        System.out.println("Successfully opened the website");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("aroussi.nouredine@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("PASSWORD");
        driver.findElement(By.id("u_0_2")).click();
        System.out.println("Successfully logged in");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.cssSelector(".\\_64kz .\\_54nh")).click();
        System.out.println("Successfully logged out");
    }
}
