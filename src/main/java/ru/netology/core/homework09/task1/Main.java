package ru.netology.core.homework09.task1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(URL);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        CloseableHttpResponse response = httpClient.execute(request);

        List<CatFact> catFacts = MAPPER.readValue(
                response.getEntity().getContent(),
                new TypeReference<>() {}
        );

        httpClient.close();
        response.close();

        catFacts.stream()
                .filter(value -> value.getUpvotes() > 0)
                .forEach(System.out::println);
    }
}