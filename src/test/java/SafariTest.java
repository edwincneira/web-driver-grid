import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;

public class SafariTest {

    @Test
    public void webDriverMacInit() {
        WebDriver driverSafari = new SafariDriver();
        driverSafari.get("https://selenium.dev");
        driverSafari.quit();
    }

}
