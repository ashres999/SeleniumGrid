package grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Node3 {
    WebDriver driver;
    String nodeURL;

    @Test
    public void f() {
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
            driver.get("http://demo.guru99.com/test/upload/");
            WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

            //enter the file path into the file selection input field
            uploadElement.sendKeys("C:\\Users\\as241\\Documents\\seleniumupload");

            // check the "I accept the terms of service" check box
            driver.findElement(By.id("terms")).click();

            // click the "UploadFile" button
            driver.findElement(By.name("send")).click();
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
