package tests;

import DataManagers.TestData;
import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.toolbar.ToolBar;
import steps.Checks;
import steps.CommonSteps;

@Test(testName = "03.Search Tests.")
public class SearchTests extends BaseTest {

    @Test(description = "01.Search function test.")
    @Severity(SeverityLevel.CRITICAL)
    public void testSearchFunction() {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName, TestData.accessToken);
        Checks.LoginCheck(toolBar, true);
        CommonSteps.searchFor(toolBar, TestData.searchFor);
        Checks.searchReturnsCorrectResultCheck(TestData.exceptedSearchFor, TestData.searchResultIndex);
    }
}