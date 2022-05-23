package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
  public ChromeDriver driver;

  public ContactHelper(ChromeDriver driver) {
    this.driver=driver;
  }


  public void returnToHomePage() {
      driver.findElement(By.linkText("home")).click();
    }

    public void fillContactForm(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
      driver.findElement(By.name("company")).click();
      driver.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("home")).click();
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }
}
