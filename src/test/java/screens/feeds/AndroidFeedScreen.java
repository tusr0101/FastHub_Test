package screens.feeds;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidFeedScreen extends FeedsScreen {

    public AndroidFeedScreen() {
        super(By.xpath("//*[contains(@resource-id, 'recycler')]"));
    }

    @Override
    protected By getFeedElementsLocator() {
        return By.xpath("//*[contains(@resource-id, 'recycler')]/*[contains(@class, 'Relative')]");
    }
}