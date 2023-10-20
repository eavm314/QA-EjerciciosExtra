package filaA;

import apiTestTemplate.config.Configuration;
import apiTestTemplate.factory.FactoryRequest;
import apiTestTemplate.testSuite.ApiBaseTest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class Ej1_Test extends ApiBaseTest {
//    1) 20% API Test > Crear un usuario, Crear un project con el usuario usando auth basic,
//    Borrar el usuario, Crear otro proyecto con el usuario borrado (no deberia crear el segundo
//            proyecto) - Todo.ly

    private final Random rnd = new Random();

    @Test
    public void testing() {
        createUser();
        createProject();
        deleteUser();
        createProjectWithoutAuth();
    }

    private void createUser() {
        String randomEmail = "enrique" + rnd.nextInt() + "@gmail.com";
        String randomPassword = "pwd" + rnd.nextInt();

        Configuration.user = randomEmail;
        Configuration.password = randomPassword;

        JSONObject body = new JSONObject();
        body.put("Email", randomEmail);
        body.put("Password", randomPassword);
        body.put("FullName", "Enrique");

        requestInfo.setUrl(Configuration.host + "/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("Email", equalTo(body.get("Email")))
                .body("FullName", equalTo(body.get("FullName")));
    }

    private void createProject() {
        String randomContent = "Project " + rnd.nextInt();

        JSONObject body = new JSONObject();
        body.put("Content", randomContent);

        requestInfo.setUrl(Configuration.host + "/api/projects.json")
                .setBody(body.toString())
                .setBasicAuthNeeded(true);

        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteUser() {
        requestInfo.setUrl(Configuration.host + "/api/user/0.json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("Email", equalTo(Configuration.user));
    }

    private void createProjectWithoutAuth() {
        String randomContent = "Project " + rnd.nextInt();

        JSONObject body = new JSONObject();
        body.put("Content", randomContent);

        requestInfo.setUrl(Configuration.host + "/api/projects.json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("ErrorMessage", equalTo("Account doesn't exist"))
                .body("ErrorCode", equalTo(105));
    }
}
