package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
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
        int before = app.group().getGroupCount(); // список групп до
        app.group().selectGroup(By.name("selected[]"));
        app.group().initGroupModification();
        app.group().fillGroupForm(new GroupData().withName("test2").withHeader("test3").withFooter("test4"));
        app.group().submitGroupModification();
        app.group().returnToGroupPage();
        int after = app.group().getGroupCount(); // список групп после
        Assert.assertEquals(after, before); // сравниваем список групп до и после
    }
}
