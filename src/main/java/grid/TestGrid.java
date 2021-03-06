package grid;

import com.sun.xml.internal.ws.resources.UtilMessages;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestGrid {
    static WebDriver driver;
    static String nodeURL;

    public static void main(String[] args) {
        try {
            nodeURL = "http://192.168.56.1:4444/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
            driver.get("http://www.amazon.com");
            driver.findElement(By.linkText("Today's Deals")).click();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
