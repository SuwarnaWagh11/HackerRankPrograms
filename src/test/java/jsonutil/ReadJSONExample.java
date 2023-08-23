package jsonutil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

public class ReadJSONExample {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("C:\\interview\\employees.json");

        Object obj = JsonParser.parseReader(reader);
        //JSONObject jsonObj  = (JSONObject) obj;
        JsonArray emplList = (JsonArray) obj;

        System.out.println(emplList);
        for(JsonElement emp: emplList){
            //System.out.println(emp.getAsJsonObject());
            JsonObject obj1 = emp.getAsJsonObject();
            obj1.get("firstName");
            System.out.println(obj1.get("firstName"));
        }
        //{"aoColumnDefs":[{"aTargets":[0],"aDataSort":[0,1]},{"aTargets":[1],"aDataSort":[1,0]},{"aTargets":[2],"aDataSort":[2,3,4]}]}

        /* {
    "aoColumnDefs": [
     { "aDataSort": [ 0, 1 ], "aTargets": [ 0 ] },
     { "aDataSort": [ 1, 0 ], "aTargets": [ 1 ] },
     { "aDataSort": [ 2, 3, 4 ], "aTargets": [ 2 ] }
   ]
  }*/
        JSONObject jo = new JSONObject();
        Collection<JSONObject> items = new ArrayList<>();

        JSONObject item1 = new JSONObject();
        //item1.put("aDataSort", new JSONArray(0, 1));
        //item1.put("aTargets", new JSONArray(0));
        item1.put("aTargets","1");
        item1.put("aDataSort","2,4");
        items.add(item1);
        JSONObject item2 = new JSONObject();
       // item2.put("aDataSort", new JSONArray(1, 0));
        //item2.put("aTargets", new JSONArray(1));
        items.add(item2);
        JSONObject item3 = new JSONObject();
       // item3.put("aDataSort", new JSONArray(2, 3, 4));
       // item3.put("aTargets", new JSONArray(2));
        items.add(item3);

        jo.put("aoColumnDefs", items);

        System.out.println(jo.toString());
    }
}
