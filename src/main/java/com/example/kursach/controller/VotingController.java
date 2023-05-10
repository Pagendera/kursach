package com.example.kursach.controller;

import com.example.kursach.controller.payload.mapper.CreatedPretendantMapper;
import com.example.kursach.controller.payload.mapper.CreatedVotingMapper;
import com.example.kursach.model.Voting;
import com.example.kursach.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/votings")
@RequiredArgsConstructor
public class VotingController {

    private final VotingService votingService;
    private final CreatedVotingMapper createdVotingMapper;
    private final CreatedPretendantMapper createdPretendantMapper;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("votings",createdVotingMapper.doPayload(votingService.findAll()));
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        Voting voting = votingService.findById(id);
        model.addAttribute("voting",createdVotingMapper.doPayload(voting));
        model.addAttribute("pretendants", createdPretendantMapper.doPayload(voting.getPretendants()));
        return "voting";
    }

    @PostMapping
    public String save(@RequestParam String name,
                       @RequestParam String description){
        Voting voting = new Voting();
        voting.setName(name);
        voting.setDescription(description);

        votingService.save(voting);
        return "redirect:/votings";
    }

    @PostMapping ("/update/{id}")
    public String deleteById(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String description){
        Voting voting = new Voting();
        voting.setName(name);
        voting.setDescription(description);
        voting.setId(id);
        voting.setPretendants(votingService.findById(id).getPretendants());
        votingService.save(voting);

        return "redirect:/votings";
    }

    @PostMapping ("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        votingService.deleteById(id);
        return "redirect:/votings";
    }
}
