package screens.login;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidLoginWithTokenScreen extends LoginWithTokenScreen {

    public AndroidLoginWithTokenScreen() {
        super(By.id("loginForm"));
    }

    @Override
    protected By getUsernameTxbLoc() {
        return By.id("usernameEditText");
    }

    @Override
    protected By getAccessTokenTxbLoc() {
        return By.id("passwordEditText");
    }

    @Override
    protected By getLoginBtnLoc() {
        return By.id("login");
    }

    @Override
    protected By getOpenInBrowserBtnLoc() {
        return By.id("browserLogin");
    }

    @Override
    protected By getShowPasswordBtnLoc() {
        return By.id("text_input_end_icon");
    }
}