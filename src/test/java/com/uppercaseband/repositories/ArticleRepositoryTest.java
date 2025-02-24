package com.uppercaseband.repositories;

import com.uppercaseband.config.DatabaseConfig;
import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import com.uppercaseband.domain.Media;
import com.uppercaseband.domain.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataR2dbcTest
@Import(DatabaseConfig.class)
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @BeforeEach
    public void setUp() {
        articleRepository.deleteAll().block();
        articleRepository.save(getTestArticle1())
                .subscribe(article -> System.out.println(article.toString()));
        articleRepository.save(getTestArticle2())
                .subscribe(article -> System.out.println(article.toString()));
        articleRepository.save(getTestArticle3())
                .subscribe(article -> System.out.println(article.toString()));
        articleRepository.count().subscribe(count -> System.out.println("Articles count is: " + count));
    }


    @Test
    void testGetArticles() {

        articleRepository.count().subscribe(count -> {
            System.out.println("testGetArticles count is: " + count);
            assertEquals(3, count);
        });
    }

    @Test
    public void testFindByCategory() {
        //given

        //when
        Long count = articleRepository.findByCategory(Category.HIGHLIGHTS).count().block();
        System.out.println("testFindByCategory category "+Category.HIGHLIGHTS+" count is: " + count);

        //then
        assertEquals(2, count);
    }


    @Test
    public void testFindByInvalidCategory() {
        //given

        //when
        Long count = articleRepository.findByCategory(null).count().block();
        System.out.println("testFindByInvalidCategory category "+Category.HIGHLIGHTS+" count is: " + count);

        //then
        assertEquals(0, count);
    }

    Article getTestArticle1() {
        /**
        Media article1Media = Media.builder()
                .type(MediaType.IMAGE)
                .path("/images/tanging_ikaw.png")
                .build();
        */
        return Article.builder()
                .title("Tanging Ikaw")
                .description("The brand new single from UPPERCASE released under Radio Insect Records")
                .displayOrder(100)
                .category(Category.HIGHLIGHTS)
                .subContent("<a href='https://open.spotify.com/artist/6h4pjpssOa3fBNiQmSkgOB?si=lbGJiYu7R_6ouDMIs7Jv3A'>CHECK IT OUT</a>")
                //.media(article1Media)
                .build();
    }

    Article getTestArticle2() {
        /**
        Media article2Media = Media.builder()
                .type(MediaType.IMAGE)
                .path("/images/tsw_album.png")
                .build();
        */
        return Article.builder()
                .title("'Time Space Warp' Album Launch")
                .description("May 17, 2013 – Hard Rock Café Toronto")
                .displayOrder(200)
                .category(Category.HIGHLIGHTS)
                .subContent("<p><a href='https://www.facebook.com/pg/cyberpinoyradio/photos/?tab=album&album_id=657041557656169'>SEE EVENT PICS</a></p><p><a href='https://youtu.be/yNt0JV8or3k?list=PL0AgfLYM2K_sKTvDMqLY4sDr8Pi1zadB0'>WATCH EVENT VIDEO</a></p>")
                //.media(article2Media)
                .build();
    }

    Article getTestArticle3() {
        /**
        Media article3Media = Media.builder()
                .type(MediaType.VIDEO)
                .path("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/ZfNUPtLtH5w\" frameborder=\"0\" allowfullscreen></iframe>")
                .build();
        */
        return Article.builder()
                .title("'Time Space Warp' Music Video Launch")
                .description("July 12, 2013 – Prestige Bar, North York")
                .displayOrder(300)
                .category(Category.EVENTS)
                //.media(article3Media)
                .build();
    }
}