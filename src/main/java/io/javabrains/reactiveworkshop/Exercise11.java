package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


public class Exercise11 {

        public static void main(String[] args) throws IOException {
        /*   
        try {
            JSONObject jsonObject = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
            jsonObject.toMap().entrySet().forEach((item)-> {
                System.out.println(item.getKey());
                System.out.println(item.getValue());
            });
        } catch (JSONException err){
            System.out.println("Error" + err.toString());
        }
        */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue("{\"phonetype\":\"N95\",\"cat\":\"WP\"}",  new TypeReference<Map<String,
        String>>() {}).entrySet().forEach(item -> {
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        });
    }
}
