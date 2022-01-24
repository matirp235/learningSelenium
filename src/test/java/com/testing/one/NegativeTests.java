package com.testing.one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
    @Test(priority = 1)
    public void InvalidUserTests() {
        System.out.println("***Invalid Username validation test***");

        //create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //maximize browser
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        // enter username - invalid
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("InvalidUsername");

        //enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("");

        // click on login page
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //failed login message
        WebElement invalidUsernameMessage = driver.findElement(By.id("flash-messages"));
        String expectMessage = "Your username is invalid!";
        String actualMessage = invalidUsernameMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectMessage), "Actual message does not contain expected message.\nActual Message : " + actualMessage + "\nExpected Message : " + expectMessage);

        driver.quit();
    }

    @Test(priority = 2, enabled = false)
    public void InvalidPasswordTests() {
        System.out.println("***Invalid Password validation test***");

        //create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //maximize browser
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        // enter username - invalid
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("");

        // click on login page
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //failed login message
        WebElement invalidUsernameMessage = driver.findElement(By.id("flash-messages"));
        String expectMessage = "Your password is invalid!";
        String actualMessage = invalidUsernameMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectMessage), "Actual message does not contain expected message.\nActual Message : " + actualMessage + "\nExpected Message : " + expectMessage);

        driver.quit();
    }
}
