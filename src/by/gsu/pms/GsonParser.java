package by.gsu.pms;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


public class GsonParser {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }
}