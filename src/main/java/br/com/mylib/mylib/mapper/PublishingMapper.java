package br.com.mylib.mylib.mapper;

import br.com.mylib.mylib.dto.PublishingCreateDto;
import br.com.mylib.mylib.dto.PublishingDto;
import br.com.mylib.mylib.model.Publishing;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublishingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public PublishingDto toPublshingDto(Publishing publishing) {
        return MODEL_MAPPER.map(publishing, PublishingDto.class);
    }

    public List<PublishingDto> toPublishingDtoList(List<Publishing> publishingList) {
        return publishingList.stream().map(this::toPublshingDto).collect(Collectors.toList());
    }

    public Publishing toPublishingCreate(PublishingCreateDto publishingCreateDto) {
        return MODEL_MAPPER.map(publishingCreateDto, Publishing.class);
    }
}
