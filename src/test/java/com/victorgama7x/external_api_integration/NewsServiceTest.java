package com.victorgama7x.external_api_integration;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.victorgama7x.external_api_integration.client.NewsClient;
import com.victorgama7x.external_api_integration.dto.NewsResponse;
import com.victorgama7x.external_api_integration.service.NewsService;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {

    @Mock
    private NewsClient client;

    @InjectMocks
    private NewsService service;

    @Test
    void shouldReturnNews() {
        ReflectionTestUtils.setField(service, "apiKey", "test_key");
        NewsResponse mockResponse = new NewsResponse("ok", 1, List.of());

        when(client.fetchNews(anyString())).thenReturn(mockResponse);

        var result = service.searchNews();

        assertNotNull(result);
        assertEquals("ok", result.status());
    }
}