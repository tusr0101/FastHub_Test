#FastHub_RE_AutoTests

Реализация автотестов для приложения [FastHub-RE](https://github.com/LightDestory/FastHub-RE).

Requirements:
- Java 11
- maven
- [Appium server](https://appium.io/)
- [Android SDK](https://developer.android.com/studio) (adb, Android Emulator / real device)
- [Allure framework](https://docs.qameta.io/allure-report/) (Optional. For report generating.)

Preparations:
* 1\. Set your own GitHub test user credentials in file [src/test/resources/data.json](/src/test/resources/data.json).
  * 1.1\. secrets.userName - GitHub username
  * 1.2\. secrets.password - GitHub password
  * 1.3\. secrets.accessToken - GitHub access token. [Read the docs.](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
* 2\. Run appium server.
  * 2.1\. If it's running as local server on http://127.0.0.1:4723/wd/hub. You don't have to do anything else.
  * 2.2\. If it's running on a remote server. Set remote URL in file [src/test/resources/settings.json](/src/test/resources/settings.json).
* 3\. Put APK file of application into [src/tests/resources/apps](src/test/resources/apps) folder.
* 4\. Configure and run Android Emulator.
  * 4.1\. Add information about device(or emulator) into file [src/test/resources/devices.json](/src/test/resources/devices.json).
  * 4.2\. Set deviceKey(key from devices.json) in [src/test/resources/settings.json](/src/test/resources/settings.json) file.
* 5\. Finally, run tests with maven command: `mvn clean test`
* 6\. After tests, you can generate Allure report: `allure serve`