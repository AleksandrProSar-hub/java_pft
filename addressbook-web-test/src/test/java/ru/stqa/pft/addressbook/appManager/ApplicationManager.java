package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
    private  String browser;
    public WebDriver driver;
    public ContactHelper contactHelper;
    public SessionHelper sessionHelper;
    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.CHROME){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\prota\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == BrowserType.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\prota\\Downloads\\chromedriver_win32\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser == BrowserType.EDGE) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\prota\\Downloads\\chromedriver_win32\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

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
