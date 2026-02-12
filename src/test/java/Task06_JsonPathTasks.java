import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class Task06_JsonPathTasks {

    /*
    Asagidaki JSON strukturunu Java ile yaradin:
{
"person": {
"name": "Elvin",
"age": 28,
"city": "Baku"
},
"cars": [
{
"brand": "BMW",
"year": 2018
},
{
"brand": "Mercedes",
"year": 2020
}
]
}

Konsola cap edin:
- Sexsin adini (person.name)
- Seheri (person.city)
- Birinci mashinin brand-ini (cars[0].brand)
- Ikinci mashinin ilini (cars[1].year)
Ipucu: JSONObject ve JSONArray istifade edin. Nested obyektler ucun
.getJSONObject() metodu lazimdir
     */




    @Test
    public void jsonPathTest()
    {

        JSONObject personalInfoJsonObj = new JSONObject();
        JSONObject personJsonObj = new JSONObject();

        JSONArray carsJsonObj = new JSONArray();
        JSONObject bmwJsonObj = new JSONObject();
        JSONObject mercedesJsonObj = new JSONObject();

        personJsonObj.put("name", "Elvin");
        personJsonObj.put("age", 28);
        personJsonObj.put("city", "Baku");

        bmwJsonObj.put("brand", "BMW");
        bmwJsonObj.put("year", 2018);

        mercedesJsonObj.put("brand", "Mercedes");
        mercedesJsonObj.put("year", 2020);

        carsJsonObj.put(bmwJsonObj);
        carsJsonObj.put(mercedesJsonObj);

        personalInfoJsonObj.put("person", personJsonObj);
        personalInfoJsonObj.put("cars", carsJsonObj);

        System.out.println(personalInfoJsonObj);

        System.out.println("------Personal Info------");

        System.out.println("Name:" + personalInfoJsonObj.getJSONObject("person").get("name"));
        System.out.println("City:" + personalInfoJsonObj.getJSONObject("person").get("city"));

        System.out.println("--------Car details---------");

        System.out.println("Brand:" + personalInfoJsonObj.getJSONArray("cars").getJSONObject(0).get("brand"));
        System.out.println("Year:" + personalInfoJsonObj.getJSONArray("cars").getJSONObject(1).get("year"));
    }
}
