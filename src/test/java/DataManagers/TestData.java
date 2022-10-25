package DataManagers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestData {
    private final static ISettingsFile settingsFile = new JsonSettingsFile("data.json");

    public final static String userName = settingsFile.getValue("/secrets/userName").toString();
    public final static String password = settingsFile.getValue("/secrets/password").toString();
    public final static String accessToken = settingsFile.getValue("/secrets/accessToken").toString();

    public final static String browserPackage = settingsFile.getValue("/loginTests/browserPackage").toString();
    public final static int randomTokenLength = Integer.parseInt(settingsFile.getValue("/loginTests/randomTokenLength").toString());

    public final static String searchFor = settingsFile.getValue("/searchTests/searchFor").toString();
    public final static String exceptedSearchFor = settingsFile.getValue("/searchTests/exceptedSearchFor").toString();
    public final static int searchResultIndex = Integer.parseInt(settingsFile.getValue("/searchTests/searchResultIndex").toString());

    public final static String exceptedRepoName = settingsFile.getValue("/repoTests/exceptedRepoName").toString();
    public final static String exceptedRepoAccess = settingsFile.getValue("/repoTests/exceptedRepoAccess").toString();
    public final static int repoIndex = Integer.parseInt(settingsFile.getValue("/repoTests/repoIndex").toString());

    public final static int screenRecordingTimeLimit = Integer.parseInt(settingsFile.getValue("/config/screenRecordingTimeLimit").toString());

}
