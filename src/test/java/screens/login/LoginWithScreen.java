package screens.login;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public abstract class LoginWithScreen extends Screen {

    private final IButton accessTokenBtn;
    private final IButton loginInBrowserBtn;

    protected LoginWithScreen(By locator) {
        super(locator, "LoginWithScreen");
        accessTokenBtn = getElementFactory().getButton(getAccessTokenBtnLoc(), "AccessTokenBtn");
        loginInBrowserBtn = getElementFactory().getButton(getOpenInBrowserBtnLoc(), "LoginInBrowser");
    }

    protected abstract By getAccessTokenBtnLoc();

    protected abstract By getOpenInBrowserBtnLoc();

    @Step("Tap login in browser button.")
    public void tapLoginInBrowser() {
        loginInBrowserBtn.click();
    }
    @Step("Tap login with access token button.")
    public void tapAccessToken() {
        accessTokenBtn.click();
    }

    public boolean isPresented(){
        return accessTokenBtn.state().isExist();
    }
}
