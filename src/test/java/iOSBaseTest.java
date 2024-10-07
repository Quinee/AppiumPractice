import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTest {
    public AppiumDriverLocalService service;
    public IOSDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException{
         
         service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//quineebhattacharjee//.nvm//versions//node//v19.9.0//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16");
        options.setApp("//Users//quineebhattacharjee//Desktop//UIKitCatalog.app");
        options.setPlatformVersion("18.0");

        //Appium tlks to WebDriver Agent and the agent talk to iOS app
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

         driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(),options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }

    public void longPress(WebElement ele){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) ele).getId());
        params.put("duration", 2.0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: touchAndHold", params);
    }

   
}
