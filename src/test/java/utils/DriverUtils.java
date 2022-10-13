package utils;

import aquality.appium.mobile.application.Application;
import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.testng.collections.Lists;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverUtils {

    private DriverUtils() {}

    public static Application getApplication(){
        return AqualityServices.getApplication();
    }

    public static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) AqualityServices.getApplication().getDriver();
    }

    public static String getCurrentActivity() {
        return getAndroidDriver().currentActivity();
    }

    public static String getTestPackageName() {
        return (String) getAndroidDriver().getCapabilities().getCapability("appium:appPackage");
    }

    public static String getCurrentPackage() {
        return getAndroidDriver().getCurrentPackage();
    }

    public static void activateApp(String packageName) {
        getAndroidDriver().activateApp(packageName);
    }

    public static void terminateApp(String packageName) {
        getAndroidDriver().terminateApp(packageName);
    }

    public static void clearAppData(String packageName) {
        Map<String, Object> args = new HashMap<>();
        args.put("command", "pm clear");
        args.put("args", Lists.newArrayList(packageName));
        getAndroidDriver().executeScript("mobile: shell", args);
    }

    public static void enableShowTouches() {
        Map<String, Object> args = new HashMap<>();
        args.put("command", "settings put system show_touches");
        args.put("args", Lists.newArrayList("1"));
        getAndroidDriver().executeScript("mobile: shell", args);
    }

    public static void enableShowCoordinates() {
        Map<String, Object> args = new HashMap<>();
        args.put("command", "settings put system pointer_location");
        args.put("args", Lists.newArrayList("1"));
        getAndroidDriver().executeScript("mobile: shell", args);
    }

    public static void startRecordingScreen(Duration duration) {
        AndroidStartScreenRecordingOptions opt = new AndroidStartScreenRecordingOptions();
        opt.withTimeLimit(duration);
        getAndroidDriver().startRecordingScreen(opt);
    }

    public static String stopRecordingScreen() {
        return getAndroidDriver().stopRecordingScreen();
    }

    public static void quit(){
        AqualityServices.getApplication().quit();
    }
}
