package tests;

import DataManagers.TestData;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;

@Test(testName = "Login tests", description = "Checking the ability to sing in to the application.")
public class LoginTests extends BaseTest{

    private final LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
    private final LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
    private final ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
    private final NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);

    @Test(testName = "Login with access token test.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginByAccessToken (){
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented.");
        loginWithScreen.tapAccessToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginScreen::isPresented),
                "Login with Access token Screen is not presented.");
        loginScreen.setUsername(TestData.userName);
        loginScreen.setPassword(TestData.accessToken);
        loginScreen.tapLoginWithToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(toolBar::isPresented),
                "Login failed. Tool bar is not presented.");
        toolBar.tapNavigateUp();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(navigateMenu::isPresented),
                "Navigate Menu is not presented.");
        Assert.assertEquals(navigateMenu.getUserName(), TestData.realUserName,
                "Usernames are not equal.");
    }
}
