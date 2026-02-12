import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Task02_GetRequestMultipleFieldAssertion {

    /*
    URL:
    https://jsonplaceholder.typicode.com/posts/60
    Test edin:
- Status code 200 olmalidir
- id 60 olmalidir
- userId 6 olmalidir
- body uzunlugu 20 simvoldan cox olmalidir
- title icinde en az 1 bosluq (" ") olmalidir
    Ipucu: String metodlarindan .length() ve .contains(" ") istifade edin

     */

    @Test
    public void getRequestMultipleFieldAssertion() {

        //1 endpoint ve request body yarat

        String url = "https://jsonplaceholder.typicode.com/posts/60";

        //2 expected data hazirla

        //3 request gonder ve gelen cavabi yadda saxla

        Response response = given().when().get(url);

        response.prettyPrint();


        //4 Assertions

        response

                .then()
                .assertThat()

                .statusCode(200)
                .body("id", equalTo(60),
                "userId", equalTo(6),
                        "body.length()", (greaterThan(20)),
                        "title", containsString(" ")
                );

    }

}
