package utils;

import aquality.appium.mobile.application.Application;
import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.openqa.selenium.Capabilities;
import org.testng.collections.Lists;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverUtils {

    private static final Logger logger = AqualityServices.getLogger();

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
        try {
            getAndroidDriver().startRecordingScreen(opt);
        } catch (org.openqa.selenium.WebDriverException e) {
            logger.warn(String.format("Screen recording is not available. %s", e.getMessage()));
        }
    }

    public static String stopRecordingScreen() {
        try {
            return getAndroidDriver().stopRecordingScreen();
        }
        catch (org.openqa.selenium.WebDriverException e) {
            logger.warn(String.format("Screen recording is not available. %s", e.getMessage()));
        }
        return null;
    }

    public static Capabilities getCapabilities() {
        return AqualityServices.getApplication().getDriver().getCapabilities();
    }

    public static void quit(){
        AqualityServices.getApplication().quit();
    }
}
