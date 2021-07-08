package ru.netology.core.homework09.task2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {

    private static final String PATH = "./src/main/java/ru/netology/core/homework09/task2/";

    private static final String URL = "https://api.nasa.gov/planetary/apod?api_key=zU0EDSQcZDWyGSHKjxc7UR8wpXrDzHQeeo5py1zJ";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        CloseableHttpResponse response = getResponse(httpClient, URL);

        Nasa nasa = MAPPER.readValue(
                response.getEntity().getContent(),
                new TypeReference<>() {}
        );

        /**
         * How to get a preview from YouTube
         * http://shpargalkablog.ru/2013/06/youtube.html
         */
        String nasaUrl = (nasa.getUrl().endsWith(".jpg") && nasa.getMediaType().equals("image")) ?
                nasa.getUrl() :
                "https://img.youtube.com/vi/" + nasa.getUrl().split("watch\\?v=")[1] + "/maxresdefault.jpg";

        /**
         * С целью демонстрации работоспособности скачивания превью с ютуб видео, был создан нижеуказанный захардкоженный url
         * (при изменении ссылки на другое ютуб видео будет скачиваться соответствующий новому видео превью).
         * Продемонстрировать работу тернарного оператора, к сожалению, не выйдет, потому что сегодня от NASA получена именно картинка
         */
//        String nasaUrl = "https://img.youtube.com/vi/"
//                + "https://www.youtube.com/watch?v=JMJXvsCLu6s".split("watch\\?v=")[1]
//                + "/maxresdefault.jpg";

        CloseableHttpResponse nasaResponse = getResponse(httpClient, nasaUrl);

        String filePath = PATH + new File(nasaUrl).getName();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        nasaResponse.getEntity().writeTo(bos);

        bos.close();
        httpClient.close();
        response.close();
        nasaResponse.close();
    }

    private static CloseableHttpResponse getResponse(CloseableHttpClient httpClient, String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return httpClient.execute(request);
    }
}