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
    Object[] response;
    ArrayList<Integer> postIds = new ArrayList<>();

    @Given("that I search for the username {string}")
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
        GetUserPostsComments(postIds);
    }

    @When("I search for the username {string}")
    public void i_search_for_the_username(String username) {
        userResponse = GetUser(username);
    }

    @When("I search for a inexistent username {string}")
    public void i_search_for_a_inexistent_username(String username) {
        response = (UsersResponse[]) GetUser(username);
    }

    @Then("I receive an empty body response")
    public void i_receive_an_empty_body() {
        Assert.assertEquals(0, response.length);
    }

    @When("I use an inexistent user id to search for the posts")
    public void i_use_an_inexistent_user_id_to_search_for_the_posts() {
        response = (PostsResponse[]) GetUserPostsIds(9999);
    }

    @When("I use an inexistent post id to search for the posts comments")
    public void i_use_an_inexistent_post_id_to_search_for_the_posts_comments() {
        response = (PostComments[]) GetUserPostComment(9999);
    }

}
