package webUITemplate.testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class ProjectItemTest extends TodolyBaseTest{
    private final Random rnd = new Random();
    private String projectName;
    private String itemName;
    @Test
    public void createProjectItemUpdate() throws InterruptedException {
        login();
        createProject();
        createItem();
        updateItem();
    }

    public void createProject() {
        projectName = "Project " + rnd.nextInt();

        menuSection.addNewProjectButton.click();
        menuSection.newProjectInput.setText(projectName);
        menuSection.confirmNewProjectButton.click();

        Assertions.assertTrue(
                menuSection.selectProjectButton(projectName).isControlDisplayed(),
        "Error: El proyecto no se creo correctamente");
    }

    public void createItem(){
        menuSection.selectProjectButton(projectName).click();

        itemName = "Item " + rnd.nextInt();

        itemsSection.addNewItemInput.setText(itemName);
        itemsSection.addNewItemButton.click();

        Assertions.assertTrue(
                itemsSection.selectItemButton(itemName).isControlDisplayed(),
                "Error: El item no se creo correctamente");
    }

    public void updateItem() throws InterruptedException {
        itemsSection.selectItemButton(itemName).click();

        itemName = "Item " + rnd.nextInt();

        Thread.sleep(2000);
        itemsSection.editItemInput.clearSetText(itemName);

//        itemsSection.saveItemButton.click();

        Assertions.assertTrue(
                itemsSection.selectItemButton(itemName).isControlDisplayed(),
                "Error: El item no se actualizó correctamente");
    }
}
