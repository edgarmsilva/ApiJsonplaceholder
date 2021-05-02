package Api;

import ResponseModels.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;

import static stepDefinitions.Commons.*;
import static stepDefinitions.Hooks.*;

public class Jsonplaceholder {

    public static UsersResponse[] GetUser(String username) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
        response = httpRequest.get("/users?username=" + username);
        return response.getBody().as(UsersResponse[].class);
    }

    public static PostsResponse[] GetUserPostsIds(Integer id) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
        response = httpRequest.get("/posts?userId=" + id);
        return response.getBody().as(PostsResponse[].class);
    }

    public static ArrayList<String> GetUserPostsCommentsEmails(ArrayList<Integer> postIds) {
        ArrayList<String> commentEmails = new ArrayList<>();
        for (Integer postId : postIds) {
            RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
            response = httpRequest.get("/comments?postId=" + postId);
            PostComments[] postsComments = response.getBody().as(PostComments[].class);
            for (PostComments eachComment : postsComments) {
                Assert.assertEquals(postId, eachComment.postId);
                if (validateEmail(eachComment.email)) {
                    commentEmails.add(eachComment.email);
                } else {
                    System.out.println("The Email: " + eachComment.email + "From comment ID No." + eachComment.id + " is not a valid Email.");
                }
            }
        }
        return commentEmails;
    }

    public static PostComments[] GetUserPostsComments(ArrayList<Integer> postId) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
        response = httpRequest.get("/comments?postId=" + postId);
        httpRequest.log().all();
        PostComments[] postsComments = response.getBody().as(PostComments[].class);
        return response.getBody().as(PostComments[].class);
    }

    public static PostComments[] GetUserPostComment(Integer postId) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
        response = httpRequest.get("/comments?postId=" + postId);
        httpRequest.log().all();
        PostComments[] postsComments = response.getBody().as(PostComments[].class);
        return response.getBody().as(PostComments[].class);
    }
}
