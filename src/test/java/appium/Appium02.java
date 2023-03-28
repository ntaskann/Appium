package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 29");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\asus\\IdeaProjects\\QAAppium\\src\\test\\java\\app\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
//        MobileElement okButton = driver.findElementByXPath("//*[@text='OK']");
//        okButton.click();

        MobileElement anasayfaBaslik = driver.findElementById("android:id/title");
        Assert.assertTrue(anasayfaBaslik.isDisplayed());

        MobileElement addGestureButton = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addGestureButton.click();

        Thread.sleep(2000);
        MobileElement nameTextBox = driver.findElementByXPath("//*[@class='android.widget.EditText']");
        nameTextBox.sendKeys("Appium2");

        Thread.sleep(1000);
        MobileElement bosluk = driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay");
        bosluk.click();

        Thread.sleep(1000);
        MobileElement doneButton = driver.findElementById("com.davemac327.gesture.tool:id/done");
        doneButton.click();


    }
}
