package steps;

import DataManagers.TestData;
import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.chrome.acceptTerms.AcceptTermsChromeScreen;
import screens.chrome.github.GithubLoginChromeScreen;
import screens.chrome.sync.SyncChromeScreen;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.toolbar.ToolBar;
import utils.DriverUtils;

public class CommonSteps {

    @Step("Login with Access Token.")
    public static void loginWithAccessToken(LoginWithScreen loginWithScreen, LoginWithTokenScreen loginScreen,
                                            ToolBar toolBar, String userName, String accessToken) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented.");
        loginWithScreen.tapAccessToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginScreen::isPresented),
                "Login with Access token Screen is not presented.");
        loginScreen.setUsername(userName);
        loginScreen.setPassword(accessToken);
        loginScreen.tapLoginWithToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(toolBar::isPresented),
                "Login failed. Tool bar is not presented.");
    }

    @Step("Open browser for login.")
    public static void openloginWithBrowser(LoginWithScreen loginWithScreen) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented.");
        loginWithScreen.tapLoginInBrowser();
    }

    @Step("Login with browser.")
    public static void loginWithBrowser(AcceptTermsChromeScreen acceptTermsChromeScreen,
                                        SyncChromeScreen syncChromeScreen, GithubLoginChromeScreen githubLoginChromeScreen,
                                        ToolBar toolBar, String userName, String accessToken){
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(acceptTermsChromeScreen::isPresented,
                "Chrome accept terms is not presented."));
        acceptTermsChromeScreen.tapAcceptTerms();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(syncChromeScreen::isPresented),
                "Chrome sync screen is not presented.");
        syncChromeScreen.tapDeclineSync();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(githubLoginChromeScreen::isPresented),
                "Github login page is not presented");
        githubLoginChromeScreen.setUsername(userName);
        githubLoginChromeScreen.setPassword(accessToken);
        githubLoginChromeScreen.tapSignIn();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(toolBar::isPresented),
                "Login failed. Tool bar is not presented.");
    }

    @Step("Clear {packageName} data. ")
    public static void clearBrowserData(String packageName) {
        DriverUtils.terminateApp(packageName);
        DriverUtils.clearAppData(packageName);
    }
}
