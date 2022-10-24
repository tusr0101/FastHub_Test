package screens.toolbar;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;
import utils.DriverUtils;

public abstract class ToolBar extends Screen {

    private final IButton navigateUpBtn;
    private final IButton notificationsBtn;
    private final IButton searchBtn;
    private final ITextBox searchTxtField;

    protected ToolBar(By locator) {
        super(locator, "Toolbar");
        navigateUpBtn = getElementFactory().getButton(getNavigateUpBtnLoc(), "Navigate Up");
        notificationsBtn = getElementFactory().getButton(getNotificationsBtnLoc(), "Notifications");
        searchBtn = getElementFactory().getButton(getSearchBtnLoc(), "Search");
        searchTxtField = getElementFactory().getTextBox(getSearchTxtField(), "Search field");
    }

    protected abstract By getNavigateUpBtnLoc();

    protected abstract By getNotificationsBtnLoc();

    protected abstract By getSearchBtnLoc();

    protected abstract By getSearchTxtField();

    @Step("Open Navigate menu.")
    public void tapNavigateUp() {
        navigateUpBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Open notifications.")
    public void tapNotifications() {
        notificationsBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Tap search.")
    public void tapSearch() {
        searchBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Type text into search field \"{text}\"")
    public void typeSearch(String text) {
        searchTxtField.sendKeys(text);
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
