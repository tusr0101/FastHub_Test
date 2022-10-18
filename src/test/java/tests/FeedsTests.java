package tests;

import DataManagers.TestData;
import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.feeds.FeedsScreen;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.toolbar.ToolBar;
import steps.Checks;
import steps.CommonSteps;

@Test(testName = "02.Feeds Tests.")
public class FeedsTests extends BaseTest {

    @Test(description = "01.Feeds should be available test.")
    @Severity(SeverityLevel.CRITICAL)
    public void testFeedsShouldBeAvailable() {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName, TestData.accessToken);
        Checks.LoginCheck(toolBar, true);
        FeedsScreen feedsScreen = AqualityServices.getScreenFactory().getScreen(FeedsScreen.class);
        Checks.feedIsNotEmptyCheck(feedsScreen);
    }
}