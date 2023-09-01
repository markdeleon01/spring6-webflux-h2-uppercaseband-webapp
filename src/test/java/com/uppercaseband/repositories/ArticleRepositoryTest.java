package com.uppercaseband.repositories;

import com.uppercaseband.config.DatabaseConfig;
import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
@Import(DatabaseConfig.class)
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void getArticles() {
        articleRepository.save(getTestArticle())
                .subscribe(article -> {
                    System.out.println(article.toString());
                });

        articleRepository.count().subscribe(count -> {
            System.out.println("Article count is: " + count);
            assertEquals(count, 1);
        });
    }

    Article getTestArticle() {
        return Article.builder()
                .title("Tanging Ikaw")
                .description("The brand new single from UPPERCASE released under Radio Insect Records")
                .sortOrder(100)
                .category(Category.HIGHLIGHTS)
                .subContent("<a href='https://open.spotify.com/artist/6h4pjpssOa3fBNiQmSkgOB?si=lbGJiYu7R_6ouDMIs7Jv3A'>CHECK IT OUT</a>")
                //.media(article1Media)
                .build();
    }
}