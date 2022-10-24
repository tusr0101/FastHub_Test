package DataManagers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestData {
    private final static ISettingsFile settingsFile = new JsonSettingsFile("data_private.json");

    public final static String userName = settingsFile.getValue("/userName").toString();
    public final static String accessToken = settingsFile.getValue("/accessToken").toString();
    public final static String password = settingsFile.getValue("/password").toString();
    public final static String browserPackage = settingsFile.getValue("/browserPackage").toString();
    public final static String searchFor = settingsFile.getValue("/searchFor").toString();
    public final static String exceptedSearchFor = settingsFile.getValue("/exceptedSearchFor").toString();
    public final static int searchResultIndex = Integer.parseInt(settingsFile.getValue("/searchResultIndex").toString());
    public final static String exceptedRepoName = settingsFile.getValue("/exceptedRepoName").toString();
    public final static String exceptedRepoAccess = settingsFile.getValue("/exceptedRepoAccess").toString();
    public final static int repoIndex = Integer.parseInt(settingsFile.getValue("/repoIndex").toString());
    public final static int screenRecordingTimeLimit = Integer.parseInt(settingsFile.getValue("/screenRecordingTimeLimit").toString());
    public final static int randomTokenLength = Integer.parseInt(settingsFile.getValue("/randomTokenLength").toString());

}
