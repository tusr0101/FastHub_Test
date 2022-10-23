package steps;

import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.mainRecycler.RecyclerElement;
import screens.mainRecycler.MainRecyclerScreen;
import screens.login.LoginWithTokenScreen;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;
import utils.DriverUtils;

import java.util.List;

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

    @Step("Checking Main Recycler is not empty.")
    public static MainRecyclerScreen getRecyclerIsNotEmptyCheck() {
        Assert.assertFalse(AqualityServices.getConditionalWait().waitFor(
                ()->AqualityServices.getScreenFactory().getScreen(MainRecyclerScreen.class).getElements().isEmpty()),
                "Recycler is empty.");
        return AqualityServices.getScreenFactory().getScreen(MainRecyclerScreen.class);
    }

    @Step("Checking search results.")
    public static void searchReturnsCorrectResultCheck(String exceptedSearchFor, int exceptedIndex) {
        MainRecyclerScreen mainRecyclerScreen = getRecyclerIsNotEmptyCheck();
        List<RecyclerElement> elements = mainRecyclerScreen.getElements();
        Assert.assertEquals(elements.get(exceptedIndex).getTitle(), exceptedSearchFor, "Search result is not correct.");
    }

    @Step("Checking list of user repositories.")
    public static void repositoriesOfUserCheck(String exceptedRepoName, String exceptedRepoAccess, int exceptedIndex) {
        MainRecyclerScreen mainRecyclerScreen = getRecyclerIsNotEmptyCheck();
        List<RecyclerElement> elements = mainRecyclerScreen.getElements();
        String[] title = elements.get(exceptedIndex).getTitle().split("\\s+");
        Assert.assertEquals(title[1], exceptedRepoAccess, "Repository name is not correct.");
        Assert.assertEquals(title[2], exceptedRepoName, "Repository name is not correct");
    }
}
