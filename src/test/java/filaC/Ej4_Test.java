package filaC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webUITemplate.controls.Alert;
import webUITemplate.testSuite.TodolyBaseTest;

import java.util.Random;

public class Ej4_Test extends TodolyBaseTest {
    //    4) 20% Web UI> Crear un Usuario > Eliminar el usuario
    //    Todo.ly -> Account> Delete Account

    private final Random rnd = new Random();
    private String randomEmail;
    private String randomPassword;

    @Test
    public void testing(){
        createUser();
        deleteUser();
        getLoginError();
    }

    private void createUser() {
        randomEmail = "enrique" + rnd.nextInt() + "@gmail.com";
        randomPassword = "pwd" + rnd.nextInt();

        mainPage.signUpButton.click();

        signUpSection.fullNameInput.setText("Enrique");
        signUpSection.emailInput.setText(randomEmail);
        signUpSection.pwdInput.setText(randomPassword);

        signUpSection.termsOfServiceButton.click();
        signUpSection.signUpButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error: No se pudo crear la cuenta");
    }

    private void deleteUser(){
        menuSection.settingsButton.click();

        profileSection.accountTab.click();
        profileSection.deleteAccountButton.click();

        Alert.accept();

        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed(),
                "Error: No se elimino el usuario");
    }

    private void getLoginError(){
        mainPage.loginButton.click();

        loginSection.emailTextBox.setText(randomEmail);
        loginSection.pwdTextBox.setText(randomPassword);

        loginSection.loginButton.click();

        Assertions.assertTrue(mainPage.errorMessage.isControlDisplayed(),
                "Error: El usuario y contraseña ingresados no generan un error");
    }
}
