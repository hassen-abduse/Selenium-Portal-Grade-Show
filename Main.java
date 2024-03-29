package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.setProperty("webdriver.chrome.driver", "C:\\chrome-webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.monergism.com/";
        driver.get(url);

        String title = driver.getTitle();
        int titleLength = driver.getTitle().length();

        System.out.println("Title of the page is: " + title);
        System.out.println("Length of the title is: " + titleLength);

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)){
            System.out.println("Verification Successful = The correct URL is opened");
        }else{
            System.out.println("Verification Failed = An incorrect url is opened");
            System.out.println("Actual URL is: " + actualUrl);
            System.out.println("Expected URL is: " + url);
        }

        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource.length();

        System.out.println("Total length of page source is: " + pageSourceLength);

        driver.close();
    }
}
