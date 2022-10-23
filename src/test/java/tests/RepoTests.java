package tests;

import DataManagers.TestData;
import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.login.LoginWithScreen;
import screens.login.LoginWithTokenScreen;
import screens.navigateMenu.NavigateMenu;
import screens.toolbar.ToolBar;
import steps.Checks;
import steps.CommonSteps;

@Test(testName = "04.Repositories Tests.")
public class RepoTests extends BaseTest {

    @Test(description = "01.Repositories of user should be available.")
    @Severity(SeverityLevel.NORMAL)
    public void testRepositoriesOfUserShouldBeAvailable() {
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, TestData.userName, TestData.accessToken);
        Checks.LoginCheck(toolBar, true);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);
        CommonSteps.openRepositories(toolBar, navigateMenu);
        Checks.repositoriesOfUserCheck(TestData.exceptedRepoName, TestData.exceptedRepoAccess, TestData.repoIndex);
    }
}