package filaC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webUITemplate.testSuite.TodoistBaseTest;

import java.util.Random;

public class Ej3_Test extends TodoistBaseTest {
    //    3) 15% Web UI > Update the name account (settings>account)(Todoist)
    private final Random rnd = new Random();

    @Test
    public void testing() throws InterruptedException {
        createUser();
        createProject();
    }

    private void createUser() throws InterruptedException {
        String randomEmail = "enrique" + rnd.nextInt() + "@gmail.com";
        String randomPassword = "pwd" + rnd.nextInt();

        landingPage.startForFreeButton.click();

        signUpPage.emailInput.setText(randomEmail);
        signUpPage.passwordInput.setText(randomPassword);
        signUpPage.signInButton.click();

        signUpPage.nameInput.setText("Enrique");
        signUpPage.continueButton.click();

        signUpPage.personalAccountButton.click();
        Thread.sleep(1000);
        signUpPage.launchButton.click();

        appPage.dismissButton.click();

        Assertions.assertTrue(appPage.todayTitle.isControlDisplayed(),
                "Error: No se pudo crear la cuenta");
    }

    private void createProject(){
        String randomProjectName = "Project " + rnd.nextInt();

        projectsSection.projectsButton.click();
        projectsSection.addProjectButton.click();

        projectsSection.nameInput.setText(randomProjectName);
        projectsSection.addButton.click();

        Assertions.assertTrue(appPage.getProjectTitle(randomProjectName).isControlDisplayed(),
                "Error: No se pudo crear el projecto");
    }
}
