package com.victorgama7x.external_api_integration.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.victorgama7x.external_api_integration.dto.NewsResponse;

@Component
public class NewsClient {

    private final WebClient webClient;

    public NewsClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://newsapi.org/v2")
                .build();
    }

    public NewsResponse fetchNews(String apiKey) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/top-headlines")
                        .queryParam("country", "us")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(NewsResponse.class)
                .block();
    }
}