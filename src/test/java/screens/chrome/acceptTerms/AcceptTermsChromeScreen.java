package screens.chrome.acceptTerms;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AttachUtils;
import utils.DriverUtils;

public abstract class AcceptTermsChromeScreen extends Screen {

    private final IButton acceptTermsBtn;

    protected AcceptTermsChromeScreen(By locator) {
        super(locator, "Chrome Accept terms screen");
        acceptTermsBtn = getElementFactory().getButton(getAcceptTermsBtnLoc(), "Accept terms");
    }

    protected abstract By getAcceptTermsBtnLoc();

    @Step("Accept Chrome terms.")
    public void tapAcceptTerms() {
        acceptTermsBtn.click();
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
