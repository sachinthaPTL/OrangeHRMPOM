package com.pragmatic.examples.selenium.sikuli;

/**
 * Copyrights Pragmatic Test Labs
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddEmployeeFileUploadExample {


    private String BASEURL="http://opensource.demo.orangehrmlive.com";

    private String pathToChromeDriver= "drivers/chromedriver.exe";

    private String pathToImage ="pics/image-login-button.PNG";

    WebDriver webDriver;

    private By txtUsername = By.id("txtUsername");
    private By txtPassword = By.id("txtPassword");
    private By btnLogin = By.id("btnLogin");
    private By msgError = By.id("spanMessage");

    private String username= "Admin";
    private String password= "admin";



    @Test
    public void testAddEmployeeProfilePicUpload() throws FindFailed {

        openBrowser();
        webDriver.findElement(txtUsername).sendKeys(username);
        webDriver.findElement(txtPassword).sendKeys(password);
        webDriver.findElement(txtPassword).submit();
        webDriver.findElement(By.id("menu_pim_viewPimModule")).click();
        webDriver.findElement(By.id("menu_pim_addEmployee")).click();

        //Add employee details  firstName
        webDriver.findElement(By.id("firstName")).sendKeys(getRandomName(10));
        webDriver.findElement(By.id("lastName")).sendKeys(getRandomName(8));

        //Click browse button
        webDriver.findElement(By.id("photofile")).click();

        //Set file name
        Screen screen = new Screen();
//        screen.type("pics/image-upload-filename-field.PNG",
//                "E:\\learning\\sikuli4\\pics\\image-upload-open-button.PNG");
        screen.find("pics/image-upload-filename-field.PNG");
        screen.type("C:\\Users\\PTL_PC\\Desktop\\Day_02_Resources\\pexels-photo.jpg");

        //Click open button
        screen.click("pics/image-upload-open-button.PNG");

        webDriver.findElement(By.id("btnSave")).click();





    }

    private void openBrowser() {
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(BASEURL);
    }


    private  String getRandomName(int length) {
        String UPPERCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ]";
        String LOWERCHARS ="abcdefghijklmnopqrstuvwxyz";

        StringBuilder salt = new StringBuilder();
        int index = (int) (new Random().nextFloat() * UPPERCHARS.length());
        salt.append(UPPERCHARS.charAt(index));

        Random rnd = new Random();
        while (salt.length() < length-1) {
            index = (int) (rnd.nextFloat() * LOWERCHARS.length());
            salt.append(LOWERCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
