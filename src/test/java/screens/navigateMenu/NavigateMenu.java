package screens.navigateMenu;

import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class NavigateMenu extends Screen {

    private final ITextBox userName;

    protected NavigateMenu(By locator) {
        super(locator, "Navigate Menu");
        userName = getElementFactory().getTextBox(getUserNameTxtLoc(), "Username");
    }

    protected abstract By getUserNameTxtLoc();

    public String getUserName(){
        return userName.getText();
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}
