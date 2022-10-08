package steps;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.login.LoginWithTokenScreen;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;
import utils.DriverUtils;

public class Checks {

    @Step("Checking username.")
    public static void isUsernameCorrectCheck(ToolBar toolBar, NavigateMenu navigateMenu, String exceptedUsername) {
        toolBar.tapNavigateUp();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(navigateMenu::isPresented),
                "Navigate Menu is not presented.");
        Assert.assertEquals(navigateMenu.getUserName(), exceptedUsername,
                "Usernames are not equal.");
    }

    @Step("Checking login status.")
    public static void LoginCheck(ToolBar toolBar, boolean exceptedResult) {
        Assert.assertEquals(AqualityServices.getConditionalWait().waitFor(toolBar::isPresented), exceptedResult,
                String.format("Login check failed. excepted = %b", exceptedResult));
    }

    @Step("Checking access token visibility.")
    public static void isAccessTokenVisibleCheck(LoginWithTokenScreen loginScreen) {
        Assert.assertFalse(loginScreen.isPasswordHidden(), "Access Token is hidden.");
    }

    @Step("Checking browser package is open.")
    public static void isBrowserOpenCheck(String excepted_package) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(
                () -> DriverUtils.getCurrentPackage().equals(excepted_package), "Browser is not open."));
    }
}
