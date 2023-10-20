package webUITemplate.pages.todoly;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.Control;
import webUITemplate.controls.TextBox;

public class ProfileSection {
    public Control settingsDialog = new Control(By.id("settingsDialog"));
    public TextBox fullNameInput = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//button[span[text()='Ok']]"));
}