package stepDefinitions;

import ResponseModels.*;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;

import static Api.Jsonplaceholder.*;

public class ApiJsonPlaceholder_steps {
    Integer userNameId;
    UsersResponse[] userResponse;
    PostsResponse[] postsResponses;
    ArrayList<Integer> postIds = new ArrayList<>();

    @Given("that I search for the username {string} to get its id")
    public void that_i_search_for_the_username(String username) {
        userResponse = GetUser(username);
        Assert.assertEquals(username, userResponse[0].username);
        userNameId = userResponse[0].id;
    }

    @When("I use the id fetched to search for the posts written by the user")
    public void i_use_the_id_fetched_to_search_for_the_posts_written_by_the_user() {
        postsResponses = GetUserPostsIds(userNameId);
        ArrayList<Integer> postIds = new ArrayList<>();
        for (PostsResponse eachPost : postsResponses) {
            Assert.assertEquals(userNameId, eachPost.userId);
            postIds.add(eachPost.id);
        }
    }

    @Then("I validate if the emails in the comment section are in the proper format")
    public void i_validate_if_the_emails_in_the_comment_section_are_in_the_proper_format() {
        GetUserPostsCommentsEmails(postIds);
    }
}
