package hw21;

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
    public void addPetsTestSuccess() {
        postPetRequest(prepareTestPet()).statusCode(200);
    }

    @Test
    public void addPetsTestFailed() {
        given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .post("pet")
                .then()
                .statusCode(405);
    }

    @Test
    public void updatePetTest() {
        Pet pet = prepareTestPet();
        postPetRequest(pet);

        pet.setName("new_test_name");

        putPetRequest(pet).statusCode(200);

        Pet actual = getPetRequest(pet.getId()).extract().as(Pet.class);
        assertEquals("new_test_name", actual.getName());
    }

    @Test
    public void updatePetsFailed() {
        Pet pet = prepareTestPet();
        long id = -10000;
        pet.setId(id);
        putPetRequest(pet).statusCode(200); // ?? added new pet with random id but must be 405 status
        getPetRequest(id).statusCode(404);
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

        getPetRequest(id).statusCode(404);
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
    }

    @Test
    public void getOrderFailed() {
        given()
                .baseUri(baseUrl)
                .when()
                .get("store/order/100")
                .then()
                .log()
                .all()
                .statusCode(404);
    }
    @Test
    public void getOrderSuccess() {
        Order order = prepareTestOrder();
        postOrderRequest(order);
        getOrderRequest(order.getId()).statusCode(200);
    }
    @Test
    public void deleteOrderFailed() {
        given()
                .baseUri(baseUrl)
                .when()
                .delete("store/order/-100")
                .then()
                .log()
                .all()
                .statusCode(404);
    }
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

    private ValidatableResponse getOrderRequest(long orderId) {
        return given()
                .baseUri(baseUrl)
                .when()
                .get("store/order/"+orderId)
                .then()
                .log()
                .all();
    }
}
