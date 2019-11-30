package com.Injectionpart.provider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import javax.inject.Provider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WebDriverProvider implements Provider<WebDriver> {

        @Override
        public WebDriver get() {
                ChromeOptions options = new ChromeOptions();

                URL gamelan = null;
                try {
                        gamelan = new URL("http://localhost:4444/wd/hub");
                } catch (MalformedURLException e) {
                        e.printStackTrace();
                }

                WebDriver driver;

                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                //options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                String browser = Optional.ofNullable(System.getProperty("browser")).orElse("");
                switch (browser.toLowerCase()) {
                        case "ie":
                        case "internet explorer":
                                driver = new InternetExplorerDriver();
                                break;
                        case "firefox":
                                driver = new FirefoxDriver();
                                break;
                        case "safari":
                                driver = new SafariDriver();
                                break;
                        case "opera":
                                driver = new OperaDriver();
                                break;
                        case "remote":
                                driver = new RemoteWebDriver(new DesiredCapabilities());
                                break;
                        default:
                                WebDriverManager.chromedriver().setup();
                                driver = new ChromeDriver(options);
                                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                }
                return driver;
        }
}

