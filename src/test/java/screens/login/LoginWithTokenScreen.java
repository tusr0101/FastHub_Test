package screens.login;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AttachUtils;
import utils.DriverUtils;

public abstract class LoginWithTokenScreen extends Screen {

    private final ITextBox usernameTxb;
    private final ITextBox passwordTxb;
    private final IButton loginBtn;
    private final IButton loginInBrowserBtn;
    private final IButton showPasswordBtn;

    protected LoginWithTokenScreen(By locator) {
        super(locator, "LoginScreen");
        usernameTxb = getElementFactory().getTextBox(getUsernameTxbLoc(), "UsernameText");
        passwordTxb = getElementFactory().getTextBox(getAccessTokenTxbLoc(), "AccessTokenText");
        loginBtn = getElementFactory().getButton(getLoginBtnLoc(), "LoginBtn");
        loginInBrowserBtn = getElementFactory().getButton(getOpenInBrowserBtnLoc(), "LoginInBrowser");
        showPasswordBtn = getElementFactory().getButton(getShowPasswordBtnLoc(), "ShowPassword");
    }

    protected abstract By getUsernameTxbLoc();

    protected abstract By getAccessTokenTxbLoc();

    protected abstract By getLoginBtnLoc();

    protected abstract By getOpenInBrowserBtnLoc();

    protected abstract By getShowPasswordBtnLoc();

    @Step("Type username=\"{username}\".")
    public LoginWithTokenScreen setUsername(final String username) {
        usernameTxb.sendKeys(username);
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return this;
    }

    @Step("Type password=\"{password}\".")
    public LoginWithTokenScreen setPassword(final String password) {
        passwordTxb.sendKeys(password);
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return this;
    }

    @Step("Tap login button.")
    public void tapLoginWithToken() {
        loginBtn.click();
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Tap login in browser button.")
    public void tapLoginInBrowser() {
        loginInBrowserBtn.click();
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Tap show accessToken.")
    public void tapShowAccessToken() {
        showPasswordBtn.click();
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Is password hidden.")
    public boolean isPasswordHidden(){
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return passwordTxb.getAttribute("password").equals("true");
    }

    public boolean isPresented(){
        return passwordTxb.state().isExist();
    }
}