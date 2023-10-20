package firefoxTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUITemplate.pages.todoly.*;
import webUITemplate.session.Session;

public class FireFoxTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.browserType = "firefox";
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void login(){
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("enriqueadhemar@gmail.com");
        loginSection.pwdTextBox.setText("eavm123");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo iniciar sesion");

    }
}
