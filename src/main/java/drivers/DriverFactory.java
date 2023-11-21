package drivers;

import com.microsoft.playwright.*;


public class DriverFactory {
    BrowserTypeEnum browserType;

    public DriverFactory(BrowserTypeEnum browserType) {
        this.browserType = browserType;
    }

    public Browser createDriver() throws Exception {

        Playwright playwright = Playwright.create();

        switch (this.browserType) {
            case Chrome:
                return playwright.chromium().launch(launchOptions());
            case Firefox:
                return playwright.firefox().launch();
            case Safari:
                return playwright.webkit().launch();
            default:
                throw new Exception("Invalid browser type");
        }
    }

    public BrowserType.LaunchOptions launchOptions() {
        return new BrowserType.LaunchOptions()
                .setHeadless(false);
    }
}


