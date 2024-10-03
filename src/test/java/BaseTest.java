import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException{
         UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("QB Pixel 3 API 35");
        options.setApp("//Users//quineebhattacharjee//Desktop//Learnings//AppiumJava//AppiumRS//AppiumPractice//AppiumRS//src//test//java//resources//ApiDemos-debug.apk");

         service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//quineebhattacharjee//.nvm//versions//node//v19.9.0//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

         driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
    public void longPress(WebElement ele){
            
((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    "elementId", ((RemoteWebElement) ele).getId(),
    "duration",2000
));
    }
}