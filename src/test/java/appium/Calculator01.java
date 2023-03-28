package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Calculator01 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //Uygulama bilgileri
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        MobileElement sayi0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        MobileElement sayi1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement sayi2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement sayi3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement sayi4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement sayi5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement sayi6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement sayi7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement sayi8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement sayi9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        //accessibility id varsa bunu kullan ->findElementByAccessibilityId(" ")
        MobileElement esittir = driver.findElementByAccessibilityId("equals");
        MobileElement silme = driver.findElementByAccessibilityId("delete");
        MobileElement bolme = driver.findElementByAccessibilityId("divide");
        MobileElement carpma = driver.findElementByAccessibilityId("multiply");
        MobileElement cikarma = driver.findElementByAccessibilityId("minus");
        MobileElement toplama = driver.findElementByAccessibilityId("plus");

        // 54 ile 96'yı toplayarak sonucu assert ediniz
        sayi5.click();
        sayi4.click();
        toplama.click();
        sayi9.click();
        sayi6.click();
        esittir.click();

        MobileElement sonuc = driver.findElementById("com.google.android.calculator:id/result_final");
        String expectedResult = "150";

        assertEquals(expectedResult, sonuc.getText());
        assertTrue(sonuc.getText().contains("150"));


    }
}
