import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {
    @Test
    public void testCreateUser(){
        String user = "{\n"+
                "   \"name\": \"morpheus\", \n" +
                "   \"job\": \"leader\", \n" +
                "}";

        given().baseUri("https://reqres.in/").
                basePath("/rest-api").
                contentType(ContentType.JSON).
                body(user).
                log().all().
        when().post("users").
        then().assertThat().
                statusCode(201).
                body("id", Matchers.notNullValue()).
                body("name", Matchers.equalTo("morpheus")).
                body("job", Matchers.equalTo("leader")).
                log().all();
    }
}
