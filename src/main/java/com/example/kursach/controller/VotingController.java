package com.example.kursach.controller;

import com.example.kursach.controller.payload.mapper.CreatedPretendentsMapper;
import com.example.kursach.controller.payload.mapper.CreatedVotingMapper;
import com.example.kursach.model.Voting;
import com.example.kursach.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/votings")
@RequiredArgsConstructor
public class VotingController {

    private final VotingService votingService;
    private final CreatedVotingMapper createdVotingMapper;
    private final CreatedPretendentsMapper createdPretendentsMapper;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("votings",createdVotingMapper.doPayload(votingService.findAll()));
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        Voting voting = votingService.findById(id);
        model.addAttribute("voting",createdVotingMapper.doPayload(voting));
        model.addAttribute("pretendents", createdPretendentsMapper.doPayload(voting.getPretendents()));
        return "voting";
    }

}
