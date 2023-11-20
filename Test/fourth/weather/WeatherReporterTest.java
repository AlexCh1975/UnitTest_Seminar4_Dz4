package fourth.weather;


import org.junit.jupiter.api.Test;
import seminars.fourth.weather.WeatherReporter;
import seminars.fourth.weather.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    @Test
    void weatherTest(){
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        when(weatherService.getCurrentTemperature()).thenReturn(22);

        String result = weatherReporter.generateReport();

        assertEquals("Текущая температура: 22 градусов.", result);
    }


}