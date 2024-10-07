import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ecom_tc_2 extends BaseTest{

    @Test
    public void FillForm() throws InterruptedException{
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("QuineeB");
        //To hide the keyboard which comes up while typing
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //To handle Toast msgs which gives up when we do not add name. So, we have commented LOC10
       // String displayedToastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //Assert.assertEquals(displayedToastMsg, "Please enter your name");
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));

        int productSize = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<productSize;i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase("Jordan 6 Rings"))
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        String productNameInCart = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(productNameInCart, "Jordan 6 Rings");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        webDriverWait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
       

    }
    
}
