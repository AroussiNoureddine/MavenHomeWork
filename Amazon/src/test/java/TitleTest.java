import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleTest extends CommonAPI {
    @Test
    public void titleTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }
}
