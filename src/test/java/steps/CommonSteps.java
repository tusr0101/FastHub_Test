package steps;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.toolbar.ToolBar;

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
    public static void loginWithBrowser(LoginWithScreen loginWithScreen) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented.");
        loginWithScreen.tapLoginInBrowser();
    }

}
