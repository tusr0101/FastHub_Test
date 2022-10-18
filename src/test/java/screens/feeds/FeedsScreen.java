package screens.feeds;

import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public abstract class FeedsScreen extends Screen {

    protected FeedsScreen(By locator) {
        super(locator, "Feed container");
    }

    protected abstract By getFeedElementsLocator();

    @Step("Get feeds.")
    public List<FeedElement> getFeeds() {
        return getElementFactory().findElements(getFeedElementsLocator(), FeedElement.class);
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}