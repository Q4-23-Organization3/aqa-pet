package hw23.stepdeffs;

import hw21.Category;
import hw21.Pet;
import hw21.Tag;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetStoreSteps {

    private Pet pet;
    private final String baseUrl = "https://petstore.swagger.io/v2";

    @Given("New pet added with id: {long} and name: {string}")
    public void new_pet_added_with_id_id_and_name_old_name(long id, String oldName) {
        Category category = Category.builder()
                .id(321L)
                .name("test")
                .build();
        ArrayList<String> urls = new ArrayList<>();
        urls.add("test_url");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(Tag.builder().id(1L).name("test_tag").build());

        pet = Pet.builder()
                .id(id)
                .name(oldName)
                .status("test_available")
                .category(category)
                .photoUrls(urls)
                .tags(tags)
                .build();

        given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("pet")
                .then()
                .log()
                .all();
    }
    @When("Set pet name to {string} and sent PUT request")
    public void set_pet_name_to_new_name_and_sent_put_request(String newName) {
        pet.setName(newName);
        given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .body(pet)
                .put("pet")
                .then()
                .log()
                .all();
    }
    @Then("When I make GET request by {long} received pet new name equals to {string}")
    public void when_i_make_get_request_by_id_received_pet_new_name_equals_to_new_name(long id, String newName) {
        Pet actual = given()
                .baseUri(baseUrl)
                .when()
                .contentType(ContentType.JSON)
                .get("pet/"+id)
                .then()
                .log()
                .all()
                .extract()
                .as(Pet.class);
        assertEquals(newName, actual.getName());
    }
}
