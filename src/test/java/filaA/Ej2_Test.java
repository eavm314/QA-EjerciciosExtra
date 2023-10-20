package filaA;

import apiTestTemplate.config.Configuration;
import apiTestTemplate.factory.FactoryRequest;
import apiTestTemplate.testSuite.ApiBaseTest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.equalTo;

public class Ej2_Test extends ApiBaseTest {
    // 2) 15% API Test > Crear 4 project y luego eliminar todos los proyectos que existen -Todo.ly

    @ParameterizedTest
    @CsvSource(
            {
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4"
            }
    )
    public void createDeleteProject(String content) {

        JSONObject body = new JSONObject();
        body.put("Content", content);

        int id = createItem(body);

        deleteItem(id);

    }

    @BeforeEach
    @Override
    public void before() {
        super.before();
        authenticate();
    }

    private Integer createItem(JSONObject body) {

        requestInfo.setUrl(Configuration.host + "/api/items.json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));

        return response.getBody().path("Id");
    }

    private void deleteItem(Integer id) {
        requestInfo.setUrl(Configuration.host + "/api/items/" + id + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("Id", equalTo(id))
                .body("Deleted", equalTo(true));
    }
}
