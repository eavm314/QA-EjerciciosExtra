package webUITemplate.pages.todoist;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.Control;
import webUITemplate.controls.TextBox;

public class AppPage {
    public Control todayTitle = new Control(By.xpath("//h1/span[text()='Today']"));
    public Button profileButton = new Button(By.id(":r0:"));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
    public Button logoutButton = new Button(By.xpath("//button[span[text()='Log out']]"));
    public Control getProjectTitle(String name){
        return new Control(By.xpath("//h1/span[text()='"+name+"']"));
    }

    public Button dismissButton = new Button(By.xpath("//button[@aria-label='Dismiss']"));

    public Button addTaskButton = new Button(By.className("plus_add_button"));
    public TextBox taskNameInput = new TextBox(By.xpath("//p[@data-placeholder='Task name']"));
    public Button addTaskConfirmButton = new Button(By.xpath("//button[@aria-label='Add task']"));
    public Button getTaskButton(String content){
        return new Button(By.xpath("//div[@class='task_content' and text()='"+content+"']"));
    }

    public Control getProfileName(String name){
        return new Control(By.xpath("//button[@aria-label='Settings']/span[text()='"+name+"']"));
    }
}
