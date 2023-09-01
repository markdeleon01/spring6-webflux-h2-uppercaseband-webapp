package com.uppercaseband.services;


import com.uppercaseband.domain.Category;
import com.uppercaseband.mappers.ArticleMapper;
import com.uppercaseband.models.ArticleDTO;
import com.uppercaseband.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;


    @Override
    public Flux<ArticleDTO> getAllArticles() {

        log.debug("getAllArticles");

        return articleRepository.findAll()
                .map(articleMapper::articleToArticleDto);
    }

    @Override
    public Flux<ArticleDTO> getArticlesByCategory(String category) {
        log.debug("getArticlesByCategory="+category);

        try {
            Category theCategory = Category.valueOf(category);

            return articleRepository.findByCategory(theCategory)
                    .map(articleMapper::articleToArticleDto);

        } catch (IllegalArgumentException e) {	//for invalid category

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            log.error(sStackTrace);

            return Flux.empty();
        }
    }
}
