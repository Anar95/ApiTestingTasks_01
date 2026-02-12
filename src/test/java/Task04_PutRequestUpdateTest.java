import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Task04_PutRequestUpdateTest {

   /*
    URL:

    https://jsonplaceholder.typicode.com/posts/10
    Request Body:
    {
            "id": 10,
            "title": "Updated Post",
            "body": "Post was updated",
            "userId": 4
    }
    Test edin:
 - Status code 200 olmalidir
- title "Updated Post" olmalidir
- body icinde "updated" sozu kecmelidir
- userId 4 olmalidir
    Ipucu: .put(url) metodu istifade edin ve containsStringIgnoringCase() faydali ola biler
    */


    @Test
    public void putRequestUpdateTest(){

        //1 endpoint ve request body yarat

        String url = "https://jsonplaceholder.typicode.com/posts/10";

        JSONObject requestBody = new JSONObject();

        requestBody.put("id", 10);
        requestBody.put("title", "Updated Post");
        requestBody.put("body", "Post was updated");
        requestBody.put( "userId", 4);

        //2 expected data hazirla

        //3 request gonder ve gelen cavabi save et

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .put(url);


        //4 Assertions

        response
                .then()
                .assertThat()

                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", equalTo("Updated Post"),
                        "body", containsStringIgnoringCase("updated"),
                        "userId", equalTo(4));

        response.prettyPrint();
    }
}
