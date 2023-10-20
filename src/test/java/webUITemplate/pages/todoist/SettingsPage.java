package webUITemplate.pages.todoist;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.TextBox;

public class SettingsPage {
    public Button changePasswordButton = new Button(By.xpath("//a[@href='/app/settings/account/password']"));
    public TextBox currentPasswordInput = new TextBox(By.xpath("//span[text()='Current password']/../../../div/input"));
    public TextBox newPasswordInput = new TextBox(By.xpath("//span[text()='New password']/../../../div/input"));
    public TextBox newPasswordConfirmInput = new TextBox(By.xpath("//span[text()='Confirm new password']/../../../div/input"));
    public Button confirmChangePasswordButton = new Button(By.xpath("//button[@type='submit' and span[text()='Change password']]"));
    public Button closeSettingsButton = new Button(By.xpath("//button[@aria-label='Close settings']"));

    public TextBox nameInput = new TextBox(By.name("name"));
    public Button updateButton = new Button(By.xpath("//button[@type='submit' and span[text()='Update']]"));
}
