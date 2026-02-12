import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class Task07JsonObjectSchoolSystem {

    /*
    Asagidaki JSON strukturunu Java ile yaradin:
    {
        "school": "Code Academy",
            "students": [
        {
                "id": 1,
                "name": "Aysel",
                "grades": [85, 90, 78]
        },
        {
            "id": 2,
                "name": "Murad",
                "grades": [88, 92, 80]
        }
]
    }
    Konsola cap edin:
- Birinci telebenin adini
- Birinci telebenin ikinci qiymetini (index 1)
- Ikinci telebenin adini
- Ikinci telebenin qiymetlerinin sayini
    Ipucu: grades array-dir, .getJSONArray("grades") ve .length() metodlari istifade edin

     */


    @Test
    public void jsonPathTest()
    {

        JSONObject allInfoJsonObj = new JSONObject();
        allInfoJsonObj.put("school", "Code Academy");


        JSONArray studentsJsonObj = new JSONArray();
        JSONObject firstStudentJsonObj = new JSONObject();
        JSONObject secondStudentJsonObj = new JSONObject();

//first student details
    firstStudentJsonObj.put("id", 1);
    firstStudentJsonObj.put("name", "Aysel");

    //Student's grades = Array, adding grades to object new json object
    JSONArray firstGrades = new JSONArray();
        firstGrades.put(85);
        firstGrades.put(90);
        firstGrades.put(78);
    firstStudentJsonObj.put("grades", firstGrades);

    //2nd student details
        secondStudentJsonObj.put("id", 2);
        secondStudentJsonObj.put("name", "Murad");

        JSONArray secondGrades = new JSONArray();
        secondGrades.put(88);
        secondGrades.put(92);
        secondGrades.put(80);

        secondStudentJsonObj.put("grades", secondGrades);


        //add students objects to array

        studentsJsonObj.put(firstStudentJsonObj);
        studentsJsonObj.put(secondStudentJsonObj);

        //butun melumatlari main Json-a elave edirik

        allInfoJsonObj.put("school", "Code Academy");
        allInfoJsonObj.put("students", studentsJsonObj);


        //consoleda gosteririk - 1ci telebenin adi

        System.out.println("Telebenin adi: "
                + allInfoJsonObj
                .getJSONArray("students")
                .getJSONObject(0)
                .get("name")
        );
        //birinci telebenin ikinci qiymeti

        System.out.println("Telebenin qiymeti: "
                + allInfoJsonObj
                .getJSONArray("students")
                .getJSONObject(0)
                .getJSONArray("grades")
                .get(1)
        );

        //ikinci telebenin adi

        System.out.println("Telebenin adi: "
                + allInfoJsonObj
                .getJSONArray("students")
                .getJSONObject(1)
                .get("name")
        );

        //ikinci telebenin qiymetlerinin sayi

        System.out.println("Telebenin qiymetlerinin sayi: "
                + allInfoJsonObj
                .getJSONArray("students")
                .getJSONObject(1)
                .getJSONArray("grades")
                .length()
        );

}

}
