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

    @Override
    protected By getProfileBtnLoc() {
        return By.xpath("//android.widget.LinearLayout[contains(@content-desc, \"Profile\")]");
    }

    @Override
    protected By getLogoutBtnLoc() {
        return By.id("logout");
    }
}