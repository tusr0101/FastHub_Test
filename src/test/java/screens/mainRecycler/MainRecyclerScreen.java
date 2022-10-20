package screens.mainRecycler;

import aquality.appium.mobile.screens.Screen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public abstract class MainRecyclerScreen extends Screen {

    protected MainRecyclerScreen(By locator) {
        super(locator, "Recycler container");
    }

    protected abstract By getFeedElementsLocator();

    @Step("Get Main Recycler elements.")
    public List<RecyclerElement> getElements() {
        return getElementFactory().findElements(getFeedElementsLocator(), RecyclerElement.class);
    }

    public boolean isPresented(){
        return this.state().isExist();
    }
}