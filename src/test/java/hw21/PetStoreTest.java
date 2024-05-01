package hw21;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetStoreTest {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    @Test
    @Description("Valid pet object added")
    public void addPetsTestSuccess() {
        ValidatableResponse response = postPetRequest(prepareTestPet());
        response.statusCode(200);
        attachResponse(response.extract().asString());
    }

    @Test
    @Description("Empty request body return status 405")
    public void addPetsTestFailed() {
        ValidatableResponse response = given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .post("pet")
                .then();
        response.statusCode(405);
        attachResponse(response.extract().asString());
    }

    @Test
    public void updatePetTest() {
        Pet pet = prepareTestPet();
        postPetRequest(pet);

        pet.setName("new_test_name");

        putPetRequest(pet).statusCode(200);

        Pet actual = getPetRequest(pet.getId()).extract().as(Pet.class);
        assertEquals("new_test_name", actual.getName());
        attachResponse("Actual updated name " + actual.getName());
    }

    @Test
    @Description("Update pet object with incorrect id fails")
    public void updatePetsFailed() {
        Pet pet = prepareTestPet();
        long id = -10000;
        pet.setId(id);
        putPetRequest(pet).statusCode(200); // ?? added new pet with random id but must be 405 status
        ValidatableResponse response = getPetRequest(id);
        response.statusCode(404);
        attachResponse(response.extract().asString());
    }

    @Test
    public void deletePetSuccess() {
        Pet[] pets = given()
                .baseUri(baseUrl)
                .when()
                .queryParams("status", "available,sold,pending")
                .get("pet/findByStatus")
                .then()
                .log()
                .all()
                .extract()
                .as(Pet[].class);
        long id = pets[0].getId();
        given()
                .baseUri(baseUrl)
                .when()
                .delete("pet/"+id)
                .then()
                .log()
                .all()
                .statusCode(200);

        ValidatableResponse response = getPetRequest(id);
        response.statusCode(404);
        attachResponse(response.extract().asString());
    }

    @Test
    public void addUniqueStatus() {
        Pet pet = prepareTestPet();
        pet.setStatus("uniq_test_status1234");
        postPetRequest(pet);
        HashMap map = given()
                .baseUri(baseUrl)
                .when()
                .get("store/inventory")
                .then()
                .log()
                .all()
                .extract()
                .as(HashMap.class);
        assertEquals(1, map.get("uniq_test_status1234"));
        attachResponse("Count of pets with status uniq_test_status1234 = " + map.get("uniq_test_status1234"));
    }

    @Test
    public void getOrderFailed() {
        ValidatableResponse response = given()
                .baseUri(baseUrl)
                .when()
                .get("store/order/100")
                .then()
                .log()
                .all();

        response.statusCode(404);
        attachResponse(response.extract().asString());
    }
    @Test
    public void getOrderSuccess() {
        Order order = prepareTestOrder();
        postOrderRequest(order);
        ValidatableResponse response = getOrderRequest(order.getId());

        response.statusCode(200);
        attachResponse(response.extract().asString());
    }
    @Test
    public void deleteOrderFailed() {
        ValidatableResponse response = given()
                .baseUri(baseUrl)
                .when()
                .delete("store/order/-100")
                .then()
                .log()
                .all();

        response.statusCode(404);
        attachResponse(response.extract().asString());
    }
    @Step
    private Pet prepareTestPet() {
        Category category = Category.builder()
                .id(321L)
                .name("test")
                .build();
        ArrayList<String> urls = new ArrayList<>();
        urls.add("test_url");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(Tag.builder().id(1L).name("test_tag").build());
        return Pet.builder()
                .id(123L)
                .name("test_pet")
                .status("test_available")
                .category(category)
                .photoUrls(urls)
                .tags(tags)
                .build();
    }
    @Step
    private Order prepareTestOrder() {
        return Order.builder()
                .petId(123L)
                .complete(false)
                .quantity(2)
                .id(456)
                .status("test_order_status")
                .shipDate("2024-04-23T19:30:19.852Z")
                .build();
    }
    @Step
    private ValidatableResponse getPetRequest(long id) {
        return given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .get("pet/"+id)
                .then()
                .log()
                .all();
    }
    @Step
    private ValidatableResponse putPetRequest(Pet pet) {
        return given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .body(pet)
                .put("pet")
                .then()
                .log()
                .all();
    }
    @Step
    private ValidatableResponse postPetRequest(Pet pet) {
        return given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("pet")
                .then()
                .log()
                .all();
    }

    @Step
    private ValidatableResponse postOrderRequest(Order order) {
        return given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .body(order)
                .post("store/order")
                .then()
                .log()
                .all();
    }

    @Step
    private ValidatableResponse getOrderRequest(long orderId) {
        return given()
                .baseUri(baseUrl)
                .when()
                .get("store/order/"+orderId)
                .then()
                .log()
                .all();
    }

    @Attachment
    public String attachResponse(String response) {
        return response;
    }
}
