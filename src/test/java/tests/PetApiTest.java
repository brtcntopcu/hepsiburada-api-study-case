package tests;

import org.hamcrest.Matchers;
import org.junit.Test;
import spec.RequestSpec;


import static io.restassured.RestAssured.*;

public class PetApiTest extends RequestSpec {

    public PetApiTest() {
        super("https://petstore.swagger.io/v2");
    }

    @Test
    public void postPet() {
        String pet = "{\"id\":123,\"name\":\"Cesur\",\"status\":\"available\"}";

        given()
                .spec(getRequestSpecification())
                .body(pet)
                .when().post("/pet")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(123))
                .body("name", Matchers.equalTo("Cesur"))
                .body("status", Matchers.equalTo("available"))
                .extract().response().print();

    }

    @Test
    public void getPet() {

        given()
                .spec(getRequestSpecification())
                .pathParam("id", 11)
                .when().get("/pet/{id}")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(11))
                .extract().response().print();
    }

}

