package filaA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webUITemplate.testSuite.TodoistBaseTest;
import webUITemplate.testSuite.TodolyBaseTest;

import java.util.Random;

public class Ej3_Test extends TodolyBaseTest {
    //   3) 20% Web UI > Crear un usuario, ingresar con este a la aplicación y crear un proyecto - Todo.ly
    private final Random rnd = new Random();

    @Test
    public void testing() {
        createUser();
        createProject();
    }

    private void createUser() {
        String randomEmail = "enrique" + rnd.nextInt() + "@gmail.com";
        String randomPassword = "pwd" + rnd.nextInt();

        mainPage.signUpButton.click();

        signUpSection.fullNameInput.setText("Enrique");
        signUpSection.emailInput.setText(randomEmail);
        signUpSection.pwdInput.setText(randomPassword);

        signUpSection.termsOfServiceButton.click();
        signUpSection.signUpButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error: No se pudo crear la cuenta");
    }

    private void createProject(){
        String randomProjectName = "Project " + rnd.nextInt();

        menuSection.addNewProjectButton.click();
        menuSection.newProjectInput.setText(randomProjectName);
        menuSection.confirmNewProjectButton.click();

        Assertions.assertTrue(menuSection.selectProjectButton(randomProjectName).isControlDisplayed(),
                "Error: No se pudo crear el projecto");
    }
}
