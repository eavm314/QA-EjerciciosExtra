package webUITemplate.pages.todoly;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.TextBox;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox newProjectInput = new TextBox(By.id("NewProjNameInput"));
    public Button confirmNewProjectButton = new Button(By.id("NewProjNameButton"));
    public Button selectProjectButton(String projectName){
        return new Button(By.xpath("//td[text()='"+projectName+"']"));
    }
    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));
}
