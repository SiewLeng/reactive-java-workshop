package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
// import java.util.HashMap;
import java.util.Map;

// import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Miscellaneous {

    public static void function1()throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("phoneType", "N95");
        map.put("colour", "Black");
        JSONObject jsonObject = new JSONObject(map);
        String objectString = jsonObject.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(objectString,  new TypeReference<Map<String,
        String>>() {}).entrySet().forEach(item -> {
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        });
    }

    public static void function2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("current date: " + LocalDateTime.now().format(dateTimeFormatter));
    }
    

    public static void main(String[] args) throws IOException {
        function1();
        function2();
    }
}
