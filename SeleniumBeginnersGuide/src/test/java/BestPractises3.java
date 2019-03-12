import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsById;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BestPractises3 extends CommonAPI{
    @Test
    public void testChapter2(){
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      if  (driver.findElements(By.xpath("//input[@id='but1']")).size()>0)
          driver.get("http://book.theautomatedtester.co.uk/chapter2");
    }
    @Test
    public void getTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "Selenium: Beginners Guide");
    }
    @Test
    public void testChapter4(){
        driver.get("http://book.theautomatedtester.co.uk/chapter4");
        WebElement element = driver.findElement(By.id("selectLoad"));
        String value = element.getAttribute("value");
        Assert.assertEquals("Click to load the select below", value);
    }
    @Test
    public void testCapter1VerifyButton() {
        driver.get("http://book.theautomatedtester.co.uk/chapter1");
        WebElement element = driver.findElement(By.id("verifybutton"));
        String str=element.getAttribute("value");
        Assert.assertEquals(str,"Verify this button he here");
    }
    @Test
    public void tCh1VefiryButtonList(){
        List<WebElement> elements = ((FindsById)driver).findElementsById("verifybutton");
        Assert.assertEquals(1, elements.size());
    }
    @Test
    public void testCapter1Storetext() {
        driver.get("http://book.theautomatedtester.co.uk/chapter1");
         WebElement element = driver.findElement(By.className("storetext"));
    }
    @Test
    public void testCapter1StoretextList(){
        List<WebElement> elements = ((FindsByClassName)driver).findElementsByClassName("storetext");
        Assert.assertEquals(1, elements.size());
    }
}
