package fourth.http;

import org.junit.jupiter.api.Test;
import seminars.fourth.http.HttpClient;
import seminars.fourth.http.WebService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class WebServiceTest {

    /**
     * 4.7 Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
     * Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
     * HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
     * WebService, который использует HttpClient для получения данных с веб-сайта.
     */

    @Test
    void testWebService(){
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn(Arrays.asList("Header", "Body", "200"));

        List<String> result = webService.sendRequest("url");

        verify(httpClient).get("url");
        assertEquals(3, result.size());


    }
}
