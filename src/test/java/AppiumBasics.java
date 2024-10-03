import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppiumBasics extends BaseTest{
    @Test
    public void WifiSettingsName() throws MalformedURLException, URISyntaxException {
       
        //AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        //QB Pixel 3 API 35
        //Actual automation code
        //Diff locators that appium supports > xpath,id, accessibiltyId,className,androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        String displayedAlertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(displayedAlertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("QuineeWifi");
        //For className, recommended to use AppiumBy and not By from Appium team
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        
    }
}
