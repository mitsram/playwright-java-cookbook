import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        page.navigate("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(page);
    }

    @Test
    public void login_ValidCredentials_Returns_Successful() {
        loginPage.login("tomsmith", "SuperSecretPassword!");

        boolean isLoggedIn = loginPage.isLoggedIn();
        Assert.assertTrue(isLoggedIn);
    }
}
