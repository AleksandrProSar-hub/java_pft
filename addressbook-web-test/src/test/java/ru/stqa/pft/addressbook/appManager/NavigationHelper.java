package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase{


    public NavigationHelper(ChromeDriver driver) {
      super(driver);
    }

    public void groupPage() {

        click(By.linkText("groups"));
    }
}
