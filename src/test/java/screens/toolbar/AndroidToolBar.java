package screens.toolbar;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidToolBar extends ToolBar {

    public AndroidToolBar() {
        super(By.id("toolbar"));
    }

    @Override
    protected By getNavigateUpBtnLoc() {
        return By.xpath("//android.widget.ImageButton[contains(@content-desc, \"Navigate up\")]");
    }

    @Override
    protected By getNotificationsBtnLoc() {
        return By.id("notifications");
    }

    @Override
    protected By getSearchBtnLoc() {
        return By.id("search");
    }

    @Override
    protected By getSearchTxtField() {
        return By.id("searchEditText");
    }

}