package filaC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webUITemplate.testSuite.TodoistBaseTest;

import java.util.Random;

public class Ej3_Test extends TodoistBaseTest {
    //    3) 15% Web UI > Update the name account (settings>account)(Todoist)
    private final Random rnd = new Random();

    @Test
    public void testing(){
        login();
        updateName();
    }

    private void updateName(){
        String randomName = "Name" + rnd.nextInt();

        appPage.profileButton.click();
        appPage.settingsButton.click();

        settingsPage.nameInput.clearSetText(randomName);
        settingsPage.updateButton.click();

        settingsPage.closeSettingsButton.click();

        Assertions.assertTrue(appPage.getProfileName(randomName).isControlDisplayed(),
                "Error: No se cambio el nombre");
    }

}
