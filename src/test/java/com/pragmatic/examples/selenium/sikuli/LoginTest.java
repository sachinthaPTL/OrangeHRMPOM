package com.pragmatic.examples.selenium.sikuli;

/**
 * Copyrights Pragmatic Test Labs
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private String BASEURL="http://opensource.demo.orangehrmlive.com";

    private String pathToChromeDriver= "E:\\selenium\\drivers\\chromedriver_win32\\chromedriver.exe";

    private String pathToImage ="pics/image-login-button.PNG";

    WebDriver webDriver;

    private By txtUsername = By.id("txtUsername");
    private By txtPassword = By.id("txtPassword");
    private By btnLogin = By.id("btnLogin");
    private By msgError = By.id("spanMessage");

    private String username= "Admin";
    private String password= "admin";

    private String msgExpected="Username cannot be empty";


    @AfterClass
    public void afterClass(){
        webDriver.quit();
    }

    @Test
    public void testLoginWithBlankUsername() throws FindFailed {
        String msgActual;

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(BASEURL);

        webDriver.findElement(txtUsername).clear();
        webDriver.findElement(txtPassword).clear();
        webDriver.findElement(txtPassword).sendKeys(password);
        Screen screen = new Screen();

        screen.click(pathToImage);
        msgActual = webDriver.findElement(msgError).getText();
        Assert.assertEquals(msgActual, msgExpected);

    }


    @Test
    public void testLoginWithBlankUsername2() throws FindFailed {
        String msgActual;

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(BASEURL);


        Screen screen = new Screen();
        screen.type("pics/image-username-field.PNG","");
        screen.type("pics/image-password-field.PNG",password);
        screen.click(pathToImage);
        msgActual = webDriver.findElement(msgError).getText();
        Assert.assertEquals(msgActual, msgExpected);

    }







}
