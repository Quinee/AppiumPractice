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

public class DragDropDemo extends BaseTest{
    @Test
    public void DragDropTest() throws InterruptedException  {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
    "elementId", ((RemoteWebElement) source).getId(),
    "endX", 652,
    "endY", 564
));

Thread.sleep(3000);
String displayedResultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
Assert.assertEquals(displayedResultText,"Dropped");
       


        


        
        
    }
}
