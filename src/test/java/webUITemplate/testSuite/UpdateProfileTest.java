package webUITemplate.testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class UpdateProfileTest extends TodolyBaseTest{
    private final Random rnd = new Random();
    private String newName;
    @Test
    public void updateFullName() throws InterruptedException {
        login();
        openSettings();
        updateName();
        checkName();
    }

    public void openSettings() throws InterruptedException {
        menuSection.settingsButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(
                profileSection.settingsDialog.isControlDisplayed(),
                "Error: No se abrió el dialogo de configuración");
    }

    public void updateName() throws InterruptedException {
        newName = "Enrique " + rnd.nextInt();

        profileSection.fullNameInput.clearSetText(newName);
        profileSection.okButton.click();

        Thread.sleep(1000);
        Assertions.assertFalse(
                profileSection.settingsDialog.isControlDisplayed(),
                "Error: No se cerró el dialogo de configuración");
    }

    public void checkName() throws InterruptedException {
        openSettings();
        String actualName = profileSection.fullNameInput.getValue();

        Assertions.assertEquals(newName, actualName, "Error: No se actualizó el nombre");
    }


}
