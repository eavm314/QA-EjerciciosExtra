package webUITemplate.pages.todoist;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.TextBox;

public class LoginPage {
    public TextBox emailInput = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox passwordInput = new TextBox(By.xpath("//input[@type='password']"));
    public Button logInButton = new Button(By.xpath("//button[@type='submit']"));
}
