import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Task05_DeleteRequest {

    /*
    URL:
    https://jsonplaceholder.typicode.com/posts/8
    Test edin:
- Status code 200 olmalidir
- Response body bosh {} olmalidir
 Ipucu: .delete(url) ve .body(equalTo("{}")) istifade edin

     */

    @Test
    public void DeleteRequestTest(){

        //1 endpoint ve request body yarat

        String url = "https://jsonplaceholder.typicode.com/posts/8";

        //2 expected datani hazirla

        //3  request gonder ve gelen cavabi yadda saxla

        Response response = given().when().delete(url);

        response.prettyPrint();

        response
                .then()
                .assertThat()

                .statusCode(200)
                .body(equalTo("{}"));

    }

}
