package com.example.kursach.controller.payload.mapper;

import com.example.kursach.controller.payload.CreatedPretendent;
import com.example.kursach.controller.payload.CreatedVote;
import com.example.kursach.model.Pretendent;
import com.example.kursach.model.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreatedVoteMapper {

    @Mapping(target = "pretendentId", source = "pretendent.id")
    CreatedVote doPayload(Vote vote);

    List<CreatedVote> doPayload(List<Vote> votes);
}
