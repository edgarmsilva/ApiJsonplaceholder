package Api;

import ResponseModels.UsersResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static stepDefinitions.Commons.*;
import static stepDefinitions.Hooks.*;

public class Jsonplaceholder {

    public static int GetUserId(String username) {
        RequestSpecification httpRequest = RestAssured.given().spec(api_jsonplaceholder);
        httpRequest.log().all();
        response = httpRequest.get("/users?username=" + username);
        UsersResponse[] userBody = response.getBody().as(UsersResponse[].class);

        Assert.assertEquals(username, userBody[0].username);

        System.out.println(">>>>>>>>>>>>>>>>>>" +userBody[0].id);
        System.out.println(">>>>>>>>>>>>>>>>>>" +userBody[0].name);
        System.out.println(">>>>>>>>>>>>>>>>>>" +userBody[0].username);

        return userBody[0].id;

    }


}
