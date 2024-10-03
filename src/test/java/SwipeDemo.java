import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class SwipeDemo extends BaseTest{
    @Test
    public void SwipeDemoTest() throws InterruptedException  {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        //driver.findElement(AppiumBy.accessibilityId("1. Photos"))

        //Before swipe the focus is in the First Image
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");

        //Now, we are swiping
        swipeAction(firstImage,"left");

        //After swiping the focus should not be in the first image
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");


        


        
        
    }
}
