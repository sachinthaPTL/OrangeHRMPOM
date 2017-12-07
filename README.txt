/**
 * Copyrights Pragmatic Test Labs
 */

Steps to setup and use Sikuli  in Selenium WebDriver

Steps 1: Set dependencies to Selenium , TesNG and sikulixapi in POM.xml
Step 2 : Access the pages to automate and capture the area of the required control (e.g Login button)
Step 3 : Save the pictures into a directory within the project folder
Step 4 : Create an instance of Screen class
Screen screen = new Screen();

Step 5 : Call the actions (methods) to interact with the web page

To click
screen.click("pics/image-upload-open-button.PNG");

To Type
screen.type("pics/image-upload-filename-field.PNG",
        "E:\\learning\\sikuli4\\pics\\image-upload-open-button.PNG");

