package com.victorgama7x.external_api_integration.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.victorgama7x.external_api_integration.client.NewsClient;
import com.victorgama7x.external_api_integration.dto.NewsResponse;

@Service
public class NewsService {

    private final NewsClient client;

    @Value("${api.key}")
    private String apiKey;

    public NewsService(NewsClient client) {
        this.client = client;
    }

    public NewsResponse searchNews() {
        return client.fetchNews(apiKey);
    }
}