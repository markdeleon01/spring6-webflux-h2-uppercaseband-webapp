package com.uppercaseband.services;

import com.uppercaseband.models.ArticleDTO;
import reactor.core.publisher.Flux;

//the service returns reactive types (mono or flux)
public interface ArticleService {

    Flux<ArticleDTO> getAllArticles();

    Flux<ArticleDTO> getArticlesByCategory(String category);

}
