package utils;

import aquality.appium.mobile.application.Application;
import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.android.AndroidDriver;

public class DriverUtils {

    private DriverUtils() {}

    public static Application getApplication(){
        return AqualityServices.getApplication();
    }
    public static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) AqualityServices.getApplication().getDriver();
    }

    public static void quit(){
        AqualityServices.getApplication().quit();
    }
}
