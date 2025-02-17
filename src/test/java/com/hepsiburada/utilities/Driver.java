package com.hepsiburada.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public Driver() {
    }

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            System.out.println("TRYING TO CREATE DRIVER");
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("start-maximized");
                    WebDriverManager.chromedriver().clearDriverCache().setup();
                    WebDriverManager.chromedriver().clearResolutionCache().setup();
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;

            }
        }


        return driverPool.get();
    }
    public static void close() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
