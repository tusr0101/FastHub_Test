package screens.navigateMenu;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;
import utils.DriverUtils;

public abstract class NavigateMenu extends Screen {

    private final ITextBox userName;
    private final IButton profileBtn;
    private final IButton logoutBtn;
    private final IButton reposBtn;

    protected NavigateMenu(By locator) {
        super(locator, "Navigate Menu");
        userName = getElementFactory().getTextBox(getUserNameTxtLoc(), "Username");
        profileBtn = getElementFactory().getButton(getProfileBtnLoc(), "ProfileBtn");
        logoutBtn = getElementFactory().getButton(getLogoutBtnLoc(), "LogoutBtn");
        reposBtn = getElementFactory().getButton(getRepositoriesBtnLoc(), "ReposBtn");
    }

    protected abstract By getUserNameTxtLoc();

    protected abstract By getProfileBtnLoc();

    protected abstract By getLogoutBtnLoc();

    protected abstract By getRepositoriesBtnLoc();

    @Step("Get Username")
    public String getUserName(){
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return userName.getText();
    }

    @Step("Open profile in navigation menu.")
    public void tapProfile(){
        profileBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Open repositories")
    public void tapRepositories() {
        reposBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    @Step("Logout from app.")
    public void tapLogout(){
        logoutBtn.click();
        AllureUtils.saveScreenshot(DriverUtils.getAndroidDriver());
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
