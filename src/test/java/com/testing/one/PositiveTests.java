package com.testing.one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
    @Test
    public void loginTest() {
        System.out.println("********Starting Logintest********");
//        create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

//        maximize screen
        driver.manage().window().maximize();
//        open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("********Page is open********");
//        enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
//        enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("");
//        click Login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
//        verification
//        new url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
//        logout button visible
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Log out button is not visible");
//        successful login message
        WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
        String expectMessage = "You logged into a secure area!";
        String actualMessage = successMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectMessage), "Actual message does not contain expected message.\nActual Message : " + actualMessage + "\nExpected Message : " + expectMessage);

//        Close browser
//        driver.close();
        driver.quit();


    }

    private void sleep(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
