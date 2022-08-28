package screens;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidLoginScreen extends LoginScreen {

    public AndroidLoginScreen() {
        super(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
    }

    @Override
    protected By getUsernameTxbLoc() {
        return By.id("usernameEditText");
    }

    @Override
    protected By getPasswordTxbLoc() {
        return By.id("passwordEditText");
    }

    @Override
    protected By getLoginBtnLoc() {
        return By.id("login");
    }

    @Override
    protected By getAccessTokenBtn() {
        return By.id("accessToken");
    }
}