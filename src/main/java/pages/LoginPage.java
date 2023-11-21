package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;
    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.locator("#username").fill(username);
        page.locator("#password").fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    public boolean isLoggedIn() {
        return page.locator("h2").innerText().equals("Secure Area");
    }
}
