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

@Test(suiteName = "Login tests", description = "Checking the ability to sing in to the application.")
public class LoginTests extends BaseTest{

    @Test(description = "Login with access token test.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginByAccessToken (){
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);

        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, toolBar, TestData.userName, TestData.accessToken);
        Checks.isUsernameCorrectCheck(toolBar, navigateMenu, TestData.realUserName);
    }

    @Test(description = "Login with access token test._2")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginByAccessToken_2 (){
        LoginWithScreen loginWithScreen = AqualityServices.getScreenFactory().getScreen(LoginWithScreen.class);
        LoginWithTokenScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginWithTokenScreen.class);
        ToolBar toolBar = AqualityServices.getScreenFactory().getScreen(ToolBar.class);
        NavigateMenu navigateMenu = AqualityServices.getScreenFactory().getScreen(NavigateMenu.class);

        CommonSteps.loginWithAccessToken(loginWithScreen, loginScreen, toolBar, TestData.userName, TestData.accessToken);
        Checks.isUsernameCorrectCheck(toolBar, navigateMenu, TestData.realUserName);
    }

}
// TODO:
//  1) сохранять лог файл в tearDown+
//  0) ДОБАВИТЬ ЕЩЕ 1 тест и проверить работу нескольких тестов+
//  2) перенести проверки в степы+
//  3) так же в степы вынести CommonSteps типа логина(но в этом тесте мб оставить?)+
//  4) разобраться почему не ставится описание кейса и имя из метода
//  5) скрины для каждого степа?+
//  6) создать pipeline в jenkins(заставить работать по автомату: сборка, запуск эмулятора и т.д)
//  7) реализовать больше тестов
