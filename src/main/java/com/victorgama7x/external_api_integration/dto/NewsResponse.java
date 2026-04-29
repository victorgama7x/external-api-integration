package com.victorgama7x.external_api_integration.dto;

import java.util.List;

public record NewsResponse(String status,
                int totalResults,
                List<ArticleDTO> articles) {

}
