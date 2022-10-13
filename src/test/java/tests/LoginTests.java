package tests;

import DataManagers.TestData;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.chrome.acceptTerms.AcceptTermsChromeScreen;
import screens.chrome.github.GithubLoginChromeScreen;
import screens.chrome.sync.SyncChromeScreen;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.logout.LogoutScreen;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;
import steps.Checks;
import steps.CommonSteps;
import utils.RandomUtils;

@Test(testName = "Checking the ability to sing in to the application.")
public class LoginTests extends BaseTest{

    @Test(description = "01.Login with access token test.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginByAccessToken () {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);

        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName, TestData.accessToken);
        Checks.LoginCheck(toolBar, true);
        Checks.isUsernameCorrectCheck(toolBar, navigateMenu, TestData.userName);
    }

    @Test(description = "02.Login with browser open browser.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithBrowserShouldOpenBrowser() {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        CommonSteps.openLoginWithBrowser(loginWithScreen);
        Checks.isBrowserOpenCheck(TestData.browserPackage);
    }

    @Test(description = "03.Login with browser.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithBrowser() {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        AcceptTermsChromeScreen acceptTermsChromeScreen = AqualityServices.getScreenFactory().getScreen(AcceptTermsChromeScreen.class);
        SyncChromeScreen syncChromeScreen = AqualityServices.getScreenFactory().getScreen(SyncChromeScreen.class);
        GithubLoginChromeScreen githubLoginChromeScreen = AqualityServices.getScreenFactory().getScreen(GithubLoginChromeScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);

        CommonSteps.openLoginWithBrowser(loginWithScreen);
        CommonSteps.loginWithBrowser(acceptTermsChromeScreen, syncChromeScreen, githubLoginChromeScreen,
                TestData.userName, TestData.password);
        Checks.LoginCheck(toolBar, true);
        Checks.isUsernameCorrectCheck(toolBar, navigateMenu, TestData.userName);
    }

    @Test(description = "04.Show access token function test.")
    @Severity(SeverityLevel.NORMAL)
    public void testShowPasswordShouldShowPassword() {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        CommonSteps.typeAndShowAccessToken(loginWithScreen, loginScreen, TestData.accessToken);
        Checks.isAccessTokenVisibleCheck(loginScreen);
    }

    @Test(description = "05.Login with invalid access token test.")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithInvalidCredentialsIsImpossible () {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);

        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName,
                RandomUtils.getRandomString(TestData.randomTokenLength));
        Checks.LoginCheck(toolBar, false);
    }

    @Test(description = "06.Logout function test.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutFunction () {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);
        LogoutScreen logoutScreen = AqualityServices.getScreenFactory().getScreen(LogoutScreen.class);

        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName, TestData.accessToken);
        Checks.LoginCheck(toolBar, true);
        CommonSteps.logoutFromApplication(toolBar, navigateMenu, logoutScreen);
        loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login with screen is not presented after logout.");
    }

    @Test(description = "07.The session is saved after the application is closed.")
    @Severity(SeverityLevel.CRITICAL)
    public void testSessionShouldBeSavedAfterClosing () {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName, TestData.accessToken);
        Checks.LoginCheck(toolBar, true);

        CommonSteps.closeAndOpenTestApp();
        toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);
        Checks.LoginCheck(toolBar, true);
        Checks.isUsernameCorrectCheck(toolBar, navigateMenu, TestData.userName);
    }
}
