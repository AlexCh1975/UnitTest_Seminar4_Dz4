package seminars.fourth.http;

import java.util.List;

public class WebService {
    public HttpClient httpClient;

    public WebService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public List<String> sendRequest(String url){
        return httpClient.get(url);
    }
}
