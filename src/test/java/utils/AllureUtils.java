package utils;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class AllureUtils {
    private static final Logger logger = AqualityServices.getLogger();

    private AllureUtils() {}

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveScreenshot(AndroidDriver driver) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        String replaceBase64 = screenshotBase64.replaceAll("\n","");
        return Base64.getDecoder().decode(replaceBase64.getBytes(StandardCharsets.UTF_8));
    }

    @Attachment(value = "Logs", type = "text")
    public static String saveTestLogs(String testLogs){
        return testLogs;
    }

    @Attachment(value = "ScreenRecord", type = "video/mp4", fileExtension = ".mp4")
    public static byte[] saveScreenRecord(String recordBase64) {
        return Base64.getDecoder().decode(recordBase64.getBytes(StandardCharsets.UTF_8));
    }

    private static Properties collectEnvironmentInfo(){
        Capabilities caps = DriverUtils.getCapabilities();
        Properties props = new Properties();
        props.put("Device_name", caps.getCapability("appium:deviceName"));
        props.put("Platform", caps.getCapability("platformName").toString());
        props.put("Platform_version", caps.getCapability("appium:platformVersion"));
        props.put("Platform_API_level", Long.toString((long) caps.getCapability("appium:deviceApiLevel")));
        props.put("udid", caps.getCapability("appium:udid"));
        props.put("Screen_size", caps.getCapability("appium:deviceScreenSize"));
        props.put("package_name", DriverUtils.getTestPackageName());
        props.put("Appium_IP", AqualityServices.getApplication().getDriver().getRemoteAddress().toString());
        return props;
    }

    public static void createEnvironmentProperties() {
        try{
            Properties props = collectEnvironmentInfo();

            String work_dir = System.getProperty("user.dir");
            String sep = System.getProperty("file.separator");
            Path allureResultsPath = Paths.get(work_dir, sep, "allure-results");
            Path envPath = Paths.get(allureResultsPath.toString(), "environment.properties");
            Files.createDirectories(allureResultsPath);

            File envFile = new File(envPath.toUri());
            FileOutputStream outputStrem = new FileOutputStream(envFile);
            props.store(outputStrem, "Auto generated Test environment information file.");
            outputStrem.close();
            logger.info(String.format("Allure environment file was created: \"%s\"", envPath));
        }
        catch (IOException e){
            logger.warn(String.format("Can't create Allure environment.properties file. %s", e.getMessage()));
        }
    }
}
