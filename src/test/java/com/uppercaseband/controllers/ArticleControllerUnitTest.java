package com.uppercaseband.controllers;

import com.uppercaseband.domain.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArticleControllerUnitTest {

    @Autowired
    ArticleController articleController;


    @Test
    @Order(1)
    void testGetAllArticles() {
        log.debug("testGetAllArticles");
        assertNotNull(articleController);

        Long count = articleController.getAllArticles().count().block();
        log.debug("testGetAllArticles count: {}", count);
        assertEquals(3, count);
    }

    @Test
    @Order(20)
    void testGetArticlesByCategory() {
        log.debug("testGetArticlesByCategory");

        Long count = articleController.getArticlesByCategory(Optional.ofNullable(Category.HIGHLIGHTS.toString())).count().block();
        log.debug("testGetArticlesByCategory count: {}", count);
        assertEquals(2, count);
    }
}