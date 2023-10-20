package webUITemplate.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import webUITemplate.pages.todoly.*;
import webUITemplate.session.Session;

public class TodolyBaseTest {

    public MenuSection menuSection = new MenuSection();
    public MainPage mainPage = new MainPage();
    public SignUpSection signUpSection = new SignUpSection();
    public LoginSection loginSection = new LoginSection();
    public ItemsSection itemsSection = new ItemsSection();
    public ProfileSection profileSection = new ProfileSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.browserType = "chrome";
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    public void login(){
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("enriqueadhemar@gmail.com");
        loginSection.pwdTextBox.setText("eavm123");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo iniciar sesion");

    }



}
