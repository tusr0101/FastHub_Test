package screens.chrome.github;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidGithubLoginChromeScreen extends GithubLoginChromeScreen {

    public AndroidGithubLoginChromeScreen() {
        super(By.xpath("//*[@resource-id='login']"));
    }

    @Override
    protected By getUsernameTxbLoc() {
        return By.xpath("//*[@resource-id='login_field']");
    }

    @Override
    protected By getPasswordTxbLoc() {
        return By.xpath("//*[@resource-id='password']");
    }

    @Override
    protected By getSignInBtnLoc() {
        // contains(text(), 'Sign in') does not work
        // org.eclipse.wst.xml.xpath2.processor.DynamicError: Value does not match a required type.
        return By.xpath("//*[contains(@class, 'Button') and matches(@text, 'Sign')]");
    }
}