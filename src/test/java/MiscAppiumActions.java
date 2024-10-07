import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
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

public class MiscAppiumActions extends BaseTest{
    @Test
    public void MiscAppiumActionsTest() throws InterruptedException  {
        //Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
            "intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
   
));
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        //Use the below if u want to check for orientation
       // DeviceRotation landScape = new DeviceRotation(0,0,90);
        //driver.rotate(landScape);

        driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        String displayedAlertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(displayedAlertTitle, "WiFi settings");

        //Copy to clipboard - paste it in Clipboard
        driver.setClipboardText("QuineeWifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        //For className, recommended to use AppiumBy and not By from Appium team
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));


        


        
        
    }
}
