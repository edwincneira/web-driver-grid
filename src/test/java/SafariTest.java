import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariTest {

    @Test
    public void webDriverMacInit() {
        WebDriver driverSafari = new SafariDriver();
        driverSafari.navigate().to("https://selenium.dev");
        driverSafari.quit();
    }

}
