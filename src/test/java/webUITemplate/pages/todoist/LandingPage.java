package webUITemplate.pages.todoist;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;

public class LandingPage {
    public Button startForFreeButton = new Button(By.xpath("//a[@href='/auth/signup']"));
    public Button enterLoginButton = new Button(By.xpath("//a[@href='/auth/login']"));
}
