package hw23.stepdeffs;

import hw21.Category;
import hw21.Pet;
import hw21.Tag;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetStatusesSteps {
    private HashMap<String, Integer> statuses;
    private final String baseUrl = "https://petstore.swagger.io/v2";

    @Given("^Pet with status (.*)$")
    public void pet_with_status(String status) {
        Category category = Category.builder()
                .id(321L)
                .name("test")
                .build();
        ArrayList<String> urls = new ArrayList<>();
        urls.add("test_url");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(Tag.builder().id(1L).name("test_tag").build());

        Pet pet = Pet.builder()
                .id(123L)
                .name("test_name")
                .status(status)
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
    @When("Send GET to receive map of statuses")
    public void send_get_to_receive_map_of_statuses() {
        statuses = given()
                .baseUri(baseUrl)
                .when()
                .get("store/inventory")
                .then()
                .log()
                .all()
                .extract()
                .as(HashMap.class);
    }
    @Then("^Count of statuses (.*) is (.*)$")
    public void count_of_statuses_is(String status, int count) {
        int actual = statuses.get(status);
        assertEquals(count, actual);
    }
}
