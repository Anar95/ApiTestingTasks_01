import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Task01_GetRequestBodyAssertion {
    /*
    URL:
    https://jsonplaceholder.typicode.com/posts/25
    Test edin:
- Status code 200 olmalidir
- Content-Type application/json olmalidir
- Response body-de id 25 olmalidir
- Response body-de userId 3 olmalidir
- title fieldi bosh olmamalidir
    Ipucu: .body("id", equalTo(25)) ve .body("title", not(emptyString())) istifade edin

     */

    @Test
    public void getRequestBodyAssertion() {

        //1 endpoint ve requestbody yaratmaq

        String url = "https://jsonplaceholder.typicode.com/posts/25";

        //2 expected data varsa hazirlayiriq
        //3 request gonderirik ve donen cavabi yadda saxlayiriq

        Response response = given().when().get(url);

        response.prettyPrint();

        //4 Assertions

        response

                .then()
                .assertThat()

                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(25),
                        "userId", equalTo(3),
                        "title", not(emptyString())
                        );

    }
}

