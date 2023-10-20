package filaA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webUITemplate.testSuite.TodoistBaseTest;

import java.util.Random;

public class Ej4_Test extends TodoistBaseTest {
    // 4) 15% Web UI> Create 1 Task (todoist)
    @Test
    public void testing(){
        login();
        createTask();
    }

    private void createTask(){
        Random rnd = new Random();
        String randomContent = "Task"+rnd.nextInt();

        appPage.addTaskButton.click();
        appPage.taskNameInput.setText(randomContent);

        appPage.addTaskConfirmButton.click();

        Assertions.assertTrue(appPage.getTaskButton(randomContent).isControlDisplayed(),
                "Error: No se creo la tarea");
    }
}
