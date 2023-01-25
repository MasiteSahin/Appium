package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {
    @Test
    public void calculatorAddTest() throws MalformedURLException, InterruptedException {

        //DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","Pixel 3");
      // they are same line 13=14  caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        caps.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        //Set URL for the appium server

        URL url = new URL("http://localhost:4723/wd/hub");
        //Appium launch

        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,caps);

        Assert.assertEquals(driver.getPlatformName(),"android");
        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());

        Thread.sleep(4000);

        driver.closeApp();

    }
}
