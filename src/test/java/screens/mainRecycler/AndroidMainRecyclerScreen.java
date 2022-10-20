package screens.mainRecycler;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidMainRecyclerScreen extends MainRecyclerScreen {

    public AndroidMainRecyclerScreen() {
        super(By.xpath("//*[contains(@resource-id, 'recycler')]"));
    }

    @Override
    protected By getFeedElementsLocator() {
        return By.xpath("//*[contains(@resource-id, 'recycler')]/*[contains(@class, 'Relative')]");
    }
}