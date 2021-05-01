package stepDefinitions;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Hooks {
    public static RequestSpecification api_jsonplaceholder;

    @Before
    public void setup() {
        api_jsonplaceholder = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}
