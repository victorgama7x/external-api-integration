package com.victorgama7x.external_api_integration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorgama7x.external_api_integration.dto.NewsResponse;
import com.victorgama7x.external_api_integration.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public NewsResponse getNews() {
        return newsService.searchNews();
    }

}
