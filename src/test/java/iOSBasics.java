import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSBasics extends iOSBaseTest{

    @Test
    public void IosBasicsTest() throws InterruptedException{
        //Xpath,classname,IOS,iosClassChain,IOSPredicateString, accessibilityId and Id
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //iOSChain is slightly faster than xpath
        //Syntax of writing iOSClassChain selector

        //xpath >          //XCUIElementTypeStaticText[@name="Alert Views"]
        //iOSClassChain > **/XCUIElementTypeStaticText[`name == "Alert Views"`]
        //Syntax > **/tagName[`attribute=='value'`]
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")).click();
        //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        //driver.findElement(AppiumBy.accessibilityId("OK")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name BEGINSWITH[c] 'Confirm'"))
//BEGINSWITH[c] make it case sensitive, ENDSWITH, even a single will also do like type == 'XCUIElementTypeStaticText'
String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH 'A message'")).getText();
System.out.println(text);
driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();
    }
    
}
