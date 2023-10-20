package apiTestTemplate.testSuite;

import apiTestTemplate.config.Configuration;
import apiTestTemplate.factory.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TodolyTokenTest extends ApiBaseTest {
    @Test
    public void createUpdateDeleteProject(){
        authenticate();

        JSONObject body = new JSONObject();
        body.put("Content","Nuevo proyecto tarea");

        createProject(body);
        int idProject = response.then().extract().path("Id");

        readProject(idProject, body);

        body.put("Content","Projecto actualizado");
        updateProject(idProject, body);

        deleteProject(idProject);
    }

    private void createProject(JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects.json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void readProject(int idProject, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json");
        response = FactoryRequest.make(get).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("Id", equalTo(idProject))
                .body("Content", equalTo(body.get("Content")));
    }

    private void updateProject(int idProject, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json")
                .setBody(body.toString());
        response = FactoryRequest.make(put).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")));
    }

    private void deleteProject(int idProject) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("Id", equalTo(idProject))
                .body("Deleted", equalTo(true));
    }
}
