package Api;

import ResponseModels.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;

import static stepDefinitions.Commons.*;
import static stepDefinitions.Hooks.*;

public class Jsonplaceholder {

//    public static int GetUserId(String username) {
//        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
//        response = httpRequest.get("/users?username=" + username);
//        UsersResponse[] userBody = response.getBody().as(UsersResponse[].class);
//        Assert.assertEquals(username, userBody[0].username);
//        return userBody[0].id;
//    }

    public static UsersResponse[] GetUser(String username) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
        response = httpRequest.get("/users?username=" + username);
        return response.getBody().as(UsersResponse[].class);
    }

//    public static ArrayList GetUserPostsIds(Integer id) {
//        ArrayList<Integer> postIds = new ArrayList<Integer>();
//        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
//        response = httpRequest.get("/posts?userId=" + id);
//        PostsResponse[] postsBody = response.getBody().as(PostsResponse[].class);
//        for (PostsResponse eachPost : postsBody) {
//            Assert.assertEquals(id, eachPost.userId);
//            postIds.add(eachPost.id);
//        }
//        return postIds;
//    }

    public static PostsResponse[] GetUserPostsIds(Integer id) {
        ArrayList<Integer> postIds = new ArrayList<>();
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
                if (validateEmail(eachComment.email)){
                    commentEmails.add(eachComment.email);
                }else{
                    System.out.println("The Email: "+ eachComment.email + "From comment ID No."+ eachComment.id +" is not a valid Email.");
                }
            }
        }
        return commentEmails;
    }
}
