package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;

public class NavigateCommands {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome-webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://portal.aait.edu.et/";
        String reportUrl = "https://portal.aait.edu.et/Grade/GradeReport";

        driver.get(url);

        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));

        userName.sendKeys("portal username");
        password.sendKeys("portal password");
        System.out.println("Text Field set");

        userName.clear();
        password.clear();
        System.out.println("Text Field cleared");

        userName.sendKeys("portal username");
        password.sendKeys("portal password");
        System.out.println("Text Field set");

        WebElement button = driver.findElement(By.className("btn"));
        button.click();
        System.out.println("Logging is done");

        driver.navigate().to(reportUrl);

        WebElement result = driver.findElement(By.tagName("table"));
        String res = result.getText();
        //System.out.println(res);
        String path = "C:\\Users\\hp\\Documents\\SeleniumAutoTest\\src\\result.txt";

        try {
            Files.write(Paths.get(path), res.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
