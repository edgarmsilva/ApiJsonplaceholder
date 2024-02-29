package stepDefinitions;

import io.restassured.response.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commons {

    public static Response response;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
