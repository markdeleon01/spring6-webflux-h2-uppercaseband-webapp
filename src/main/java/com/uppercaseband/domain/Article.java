package com.uppercaseband.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    private Integer id;

    private String title;

    private String description;

    private Integer sortOrder;

    private Media media;

    private String subContent;

    private Category category;
}
