package tests;

import DataManagers.TestData;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;

public class LoginTest extends BaseTest{
    private final LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
    private final LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
    private final ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
    private final NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);

    @Test
    public void testLoginByAccessToken (){
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginWithScreen::isPresented),
                "Login With Screen is not presented");
        loginWithScreen.tapAccessToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(loginScreen::isPresented),
                "Login with Access token Screen is not presented");
        loginScreen.setUsername(TestData.userName);
        loginScreen.setPassword(TestData.accessToken);
        loginScreen.tapLoginWithToken();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(toolBar::isPresented),
                "Login failed. Tool bar is not presented");
        toolBar.tapNavigateUp();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(navigateMenu::isPresented),
                "Navigate Menu is not presented");
        Assert.assertEquals(navigateMenu.getUserName(), TestData.realUserName, "Usernames are not equal");
    }

    public void noNeedNow(){
        //AndroidDriver s = (AndroidDriver) AqualityServices.getApplication().getDriver();
        //TODO: delete this
    }
}
