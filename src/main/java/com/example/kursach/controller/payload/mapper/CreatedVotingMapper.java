package com.example.kursach.controller.payload.mapper;

import com.example.kursach.controller.payload.CreatedVoting;
import com.example.kursach.model.Voting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = CreatedPretendantMapper.class, componentModel = "spring")
public interface CreatedVotingMapper {
    @Mapping(target = "userId", source = "user.id")
    CreatedVoting doPayload(Voting voting);

    List<CreatedVoting> doPayload(List<Voting> votings);
}
