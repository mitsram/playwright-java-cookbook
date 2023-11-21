import com.microsoft.playwright.Page;
import drivers.Driver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Page page;

    @BeforeClass
    public void setUp() throws Exception {
        this.page = Driver.initializePlaywright();
    }
}
