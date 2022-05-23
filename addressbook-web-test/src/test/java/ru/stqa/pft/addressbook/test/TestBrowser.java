package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public  class TestBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\prota\\Downloads\\chromedriver_win32\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }
}