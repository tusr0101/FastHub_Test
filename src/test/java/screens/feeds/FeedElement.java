package screens.feeds;

import aquality.appium.mobile.elements.Label;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.selenium.core.elements.ElementState;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FeedElement extends Label {

    protected By parentLoc;
    private final By titleLoc = By.xpath("//*[contains(@resource-id, 'title')]");
    private final By descLoc = By.xpath("//*[contains(@resource-id, 'description')]");
    private final By avatarLoc = By.xpath("//*[contains(@class, 'ImageView') and contains(@resource-id, 'avatar')]");

    private final ILabel title = this.findChildElement(titleLoc, ILabel.class);
    private final ILabel desc =  this.findChildElement(descLoc, ILabel.class);
    private final ILabel avatar =  this.findChildElement(avatarLoc, ILabel.class);

    protected FeedElement(By locator, String name, ElementState state) {
        super(locator, name, state);
        parentLoc = locator;
    }

    @Step("Get Feed title.")
    public String getTitle(){
        return title.getAttribute("text");
    }

    @Step("Get Feed text.")
    public String getDesc(){
        return desc.getAttribute("text");
    }

    @Step("Get Feed avatar description.")
    public String getAvatarDescText(){
        return avatar.getAttribute("content-desc");
    }
}