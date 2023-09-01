package com.uppercaseband.repositories;

import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ArticleRepository extends ReactiveCrudRepository<Article, Integer> {
    // Spring Data R2DBC will provide the implementation, just like in Spring Data JPA

    Flux<Article> findByCategory(Category c);	//find zero or more elements of Article based on Category
}
