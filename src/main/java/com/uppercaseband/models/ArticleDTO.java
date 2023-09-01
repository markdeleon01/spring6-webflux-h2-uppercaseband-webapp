package com.uppercaseband.models;

import com.uppercaseband.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDTO {

    private String title;

    private String description;

    private Integer displayOrder;

    private MediaDTO media;

    private String subContent;

    private Category category;
}
