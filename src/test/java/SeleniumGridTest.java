import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {

    @Test
    public void webDriverInit() throws MalformedURLException, InterruptedException {

        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.setCapability("gsg:customcap", true);
        WebDriver driverChrome = new RemoteWebDriver(new URL("http://localhost:4444"), optionsChrome);

        FirefoxOptions optionsFireFox = new FirefoxOptions();
        optionsFireFox.setCapability("gsg:customcap", true);
        WebDriver driverFireFox = new RemoteWebDriver(new URL("http://localhost:4444"), optionsFireFox);

        EdgeOptions optionsEdge = new EdgeOptions();
        optionsEdge.setCapability("gsg:customcap", true);
        WebDriver driverEdge = new RemoteWebDriver(new URL("http://localhost:4444"), optionsEdge);


        driverChrome.get("https://selenium.dev");
        driverFireFox.get("https://selenium.dev");
        driverEdge.get("https://selenium.dev");
        driverChrome.quit();
        driverFireFox.quit();
        driverEdge.quit();
    }

}
