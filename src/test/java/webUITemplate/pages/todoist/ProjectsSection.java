package webUITemplate.pages.todoist;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.TextBox;

public class ProjectsSection {
    public Button projectsButton = new Button(By.xpath("//a[@href='/app/projects']"));
    public Button addProjectButton = new Button(By.xpath("//button[@aria-label='Add project']"));
    public TextBox nameInput = new TextBox(By.xpath("//input[@name='name']"));
    public Button addButton = new Button(By.xpath("//button[span[text()='Add']]"));
}
