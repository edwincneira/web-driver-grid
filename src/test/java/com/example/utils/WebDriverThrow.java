package com.example.utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverThrow {

    public static WebDriver chromeDriver() throws MalformedURLException {
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.setCapability("gsg:customcap", true);
        Serenity.getWebdriverManager().getWebdriver();
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), optionsChrome);
        return driver;
    }

    public static WebDriver fireFoxDriver() throws MalformedURLException {
        FirefoxOptions optionsFireFox = new FirefoxOptions();
        optionsFireFox.setCapability("gsg:customcap", true);
        WebDriver driver = Serenity.getDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), optionsFireFox);
        return driver;
    }

    public static WebDriver edgeDriver() throws MalformedURLException {
        EdgeOptions optionsEdge = new EdgeOptions();
        optionsEdge.setCapability("gsg:customcap", true);
        WebDriver driver = Serenity.getDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), optionsEdge);
        return driver;
    }

    public static WebDriver safariDriver() {
        WebDriver driver = Serenity.getDriver();
        driver = new SafariDriver();
        return driver;
    }
}
