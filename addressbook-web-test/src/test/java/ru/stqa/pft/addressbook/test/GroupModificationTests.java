package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
    }

    @Test
    public void testGroupModification(){
        app.group().selectGroup(By.name("selected[]"));
        app.group().initGroupModification();
        app.group().fillGroupForm(new GroupData("test2", "test3", "test4"));
        app.group().submitGroupModification();
        app.group().returnToGroupPage();
    }
}
