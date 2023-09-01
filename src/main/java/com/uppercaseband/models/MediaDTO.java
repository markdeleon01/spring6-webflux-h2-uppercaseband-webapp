package com.uppercaseband.models;

import com.uppercaseband.domain.MediaType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MediaDTO {

    private MediaType type;

    private String path;
}
