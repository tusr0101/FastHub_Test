package screens.chrome.sync;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;
import utils.DriverUtils;

public abstract class SyncChromeScreen extends Screen {

    private final IButton declineSyncBtn;

    protected SyncChromeScreen(By locator) {
        super(locator, "Chrome Turn on sync screen");
        declineSyncBtn = getElementFactory().getButton(getDeclineSyncBtnLoc(), "Decline sync");
    }

    protected abstract By getDeclineSyncBtnLoc();

    @Step("Decline Chrome sync.")
    public void tapDeclineSync() {
        declineSyncBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
