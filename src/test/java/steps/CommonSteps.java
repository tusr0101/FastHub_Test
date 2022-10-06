package steps;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.chrome.acceptTerms.AcceptTermsChromeScreen;
import screens.chrome.github.GithubLoginChromeScreen;
import screens.chrome.sync.SyncChromeScreen;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import utils.DriverUtils;

public class CommonSteps {

    @Step("Login with Access Token.")
    public static void loginWithAccessToken(LoginWithScreen loginWithScreen, LoginWithTokenScreen loginScreen,
                                            String userName, String accessToken) {
        openLoginWithAccessToken(loginWithScreen, loginScreen);
        loginScreen.setUsername(userName);
        loginScreen.setPassword(accessToken);
        loginScreen.tapLoginWithToken();
    }

    @Step("Open login with Access Token screen.")
    public static void openLoginWithAccessToken(LoginWithScreen loginWithScreen, LoginWithTokenScreen loginScreen) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented.");
        loginWithScreen.tapAccessToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginScreen::isPresented),
                "Login with Access token Screen is not presented.");
    }

    @Step("Type and show password.")
    public static void typeAndShowAccessToken(LoginWithScreen loginWithScreen, LoginWithTokenScreen loginScreen,
                                              String accessToken) {
        openLoginWithAccessToken(loginWithScreen, loginScreen);
        loginScreen.setPassword(accessToken);
        loginScreen.tapShowAccessToken();
    }

    @Step("Open browser for login.")
    public static void openLoginWithBrowser(LoginWithScreen loginWithScreen) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented.");
        loginWithScreen.tapLoginInBrowser();
    }

    @Step("Login with browser.")
    public static void loginWithBrowser(AcceptTermsChromeScreen acceptTermsChromeScreen,
                                        SyncChromeScreen syncChromeScreen, GithubLoginChromeScreen githubLoginChromeScreen,
                                        String userName, String accessToken){
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
    }

    @Step("Clear {packageName} data. ")
    public static void clearBrowserData(String packageName) {
        DriverUtils.terminateApp(packageName);
        DriverUtils.clearAppData(packageName);
    }
}
