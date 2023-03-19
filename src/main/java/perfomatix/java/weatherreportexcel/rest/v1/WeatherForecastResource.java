package perfomatix.java.weatherreportexcel.rest.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perfomatix.java.weatherreportexcel.dto.ResponseDTO;
import perfomatix.java.weatherreportexcel.service.WeatherService;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class WeatherForecastResource {

    private final WeatherService weatherService;

    @GetMapping (value = "city/weather/worksheet")
    public ResponseEntity<?> cityWeatherToExcel(@RequestParam String cityname){
        weatherService.getWeather(cityname);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.OK, "success", "weather fetched", null));
    }
}
