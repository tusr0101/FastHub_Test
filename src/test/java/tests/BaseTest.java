package tests;

import aquality.appium.mobile.application.Application;
import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.Steps;

public abstract class BaseTest {

    protected final Logger logger = AqualityServices.getLogger();
    //protected ISettingsFile settings = new JsonSettingsFile("settings.json");

    @BeforeMethod(description = "Run application.")
    protected void setUp(){
        AqualityServices.getApplication();
    }

    @AfterMethod
    public void tearDown(ITestResult result, ITestContext testContext) {
        if (AqualityServices.isApplicationStarted()){
            if (result.getStatus() == ITestResult.FAILURE) {
                Steps.saveScreenshot(getAndroidDriver());
            }
            getApplication().quit();
        }
    }

    protected Application getApplication(){
        return AqualityServices.getApplication();
    }

    protected AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getApplication().getDriver();
    }
}