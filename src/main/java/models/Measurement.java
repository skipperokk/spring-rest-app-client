package models;

import org.springframework.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Measurement {
    private final Random random = new Random();

    public HttpEntity<Map<String, Object>> getRequest(Sensor sensor) {
        Map<String, Object> measurementToSend = new HashMap<>();
        measurementToSend.put("value", -100 + (Math.random() * 200));
        measurementToSend.put("raining", random.nextBoolean());
        measurementToSend.put("sensor", sensor);
        return new HttpEntity<>(measurementToSend);
    }
}
