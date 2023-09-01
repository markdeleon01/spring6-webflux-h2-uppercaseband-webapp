package com.uppercaseband.repositories;

import com.uppercaseband.domain.Article;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ArticleRepository extends ReactiveCrudRepository<Article, Integer> {
    // Spring Data R2DBC will provide the implementation, just like in Spring Data JPA
}
