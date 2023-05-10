package com.example.kursach.controller.payload.mapper;

import com.example.kursach.controller.payload.CreatedPretendant;
import com.example.kursach.model.Pretendant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreatedPretendantMapper {
    @Mapping(target = "votingId", source = "voting.id")
    CreatedPretendant doPayload(Pretendant pretendant);

    List<CreatedPretendant> doPayload(List<Pretendant> pretendants);
}
