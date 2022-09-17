package screens.navigateMenu;

import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AttachUtils;
import utils.DriverUtils;

public abstract class NavigateMenu extends Screen {

    private final ITextBox userName;

    protected NavigateMenu(By locator) {
        super(locator, "Navigate Menu");
        userName = getElementFactory().getTextBox(getUserNameTxtLoc(), "Username");
    }

    protected abstract By getUserNameTxtLoc();

    @Step("Get Username")
    public String getUserName(){
        AttachUtils.saveScreenshot(DriverUtils.getAndroidDriver());
        return userName.getText();
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
