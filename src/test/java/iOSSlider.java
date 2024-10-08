import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSSlider extends iOSBaseTest{

    @Test
    public void iOSSliderTest() throws InterruptedException{
        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
        slider.sendKeys("0%");//To make it slide left
        Thread.sleep(3000);
        slider.sendKeys("1%");//To make it slide right
        Thread.sleep(3000);
       

      
    }
    
}
