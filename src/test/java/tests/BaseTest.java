package tests;

import DataManagers.TestData;
import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.filter.ThresholdFilter;
import org.apache.logging.log4j.core.appender.WriterAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.CommonSteps;
import utils.AllureUtils;
import utils.DriverUtils;

import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    protected final Logger logger = AqualityServices.getLogger();
    protected Writer consoleWriter;
    protected Appender testAppender;

    private void setUpMethodAppender(String test_name) {
        consoleWriter = new StringWriter();
        testAppender = WriterAppender.newBuilder().setName(test_name)
                .setTarget(consoleWriter)
                .setLayout(PatternLayout.newBuilder().withPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n").build())
                .setFilter(ThresholdFilter.createFilter(Level.INFO, Filter.Result.ACCEPT, Filter.Result.DENY))
                .build();
        logger.addAppender(testAppender);
    }

    @BeforeSuite
    protected void setUpSuite(){
        AllureUtils.createEnvironmentProperties();
    }

    @BeforeMethod(description = "Run application.")
    protected void setUp(Method method){
        setUpMethodAppender(method.getName());
        logger.addAppender(testAppender);
        DriverUtils.getApplication();
        CommonSteps.clearBrowserData(TestData.browserPackage);
        DriverUtils.enableShowTouches();
        DriverUtils.enableShowCoordinates();
        DriverUtils.startRecordingScreen(Duration.ofSeconds(TestData.screenRecordingTimeLimit));
    }

    @AfterMethod(description = "Close app. Save attachments.")
    public void tearDown() {
        String record = DriverUtils.stopRecordingScreen();
        CommonSteps.clearBrowserData(TestData.browserPackage);

        if (AqualityServices.isApplicationStarted()){
            DriverUtils.quit();
        }
        if (record != null) {
            AllureUtils.saveScreenRecord(record);
        }
        AllureUtils.saveTestLogs(consoleWriter.toString());
        logger.removeAppender(testAppender);
    }
}