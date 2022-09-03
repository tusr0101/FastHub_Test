package tests;

import aquality.appium.mobile.application.Application;
import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected final Logger logger = AqualityServices.getLogger();
    //protected ISettingsFile settings = new JsonSettingsFile("settings.json");

    @BeforeMethod
    protected void setUp(){
        AqualityServices.getApplication();
    }

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isApplicationStarted()){
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