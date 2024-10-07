import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

    @Test
    public void browserTest(){
        // driver.get("https://google.com");
        // System.out.println("YYYY"+driver.getTitle());
        //  driver.findElement(By.name("q")).sendKeys("water");
        // driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("a[routerlink*='product']")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");

        String text = driver.findElement(By.xpath("//a[normalize-space()='Devops']")).getText();
        Assert.assertEquals(text, "Devops");
    }
    
}
