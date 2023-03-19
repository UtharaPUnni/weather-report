package perfomatix.java.weatherreportexcel.service;

import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
@Builder
public class WeatherService {

        public void getWeather(String cityName) {

                var body = WebClient.create("https://api.open-meteo.com").get()
                        .uri(uriBuilder -> uriBuilder.path("/v1/forecast")
                                .queryParams(buildQueryParam())
                                .build()).retrieve().bodyToMono(Object.class).block();
                System.out.println("abc");
        }

        public MultiValueMap<String, String> buildQueryParam() {
                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                map.add("latitude", "52.52");
                map.add("longitude", "13.41");
                map.add("hourly", "temperature_2m");
                return map;
        }
        }

