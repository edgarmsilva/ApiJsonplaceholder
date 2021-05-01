package stepDefinitions;

import Api.Jsonplaceholder;
import io.cucumber.java.en.*;

import static Api.Jsonplaceholder.*;

public class ApiJsonPlaceholder_steps {
    int userId;

    @Given("that I search for the username {string} to get its id")
    public void that_i_search_for_the_username(String username) {

        userId = GetUserId(username);
    }

    @When("I use the id fetched to search for the posts written by the user")
    public void i_use_the_id_fetched_to_search_for_the_posts_written_by_the_user() {
        
    }

    @Then("I validate if the emails in the comment section are in the proper format")
    public void i_validate_if_the_emails_in_the_comment_section_are_in_the_proper_format() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
