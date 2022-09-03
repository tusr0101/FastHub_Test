package screens.login;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidLoginWithScreen extends LoginWithScreen {

    public AndroidLoginWithScreen() {
        super(By.id("loginForm"));
    }

    @Override
    protected By getAccessTokenBtnLoc() {
        return By.id("accessToken");
    }

    @Override
    protected By getOpenInBrowserBtnLoc() {
        return By.id("browserLogin");
    }
}