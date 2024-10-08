import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSSwipe extends iOSBaseTest{

    @Test
    public void iOSSwipeTest() throws InterruptedException{
       Map<String,String> params = new HashMap<>();
       params.put("bundleId", "com.apple.mobileslideshow");
       driver.executeScript("mobile:launchApp", params);
       Thread.sleep(3000);

        //int imagesCount = driver.findElements(By.xpath("//XCUIElementTypeImage")).size();//XCUIElementTypeImage
       //System.out.println("YYYY"+imagesCount);
       driver.findElement(By.xpath("(//XCUIElementTypeOther//XCUIElementTypeImage)[1]")).click();

      
    }
    
}
