package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public ChromeDriver driver;
    public ContactHelper contactHelper;
    public SessionHelper sessionHelper;
    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prota\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret"); // логин завернули в метод. чтобы можно было кнему обращаться из разных мест и не тащить лишний код
    }




    public void stop() {
        driver.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public void goToAddNewContactPage() {
      driver.findElement(By.linkText("add new")).click();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void deleteContact()  {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
      Alert confirmationAlert = driver.switchTo().alert();
      confirmationAlert.accept();


    }

    public  void goToHomePage() {
      driver.findElement(By.linkText("home")).click();
    }
}
