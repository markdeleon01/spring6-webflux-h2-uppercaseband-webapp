package com.uppercaseband.mappers;

import com.uppercaseband.domain.Article;
import com.uppercaseband.models.ArticleDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleMapper {

    Article articleDtoToArticle(ArticleDTO articleDto);

    ArticleDTO articleToArticleDto(Article article);
}
