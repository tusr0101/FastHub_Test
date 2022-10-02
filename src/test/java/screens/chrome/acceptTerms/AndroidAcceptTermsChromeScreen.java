package screens.chrome.acceptTerms;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidAcceptTermsChromeScreen extends AcceptTermsChromeScreen{

    public AndroidAcceptTermsChromeScreen() {
        super(By.id("com.android.chrome:id/tos_and_privacy"));
    }

    @Override
    protected By getAcceptTermsBtnLoc() {
        return By.id("com.android.chrome:id/terms_accept");
    }
}