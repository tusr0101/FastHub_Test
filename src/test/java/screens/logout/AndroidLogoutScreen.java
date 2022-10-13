package screens.logout;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidLogoutScreen extends LogoutScreen {

    public AndroidLogoutScreen() {
        super(By.xpath("//*[contains(@resource-id, 'title') and matches(@text, 'Logout')]"));
    }

    @Override
    protected By getConfirmLogoutBtnLoc() {
        return By.id("ok");
    }

}