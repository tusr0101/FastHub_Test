package DataManagers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestData {
    private final static ISettingsFile settingsFile = new JsonSettingsFile("data_private.json");

    public final static String userName = settingsFile.getValue("/userName").toString();
    public final static String realUserName = settingsFile.getValue("/realUserName").toString();
    public final static String accessToken = settingsFile.getValue("/accessToken").toString();

}
