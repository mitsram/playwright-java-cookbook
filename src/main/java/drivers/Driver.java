package drivers;

import com.microsoft.playwright.*;

public class Driver {

    public static Page initializePlaywright() throws Exception {
        DriverFactory factory = new DriverFactory(getBrowserTypeFromEnv());
        Browser browser = factory.createDriver();

        return browser.newPage();
    }

    public static BrowserTypeEnum getBrowserTypeFromEnv() {
        String envBrowserType = System.getenv("BROWSER_TYPE");
        String browserType = (envBrowserType == null || envBrowserType.isEmpty()) ? "Chrome" : envBrowserType;

        try {
            return Enum.valueOf(BrowserTypeEnum.class, browserType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
    }
}
