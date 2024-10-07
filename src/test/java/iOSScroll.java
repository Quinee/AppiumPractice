import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;

public class iOSScroll extends iOSBaseTest{

    @Test
    public void iOSScrollTest() throws InterruptedException{
        
        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
       //longPress(ele);
       Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) ele).getId());
        params.put("direction", "down");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: scroll", params);
        ele.click();
        //Thread.sleep(4000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");

        String blueNumber = driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
        Assert.assertEquals(blueNumber,"105");
       



      
    }
    
}
