import models.Measurement;
import models.Sensor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestAppClient {
    private static final String LOCALHOST_URL = "http://localhost:8081";
    private static final String REGISTER_SENSOR_URL =  LOCALHOST_URL + "/sensors/registration";
    private static final String ADD_MEASUREMENT_URL = LOCALHOST_URL + "/measurements/add";
    private static final String GET_ALL_MEASUREMENTS_URL = LOCALHOST_URL + "/measurements";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 5; i++) {
            Sensor sensor = new Sensor("Sensor name");
            makePostRequest(REGISTER_SENSOR_URL, sensor.getRequest(), restTemplate);
            Measurement measurement = new Measurement();
            makePostRequest(ADD_MEASUREMENT_URL, measurement.getRequest(sensor), restTemplate);
        }
        ResponseEntity<String> allMeasurementsResponse = restTemplate.getForEntity(GET_ALL_MEASUREMENTS_URL, String.class);
        System.out.println(allMeasurementsResponse);
    }

    private static void makePostRequest(String url, Object request, RestTemplate restTemplate) {
        restTemplate.postForEntity(url, request, String.class);
    }
}
