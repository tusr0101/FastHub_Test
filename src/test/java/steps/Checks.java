package steps;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;

public class Checks {

    @Step("Check username.")
    public static void isUsernameCorrectCheck(ToolBar toolBar, NavigateMenu navigateMenu, String exceptedUsername) {
        toolBar.tapNavigateUp();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(navigateMenu::isPresented),
                "Navigate Menu is not presented.");
        Assert.assertEquals(navigateMenu.getUserName(), exceptedUsername,
                "Usernames are not equal.");
    }
}
