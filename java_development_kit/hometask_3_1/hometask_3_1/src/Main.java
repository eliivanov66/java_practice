import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {

    public static void main(String[] args) {
        SQLiteHandler db = new SQLiteHandler("./Database/hometask.db");

        db.connect();

        Map<String, String> scheme = new HashMap<>();
        scheme.put("name", "TEXT");
        scheme.put("phone", "INT");

        db.deleteTable("test");
        db.createTable("test", scheme );

        Map<String,Object> tempMap = new HashMap<>();
        tempMap.put("name", "name#1");
        tempMap.put("phone", 123);
        db.writeTable("test", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "name#2");
        tempMap.put("phone", 1234);
        db.writeTable("test", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "name#3");
        tempMap.put("phone", 12345);
        db.writeTable("test", tempMap);


        List<Map<String, Object>> resultFull = db.readTable("test");
        for (Map<String,Object> map : resultFull) {
            db.printTableRow(map);
        }

        Map<String, Object> resultID = db.readTableByID("test", 3);
        db.printTableRow(resultID);

        tempMap = new HashMap<>();
        tempMap.put("name", "name#3updated");
        tempMap.put("phone", 123456);

        db.updateTable("test", tempMap, 3);

        resultID = db.readTableByID("test", 3);
        db.printTableRow(resultID);
        db.disconnect();
    }

}