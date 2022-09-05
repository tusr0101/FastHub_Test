package screens.toolbar;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public abstract class ToolBar extends Screen {

    private final IButton navigateUpBtn;
    private final IButton notificationsBtn;
    private final IButton searchBtn;

    protected ToolBar(By locator) {
        super(locator, "Toolbar");
        navigateUpBtn = getElementFactory().getButton(getNavigateUpBtnLoc(), "Navigate Up");
        notificationsBtn = getElementFactory().getButton(getNotificationsBtnLoc(), "Notifications");
        searchBtn = getElementFactory().getButton(getSearchBtnLoc(), "Search");
    }

    protected abstract By getNavigateUpBtnLoc();

    protected abstract By getNotificationsBtnLoc();

    protected abstract By getSearchBtnLoc();

    @Step("Open Navigate menu.")
    public void tapNavigateUp() {
        navigateUpBtn.click();
    }

    @Step("Open notifications.")
    public void tapNotifications() {
        notificationsBtn.click();
    }
    @Step("Open search.")
    public void tapSearch() {
        searchBtn.click();
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
