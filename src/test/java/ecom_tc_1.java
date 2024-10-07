import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ecom_tc_1 extends BaseTest{

    @Test
    public void FillForm(){
        //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("QuineeB");
        //To hide the keyboard which comes up while typing
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //To handle Toast msgs which gives up when we do not add name. So, we have commented LOC10
        String displayedToastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(displayedToastMsg, "Please enter your name");

    }
    
}
