package com.uppercaseband.mappers;

import com.uppercaseband.domain.Media;
import com.uppercaseband.models.MediaDTO;
import org.mapstruct.Mapper;

@Mapper
// this mapper is implemented via MapStruct
public interface MediaMapper {

    MediaDTO mediaToMediaDTO (Media media);

    Media mediaDTOToMedia (MediaDTO mediaDTO);
}
