package screens.chrome.github;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AttachUtils;
import utils.DriverUtils;

public abstract class GithubLoginChromeScreen extends Screen {
    private final ITextBox usernameTxb;
    private final ITextBox passwordTxb;
    private final IButton signInBtn;

    protected GithubLoginChromeScreen(By locator) {
        super(locator, "Github login page");
        usernameTxb = getElementFactory().getTextBox(getUsernameTxbLoc(), "UsernameText");
        passwordTxb = getElementFactory().getTextBox(getPasswordTxbLoc(), "PasswordText");
        signInBtn = getElementFactory().getButton(getSignInBtnLoc(), "SignInButton");
    }

    protected abstract By getUsernameTxbLoc();

    protected abstract By getPasswordTxbLoc();

    protected abstract By getSignInBtnLoc();

    @Step("Type username=\"{username}\".")
    public GithubLoginChromeScreen setUsername(final String username) {
        usernameTxb.sendKeys(username);
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return this;
    }
    @Step("Type password=\"{password}\".")
    public GithubLoginChromeScreen setPassword(final String password) {
        passwordTxb.sendKeys(password);
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return this;
    }

    @Step("Sign in with Github.")
    public void tapSignIn() {
        signInBtn.click();
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
