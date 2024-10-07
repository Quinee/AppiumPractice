import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ecom_tc_3 extends BaseTest{

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

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();



        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        //String productNameInCart = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        //Assert.assertEquals(productNameInCart, "Jordan 6 Rings");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        webDriverWait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        int productSizeInCart = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double totalSum=0;
        for(int i = 0;i<productSizeInCart;i++){
            String amt = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            double amountPrice = Double.parseDouble(amt.substring(1));
            totalSum = totalSum + amountPrice;
        }

        String totalAmtString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double totalAmtDouble = Double.parseDouble(totalAmtString.substring(1));

        Assert.assertEquals(totalAmtDouble, totalSum);

        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPress(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);
       

    }
    
}
