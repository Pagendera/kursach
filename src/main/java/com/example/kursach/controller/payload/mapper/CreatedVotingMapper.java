package com.example.kursach.controller.payload.mapper;

import com.example.kursach.controller.payload.CreatedVoting;
import com.example.kursach.model.Voting;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = CreatedPretendentsMapper.class, componentModel = "spring")
public interface CreatedVotingMapper {

    CreatedVoting doPayload(Voting voting);

    List<CreatedVoting> doPayload(List<Voting> votings);
}
