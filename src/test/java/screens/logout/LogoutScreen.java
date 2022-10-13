package screens.logout;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AttachUtils;
import utils.DriverUtils;

public abstract class LogoutScreen extends Screen {

    private final IButton confirmLogoutBtn;

    protected LogoutScreen(By locator) {
        super(locator, "Logout Screen");
        confirmLogoutBtn = getElementFactory().getButton(getConfirmLogoutBtnLoc(), "Confirm Logout Btn");
    }

    protected abstract By getConfirmLogoutBtnLoc();

    @Step("Confirm logout.")
    public void tapOk() {
        confirmLogoutBtn.click();
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
