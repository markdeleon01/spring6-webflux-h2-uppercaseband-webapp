package com.uppercaseband.mappers;

import com.uppercaseband.domain.Article;
import com.uppercaseband.models.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=MediaMapper.class)
// this mapper is implemented via MapStruct
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    Article articleDtoToArticle(ArticleDTO articleDto);

    ArticleDTO articleToArticleDto(Article article);
}
