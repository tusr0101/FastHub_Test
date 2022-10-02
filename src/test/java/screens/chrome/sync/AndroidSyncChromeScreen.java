package screens.chrome.sync;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidSyncChromeScreen extends SyncChromeScreen {

    public AndroidSyncChromeScreen() {
        super(By.id("com.android.chrome:id/signin_title"));
    }

    @Override
    protected By getDeclineSyncBtnLoc() {
        return By.id("com.android.chrome:id/negative_button");
    }
}