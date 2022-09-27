package tests;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import spec.RequestSpec;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class PetApiTest extends RequestSpec {

    public PetApiTest() {
        super("https://petstore.swagger.io/v2");
    }

    @Test
    public void postPet() {
        JSONObject pet = new JSONObject();
        pet.put("id",123);
        pet.put("name", "Cesur");
        pet.put("status", "available");

        given()
                .spec(getRequestSpecification())
                .body(new JSONObject(pet).toString())
        .when()
                .post("/pet")
        .then()
                .statusCode(200)
                .extract().response().print();

    }

    @Test
    public void getPet() {

        int petId = 11;

        given()
                .spec(getRequestSpecification())
                .pathParam("id", petId)
        .when()
                .get("/pet/{id}")
        .then()
                .statusCode(200)
                .extract().response().print();
    }

}

