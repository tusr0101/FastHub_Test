package tests;

import DataManagers.TestData;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTest extends BaseTest{
    private final LoginScreen loginScreen = AqualityServices.getScreenFactory().getScreen(LoginScreen.class);

    @Test
    public void testLoginByAccessToken (){
        loginScreen.tapAccessToken();
        loginScreen.setUsername(TestData.userName);
        loginScreen.setPassword(TestData.accessToken);
        loginScreen.tapLogin();
        System.out.println("");
        //Assert.assertNotNull(loginScreen, "Screen must be resolved from factory");
    }
}
