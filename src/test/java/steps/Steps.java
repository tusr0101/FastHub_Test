package steps;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Steps {
    private static final Logger logger = AqualityServices.getLogger();

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveScreenshot(AndroidDriver driver) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        String replaceBase64 = screenshotBase64.replaceAll("\n","");
        return Base64.getDecoder().decode(replaceBase64.getBytes(StandardCharsets.UTF_8));
    }
}
