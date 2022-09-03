package screens.navigateMenu;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidNavigateMenu extends NavigateMenu {

    public AndroidNavigateMenu() {
        super(By.id("extrasNav"));
    }

    @Override
    protected By getUserNameTxtLoc() {
        return By.id("navUsername");
    }
}