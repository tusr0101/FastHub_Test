package screens.login;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

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

    public LoginWithTokenScreen setUsername(final String username) {
        usernameTxb.sendKeys(username);
        return this;
    }

    public LoginWithTokenScreen setPassword(final String password) {
        passwordTxb.sendKeys(password);
        return this;
    }

    public void tapLoginWithToken() {
        loginBtn.click();
    }

    public void tapLoginInBrowser() {
        loginInBrowserBtn.click();
    }

    public boolean isPasswordVisible(){
        return passwordTxb.getAttribute("password").equals("false");
    }

    public boolean isPresented(){
        return passwordTxb.state().isExist();
    }
}