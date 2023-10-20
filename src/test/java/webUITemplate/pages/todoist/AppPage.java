package webUITemplate.pages.todoist;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.Control;

public class AppPage {
    public Control todayTitle = new Control(By.xpath("//h1/span[text()='Today']"));
    public Button profileButton = new Button(By.id(":r0:"));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
    public Button logoutButton = new Button(By.xpath("//button[span[text()='Log out']]"));
    public Control getProjectTitle(String name){
        return new Control(By.xpath("//h1/span[text()='"+name+"']"));
    }

    public Button dismissButton = new Button(By.xpath("//button[@aria-label='Dismiss']"));
}
