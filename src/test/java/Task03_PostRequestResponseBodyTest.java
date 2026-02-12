import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Task03_PostRequestResponseBodyTest {

    /*
    URL:
    https://jsonplaceholder.typicode.com/posts
    Request Body:

    {
        "title": "Automation Test",
            "body": "API testing with Rest Assured",
            "userId": 9
    }
    Test edin:
- Status code 201 olmalidir
- Content-Type application/json olmalidir
- Response body-de title "Automation Test" olmalidir
- Response body-de userId 9 olmalidir
- body fieldi icinde "Rest" sozu kecmelidir
    Ipucu: .body(requestBody).post(url) ve .body("body", containsString("Rest")) istifade
            edin

     */

    @Test
    public void Task03_GetRequestMultipleFieldAssertion() {

        //1 endpoint ve request body yaradiriq

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Automation Test");
        requestBody.put("body", "API testing with Rest Assured");
        requestBody.put("userId", 9);

        System.out.println(requestBody);

        //2 expected data hazirla

        //3 request gonder ve gelen cavabi yadda saxla

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when().
                put(url);

        response.prettyPrint();

        //Assertions

        response
                .then()
                .assertThat()

                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", equalTo("Automation Test"),
                        "userId", equalTo(9),
                        "body", containsString("Rest")

                );


    }
}
