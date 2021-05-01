package Api;

import ResponseModels.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;

import static stepDefinitions.Commons.*;
import static stepDefinitions.Hooks.*;

public class Jsonplaceholder {

    public static int GetUserId(String username) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
//        httpRequest.log().all();
        response = httpRequest.get("/users?username=" + username);
        UsersResponse[] userBody = response.getBody().as(UsersResponse[].class);
        Assert.assertEquals(username, userBody[0].username);
        return userBody[0].id;
    }

    public static ArrayList GetUserPostsIds(Integer id) {
        ArrayList<Integer> postIds = new ArrayList<Integer>();
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
//        httpRequest.log().all();
        response = httpRequest.get("/posts?userId=" + id);
        PostsResponse[] postsBody = response.getBody().as(PostsResponse[].class);
        for (PostsResponse eachPost : postsBody) {
            Assert.assertEquals(id, eachPost.userId);
            postIds.add(eachPost.id);
        }
        return postIds;
    }

    public static ArrayList<String> GetUserPostsCommentsEmails(ArrayList<Integer> postIds) {
        ArrayList<String> commentEmails = new ArrayList<String>();
        for (Integer postId : postIds) {
//            System.out.println("ID:" + postId);
            RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
//            httpRequest.log().all();
            response = httpRequest.get("/comments?postId=" + postId);
            PostComments[] postsComments = response.getBody().as(PostComments[].class);
            for (PostComments eachComment : postsComments) {
//                System.out.println("Validating Email:"+ eachComment.email);
                Assert.assertEquals(postId, eachComment.postId);
                if (validateEmail(eachComment.email)){
                    commentEmails.add(eachComment.email);
//                    System.out.println("Email OK!");
                }else{
                    System.out.println("The Email: "+ eachComment.email + "From comment ID No."+ eachComment.id +" is not a valid Email.");
                }
            }
        }
        return commentEmails;
    }

}
