package com.uppercaseband.mappers;

import com.uppercaseband.domain.Media;
import com.uppercaseband.models.MediaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
// this mapper is implemented via MapStruct
public interface MediaMapper {

    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

    MediaDTO mediaToMediaDTO (Media media);

    Media mediaDTOToMedia (MediaDTO mediaDTO);
}
