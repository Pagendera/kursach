package com.example.kursach.controller.payload.mapper;

import com.example.kursach.controller.payload.CreatedPretendent;
import com.example.kursach.model.Pretendent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreatedPretendentsMapper {
    @Mapping(target = "votingId", source = "voting.id")
    CreatedPretendent doPayload(Pretendent pretendent);

    List<CreatedPretendent> doPayload(List<Pretendent> pretendents);
}
