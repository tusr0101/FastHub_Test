package steps;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;
import utils.DriverUtils;

public class Checks {

    @Step("Check username.")
    public static void isUsernameCorrectCheck(ToolBar toolBar, NavigateMenu navigateMenu, String exceptedUsername) {
        toolBar.tapNavigateUp();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(navigateMenu::isPresented),
                "Navigate Menu is not presented.");
        Assert.assertEquals(navigateMenu.getUserName(), exceptedUsername,
                "Usernames are not equal.");
    }
    @Step("Check browser package is open.")
    public static void isBrowserOpenCheck(String excepted_package) {
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(
                () -> DriverUtils.getCurrentPackage().equals(excepted_package), "Browser is not open."));
    }
}
