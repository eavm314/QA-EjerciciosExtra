package webUITemplate.controls;

import org.openqa.selenium.By;
import webUITemplate.session.Session;

public class Alert{
    public static void accept(){
        Session.getInstance().getBrowser().switchTo().alert().accept();
    }

    public static void dismiss(){
        Session.getInstance().getBrowser().switchTo().alert().dismiss();
    }
}
