package models;

import org.springframework.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Sensor {
    private final String name;
    private final Random random = new Random();

    public Sensor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HttpEntity<Map<String, String>> getRequest() {
        Map<String, String> sensorToSend = new HashMap<>();
        sensorToSend.put("name", name + " " + random.nextInt(1000));
        return new HttpEntity<>(sensorToSend);
    }
}
