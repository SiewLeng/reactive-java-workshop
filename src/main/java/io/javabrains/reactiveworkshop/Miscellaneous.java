package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        LocalDateTime dateTime = LocalDateTime.now();
        // ZonedDateTime zdt= dateTime.atZone(ZoneOffset.of("+08:00"));
        ZoneId defaultZone = ZoneId.systemDefault();
        ZonedDateTime zdt= dateTime.atZone(defaultZone);
        System.out.println("\ncurrent date: " + zdt.format(dateTimeFormatter));
    }

    public static void function3() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.systemDefault());
        System.out.println("\ncurrent date: " + dateTime.format(dateTimeFormatter));
        System.out.println("\ncurrent date with dateTimeFormatter: " + dateTime.format(dateTimeFormatter));
    }

    public static void function4() {
        ZoneId defaultZone = ZoneId.systemDefault();
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        OffsetDateTime currentOffsetDateTime = currentLocalDateTime.atZone(defaultZone).toOffsetDateTime();
        System.out.println("current time using offsetDateTime: " + currentOffsetDateTime);
    }

    public static void function5() {
        System.out.println("current time using local date time: " + LocalDateTime.now());
    }

    public static void main(String[] args) throws IOException {
        // function1();
        // function2();
        function4();
        function5();
    }
}
